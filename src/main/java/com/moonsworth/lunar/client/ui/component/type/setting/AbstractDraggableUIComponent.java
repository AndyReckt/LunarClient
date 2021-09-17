package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.Point;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractDraggableUIComponent
extends UIComponent {
    public Point llIlIIIllIIlIllIllIllllIl = new Point();
    public AtomicBoolean IllIllIIIllIIIlIlIlIIIIll = new AtomicBoolean();

    public AbstractDraggableUIComponent(UIComponent uIComponent) {
        super(uIComponent);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        if (this.IllIllIIIllIIIlIlIlIIIIll.get()) {
            if (!Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
                this.IllIllIIIllIIIlIlIlIIIIll.set(false);
                return;
            }
            double d = f - this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl;
            double d2 = f2 - this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl;
            ScaledResolutionHelper scaledResolutionHelper = AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI();
            if (d >= scaledResolutionHelper.lIllIlIIIlIIIIIIIlllIlIll() - (double)(this.width / 2.0f)) {
                d = (float)scaledResolutionHelper.lIllIlIIIlIIIIIIIlllIlIll() - this.width / 2.0f;
            } else if (d <= (double)(-this.width / 2.0f)) {
                d = -this.width / 2.0f;
            }
            if (d2 >= scaledResolutionHelper.llIlllIIIllllIIlllIllIIIl() - (double)(this.height / 2.0f)) {
                d2 = (float)scaledResolutionHelper.llIlllIIIllllIIlllIllIIIl() - this.height / 2.0f;
            } else if (d2 <= (double)(-this.height / 2.0f)) {
                d2 = -this.height / 2.0f;
            }
            this.lIlIlIlIlIIlIIlIIllIIIIIl((float)d, (float)d2, this.width, this.height);
        }
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float f, float f2) {
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f - this.x, f2 - this.y);
        this.IllIllIIIllIIIlIlIlIIIIll.set(true);
    }

    public void save() {
        if (this.IllIllIIIllIIIlIlIlIIIIll.get()) {
            this.IllIllIIIllIIIlIlIlIIIIll.set(false);
        }
    }
}
 