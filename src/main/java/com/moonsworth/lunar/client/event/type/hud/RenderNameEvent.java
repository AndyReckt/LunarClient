package com.moonsworth.lunar.client.event.type.hud;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

import java.util.List;

public class RenderNameEvent
extends CancellableEvent {
    public final EntityLivingBaseBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public final double lIllIlIIIlIIIIIIIlllIlIll;
    public final double llIlllIIIllllIIlllIllIIIl;
    public final double llllIIlIIlIIlIIllIIlIIllI;
    public List IlIlIlllllIlIIlIlIlllIlIl;

    public EntityLivingBaseBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public double lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public double llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public double llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public RenderNameEvent(EntityLivingBaseBridge entityLivingBaseBridge, String string, double d, double d2, double d3, List list) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityLivingBaseBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
        this.lIllIlIIIlIIIIIIIlllIlIll = d;
        this.llIlllIIIllllIIlllIllIIIl = d2;
        this.llllIIlIIlIIlIIllIIlIIllI = d3;
        this.IlIlIlllllIlIIlIlIlllIlIl = list;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List list) {
        this.IlIlIlllllIlIIlIlIlllIlIl = list;
    }
}