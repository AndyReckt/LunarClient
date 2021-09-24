package com.moonsworth.lunar.client.ui.component.type.setting;

import com.google.common.collect.Iterables;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 18:40
 */
public class ColorPickerUIComponent extends AbstractDescritiveSettingUIComponent<Number> {
    public static final int[] lIlIlIlIlIIlIIlIIllIIIIIl = new int[] {-5636096, -43691, -22016, -171, -16733696, -11141291, -11141121, -16733526, -16777046, -11184641, -43521, -5635926, -1, -5592406};
    public boolean llIlIIIllIIlIllIllIllllIl;
    public List<ColorSettingUIComponent> IllIllIIIllIIIlIlIlIIIIll;
    public List<ColorSettingUIComponent> IIlIllIlllllllIIlIIIllIIl;
    public ArrayDeque<ColorSettingUIComponent> lIIlIlllIlIlIIIlllIIlIIII;
    public lIllllIllIIlIIlIIIlIIIlII llIllIlIllIlllIllIIIIllII;
    public EnumSetting2UIComponent IllllllllllIlIIIlllIlllll;
    public IntSliderUIComponent lllllIllIlIIlIIlIIIlllIlI;
    public boolean IllIIIlllIIIlIlllIlIIlIII;

    public ColorPickerUIComponent(ColorSetting var1, UIComponent var2) {
        super(var1, var2);
        this.llIllIlIllIlllIllIIIIllII = new lIllllIllIIlIIlIIIlIIIlII(var1.IlllllIlIIIlIIlIIllIIlIll(), this);
        this.llIllIlIllIlllIllIIIIllII.setRunnable(() -> {
            if (var1.IlllllIlIIIlIIlIIllIIlIll().llIlllIIIllllIIlllIllIIIl()) {
                var1.IlIlIlllllIlIIlIlIlllIlIl(1.0F);
                var1.llIIIIIIIllIIllIlIllIIIIl(0.0F);
                var1.lIIIllIllIIllIlllIlIIlllI(0.0F);
            }

        });
        this.IllllllllllIlIIIlllIlllll = new EnumSetting2UIComponent(var1.llIIIlllIIlllIllllIlIllIl(), this);
        this.lllllIllIlIIlIIlIIIlllIlI = new IntSliderUIComponent(var1.llIIlIlIIIllIlIlIlIIlIIll(), this);
        this.IllIllIIIllIIIlIlIlIIIIll = new ArrayList<>(12);
        this.IIlIllIlllllllIIlIIIllIIl = new ArrayList<>(12);
        this.lIIlIlllIlIlIIIlllIIlIIII = new ArrayDeque<>(6);
        //this.IllIllIIIllIIIlIlIlIIIIll.clear();

        for (ColorSetting var4 : LunarClient.getInstance().IllllllllllIlIIIlllIlllll().llIlllIIIllllIIlllIllIIIl()) {
            this.IllIllIIIllIIIlIlIlIIIIll.add(new ColorSettingUIComponent(this, var4));
        }

        for(int var5 = 0; var5 < 12; ++var5) {
            this.IIlIllIlllllllIIlIIIllIIl.add(new ColorSettingUIComponent(this, new ColorSetting("def" + var5, lIlIlIlIlIIlIIlIIllIIIIIl[var5])));
        }

        this.onMouseClick((var3x, var4x, var5x) -> {
            boolean var6 = this.mouseInside(var3x, var4x) && var4x < this.y + 14.0F && var3x >= this.x + this.width - 20.0F;
            if (var4x < this.y + 14.0F && !var6) {
                this.llIlIIIllIIlIllIllIllllIl = !this.llIlIIIllIIlIllIllIllllIl;
                if (var2 != null) {
                    var2.setPositionAndSize(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight());
                }

                return true;
            } else {
                Iterator var7 = this.IIlIllIlllllllIIlIIIllIIl.iterator();

                ColorSettingUIComponent var8;
                while(var7.hasNext()) {
                    var8 = (ColorSettingUIComponent)var7.next();
                    if (var8.mouseInside(var3x, var4x)) {
                        return var8.onMouseClicked(var3x, var4x, var5x);
                    }
                }

                var7 = this.lIIlIlllIlIlIIIlllIIlIIII.iterator();

                while(var7.hasNext()) {
                    var8 = (ColorSettingUIComponent)var7.next();
                    if (var8.mouseInside(var3x, var4x)) {
                        return var8.onMouseClicked(var3x, var4x, var5x);
                    }
                }

                var7 = this.IllIllIIIllIIIlIlIlIIIIll.iterator();

                while(var7.hasNext()) {
                    var8 = (ColorSettingUIComponent)var7.next();
                    if (var8.mouseInside(var3x, var4x)) {
                        return var8.onMouseClicked(var3x, var4x, var5x);
                    }
                }

                if (!var6) {
                    if (this.llIllIlIllIlllIllIIIIllII.mouseInside(var3x, var4x)) {
                        return this.llIllIlIllIlllIllIIIIllII.onMouseClicked(var3x, var4x, var5x);
                    } else if (this.IllllllllllIlIIIlllIlllll.mouseInside(var3x, var4x)) {
                        return this.IllllllllllIlIIIlllIlllll.onMouseClicked(var3x, var4x, var5x);
                    } else {
                        return this.lllllIllIlIIlIIlIIIlllIlI.mouseInside(var3x, var4x) && this.lllllIllIlIIlIIlIIIlllIlI.onMouseClicked(var3x, var4x, var5x);
                    }
                } else {
                    boolean var10 = false;
                    Iterator var11 = this.IllIllIIIllIIIlIlIlIIIIll.iterator();

                    while(var11.hasNext()) {
                        ColorSettingUIComponent var9 = (ColorSettingUIComponent)var11.next();
                        if (var9.color.lIlIlIlIlIIlIIlIIllIIIIIl(var1)) {
                            var10 = true;
                            break;
                        }
                    }

                    if (var10) {
                        LunarClient.getInstance().IllllllllllIlIIIlllIlllll().llIlllIIIllllIIlllIllIIIl().removeIf((var1x) -> var1x.lIlIlIlIlIIlIIlIIllIIIIIl(var1));
                        LunarClient.getInstance().IllllllllllIlIIIlllIlllll().save();
                    } else {
                        if (LunarClient.getInstance().IllllllllllIlIIIlllIlllll().llIlllIIIllllIIlllIllIIIl().size() >= 12) {
                            LunarClient.getInstance().IllllllllllIlIIIlllIlllll().llIlllIIIllllIIlllIllIIIl().remove(Iterables.getFirst(LunarClient.getInstance().IllllllllllIlIIIlllIlllll().llIlllIIIllllIIlllIllIIIl(), (Object)null));
                        }

                        LunarClient.getInstance().IllllllllllIlIIIlllIlllll().lIlIlIlIlIIlIIlIIllIIIIIl(var1);
                    }
                    this.resoze(this.x, this.y, this.width);
                    return true;
                }
            }
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ColorSettingUIComponent var1) {
        if (!var1.color.lIlIlIlIlIIlIIlIIllIIIIIl((ColorSetting)this.setting)) {
            if (this.lIIlIlllIlIlIIIlllIIlIIII.size() >= 6) {
                this.lIIlIlllIlIlIIIlllIIlIIII.poll();
            }

            ((ColorSetting)this.setting).lIlIlIlIlIIlIIlIIllIIIIIl(var1.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F));
            ((ColorSetting)this.setting).IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(var1.color.IlllllIlIIIlIIlIIllIIlIll().llIlllIIIllllIIlllIllIIIl());
            ((ColorSetting)this.setting).llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(var1.color.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl());
            ((ColorSetting)this.setting).llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(var1.color.llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl());
            this.lIIlIlllIlIlIIIlllIIlIIII.add(var1.lIllIlIIIlIIIIIIIlllIlIll());
            this.resoze(this.x, this.y, this.width);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ColorSetting var1, ColorSetting var2) {
        var1.setColor((Integer)var2.llIlllIIIllllIIlllIllIIIl());
        var1.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(var2.IlllllIlIIIlIIlIIllIIlIll().llIlllIIIllllIIlllIllIIIl());
        var1.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(var2.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl());
        var1.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(var2.llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl());
    }

    public void resoze(float var1, float var2, float var3) {
        super.resoze(var1, var2, var3);
        this.IllIllIIIllIIIlIlIlIIIIll.clear();

        for (ColorSetting var5 : LunarClient.getInstance().IllllllllllIlIIIlllIlllll().llIlllIIIllllIIlllIllIIIl()) {
            this.IllIllIIIllIIIlIlIlIIIIll.add(new ColorSettingUIComponent(this, var5));
        }

        this.llIllIlIllIlllIllIIIIllII.setPositionAndSize(var1 + 7.0F, var2 + 17.0F, 110.0F, 12.0F);
        this.IllllllllllIlIIIlllIlllll.resoze(var1 + 7.0F, var2 + 43.0F, 110.0F);
        this.lllllIllIlIIlIIlIIIlllIlI.setPositionAndSize(var1 + 52.0F, var2 + 30.0F, 52.0F, 12.0F);
        int var8 = 0;

        int var6;
        ColorSettingUIComponent var7;
        int var9;
        for(var9 = 0; var9 < 6; ++var9) {
            for(var6 = 0; var6 < 2; ++var6) {
                var7 = (ColorSettingUIComponent)this.IIlIllIlllllllIIlIIIllIIl.get(var8);
                var7.setPositionAndSize(var1 + 271.5F + 10.0F * (float)var6, var2 + 15.0F + 10.0F * (float)var9, 8.0F, 8.0F);
                ++var8;
            }
        }

        var9 = 0;

        for(Iterator var10 = this.lIIlIlllIlIlIIIlllIIlIIII.iterator(); var10.hasNext(); ++var9) {
            var7 = (ColorSettingUIComponent)var10.next();
            var7.setPositionAndSize(var1 + 301.0F, var2 + 15.0F + 10.0F * (float)var9, 8.0F, 8.0F);
        }

        var8 = 0;

        for(var9 = 0; var9 < 6; ++var9) {
            for(var6 = 0; var6 < 2; ++var6) {
                if (this.IllIllIIIllIIIlIlIlIIIIll.size() > var8) {
                    var7 = (ColorSettingUIComponent)this.IllIllIIIllIIIlIlIlIIIIll.get(var8);
                    var7.setPositionAndSize(var1 + 318.5F + 10.0F * (float)var6, var2 + 15.0F + 10.0F * (float)var9, 8.0F, 8.0F);
                    ++var8;
                }
            }
        }

    }

    public float getHeight() {
        return this.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0F : (this.llIlIIIllIIlIllIllIllllIl ? 80.0F : 14.0F);
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    public void onUpdateScreen() {
    }

    public void drawComponent(float mouseX, float mouseY, boolean var3) {
        FontRegistry.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x, this.y + 1.5F, -4079426);
        FontRegistry.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl("#" + Integer.toHexString((Integer)((ColorSetting)this.setting).llIlllIIIllllIIlllIllIIIl() & 16777215), this.x + this.width - 68.0F, this.y + 2.5F, -2134785858);
        float var4 = this.x + this.width - 84.0F;
        float var5 = this.y + 2.0F;
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(var4, var5, 10.0F, 10.0F, 8.0F, ((ColorSetting)this.setting).lIlIlIlIlIIlIIlIIllIIIIIl(var4 + var5), true, true, true, true);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - 83.0F, this.y + 3.0F, 8.0F, 8.0F, 3.0F, -1342177281, true, true, true, true);
        boolean var6 = false;
        Iterator var7 = this.IllIllIIIllIIIlIlIlIIIIll.iterator();

        while(var7.hasNext()) {
            ColorSettingUIComponent var8 = (ColorSettingUIComponent)var7.next();
            if (var8.color.lIlIlIlIlIIlIIlIIllIIIIIl((ColorSetting)this.setting)) {
                var6 = true;
                break;
            }
        }

        boolean var20 = this.mouseInside(mouseX, mouseY) && var3 && mouseY < this.y + 14.0F && mouseX >= this.x + this.width - 20.0F;
        GL11.glColor4f(var6 ? 0.8F : 0.0F, var6 ? 0.8F : 0.0F, 0.0F, var20 ? 0.8F : 0.5F);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(AbstractUIScreen.llllIIlIIlIIlIIllIIlIIllI, 3.0F, this.x + this.width - 17.5F, this.y + 4.0F);
        if (this.llIlIIIllIIlIllIllIllllIl) {
            AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 14.0F, 112.0F, this.height - 20.0F, 4.0F, 536870912);
            FontRegistry.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((ColorSetting)this.setting).llIIlIlIIIllIlIlIlIIlIIll().get(((ColorSetting)this.setting).llIIlIlIIIllIlIlIlIIlIIll().lIIlIlllIlIlIIIlllIIlIIII()), this.x + 7.0F, this.y + 31.0F, -4079426);
            this.llIllIlIllIlllIllIIIIllII.drawComponent(mouseX, mouseY, var3);
            this.IllllllllllIlIIIlllIlllll.drawComponent(mouseX, mouseY, var3);
            this.lllllIllIlIIlIIlIIIlllIlI.drawComponent(mouseX, mouseY, var3);
            float var21 = this.x + 118.0F;
            float var9 = this.y + 14.0F;
            float var10 = 114.0F;
            float var11 = this.height - 20.0F;
            AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(var21, this.y + 14.0F, var10, var11, 4.0F, -1);
            boolean var12 = false;

            float var15;
            float var16;
            int var17;
            for(int var13 = 0; (float)var13 < var10 - 2.0F; ++var13) {
                for(int var14 = 0; (float)var14 < var11 - 2.0F; ++var14) {
                    var15 = (float)var13 / (var10 - 2.0F);
                    var16 = 1.0F - (float)var14 / (var11 - 2.0F);
                    var17 = Color.HSBtoRGB(((ColorSetting)this.setting).IlIlIlllllIlIIlIlIlllIlIl(), var15, var16);
                    boolean var18 = mouseX >= var21 + 1.0F + (float)var13 && mouseX <= var21 + 2.0F + (float)var13 && mouseY >= var9 + 1.0F + (float)var14 && mouseY <= var9 + 2.0F + (float)var14;
                    if (Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && var18) {
                        float var19 = ((ColorSetting)this.setting).llllIIlIIlIIlIIllIIlIIllI(0.0F);
                        ((ColorSetting)this.setting).lIlIlIlIlIIlIIlIIllIIIIIl(var17);
                        ((ColorSetting)this.setting).IlllllIlIIIlIIlIIllIIlIll(var19);
                        var12 = true;
                    }

                    AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(var21 + 1.0F + (float)var13, var9 + 1.0F + (float)var14, 1.0F, 1.0F, var17);
                }
            }

            if (this.IllIIIlllIIIlIlllIlIIlIII && !var12) {
                if (!Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0)) {
                    AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                }

                if (this.lIIlIlllIlIlIIIlllIIlIIII.size() >= 6) {
                    this.lIIlIlllIlIlIIIlllIIlIIII.poll();
                }

                ColorSetting var22 = new ColorSetting("recent", (Integer)((ColorSetting)this.setting).llIlllIIIllllIIlllIllIIIl());
                this.lIlIlIlIlIIlIIlIIllIIIIIl(var22, (ColorSetting)this.setting);
                this.lIIlIlllIlIlIIIlllIIlIIII.add(new ColorSettingUIComponent(this, var22));
                this.resoze(this.x, this.y, this.width);
            }

            this.IllIIIlllIIIlIlllIlIIlIII = var12;
            float var23 = ((ColorSetting)this.setting).llIIIIIIIllIIllIlIllIIIIl();
            float var24 = 1.0F - ((ColorSetting)this.setting).lIIIllIllIIllIlllIlIIlllI();
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var21 + 1.0F + (var10 - 2.0F) * var23, var9 + 1.0F + (var11 - 2.0F) * var24, 2.0D, -16777216);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var21 + 1.0F + (var10 - 2.0F) * var23, var9 + 1.0F + (var11 - 2.0F) * var24, 1.0D, -1);
            AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x + 238.0F, this.y + 14.0F, 9.0F, this.height - 20.0F, 4.0F, -1);

            for(int var25 = 0; (float)var25 < var11 - 2.0F; ++var25) {
                boolean var26 = mouseX >= this.x + 239.0F && mouseX <= this.x + 239.0F + 7.0F && mouseY >= this.y + 15.0F + (float)var25 && mouseY <= this.y + 16.0F + (float)var25;
                if (Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && var26) {
                    ((ColorSetting)this.setting).llIIlIlIIIllIlIlIlIIlIIll((float)var25 / (var11 - 2.0F));
                }

                AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 239.0F, var9 + 1.0F + (float)var25, 7.0F, 1.0F, Color.HSBtoRGB((float)var25 / (var11 - 2.0F), 1.0F, 1.0F));
            }

            var15 = Math.min(0.925F, ((ColorSetting)this.setting).IlIlIlllllIlIIlIlIlllIlIl());
            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x + 244.5F, var9 + 1.0F + (var11 - 2.0F) * var15, 3.5F, -1);
            AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x + 252.0F, this.y + 14.0F, 9.0F, this.height - 20.0F, 4.0F, -1);

            int var27;
            for(var27 = 0; (float)var27 < (var11 - 4.0F - 2.0F) / 4.0F; ++var27) {
                for(var17 = 0; var17 < 2; ++var17) {
                    if (var27 % 2 == 0) {
                        if (var17 % 2 == 0) {
                            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 253.0F + (float)var17 * 3.5F, this.y + 17.0F + (float)(var27 * 4), 3.5F, 4.0F, 1342177280);
                        } else {
                            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 253.0F + (float)var17 * 3.5F, this.y + 17.0F + (float)(var27 * 4) + 4.0F, 3.5F, 4.0F, 1342177280);
                        }
                    }
                }
            }

            int var30;
            for(var27 = 0; (float)var27 < var11 - 2.0F; ++var27) {
                boolean var28 = mouseX >= this.x + 253.0F && mouseX <= this.x + 253.0F + 7.0F && mouseY >= this.y + 15.0F + (float)var27 && mouseY <= this.y + 16.0F + (float)var27;
                if (Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && var28) {
                    ((ColorSetting)this.setting).IlllllIlIIIlIIlIIllIIlIll(1.0F - (float)var27 / (var11 - 2.0F));
                }

                var30 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(1.0F, 1.0F, 1.0F, 1.0F - (float)var27 / (var11 - 2.0F));
                AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 253.0F, this.y + 15.0F + (float)var27, 7.0F, 1.0F, var30);
            }

            var16 = Math.min(0.925F, 1.0F - ((ColorSetting)this.setting).llllIIlIIlIIlIIllIIlIIllI());
            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x + 258.5F, var9 + 1.0F + (var11 - 2.0F) * var16, 3.5F, -52429);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 266.0F, this.y + 14.0F, 0.5F, this.height - 20.0F, 547529378);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 314.0F, this.y + 14.0F, 0.5F, this.height - 20.0F, 547529378);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + 295.0F, this.y + 14.0F, 0.5F, this.height - 20.0F, 547529378);
            Iterator var29 = this.IIlIllIlllllllIIlIIIllIIl.iterator();

            ColorSettingUIComponent var31;
            while(var29.hasNext()) {
                var31 = (ColorSettingUIComponent)var29.next();
                var31.drawComponent(mouseX, mouseY, var3);
            }

            var29 = this.lIIlIlllIlIlIIIlllIIlIIII.iterator();

            while(var29.hasNext()) {
                var31 = (ColorSettingUIComponent)var29.next();
                var31.drawComponent(mouseX, mouseY, var3);
            }

            var29 = this.IllIllIIIllIIIlIlIlIIIIll.iterator();

            while(var29.hasNext()) {
                var31 = (ColorSettingUIComponent)var29.next();
                var31.drawComponent(mouseX, mouseY, var3);
            }

            for(var17 = 0; var17 < 6; ++var17) {
                AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x + 301.0F, this.y + 15.0F + 10.0F * (float)var17, 8.0F, 8.0F, 4.0F, 889192448);
            }

            for(var17 = 0; var17 < 6; ++var17) {
                for(var30 = 0; var30 < 2; ++var30) {
                    AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x + 318.5F + 10.0F * (float)var30, this.y + 15.0F + 10.0F * (float)var17, 8.0F, 8.0F, 4.0F, 889192448);
                }
            }
        }

    }

    public void onKeyTyped(char var1, KeyType var2) {
    }

    public void onGuiClosed() {
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }
}