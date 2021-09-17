package com.moonsworth.lunar.client.websocket;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiNewChatBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatComponentTextBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.world.PreRunTickEvent;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.ColorUtil;
import com.moonsworth.lunar.client.websocket.assets.AbstractWebSocketPacket;
import io.netty.buffer.Unpooled;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.security.PublicKey;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Decencies
 * @since 10/07/2021 23:00
 */
public class AssetsWebSocket
        extends WebSocketClient
        implements llIlllIIIllllIIlllIllIIIl,
        EventHandler {
    public static final int IlllIIIIIIlllIlIIlllIlIIl = 15;
    public static final int lIllIlIIIlIIIIIIIlllIlIll = 1;
    public static llllIIlIIlIIlIIllIIlIIllI llIlllIIIllllIIlllIllIIIl;
    public static String lIlIlIlIlIIlIIlIIllIIIIIl;
    public String llllIIlIIlIIlIIllIIlIIllI = null;
    public final Cache IlIlIlllllIlIIlIlIlllIlIl = CacheBuilder.newBuilder().expireAfterWrite(3L, TimeUnit.MINUTES).build();
    public final LunarClient llIIIIIIIllIIllIlIllIIIIl;
    public final MinecraftBridge lIIIllIllIIllIlllIlIIlllI;
    public WebSocketState IlllllIlIIIlIIlIIllIIlIll = WebSocketState.DISCONNECTED;
    public long llIIlIlIIIllIlIlIlIIlIIll;
    public boolean llIIIlllIIlllIllllIlIllIl;
    public boolean lllllIllIllIllllIlIllllII;
    public boolean lllIIIIIlllIIlIllIIlIIIlI = false;

    public AssetsWebSocket(Map map) {
        super(new URI("wss://assetserver.lunarclientprod.com/connect"), new Draft_6455(), map, 30000);
        LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Assets", (Object)"Instantiate", new Object[0]);
        this.llIIIIIIIllIIllIlIllIIIIl = Ref.IlllIIIIIIlllIlIIlllIlIIl();
        this.lIIIllIllIIllIlllIlIIlllI = Ref.lIlIlIlIlIIlIIlIIllIIIIIl();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerPlayClientInitEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void onOpen(ServerHandshake serverHandshake) {
        llIlllIIIllllIIlllIllIIIl = null;
        this.IlllllIlIIIlIIlIIllIIlIll = WebSocketState.AWAITING_ENCRYPTION_REQUEST;
        LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Assets", (Object)"Connection established as %s", this.llIIIIIIIllIIllIlIllIIIIl.llllIIlIIlIIlIIllIIlIIllI().llIlllIIIllllIIlllIllIIIl());
        this.llIIIIIIIllIIllIlIllIIIIl.IlIIIlIlIlIlIlIllIIllIIlI().lIlIlIlIlIIlIIlIIllIIIIIl();
        this.llIIlIlIIIllIlIlIlIIlIIll = System.currentTimeMillis();
    }

    public void onClose(int n, String string, boolean bl) {
        if (this.IlllllIlIIIlIIlIIllIIlIll == null) {
            int n2;
            boolean bl2;
            block7: {
                bl2 = true;
                n2 = 15;
                if (n == 1000) {
                    try {
                        JsonObject jsonObject = LunarClient.llIIlIlIIIllIlIlIlIIlIIll.fromJson(string, JsonObject.class);
                        if (jsonObject.isJsonObject()) {
                            if (jsonObject.has("exponentialBackoff") && !jsonObject.get("exponentialBackoff").isJsonNull()) {
                                bl2 = jsonObject.getAsBoolean();
                            }
                            if (jsonObject.has("time") && !jsonObject.get("time").isJsonNull()) {
                                n2 = jsonObject.get("time").getAsInt();
                            }
                        }
                    }
                    catch (JsonSyntaxException jsonSyntaxException) {
                        if (!string.equalsIgnoreCase("Server rebooting")) break block7;
                        n2 = 5;
                        bl2 = false;
                    }
                }
            }
            llIlllIIIllllIIlllIllIIIl = new llllIIlIIlIIlIIllIIlIIllI(n2, bl2);
        }
        this.IlllllIlIIIlIIlIIllIIlIll = WebSocketState.DISCONNECTED;
        LunarLogger.lIlIlIlIlIIlIIlIIllIIIIIl("Assets", (Object)"Connection closed (%d, \"%s\")", n, string);
        this.llIIIlllIIlllIllllIlIllIl = false;
        this.lllllIllIllIllllIlIllllII = false;
        this.llIIIIIIIllIIllIlIllIIIIl.IlIIIlIlIlIlIlIllIIllIIlI().IlllIIIIIIlllIlIIlllIlIIl();
        this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().llllIIlIIlIIlIIllIIlIIllI();
    }

    public void onMessage(ByteBuffer byteBuffer) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.llIlllIIIllllIIlllIllIIIl().initPacketBuffer(Unpooled.wrappedBuffer((byte[])byteBuffer.array())));
    }

    public void onError(Exception exception) {
        LunarLogger.llIlllIIIllllIIlllIllIIIl("Assets", (Object)("WS-Error:" + exception.getMessage()), new Object[0]);
        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl(lunar.av.lIlIlIlIlIIlIIlIIllIIIIIl.ASSET_SERVER)) {
            exception.printStackTrace();
        }
    }

    public void onMessage(String string) {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractWebSocketPacket abstractWebSocketPacket) {
        if (!this.isOpen()) {
            return;
        }
        PacketBufferBridge packetBufferBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initPacketBuffer(Unpooled.buffer());
        packetBufferBridge.bridge$writeVarIntToBuffer((Integer)AbstractWebSocketPacket.REGISTRY.get(abstractWebSocketPacket.getClass()));
        try {
            abstractWebSocketPacket.IlllIIIIIIlllIlIIlllIlIIl(packetBufferBridge);
            byte[] byArray = new byte[packetBufferBridge.bridge$readableBytes()];
            packetBufferBridge.bridge$readBytes(byArray);
            packetBufferBridge.bridge$release();
            this.send(byArray);
            if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl(lunar.av.lIlIlIlIlIIlIIlIIllIIIIIl.ASSET_SERVER)) {
                LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Assets", (Object)"Sent: %s", abstractWebSocketPacket.getClass().getSimpleName());
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(PacketBufferBridge packetBufferBridge) {
        int n = packetBufferBridge.bridge$readVarIntFromBuffer();
        Class clazz = (Class)AbstractWebSocketPacket.REGISTRY.inverse().get(n);
        try {
            AbstractWebSocketPacket abstractWebSocketPacket;
            AbstractWebSocketPacket abstractWebSocketPacket2 = abstractWebSocketPacket = clazz == null ? null : (AbstractWebSocketPacket)clazz.newInstance();
            if (abstractWebSocketPacket == null) {
                return;
            }
            if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl(lunar.av.lIlIlIlIlIIlIIlIIllIIIIIl.ASSET_SERVER)) {
                LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Assets", (Object)"Received: %s", clazz.getSimpleName());
            }
            abstractWebSocketPacket.lIlIlIlIlIIlIIlIIllIIIIIl(packetBufferBridge);
            abstractWebSocketPacket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
        }
        catch (Exception exception) {
            LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Assets", (Object)("Error from: " + clazz), new Object[0]);
            exception.printStackTrace();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent serverDisconnectEvent) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("");
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerPlayClientInitEvent netHandlerPlayClientInitEvent) {
        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentServerData() == null) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl("singleplayer");
        } else if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$isConnectedToRealms()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl("Minecraft Realms");
        } else {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentServerData().bridge$serverIP());
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        if (string.equalsIgnoreCase(this.llllIIlIIlIIlIIllIIlIIllI)) {
            return;
        }
        String string2 = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        Pattern pattern = Pattern.compile(string2);
        Matcher matcher = pattern.matcher(string);
        this.llllIIlIIlIIlIIllIIlIIllI = string;
        if (!matcher.find()) {
            this.llIIIIIIIllIIllIlIllIIIIl.llllIIlIIlIIlIIllIIlIIllI().lIllIlIIIlIIIIIIIlllIlIll(string);
            this.lIlIlIlIlIIlIIlIIllIIIIIl((AbstractWebSocketPacket)new WSPacketServerUpdate("", string));
        } else {
            this.llIIIIIIIllIIllIlIllIIIIl.llllIIlIIlIIlIIllIIlIIllI().lIllIlIIIlIIIIIIIlllIlIll("_numeric_");
            this.lIlIlIlIlIIlIIlIIllIIIIIl((AbstractWebSocketPacket)new WSPacketServerUpdate("", "_numeric_"));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketMessage wSPacketMessage) {
        UUID uUID = UUID.fromString(wSPacketMessage.lIlIlIlIlIIlIIlIIllIIIIIl());
        String string = wSPacketMessage.IlllIIIIIIlllIlIIlllIlIIl();
        this.llIIIIIIIllIIllIlIllIIIIl.lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(uUID, string);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketServerUpdate wSPacketServerUpdate) {
        UUID uUID = UUID.fromString(wSPacketServerUpdate.IlllIIIIIIlllIlIIlllIlIIl());
        String string = wSPacketServerUpdate.lIlIlIlIlIIlIIlIIllIIIIIl();
        Profile profile = this.llIIIIIIIllIIllIlIllIIIIl.lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(uUID);
        if (profile != null) {
            profile.lIllIlIIIlIIIIIIIlllIlIll(string);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketConsole wSPacketConsole) {
        LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Assets", (Object)"[Console] %s", wSPacketConsole.lIlIlIlIlIIlIIlIIllIIIIIl());
        this.llIIIIIIIllIIllIlIllIIIIl.IllIllIIIllIIIlIlIlIIIIll().lIlIlIlIlIIlIIlIIllIIIIIl(wSPacketConsole.lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketClientFriendRequestUpdate wSPacketClientFriendRequestUpdate) {
        if (!wSPacketClientFriendRequestUpdate.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            this.llIIIIIIIllIIllIlIllIIIIl.IllIIIlllIIIlIlllIlIIlIII().lIlIlIlIlIIlIIlIIllIIIIIl(UUID.fromString(wSPacketClientFriendRequestUpdate.IlllIIIIIIlllIlIIlllIlIIl()));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketFriendUpdate wSPacketFriendUpdate) {
        UUID uUID = UUID.fromString(wSPacketFriendUpdate.lIlIlIlIlIIlIIlIIllIIIIIl());
        String string = wSPacketFriendUpdate.IlllIIIIIIlllIlIIlllIlIIl();
        boolean bl = wSPacketFriendUpdate.llIlllIIIllllIIlllIllIIIl();
        Profile profile = this.llIIIIIIIllIIllIlIllIIIIl.lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(uUID);
        if (profile == null) {
            profile = new Profile(uUID);
        }
        if (wSPacketFriendUpdate.lIllIlIIIlIIIIIIIlllIlIll() < 10L) {
            int n = (int)wSPacketFriendUpdate.lIllIlIIIlIIIIIIIlllIlIll();
            Status status = Status.lIlIlIlIlIIlIIlIIllIIIIIl;
            for (Status status2 : Status.values()) {
                if (status2.ordinal() != n) continue;
                status = status2;
            }
            if (this.IlIlIlllllIlIIlIlIlllIlIl.getIfPresent(profile.lIllIlIIIlIIIIIIIlllIlIll()) == null && ((Boolean)this.llIIIIIIIllIIllIlIllIIIIl.lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lllllIllIlIIlIIlIIIlllIlI().llIlllIIIllllIIlllIllIIIl()).booleanValue() && status == Status.lIlIlIlIlIIlIIlIIllIIIIIl && profile.llIllIlIllIlllIllIIIIllII() != Status.lIlIlIlIlIIlIIlIIllIIIIIl && System.currentTimeMillis() - this.llIIlIlIIIllIlIlIlIIlIIll > TimeUnit.SECONDS.toMillis(1L)) {
                this.llIIIIIIIllIIllIlIllIIIIl.IIIlIIIIIIllIIIIllIIIIlII().lIllIlIIIlIIIIIIIlllIlIll(profile.llIlllIIIllllIIlllIllIIIl(), EnumChatColor.llIIIlllIIlllIllllIlIllIl.toString() + (Object)((Object)EnumChatColor.lIIlIlllIlIlIIIlllIIlIIII) + profile.llIlllIIIllllIIlllIllIIIl() + (Object)((Object)EnumChatColor.IllIllIIIllIIIlIlIlIIIIll) + " is now online");
            }
            profile.IlllIIIIIIlllIlIIlllIlIIl(status);
        }
        this.IlIlIlllllIlIIlIlIlllIlIl.put(profile.lIllIlIIIlIIIIIIIlllIlIll(), false);
        profile.lIlIlIlIlIIlIIlIIllIIIIIl(bl);
        profile.lIlIlIlIlIIlIIlIIllIIIIIl(string);
        MinecraftVersion minecraftVersion2 = Arrays.stream(MinecraftVersion.values()).filter(minecraftVersion -> minecraftVersion.name().equals(wSPacketFriendUpdate.llllIIlIIlIIlIIllIIlIIllI())).findFirst().orElse(null);
        profile.lIlIlIlIlIIlIIlIIllIIIIIl(minecraftVersion2);
        if (!bl) {
            profile.IlllIIIIIIlllIlIIlllIlIIl(Status.llIlllIIIllllIIlllIllIIIl);
            profile.lIlIlIlIlIIlIIlIIllIIIIIl(wSPacketFriendUpdate.lIllIlIIIlIIIIIIIlllIlIll());
        }
        if (!this.llIIIIIIIllIIllIlIllIIIIl.lllllIllIlIIlIIlIIIlllIlI().IlllIIIIIIlllIlIIlllIlIIl(uUID)) {
            this.llIIIIIIIllIIllIlIllIIIIl.lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(profile);
        }
        this.llIIIIIIIllIIllIlIllIIIIl.lllllIllIlIIlIIlIIIlllIlI().IlIlIlllllIlIIlIlIlllIlIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AssetsPacketBulkFriends assetsPacketBulkFriends) {
        this.llIIIIIIIllIIllIlIllIIIIl.IllIIIlllIIIlIlllIlIIlIII().llllIIlIIlIIlIIllIIlIIllI();
        JsonArray jsonArray = assetsPacketBulkFriends.lIlIlIlIlIIlIIlIIllIIIIIl();
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            UUID uUID = UUID.fromString(jsonObject.get("uuid").getAsString());
            String string = jsonObject.get("name").getAsString();
            this.llIIIIIIIllIIllIlIllIIIIl.IllIIIlllIIIlIlllIlIIlIII().IlllIIIIIIlllIlIIlllIlIIl(uUID, string);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketChat wSPacketChat) {
        MinecraftBridge minecraftBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl();
        if (minecraftBridge.bridge$getGuiIngame() != null && minecraftBridge.bridge$getGuiIngame().bridge$getChatGUI() != null) {
            GuiNewChatBridge guiNewChatBridge = minecraftBridge.bridge$getGuiIngame().bridge$getChatGUI();
            guiNewChatBridge.bridge$printChatMessage(Bridge.llIlllIIIllllIIlllIllIIIl().initChatText(wSPacketChat.lIlIlIlIlIIlIIlIIllIIIIIl()));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketFormattedConsoleOutput wSPacketFormattedConsoleOutput) {
        String string = wSPacketFormattedConsoleOutput.lIlIlIlIlIIlIIlIIllIIIIIl();
        String string2 = wSPacketFormattedConsoleOutput.IlllIIIIIIlllIlIIlllIlIIl();
        LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Assets", (Object)EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl("[" + string + "] " + string2), new Object[0]);
        this.llIIIIIIIllIIllIlIllIIIIl.IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(string, string2);
        this.llIIIIIIIllIIllIlIllIIIIl.IllIllIIIllIIIlIlIlIIIIll().lIlIlIlIlIIlIIlIIllIIIIIl((Object)((Object)EnumChatColor.IlllllIlIIIlIIlIIllIIlIll) + "[" + (Object)((Object)EnumChatColor.IllIIIlllIIIlIlllIlIIlIII) + wSPacketFormattedConsoleOutput.lIlIlIlIlIIlIIlIIllIIIIIl() + (Object)((Object)EnumChatColor.IlllllIlIIIlIIlIIllIIlIll) + "] " + (Object)((Object)EnumChatColor.IllIIIlllIIIlIlllIlIIlIII) + wSPacketFormattedConsoleOutput.IlllIIIIIIlllIlIIlllIlIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketFriendsUpdate wSPacketFriendsUpdate) {
        String string;
        UUID uUID;
        this.IlllllIlIIIlIIlIIllIIlIll = WebSocketState.READY;
        this.llIIIIIIIllIIllIlIllIIIIl.lllllIllIlIIlIIlIIIlllIlI().llllIIlIIlIIlIIllIIlIIllI();
        Map map = wSPacketFriendsUpdate.lIllIlIIIlIIIIIIIlllIlIll();
        Map map2 = wSPacketFriendsUpdate.llIlllIIIllllIIlllIllIIIl();
        this.llIIIlllIIlllIllllIlIllIl = wSPacketFriendsUpdate.lIlIlIlIlIIlIIlIIllIIIIIl();
        this.lllllIllIllIllllIlIllllII = wSPacketFriendsUpdate.IlllIIIIIIlllIlIIlllIlIIl();
        for (Map.Entry entry : map.entrySet()) {
            uUID = UUID.fromString((String)entry.getKey());
            string = (String)((List)entry.getValue()).get(0);
            int n = (Integer)((List)entry.getValue()).get(1);
            String string2 = (String)((List)entry.getValue()).get(2);
            Status status = Status.lIlIlIlIlIIlIIlIIllIIIIIl;
            for (Status status2 : Status.values()) {
                if (status2.ordinal() != n) continue;
                status = status2;
            }
            Profile profile = new Profile(uUID);
            profile.lIlIlIlIlIIlIIlIIllIIIIIl(string);
            profile.lIllIlIIIlIIIIIIIlllIlIll(string2);
            profile.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            profile.IlllIIIIIIlllIlIIlllIlIIl(status);
            this.llIIIIIIIllIIllIlIllIIIIl.lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(profile);
        }
        for (Map.Entry entry : map2.entrySet()) {
            uUID = UUID.fromString((String)entry.getKey());
            string = (String)((List)entry.getValue()).get(0);
            Profile profile = new Profile(uUID);
            profile.lIlIlIlIlIIlIIlIIllIIIIIl(string);
            profile.lIllIlIIIlIIIIIIIlllIlIll("");
            profile.IlllIIIIIIlllIlIIlllIlIIl(Status.llIlllIIIllllIIlllIllIIIl);
            profile.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            profile.lIlIlIlIlIIlIIlIIllIIIIIl((Long)((List)entry.getValue()).get(1));
            this.llIIIIIIIllIIllIlIllIIIIl.lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(profile);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractPacket abstractPacket, boolean bl) {
        if (bl) {
            WSPacketFriendStatusUpdate wSPacketFriendStatusUpdate = (WSPacketFriendStatusUpdate)abstractPacket;
            UUID uUID = UUID.fromString(wSPacketFriendStatusUpdate.lIlIlIlIlIIlIIlIIllIIIIIl());
            this.llIIIIIIIllIIllIlIllIIIIl.IllIIIlllIIIlIlllIlIIlIII().lIlIlIlIlIIlIIlIIllIIIIIl(uUID, wSPacketFriendStatusUpdate.IlllIIIIIIlllIlIIlllIlIIl());
        } else {
            WSPacketFriendRequest wSPacketFriendRequest = (WSPacketFriendRequest)abstractPacket;
            UUID uUID = UUID.fromString(wSPacketFriendRequest.lIlIlIlIlIIlIIlIIllIIIIIl());
            String string = wSPacketFriendRequest.IlllIIIIIIlllIlIIlllIlIIl();
            this.llIIIIIIIllIIllIlIllIIIIl.IllIIIlllIIIlIlllIlIIlIII().IlllIIIIIIlllIlIIlllIlIIl(uUID, string);
            this.llIIIIIIIllIIllIlIllIIIIl.IIIlIIIIIIllIIIIllIIIIlII().lIllIlIIIlIIIIIIIlllIlIll(string, (Object)((Object)EnumChatColor.lIIlIlllIlIlIIIlllIIlIIII) + string + (Object)((Object)EnumChatColor.IllIIIlllIIIlIlllIlIIlIII) + " wants to be your friend");
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketClientFriendRemove wSPacketClientFriendRemove) {
        UUID uUID = UUID.fromString(wSPacketClientFriendRemove.lIlIlIlIlIIlIIlIIllIIIIIl());
        Profile profile = this.llIIIIIIIllIIllIlIllIIIIl.lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(uUID);
        if (profile != null) {
            this.llIIIIIIIllIIllIlIllIIIIl.lllllIllIlIIlIIlIIIlllIlI().lIllIlIIIlIIIIIIIlllIlIll(uUID);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketClientUnknownCosmetic wSPacketClientUnknownCosmetic) {
        boolean bl = wSPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl().equals(this.lIIIllIllIIllIlllIlIIlllI.bridge$getSession().bridge$getProfile().getId());
        if (bl) {
            this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().llIlllIIIllllIIlllIllIIIl().clear();
        } else {
            this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().lIIIllIllIIllIlllIlIIlllI().remove(wSPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl());
        }
        for (Cosmetic cosmetic : wSPacketClientUnknownCosmetic.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            if (cosmetic == null) continue;
            if (bl) {
                this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().llIlllIIIllllIIlllIllIIIl().add(cosmetic);
            }
            if (bl && !cosmetic.llIIIIIIIllIIllIlIllIIIIl()) continue;
            this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(wSPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl(), cosmetic);
        }
        if (bl) {
            this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().IlIlIlllllIlIIlIlIlllIlIl();
        }
        int n = wSPacketClientUnknownCosmetic.lIllIlIIIlIIIIIIIlllIlIll();
        float f = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        float f2 = ColorUtil.lIllIlIIIlIIIIIIIlllIlIll(n);
        float f3 = ColorUtil.llllIIlIIlIIlIIllIIlIIllI(n);
        if (Bridge.IlllIIIIIIlllIlIIlllIlIIl() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl && Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getWorld() != null) {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getWorld().bridge$getPlayerByUniqueId(wSPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl()).ifPresent(entityPlayerBridge -> this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().llIIlIlIIIllIlIlIlIIlIIll().put(entityPlayerBridge.bridge$getName(), wSPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl()));
        }
        this.llIIIIIIIllIIllIlIllIIIIl.IIlIllIlIIllIIlIlIllllllI().IlllllIlIIIlIIlIIllIIlIll().put(wSPacketClientUnknownCosmetic.IlllIIIIIIlllIlIIlllIlIIl(), new CosmeticManager.NameTagLogo(f, f2, f3, wSPacketClientUnknownCosmetic.llIlllIIIllllIIlllIllIIIl()));
        if (this.lIIIllIllIIllIlllIlIIlllI.bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && Ref.llIIIlllIIlllIllllIlIllIl() == CosmeticsUIScreen.class) {
            this.lIIIllIllIIllIlllIlIIlllI.bridge$submit(() -> this.lIIIllIllIIllIlllIlIIlllI.bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new CosmeticsUIScreen())));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketJoinServer wSPacketJoinServer) {
        SecretKey secretKey = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$createNewSharedKey();
        PublicKey publicKey = wSPacketJoinServer.lIlIlIlIlIIlIIlIIllIIIIIl();
        byte[] byArray = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$getServerIdHash("", publicKey, secretKey);
        if (byArray == null) {
            return;
        }
        String string = new BigInteger(byArray).toString(16);
        try {
            MinecraftSessionService minecraftSessionService = new YggdrasilAuthenticationService(Proxy.NO_PROXY, UUID.randomUUID().toString()).createMinecraftSessionService();
            minecraftSessionService.joinServer(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession().bridge$getProfile(), Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession().bridge$getToken(), string);
        }
        catch (AuthenticationUnavailableException authenticationUnavailableException) {
            Ref.IlllIIIIIIlllIlIIlllIlIIl().IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType.ERROR, "Authentication Unavailable", authenticationUnavailableException.getMessage());
            LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Auth", (Object)"Authentication Unavailable (%s)", authenticationUnavailableException.getMessage());
            return;
        }
        catch (InvalidCredentialsException invalidCredentialsException) {
            Ref.IlllIIIIIIlllIlIIlllIlIIl().IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType.ERROR, "Invalid Credentials", invalidCredentialsException.getMessage());
            LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Auth", (Object)"Invalid Credentials (%s)", invalidCredentialsException.getMessage());
            return;
        }
        catch (AuthenticationException authenticationException) {
            Ref.IlllIIIIIIlllIlIIlllIlIIl().IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType.ERROR, "Authentication Error", authenticationException.getMessage());
            LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Auth", (Object)"Authentication Error (%s)", authenticationException.getMessage());
            return;
        }
        catch (NullPointerException nullPointerException) {
            this.close();
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientJoinServerResponse(secretKey, publicKey, wSPacketJoinServer.IlllIIIIIIlllIlIIlllIlIIl()));
        this.IlllllIlIIIlIIlIIllIIlIll = WebSocketState.AUTHENTICATING;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(IlIIlIIlIIlIIllIIIllIIllI ilIIlIIlIIlIIllIIIllIIllI) {
        AbstractEmote abstractEmote = this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(ilIIlIIlIIlIIllIIIllIIllI.IlllIIIIIIlllIlIIlllIlIIl());
        Ref.llIIIIIIIllIIllIlIllIIIIl().bridge$getPlayerByUniqueId(ilIIlIIlIIlIIllIIIllIIllI.lIlIlIlIlIIlIIlIIllIIIIIl()).ifPresent(entityPlayerBridge -> this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((EntityPlayerBridge)entityPlayerBridge, abstractEmote));
        if (LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlllIIIIIIlllIlIIlllIlIIl()) {
            LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().lIllllIllIIlIIlIIIlIIIlII().handleAssetPacket(ilIIlIIlIIlIIllIIIllIIllI);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(IIlIlIIIllIIllllIllllIlIl iIlIlIIIllIIllllIllllIlIl) {
        this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(iIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(IlIlIllIIllllIllllllIIlIl ilIlIllIIllllIllllllIIlIl) {
        this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(ilIlIllIIllllIllllllIIlIl.lIlIlIlIlIIlIIlIIllIIIIIl());
        this.llIIIIIIIllIIllIlIllIIIIl.lIIlIlllIlIlIIIlllIIlIIII().IlllIIIIIIlllIlIIlllIlIIl(ilIlIllIIllllIllllllIIlIl.IlllIIIIIIlllIlIIlllIlIIl());
        if (Ref.llIIIlllIIlllIllllIlIllIl() == EmotesUIScreen.class) {
            ((EmotesUIScreen)((Object)Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen())).llIIIlllIIlllIllllIlIllIl();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketForceCrash wSPacketForceCrash) {
        this.lllIIIIIlllIIlIllIIlIIIlI = true;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(lIlIIIIIllIIlIIlIIlIlIIlI lIlIIIIIllIIlIIlIIlIlIIlI2) {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WSPacketClientBan wSPacketClientBan) {
        String string2;
        if (Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().IlIllIIlIIlIIIllIllllIIll().lIlIlIlIlIIlIIlIIllIIIIIl()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : wSPacketClientBan.lIllIlIIIlIIIIIIIlllIlIll()) {
            stringBuilder.append((Object)EnumChatColor.lllllIllIllIllllIlIllllII).append(string2).append((Object)EnumChatColor.IllIllIIIllIIIlIlIlIIIIll).append(", ");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 4);
        } else {
            stringBuilder.append((Object)EnumChatColor.lllllIllIllIllllIlIllllII).append("Lunar Client");
        }
        String string3 = (Object)((Object)EnumChatColor.lllllIllIllIllllIlIllllII) + "Ban: " + (Object)((Object)EnumChatColor.lIIIllIllIIllIlllIlIIlllI) + wSPacketClientBan.IlllIIIIIIlllIlIIlllIlIIl();
        string2 = (Object)((Object) EnumChatColor.IllIllIIIllIIIlIlIlIIIIll) + "Detected on " + stringBuilder.toString();
        MinecraftBridge minecraftBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl();
        if (minecraftBridge.bridge$getGuiIngame() != null && minecraftBridge.bridge$getGuiIngame().bridge$getChatGUI() != null) {
            GuiNewChatBridge guiNewChatBridge = minecraftBridge.bridge$getGuiIngame().bridge$getChatGUI();
            ChatComponentTextBridge chatComponentTextBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initChatText("      " + (String)string3);
            chatComponentTextBridge.setLc(true);
            guiNewChatBridge.bridge$printChatMessage(chatComponentTextBridge);
            guiNewChatBridge.bridge$printChatMessage(Bridge.llIlllIIIllllIIlllIllIIIl().initChatText("      " + string2));
        }
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(llllIIlIIlIIlIIllIIlIIllI llllIIlIIlIIlIIllIIlIIllI2) {
        llIlllIIIllllIIlllIllIIIl = llllIIlIIlIIlIIllIIlIIllI2;
    }

    public WebSocketState lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lllllIllIllIllllIlIllllII;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lllllIllIllIllllIlIllllII = bl;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    static {
        lIlIlIlIlIIlIIlIIllIIIIIl = "not set";
        EventBus.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(PreRunTickEvent.class, (preRunTickEvent) -> {
            if (LunarClient.IIllIlIllIlIllIllIllIllII() == null || LunarClient.IIllIlIllIlIllIllIllIllII().llIllIIIIlIIIIIIlllIllIlI()) {
                return;
            }
            if (!Ref.getAssetsWebsocket().isPresent() || ((AssetsWebSocket)Ref.getAssetsWebsocket().get()).lIlIlIlIlIIlIIlIIllIIIIIl() == WebSocketState.DISCONNECTED) {
                if (llIlllIIIllllIIlllIllIIIl == null) {
                    LunarLogger.lIllIlIIIlIIIIIIIlllIlIll("Assets Reconnect", (Object)"There was no closedConnection for a disconnected player.", new Object[0]);
                    llIlllIIIllllIIlllIllIIIl = new llllIIlIIlIIlIIllIIlIIllI(15, true);
                }
                if (llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl()) {
                    Ref.IlllIIIIIIlllIlIIlllIlIIl().loginToAssetsWebsocket();
                    LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Assets Reconnect", (Object)"Reconnecting to the assets server...", new Object[0]);
                }
            }
        });
    }
}