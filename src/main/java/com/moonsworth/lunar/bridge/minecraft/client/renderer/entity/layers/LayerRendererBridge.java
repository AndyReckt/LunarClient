package com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.current.lIllIlIIIlIIIIIIIlllIlIll;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;

public interface LayerRendererBridge {
    public void bridge$render(EntityLivingBaseBridge var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8);

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityLivingBaseBridge entityLivingBaseBridge, lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackBridge matrixStackBridge, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
    }
}
 