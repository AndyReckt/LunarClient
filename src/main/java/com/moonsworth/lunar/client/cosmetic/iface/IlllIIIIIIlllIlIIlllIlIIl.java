package com.moonsworth.lunar.client.cosmetic.iface;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelRendererBridge;

public interface IlllIIIIIIlllIlIIlllIlIIl {
    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, float var2);

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(ModelRendererBridge modelRendererBridge, ModelRendererBridge modelRendererBridge2) {
        modelRendererBridge.bridge$setOffsetX(modelRendererBridge2.bridge$getOffsetX());
        modelRendererBridge.bridge$setOffsetY(modelRendererBridge2.bridge$getOffsetY());
        modelRendererBridge.bridge$setOffsetZ(modelRendererBridge2.bridge$getOffsetZ());
        modelRendererBridge.bridge$setRotateAngleX(modelRendererBridge2.bridge$getRotateAngleX());
        modelRendererBridge.bridge$setRotateAngleY(modelRendererBridge2.bridge$getRotateAngleY());
        modelRendererBridge.bridge$setRotateAngleZ(modelRendererBridge2.bridge$getRotateAngleZ());
        modelRendererBridge.bridge$setRotatePointX(modelRendererBridge2.bridge$getRotatePointX());
        modelRendererBridge.bridge$setRotatePointY(modelRendererBridge2.bridge$getRotatePointY());
        modelRendererBridge.bridge$setRotatePointZ(modelRendererBridge2.bridge$getRotatePointZ());
    }
}
 