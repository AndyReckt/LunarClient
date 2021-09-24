/*
 * Decompiled with CFR 0.150.
 */
package mchorse.mclib.utils;

import mchorse.mclib.utils.Interpolations;

public enum Interpolation {
    LINEAR("linear") {

        @Override
        public float interpolate(float f, float f2, float f3) {
            return Interpolations.lerp(f, f2, f3);
        }
    }
    ,
    QUAD_IN("quad_in") {

        @Override
        public float interpolate(float f, float f2, float f3) {
            return f + (f2 - f) * f3 * f3;
        }
    }
    ,
    QUAD_OUT("quad_out") {

        @Override
        public float interpolate(float f, float f2, float f3) {
            return f - (f2 - f) * f3 * (f3 - 2.0f);
        }
    }
    ,
    QUAD_INOUT("quad_inout") {

        @Override
        public float interpolate(float f, float f2, float f3) {
            if ((f3 *= 2.0f) < 1.0f) {
                return f + (f2 - f) / 2.0f * f3 * f3;
            }
            return f - (f2 - f) / 2.0f * ((f3 -= 1.0f) * (f3 - 2.0f) - 1.0f);
        }
    }
    ,
    CUBIC_IN("cubic_in") {

        @Override
        public float interpolate(float f, float f2, float f3) {
            return f + (f2 - f) * f3 * f3 * f3;
        }
    }
    ,
    CUBIC_OUT("cubic_out") {

        @Override
        public float interpolate(float f, float f2, float f3) {
            return f + (f2 - f) * ((f3 -= 1.0f) * f3 * f3 + 1.0f);
        }
    }
    ,
    CUBIC_INOUT("cubic_inout") {

        @Override
        public float interpolate(float f, float f2, float f3) {
            if ((f3 *= 2.0f) < 1.0f) {
                return f + (f2 - f) / 2.0f * f3 * f3 * f3;
            }
            return f + (f2 - f) / 2.0f * ((f3 -= 2.0f) * f3 * f3 + 2.0f);
        }
    }
    ,
    EXP_IN("exp_in") {

        @Override
        public float interpolate(float f, float f2, float f3) {
            return f + (f2 - f) * (float)Math.pow(2.0, 10.0f * (f3 - 1.0f));
        }
    }
    ,
    EXP_OUT("exp_out") {

        @Override
        public float interpolate(float f, float f2, float f3) {
            return f + (f2 - f) * (float)(-Math.pow(2.0, -10.0f * f3) + 1.0);
        }
    }
    ,
    EXP_INOUT("exp_inout") {

        @Override
        public float interpolate(float f, float f2, float f3) {
            if (f3 == 0.0f) {
                return f;
            }
            if (f3 == 1.0f) {
                return f2;
            }
            if ((f3 *= 2.0f) < 1.0f) {
                return f + (f2 - f) / 2.0f * (float)Math.pow(2.0, 10.0f * (f3 - 1.0f));
            }
            return f + (f2 - f) / 2.0f * (float)(-Math.pow(2.0, -10.0f * (f3 -= 1.0f)) + 2.0);
        }
    };

    public final String key;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    Interpolation(String key) {
        this.key = key;
    }

    public abstract float interpolate(float var1, float var2, float var3);
}

