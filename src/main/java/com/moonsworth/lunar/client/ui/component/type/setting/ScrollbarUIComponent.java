package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class ScrollbarUIComponent extends UIComponent {
    public double scrollAmount;
    public float yOffset;
    public float contentHeight;
    public boolean llIlIIIllIIlIllIllIllllIl;
    public boolean IllIllIIIllIIIlIlIlIIIIll;
    public float IIlIllIlllllllIIlIIIllIIl;
    public boolean lIIlIlllIlIlIIIlllIIlIIII;

    public ScrollbarUIComponent(UIComponent parent) {
        super(parent);
        this.onMouseClick((float f, float f2, int n) -> {
            if (this.mouseInside(f, f2)) {
                this.lIIlIlllIlIlIIIlllIIlIIII = true;
                return true;
            }
            return false;
        });
    }

    @Override
    public boolean mouseInside(float mouseX, float mouseY) {
        return mouseX >= this.x && mouseX <= this.x + this.width && mouseY > this.y && mouseY < this.y + this.height;
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
    }

    public float getYOffset() {
        return this.yOffset;
    }

    public void onDraw(float f, float f2, boolean bl) {
        if (this.parent != null && !this.parent.mouseInside(f, f2) && this.scrollAmount != 0.0) {
            this.scrollAmount = 0.0;
        }
        double d = Math.round(this.scrollAmount / 5.0);
        this.scrollAmount -= d;
        if (this.scrollAmount != 0.0) {
            this.yOffset = (float)((double)this.yOffset + d);
        }
        if (this.IllIllIIIllIIIlIlIlIIIIll) {
            if (this.yOffset < -this.contentHeight + this.height) {
                this.yOffset = -this.contentHeight + this.height;
                this.scrollAmount = 0.0;
            }
            if (this.yOffset > 0.0f) {
                this.yOffset = 0.0f;
                this.scrollAmount = 0.0;
            }
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0f, this.yOffset, 0.0f);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float f, float f2, boolean bl) {
        float f3;
        this.IllIllIIIllIIIlIlIlIIIIll = true;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        boolean bl2 = this.llIlllIIIllllIIlllIllIIIl();
        if (!(!this.llIlIIIllIIlIllIllIllllIl || Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.mouseInside(f, f2) && bl)) {
            this.llIlIIIllIIlIllIllIllllIl = false;
        }
        if (this.lIIlIlllIlIlIIIlllIIlIIII && !Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
            this.lIIlIlllIlIlIIIlllIIlIIII = false;
        }
        float f4 = this.height;
        float f5 = this.contentHeight;
        float f6 = f4 / f5 * 100.0f;
        float f7 = f4 / 100.0f * f6;
        float f8 = this.yOffset / 100.0f * f6;
        if (Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIIlIlllIlIlIIIlllIIlIIII) {
            f3 = f2 - this.y;
            float f9 = f3 / this.height;
            this.yOffset = -(this.contentHeight - this.height / 2.0f) + this.contentHeight * f9 + f7 / 2.0f;
        }
        if (bl2) {
            f3 = this.height;
            if (this.llIlIIIllIIlIllIllIllllIl) {
                if (this.yOffset != this.IIlIllIlllllllIIlIIIllIIl && this.IIlIllIlllllllIIlIIIllIIl != f7 / 2.0f && this.IIlIllIlllllllIIlIIIllIIl != f7 / 2.0f + -this.contentHeight + f3) {
                    if (f2 > this.y + this.height - f7 - f7 / 4.0f + f8) {
                        this.yOffset = f5 / 7.0f;
                    } else if (f2 < this.y + this.height - f7 / 4.0f + f8) {
                        this.yOffset += f5 / 7.0f;
                    }
                    this.IIlIllIlllllllIIlIIIllIIl = this.yOffset;
                } else if (f2 > this.y + this.height - f7 - f7 / 4.0f + f8 || f2 < this.y + this.height - f7 / 4.0f - f8) {
                    this.IIlIllIlllllllIIlIIIllIIl = 1.0f;
                }
            }
            if (this.yOffset < -this.contentHeight + f3) {
                this.yOffset = -this.contentHeight + f3;
                this.scrollAmount = 0.0;
            }
            if (this.yOffset > 0.0f) {
                this.yOffset = 0.0f;
                this.scrollAmount = 0.0;
            }
            boolean bl3 = f >= this.x && f <= this.x + this.width && f2 > this.y + this.height - f7 + f8 && f2 < this.y + this.height + f8;
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 540884285);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height + f8 - f7, this.width, f7, bl && (bl3 || Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIIlIlllIlIlIIIlllIIlIIII) ? 1625481954 : 0x20E2E2E2);
        }
        if (!bl2 && this.yOffset != 0.0f) {
            this.yOffset = 0.0f;
        }
    }

    public void llIlllIIIllllIIlllIllIIIl(float f, float f2, boolean bl) {
        if (this.parent != null && !this.parent.mouseInside(f, f2) && this.scrollAmount != 0.0) {
            this.scrollAmount = 0.0;
        }
        double d = Math.round(this.scrollAmount / 5.0);
        this.scrollAmount -= d;
        if (this.scrollAmount != 0.0) {
            this.yOffset = (float)((double)this.yOffset - d);
        }
        if (this.IllIllIIIllIIIlIlIlIIIIll) {
            if (this.yOffset < -this.contentHeight + this.height) {
                this.yOffset = -this.contentHeight + this.height;
                this.scrollAmount = 0.0;
            }
            if (this.yOffset > 0.0f) {
                this.yOffset = 0.0f;
                this.scrollAmount = 0.0;
            }
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0f, -this.yOffset, 0.0f);
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.contentHeight > this.height;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(float f, float f2, boolean bl) {
        float f3;
        this.IllIllIIIllIIIlIlIlIIIIll = true;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        boolean bl2 = this.llIlllIIIllllIIlllIllIIIl();
        if (!(!this.llIlIIIllIIlIllIllIllllIl || Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.mouseInside(f, f2) && bl)) {
            this.llIlIIIllIIlIllIllIllllIl = false;
        }
        if (this.lIIlIlllIlIlIIIlllIIlIIII && !Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
            this.lIIlIlllIlIlIIIlllIIlIIII = false;
        }
        float f4 = this.height;
        float f5 = this.contentHeight;
        float f6 = f4 / f5 * 100.0f;
        float f7 = f4 / 100.0f * f6;
        float f8 = this.yOffset / 100.0f * f6;
        if (Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIIlIlllIlIlIIIlllIIlIIII) {
            f3 = f2 - this.y;
            float f9 = f3 / this.height;
            this.yOffset = -(this.contentHeight * f9) + f7 / 2.0f + f9;
        }
        if (bl2) {
            boolean bl3;
            f3 = this.height;
            boolean bl4 = bl3 = f >= this.x && f <= this.x + this.width && f2 > this.y - f8 && f2 < this.y + f7 - f8;
            if (this.llIlIIIllIIlIllIllIllllIl) {
                if (this.yOffset != this.IIlIllIlllllllIIlIIIllIIl && this.IIlIllIlllllllIIlIIIllIIl != f7 / 2.0f && this.IIlIllIlllllllIIlIIIllIIl != f7 / 2.0f + -this.contentHeight + f3) {
                    if (f2 > this.y + f7 - f7 / 4.0f - f8) {
                        this.yOffset -= f5 / 7.0f;
                    } else if (f2 < this.y + f7 / 4.0f - f8) {
                        this.yOffset += f5 / 7.0f;
                    }
                    this.IIlIllIlllllllIIlIIIllIIl = this.yOffset;
                } else if (f2 > this.y + f7 - f7 / 4.0f - f8 || f2 < this.y + f7 / 4.0f - f8) {
                    this.IIlIllIlllllllIIlIIIllIIl = 1.0f;
                }
            }
            if (this.yOffset < -this.contentHeight + f3) {
                this.yOffset = -this.contentHeight + f3;
                this.scrollAmount = 0.0;
            }
            if (this.yOffset > 0.0f) {
                this.yOffset = 0.0f;
                this.scrollAmount = 0.0;
            }
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 540884285);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y - f8, this.width, f7, bl && (bl3 || Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIIlIlllIlIlIIIlllIIlIIII) ? 1625481954 : 0x20E2E2E2);
        }
        if (!bl2 && this.yOffset != 0.0f) {
            this.yOffset = 0.0f;
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
        if (n != 0 && this.contentHeight >= this.height) {
            this.scrollAmount += (float)n / 3.0f;
        }
    }

    @Override
    public void onGuiClosed() {
    }

    public void setScrollAmount(double d) {
        this.scrollAmount = d;
    }

    public double getScrollAmount() {
        return this.scrollAmount;
    }

    public void setYOffset(float f) {
        this.yOffset = f;
    }

    public void setContentHeight(float f) {
        this.contentHeight = f;
    }

    public boolean load() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public boolean lIIIllIllIIllIlllIlIIlllI() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }
}