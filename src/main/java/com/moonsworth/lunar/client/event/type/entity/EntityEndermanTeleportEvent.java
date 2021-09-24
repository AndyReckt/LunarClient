package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.client.event.CancellableEvent;

public class EntityEndermanTeleportEvent
    extends CancellableEvent {
    public double lIlIlIlIlIIlIIlIIllIIIIIl;
    public double IlllIIIIIIlllIlIIlllIlIIl;
    public double lIllIlIIIlIIIIIIIlllIlIll;
    public float llIlllIIIllllIIlllIllIIIl;

    public double lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public double IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public double lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public float llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(double d) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = d;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(double d) {
        this.IlllIIIIIIlllIlIIlllIlIIl = d;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(double d) {
        this.lIllIlIIIlIIIIIIIlllIlIll = d;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.llIlllIIIllllIIlllIllIIIl = f;
    }

    public EntityEndermanTeleportEvent(double d, double d2, double d3, float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = d;
        this.IlllIIIIIIlllIlIIlllIlIIl = d2;
        this.lIllIlIIIlIIIIIIIlllIlIll = d3;
        this.llIlllIIIllllIIlllIllIIIl = f;
    }
}