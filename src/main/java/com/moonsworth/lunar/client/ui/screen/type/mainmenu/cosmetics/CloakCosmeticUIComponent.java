package com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics;

import com.moonsworth.lunar.bridge.lunar.RenderUtilBridge;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.AbstractTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.CustomTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.CustomTextureHolder;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.LoadableTickingTexture;
import com.moonsworth.lunar.bridge.minecraft.util.ModelCloak;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.CloakCosmetic;
import com.moonsworth.lunar.client.cosmetic.CosmeticType;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.texture.AnimationTickingTexture;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

import java.io.IOException;

public class CloakCosmeticUIComponent extends AbstractCosmeticUIComponent {
    public final ColorEase llIlIIIllIIlIllIllIllllIl = new ColorEase(0, -16777216);
    public static ModelCloak IllIllIIIllIIIlIlIlIIIIll;
    public boolean IIlIllIlllllllIIlIIIllIIl;
    public LoadableTickingTexture lIIlIlllIlIlIIIlllIIlIIII;

    public CloakCosmeticUIComponent(UIComponent uIComponent, CloakCosmetic cloakCosmetic) {
        super(uIComponent, cloakCosmetic);
        IllIllIIIllIIIlIlIlIIIIll = Bridge.getInstance().initModelCloak(1, 64, 32);
        if (cloakCosmetic.llIIIIIIIllIIllIlIllIIIIl()) {
            this.mc.bridge$getTextureManager().bridge$bindTexture(cloakCosmetic.llllIIlIIlIIlIIllIIlIIllI());
        }
        if (cloakCosmetic.llIIIIIIIllIIllIlIllIIIIl() || Ref.getLC().IIlIllIlIIllIIlIlIllllllI().llIIIlllIIlllIllllIlIllIl().containsKey(cloakCosmetic.llllIIlIIlIIlIIllIIlIIllI())) {
            this.lIIlIlllIlIlIIIlllIIlIIII = LoadableTickingTexture.lIlIlIlIlIIlIIlIIllIIIIIl;
            return;
        }
        this.lIIlIlllIlIlIIIlllIIlIIII = Bridge.getInstance().initAsyncTexture(cloakCosmetic.llllIIlIIlIIlIIllIIlIIllI());
        try {
            this.lIIlIlllIlIlIIIlllIIlIIII.bridge$loadTexture(Ref.getMinecraft().bridge$getResourceManager());
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
    }

    @Override
    public void onUpdateScreen() {
        this.lIIlIlllIlIlIIIlllIIlIIII.bridge$tick();
    }

    @Override
    public void onGuiClosed() {
        this.lIIlIlllIlIlIIIlllIIlIIII.bridge$deleteGlTexture();
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        RenderUtilBridge renderUtilBridge = Bridge.IlllllIlIIIlIIlIIllIIlIll();
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        float f3 = this.ease.getProgress();
        int n = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f, 0.0f, 0.0f, 0.2f);
        int n2 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.1f, 0.6f, 0.1f, 1.0f);
        int n3 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(1.0f, 1.0f, 1.0f, 0.2f);
        if (this.cosmetic == null) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 5.0f, n, n3, n);
        } else {
            float f4 = ColorUtil.llIIIIIIIllIIllIlIllIIIIl(this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY))) * 0.3f;
            if (this.lIIlIlllIlIlIIIlllIIlIIII.bridge$ready()) {
                if (!this.ease.llllIIlIIlIIlIIllIIlIIllI()) {
                    this.ease.lIllIlIIIlIIIIIIIlllIlIll();
                }
                if (this.cosmetic.lIllIlIIIlIIIIIIIlllIlIll() == CosmeticType.CLOAK) {
                    this.mc.bridge$getTextureManager().bridge$bindTexture(this.cosmetic.llllIIlIIlIIlIIllIIlIIllI());
                    glStateManagerBridge.bridge$enableColorMaterial();
                    glStateManagerBridge.bridge$pushMatrix();
                    glStateManagerBridge.bridge$enableAlpha();
                    glStateManagerBridge.bridge$enableBlend();
                    glStateManagerBridge.bridge$color(1.0f, 1.0f, 1.0f, (0.7f + f4) * f3);
                    glStateManagerBridge.bridge$translate(this.x + this.width / 2.0f, this.y + this.height / 4.0f / 2.0f + 1.0f, 50.0f);
                    glStateManagerBridge.bridge$rotate(-22.5f, 1.0f, 0.0f, 0.0f);
                    if (this.cosmetic.llIIIIIIIllIIllIlIllIIIIl()) {
                        glStateManagerBridge.bridge$rotate(-225.0f + (float)Math.toDegrees((double)Ref.getMinecraft().bridge$getSystemTime() / 1000.0), 0.0f, 1.0f, 0.0f);
                    } else {
                        glStateManagerBridge.bridge$rotate(-225.0f, 0.0f, 1.0f, 0.0f);
                    }
                    float f5 = this.height - this.height / 4.0f - 1.0f;
                    glStateManagerBridge.bridge$scale(-f5, f5, f5);
                    AbstractTextureBridge abstractTextureBridge = Ref.getMinecraft().bridge$getTextureManager().bridge$getTexture(this.cosmetic.llllIIlIIlIIlIIllIIlIIllI());
                    if (abstractTextureBridge instanceof CustomTextureHolder) {
                        CustomTextureBridge customTextureBridge = ((CustomTextureHolder)abstractTextureBridge).getCustomTexture();
                        if (customTextureBridge instanceof AnimationTickingTexture) {
                            AnimationTickingTexture animationTickingTexture = (AnimationTickingTexture)customTextureBridge;
                            ModelCloak modelCloak = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().llIIIlllIIlllIllllIlIllIl().get(this.cosmetic.llllIIlIIlIIlIIllIIlIIllI());
                            if (modelCloak != null) {
                                modelCloak.updateUVPosition(animationTickingTexture.lIlIlIlIlIIlIIlIIllIIIIIl() * animationTickingTexture.IlllIIIIIIlllIlIIlllIlIIl(), animationTickingTexture.IlllIIIIIIlllIlIIlllIlIIl());
                                modelCloak.render(animationTickingTexture.lIlIlIlIlIIlIIlIIllIIIIIl(), 0.0315f);
                            }
                        }
                    } else if (Bridge.getMinecraftVersion().lIlIlIlIlIIlIIlIIllIIIIIl()) {
                        IllIllIIIllIIIlIlIlIIIIll.render(1, 0.0315f);
                    } else {
                        Ref.getMinecraft().bridge$getRenderManager().bridge$defaultPlayerRenderer().bridge$getMainModel().bridge$cloak().bridge$render(0.0625f, this.cosmetic.llllIIlIIlIIlIIllIIlIIllI());
                    }
                    glStateManagerBridge.bridge$disableBlend();
                    glStateManagerBridge.bridge$disableAlpha();
                    glStateManagerBridge.bridge$popMatrix();
                    renderUtilBridge.bridge$disableStandardItemLighting();
                    glStateManagerBridge.bridge$disableRescaleNormal();
                    if (Bridge.getMinecraftVersion().IlllIIIIIIlllIlIIlllIlIIl()) {
                        glStateManagerBridge.bridge$setActiveTexture(Bridge.lIlIIIIIIlIIIllllIllIIlII().bridge$lightmapTexUnit());
                        glStateManagerBridge.bridge$disableTexture2D();
                        glStateManagerBridge.bridge$setActiveTexture(Bridge.lIlIIIIIIlIIIllllIllIIlII().bridge$defaultTexUnit());
                    }
                } else {
                    glStateManagerBridge.bridge$color(1.0f, 1.0f, 1.0f, (0.7f + f4) * f3);
                    AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.cosmetic.IlIlIlllllIlIIlIlIlllIlIl(), this.x + 1.0f, this.y + 1.0f, this.width - 2.0f, this.height - 2.0f);
                }
            }
            glStateManagerBridge.bridge$color(1.0f, 1.0f, 1.0f, (0.7f + f4) * f3);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 5.0f, n, this.cosmetic.llIIIIIIIllIIllIlIllIIIIl() ? n2 : n3, 0);
        }
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this.cosmetic.llIIIIIIIllIIllIlIllIIIIl();
    }

    @Override
    public String llIlllIIIllllIIlllIllIIIl() {
        return this.cosmetic.IlllIIIIIIlllIlIIlllIlIIl();
    }
}
