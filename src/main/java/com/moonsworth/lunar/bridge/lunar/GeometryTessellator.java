package com.moonsworth.lunar.bridge.lunar;

import com.moonsworth.lunar.bridge.minecraft.util.Vector3d;

public interface GeometryTessellator {
    void bridge$setTranslation(double var1, double var3, double var5);

default void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.bridge$begin(7);
    }

default void IlllIIIIIIlllIlIIlllIlIIl() {
        this.bridge$begin(1);
    }

    void bridge$begin(int var1);

    void bridge$draw();

    void bridge$setDelta(double var1);

    void bridge$drawCuboid(Vector3d var1, int var2, int var3);

    void bridge$drawCuboid(Vector3d var1, Vector3d var2, int var3, int var4);

    void bridge$drawLines(Vector3d var1, Vector3d var2, int var3, int var4);

    void bridge$drawLines(Vector3d var1, int var2, int var3);

    boolean bridge$isDrawing();
}
