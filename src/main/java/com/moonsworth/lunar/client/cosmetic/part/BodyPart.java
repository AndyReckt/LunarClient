package com.moonsworth.lunar.client.cosmetic.part;

import com.moonsworth.lunar.bridge.minecraft.client.model.ModelBipedBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.client.util.CosmeticRotationHelper;

public enum BodyPart {
    HEAD(3) {
        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelBipedBridge var1) {
            return (var1x, var2) -> {
                var1.bridge$bipedHead().bridge$postRender(0.0625F);
            };
        }

        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelPlayerBridge var1) {
            return CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((var1x, var2) -> {
                var1.bridge$bipedHead().lIlIlIlIlIIlIIlIIllIIIIIl(var2);
            });
        }
    },
    BODY(2) {
        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelBipedBridge var1) {
            return (var1x, var2) -> {
                var1.bridge$bipedBody().bridge$postRender(0.0625F);
            };
        }

        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelPlayerBridge var1) {
            return CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((var1x, var2) -> {
                var1.bridge$bipedBody().lIlIlIlIlIIlIIlIIllIIIIIl(var2);
            });
        }
    },
    RIGHT_ARM(-1) {
        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelBipedBridge var1) {
            return (var1x, var2) -> {
                var1.bridge$bipedRightArm().bridge$postRender(0.0625F);
            };
        }

        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelPlayerBridge var1) {
            return CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((var1x, var2) -> {
                var1.bridge$bipedRightArm().lIlIlIlIlIIlIIlIIllIIIIIl(var2);
            });
        }
    },
    LEFT_ARM(-1) {
        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelBipedBridge var1) {
            return (var1x, var2) -> {
                var1.bridge$bipedLeftArm().bridge$postRender(0.0625F);
            };
        }

        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelPlayerBridge var1) {
            return CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((var1x, var2) -> {
                var1.bridge$bipedLeftArm().lIlIlIlIlIIlIIlIIllIIIIIl(var2);
            });
        }
    },
    RIGHT_LEG(1) {
        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelBipedBridge var1) {
            return (var1x, var2) -> {
                var1.bridge$bipedRightLeg().bridge$postRender(0.0625F);
            };
        }

        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelPlayerBridge var1) {
            return CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((var1x, var2) -> {
                var1.bridge$bipedRightLeg().lIlIlIlIlIIlIIlIIllIIIIIl(var2);
            });
        }
    },
    LEFT_LEG(1) {
        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelBipedBridge var1) {
            return (var1x, var2) -> {
                var1.bridge$bipedLeftLeg().bridge$postRender(0.0625F);
            };
        }

        public CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelPlayerBridge var1) {
            return CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((var1x, var2) -> {
                var1.bridge$bipedLeftLeg().lIlIlIlIlIIlIIlIIllIIIIIl(var2);
            });
        }
    };

    public int llIIIIIIIllIIllIlIllIIIIl;

    BodyPart(int var3) {
        this.llIIIIIIIllIIllIlIllIIIIl = var3;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl != -1;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public abstract CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelBipedBridge var1);

    public abstract CosmeticRotationHelper lIlIlIlIlIIlIIlIIllIIIIIl(ModelPlayerBridge var1);

    // $FF: synthetic method
    BodyPart(int var3, Object var4) {
        this(var3);
    }
}