package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.block.BlockBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.EntityRendererBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class EntityRendererEvent
    extends CancellableEvent {
    public final EntityRendererBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final EntityBridge IlllIIIIIIlllIlIIlllIlIIl;
    public final BlockBridge lIllIlIIIlIIIIIIIlllIlIll;
    public final double llIlllIIIllllIIlllIllIIIl;

    public EntityRendererBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public EntityBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public BlockBridge lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public double llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public EntityRendererEvent(EntityRendererBridge entityRendererBridge, EntityBridge entityBridge, BlockBridge blockBridge, double d) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityRendererBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = entityBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = blockBridge;
        this.llIlllIIIllllIIlllIllIIIl = d;
    }

    public static class IlllIIIIIIlllIlIIlllIlIIl
        extends EntityRendererEvent {
        public float lIlIlIlIlIIlIIlIIllIIIIIl;

        public IlllIIIIIIlllIlIIlllIlIIl(EntityRendererBridge entityRendererBridge, EntityBridge entityBridge, BlockBridge blockBridge, double d, float f) {
            super(entityRendererBridge, entityBridge, blockBridge, d);
            this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
        }

        public float llllIIlIIlIIlIIllIIlIIllI() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
        }
    }

    public static class lIlIlIlIlIIlIIlIIllIIIIIl
        extends EntityRendererEvent {
        public float lIlIlIlIlIIlIIlIIllIIIIIl;
        public float IlllIIIIIIlllIlIIlllIlIIl;
        public float lIllIlIIIlIIIIIIIlllIlIll;

        public lIlIlIlIlIIlIIlIIllIIIIIl(EntityRendererBridge entityRendererBridge, EntityBridge entityBridge, BlockBridge blockBridge, double d, float f, float f2, float f3) {
            super(entityRendererBridge, entityBridge, blockBridge, d);
            this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
            this.IlllIIIIIIlllIlIIlllIlIIl = f2;
            this.lIllIlIIIlIIIIIIIlllIlIll = f3;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
        }

        public void IlllIIIIIIlllIlIIlllIlIIl(float f) {
            this.IlllIIIIIIlllIlIIlllIlIIl = f;
        }

        public void lIllIlIIIlIIIIIIIlllIlIll(float f) {
            this.lIllIlIIIlIIIIIIIlllIlIll = f;
        }

        public float llllIIlIIlIIlIIllIIlIIllI() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public float IlIlIlllllIlIIlIlIlllIlIl() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }

        public float llIIIIIIIllIIllIlIllIIIIl() {
            return this.lIllIlIIIlIIIIIIIlllIlIll;
        }
    }

    public static class lIllIlIIIlIIIIIIIlllIlIll
        extends EntityRendererEvent {
        public float lIlIlIlIlIIlIIlIIllIIIIIl;
        public float IlllIIIIIIlllIlIIlllIlIIl;
        public float lIllIlIIIlIIIIIIIlllIlIll;

        public lIllIlIIIlIIIIIIIlllIlIll(EntityRendererBridge entityRendererBridge, EntityBridge entityBridge, BlockBridge blockBridge, double d, float f, float f2, float f3) {
            super(entityRendererBridge, entityBridge, blockBridge, d);
            this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
            this.IlllIIIIIIlllIlIIlllIlIIl = f2;
            this.lIllIlIIIlIIIIIIIlllIlIll = f3;
        }

        public float llllIIlIIlIIlIIllIIlIIllI() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public float IlIlIlllllIlIIlIlIlllIlIl() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }

        public float llIIIIIIIllIIllIlIllIIIIl() {
            return this.lIllIlIIIlIIIIIIIlllIlIll;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
        }

        public void IlllIIIIIIlllIlIIlllIlIIl(float f) {
            this.IlllIIIIIIlllIlIIlllIlIIl = f;
        }

        public void lIllIlIIIlIIIIIIIlllIlIll(float f) {
            this.lIllIlIIIlIIIIIIIlllIlIll = f;
        }
    }

    public static class llllIIlIIlIIlIIllIIlIIllI
        extends EntityRendererEvent {
        public final int lIlIlIlIlIIlIIlIIllIIIIIl;
        public final float IlllIIIIIIlllIlIIlllIlIIl;

        public llllIIlIIlIIlIIllIIlIIllI(EntityRendererBridge entityRendererBridge, EntityBridge entityBridge, BlockBridge blockBridge, double d, int n, float f) {
            super(entityRendererBridge, entityBridge, blockBridge, d);
            this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
            this.IlllIIIIIIlllIlIIlllIlIIl = f;
        }

        public int llllIIlIIlIIlIIllIIlIIllI() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public float IlIlIlllllIlIIlIlIlllIlIl() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }
    }

    public static class llIlllIIIllllIIlllIllIIIl
        extends EntityRendererEvent {
        public float lIlIlIlIlIIlIIlIIllIIIIIl;

        public llIlllIIIllllIIlllIllIIIl(EntityRendererBridge entityRendererBridge, EntityBridge entityBridge, BlockBridge blockBridge, double d, float f) {
            super(entityRendererBridge, entityBridge, blockBridge, d);
            this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
        }

        public float llllIIlIIlIIlIIllIIlIIllI() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
        }
    }
}
