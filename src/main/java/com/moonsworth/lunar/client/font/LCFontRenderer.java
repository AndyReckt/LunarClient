package com.moonsworth.lunar.client.font;

import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.util.FontCharParser;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 15:58
 */
public class LCFontRenderer extends LCFont {

    public char lIlIIIIIIlIIIllllIllIIlII = (char)167;
    public LCFont.CharData[] lIIIllIllIIllIlllIlIIlllI = new LCFont.CharData[256];
    public LCFont.CharData[] IlllllIlIIIlIIlIIllIIlIll = new LCFont.CharData[256];
    public LCFont.CharData[] llIIlIlIIIllIlIlIlIIlIIll = new LCFont.CharData[256];
    public final int[] llIlIIIllIIlIllIllIllllIl = new int[32];
    public final String IllIllIIIllIIIlIlIlIIIIll = "0123456789abcdefklmnor";
    public int llIIIlllIIlllIllllIlIllIl;
    public int lllllIllIllIllllIlIllllII;
    public int lllIIIIIlllIIlIllIIlIIIlI;

    public LCFontRenderer(ResourceLocationBridge resourceLocationBridge, float f) {
        super(resourceLocationBridge, f);
        this.IlIlIlllllIlIIlIlIlllIlIl();
        this.llllIIlIIlIIlIIllIIlIIllI();
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(String string, double d, double d2, int n, int n2) {
        float f = this.lIlIlIlIlIIlIIlIIllIIIIIl(string, d + 1.0, d2 + 1.0, n2, false);
        return Math.max(f, this.lIlIlIlIlIIlIIlIIllIIIIIl(string, d, d2, n, false));
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(String string, double d, double d2, int n) {
        float f = this.lIlIlIlIlIIlIIlIIllIIIIIl(string, d + 1.0, d2 + 1.0, n, true);
        return Math.max(f, this.lIlIlIlIlIIlIIlIIllIIIIIl(string, d, d2, n, false));
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, float f2, int n) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(string, f, f2, n, false);
    }

    public float IlllIIIIIIlllIlIIlllIlIIl(String string, float f, float f2, int n) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(string, f - (float)(this.IlllIIIIIIlllIlIIlllIlIIl(string) / 2), f2, n);
    }

    public float lIllIlIIIlIIIIIIIlllIlIll(String string, float f, float f2, int n) {
        float f3 = this.lIlIlIlIlIIlIIlIIllIIIIIl(string, (double)(f - (float)(this.IlllIIIIIIlllIlIIlllIlIIl(string) / 2)) + 1.0, (double)f2 + 1.0, n, true);
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(string, f - (float)(this.IlllIIIIIIlllIlIIlllIlIIl(string) / 2), f2, n);
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(String string, double d, double d2, int n, boolean bl) {
        d -= 1.0;
        if (string == null) {
            return 0.0f;
        }
        if (n == 0x20FFFFFF) {
            n = 0xFFFFFF;
        }
        if ((n & 0xFC000000) == 0) {
            n |= 0xFF000000;
        }
        if (bl) {
            n = (n & 0xFCFCFC) >> 2 | n & 0xFF000000;
        }
        LCFont.CharData[] charDataArray = this.lIlIlIlIlIIlIIlIIllIIIIIl;
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = true;
        d *= 2.0;
        d2 = (d2 - 3.0) * 2.0;
        if (bl7) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(0.5, 0.5, 0.5);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$blendFunc(770, 771);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color((float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, f);
            int n2 = string.length();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$bindTexture(this.llIIIIIIIllIIllIlIllIIIIl);
            for (int i = 0; i < n2; ++i) {
                char c = string.charAt(i);
                if (c == this.lIlIIIIIIlIIIllllIllIIlII) {
                    int n3 = 21;
                    try {
                        n3 = "0123456789abcdefklmnor".indexOf(string.charAt(i + 1));
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    if (n3 < 16) {
                        bl3 = false;
                        bl4 = false;
                        bl2 = false;
                        bl6 = false;
                        bl5 = false;
                        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$bindTexture(this.llIIIIIIIllIIllIlIllIIIIl);
                        charDataArray = this.lIlIlIlIlIIlIIlIIllIIIIIl;
                        if (n3 < 0 || n3 > 15) {
                            n3 = 15;
                        }
                        if (bl) {
                            n3 += 16;
                        }
                        int n4 = this.llIlIIIllIIlIllIllIllllIl[n3];
                        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color((float)(n4 >> 16 & 0xFF) / 255.0f, (float)(n4 >> 8 & 0xFF) / 255.0f, (float)(n4 & 0xFF) / 255.0f, f);
                    } else if (n3 == 16) {
                        bl2 = true;
                    } else if (n3 == 17) {
                        bl3 = true;
                        if (bl4) {
                            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$bindTexture(this.lllIIIIIlllIIlIllIIlIIIlI);
                            charDataArray = this.llIIlIlIIIllIlIlIlIIlIIll;
                        } else {
                            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$bindTexture(this.llIIIlllIIlllIllllIlIllIl);
                            charDataArray = this.lIIIllIllIIllIlllIlIIlllI;
                        }
                    } else if (n3 == 18) {
                        bl5 = true;
                    } else if (n3 == 19) {
                        bl6 = true;
                    } else if (n3 == 20) {
                        bl4 = true;
                        if (bl3) {
                            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$bindTexture(this.lllIIIIIlllIIlIllIIlIIIlI);
                            charDataArray = this.llIIlIlIIIllIlIlIlIIlIIll;
                        } else {
                            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$bindTexture(this.lllllIllIllIllllIlIllllII);
                            charDataArray = this.IlllllIlIIIlIIlIIllIIlIll;
                        }
                    } else if (n3 == 21) {
                        bl3 = false;
                        bl4 = false;
                        bl2 = false;
                        bl6 = false;
                        bl5 = false;
                        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color((float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, f);
                        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$bindTexture(this.llIIIIIIIllIIllIlIllIIIIl);
                        charDataArray = this.lIlIlIlIlIIlIIlIIllIIIIIl;
                    }
                    ++i;
                    continue;
                }
                if (c >= charDataArray.length || c < 0) continue;
                this.lIlIlIlIlIIlIIlIIllIIIIIl(charDataArray, c, (float)d, (float)d2 + 6.0f, n);
                if (bl5) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(d, d2 + (double)(charDataArray[c].IlllIIIIIIlllIlIIlllIlIIl / 2), d + (double)charDataArray[c].lIlIlIlIlIIlIIlIIllIIIIIl - 8.0, d2 + (double)(charDataArray[c].IlllIIIIIIlllIlIIlllIlIIl / 2), 1.0f);
                }
                if (bl6) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(d, d2 + (double)charDataArray[c].IlllIIIIIIlllIlIIlllIlIIl - 2.0, d + (double)charDataArray[c].lIlIlIlIlIIlIIlIIllIIIIIl - 8.0, d2 + (double)charDataArray[c].IlllIIIIIIlllIlIIlllIlIIl - 2.0, 1.0f);
                }
                d += charDataArray[c].lIlIlIlIlIIlIIlIIllIIIIIl - 8 + this.IlIlIlllllIlIIlIlIlllIlIl;
            }
            GL11.glHint(3155, 4352);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        }
        return (float)d / 2.0f;
    }


    public String lIlIlIlIlIIlIIlIIllIIIIIl(String string, double d) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(string, d, false);
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl(String string, double d, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        float f = 0.0f;
        int n = bl ? string.length() - 1 : 0;
        int n2 = bl ? -1 : 1;
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i = n; i >= 0 && i < string.length() && f < (float)d; i += n2) {
            char c = string.charAt(i);
            double d2 = this.IlllIIIIIIlllIlIIlllIlIIl(String.valueOf(c));
            if (bl2) {
                bl2 = false;
                if (c != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        bl3 = false;
                    }
                } else {
                    bl3 = true;
                }
            } else if (d2 < 0.0) {
                bl2 = true;
            } else {
                f = (float)((double)f + d2);
                if (bl3) {
                    f += 1.0f;
                }
            }
            if (f > (float)d) break;
            if (bl) {
                stringBuilder.insert(0, c);
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    @Override
    public int IlllIIIIIIlllIlIIlllIlIIl(String string) {
        if (string == null) {
            return 0;
        }
        int n = 0;
        LCFont.CharData[] charDataArray = this.lIlIlIlIlIIlIIlIIllIIIIIl;
        boolean bl = false;
        boolean bl2 = false;
        int n2 = string.length();
        for (int i = 0; i < n2; ++i) {
            char c = string.charAt(i);
            if (c == this.lIlIIIIIIlIIIllllIllIIlII && i < n2) {
                int n3 = "0123456789abcdefklmnor".indexOf(c);
                if (n3 < 16) {
                    bl = false;
                    bl2 = false;
                } else if (n3 == 17) {
                    bl = true;
                    charDataArray = bl2 ? this.llIIlIlIIIllIlIlIlIIlIIll : this.lIIIllIllIIllIlllIlIIlllI;
                } else if (n3 == 20) {
                    bl2 = true;
                    charDataArray = bl ? this.llIIlIlIIIllIlIlIlIIlIIll : this.IlllllIlIIIlIIlIIllIIlIll;
                } else if (n3 == 21) {
                    bl = false;
                    bl2 = false;
                    charDataArray = this.lIlIlIlIlIIlIIlIIllIIIIIl;
                }
                ++i;
                continue;
            }
            if (c >= charDataArray.length || c < 0) continue;
            n += charDataArray[c].lIlIlIlIlIIlIIlIIllIIIIIl - 8 + this.IlIlIlllllIlIIlIlIlllIlIl;
        }
        return n / 2;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(bl);
        this.llllIIlIIlIIlIIllIIlIIllI();
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        super.IlllIIIIIIlllIlIIlllIlIIl(bl);
        this.llllIIlIIlIIlIIllIIlIIllI();
    }

    public void llllIIlIIlIIlIIllIIlIIllI() {
        Bridge.lIIIllIllIIllIlllIlIIlllI().bridge$deleteTexture(this.llIIIlllIIlllIllllIlIllIl);
        Bridge.lIIIllIllIIllIlllIlIIlllI().bridge$deleteTexture(this.lllllIllIllIllllIlIllllII);
        Bridge.lIIIllIllIIllIlllIlIIlllI().bridge$deleteTexture(this.lllIIIIIlllIIlIllIIlIIIlI);
        this.llIIIlllIIlllIllllIlIllIl = this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.deriveFont(1), this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl, this.lIIIllIllIIllIlllIlIIlllI);
        this.lllllIllIllIllllIlIllllII = this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.deriveFont(2), this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl, this.IlllllIlIIIlIIlIIllIIlIll);
        this.lllIIIIIlllIIlIllIIlIIIlI = this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.deriveFont(3), this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl, this.llIIlIlIIIllIlIlIlIIlIIll);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3, double d4, float f) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        GL11.glLineWidth(f);
        GL11.glBegin(1);
        GL11.glVertex2d(d, d2);
        GL11.glVertex2d(d3, d4);
        GL11.glEnd();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
    }

    public String IlllIIIIIIlllIlIIlllIlIIl(String string, double d) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        boolean bl = false;
        for (char c : string.toCharArray()) {
            String string2;
            String string3;
            if (bl) {
                stringBuilder.append(c);
                bl = false;
                continue;
            }
            if (c == '§') {
                stringBuilder.append(c);
                bl = true;
                continue;
            }
            stringBuilder.append(c);
            int n = this.IlllIIIIIIlllIlIIlllIlIIl(stringBuilder.toString());
            if (!((double)n >= d)) continue;
            String string4 = stringBuilder.toString();
            if (string4.contains(" ")) {
                string3 = string4.substring(0, string4.lastIndexOf(" "));
                string2 = string4.substring(string4.lastIndexOf(" "));
                if (string2.startsWith(" ")) {
                    string2 = string2.replaceFirst(" ", "");
                }
            } else {
                string3 = string4.substring(0, string4.length() - 1);
                string2 = string4.substring(string4.length() - 1);
            }
            stringBuilder2.append(string3).append("\n");
            String string5 = FontCharParser.lIlIlIlIlIIlIIlIIllIIIIIl(stringBuilder.toString());
            stringBuilder.setLength(0);
            stringBuilder.append(string2).append(string5);
        }
        stringBuilder2.append(stringBuilder);
        return stringBuilder2.length() == 0 ? string : stringBuilder2.toString();
    }

    public List<String> lIllIlIIIlIIIIIIIlllIlIll(String string, double d) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if ((double)this.IlllIIIIIIlllIlIIlllIlIIl(string) > d || string.contains("\n")) {
            String[] stringArray = string.split(" ");
            String string2 = "";
            String string3 = "";
            for (String string4 : stringArray) {
                if (string4.equals("\n")) {
                    arrayList.add(string2);
                    string2 = "";
                }
                StringBuilder stringBuilder = new StringBuilder();
                if ((double)this.IlllIIIIIIlllIlIIlllIlIIl(stringBuilder.append(string2).append(string4).append(" ").toString()) < d) {
                    string2 = string2 + string4 + " ";
                } else {
                    arrayList.add(string2);
                    string2 = string3 + string4 + " ";
                }
                String string5 = EnumChatColor.lIllIlIIIlIIIIIIIlllIlIll(string4);
                if (string5.equals("")) continue;
                string3 = string5;
            }
            if (string2.length() > 0) {
                if ((double)this.IlllIIIIIIlllIlIIlllIlIIl(string2) < d) {
                    arrayList.add(string2 + " ");
                } else {
                    arrayList.addAll(this.llIlllIIIllllIIlllIllIIIl(string2, d));
                }
            }
        } else {
            arrayList.add(string);
        }
        return arrayList;
    }

    public List<String> llIlllIIIllllIIlllIllIIIl(String string, double d) {
        ArrayList<String> arrayList = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        char c = 'F';
        char[] cArray = string.toCharArray();
        for (int i = 0; i < cArray.length; ++i) {
            char c2 = cArray[i];
            if (c2 == this.lIlIIIIIIlIIIllllIllIIlII && i < cArray.length - 1) {
                c = cArray[i + 1];
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            if ((double)this.IlllIIIIIIlllIlIIlllIlIIl(stringBuilder2.append(stringBuilder).append(c2).toString()) < d) {
                stringBuilder.append(c2);
                continue;
            }
            arrayList.add(stringBuilder.toString());
            stringBuilder = new StringBuilder(this.lIlIIIIIIlIIIllllIllIIlII + "" + c + c2);
        }
        if (stringBuilder.length() > 0) {
            arrayList.add(stringBuilder.toString());
        }
        return arrayList;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl() {
        for (int i = 0; i < 32; ++i) {
            int n = (i >> 3 & 1) * 85;
            int n2 = (i >> 2 & 1) * 170 + n;
            int n3 = (i >> 1 & 1) * 170 + n;
            int n4 = (i & 1) * 170 + n;
            if (i == 6) {
                n2 += 85;
            }
            if (i >= 16) {
                n2 /= 4;
                n3 /= 4;
                n4 /= 4;
            }
            this.llIlIIIllIIlIllIllIllllIl[i] = (n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n4 & 0xFF;
        }
    }

}

