package com.moonsworth.lunar.client.ui.component;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.event.MouseEventCallback;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.BooleanSupplier;

/**
 * @author Decencies
 * @since 10/07/2021 14:08
 */
@RequiredArgsConstructor
public abstract class UIComponent implements I18nBridge {

    public float x;
    public float y;
    public float width;
    public float height;
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl = false;
    public final UIComponent lIIIllIllIIllIlllIlIIlllI;
    public MouseEventCallback IlllllIlIIIlIIlIIllIIlIll;
    public MouseEventCallback llIIlIlIIIllIlIlIlIIlIIll;
    public MouseEventCallback llIIIlllIIlllIllllIlIllIl;
    public BooleanSupplier lllllIllIllIllllIlIllllII = () -> true;
    public final MinecraftBridge lllIIIIIlllIIlIllIIlIIIlI = Ref.lIlIlIlIlIIlIIlIIllIIIIIl();
    public final LunarClient lIlIIIIIIlIIIllllIllIIlII = LunarClient.IIllIlIllIlIllIllIllIllII();

    public boolean IlllIIIIIIlllIlIIlllIlIIl(float f, float f2) {
        return f > this.x && f < this.x + this.width && f2 > this.y && f2 < this.y + this.height;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
        this.lIlIlIlIlIIlIIlIIllIIIIIl = true;
    }

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl();

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, boolean var3);

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(char var1, KeyType var2);

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
    }

    public abstract void IlllIIIIIIlllIlIIlllIlIIl();

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        return this.IlllllIlIIIlIIlIIllIIlIll != null && this.lllllIllIllIllllIlIllllII.getAsBoolean() && this.IlllllIlIIIlIIlIIllIIlIll.accept(f, f2, n);
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll(float f, float f2, int n) {
        return this.llIIIlllIIlllIllllIlIllIl != null && this.lllllIllIllIllllIlIllllII.getAsBoolean() && this.llIIIlllIIlllIllllIlIllIl.accept(f, f2, n);
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
        return this.llIIlIlIIIllIlIlIlIIlIIll != null && this.lllllIllIllIllllIlIllllII.getAsBoolean() && this.llIIlIlIIIllIlIlIlIIlIIll.accept(f, f2, n);
    }

    public void IlIlIlllllIlIIlIlIlllIlIl() {
    }

    public Optional llIIIlllIIlllIllllIlIllIl() {
        return Optional.ofNullable(this.lIIIllIllIIllIlllIlIIlllI);
    }

    @Override
    public String getLanguagePath() {
        return "gui.components";
    }

    public boolean lllllIllIllIllllIlIllllII() {
        return this.lllllIllIllIllllIlIllllII.getAsBoolean();
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float f) {
        this.x = f;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float f) {
        this.y = f;
    }

    public void llIlllIIIllllIIlllIllIIIl(float f) {
        this.width = f;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(float f) {
        this.height = f;
    }

    public float lllIIIIIlllIIlIllIIlIIIlI() {
        return this.x;
    }

    public float lIlIIIIIIlIIIllllIllIIlII() {
        return this.y;
    }

    public float llIlIIIllIIlIllIllIllllIl() {
        return this.width;
    }

    public float IllIllIIIllIIIlIlIlIIIIll() {
        return this.height;
    }

    public boolean IIlIllIlllllllIIlIIIllIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(MouseEventCallback mouseEventCallback) {
        this.IlllllIlIIIlIIlIIllIIlIll = mouseEventCallback;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(MouseEventCallback mouseEventCallback) {
        this.llIIlIlIIIllIlIlIlIIlIIll = mouseEventCallback;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(MouseEventCallback mouseEventCallback) {
        this.llIIIlllIIlllIllllIlIllIl = mouseEventCallback;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(BooleanSupplier booleanSupplier) {
        this.lllllIllIllIllllIlIllllII = booleanSupplier;
    }

}
