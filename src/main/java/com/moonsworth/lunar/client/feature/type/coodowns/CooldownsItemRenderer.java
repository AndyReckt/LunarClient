package com.moonsworth.lunar.client.feature.type.coodowns;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class CooldownsItemRenderer {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public long IlllIIIIIIlllIlIIlllIlIIl;
    public long lIllIlIIIlIIIIIIIlllIlIll;
    public int llIlllIIIllllIIlllIllIIIl;
    public ItemStackBridge llllIIlIIlIIlIIllIIlIIllI;

    public CooldownsItemRenderer(String string, ItemStackBridge itemStackBridge, long l) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = l;
        this.lIllIlIIIlIIIIIIIlllIlIll = System.currentTimeMillis();
        this.llllIIlIIlIIlIIllIIlIIllI = itemStackBridge;
        this.llIlllIIIllllIIlllIllIIIl = Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItemID(itemStackBridge.bridge$getItem());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        int n = 17;
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        RenderItemBridge renderItemBridge = Ref.getMinecraft().bridge$getRenderItem();
        float f3 = renderItemBridge.bridge$getZLevel();
        renderItemBridge.bridge$setZLevel(-200.0f);
        float f4 = 1.35f;
        glStateManagerBridge.bridge$pushMatrix();
        glStateManagerBridge.bridge$translate(-0.5f, -1.0f, 0.0f);
        glStateManagerBridge.bridge$scale(f4, f4, f4);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableStandardItemLighting();
        renderItemBridge.bridge$renderItemAndEffectIntoGUI(this.llllIIlIIlIIlIIllIIlIIllI, (int)((f + (float)(n / 2)) / f4), (int)((f2 + (float)(n / 2)) / f4));
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$disableStandardItemLighting();
        glStateManagerBridge.bridge$popMatrix();
        renderItemBridge.bridge$setZLevel(f3);
        double d = this.IlllIIIIIIlllIlIIlllIlIIl - (System.currentTimeMillis() - this.lIllIlIIIlIIIIIIIlllIlIll);
        if (d <= 0.0) {
            return;
        }
        glStateManagerBridge.bridge$color(0.0f, 0.0f, 0.0f, 0.2f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f + (float)n, f2 + (float)n, n, 0.0, (float)this.IlllIIIIIIlllIlIIlllIlIIl / 3.95f, (int)this.IlllIIIIIIlllIlIIlllIlIIl, d);
        glStateManagerBridge.bridge$color(0.9f, 0.9f, 0.9f, 1.0f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f + (float)n, f2 + (float)n, (float)n + 0.1f, n - 2, (float)this.IlllIIIIIIlllIlIIlllIlIIl / 3.95f, (int)this.IlllIIIIIIlllIlIIlllIlIIl, this.IlllIIIIIIlllIlIIlllIlIIl);
        glStateManagerBridge.bridge$color(0.35f, 0.35f, 0.35f, 0.6f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f + (float)n, f2 + (float)n, (float)n + 0.1f, n - 2, (float)this.IlllIIIIIIlllIlIIlllIlIIl / 3.95f, (int)this.IlllIIIIIIlllIlIIlllIlIIl, d);
        String string = String.format("%.1f", d / 1000.0);
        float f5 = FontRegistry.lIlIIIIIIlIIIllllIllIIlII().IlllIIIIIIlllIlIIlllIlIIl(string);
        FontRegistry.lIlIIIIIIlIIIllllIllIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(string, f + (float)n - f5 / 2.0f, f2 + (float)(n / 2) + 4.0f, -1, 0x6F000000);
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll < System.currentTimeMillis() - this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(long l) {
        this.IlllIIIIIIlllIlIIlllIlIIl = l;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl() {
        this.lIllIlIIIlIIIIIIIlllIlIll = System.currentTimeMillis();
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public long llIlllIIIllllIIlllIllIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int llllIIlIIlIIlIIllIIlIIllI() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }
}
