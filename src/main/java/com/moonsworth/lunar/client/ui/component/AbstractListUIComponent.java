package com.moonsworth.lunar.client.ui.component;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.ui.component.type.setting.IllIllIIIllIIIlIlIlIIIIll;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.UIScreenCloseException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractListUIComponent<T extends UIComponent> extends UIComponent implements UIScreenCloseException {
    public List<T> components = Collections.synchronizedList(this.lIllIlIIIlIIIIIIIlllIlIll());
    public boolean sumBool;
    public IllIllIIIllIIIlIlIlIIIIll sumTing;

    public AbstractListUIComponent(UIComponent parent) {
        super(parent);
        this.onMouseRelease((f, f2, n) -> {
            if (this.sumTing != null && this.sumTing.mouseInside(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.sumTing, f, f2) && this.sumTing.onMouseReleased(f, f2, n)) {
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                if (this.sumBool) {
                    this.sumTing = null;
                }
                return true;
            }
            for (UIComponent component : this.components) {
                if (!component.mouseInside(f, f2) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(component, f, f2) || !component.onMouseReleased(f, f2, n)) continue;
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                return true;
            }
            return false;
        });
        this.onMouseClick((f, f2, n) -> {
            if (this.sumTing != null && this.sumTing.mouseInside(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.sumTing, f, f2) && this.sumTing.onMouseClicked(f, f2, n)) {
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                if (this.sumBool) {
                    this.sumTing = null;
                }
                return true;
            }
            for (UIComponent component : this.components) {
                if (!component.mouseInside(f, f2) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(component, f, f2) || !component.onMouseClicked(f, f2, n)) continue;
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                return true;
            }
            return false;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> {
            if (this.sumTing != null) {
                if (!this.mouseInside(f, f2) && this.sumTing.mouseInside(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.sumTing, f, f2) && this.sumTing.onMouseClicked(f, f2, n)) {
                    AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                    if (this.sumBool) {
                        this.sumTing = null;
                    }
                    return true;
                }
                if (!this.sumTing.mouseInside(f, f2)) {
                    this.sumTing = null;
                    this.sumBool = true;
                }
            }
            for (UIComponent component : this.components) {
                if (component.mouseInside(f, f2) || !component.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n)) continue;
                return true;
            }
            return false;
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(IllIllIIIllIIIlIlIlIIIIll illIllIIIllIIIlIlIlIIIIll) {
        this.sumTing = illIllIIIllIIIlIlIlIIIIll;
    }

    public abstract List<T> lIllIlIIIlIIIIIIIlllIlIll();

    @Override
    public void onUpdateScreen() {
        for (UIComponent uIComponent : this.components) {
            uIComponent.onUpdateScreen();
        }
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        for (UIComponent uIComponent : this.components) {
            uIComponent.drawComponent(mouseX, mouseY, bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, mouseX, mouseY));
        }
        if (this.sumTing != null) {
            this.sumTing.drawComponent(mouseX, mouseY, bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.sumTing, mouseX, mouseY));
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        for (UIComponent uIComponent : this.components) {
            uIComponent.onKeyTyped(c, keyType);
        }
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
        for (UIComponent uIComponent : this.components) {
            uIComponent.handleMouseScrollDelta(n);
        }
    }

    @Override
    public void onGuiClosed() {
        for (UIComponent uIComponent : this.components) {
            uIComponent.onGuiClosed();
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent, float f, float f2, UIComponent ... uIComponentArray) {
        UIComponent uIComponent2;
        List<UIComponent> list = Arrays.asList(uIComponentArray);
        if (uIComponent == this.sumTing) {
            return true;
        }
        boolean bl = true;
        for (int i = this.components.size() - 1; i >= 0 && (uIComponent2 = this.components.get(i)) != uIComponent; --i) {
            if (list.contains(uIComponent2)) continue;
            if (this.sumTing != null && this.sumTing.mouseInside(f, f2)) {
                bl = false;
                break;
            }
            if (!uIComponent2.mouseInside(f, f2)) continue;
            bl = false;
            break;
        }
        return bl;
    }

    @Override
    public boolean shouldCancel() {
        return this.components.stream().filter(uIComponent -> uIComponent instanceof UIScreenCloseException).anyMatch(uIComponent -> ((UIScreenCloseException) uIComponent).shouldCancel());
    }

    public List<T> lIIlIlllIlIlIIIlllIIlIIII() {
        return this.components;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List<T> list) {
        this.components = list;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.sumBool = bl;
    }

    public IllIllIIIllIIIlIlIlIIIIll llIllIlIllIlllIllIIIIllII() {
        return this.sumTing;
    }
}