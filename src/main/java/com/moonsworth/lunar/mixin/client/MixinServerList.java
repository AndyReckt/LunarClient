package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.ServerDataBridge;
import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.ServerListBridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.server.FeaturedServer;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.util.*;

@Mixin(ServerList.class)
public abstract class MixinServerList implements ServerListBridge {
    public Set<ServerData> pinnedServer;
    public final Map<Integer, ServerData> hiddenServers = new HashMap<>();
    @Final
    @Shadow
    private List<ServerData> servers;
    @Final
    @Shadow
    private static Logger logger;

    @Shadow
    public abstract ServerData getServerData(int var1);

    @Inject(method = "swapServers", at = @At("HEAD"), cancellable = true)
    public void impl$swapServers(int var1, int var2, CallbackInfo var3) {
        if (!this.bridge$canSwapServers(var1, var2)) {
            var3.cancel();
        }
    }

    @Overwrite
    public void loadServerList() {
        try {
            this.servers.clear();
            this.hiddenServers.clear();
            final NBTTagCompound read = CompressedStreamTools.read(new File(Ref.getMinecraft().bridge$getMcDataDir(), "servers.dat"));
            if (read == null) {
                return;
            }
            final HashSet<String> set = new HashSet<>();
            for (final FeaturedServer featuredServer : LunarClient.getInstance().llllIlIllllIlIlIIIllIlIlI().llIlllIIIllllIIlllIllIIIl()) {
                if (featuredServer.getPing() != -1L && System.currentTimeMillis() > featuredServer.getPing()) {
                    continue;
                }
                set.add((featuredServer.getIp().contains(".") && featuredServer.getIp().split("\\.").length == 3) ? featuredServer.getIp().split("\\.")[1] : featuredServer.getIp());
                final ServerData serverData = new ServerData(featuredServer.getName(), featuredServer.getIp(), false);
                this.pinnedServer.add(serverData);
                this.servers.add(serverData);
            }
            final NBTTagList tagList = read.getTagList("servers", 10);
            for (int i = 0; i < tagList.tagCount(); ++i) {
                final ServerData serverDataFromNBTCompound = ServerData.getServerDataFromNBTCompound(tagList.getCompoundTagAt(i));
                if (set.contains((serverDataFromNBTCompound.serverIP.contains(".") && serverDataFromNBTCompound.serverIP.split("\\.").length == 3) ? serverDataFromNBTCompound.serverIP.split("\\.")[1] : serverDataFromNBTCompound.serverIP)) {
                    this.hiddenServers.put(i, serverDataFromNBTCompound);
                } else {
                    this.servers.add(serverDataFromNBTCompound);
                }
            }
        } catch (Exception ex) {
            logger.error("Couldn't load server list", ex);
        }
    }

    @Overwrite
    public void saveServerList() {
        try {
            NBTTagList var1 = new NBTTagList();
            int var2 = 0;

            for(int var3 = 0; var3 < this.servers.size() + this.hiddenServers.values().size(); ++var3) {
                ServerData var4;
                if (this.hiddenServers.containsKey(var3)) {
                    var4 = this.hiddenServers.get(var3);
                    ++var2;
                } else {
                    var4 = this.servers.get(var3 - var2);
                }
                if (var4 != null && !this.pinnedServer.contains(var4)) {
                    var1.appendTag(var4.getNBTCompound());
                }
            }

            NBTTagCompound var6 = new NBTTagCompound();
            var6.setTag("servers", var1);
            CompressedStreamTools.safeWrite(var6, new File(Ref.getMinecraft().bridge$getMcDataDir(), "servers.dat"));
        } catch (Exception var5) {
            logger.error("Couldn't save server list", var5);
        }
    }

    public boolean bridge$canSwapServers(int var1, int var2) {
        final ServerData serverData = this.getServerData(var1);
        final ServerData serverData2 = this.getServerData(var2);
        return !this.pinnedServer.contains(serverData) && !this.pinnedServer.contains(serverData2);
    }

    public boolean bridge$isPinned(ServerDataBridge var1) {
        return this.pinnedServer.contains((ServerData) var1);
    }
}