package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class ScrollableUIComponent extends UIComponent {
    public double lIlIlIlIlIIlIIlIIllIIIIIl;
    public float IlllIIIIIIlllIlIIlllIlIIl;
    public float lIllIlIIIlIIIIIIIlllIlIll;
    public boolean llIlIIIllIIlIllIllIllllIl;
    public boolean IllIllIIIllIIIlIlIlIIIIll;
    public float IIlIllIlllllllIIlIIIllIIl;
    public boolean lIIlIlllIlIlIIIlllIIlIIII;

    public ScrollableUIComponent(UIComponent var1) {
        super(var1);
        this.onMouseClick((var1x, var2, var3) -> {
            if (this.mouseInside(var1x, var2)) {
                this.lIIlIlllIlIlIIIlllIIlIIII = true;
                return true;
            } else {
                return false;
            }
        });
    }

    public boolean mouseInside(float mouseX, float mouseY) {
        return mouseX >= this.x && mouseX <= this.x + this.width && mouseY > this.y && mouseY < this.y + this.height;
    }

    public void onUpdateScreen() {
    }

    public void drawComponent(float mouseX, float mouseY, boolean var3) {
    }

    public float lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, boolean var3) {
        if (this.parent != null && !this.parent.mouseInside(var1, var2) && this.lIlIlIlIlIIlIIlIIllIIIIIl != 0.0D) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
        }

        if (var3 && (this.parent == null || this.parent.mouseInside(var1, var2)) && this.lIlIlIlIlIIlIIlIIllIIIIIl != 0.0D) {
            this.IlllIIIIIIlllIlIIlllIlIIl = (float)((double)this.IlllIIIIIIlllIlIIlllIlIIl + this.lIlIlIlIlIIlIIlIIllIIIIIl / 8.0D);
            this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
        }

        if (this.IllIllIIIllIIIlIlIlIIIIll) {
            if (this.IlllIIIIIIlllIlIIlllIlIIl < -this.lIllIlIIIlIIIIIIIlllIlIll + this.height) {
                this.IlllIIIIIIlllIlIIlllIlIIl = -this.lIllIlIIIlIIIIIIIlllIlIll + this.height;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
            }

            if (this.IlllIIIIIIlllIlIIlllIlIIl > 0.0F) {
                this.IlllIIIIIIlllIlIIlllIlIIl = 0.0F;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
            }
        }

        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0F, this.IlllIIIIIIlllIlIIlllIlIIl, 0.0F);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float var1, float var2, boolean var3) {
        this.IllIllIIIllIIIlIlIlIIIIll = true;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        boolean var4 = this.llIlllIIIllllIIlllIllIIIl();
        if (this.llIlIIIllIIlIllIllIllllIl && (!Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) || !this.mouseInside(var1, var2) || !var3)) {
            this.llIlIIIllIIlIllIllIllllIl = false;
        }

        if (this.lIIlIlllIlIlIIIlllIIlIIII && !Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
            this.lIIlIlllIlIlIIIlllIIlIIII = false;
        }

        float var5 = this.height;
        float var6 = this.lIllIlIIIlIIIIIIIlllIlIll;
        float var7 = var5 / var6 * 100.0F;
        float var8 = var5 / 100.0F * var7;
        float var9 = this.IlllIIIIIIlllIlIIlllIlIIl / 100.0F * var7;
        float var10;
        if (Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIIlIlllIlIlIIIlllIIlIIII) {
            var10 = var2 - this.y;
            float var11 = var10 / this.height;
            this.IlllIIIIIIlllIlIIlllIlIIl = -(this.lIllIlIIIlIIIIIIIlllIlIll - this.height / 2.0F) + this.lIllIlIIIlIIIIIIIlllIlIll * var11 + var8 / 2.0F;
        }

        if (var4) {
            var10 = this.height;
            if (this.llIlIIIllIIlIllIllIllllIl) {
                if (this.IlllIIIIIIlllIlIIlllIlIIl != this.IIlIllIlllllllIIlIIIllIIl && this.IIlIllIlllllllIIlIIIllIIl != var8 / 2.0F && this.IIlIllIlllllllIIlIIIllIIl != var8 / 2.0F + -this.lIllIlIIIlIIIIIIIlllIlIll + var10) {
                    if (var2 > this.y + this.height - var8 - var8 / 4.0F + var9) {
                        this.IlllIIIIIIlllIlIIlllIlIIl = var6 / 7.0F;
                    } else if (var2 < this.y + this.height - var8 / 4.0F + var9) {
                        this.IlllIIIIIIlllIlIIlllIlIIl += var6 / 7.0F;
                    }

                    this.IIlIllIlllllllIIlIIIllIIl = this.IlllIIIIIIlllIlIIlllIlIIl;
                } else if (var2 > this.y + this.height - var8 - var8 / 4.0F + var9 || var2 < this.y + this.height - var8 / 4.0F - var9) {
                    this.IIlIllIlllllllIIlIIIllIIl = 1.0F;
                }
            }

            if (this.IlllIIIIIIlllIlIIlllIlIIl < -this.lIllIlIIIlIIIIIIIlllIlIll + var10) {
                this.IlllIIIIIIlllIlIIlllIlIIl = -this.lIllIlIIIlIIIIIIIlllIlIll + var10;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
            }

            if (this.IlllIIIIIIlllIlIIlllIlIIl > 0.0F) {
                this.IlllIIIIIIlllIlIIlllIlIIl = 0.0F;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
            }

            boolean var12 = var1 >= this.x && var1 <= this.x + this.width && var2 > this.y + this.height - var8 + var9 && var2 < this.y + this.height + var9;
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, -2145575651);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height + var9, this.width, this.height - var8 + var9, !var3 || !var12 && (!Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) || !this.lIIlIlllIlIlIIIlllIIlIIII) ? -1347015102 : -4837822);
        }

        if (!var4 && this.IlllIIIIIIlllIlIIlllIlIIl != 0.0F) {
            this.IlllIIIIIIlllIlIIlllIlIIl = 0.0F;
        }

    }

    public void llIlllIIIllllIIlllIllIIIl(float var1, float var2, boolean var3) {
        if (this.parent != null && !this.parent.mouseInside(var1, var2) && this.lIlIlIlIlIIlIIlIIllIIIIIl != 0.0D) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
        }

        if (var3 && (this.parent == null || this.parent.mouseInside(var1, var2)) && this.lIlIlIlIlIIlIIlIIllIIIIIl != 0.0D) {
            this.IlllIIIIIIlllIlIIlllIlIIl = (float)((double)this.IlllIIIIIIlllIlIIlllIlIIl - this.lIlIlIlIlIIlIIlIIllIIIIIl / 8.0D);
            this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
        }

        if (this.IllIllIIIllIIIlIlIlIIIIll) {
            if (this.IlllIIIIIIlllIlIIlllIlIIl < -this.lIllIlIIIlIIIIIIIlllIlIll + this.height) {
                this.IlllIIIIIIlllIlIIlllIlIIl = -this.lIllIlIIIlIIIIIIIlllIlIll + this.height;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
            }

            if (this.IlllIIIIIIlllIlIIlllIlIIl > 0.0F) {
                this.IlllIIIIIIlllIlIIlllIlIIl = 0.0F;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
            }
        }

        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0F, -this.IlllIIIIIIlllIlIIlllIlIIl, 0.0F);
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll > this.height;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(float var1, float var2, boolean var3) {
        this.IllIllIIIllIIIlIlIlIIIIll = true;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        boolean var4 = this.llIlllIIIllllIIlllIllIIIl();
        if (this.llIlIIIllIIlIllIllIllllIl && (!Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) || !this.mouseInside(var1, var2) || !var3)) {
            this.llIlIIIllIIlIllIllIllllIl = false;
        }

        if (this.lIIlIlllIlIlIIIlllIIlIIII && !Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
            this.lIIlIlllIlIlIIIlllIIlIIII = false;
        }

        float var5 = this.height;
        float var6 = this.lIllIlIIIlIIIIIIIlllIlIll;
        float var7 = var5 / var6 * 100.0F;
        float var8 = var5 / 100.0F * var7;
        float var9 = this.IlllIIIIIIlllIlIIlllIlIIl / 100.0F * var7;
        float var10;
        if (Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIIlIlllIlIlIIIlllIIlIIII) {
            var10 = var2 - this.y;
            float var11 = var10 / this.height;
            this.IlllIIIIIIlllIlIIlllIlIIl = -(this.lIllIlIIIlIIIIIIIlllIlIll * var11) + var8 / 2.0F;
        }

        if (var4) {
            var10 = this.height;
            boolean var12 = var1 >= this.x && var1 <= this.x + this.width && var2 > this.y - var9 && var2 < this.y + var8 - var9;
            if (this.llIlIIIllIIlIllIllIllllIl) {
                if (this.IlllIIIIIIlllIlIIlllIlIIl != this.IIlIllIlllllllIIlIIIllIIl && this.IIlIllIlllllllIIlIIIllIIl != var8 / 2.0F && this.IIlIllIlllllllIIlIIIllIIl != var8 / 2.0F + -this.lIllIlIIIlIIIIIIIlllIlIll + var10) {
                    if (var2 > this.y + var8 - var8 / 4.0F - var9) {
                        this.IlllIIIIIIlllIlIIlllIlIIl -= var6 / 7.0F;
                    } else if (var2 < this.y + var8 / 4.0F - var9) {
                        this.IlllIIIIIIlllIlIIlllIlIIl += var6 / 7.0F;
                    }

                    this.IIlIllIlllllllIIlIIIllIIl = this.IlllIIIIIIlllIlIIlllIlIIl;
                } else if (var2 > this.y + var8 - var8 / 4.0F - var9 || var2 < this.y + var8 / 4.0F - var9) {
                    this.IIlIllIlllllllIIlIIIllIIl = 1.0F;
                }
            }

            if (this.IlllIIIIIIlllIlIIlllIlIIl < -this.lIllIlIIIlIIIIIIIlllIlIll + var10) {
                this.IlllIIIIIIlllIlIIlllIlIIl = -this.lIllIlIIIlIIIIIIIlllIlIll + var10;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
            }

            if (this.IlllIIIIIIlllIlIIlllIlIIl > 0.0F) {
                this.IlllIIIIIIlllIlIIlllIlIIl = 0.0F;
                this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0D;
            }

            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, -2145575651);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y - var9, this.width, var8 - var9, !var3 || !var12 && (!Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) || !this.lIIlIlllIlIlIIIlllIIlIIII) ? -1347015102 : -4837822);
        }

        if (!var4 && this.IlllIIIIIIlllIlIIlllIlIIl != 0.0F) {
            this.IlllIIIIIIlllIlIIlllIlIIl = 0.0F;
        }

    }

    public void onKeyTyped(char var1, KeyType var2) {
    }

    public void handleMouseScrollDelta(int var1) {
        super.handleMouseScrollDelta(var1);
        if (var1 != 0 && this.lIllIlIIIlIIIIIIIlllIlIll >= this.height) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl += (float)var1 / 1.75F;
        }

    }

    public void onGuiClosed() {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1) {
        this.lIllIlIIIlIIIIIIIlllIlIll = var1;
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public boolean load() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }
}
