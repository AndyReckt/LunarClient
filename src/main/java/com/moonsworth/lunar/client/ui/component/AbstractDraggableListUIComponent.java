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

public abstract class AbstractDraggableListUIComponent
extends AbstractDraggableUIComponent {
    public List<UIComponent> IlllIIIIIIlllIlIIlllIlIIl = Collections.synchronizedList(this.lIllIlIIIlIIIIIIIlllIlIll());
    public IllIllIIIllIIIlIlIlIIIIll asas;

    public AbstractDraggableListUIComponent(UIComponent parent) {
        super(parent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2, new UIComponent[0]) || !uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n)) continue;
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                return true;
            }
            if (this.asas != null && this.asas.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.asas, f, f2, new UIComponent[0]) && this.asas.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n)) {
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                return true;
            }
            return true;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> {
            if (this.asas != null && !this.asas.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                this.asas = null;
            }
            for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                if (uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2, new UIComponent[0]) || !uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n)) continue;
                return true;
            }
            return false;
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(IllIllIIIllIIIlIlIlIIIIll illIllIIIllIIIlIlIlIIIIll) {
        this.asas = illIllIIIllIIIlIlIlIIIIll;
    }

    public abstract List lIllIlIIIlIIIIIIIlllIlIll();

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        if (this.IllIllIIIllIIIlIlIlIIIIll.get()) {
            if (!Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
                this.IllIllIIIllIIIlIlIlIIIIll.set(false);
                return;
            }
            float f3 = f - this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl;
            float f4 = f2 - this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl;
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
            this.lIlIlIlIlIIlIIlIIllIIIIIl(f3, f4, this.width, this.height);
            for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent.lllIIIIIlllIIlIllIIlIIIlI() - f5, uIComponent.lIlIIIIIIlIIIllllIllIIlII() - f6, uIComponent.llIlIIIllIIlIllIllIllllIl(), uIComponent.IllIllIIIllIIIlIlIlIIIIll());
            }
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl();
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2, new UIComponent[0]));
        }
        if (this.asas != null) {
            this.asas.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.asas, f, f2, new UIComponent[0]));
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
            uIComponent.IlllIIIIIIlllIlIIlllIlIIl();
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent, float f, float f2, UIComponent ... uIComponentArray) {
        UIComponent uIComponent2;
        List<UIComponent> list = Arrays.asList(uIComponentArray);
        if (uIComponent == this.asas) {
            return true;
        }
        boolean bl = true;
        for (int i = this.IlllIIIIIIlllIlIIlllIlIIl.size() - 1; i >= 0 && (uIComponent2 = (UIComponent)this.IlllIIIIIIlllIlIIlllIlIIl.get(i)) != uIComponent; --i) {
            if (list.contains(uIComponent2)) continue;
            if (this.asas != null && this.asas.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                bl = false;
                break;
            }
            if (!uIComponent2.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
            bl = false;
            break;
        }
        return bl;
    }

    public List llllIIlIIlIIlIIllIIlIIllI() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public IllIllIIIllIIIlIlIlIIIIll llIIIIIIIllIIllIlIllIIIIl() {
        return this.asas;
    }
}
 