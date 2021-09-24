package com.moonsworth.lunar.client.ui.component;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDraggableUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IllIllIIIllIIIlIlIlIIIIll;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractDraggableListUIComponent extends AbstractDraggableUIComponent {
    public List<UIComponent> list = Collections.synchronizedList(this.lIllIlIIIlIIIIIIIlllIlIll());
    public IllIllIIIllIIIlIlIlIIIIll asas;

    public AbstractDraggableListUIComponent(UIComponent parent) {
        super(parent);
        this.onMouseClick((float f, float f2, int n) -> {
            for (UIComponent uIComponent : this.list) {
                if (!uIComponent.mouseInside(f, f2) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2) || !uIComponent.onMouseClicked(f, f2, n)) continue;
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                return true;
            }
            if (this.asas != null && this.asas.mouseInside(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.asas, f, f2) && this.asas.onMouseClicked(f, f2, n)) {
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                return true;
            }
            return true;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> {
            if (this.asas != null && !this.asas.mouseInside(f, f2)) {
                this.asas = null;
            }
            for (UIComponent uIComponent : this.list) {
                if (uIComponent.mouseInside(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2) || !uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n)) continue;
                return true;
            }
            return false;
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(IllIllIIIllIIIlIlIlIIIIll illIllIIIllIIIlIlIlIIIIll) {
        this.asas = illIllIIIllIIIlIlIlIIIIll;
    }

    public abstract List<UIComponent> lIllIlIIIlIIIIIIIlllIlIll();

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        if (this.dragging.get()) {
            if (!Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
                this.dragging.set(false);
                return;
            }
            float f3 = f - this.point.x;
            float f4 = f2 - this.point.y;
            ScaledResolutionHelper scaledResolutionHelper = AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI();
            if ((double)f3 >= scaledResolutionHelper.lIllIlIIIlIIIIIIIlllIlIll() - (double)(this.width / 2.0f)) {
                f3 = (float)scaledResolutionHelper.lIllIlIIIlIIIIIIIlllIlIll() - this.width / 2.0f;
            } else if (f3 <= -this.width / 2.0f) {
                f3 = -this.width / 2.0f;
            }
            if ((double)f4 >= scaledResolutionHelper.llIlllIIIllllIIlllIllIIIl() - (double)(this.height / 2.0f)) {
                f4 = (float)scaledResolutionHelper.llIlllIIIllllIIlllIllIIIl() - this.height / 2.0f;
            } else if (f4 <= -this.height / 2.0f) {
                f4 = -this.height / 2.0f;
            }
            float f5 = this.x - f3;
            float f6 = this.y - f4;
            this.setPositionAndSize(f3, f4, this.width, this.height);
            for (UIComponent uIComponent : this.list) {
                uIComponent.setPositionAndSize(uIComponent.getX() - f5, uIComponent.getY() - f6, uIComponent.getWidth(), uIComponent.getHeight());
            }
        }
    }

    @Override
    public void onUpdateScreen() {
        for (UIComponent uIComponent : this.list) {
            uIComponent.onUpdateScreen();
        }
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        for (UIComponent uIComponent : this.list) {
            uIComponent.drawComponent(mouseX, mouseY, bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, mouseX, mouseY));
        }
        if (this.asas != null) {
            this.asas.drawComponent(mouseX, mouseY, bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.asas, mouseX, mouseY));
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        for (UIComponent uIComponent : this.list) {
            uIComponent.onKeyTyped(c, keyType);
        }
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
        for (UIComponent uIComponent : this.list) {
            uIComponent.handleMouseScrollDelta(n);
        }
    }

    @Override
    public void onGuiClosed() {
        for (UIComponent uIComponent : this.list) {
            uIComponent.onGuiClosed();
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent, float f, float f2, UIComponent ... uIComponentArray) {
        UIComponent uIComponent2;
        List<UIComponent> list = Arrays.asList(uIComponentArray);
        if (uIComponent == this.asas) {
            return true;
        }
        boolean bl = true;
        for (int i = this.list.size() - 1; i >= 0 && (uIComponent2 = this.list.get(i)) != uIComponent; --i) {
            if (list.contains(uIComponent2)) continue;
            if (this.asas != null && this.asas.mouseInside(f, f2)) {
                bl = false;
                break;
            }
            if (!uIComponent2.mouseInside(f, f2)) continue;
            bl = false;
            break;
        }
        return bl;
    }

    public List<UIComponent> llllIIlIIlIIlIIllIIlIIllI() {
        return this.list;
    }

    public IllIllIIIllIIIlIlIlIIIIll llIIIIIIIllIIllIlIllIIIIl() {
        return this.asas;
    }
}
