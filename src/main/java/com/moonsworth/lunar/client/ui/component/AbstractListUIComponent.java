package com.moonsworth.lunar.client.ui.component;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.ui.component.type.setting.IllIllIIIllIIIlIlIlIIIIll;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.BooleanCallbackSetting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractListUIComponent<T extends UIComponent>
extends UIComponent
implements BooleanCallbackSetting {
    public List<T> llIlIIIllIIlIllIllIllllIl = Collections.synchronizedList(this.lIllIlIIIlIIIIIIIlllIlIll());
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl;
    public IllIllIIIllIIIlIlIlIIIIll IllIllIIIllIIIlIlIlIIIIll;

    public AbstractListUIComponent(UIComponent component) {
        super(component);
        this.lIllIlIIIlIIIIIIIlllIlIll((f, f2, n) -> {
            if (this.IllIllIIIllIIIlIlIlIIIIll != null && this.IllIllIIIllIIIlIlIlIIIIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll, f, f2, new UIComponent[0]) && this.IllIllIIIllIIIlIlIlIIIIll.lIllIlIIIlIIIIIIIlllIlIll(f, f2, n)) {
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                if (this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                    this.IllIllIIIllIIIlIlIlIIIIll = null;
                }
                return true;
            }
            for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2, new UIComponent[0]) || !uIComponent.lIllIlIIIlIIIIIIIlllIlIll(f, f2, n)) continue;
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                return true;
            }
            return false;
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.IllIllIIIllIIIlIlIlIIIIll != null && this.IllIllIIIllIIIlIlIlIIIIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll, f, f2, new UIComponent[0]) && this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n)) {
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                if (this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                    this.IllIllIIIllIIIlIlIlIIIIll = null;
                }
                return true;
            }
            for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2, new UIComponent[0]) || !uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n)) continue;
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                return true;
            }
            return false;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> {
            if (this.IllIllIIIllIIIlIlIlIIIIll != null) {
                if (!this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.IllIllIIIllIIIlIlIlIIIIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll, f, f2, new UIComponent[0]) && this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n)) {
                    AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                    if (this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                        this.IllIllIIIllIIIlIlIlIIIIll = null;
                    }
                    return true;
                }
                if (!this.IllIllIIIllIIIlIlIlIIIIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                    this.IllIllIIIllIIIlIlIlIIIIll = null;
                    this.lIlIlIlIlIIlIIlIIllIIIIIl = true;
                }
            }
            for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
                if (uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2) || !uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n)) continue;
                return true;
            }
            return false;
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(IllIllIIIllIIIlIlIlIIIIll illIllIIIllIIIlIlIlIIIIll) {
        this.IllIllIIIllIIIlIlIlIIIIll = illIllIIIllIIIlIlIlIIIIll;
    }

    public abstract List<T> lIllIlIIIlIIIIIIIlllIlIll();

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl();
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2, new UIComponent[0]));
        }
        if (this.IllIllIIIllIIIlIlIlIIIIll != null) {
            this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll, f, f2, new UIComponent[0]));
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
            uIComponent.IlllIIIIIIlllIlIIlllIlIIl();
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent, float f, float f2, UIComponent ... uIComponentArray) {
        UIComponent uIComponent2;
        List<UIComponent> list = Arrays.asList(uIComponentArray);
        if (uIComponent == this.IllIllIIIllIIIlIlIlIIIIll) {
            return true;
        }
        boolean bl = true;
        for (int i = this.llIlIIIllIIlIllIllIllllIl.size() - 1; i >= 0 && (uIComponent2 = (UIComponent)this.llIlIIIllIIlIllIllIllllIl.get(i)) != uIComponent; --i) {
            if (list.contains(uIComponent2)) continue;
            if (this.IllIllIIIllIIIlIlIlIIIIll != null && this.IllIllIIIllIIIlIlIlIIIIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                bl = false;
                break;
            }
            if (!uIComponent2.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
            bl = false;
            break;
        }
        return bl;
    }

    @Override
    public boolean c_() {
        return this.llIlIIIllIIlIllIllIllllIl.stream().filter(uIComponent -> uIComponent instanceof BooleanCallbackSetting).anyMatch(uIComponent -> ((BooleanCallbackSetting)((Object)uIComponent)).c_());
    }

    public List lIIlIlllIlIlIIIlllIIlIIII() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List list) {
        this.llIlIIIllIIlIllIllIllllIl = list;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = bl;
    }

    public IllIllIIIllIIIlIlIlIIIIll llIllIlIllIlllIllIIIIllII() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }
}