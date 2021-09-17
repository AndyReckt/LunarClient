package com.moonsworth.lunar.bridge.optifine;

public interface ShadersBridge {
    public boolean hasShadowPass();

    public String getShaderPack();

    public void setShaderPack(String var1);

    public void useProgram(ProgramBridge var1);

    public void beginBeacon();

    public void endBeacon();

    public String getPackNone();

    public String getPackDefault();

    public ProgramBridge getProgramBasic();

    public SVertexFormatBridge getShaderVertexFormats();
}