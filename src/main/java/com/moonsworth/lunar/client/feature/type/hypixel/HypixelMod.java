package com.moonsworth.lunar.client.feature.type.hypixel;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatComponentTextBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatStyleBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.type.chat.ChatEvent;
import com.moonsworth.lunar.client.event.type.hud.RenderNameEvent;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.IntergratedServerInterface;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.server.ServerIntegration;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.threading.LunarExecutors;
import com.moonsworth.lunar.client.util.*;

import org.apache.commons.io.IOUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class HypixelMod extends ConfigurableFeature implements IntergratedServerInterface {
    public static final ImmutableList<String> llllIIlIIlIIlIIllIIlIIllI = ImmutableList.of("Winner #1 (", "Top Survivors", "Winners - ", "Winners: ", "Winner: ", "Winning Team: ", " won the game!", "Top Seeker: ", "Last team standing!", "1st Place: ", "1st Killer - ", "1st Place - ", "Winner: ", " - Damage Dealt - ", "Winning Team -", "1st - ", " Duel - ");
    public BooleanSetting IlIlIlllllIlIIlIlIlllIlIl;
    public BooleanSetting llIIIIIIIllIIllIlIllIIIIl;
    public BooleanSetting lIIIllIllIIllIlllIlIIlllI;
    public BooleanSetting IlllllIlIIIlIIlIIllIIlIll;
    public BooleanSetting llIIlIlIIIllIlIlIlIIlIIll;
    public BooleanSetting llIIIlllIIlllIllllIlIllIl;
    public ColorSetting lllIIIIIlllIIlIllIIlIIIlI;
    public ColorSetting lIlIIIIIIlIIIllllIllIIlII;
    public final Map<UUID, Integer> llIlIIIllIIlIllIllIllllIl = new ConcurrentHashMap<>();
    public final Set<UUID> IllIllIIIllIIIlIlIlIIIIll = Sets.newSetFromMap(new ConcurrentHashMap<>());
    public final JsonParser IIlIllIlllllllIIlIIIllIIl = new JsonParser();
    public long lIIlIlllIlIlIIIlllIIlIIII;

    public HypixelMod() {
        super(true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ChatEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderNameEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIIlIlllIlIlIIIlllIIlIIII = 0L;
        LunarExecutors.getLunarExecutor().scheduleAtFixedRate(() -> {
            if (this.enabled.llIlllIIIllllIIlllIllIIIl() && this.llIIIlllIIlllIllllIlIllIl.llIlllIIIllllIIlllIllIIIl() && !this.IllIllIIIllIIIlIlIlIIIIll.isEmpty()) {
                ImmutableSet<UUID> var1 = ImmutableSet.copyOf(this.IllIllIIIllIIIlIlIlIIIIll);
                this.IllIllIIIllIIIlIlIlIIIIll.clear();
                StringBuilder var2 = new StringBuilder("?");

                for (UUID var4 : var1) {
                    var2.append("uuid=").append(var4).append('&');
                }

                var2.append("gameMode=").append(FriendStatusUtil.IlllIIIIIIlllIlIIlllIlIIl() == null ? "unknown" : URLEncoder.encode(FriendStatusUtil.IlllIIIIIIlllIlIIlllIlIIl())).append('&');
                var2.append("sourceUuid=").append(AuthUtil.lIllIlIIIlIIIIIIIlllIlIll(Ref.getMinecraft().bridge$getSession().bridge$getPlayerID())).append('&');

                try {
                    URL var10 = new URL("https://hypixelcache.lunarclientprod.com" + var2);
                    HttpURLConnection var11 = (HttpURLConnection)var10.openConnection();
                    var11.setRequestMethod("GET");
                    var11.setReadTimeout(8000);
                    var11.setConnectTimeout(8000);
                    var11.setDoOutput(true);
                    String var5 = IOUtils.toString(var11.getInputStream(), Charsets.UTF_8);
                    JsonObject var6 = null;

                    try {
                        var6 = this.IIlIllIlllllllIIlIIIllIIl.parse(var5).getAsJsonObject();
                    } catch (JsonParseException var8) {
                    }

                    if (var6 == null) {
                        return;
                    }

                    var6.entrySet().forEach((var1x) -> {
                        UUID uuid = UUID.fromString(var1x.getKey());
                        JsonElement var3 = var1x.getValue();
                        if (!var3.isJsonNull()) {
                            this.llIlIIIllIIlIllIllIllllIl.put(uuid, var3.getAsInt());
                        }

                    });
                } catch (Exception var9) {
                    var9.printStackTrace();
                }
            }

        }, 4L, 4L, TimeUnit.SECONDS);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderNameEvent var1) {
        if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof EntityPlayerBridge) {
            if (this.llIIIlllIIlllIllllIlIllIl.llIlllIIIllllIIlllIllIIIl()) {
                EntityLivingBaseBridge var2 = var1.lIlIlIlIlIIlIIlIIllIIIIIl();
                UUID var3 = var2.bridge$getUniqueID();
                if (!PlayerNameUtil.lIlIlIlIlIIlIIlIIllIIIIIl((EntityPlayerBridge)var2)) {
                    String var4 = var2.bridge$getDisplayName();
                    if (var4 == null || !var4.contains(EnumChatColor.IIlIllIlllllllIIlIIIllIIl.toString())) {
                        if (!this.llIlIIIllIIlIllIllIllllIl.containsKey(var3)) {
                            this.llIlIIIllIIlIllIllIllllIl.put(var3, -1);
                            this.IllIllIIIllIIIlIlIlIIIIll.add(var3);
                        } else {
                            int var5 = this.llIlIIIllIIlIllIllIllllIl.get(var2.bridge$getUniqueID());
                            if (var5 != -1) {
                                int var6 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllIIIIIlllIIlIllIIlIIIlI.IlllIIIIIIlllIlIIlllIlIIl(0.0F), this.lllIIIIIlllIIlIllIIlIIIlI.lIllIlIIIlIIIIIIIlllIlIll(0.0F), this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl(0.0F), 223.0F);
                                int var7 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl(0.0F), this.lIlIIIIIIlIIIllllIllIIlII.lIllIlIIIlIIIIIIIlllIlIll(0.0F), this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl(0.0F), 223.0F);
                                NameLine var8 = new NameLine(new NameLine.NameLineData(var6, "Level: "));
                                var8.lIlIlIlIlIIlIIlIIllIIIIIl(new NameLine.NameLineData(var7, var5 + ""));
                                var1.IlIlIlllllIlIIlIlIlllIlIl().add(var8);
                            }
                        }
                    }
                }
            }
        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(
                this.IlIlIlllllIlIIlIlIlllIlIl = new BooleanSetting("auto_friend", false),
                this.IlllllIlIIIlIIlIIllIIlIll = new BooleanSetting("auto_tip", false),
                this.llIIIIIIIllIIllIlIllIIIIl = new BooleanSetting("auto_gg", false),
                this.lIIIllIllIIllIlllIlIIlllI = new BooleanSetting("anti_gg", false),
                this.llIIlIlIIIllIlIlIlIIlIIll = new BooleanSetting("auto_who", false),
                this.llIIIlllIIlllIllllIlIllIl = new BooleanSetting("level_head", false),
                this.lllIIIIIlllIIlIllIIlIIIlI = new ColorSetting("level_color", -171, () -> !(Boolean)this.llIIIlllIIlllIllllIlIllIl.llIlllIIIllllIIlllIllIIIl()),
                this.lIlIIIIIIlIIIllllIllIIlII = new ColorSetting("number_color", -11141121, () -> !(Boolean)this.llIIIlllIIlllIllllIlIllIl.llIlllIIIllllIIlllIllIIIl())
        );
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Hypixel Mods", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return (new FeatureDetails("hypixel_mod", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.SERVER, ModuleCategory.NEW), true, ImmutableList.of(MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl), new String[0])).lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of("AutoGG", "Auto GG", "Level Head"));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent var1) {
        if (Ref.getLC().llllIIlIIlIIlIIllIIlIIllI().llIIIIIIIllIIllIlIllIIIIl() != null) {
            if (Ref.getMinecraft().bridge$getPlayer() != null) {
                if (this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl()) {
                    Ref.getMinecraft().bridge$getPlayer().bridge$sendChatMessage("/tip all");
                }
            }
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ChatEvent var1) {
        if (var1.lIllIlIIIlIIIIIIIlllIlIll() != 2) {
            String var2 = EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl());
            if (this.llIIIlllIIlllIllllIlIllIl.llIlllIIIllllIIlllIllIIIl() && FriendStatusUtil.IlllIIIIIIlllIlIIlllIlIIl() != null) {
                List var3 = ((ChatComponentTextBridge)var1.IlllIIIIIIlllIlIIlllIlIIl()).bridge$getSiblings();
                Iterator var4 = var3.iterator();

                while(var4.hasNext()) {
                    IChatComponentBridge var5 = (IChatComponentBridge)var4.next();
                    ChatStyleBridge var6 = ((ChatComponentTextBridge)var5).bridge$getChatStyle();
                    if (var6 != null && var6.bridge$getHoverEvent() != null && var6.bridge$getClickEvent() != null && var6.bridge$getClickEvent().bridge$getValue().startsWith("/viewprofile")) {
                        UUID var7 = null;

                        try {
                            var7 = UUID.fromString(var6.bridge$getClickEvent().bridge$getValue().replace("/viewprofile ", ""));
                        } catch (IllegalArgumentException var10) {
                        }

                        if (var7 != null) {
                            String[] var8 = ((ChatComponentTextBridge)var6.bridge$getHoverEvent().bridge$getValue()).bridge$getRawText().split("\n");
                            if (var8.length == 6) {
                                Integer var9 = Ints.tryParse(var8[1].replace(EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "Hypixel Level: " + EnumChatColor.llIIIIIIIllIIllIlIllIIIIl, ""));
                                if (var9 != null) {
                                    this.IllIllIIIllIIIlIlIlIIIIll.remove(var7);
                                    this.llIlIIIllIIlIllIllIllllIl.put(var7, var9);
                                }
                            }
                        }
                    }
                }
            }

            if (this.llIIlIlIIIllIlIlIlIIlIIll.llIlllIIIllllIIlllIllIIIl() && var2.equalsIgnoreCase("Teaming is not allowed on Ranked Mode!")) {
                Ref.getMinecraft().bridge$getPlayer().bridge$sendChatMessage("/who");
            } else if (this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl() && var2.equalsIgnoreCase("You already tipped everyone that has boosters active, so there isn't anybody to be tipped right now!")) {
                var1.setCancelled(true);
            } else {
                if (this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() && (var2.toLowerCase().endsWith("gg") || var2.toLowerCase().endsWith("good game"))) {
                    var1.setCancelled(true);
                }

                if (this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl()) {
                    if (System.currentTimeMillis() - this.lIIlIlllIlIlIIIlllIIlIIII <= TimeUnit.SECONDS.toMillis(2L)) {
                        return;
                    }

                    if (var2.startsWith(" ")) {
                        boolean var11 = false;
                        UnmodifiableIterator<String> var13 = llllIIlIIlIIlIIllIIlIIllI.iterator();

                        while(var13.hasNext()) {
                            String var15 = var13.next();
                            if (var2.contains(var15)) {
                                var11 = true;
                                break;
                            }
                        }

                        if (var11) {
                            Ref.getMinecraft().bridge$getPlayer().bridge$sendChatMessage("/achat gg");
                            this.lIIlIlllIlIlIIIlllIIlIIII = System.currentTimeMillis();
                        }
                    }
                }

                if (this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl() && var2.toLowerCase().contains("friend request from")) {
                    String[] var12 = var2.split("\n");
                    int var14 = var12.length;

                    for(int var16 = 0; var16 < var14; ++var16) {
                        String var17 = var12[var16];
                        if (var17.toLowerCase().contains("friend request from ")) {
                            String var18 = var17.replace("Friend request from ", "");
                            var18 = var18.split(" ")[var18.split(" ").length - 1];
                            Ref.getMinecraft().bridge$getPlayer().bridge$sendChatMessage("/friend accept " + var18);
                            break;
                        }
                    }
                }

            }
        }
    }

    public ServerIntegration.Server lIlIlIlIlIIlIIlIIllIIIIIl() {
        return ServerIntegration.Server.HYPIXEL;
    }

    public BooleanSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public BooleanSetting lIllllIllIIlIIlIIIlIIIlII() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public BooleanSetting lIlIlIIIIIIllIlIIIIllIIII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public BooleanSetting lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public BooleanSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public BooleanSetting IIlIlIIIllIIllllIllllIlIl() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public ColorSetting lllllIIIIlIlllIllIIIlIIlI() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public ColorSetting IIlllIllIlIllIllIIllIlIIl() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public Map lIlIIlIlllIIlIIIlIlIlIllI() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public Set lIIlllIIIIIlllIIIlIlIlllI() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public long IIIlIIIIIIllIIIIllIIIIlII() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }
}
