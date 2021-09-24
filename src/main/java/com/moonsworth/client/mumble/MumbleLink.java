package com.moonsworth.client.mumble;

public class MumbleLink {
    public boolean ok = true;

    public MumbleLink() {
        try {
            System.loadLibrary("MumbleLink");
        } catch (Throwable var2) {
            var2.printStackTrace();
            this.ok = false;
        }

    }

    public native int init();

    public native void update(LinkData var1);

    public boolean isOk() {
        return this.ok;
    }
}
