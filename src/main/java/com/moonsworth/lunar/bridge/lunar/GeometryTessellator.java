package com.moonsworth.lunar.bridge.lunar;

import com.moonsworth.lunar.bridge.minecraft.util.Vector3d;

public interface GeometryTessellator {
    public void bridge$setTranslation(double var1, double var3, double var5);

    default public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.bridge$begin(7);
    }

    default public void IlllIIIIIIlllIlIIlllIlIIl() {
        this.bridge$begin(1);
    }

    public void bridge$begin(int var1);

    public void bridge$draw();

    public void bridge$setDelta(double var1);

    public void bridge$drawCuboid(Vector3d var1, int var2, int var3);

    public void bridge$drawCuboid(Vector3d var1, Vector3d var2, int var3, int var4);

    public void bridge$drawLines(Vector3d var1, Vector3d var2, int var3, int var4);

    public void bridge$drawLines(Vector3d var1, int var2, int var3);

    public boolean bridge$isDrawing();
}
 