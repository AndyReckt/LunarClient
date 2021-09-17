package com.moonsworth.lunar.bridge.minecraft.client.model;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

public interface ModelRendererBridge {
    public void bridge$setTextureOffsetX(int var1);

    public void bridge$setTextureOffsetY(int var1);

    public void bridge$setOffsetX(float var1);

    public void bridge$setOffsetY(float var1);

    public void bridge$setOffsetZ(float var1);

    public float bridge$getOffsetX();

    public float bridge$getOffsetY();

    public float bridge$getOffsetZ();

    public void bridge$setRotateAngleX(float var1);

    public void bridge$setRotateAngleY(float var1);

    public void bridge$setRotateAngleZ(float var1);

    public float bridge$getRotateAngleX();

    public float bridge$getRotateAngleY();

    public float bridge$getRotateAngleZ();

    public void bridge$setRotatePointX(float var1);

    public void bridge$setRotatePointY(float var1);

    public void bridge$setRotatePointZ(float var1);

    public float bridge$getRotatePointX();

    public float bridge$getRotatePointY();

    public float bridge$getRotatePointZ();

    default public void bridge$postRender(float f) {
    }

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(MatrixStackBridge matrixStackBridge) {
    }

    public void bridge$render(float var1, ResourceLocationBridge var2);

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(MatrixStackBridge matrixStackBridge, float f, ResourceLocationBridge resourceLocationBridge) {
    }
}