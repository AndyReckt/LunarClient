package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class IIlIllIlIIllIIlIlIllllllI
extends UIComponent {
    public double lIlIlIlIlIIlIIlIIllIIIIIl;
    public float IlllIIIIIIlllIlIIlllIlIIl;
    public float lIllIlIIIlIIIIIIIlllIlIll;
    public boolean llIlIIIllIIlIllIllIllllIl;
    public boolean IllIllIIIllIIIlIlIlIIIIll;
    public float IIlIllIlllllllIIlIIIllIIl;
    public boolean lIIlIlllIlIlIIIlllIIlIIII;

    public IIlIllIlIIllIIlIlIllllllI(UIComponent uIComponent) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                this.lIIlIlllIlIlIIIlllIIlIIII = true;
                return true;
            }
            return false;
        });
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl(float f, float f2) {
        return f >= this.x && f <= this.x + this.width && f2 > this.y && f2 < this.y + this.height;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
    }

    public float lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, boolean bl) {
        if (this.lIIIllIllIIllIlllIlIIlllI != null && !this.lIIIllIllIIllIlllIlIIlllI.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl != 0.0) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0;
        }
        double d = Math.round(this.lIlIlIlIlIIlIIlIIllIIIIIl / 5.0);
        this.lIlIlIlIlIIlIIlIIllIIIIIl -= d;
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl != 0.0) {
            this.IlllIIIIIIlllIlIIlllIlIIl = (float)((double)this.IlllIIIIIIlllIlIIlllIlIIl + d);
        }
        if (this.IllIllIIIllIIIlIlIlIIIIll) {
            if (this.IlllIIIIIIlllIlIIlllIlIIl < -this.lIllIlIIIlIIIIIIIlllIlIll + this.height) {
                this.IlllIIIIIIlllIlIIlllIlIIl = -this.lIllIlIIIlIIIIIIIlllIlIll + this.height;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0;
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl > 0.0f) {
                this.IlllIIIIIIlllIlIIlllIlIIl = 0.0f;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0;
            }
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0f, this.IlllIIIIIIlllIlIIlllIlIIl, 0.0f);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float f, float f2, boolean bl) {
        float f3;
        this.IllIllIIIllIIIlIlIlIIIIll = true;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        boolean bl2 = this.llIlllIIIllllIIlllIllIIIl();
        if (!(!this.llIlIIIllIIlIllIllIllllIl || Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && bl)) {
            this.llIlIIIllIIlIllIllIllllIl = false;
        }
        if (this.lIIlIlllIlIlIIIlllIIlIIII && !Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
            this.lIIlIlllIlIlIIIlllIIlIIII = false;
        }
        float f4 = this.height;
        float f5 = this.lIllIlIIIlIIIIIIIlllIlIll;
        float f6 = f4 / f5 * 100.0f;
        float f7 = f4 / 100.0f * f6;
        float f8 = this.IlllIIIIIIlllIlIIlllIlIIl / 100.0f * f6;
        if (Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIIlIlllIlIlIIIlllIIlIIII) {
            f3 = f2 - this.y;
            float f9 = f3 / this.height;
            this.IlllIIIIIIlllIlIIlllIlIIl = -(this.lIllIlIIIlIIIIIIIlllIlIll - this.height / 2.0f) + this.lIllIlIIIlIIIIIIIlllIlIll * f9 + f7 / 2.0f;
        }
        if (bl2) {
            f3 = this.height;
            if (this.llIlIIIllIIlIllIllIllllIl) {
                if (this.IlllIIIIIIlllIlIIlllIlIIl != this.IIlIllIlllllllIIlIIIllIIl && this.IIlIllIlllllllIIlIIIllIIl != f7 / 2.0f && this.IIlIllIlllllllIIlIIIllIIl != f7 / 2.0f + -this.lIllIlIIIlIIIIIIIlllIlIll + f3) {
                    if (f2 > this.y + this.height - f7 - f7 / 4.0f + f8) {
                        this.IlllIIIIIIlllIlIIlllIlIIl = f5 / 7.0f;
                    } else if (f2 < this.y + this.height - f7 / 4.0f + f8) {
                        this.IlllIIIIIIlllIlIIlllIlIIl += f5 / 7.0f;
                    }
                    this.IIlIllIlllllllIIlIIIllIIl = this.IlllIIIIIIlllIlIIlllIlIIl;
                } else if (f2 > this.y + this.height - f7 - f7 / 4.0f + f8 || f2 < this.y + this.height - f7 / 4.0f - f8) {
                    this.IIlIllIlllllllIIlIIIllIIl = 1.0f;
                }
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl < -this.lIllIlIIIlIIIIIIIlllIlIll + f3) {
                this.IlllIIIIIIlllIlIIlllIlIIl = -this.lIllIlIIIlIIIIIIIlllIlIll + f3;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0;
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl > 0.0f) {
                this.IlllIIIIIIlllIlIIlllIlIIl = 0.0f;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0;
            }
            boolean bl3 = f >= this.x && f <= this.x + this.width && f2 > this.y + this.height - f7 + f8 && f2 < this.y + this.height + f8;
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 540884285);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height + f8 - f7, this.width, f7, bl && (bl3 || Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIIlIlllIlIlIIIlllIIlIIII) ? 1625481954 : 0x20E2E2E2);
        }
        if (!bl2 && this.IlllIIIIIIlllIlIIlllIlIIl != 0.0f) {
            this.IlllIIIIIIlllIlIIlllIlIIl = 0.0f;
        }
    }

    public void llIlllIIIllllIIlllIllIIIl(float f, float f2, boolean bl) {
        if (this.lIIIllIllIIllIlllIlIIlllI != null && !this.lIIIllIllIIllIlllIlIIlllI.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIlIlIlIlIIlIIlIIllIIIIIl != 0.0) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0;
        }
        double d = Math.round(this.lIlIlIlIlIIlIIlIIllIIIIIl / 5.0);
        this.lIlIlIlIlIIlIIlIIllIIIIIl -= d;
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl != 0.0) {
            this.IlllIIIIIIlllIlIIlllIlIIl = (float)((double)this.IlllIIIIIIlllIlIIlllIlIIl - d);
        }
        if (this.IllIllIIIllIIIlIlIlIIIIll) {
            if (this.IlllIIIIIIlllIlIIlllIlIIl < -this.lIllIlIIIlIIIIIIIlllIlIll + this.height) {
                this.IlllIIIIIIlllIlIIlllIlIIl = -this.lIllIlIIIlIIIIIIIlllIlIll + this.height;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0;
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl > 0.0f) {
                this.IlllIIIIIIlllIlIIlllIlIIl = 0.0f;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0;
            }
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0f, -this.IlllIIIIIIlllIlIIlllIlIIl, 0.0f);
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll > this.height;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(float f, float f2, boolean bl) {
        float f3;
        this.IllIllIIIllIIIlIlIlIIIIll = true;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        boolean bl2 = this.llIlllIIIllllIIlllIllIIIl();
        if (!(!this.llIlIIIllIIlIllIllIllllIl || Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && bl)) {
            this.llIlIIIllIIlIllIllIllllIl = false;
        }
        if (this.lIIlIlllIlIlIIIlllIIlIIII && !Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
            this.lIIlIlllIlIlIIIlllIIlIIII = false;
        }
        float f4 = this.height;
        float f5 = this.lIllIlIIIlIIIIIIIlllIlIll;
        float f6 = f4 / f5 * 100.0f;
        float f7 = f4 / 100.0f * f6;
        float f8 = this.IlllIIIIIIlllIlIIlllIlIIl / 100.0f * f6;
        if (Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIIlIlllIlIlIIIlllIIlIIII) {
            f3 = f2 - this.y;
            float f9 = f3 / this.height;
            this.IlllIIIIIIlllIlIIlllIlIIl = -(this.lIllIlIIIlIIIIIIIlllIlIll * f9) + f7 / 2.0f + f9;
        }
        if (bl2) {
            boolean bl3;
            f3 = this.height;
            boolean bl4 = bl3 = f >= this.x && f <= this.x + this.width && f2 > this.y - f8 && f2 < this.y + f7 - f8;
            if (this.llIlIIIllIIlIllIllIllllIl) {
                if (this.IlllIIIIIIlllIlIIlllIlIIl != this.IIlIllIlllllllIIlIIIllIIl && this.IIlIllIlllllllIIlIIIllIIl != f7 / 2.0f && this.IIlIllIlllllllIIlIIIllIIl != f7 / 2.0f + -this.lIllIlIIIlIIIIIIIlllIlIll + f3) {
                    if (f2 > this.y + f7 - f7 / 4.0f - f8) {
                        this.IlllIIIIIIlllIlIIlllIlIIl -= f5 / 7.0f;
                    } else if (f2 < this.y + f7 / 4.0f - f8) {
                        this.IlllIIIIIIlllIlIIlllIlIIl += f5 / 7.0f;
                    }
                    this.IIlIllIlllllllIIlIIIllIIl = this.IlllIIIIIIlllIlIIlllIlIIl;
                } else if (f2 > this.y + f7 - f7 / 4.0f - f8 || f2 < this.y + f7 / 4.0f - f8) {
                    this.IIlIllIlllllllIIlIIIllIIl = 1.0f;
                }
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl < -this.lIllIlIIIlIIIIIIIlllIlIll + f3) {
                this.IlllIIIIIIlllIlIIlllIlIIl = -this.lIllIlIIIlIIIIIIIlllIlIll + f3;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0;
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl > 0.0f) {
                this.IlllIIIIIIlllIlIIlllIlIIl = 0.0f;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0;
            }
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 540884285);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y - f8, this.width, f7, bl && (bl3 || Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIIlIlllIlIlIIIlllIIlIIII) ? 1625481954 : 0x20E2E2E2);
        }
        if (!bl2 && this.IlllIIIIIIlllIlIIlllIlIIl != 0.0f) {
            this.IlllIIIIIIlllIlIIlllIlIIl = 0.0f;
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        if (n != 0 && this.lIllIlIIIlIIIIIIIlllIlIll >= this.height) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl += (double)((float)n / 3.0f);
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(double d) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = d;
    }

    public double llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(float f) {
        this.lIllIlIIIlIIIIIIIlllIlIll = f;
    }

    public boolean load() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public boolean lIIIllIllIIllIlllIlIIlllI() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }
}