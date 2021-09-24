package com.moonsworth.lunar.client.feature.type.serveraddress;

import com.google.common.collect.ImmutableList;

import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.ServerDataBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.DynamicTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.network.NetHandlerPlayClientInitEvent;
import com.moonsworth.lunar.client.event.type.network.ServerDisconnectEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.StreamUtils;

import java.awt.image.BufferedImage;
import java.util.List;

public class ServerAddressMod extends SimpleHudMod {
    public final ResourceLocationBridge IllIIIlllIIIlIlllIlIIlIII = Bridge.getInstance().initResourceLocation("minecraft", "textures/misc/unknown_server.png");
    public BooleanSetting IIlIllIlIIllIIlIlIllllllI;
    public ResourceLocationBridge lIIIlllIIIIllllIlIIIlIIll = null;
    public BufferedImage llIIIlIllIIIIlIIIlIlIllIl = null;

    public ServerAddressMod() {
        super(false, HudModPosition.TOP_LEFT);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerPlayClientInitEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1) {
        if (var1) {
            this.IlIlllIIIIIllIIllIllIIlll();
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent var1) {
        if (this.llIIIlIllIIIIlIIIlIlIllIl != null) {
            if (this.lIIIlllIIIIllllIlIIIlIIll != null) {
                Ref.getMinecraft().bridge$getTextureManager().bridge$deleteTexture(this.lIIIlllIIIIllllIlIIIlIIll);
            }

            DynamicTextureBridge var2 = Bridge.getInstance().initDynamicTexture(this.llIIIlIllIIIIlIIIlIlIllIl);
            this.lIIIlllIIIIllllIlIIIlIIll = Ref.getMinecraft().bridge$getTextureManager().bridge$getDynamicTextureLocation("server-icon-thumbnail", var2);
            this.llIIIlIllIIIIlIIIlIlIllIl = null;
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerPlayClientInitEvent var1) {
        this.IlIlllIIIIIllIIllIllIIlll();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent var1) {
        if (this.lIIIlllIIIIllllIlIIIlIIll != null) {
            Ref.getMinecraft().bridge$getTextureManager().bridge$deleteTexture(this.lIIIlllIIIIllllIlIIIlIIll);
            this.lIIIlllIIIIllllIlIIIlIIll = null;
        }

    }

    public void IlIlllIIIIIllIIllIllIIlll() {
        ServerDataBridge var1 = Ref.getMinecraft().bridge$getCurrentServerData();
        if (var1 != null && var1.bridge$getBase64Icon() != null && !var1.bridge$getBase64Icon().isEmpty()) {
            StreamUtils.lIlIlIlIlIIlIIlIIllIIIIIl(var1.bridge$getBase64Icon()).ifPresent((var1x) -> {
                this.llIIIlIllIIIIlIIIlIlIllIl = var1x;
            });
        } else {
            this.lIIIlllIIIIllllIlIIIlIIll = null;
        }

    }

    public boolean IIIIlIllIllIlIIIIIlIlIlIl() {
        return true;
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(70.0F, 66.0F);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1, float var2, float var3) {
        if (var1 != null && !var1.isEmpty()) {
            boolean var4 = this.IIlIllIlIIllIIlIlIllllllI.llIlllIIIllllIIlllIllIIIl();
            this.IlllIIIIIIlllIlIIlllIlIIl(Ref.getFontRenderer().bridge$getStringWidth(var1) + 8.0F + (float)(var4 ? (Integer)this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl() : 0), (float)(Integer)this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
            float var5 = this.llIIIIIIIllIIllIlIllIIIIl;
            if (var4) {
                var2 += this.lIIIllIllIIllIlllIlIIlllI;
                var5 -= this.lIIIllIllIIllIlllIlIIlllI;
            }

            float var6 = var5 / 2.0F;
            float var7 = this.lIIIllIllIIllIlllIlIIlllI / 1.88F - (float)Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() / 2.0F + 0.5F;
            if (this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl()) {
                float var8 = var4 ? this.lIIIllIllIIllIlllIlIIlllI : 0.0F;
                this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var8, var3, var5 + var8, this.lIIIllIllIIllIlllIlIIlllI);
                if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
                    float var9 = (Float)this.lllllIllIlIIlIIlIIIlllIlI.llIlllIIIllllIIlllIllIIIl();
                    this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var8, var3 - var9, var5 + var8, var9);
                    this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var8, var3 + this.lIIIllIllIIllIlllIlIIlllI, var5 + var8, var9);
                    this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var8 - var9, var3 - var9, var9, this.lIIIllIllIIllIlllIlIIlllI + var9 * 2.0F);
                    this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var8 + var5 + var8, var3 - var9, var9, this.lIIIllIllIIllIlllIlIIlllI + var9 * 2.0F);
                }
            }

            if (var4) {
                ResourceLocationBridge var10 = this.lIIIlllIIIIllllIlIIIlIIll == null ? this.IllIIIlllIIIlIlllIlIIlIII : this.lIIIlllIIIIllllIlIIIlIIll;
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var10, this.lIIIllIllIIllIlllIlIIlllI / 2.0F, var2 - this.lIIIllIllIIllIlllIlIIlllI, var3);
            }

            if (this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl()) {
                this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2 + var6, var3 + var7);
            } else {
                this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll(var1, var2 + var6, var3 + var7);
            }

        }
    }

    public String lllllIlIllIlIlllIIIlIIlIl() {
        return Ref.getLC().llllIIlIIlIIlIIllIIlIIllI().llIIIIIIIllIIllIlIllIIIIl();
    }

    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "[lunar.gg]";
    }

    public String IllIlIIllIIlllIIllIlIlIII() {
        return "na.lunar.gg";
    }

    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 40, 56, 62);
    }

    public List IIIIIIIIIIIIIIIllllIIlIIl() {
        return ImmutableList.of(this.IIlIllIlIIllIIlIlIllllllI = new BooleanSetting("server_icon", true));
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("serverAddressMod");
    }
}
