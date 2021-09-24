package com.moonsworth.lunar.bridge.current;

import com.moonsworth.lunar.bridge.minecraft.util.Quaternion;

/**
 * @author Decencies
 * @since 10/07/2021 17:10
 */
public interface MatrixStackBridge {
    void lIlIlIlIlIIlIIlIIllIIIIIl(double var1, double var3, double var5);

    void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3);

    void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, float var3);

    void lIllIlIIIlIIIIIIIlllIlIll(float var1, float var2, float var3);

    boolean lIlIlIlIlIIlIIlIIllIIIIIl();

    void IlllIIIIIIlllIlIIlllIlIIl();

    void lIllIlIIIlIIIIIIIlllIlIll();

    MatrixStackEntryBridge llIlllIIIllllIIlllIllIIIl();

    MatrixStackBridge llllIIlIIlIIlIIllIIlIIllI();

    void lIlIlIlIlIIlIIlIIllIIIIIl(Quaternion var1);
}