package com.moonsworth.lunar.bridge.optifine;

public interface ShadersBridge {
    boolean hasShadowPass();

    String getShaderPack();

    void setShaderPack(String var1);

    void useProgram(ProgramBridge var1);

    void beginBeacon();

    void endBeacon();

    String getPackNone();

    String getPackDefault();

    ProgramBridge getProgramBasic();

    SVertexFormatBridge getShaderVertexFormats();
}