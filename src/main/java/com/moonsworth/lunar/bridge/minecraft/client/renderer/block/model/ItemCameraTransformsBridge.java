package com.moonsworth.lunar.bridge.minecraft.client.renderer.block.model;

public interface ItemCameraTransformsBridge {
    void bridge$applyTransform(lIlIlIlIlIIlIIlIIllIIIIIl var1);

    enum lIlIlIlIlIIlIIlIIllIIIIIl {

        lIlIlIlIlIIlIIlIIllIIIIIl, // NONE
        IlllIIIIIIlllIlIIlllIlIIl, // THIRD_PERSON_LEFT_HAND
        lIllIlIIIlIIIIIIIlllIlIll, // THIRD_PERSON_RIGHT_HAND
        llIlllIIIllllIIlllIllIIIl, // FIRST_PERSON_LEFT_HAND
        llllIIlIIlIIlIIllIIlIIllI, // FIRST_PERSON_RIGHT_HAND
        IlIlIlllllIlIIlIlIlllIlIl, // HEAD
        llIIIIIIIllIIllIlIllIIIIl, // GUI
        lIIIllIllIIllIlllIlIIlllI, // GROUND
        IlllllIlIIIlIIlIIllIIlIll; // FIXED

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.name().toUpperCase();
        }

        public int IlllIIIIIIlllIlIIlllIlIIl() {
            int n;
            switch (this) {
            case lIlIlIlIlIIlIIlIIllIIIIIl: {
                n = 0;
                break;
            }
            case IlllIIIIIIlllIlIIlllIlIIl:
            case lIllIlIIIlIIIIIIIlllIlIll: {
                n = 1;
                break;
            }
            case llIlllIIIllllIIlllIllIIIl:
            case llllIIlIIlIIlIIllIIlIIllI: {
                n = 2;
                break;
            }
            default: {
                n = this.ordinal() - 2;
            }
            }
            return n;
        }
    }
}