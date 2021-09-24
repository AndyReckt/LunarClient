package com.moonsworth.lunar.client.feature.type.nick;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.gson.JsonObject;

import com.mojang.authlib.GameProfile;

import com.moonsworth.lunar.bridge.minecraft.client.network.NetworkPlayerInfoBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.entity.player.CreatePlayerEvent;
import com.moonsworth.lunar.client.event.type.network.GameProfileEvent;
import com.moonsworth.lunar.client.event.type.network.ServerConnectEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.SettingLabel;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.CosmeticsUIScreen;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class NickHiderMod extends ConfigurableFeature {
    public static final ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI = Bridge.getInstance().initResourceLocation("textures/entity/steve.png");
    public static final ResourceLocationBridge IlIlIlllllIlIIlIlIlllIlIl = Bridge.getInstance().initResourceLocation("textures/entity/alex.png");
    public BooleanSetting llIIIIIIIllIIllIlIllIIIIl;
    public BooleanSetting lIIIllIllIIllIlllIlIIlllI;
    public BooleanSetting IlllllIlIIIlIIlIIllIIlIll;
    public BooleanSetting llIIlIlIIIllIlIlIlIIlIIll;
    public BooleanSetting llIIIlllIIlllIllllIlIllIl;
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;
    public final Pattern lIlIIIIIIlIIIllllIllIIlII = Pattern.compile("([a-zA-Z0-9_]{3,16})");
    public final List<lIlIlIlIlIIlIIlIIllIIIIIl> llIlIIIllIIlIllIllIllllIl = new ArrayList<>();
    public final AtomicInteger IllIllIIIllIIIlIlIlIIIIll = new AtomicInteger();
    public final LoadingCache<String, String> IIlIllIlllllllIIlIIIllIIl = CacheBuilder.newBuilder().maximumSize(5000L).build(new CacheLoader<String, String>() {
        public String lIlIlIlIlIIlIIlIIllIIIIIl(String var1) {
            return NickHiderMod.this.lIllIlIIIlIIIIIIIlllIlIll(var1);
        }

        // $FF: synthetic method
        public String load(String var1) {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl(var1);
        }
    });
    public final NickHiderEventHandler lIIlIlllIlIlIIIlllIIlIIII = new NickHiderEventHandler(this);

    public NickHiderMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GameProfileEvent.lIlIlIlIlIIlIIlIIllIIIIIl.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(CreatePlayerEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerConnectEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.llIIIIIIIllIIllIlIllIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((var1) -> {
            if (var1) {
                this.lIllllIllIIlIIlIIIlIIIlII();
            } else {
                this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            }

        }));
        this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(((var1) -> {
            if (var1) {
                this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                this.lIllllIllIIlIIlIIIlIIIlII();
            } else {
                this.lIlIlIIIIIIllIlIIIIllIIII();
                if (this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl()) {
                    this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl();
                }
            }

        }));
        this.IlllllIlIIIlIIlIIllIIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(((var1) -> {
            if (var1) {
                this.lIIlIIIIIIlIIlIIllIlIIlII();
            } else {
                this.llIlIIIllIIlIllIllIllllIl.removeIf((var0) -> {
                    return !var0.llIlllIIIllllIIlllIllIIIl();
                });
                this.IlIllIIlIIlIIIllIllllIIll();
            }

        }));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1) {
        if (this.llIlIIIllIIlIllIllIllllIl != null) {
            this.IlIIlIIlIIlIIllIIIllIIllI();
            if (Ref.getPlayer() != null && Ref.getPlayer().bridge$getSendQueue() != null && var1) {
                this.lIllllIllIIlIIlIIIlIIIlII();
                this.lIIlIIIIIIlIIlIIllIlIIlII();
            }

        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GameProfile var1) {
        if (!Ref.getLC().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll()) {
            if (var1 != null && this.lc.llllIIlIIlIIlIIllIIlIIllI() != null) {
                String var2 = EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(var1.getName());
                boolean var3 = var2.equals(this.lc.llllIIlIIlIIlIIllIIlIIllI().llllIIlIIlIIlIIllIIlIIllI());
                boolean var4 = var2.equals(this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl());
                boolean var5 = !var3 && !var4 && this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl();
                if (var3 && this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() || var4 && this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl() || var5) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3 || var4);
                }

            }
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1) {
        Optional var2 = this.llllIIlIIlIIlIIllIIlIIllI(var1);
        if (var2.isPresent()) {
            this.llIlIIIllIIlIllIllIllllIl.remove(var2.get());
            this.IlIllIIlIIlIIIllIllllIIll();
        }

    }

    public String IlllIIIIIIlllIlIIlllIlIIl(String var1) {
        if (this.IlllIIIIIIlllIlIIlllIlIIl() && !Ref.getLC().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll()) {
            try {
                return this.IIlIllIlllllllIIlIIIllIIl.get(var1);
            } catch (UncheckedExecutionException | ExecutionException var3) {
                return var1;
            }
        } else {
            return var1;
        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(new SettingLabel("nameOptions"), this.llIIIIIIIllIIllIlIllIIIIl = new BooleanSetting("hideName", true), this.lIIIllIllIIllIlllIlIIlllI = new BooleanSetting("hideRealName", true), this.IlllllIlIIIlIIlIIllIIlIll = new BooleanSetting("hideOthersNames", false), new SettingLabel("skinOptions"), this.llIIlIlIIIllIlIlIlIIlIIll = new BooleanSetting("hideOwnSkin", true), this.llIIIlllIIlllIllllIlIllIl = new BooleanSetting("useRealSkin", true), this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting("hideOthersSkin", false));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return (new FeatureDetails("nickHider", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.NEW), new String[] {"Sk1er"})).lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of("nick hider", "nickhider"));
    }

    public boolean llIlllIIIllllIIlllIllIIIl(String var1) {
        return this.lIlIIIIIIlIIIllllIllIIlII.matcher(var1).matches() && var1.length() >= 3 && var1.length() <= 16;
    }

    public Optional llllIIlIIlIIlIIllIIlIIllI(String var1) {
        return this.llIlIIIllIIlIllIllIllllIl.stream().filter((var1x) -> {
            return var1x.IlllIIIIIIlllIlIIlllIlIIl().equalsIgnoreCase(var1);
        }).findFirst();
    }

    public ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl(UUID var1, String var2, ResourceLocationBridge var3) {
        if (this.IlllIIIIIIlllIlIIlllIlIIl() && Ref.getPlayer() != null && !Ref.getLC().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll()) {
            boolean var4 = Ref.getPlayer().bridge$getUniqueID().equals(var1);
            if (var4) {
                if (this.llIIIlllIIlllIllllIlIllIl.llIlllIIIllllIIlllIllIIIl()) {
                    return CosmeticsUIScreen.lIIIllIllIIllIlllIlIIlllI().bridge$getLocationSkin();
                }

                if (this.llIIlIlIIIllIlIlIlIIlIIll.llIlllIIIllllIIlllIllIIIl()) {
                    return this.IlIlIlllllIlIIlIlIlllIlIl(var2);
                }
            } else if (this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl()) {
                return this.IlIlIlllllIlIIlIlIlllIlIl(var2);
            }

            return var3;
        } else {
            return var3;
        }
    }

    public ResourceLocationBridge IlIlIlllllIlIIlIlIlllIlIl(String var1) {
        return var1.equals("default") ? llllIIlIIlIIlIIllIIlIIllI : IlIlIlllllIlIIlIlIlllIlIl;
    }

    public String llllIIlIIlIIlIIllIIlIIllI(boolean var1) {
        return var1 ? (this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() ? "You" : this.lc.llllIIlIIlIIlIIllIIlIIllI().llllIIlIIlIIlIIllIIlIIllI()) : "Player-" + this.IllIllIIIllIIIlIlIlIIIIll.incrementAndGet();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1, boolean var2) {
        if (var1 != null && !this.llllIIlIIlIIlIIllIIlIIllI(var1).isPresent() && this.llIlllIIIllllIIlllIllIIIl(var1)) {
            String var3 = this.llllIIlIIlIIlIIllIIlIIllI(var2);
            lIlIlIlIlIIlIIlIIllIIIIIl var4 = new lIlIlIlIlIIlIIlIIllIIIIIl(Pattern.compile(Pattern.quote(var1), 2), var1, var3, var2);
            this.llIlIIIllIIlIllIllIllllIl.add(var4);
            Comparator<lIlIlIlIlIIlIIlIIllIIIIIl> var5 = Comparator.comparingInt((var0) -> {
                return var0.IlllIIIIIIlllIlIIlllIlIIl().length();
            });
            this.llIlIIIllIIlIllIllIllllIl.sort(var5.reversed());
            this.IlIllIIlIIlIIIllIllllIIll();
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ServerConnectEvent var1) {
        this.IlIIlIIlIIlIIllIIIllIIllI();
        this.lIllllIllIIlIIlIIIlIIIlII();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(CreatePlayerEvent var1) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameProfile());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GameProfileEvent.lIlIlIlIlIIlIIlIIllIIIIIl var1) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        if (this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() && this.lc.llllIIlIIlIIlIIllIIlIIllI() != null) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lc.llllIIlIIlIIlIIllIIlIIllI().llllIIlIIlIIlIIllIIlIIllI(), true);
        }

        if (this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl()) {
            this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl();
        }

    }

    public void lIlIlIIIIIIllIlIIIIllIIII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lc.llllIIlIIlIIlIIllIIlIIllI().llllIIlIIlIIlIIllIIlIIllI());
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    public void lIIlIIIIIIlIIlIIllIlIIlII() {
        if (this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl()) {
            Ref.getPlayer().bridge$getSendQueue().bridge$getPlayerInfoMap().stream().map(NetworkPlayerInfoBridge::bridge$getGameProfile).filter((var1) -> {
                return !var1.getName().equals(this.lc.llllIIlIIlIIlIIllIIlIIllI().llllIIlIIlIIlIIllIIlIIllI()) && !var1.getName().equals(this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl());
            }).forEach(this::lIlIlIlIlIIlIIlIIllIIIIIl);
        }

    }

    public void IlIIlIIlIIlIIllIIIllIIllI() {
        this.llIlIIIllIIlIllIllIllllIl.clear();
        this.IllIllIIIllIIIlIlIlIIIIll.set(0);
        this.IlIllIIlIIlIIIllIllllIIll();
    }

    public String lIllIlIIIlIIIIIIIlllIlIll(String var1) {
        String var2 = var1;
        if (this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl() || this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl() || this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl()) {
            Iterator<lIlIlIlIlIIlIIlIIllIIIIIl> var3 = this.llIlIIIllIIlIllIllIllllIl.iterator();

            while(var3.hasNext()) {
                lIlIlIlIlIIlIIlIIllIIIIIl var4 = var3.next();
                boolean var5 = var4.llIlllIIIllllIIlllIllIIIl() && (this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl() || this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl()) || !var4.llIlllIIIllllIIlllIllIIIl() && this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl();
                if (var5) {
                    var2 = var4.lIlIlIlIlIIlIIlIIllIIIIIl().matcher(var2).replaceAll(var4.lIllIlIIIlIIIIIIIlllIlIll());
                }
            }
        }

        return var2;
    }

    public void IlIllIIlIIlIIIllIllllIIll() {
        this.IIlIllIlllllllIIlIIIllIIl.invalidateAll();
        this.lc.IIIIlIllIllIlIIIIIlIlIlIl().ifPresent(com.moonsworth.lunar.client.feature.type.nick.lIllIlIIIlIIIIIIIlllIlIll::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void read(JsonObject var1) {
        super.read(var1);
        if (var1.has("lastKnownHypixelNick")) {
            this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(var1.get("lastKnownHypixelNick").getAsString());
        }

    }

    public void write(JsonObject var1) {
        super.write(var1);
        if (!this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl().isEmpty()) {
            var1.addProperty("lastKnownHypixelNick", this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl());
        }

    }
}
