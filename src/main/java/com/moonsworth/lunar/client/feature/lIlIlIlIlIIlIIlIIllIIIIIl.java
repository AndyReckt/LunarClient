package com.moonsworth.lunar.client.feature;

import java.util.function.Predicate;

public abstract class lIlIlIlIlIIlIIlIIllIIIIIl
    extends Feature {
    public Object llllIIlIIlIIlIIllIIlIIllI;

    public lIlIlIlIlIIlIIlIIllIIIIIl(Object object, boolean bl) {
        super(bl);
        this.llllIIlIIlIIlIIllIIlIIllI = object;
    }

    public abstract Predicate IlIllIIlIIlIIIllIllllIIll();

    public Object lIllllIllIIlIIlIIIlIIIlII() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }
}