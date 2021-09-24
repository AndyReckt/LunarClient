/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  lunar.a.Bridge
 */
package mchorse.emoticons.skin_n_bones.api.bobj;

import com.moonsworth.lunar.client.bridge.Bridge;
import mchorse.mclib.utils.Interpolations;

public class BOBJKeyframe {
    public int frame;
    public float value;
    public Interpolation interpolation = Interpolation.LINEAR;
    public float leftX;
    public float leftY;
    public float rightX;
    public float rightY;

    public static BOBJKeyframe parse(String[] floats) {
        if (floats.length == 8) {
            float f = Float.parseFloat(floats[4]);
            float f2 = Float.parseFloat(floats[5]);
            float f3 = Float.parseFloat(floats[6]);
            float f4 = Float.parseFloat(floats[7]);
            return new BOBJKeyframe(Integer.parseInt(floats[1]), Float.parseFloat(floats[2]), floats[3], f, f2, f3, f4);
        }
        if (floats.length == 4) {
            return new BOBJKeyframe(Integer.parseInt(floats[1]), Float.parseFloat(floats[2]), floats[3]);
        }
        if (floats.length == 3) {
            return new BOBJKeyframe(Integer.parseInt(floats[1]), Float.parseFloat(floats[2]));
        }
        return null;
    }

    public static Interpolation interpolationFromString(String string) {
        if (string.equals("CONSTANT")) {
            return Interpolation.CONSTANT;
        }
        if (string.equals("BEZIER")) {
            return Interpolation.BEZIER;
        }
        return Interpolation.LINEAR;
    }

    public static float lerp(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }

    public BOBJKeyframe(int n, float f) {
        this.frame = n;
        this.value = f;
    }

    public BOBJKeyframe(int n, float f, String string) {
        this(n, f);
        this.interpolation = BOBJKeyframe.interpolationFromString(string);
    }

    public BOBJKeyframe(int n, float f, String string, float f2, float f3, float f4, float f5) {
        this(n, f, string);
        this.leftX = f2;
        this.leftY = f3;
        this.rightX = f4;
        this.rightY = f5;
    }

    public float interpolate(float f, BOBJKeyframe bOBJKeyframe) {
        return this.interpolation.interpolate(this, f, bOBJKeyframe);
    }

    public enum Interpolation {
        CONSTANT{

            @Override
            public float interpolate(BOBJKeyframe bOBJKeyframe, float f, BOBJKeyframe bOBJKeyframe2) {
                return bOBJKeyframe.value;
            }
        },
        LINEAR{

            @Override
            public float interpolate(BOBJKeyframe bOBJKeyframe, float f, BOBJKeyframe bOBJKeyframe2) {
                return BOBJKeyframe.lerp(bOBJKeyframe.value, bOBJKeyframe2.value, f);
            }
        }
        ,
        BEZIER{

            @Override
            public float interpolate(BOBJKeyframe bOBJKeyframe, float f, BOBJKeyframe bOBJKeyframe2) {
                if (f <= 0.0f) {
                    return bOBJKeyframe.value;
                }
                if (f >= 1.0f) {
                    return bOBJKeyframe2.value;
                }
                float f2 = bOBJKeyframe2.frame - bOBJKeyframe.frame;
                float f3 = bOBJKeyframe2.value - bOBJKeyframe.value;
                if (f3 == 0.0f) {
                    f3 = 1.0E-5f;
                }
                float f4 = (bOBJKeyframe.rightX - (float)bOBJKeyframe.frame) / f2;
                float f5 = (bOBJKeyframe.rightY - bOBJKeyframe.value) / f3;
                float f6 = (bOBJKeyframe2.leftX - (float)bOBJKeyframe.frame) / f2;
                float f7 = (bOBJKeyframe2.leftY - bOBJKeyframe.value) / f3;
                float f8 = 5.0E-4f;
                f8 = f3 == 0.0f ? f8 : Math.max(Math.min(f8, 1.0f / f3 * f8), 1.0E-5f);
                f4 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$clamp_float(f4, 0.0f, 1.0f);
                f6 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$clamp_float(f6, 0.0f, 1.0f);
                return Interpolations.bezier(0.0f, f5, f7, 1.0f, Interpolations.bezierX(f4, f6, f, f8)) * f3 + bOBJKeyframe.value;
            }
        };


        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        Interpolation() {
        }

        public abstract float interpolate(BOBJKeyframe var1, float var2, BOBJKeyframe var3);
    }
}

