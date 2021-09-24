package com.moonsworth.lunar.client.feature.type.worldedit;

import com.google.common.collect.ImmutableList;

import com.moonsworth.lunar.bridge.minecraft.client.network.play.client.C17PacketCustomPayloadBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.optifine.ShadersBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.type.network.CustomPayloadEvent;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.event.type.network.NetHandlerPlayClientInitEvent;
import com.moonsworth.lunar.client.event.type.render.RenderWorldPassEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.type.worldedit.bq.IWorldEditCUIHighlighter;
import com.moonsworth.lunar.client.feature.type.worldedit.bq.WorldEditCUIBlockHighlighter;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.ColorSetting;
import io.netty.buffer.Unpooled;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class WorldEditCUIMod extends ConfigurableFeature {
    public static final String llllIIlIIlIIlIIllIIlIIllI = "WECUI";
    public static final String IlIlIlllllIlIIlIlIlllIlIl = "worldedit:cui";
    public final lIlIlIlIlIIlIIlIIllIIIIIl llIIIIIIIllIIllIlIllIIIIl = new lIlIlIlIlIIlIIlIIllIIIIIl();
    public final WorldEditCUIBlockHighlighter lIIIllIllIIllIlllIlIIlllI = new WorldEditCUIBlockHighlighter();
    public ColorSetting IlllllIlIIIlIIlIIllIIlIll;
    public ColorSetting llIIlIlIIIllIlIlIlIIlIIll;
    public ColorSetting llIIIlllIIlllIllllIlIllIl;
    public static final int lllIIIIIlllIIlIllIIlIIIlI = 770;
    public static final int lIlIIIIIIlIIIllllIllIIlII = 771;
    public static final int llIlIIIllIIlIllIllIllllIl = 516;

    public WorldEditCUIMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderWorldPassEvent.class, (var1) -> {
            try {
                if (this.llIIIIIIIllIIllIlIllIIIIl.IlllIIIIIIlllIlIIlllIlIIl() != null) {
                    GlStateManagerBridge var2 = Bridge.llIIIIIIIllIIllIlIllIIIIl();
                    var2.bridge$blendFunc(770, 771);
                    var2.bridge$enableBlend();
                    var2.bridge$enableAlpha();
                    var2.bridge$alphaFunc(516, 0.0F);
                    var2.bridge$disableTexture2D();
                    var2.bridge$enableDepth();
                    var2.bridge$depthMask(false);
                    Bridge.lIllIlIIIlIIIIIIIlllIlIll().ifPresent((var0) -> {
                        if (var0.getConfig().hasShaders()) {
                            ShadersBridge shaders = var0.getShaders();
                            shaders.useProgram(shaders.getProgramBasic());
                        }

                    });
                    this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(this, var1.lIlIlIlIlIIlIIlIIllIIIIIl());
                    if (((com.moonsworth.lunar.client.feature.type.worldedit.bp.lIlIlIlIlIIlIIlIIllIIIIIl)this.llIIIIIIIllIIllIlIllIIIIl.IlllIIIIIIlllIlIIlllIlIIl()).lIlIlIlIlIIlIIlIIllIIIIIl().size() >= 2) {
                        IWorldEditCUIHighlighter var3 = this.llIIIIIIIllIIllIlIllIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl().IlllIIIIIIlllIlIIlllIlIIl();
                        if (var3 != null) {
                            var3.lIlIlIlIlIIlIIlIIllIIIIIl(this, var1.lIlIlIlIlIIlIIlIIllIIIIIl());
                        }
                    }

                    var2.bridge$depthMask(true);
                    var2.bridge$enableTexture2D();
                    var2.bridge$disableBlend();
                    var2.bridge$alphaFunc(516, 0.01F);
                }
            } catch (Throwable var4) {
                var4.printStackTrace();
            }

        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(CustomPayloadEvent.class, (var1) -> {
            if (var1.lIlIlIlIlIIlIIlIIllIIIIIl().equals("WECUI") || var1.lIlIlIlIlIIlIIlIIllIIIIIl().equalsIgnoreCase("worldedit:cui")) {
                this.llIIIIIIIllIIllIlIllIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(new String(var1.IlllIIIIIIlllIlIIlllIlIIl(), StandardCharsets.UTF_8));
            }

        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, (var1) -> {
            if (Ref.getMinecraft().bridge$getWorld() != null && Ref.getMinecraft().bridge$getWorld().bridge$isRemote()) {
                this.IIlIlIIIllIIllllIllllIlIl();
            }

        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerPlayClientInitEvent.class, (var1) -> {
            if (Ref.getMinecraft().bridge$getWorld() != null && Ref.getMinecraft().bridge$getWorld().bridge$isRemote()) {
                this.IIlIlIIIllIIllllIllllIlIl();
            }

        });
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.IlllllIlIIIlIIlIIllIIlIll = new ColorSetting("point1Color", Color.BLUE.getRGB()), this.llIIlIlIIIllIlIlIlIIlIIll = new ColorSetting("point2Color", Color.RED.getRGB()), this.llIIIlllIIlllIllllIlIllIl = new ColorSetting("outlineColor", Color.GREEN.getRGB()));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("WorldEdit CUI", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("worldedit_cui", ImmutableList.of(ModuleCategory.SERVER, ModuleCategory.ALL));
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        super.lIllIlIIIlIIIIIIIlllIlIll();
        this.IIlIlIIIllIIllllIllllIlIl();
    }

    public void IIlIlIIIllIIllllIllllIlIl() {
        if (Ref.getPlayer() != null) {
            String var1 = Bridge.getMinecraftVersion().ordinal() > MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl.ordinal() ? "minecraft:register" : "REGISTER";
            String var2 = Bridge.getMinecraftVersion().ordinal() > MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl.ordinal() ? "worldedit:cui" : "WECUI";
            C17PacketCustomPayloadBridge var3 = Bridge.getInstance().initCustomPayload(var1, Bridge.getInstance().initPacketBuffer(Unpooled.wrappedBuffer(var2.getBytes(StandardCharsets.UTF_8))));
            C17PacketCustomPayloadBridge var4 = Bridge.getInstance().initCustomPayload(var2, Bridge.getInstance().initPacketBuffer(Unpooled.wrappedBuffer("v|3".getBytes(StandardCharsets.UTF_8))));
            Ref.getNetHandler().bridge$addToSendQueue(var3);
            Ref.getNetHandler().bridge$addToSendQueue(var4);
        }
    }

    public lIlIlIlIlIIlIIlIIllIIIIIl IlIllIIlIIlIIIllIllllIIll() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public WorldEditCUIBlockHighlighter lIllllIllIIlIIlIIIlIIIlII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public ColorSetting lIlIlIIIIIIllIlIIIIllIIII() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public ColorSetting lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public ColorSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }
}
