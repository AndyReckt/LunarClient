package com.moonsworth.lunar.client.bridge.impl.type.util;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.CustomLayer;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.LayerRendererBridge;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;

public class CustomLayerRendererWrapper implements LayerRendererBridge, LayerRenderer {
    public RenderPlayer renderPlayer;
    public CustomLayer customLayer;

    public CustomLayerRendererWrapper(CustomLayer var1, RenderPlayer var2) {
        this.customLayer = var1;
        this.renderPlayer = var2;
    }

    public void doRenderLayer(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
        this.bridge$render((EntityLivingBaseBridge)var1, var2, var3, var4, var5, var6, var7, var8);
    }

    public boolean shouldCombineTextures() {
        return false;
    }

    public void bridge$render(EntityLivingBaseBridge var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
        this.customLayer.lIlIlIlIlIIlIIlIIllIIIIIl(var1, (ModelPlayerBridge)this.renderPlayer.getMainModel(), var2, var3, var4, var5, var6, var7, var8);
    }
}
