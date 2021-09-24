package com.moonsworth.lunar.client.feature.type.waypoints;

import org.lwjgl.opengl.GL11;

public class WaypointRenderer
    extends WapointRendererBase {
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, int n, int n2) {
        float f4 = this.IlllIIIIIIlllIlIIlllIlIIl == 100021 ? -1.0f : 1.0f;
        float f5 = (float)Math.PI * 2 / (float)n;
        float f6 = (f2 - f) / (float)n2;
        float f7 = f3 / (float)n2;
        float f8 = (f - f2) / f3;
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl == 100010) {
            GL11.glBegin(0);
            for (int i = 0; i < n; ++i) {
                float f9 = this.IlllIIIIIIlllIlIIlllIlIIl((float)i * f5);
                float f10 = this.lIlIlIlIlIIlIIlIIllIIIIIl((float)i * f5);
                this.lIlIlIlIlIIlIIlIIllIIIIIl(f9 * f4, f10 * f4, f8 * f4);
                float f11 = 0.0f;
                float f12 = f;
                for (int j = 0; j <= n2; ++j) {
                    GL11.glVertex3f(f9 * f12, f10 * f12, f11);
                    f11 += f7;
                    f12 += f6;
                }
            }
            GL11.glEnd();
        } else if (this.lIlIlIlIlIIlIIlIIllIIIIIl != 100011 && this.lIlIlIlIlIIlIIlIIllIIIIIl != 100013) {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl == 100012) {
                float f13 = 1.0f / (float)n;
                float f14 = 1.0f / (float)n2;
                float f15 = 0.0f;
                float f16 = 0.0f;
                float f17 = f;
                for (int i = 0; i < n2; ++i) {
                    float f18 = 0.0f;
                    GL11.glBegin(8);
                    for (int j = 0; j <= n; ++j) {
                        float f19;
                        float f20;
                        if (j == n) {
                            f20 = this.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f);
                            f19 = this.IlllIIIIIIlllIlIIlllIlIIl(0.0f);
                        } else {
                            f20 = this.lIlIlIlIlIIlIIlIIllIIIIIl((float)j * f5);
                            f19 = this.IlllIIIIIIlllIlIIlllIlIIl((float)j * f5);
                        }
                        if (f4 == 1.0f) {
                            this.lIlIlIlIlIIlIIlIIllIIIIIl(f20 * f4, f19 * f4, f8 * f4);
                            this.lIlIlIlIlIIlIIlIIllIIIIIl(f18, f15);
                            GL11.glVertex3f(f20 * f17, f19 * f17, f16);
                            this.lIlIlIlIlIIlIIlIIllIIIIIl(f20 * f4, f19 * f4, f8 * f4);
                            this.lIlIlIlIlIIlIIlIIllIIIIIl(f18, f15 + f14);
                            GL11.glVertex3f(f20 * (f17 + f6), f19 * (f17 + f6), f16 + f7);
                        } else {
                            this.lIlIlIlIlIIlIIlIIllIIIIIl(f20 * f4, f19 * f4, f8 * f4);
                            this.lIlIlIlIlIIlIIlIIllIIIIIl(f18, f15);
                            GL11.glVertex3f(f20 * f17, f19 * f17, f16);
                            this.lIlIlIlIlIIlIIlIIllIIIIIl(f20 * f4, f19 * f4, f8 * f4);
                            this.lIlIlIlIlIIlIIlIIllIIIIIl(f18, f15 + f14);
                            GL11.glVertex3f(f20 * (f17 + f6), f19 * (f17 + f6), f16 + f7);
                        }
                        f18 += f13;
                    }
                    GL11.glEnd();
                    f17 += f6;
                    f15 += f14;
                    f16 += f7;
                }
            }
        } else {
            float f21;
            float f22;
            int n3;
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl == 100011) {
                float f23 = 0.0f;
                float f24 = f;
                for (int i = 0; i <= n2; ++i) {
                    GL11.glBegin(2);
                    for (n3 = 0; n3 < n; ++n3) {
                        f22 = this.IlllIIIIIIlllIlIIlllIlIIl((float)n3 * f5);
                        f21 = this.lIlIlIlIlIIlIIlIIllIIIIIl((float)n3 * f5);
                        this.lIlIlIlIlIIlIIlIIllIIIIIl(f22 * f4, f21 * f4, f8 * f4);
                        GL11.glVertex3f(f22 * f24, f21 * f24, f23);
                    }
                    GL11.glEnd();
                    f23 += f7;
                    f24 += f6;
                }
            } else if ((double)f != 0.0) {
                GL11.glBegin(2);
                for (n3 = 0; n3 < n; ++n3) {
                    f22 = this.IlllIIIIIIlllIlIIlllIlIIl((float)n3 * f5);
                    f21 = this.lIlIlIlIlIIlIIlIIllIIIIIl((float)n3 * f5);
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(f22 * f4, f21 * f4, f8 * f4);
                    GL11.glVertex3f(f22 * f, f21 * f, 0.0f);
                }
                GL11.glEnd();
                GL11.glBegin(2);
                for (n3 = 0; n3 < n; ++n3) {
                    f22 = this.IlllIIIIIIlllIlIIlllIlIIl((float)n3 * f5);
                    f21 = this.lIlIlIlIlIIlIIlIIllIIIIIl((float)n3 * f5);
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(f22 * f4, f21 * f4, f8 * f4);
                    GL11.glVertex3f(f22 * f2, f21 * f2, f3);
                }
                GL11.glEnd();
            }
            GL11.glBegin(1);
            for (n3 = 0; n3 < n; ++n3) {
                f22 = this.IlllIIIIIIlllIlIIlllIlIIl((float)n3 * f5);
                f21 = this.lIlIlIlIlIIlIIlIIllIIIIIl((float)n3 * f5);
                this.lIlIlIlIlIIlIIlIIllIIIIIl(f22 * f4, f21 * f4, f8 * f4);
                GL11.glVertex3f(f22 * f, f21 * f, 0.0f);
                GL11.glVertex3f(f22 * f2, f21 * f2, f3);
            }
            GL11.glEnd();
        }
    }
}
