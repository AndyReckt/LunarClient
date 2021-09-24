package com.moonsworth.client.mumble;

public final class MumbleVec {
    public double xCoord;
    public double yCoord;
    public double zCoord;

    public MumbleVec(double var1, double var3, double var5) {
        this.xCoord = var1;
        this.yCoord = var3;
        this.zCoord = var5;
    }

    public String toString() {
        return "MumbleVec(xCoord=" + this.xCoord + ", yCoord=" + this.yCoord + ", zCoord=" + this.zCoord + ")";
    }
}