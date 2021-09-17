package com.moonsworth.lunar.bridge.minecraft.client.multiplayer;

public interface ServerDataBridge {
    public String bridge$serverIP();

    public long bridge$getPingToServer();

    public boolean getSupportsLunar();

    public void setSupportsLunar(boolean var1);

    public boolean getCheckedLunar();

    public void setCheckedLunar(boolean var1);

    public String getLunarServer();

    public void setLunarServer(String var1);

    public String bridge$getBase64Icon();
}