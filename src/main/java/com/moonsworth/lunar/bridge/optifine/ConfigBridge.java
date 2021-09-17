package com.moonsworth.lunar.bridge.optifine;

public interface ConfigBridge {
    public boolean hasDynamicFov();

    public boolean hasSmoothBiomes();

    public boolean hasCustomColors();

    public boolean hasCustomSky();

    public boolean hasCustomFonts();

    public boolean hasCustomItems();

    public boolean hasShowCapes();

    public boolean hasConnectedTextures();

    public boolean hasNaturalTextures();

    public boolean hasConnectedTexturesFancy();

    public boolean hasFastRender();

    public boolean hasTranslucentBlocksFancy();

    public boolean hasShaders();

    public void setFastRender(boolean var1);

    public boolean isZooming();

    public void setZooming(boolean var1);
}