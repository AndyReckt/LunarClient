package com.moonsworth.lunar.client.event.type.entity.player;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;
import lombok.NonNull;

public class PreRenderPlayerEvent
extends CancellableEvent {
    @NonNull
    public final EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    @NonNull
    public final double IlllIIIIIIlllIlIIlllIlIIl;
    @NonNull
    public final double lIllIlIIIlIIIIIIIlllIlIll;
    @NonNull
    public final double llIlllIIIllllIIlllIllIIIl;
    @NonNull
    public float llllIIlIIlIIlIIllIIlIIllI;
    public int IlIlIlllllIlIIlIlIlllIlIl;
    public MatrixStackBridge llIIIIIIIllIIllIlIllIIIIl;
    public lIllIlIIIlIIIIIIIlllIlIll lIIIllIllIIllIlllIlIIlllI;

    public PreRenderPlayerEvent(@NonNull EntityPlayerBridge entityPlayerBridge, @NonNull double d, @NonNull double d2, @NonNull double d3, @NonNull float f, int n, MatrixStackBridge matrixStackBridge, lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2) {
        if (entityPlayerBridge == null) {
            throw new NullPointerException("player is marked non-null but is null");
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityPlayerBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = d;
        this.lIllIlIIIlIIIIIIIlllIlIll = d2;
        this.llIlllIIIllllIIlllIllIIIl = d3;
        this.llllIIlIIlIIlIIllIIlIIllI = f;
        this.IlIlIlllllIlIIlIlIlllIlIl = n;
        this.llIIIIIIIllIIllIlIllIIIIl = matrixStackBridge;
        this.lIIIllIllIIllIlllIlIIlllI = lIllIlIIIlIIIIIIIlllIlIll2;
    }

    public PreRenderPlayerEvent(@NonNull EntityPlayerBridge entityPlayerBridge, @NonNull double d, @NonNull double d2, @NonNull double d3, @NonNull float f) {
        if (entityPlayerBridge == null) {
            throw new NullPointerException("player is marked non-null but is null");
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityPlayerBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = d;
        this.lIllIlIIIlIIIIIIIlllIlIll = d2;
        this.llIlllIIIllllIIlllIllIIIl = d3;
        this.llllIIlIIlIIlIIllIIlIIllI = f;
    }

    @NonNull
    public EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    @NonNull
    public double IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    @NonNull
    public double lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    @NonNull
    public double llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    @NonNull
    public float llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public int IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public MatrixStackBridge llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public lIllIlIIIlIIIIIIIlllIlIll lIIIllIllIIllIlllIlIIlllI() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2) {
        this.lIIIllIllIIllIlllIlIIlllI = lIllIlIIIlIIIIIIIlllIlIll2;
    }
}