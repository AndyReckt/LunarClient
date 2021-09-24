package com.moonsworth.lunar.bridge.minecraft.client.model;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

public interface ModelRendererBridge {
    void bridge$setTextureOffsetX(int var1);

    void bridge$setTextureOffsetY(int var1);

    void bridge$setOffsetX(float var1);

    void bridge$setOffsetY(float var1);

    void bridge$setOffsetZ(float var1);

    float bridge$getOffsetX();

    float bridge$getOffsetY();

    float bridge$getOffsetZ();

    void bridge$setRotateAngleX(float var1);

    void bridge$setRotateAngleY(float var1);

    void bridge$setRotateAngleZ(float var1);

    float bridge$getRotateAngleX();

    float bridge$getRotateAngleY();

    float bridge$getRotateAngleZ();

    void bridge$setRotatePointX(float var1);

    void bridge$setRotatePointY(float var1);

    void bridge$setRotatePointZ(float var1);

    float bridge$getRotatePointX();

    float bridge$getRotatePointY();

    float bridge$getRotatePointZ();

default void bridge$postRender(float f) {
    }

default void lIlIlIlIlIIlIIlIIllIIIIIl(MatrixStackBridge matrixStackBridge) {
    }

    void bridge$render(float var1, ResourceLocationBridge var2);

default void lIlIlIlIlIIlIIlIIllIIIIIl(MatrixStackBridge matrixStackBridge, float f, ResourceLocationBridge resourceLocationBridge) {
    }
}