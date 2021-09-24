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
    public boolean initialized = false;
    public final UIComponent parent;
    public MouseEventCallback onMouseClick;
    public MouseEventCallback llIIlIlIIIllIlIlIlIIlIIll;
    public MouseEventCallback onMouseRelease;
    public BooleanSupplier visible = () -> true;
    public final MinecraftBridge mc = Ref.getMinecraft();
    public final LunarClient lc = LunarClient.getInstance();

    public boolean mouseInside(float mouseX, float mouseY) {
        return mouseX > this.x && mouseX < this.x + this.width && mouseY > this.y && mouseY < this.y + this.height;
    }

    public void setPositionAndSize(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.initialized = true;
    }

    public abstract void onUpdateScreen();

    public abstract void drawComponent(float mouseX, float mouseY, boolean var3);

    public abstract void onKeyTyped(char var1, KeyType var2);

    public void handleMouseScrollDelta(int n) {
    }

    public abstract void onGuiClosed();

    public boolean onMouseClicked(float mouseX, float mouseY, int mouseButton) {
        return this.onMouseClick != null && this.visible.getAsBoolean() && this.onMouseClick.accept(mouseX, mouseY, mouseButton);
    }

    public boolean onMouseReleased(float mouseX, float mouseY, int mouseButton) {
        return this.onMouseRelease != null && this.visible.getAsBoolean() && this.onMouseRelease.accept(mouseX, mouseY, mouseButton);
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(float mouseX, float mouseY, int mouseButton) {
        return this.llIIlIlIIIllIlIlIlIIlIIll != null && this.visible.getAsBoolean() && this.llIIlIlIIIllIlIlIlIIlIIll.accept(mouseX, mouseY, mouseButton);
    }

    public void IlIlIlllllIlIIlIlIlllIlIl() {
    }

    public Optional llIIIlllIIlllIllllIlIllIl() {
        return Optional.ofNullable(this.parent);
    }

    @Override
    public String getLanguagePath() {
        return "gui.components";
    }

    public boolean isVisible() {
        return this.visible.getAsBoolean();
    }

    public void setX(float f) {
        this.x = f;
    }

    public void setY(float f) {
        this.y = f;
    }

    public void setWidth(float f) {
        this.width = f;
    }

    public void setHeight(float f) {
        this.height = f;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public void onMouseClick(MouseEventCallback mouseEventCallback) {
        this.onMouseClick = mouseEventCallback;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(MouseEventCallback mouseEventCallback) {
        this.llIIlIlIIIllIlIlIlIIlIIll = mouseEventCallback;
    }

    public void onMouseRelease(MouseEventCallback mouseEventCallback) {
        this.onMouseRelease = mouseEventCallback;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(BooleanSupplier booleanSupplier) {
        this.visible = booleanSupplier;
    }

}
