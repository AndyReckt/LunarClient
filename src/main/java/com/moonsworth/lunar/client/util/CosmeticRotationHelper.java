package com.moonsworth.lunar.client.util;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vector3f;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public interface CosmeticRotationHelper {
    static CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticRotationHelper... var0) {
        return new CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl(Arrays.asList(var0));
    }

    static CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(float var0, float var1, float var2, float var3) {
        return new CosmeticRotationHelper.lIllIlIIIlIIIIIIIlllIlIll(var0, var1, var2, var3);
    }

    static CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(float var0, float var1, float var2) {
        return new CosmeticRotationHelper.lIllIlIIIlIIIIIIIlllIlIll(0.0F, var0, var1, var2) {
            public float lIlIlIlIlIIlIIlIIllIIIIIl = 0.0F;

            public void transform(AbstractClientPlayerBridge var1, float var2) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate((this.lIlIlIlIlIIlIIlIIllIIIIIl + var2) * 57.295776F, this.IlllIIIIIIlllIlIIlllIlIIl[1], this.IlllIIIIIIlllIlIIlllIlIIl[2], this.IlllIIIIIIlllIlIIlllIlIIl[3]);
            }
        };
    }

    static CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(Vector3f var0) {
        return new CosmeticRotationHelper.llllIIlIIlIIlIIllIIlIIllI(var0);
    }

    static CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(float var0) {
        return lIlIlIlIlIIlIIlIIllIIIIIl((var1) -> {
            return var1 != null ? new Vector3f(0.0F, (float) (-((double) var1.bridge$getEyeHeight() + (var1.bridge$isSneaking() ? 0.25D : 0.0D))) * var0, 0.0F) : null;
        });
    }

    static CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(final Function<EntityPlayerBridge, Vector3f> var0) {
        return new CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((Vector3f) null) {
            public void transform(AbstractClientPlayerBridge var1, float var2) {
                Vector3f var3 = (Vector3f) var0.apply(var1);
                if (var3 != null) {
                    Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(var3.llIIIIIIIllIIllIlIllIIIIl, var3.lIIIllIllIIllIlllIlIIlllI, var3.IlllllIlIIIlIIlIIllIIlIll);
                }

            }

            public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, MatrixStackBridge var2, float var3) {
                Vector3f var4 = (Vector3f) var0.apply(var1);
                if (var4 != null) {
                    var2.lIlIlIlIlIIlIIlIIllIIIIIl((double) var4.llIIIIIIIllIIllIlIllIIIIl, (double) var4.lIIIllIllIIllIlllIlIIlllI, (double) var4.IlllllIlIIIlIIlIIllIIlIll);
                }

            }
        };
    }

    static CosmeticRotationHelper IlllIIIIIIlllIlIIlllIlIIl(Vector3f var0) {
        return new CosmeticRotationHelper.llIlllIIIllllIIlllIllIIIl(var0);
    }

    static CosmeticRotationHelper IlllIIIIIIlllIlIIlllIlIIl(final Function<EntityPlayerBridge, Vector3f> var0) {
        return new CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((Vector3f) null) {
            public void transform(AbstractClientPlayerBridge var1, float var2) {
                Vector3f var3 = (Vector3f) var0.apply(var1);
                if (var3 != null) {
                    Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale((double) var3.llIIIIIIIllIIllIlIllIIIIl, (double) var3.lIIIllIllIIllIlllIlIIlllI, (double) var3.IlllllIlIIIlIIlIIllIIlIll);
                }

            }

            public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, MatrixStackBridge var2, float var3) {
                Vector3f var4 = (Vector3f) var0.apply(var1);
                if (var4 != null) {
                    var2.lIlIlIlIlIIlIIlIIllIIIIIl(var4.llIIIIIIIllIIllIlIllIIIIl, var4.lIIIllIllIIllIlllIlIIlllI, var4.IlllllIlIIIlIIlIIllIIlIll);
                }

            }
        };
    }

    static CosmeticRotationHelper lIllIlIIIlIIIIIIIlllIlIll(Vector3f var0) {
        return lIlIlIlIlIIlIIlIIllIIIIIl(lIlIlIlIlIIlIIlIIllIIIIIl((var1) -> {
            if (var1 != null && var1.bridge$isSneaking()) {
                return !Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(var1) ? new Vector3f(0.0F, -var1.bridge$getEyeHeight() + 0.25F, 0.0F) : new Vector3f(0.0F, -var1.bridge$getEyeHeight(), 0.0F);
            } else {
                return var0;
            }
        }), lIlIlIlIlIIlIIlIIllIIIIIl(180.0F, 0.0F, 1.0F, 0.0F));
    }

    static CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(final BiConsumer<AbstractClientPlayerBridge, MatrixStackBridge> var0) {
        return new CosmeticRotationHelper() {
            public void transform(AbstractClientPlayerBridge var1, float var2) {
            }

            public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, MatrixStackBridge var2, float var3) {
                var0.accept(var1, var2);
            }
        };
    }

    void transform(AbstractClientPlayerBridge var1, float var2);

    default void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, MatrixStackBridge var2, float var3) {
    }

    public static class IlllIIIIIIlllIlIIlllIlIIl implements CosmeticRotationHelper {
        public List<CosmeticRotationHelper> lIlIlIlIlIIlIIlIIllIIIIIl;

        public IlllIIIIIIlllIlIIlllIlIIl(List<CosmeticRotationHelper> var1) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
        }

        public void transform(AbstractClientPlayerBridge var1, float var2) {
            for (CosmeticRotationHelper var4 : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                var4.transform(var1, var2);
            }
        }
    }

    public static class llIlllIIIllllIIlllIllIIIl extends CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl {
        public llIlllIIIllllIIlllIllIIIl(Vector3f var1) {
            super(var1);
        }

        public void transform(AbstractClientPlayerBridge var1, float var2) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale((double) this.IlllIIIIIIlllIlIIlllIlIIl.llIIIIIIIllIIllIlIllIIIIl, (double) this.IlllIIIIIIlllIlIIlllIlIIl.lIIIllIllIIllIlllIlIIlllI, (double) this.IlllIIIIIIlllIlIIlllIlIIl.IlllllIlIIIlIIlIIllIIlIll);
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, MatrixStackBridge var2, float var3) {
            var2.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.llIIIIIIIllIIllIlIllIIIIl, this.IlllIIIIIIlllIlIIlllIlIIl.lIIIllIllIIllIlllIlIIlllI, this.IlllIIIIIIlllIlIIlllIlIIl.IlllllIlIIIlIIlIIllIIlIll);
        }
    }

    public static class llllIIlIIlIIlIIllIIlIIllI extends CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl {
        public llllIIlIIlIIlIIllIIlIIllI(Vector3f var1) {
            super(var1);
        }

        public void transform(AbstractClientPlayerBridge var1, float var2) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(this.IlllIIIIIIlllIlIIlllIlIIl.llIIIIIIIllIIllIlIllIIIIl, this.IlllIIIIIIlllIlIIlllIlIIl.lIIIllIllIIllIlllIlIIlllI, this.IlllIIIIIIlllIlIIlllIlIIl.IlllllIlIIIlIIlIIllIIlIll);
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, MatrixStackBridge var2, float var3) {
            var2.lIlIlIlIlIIlIIlIIllIIIIIl((double) this.IlllIIIIIIlllIlIIlllIlIIl.llIIIIIIIllIIllIlIllIIIIl, (double) this.IlllIIIIIIlllIlIIlllIlIIl.lIIIllIllIIllIlllIlIIlllI, (double) this.IlllIIIIIIlllIlIIlllIlIIl.IlllllIlIIIlIIlIIllIIlIll);
        }
    }

    public static class lIllIlIIIlIIIIIIIlllIlIll implements CosmeticRotationHelper {
        public float[] IlllIIIIIIlllIlIIlllIlIIl = new float[4];

        public lIllIlIIIlIIIIIIIlllIlIll(float var1, float var2, float var3, float var4) {
            this.IlllIIIIIIlllIlIIlllIlIIl[0] = var1;
            this.IlllIIIIIIlllIlIIlllIlIIl[1] = var2;
            this.IlllIIIIIIlllIlIIlllIlIIl[2] = var3;
            this.IlllIIIIIIlllIlIIlllIlIIl[3] = var4;
        }

        public void transform(AbstractClientPlayerBridge var1, float var2) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(this.IlllIIIIIIlllIlIIlllIlIIl[0], this.IlllIIIIIIlllIlIIlllIlIIl[1], this.IlllIIIIIIlllIlIIlllIlIIl[2], this.IlllIIIIIIlllIlIIlllIlIIl[3]);
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, MatrixStackBridge var2, float var3) {
            var2.IlllIIIIIIlllIlIIlllIlIIl(this.IlllIIIIIIlllIlIIlllIlIIl[0] * this.IlllIIIIIIlllIlIIlllIlIIl[1], this.IlllIIIIIIlllIlIIlllIlIIl[0] * this.IlllIIIIIIlllIlIIlllIlIIl[2], this.IlllIIIIIIlllIlIIlllIlIIl[0] * this.IlllIIIIIIlllIlIIlllIlIIl[3]);
        }
    }

    public abstract static class lIlIlIlIlIIlIIlIIllIIIIIl implements CosmeticRotationHelper {
        public Vector3f IlllIIIIIIlllIlIIlllIlIIl;

        public lIlIlIlIlIIlIIlIIllIIIIIl(Vector3f var1) {
            this.IlllIIIIIIlllIlIIlllIlIIl = var1;
        }
    }
}