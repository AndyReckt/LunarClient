package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.client.event.Event;

public class SetRenderLivingBrightnessEvent
extends Event {
    public float lIlIlIlIlIIlIIlIIllIIIIIl;
    public float IlllIIIIIIlllIlIIlllIlIIl;
    public float lIllIlIIIlIIIIIIIlllIlIll;
    public float llIlllIIIllllIIlllIllIIIl;

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float f) {
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float f) {
        this.lIllIlIIIlIIIIIIIlllIlIll = f;
    }

    public void llIlllIIIllllIIlllIllIIIl(float f) {
        this.llIlllIIIllllIIlllIllIIIl = f;
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public float lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public float llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public SetRenderLivingBrightnessEvent(float f, float f2, float f3, float f4) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
        this.IlllIIIIIIlllIlIIlllIlIIl = f2;
        this.lIllIlIIIlIIIIIIIlllIlIll = f3;
        this.llIlllIIIllllIIlllIllIIIl = f4;
    }
}