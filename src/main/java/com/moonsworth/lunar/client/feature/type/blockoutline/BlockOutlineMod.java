package com.moonsworth.lunar.client.feature.type.blockoutline;

import com.google.common.collect.ImmutableList;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.TessellatorBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.world.DrawSelectionBoundingBoxEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.setting.*;

import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.List;

public class BlockOutlineMod extends ConfigurableFeature {
    public ColorSetting llllIIlIIlIIlIIllIIlIIllI;
    public ColorSetting IlIlIlllllIlIIlIlIlllIlIl;
    public NumberSetting llIIIIIIIllIIllIlIllIIIIl;
    public BooleanSetting lIIIllIllIIllIlllIlIIlllI;
    public BooleanSetting IlllllIlIIIlIIlIIllIIlIll;
    public final TessellatorBridge llIIlIlIIIllIlIlIlIIlIIll = Bridge.getInstance().initTessellator();

    public BlockOutlineMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(DrawSelectionBoundingBoxEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(DrawSelectionBoundingBoxEvent var1) {
        if (this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl()) {
            this.IlllIIIIIIlllIlIIlllIlIIl(var1);
        }

        if (this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl()) {
            this.lIllIlIIIlIIIIIIIlllIlIll(var1);
        }

        var1.cancel();
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(DrawSelectionBoundingBoxEvent var1) {
        float var2 = this.llllIIlIIlIIlIIllIIlIIllI.IlllIIIIIIlllIlIIlllIlIIl(0.0F);
        float var3 = this.llllIIlIIlIIlIIllIIlIIllI.lIllIlIIIlIIIIIIIlllIlIll(0.0F);
        float var4 = this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl(0.0F);
        float var5 = this.llllIIlIIlIIlIIllIIlIIllI.llllIIlIIlIIlIIllIIlIIllI(0.0F);
        GL11.glLineWidth((Float)this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl());
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$begin(3, false, true);
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$end();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$begin(3, false, true);
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$end();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$begin(1, false, true);
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var2, var3, var4, var5).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$end();
        GL11.glLineWidth(2.0F);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(DrawSelectionBoundingBoxEvent var1) {
        ColorSetting var2 = this.IlIlIlllllIlIIlIlIlllIlIl;
        float var3 = var2.IlllIIIIIIlllIlIIlllIlIIl(0.0F);
        float var4 = var2.lIllIlIIIlIIIIIIIlllIlIll(0.0F);
        float var5 = var2.llIlllIIIllllIIlllIllIIIl(0.0F);
        float var6 = var2.llllIIlIIlIIlIIllIIlIIllI(0.0F) * 0.25F;
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$begin(7, false, true);
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$end();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$begin(7, false, true);
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$end();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$begin(7, false, true);
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$end();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$begin(7, false, true);
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$end();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$begin(7, false, true);
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$end();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$begin(7, false, true);
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIllIlIIIlIIIIIIIlllIlIll()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIlllIIIllllIIlllIllIIIl(), var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.IlIlIlllllIlIIlIlIlllIlIl()).bridge$color(var3, var4, var5, var6).bridge$endVertex();
        this.llIIlIlIIIllIlIlIlIIlIIll.bridge$end();
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llllIIlIIlIIlIIllIIlIIllI = new ColorSetting("block_outline_color", (new Color(0.0F, 0.0F, 0.0F, 0.4F)).getRGB()), this.IlIlIlllllIlIIlIlIlllIlIl = new ColorSetting("block_overlay_color", (new Color(0.0F, 0.0F, 0.0F, 0.4F)).getRGB()), this.llIIIIIIIllIIllIlIllIIIIl = new NumberSetting("block_outline_width", 2.0F, 1.0F, 10.0F), this.lIIIllIllIIllIlllIlIIlllI = new BooleanSetting("block_overlay", false), this.IlllllIlIIIlIIlIIllIIlIll = new BooleanSetting("block_outline", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Block Outline", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("block_outline", ImmutableList.of(ModuleCategory.ALL));
    }

    public ColorSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public ColorSetting lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public NumberSetting lIlIlIIIIIIllIlIIIIllIIII() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public BooleanSetting lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public BooleanSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }
}
