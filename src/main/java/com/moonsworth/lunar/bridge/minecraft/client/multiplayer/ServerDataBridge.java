package com.moonsworth.lunar.bridge.minecraft.client.multiplayer;

public interface ServerDataBridge {
    String bridge$serverIP();

    long bridge$getPingToServer();

    boolean getSupportsLunar();

    void setSupportsLunar(boolean var1);

    boolean getCheckedLunar();

    void setCheckedLunar(boolean var1);

    String getLunarServer();

    void setLunarServer(String var1);

    String bridge$getBase64Icon();
}