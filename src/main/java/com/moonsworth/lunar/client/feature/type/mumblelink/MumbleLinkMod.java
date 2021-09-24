package com.moonsworth.lunar.client.feature.type.mumblelink;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.moonsworth.client.mumble.LinkData;
import com.moonsworth.client.mumble.MumbleLink;
import com.moonsworth.client.mumble.MumbleVec;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatComponentTextBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.type.network.NetHandlerPlayClientInitEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;

import java.util.List;

public final class MumbleLinkMod extends ConfigurableFeature {
    public static final ChatComponentTextBridge llllIIlIIlIIlIIllIIlIIllI;
    public static final ChatComponentTextBridge IlIlIlllllIlIIlIlIlllIlIl;
    public static final ChatComponentTextBridge llIIIIIIIllIIllIlIllIIIIl;
    public static final ChatComponentTextBridge lIIIllIllIIllIlllIlIIlllI;
    public MumbleLink IlllllIlIIIlIIlIIllIIlIll;
    public boolean llIIlIlIIIllIlIlIlIIlIIll = false;
    public boolean llIIIlllIIlllIllllIlIllIl = false;
    public final JsonObject lllIIIIIlllIIlIllIIlIIIlI = this.lIlIlIIIIIIllIlIIIIllIIII();
    public final JsonObject lIlIIIIIIlIIIllllIllIIlII = new JsonObject();

    public MumbleLinkMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerPlayClientInitEvent.class, (var1) -> {
            if (this.llIIlIlIIIllIlIlIlIIlIIll && Ref.getWorld() != null && Ref.getWorld().bridge$isRemote()) {
                Ref.getPlayer().bridge$addChatMessage(llllIIlIIlIIlIIllIIlIIllI);
            }

        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, (var1) -> {
            if (this.IlllllIlIIIlIIlIIllIIlIll != null && Ref.getWorld() != null && Ref.getWorld().bridge$isRemote()) {
                if (!this.llIIlIlIIIllIlIlIlIIlIIll && !this.llIIIlllIIlllIllllIlIllIl) {
                    this.IlIllIIlIIlIIIllIllllIIll();
                } else {
                    if (this.llIIIlllIIlllIllllIlIllIl) {
                        return;
                    }

                    EntityPlayerSPBridge var2 = Ref.getPlayer();
                    float var3 = 1.0F;
                    float var4 = 1.0F;
                    float var5 = 1.0F;
                    float var6 = 1.0F;
                    float var7 = 1.0F;
                    float var8 = 1.0F;
                    float var9 = 1.0F;
                    float var10 = 1.0F;
                    float var11 = 1.0F;
                    float var12 = 1.0F;
                    float var13 = 1.0F;
                    float var14 = 1.0F;
                    MumbleVec var15 = new MumbleVec(var2.bridge$getLookAngle().bridge$xCoord(), var2.bridge$getLookAngle().bridge$yCoord(), var2.bridge$getLookAngle().bridge$zCoord());
                    MumbleVec var16 = this.lIlIlIlIlIIlIIlIIllIIIIIl(var2);
                    MumbleVec var17 = new MumbleVec(var2.bridge$getPosX(), (float)var2.bridge$getPosZ(), (float)var2.bridge$getPosY());
                    MumbleVec var18 = new MumbleVec(var15.xCoord * (double)var3, (float)var15.zCoord * var5, (float)var15.yCoord * var4);
                    MumbleVec var19 = new MumbleVec(var16.xCoord * (double)var9, (float)var16.zCoord * var11, (float)var16.yCoord * var10);
                    MumbleVec var20 = new MumbleVec(var2.bridge$getPosX(), (float)var2.bridge$getPosZ(), (float)var2.bridge$getPosY());
                    MumbleVec var21 = new MumbleVec(var15.xCoord * (double)var6, (float)var15.zCoord * var8, (float)var15.yCoord * var7);
                    MumbleVec var22 = new MumbleVec(var16.xCoord * (double)var12, (float)var16.zCoord * var14, (float)var16.yCoord * var13);
                    LinkData var23 = new LinkData(this.lIllllIllIIlIIlIIIlIIIlII().toString(), this.lllIIIIIlllIIlIllIIlIIIlI.toString(), var18, var19, var17, var20, var21, var22);
                    this.IlllllIlIIIlIIlIIllIIlIll.update(var23);
                }
            }

        });
    }

    public JsonObject lIllllIllIIlIIlIIIlIIIlII() {
        JsonArray var1 = new JsonArray();
        var1.add(new JsonPrimitive(Ref.getWorld().bridge$getWorldInfo().bridge$getSpawnX()));
        var1.add(new JsonPrimitive(Ref.getWorld().bridge$getWorldInfo().bridge$getSpawnY()));
        var1.add(new JsonPrimitive(Ref.getWorld().bridge$getWorldInfo().bridge$getSpawnZ()));
        this.lIlIIIIIIlIIIllllIllIIlII.addProperty("name", Ref.getPlayer().bridge$getName());
        this.lIlIIIIIIlIIIllllIllIIlII.add("worldSpawn", var1);
        if (Bridge.getInstance().getMinecraftVersion().ordinal() >= MinecraftVersion.llllIIlIIlIIlIIllIIlIIllI.ordinal()) {
            this.lIlIIIIIIlIIIllllIllIIlII.addProperty("dimension", Ref.getPlayer().bridge$getDimensionName());
        } else {
            this.lIlIIIIIIlIIIllllIllIIlII.addProperty("dimension", Ref.getPlayer().bridge$getDimension());
        }

        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public JsonObject lIlIlIIIIIIllIlIIIIllIIII() {
        JsonObject var1 = new JsonObject();
        var1.addProperty("domain", "AllTalk");
        return var1;
    }

    public MumbleVec lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerSPBridge var1) {
        float var2 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$cos(-var1.bridge$getRotationYaw() * 0.01745329238474369D - 3.1415927410125732D);
        float var3 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$sin(-var1.bridge$getRotationYaw() * 0.01745329238474369D - 3.1415927410125732D);
        float var4 = -Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$cos((-var1.bridge$getRotationPitch() + 90.0D) * 0.01745329238474369D);
        float var5 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$sin((-var1.bridge$getRotationPitch() + 90.0D) * 0.01745329238474369D);
        return new MumbleVec(var3 * var4, var5, var2 * var4);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1) {
        EntityPlayerSPBridge var2;
        if (!System.getProperty("os.name").toLowerCase().contains("win")) {
            var2 = Ref.getPlayer();
            if (var2 != null) {
                var2.bridge$addChatMessage(llIIIIIIIllIIllIlIllIIIIl);
            }

            this.lIlIlIlIlIIlIIlIIllIIIIIl((Boolean)false);
        } else {
            if (var1) {
                if (this.IlllllIlIIIlIIlIIllIIlIll == null) {
                    this.IlllllIlIIIlIIlIIllIIlIll = new MumbleLink();
                }

                if (this.IlllllIlIIIlIIlIIllIIlIll.isOk()) {
                    this.IlIllIIlIIlIIIllIllllIIll();
                } else {
                    this.llIIIlllIIlllIllllIlIllIl = true;
                    Ref.getPlayer().bridge$addChatMessage(lIIIllIllIIllIlllIlIIlllI);
                }
            } else {
                var2 = Ref.getPlayer();
                if (var2 != null) {
                    var2.bridge$addChatMessage(IlIlIlllllIlIIlIlIlllIlIl);
                }
            }

        }
    }

    public void IlIllIIlIIlIIIllIllllIIll() {
        if (!this.llIIlIlIIIllIlIlIlIIlIIll) {
            try {
                this.llIIlIlIIIllIlIlIlIIlIIll = this.IlllllIlIIIlIIlIIllIIlIll.init() >= 0;
            } catch (Throwable var2) {
                this.llIIIlllIIlllIllllIlIllIl = true;
                this.llIIlIlIIIllIlIlIlIIlIIll = false;
                Ref.getPlayer().bridge$addChatMessage(lIIIllIllIIllIlllIlIIlllI);
                var2.printStackTrace();
            }
        }

        if (this.llIIlIlIIIllIlIlIlIIlIIll) {
            EntityPlayerSPBridge var1 = Ref.getPlayer();
            if (var1 != null) {
                var1.bridge$addChatMessage(llllIIlIIlIIlIIllIIlIIllI);
            }
        }

    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.getDetails().get("name"), var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("mumble-link", ImmutableList.of(ModuleCategory.MECHANIC, ModuleCategory.ALL));
    }

    static {
        llllIIlIIlIIlIIllIIlIIllI = Bridge.getInstance().initChatText(EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "[" + EnumChatColor.lllllIllIllIllllIlIllllII + "LC" + EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "]" + EnumChatColor.llIIIlllIIlllIllllIlIllIl + " Mumble Link initiated.");
        IlIlIlllllIlIIlIlIlllIlIl = Bridge.getInstance().initChatText(EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "[" + EnumChatColor.lllllIllIllIllllIlIllllII + "LC" + EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "]" + EnumChatColor.lllIIIIIlllIIlIllIIlIIIlI + " Mumble Link turned off.");
        llIIIIIIIllIIllIlIllIIIIl = Bridge.getInstance().initChatText(EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "[" + EnumChatColor.lllllIllIllIllllIlIllllII + "LC" + EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "]" + EnumChatColor.lllIIIIIlllIIlIllIIlIIIlI + " Unsupported Operating System.");
        lIIIllIllIIllIlllIlIIlllI = Bridge.getInstance().initChatText(EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "[" + EnumChatColor.lllllIllIllIllllIlIllllII + "LC" + EnumChatColor.lIIIllIllIIllIlllIlIIlllI + "]" + EnumChatColor.lllIIIIIlllIIlIllIIlIIIlI + " An error occurred while enabling MumbleLink, please create a ticket @ https://lunarclient.com/support");
    }
}