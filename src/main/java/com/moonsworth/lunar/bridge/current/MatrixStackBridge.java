package com.moonsworth.lunar.bridge.current;

import com.moonsworth.lunar.bridge.minecraft.util.Quaternion;

/**
 * @author Decencies
 * @since 10/07/2021 17:10
 */
public interface MatrixStackBridge {
    public void lIlIlIlIlIIlIIlIIllIIIIIl(double var1, double var3, double var5);

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3);

    public void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, float var3);

    public void lIllIlIIIlIIIIIIIlllIlIll(float var1, float var2, float var3);

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl();

    public void IlllIIIIIIlllIlIIlllIlIIl();

    public void lIllIlIIIlIIIIIIIlllIlIll();

    public MatrixStackEntryBridge llIlllIIIllllIIlllIllIIIl();

    public MatrixStackBridge llllIIlIIlIIlIIllIIlIIllI();

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Quaternion var1);
}