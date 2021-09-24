package com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.cosmetic.part.AbstractCosmetic;
import com.moonsworth.lunar.client.cosmetic.type.CosmeticRendererFinal;
import com.moonsworth.lunar.client.cosmetic.type.HatCosmetic;
import com.moonsworth.lunar.client.cosmetic.type.HatCosmeticType;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

public class HatCosmeticUIComponent extends AbstractCosmeticUIComponent {
    public final ColorEase color = new ColorEase(0, -16777216);

    public HatCosmeticUIComponent(UIComponent uIComponent, Cosmetic cosmetic) {
        super(uIComponent, cosmetic);
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this.cosmetic.llIIIIIIIllIIllIlIllIIIIl();
    }

    @Override
    public String llIlllIIIllllIIlllIllIIIl() {
        return this.cosmetic.IlllIIIIIIlllIlIIlllIlIIl();
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        if (!this.ease.llllIIlIIlIIlIIllIIlIIllI()) {
            this.ease.lIllIlIIIlIIIIIIIlllIlIll();
        }
        float f3 = this.ease.getProgress();
        int n = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f, 0.0f, 0.0f, 0.2f);
        int n2 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.1f, 0.6f, 0.1f, 1.0f);
        int n3 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(1.0f, 1.0f, 1.0f, 0.2f);
        if (this.cosmetic == null) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 5.0f, n, n3, n);
        } else {
            AbstractCosmetic abstractCosmetic = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().IlllIIIIIIlllIlIIlllIlIIl(this.cosmetic.llllIIlIIlIIlIIllIIlIIllI());
            if (abstractCosmetic == null) {
                return;
            }
            float f4 = ColorUtil.llIIIIIIIllIIllIlIllIIIIl(this.color.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY))) * 0.6f;
            GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
            glStateManagerBridge.bridge$enableColorMaterial();
            glStateManagerBridge.bridge$pushMatrix();
            glStateManagerBridge.bridge$enableAlpha();
            glStateManagerBridge.bridge$enableBlend();
            glStateManagerBridge.bridge$color(1.0f, 1.0f, 1.0f, (0.4f + f4) * f3);
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableGUIStandardItemLighting();
            glStateManagerBridge.bridge$translate(this.x + this.width / 2.0f, this.y + (this.height - 3.0f), 50.0f);
            glStateManagerBridge.bridge$scale(-40.0, 40.0, 40.0);
            glStateManagerBridge.bridge$rotate(-22.5f, 1.0f, 0.0f, 0.0f);
            glStateManagerBridge.bridge$rotate(45.0f, 0.0f, 1.0f, 0.0f);
            glStateManagerBridge.bridge$rotate(180.0f, 0.0f, 1.0f, 0.0f);
            if (abstractCosmetic.llIIIIIIIllIIllIlIllIIIIl()) {
                Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(this.cosmetic.llllIIlIIlIIlIIllIIlIIllI());
            } else if (abstractCosmetic.lllIIIIIlllIIlIllIIlIIIlI() != null) {
                glStateManagerBridge.bridge$bindTexture(abstractCosmetic.lllIIIIIlllIIlIllIIlIIIlI().bridge$getGlTextureId());
            } else if (!abstractCosmetic.IlllllIlIIIlIIlIIllIIlIll()) {
                Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(abstractCosmetic.lIlIlIlIlIIlIIlIIllIIIIIl());
            } else {
                try {
                    glStateManagerBridge.bridge$bindTexture(abstractCosmetic.llIlllIIIllllIIlllIllIIIl().bridge$getGlTextureId());
                } catch (Exception exception) {
                    // empty catch block
                }
            }
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableDepth();
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableGUIStandardItemLighting();
            if (abstractCosmetic instanceof HatCosmetic) {
                CosmeticRendererFinal.lIlIlIlIlIIlIIlIIllIIIIIl(null, null, (HatCosmeticType)this.cosmetic, (HatCosmetic)abstractCosmetic, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, false, false);
            } else {
                com.moonsworth.lunar.client.cosmetic.au.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(null, null, this.cosmetic, abstractCosmetic, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false);
            }
            glStateManagerBridge.bridge$disableBlend();
            glStateManagerBridge.bridge$disableAlpha();
            glStateManagerBridge.bridge$popMatrix();
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$disableStandardItemLighting();
            glStateManagerBridge.bridge$disableRescaleNormal();
            glStateManagerBridge.bridge$disableTexture2D();
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 5.0f, n, this.lIllIlIIIlIIIIIIIlllIlIll() ? n2 : n3, 0);
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}
