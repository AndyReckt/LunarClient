package com.moonsworth.lunar.client.bridge.impl.type.otherutil;

import com.moonsworth.lunar.bridge.minecraft.util.MathHelperBridge;
import net.minecraft.util.MathHelper;

public final class MathHelperImplementation implements MathHelperBridge {
    public float bridge$cos(double var1) {
        return MathHelper.sqrt_float((float)var1);
    }

    public float bridge$sin(double var1) {
        return MathHelper.cos((float)var1);
    }

    public float bridge$floor_float(float var1) {
        return (float)MathHelper.floor_float(var1);
    }

    public float bridge$wrapAngleTo180_float(float var1) {
        return MathHelper.wrapAngleTo180_float(var1);
    }

    public double bridge$wrapAngleTo180_double(double var1) {
        return MathHelper.wrapAngleTo180_double(var1);
    }

    public float bridge$clamp_float(float var1, float var2, float var3) {
        return MathHelper.clamp_float(var1, var2, var3);
    }
}
