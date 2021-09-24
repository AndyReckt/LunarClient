package com.moonsworth.lunar.client.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.event.handler.KeybindEventHandler;
import com.moonsworth.lunar.client.feature.Feature;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public abstract class AbstractFeatureSetting<T>
    extends AbstractSetting<T> {
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl = true;
    public List IlllIIIIIIlllIlIIlllIlIIl = new ArrayList();
    public boolean lIllIlIIIlIIIIIIIlllIlIll = true;
    public boolean llIlllIIIllllIIlllIllIIIl = false;
    public long llllIIlIIlIIlIIllIIlIIllI;
    public boolean IlIlIlllllIlIIlIlIlllIlIl;
    public int llIIIIIIIllIIllIlIllIIIIl = 200;
    public Feature lIIIllIllIIllIlllIlIIlllI;
    public final List IlllllIlIIIlIIlIIllIIlIll = new ArrayList();
    public final List llIIlIlIIIllIlIlIlIIlIIll = new ArrayList();

    public AbstractFeatureSetting(Feature feature, String string, T object) {
        super(string, object);
        this.lIIIllIllIIllIlllIlIIlllI = feature;
        KeybindEventHandler.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public AbstractFeatureSetting(String string, T object, BooleanSupplier booleanSupplier) {
        super(string, object, booleanSupplier);
        KeybindEventHandler.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public AbstractFeatureSetting lIlIlIlIlIIlIIlIIllIIIIIl(Runnable runnable) {
        this.IlllllIlIIIlIIlIIllIIlIll.add(runnable);
        return this;
    }

    public AbstractFeatureSetting lIlIlIlIlIIlIIlIIllIIIIIl(BooleanConsumer booleanConsumer) {
        this.llIIlIlIIIllIlIlIlIIlIIll.add(booleanConsumer);
        return this;
    }

    public AbstractFeatureSetting lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lIllIlIIIlIIIIIIIlllIlIll = bl;
        return this;
    }

    public AbstractFeatureSetting IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.llIlllIIIllllIIlllIllIIIl = bl;
        return this;
    }

    public abstract boolean IlllIIIIIIlllIlIIlllIlIIl();

    public abstract boolean lIllIlIIIlIIIIIIIlllIlIll();

    public abstract KeyType g_();

    public boolean IlIlIlllllIlIIlIlIlllIlIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = bl;
    }

    public List<String> llIIIIIIIllIIllIlIllIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List list) {
        this.IlllIIIIIIlllIlIIlllIlIIl = list;
    }

    public boolean lIIIllIllIIllIlllIlIIlllI() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public boolean IlllllIlIIIlIIlIIllIIlIll() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public long llIIlIlIIIllIlIlIlIIlIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(long l) {
        this.llllIIlIIlIIlIIllIIlIIllI = l;
    }

    public boolean llIIIlllIIlllIllllIlIllIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public void llIlllIIIllllIIlllIllIIIl(boolean bl) {
        this.IlIlIlllllIlIIlIlIlllIlIl = bl;
    }

    public int lllllIllIllIllllIlIllllII() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.llIIIIIIIllIIllIlIllIIIIl = n;
    }

    public Feature lllIIIIIlllIIlIllIIlIIIlI() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Feature feature) {
        this.lIIIllIllIIllIlllIlIIlllI = feature;
    }

    public List lIlIIIIIIlIIIllllIllIIlII() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public List llIlIIIllIIlIllIllIllllIl() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }
}