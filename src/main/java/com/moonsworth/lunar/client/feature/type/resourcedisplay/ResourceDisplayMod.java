package com.moonsworth.lunar.client.feature.type.resourcedisplay;

import com.google.common.collect.ImmutableList;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.DynamicTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.AbstractResourcePackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.gui.SwapPackEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Optional;

public class ResourceDisplayMod extends SimpleHudMod {
    public BooleanSetting IllIIIlllIIIlIlllIlIIlIII;
    public ResourceLocationBridge IIlIllIlIIllIIlIlIllllllI;
    public final ResourceLocationBridge lIIIlllIIIIllllIlIIIlIIll;

    public ResourceDisplayMod() {
        super(false, HudModPosition.TOP_RIGHT);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(SwapPackEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        DynamicTextureBridge var1 = Bridge.getInstance().initDynamicTexture(Ref.getMinecraft().bridge$getMcDefaultResourcePack().bridge$getPackImage().get());
        this.lIIIlllIIIIllllIlIIIlIIll = Ref.getMinecraft().bridge$getTextureManager().bridge$getDynamicTextureLocation("default-pack-display-thumbnail", var1);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1) {
        if (var1) {
            this.IIlIllIlIIllIIlIlIllllllI = this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft().bridge$getSelectedResourcePack());
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(SwapPackEvent var1) {
        this.IIlIllIlIIllIIlIlIllllllI = this.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl(AbstractResourcePackBridge var1) {
        Optional<BufferedImage> var2 = var1.bridge$getPackImage();
        if (var2.isPresent()) {
            DynamicTextureBridge var3 = Bridge.getInstance().initDynamicTexture(var2.get());
            return Ref.getMinecraft().bridge$getTextureManager().bridge$getDynamicTextureLocation("pack-display-thumbnail", var3);
        } else {
            return this.lIIIlllIIIIllllIlIIIlIIll;
        }
    }

    public boolean IIIIlIllIllIlIIIIIlIlIlIl() {
        return true;
    }

    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "Default";
    }

    public List<AbstractSetting<?>> IIIIIIIIIIIIIIIllllIIlIIl() {
        return ImmutableList.of(this.IllIIIlllIIIlIlllIlIIlIII = new BooleanSetting("pack_icon", true));
    }

    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(12, 24, 64, 60, 100, 300);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1, float var2, float var3) {
        if (var1 != null && !var1.isEmpty()) {
            this.IlllIIIIIIlllIlIIlllIlIIl(Ref.getFontRenderer().bridge$getStringWidth(var1) + 8.0F + (float)(this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl() ? (Integer)this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl() : 0), (float)(Integer)this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
            float var4 = this.llIIIIIIIllIIllIlIllIIIIl;
            if (this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl()) {
                var2 += this.lIIIllIllIIllIlllIlIIlllI;
                var4 -= this.lIIIllIllIIllIlllIlIIlllI;
            }

            float var5 = var4 / 2.0F;
            float var6 = this.lIIIllIllIIllIlllIlIIlllI / 1.88F - (float)Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() / 2.0F + 0.5F;
            if (this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl()) {
                float var7 = this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl() ? this.lIIIllIllIIllIlllIlIIlllI : 0.0F;
                this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var7, var3, var4 + var7, this.lIIIllIllIIllIlllIlIIlllI);
                if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
                    float var8 = (Float)this.lllllIllIlIIlIIlIIIlllIlI.llIlllIIIllllIIlllIllIIIl();
                    this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var7, var3 - var8, var4 + var7, var8);
                    this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var7, var3 + this.lIIIllIllIIllIlllIlIIlllI, var4 + var7, var8);
                    this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var7 - var8, var3 - var8, var8, this.lIIIllIllIIllIlllIlIIlllI + var8 * 2.0F);
                    this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var7 + var4 + var7, var3 - var8, var8, this.lIIIllIllIIllIlllIlIIlllI + var8 * 2.0F);
                }
            }

            if (this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl()) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlIIllIIlIlIllllllI, this.lIIIllIllIIllIlllIlIIlllI / 2.0F, var2 - this.lIIIllIllIIllIlllIlIIlllI, var3);
            }

            if (this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl()) {
                this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2 + var5, var3 + var6);
            } else {
                this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll(var1, var2 + var5, var3 + var6);
            }

        }
    }

    public String lllllIlIllIlIlllIIIlIIlIl() {
        AbstractResourcePackBridge var1 = Ref.getMinecraft().bridge$getSelectedResourcePack();
        return var1 != null && !var1.bridge$getPackName().equals("textures") ? var1.bridge$getPackName().replace(".zip", "") : "Default";
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("resource_display", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.NEW, ModuleCategory.HUD));
    }
}
