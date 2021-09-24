package com.moonsworth.lunar.bridge.optifine;

public interface ConfigBridge {
    boolean hasDynamicFov();

    boolean hasSmoothBiomes();

    boolean hasCustomColors();

    boolean hasCustomSky();

    boolean hasCustomFonts();

    boolean hasCustomItems();

    boolean hasShowCapes();

    boolean hasConnectedTextures();

    boolean hasNaturalTextures();

    boolean hasConnectedTexturesFancy();

    boolean hasFastRender();

    boolean hasTranslucentBlocksFancy();

    boolean hasShaders();

    void setFastRender(boolean var1);

    boolean isZooming();

    void setZooming(boolean var1);
}