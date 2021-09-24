package com.moonsworth.lunar.client.feature.type.blur;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.shader.ShaderBridge;
import com.moonsworth.lunar.bridge.minecraft.client.shader.ShaderGroupBridge;
import com.moonsworth.lunar.bridge.minecraft.client.shader.ShaderUniformBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.gui.GuiOpenEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;
import com.moonsworth.lunar.client.ui.ease.ExponentialEase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 18:36
 */
public class MenuBlurMod extends ConfigurableFeature {
    public static final ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI = Bridge.getInstance().initResourceLocation("shaders/post/menu_blur.json");
    public boolean IlIlIlllllIlIIlIlIlllIlIl = true;
    public float llIIIIIIIllIIllIlIllIIIIl = 0.0F;
    public final ExponentialEase lIIIllIllIIllIlllIlIIlllI = new ExponentialEase(125L);
    public final List<ShaderUniformBridge> IlllllIlIIIlIIlIIllIIlIll = new ArrayList<>();
    public NumberSetting llIIlIlIIIllIlIlIlIIlIIll;
    public MenuBlurMod.lIlIlIlIlIIlIIlIIllIIIIIl llIIIlllIIlllIllllIlIllIl;
    public MenuBlurMod.lIlIlIlIlIIlIIlIIllIIIIIl lllIIIIIlllIIlIllIIlIIIlI;
    public MenuBlurMod.lIlIlIlIlIIlIIlIIllIIIIIl lIlIIIIIIlIIIllllIllIIlII;

    public MenuBlurMod() {
        super(true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiOpenEvent.class, (var1) -> {
            if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() == null) {
                this.lIlIlIIIIIIllIlIIIIllIIII();
            }
        });
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        this.llIIlIlIIIllIlIlIlIIlIIll = (NumberSetting)(new NumberSetting("blur_strength", 4, 0, 20)).lIlIlIlIlIIlIIlIIllIIIIIl(((var1) -> {
            this.IlIlIlllllIlIIlIlIlllIlIl = true;
        }));
        this.llIIIlllIIlllIllllIlIllIl = new MenuBlurMod.lIlIlIlIlIIlIIlIIllIIIIIl("lunar", 0);
        this.lllIIIIIlllIIlIllIIlIIIlI = new MenuBlurMod.lIlIlIlIlIIlIIlIIllIIIIIl("inventory", 1862270976);
        this.lIlIIIIIIlIIIllllIllIIlII = new MenuBlurMod.lIlIlIlIlIIlIIlIIllIIIIIl("pause", 1862270976);
        return ImmutableList.of(this.llIIlIlIIIllIlIlIlIIlIIll, this.llIIIlllIIlllIllllIlIllIl.IlllIIIIIIlllIlIIlllIlIIl, this.llIIIlllIIlllIllllIlIllIl.lIllIlIIIlIIIIIIIlllIlIll, this.lllIIIIIlllIIlIllIIlIIIlI.IlllIIIIIIlllIlIIlllIlIIl, this.lllIIIIIlllIIlIllIIlIIIlI.lIllIlIIIlIIIIIIIlllIlIll, this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl, this.lIlIIIIIIlIIIllllIllIIlII.lIllIlIIIlIIIIIIIlllIlIll);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Menu Blur", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("menu_blur", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.NEW));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1) {
        if (!var1) {
            this.lIlIlIIIIIIllIlIIIIllIIII();
        }

    }

    public void IlIllIIlIIlIIIllIllllIIll() {
        try {
            Ref.getMinecraft().bridge$getEntityRenderer().bridge$loadShader(llllIIlIIlIIlIIllIIlIIllI);
            if (Ref.getMinecraft().bridge$getEntityRenderer().bridge$isShaderActive()) {
                ShaderGroupBridge var1 = Ref.getMinecraft().bridge$getEntityRenderer().bridge$getShaderGroup();

                try {
                    List<ShaderBridge> var2 = var1.bridge$listShaders();
                    this.IlllllIlIIIlIIlIIllIIlIll.clear();
                    Iterator var3 = var2.iterator();

                    while(var3.hasNext()) {
                        ShaderBridge var4 = (ShaderBridge)var3.next();
                        ShaderUniformBridge var5 = var4.bridge$getShaderManager().bridge$getShaderUniform("Progress");
                        ShaderUniformBridge var6 = var4.bridge$getShaderManager().bridge$getShaderUniform("Radius");
                        if (var5 != null) {
                            this.IlllllIlIIIlIIlIIllIIlIll.add(var5);
                            var5.bridge$set(this.llIIIIIIIllIIllIlIllIIIIl);
                        }

                        if (var6 != null) {
                            var6.bridge$set((float)(Integer)this.llIIlIlIIIllIlIlIlIIlIIll.llIlllIIIllllIIlllIllIIIl());
                        }
                    }
                } catch (IllegalArgumentException var7) {
                }
            }

            this.IlIlIlllllIlIIlIlIlllIlIl = false;
        } catch (NullPointerException | IOException var8) {
        }

        this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl((long)((float)this.lIIIllIllIIllIlllIlIIlllI.getDuration() * this.llIIIIIIIllIIllIlIllIIIIl));
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        if (this.IlIlIlllllIlIIlIlIlllIlIl) {
            this.IlIllIIlIIlIIIllIllllIIll();
        }

        if (this.lIIIllIllIIllIlllIlIIlllI.lIIIllIllIIllIlllIlIIlllI() && !this.IlllllIlIIIlIIlIIllIIlIll.isEmpty()) {
            this.IlllllIlIIIlIIlIIllIIlIll.forEach((var1) -> {
                var1.bridge$set(this.lIIIllIllIIllIlllIlIIlllI.getProgress());
            });
        }

    }

    public void lIlIlIIIIIIllIlIIIIllIIII() {
        if (this.lIIIllIllIIllIlllIlIIlllI != null && this.lIIIllIllIIllIlllIlIIlllI.lIIIllIllIIllIlllIlIIlllI() && !this.IlllllIlIIIlIIlIIllIIlIll.isEmpty()) {
            this.lIIIllIllIIllIlllIlIIlllI.llIIIIIIIllIIllIlIllIIIIl();
            this.IlllllIlIIIlIIlIIllIIlIll.forEach((var0) -> {
                var0.bridge$set(0.0F);
            });
        }

        this.IlIlIlllllIlIIlIlIlllIlIl = true;
        if (Ref.getMinecraft().bridge$getEntityRenderer().bridge$isShaderActive()) {
            Ref.getMinecraft().bridge$getEntityRenderer().bridge$stopUseShader();
        }

    }

    public int IlllIIIIIIlllIlIIlllIlIIl(int var1) {
        int var2 = var1 >>> 24;
        int var3 = var1 >> 16 & 255;
        int var4 = var1 >> 8 & 255;
        int var5 = var1 & 255;
        float var6;
        if (this.lIIIllIllIIllIlllIlIIlllI.lIIIllIllIIllIlllIlIIlllI()) {
            var6 = Math.max(Math.min(this.lIIIllIllIIllIlllIlIIlllI.getTimePassedAsFloat(), 0.75F), 0.0F);
        } else {
            var6 = 0.75F;
        }

        var2 = (int)((float)var2 * var6);
        var3 = (int)((float)var3 * var6);
        var5 = (int)((float)var5 * var6);
        var4 = (int)((float)var4 * var6);
        return var2 << 24 | var3 << 16 | var4 << 8 | var5;
    }

    public Optional<Integer> lIlIlIlIlIIlIIlIIllIIIIIl(GuiScreenBridge var1) {
        if (this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(var1)) {
            return Optional.of(this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl());
        } else if (this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(var1)) {
            return Optional.of(this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl());
        } else {
            return this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(var1) ? Optional.of(this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl()) : Optional.empty();
        }
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(GuiScreenBridge var1) {
        return this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(var1) || this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(var1) || this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(var1);
    }

    public boolean lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public float IlIIlIIlIIlIIllIIIllIIllI() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public ExponentialEase IIlIlIIIllIIllllIllllIlIl() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public List lllllIIIIlIlllIllIIIlIIlI() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public NumberSetting IIlllIllIlIllIllIIllIlIIl() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public MenuBlurMod.lIlIlIlIlIIlIIlIIllIIIIIl lIlIIlIlllIIlIIIlIlIlIllI() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public MenuBlurMod.lIlIlIlIlIIlIIlIIllIIIIIl lIIlllIIIIIlllIIIlIlIlllI() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public MenuBlurMod.lIlIlIlIlIIlIIlIIllIIIIIl IIIlIIIIIIllIIIIllIIIIlII() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(boolean var1) {
        this.IlIlIlllllIlIIlIlIlllIlIl = var1;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float var1) {
        this.llIIIIIIIllIIllIlIllIIIIl = var1;
    }

    public class lIlIlIlIlIIlIIlIIllIIIIIl {
        public final BooleanSetting IlllIIIIIIlllIlIIlllIlIIl;
        public final ColorSetting lIllIlIIIlIIIIIIIlllIlIll;
        public final List llIlllIIIllllIIlllIllIIIl = new ArrayList();

        public lIlIlIlIlIIlIIlIIllIIIIIl(String var2, int var3) {
            this.IlllIIIIIIlllIlIIlllIlIIl = new BooleanSetting(MenuBlurMod.this.enabled, "blur_" + var2 + "_toggle", true);
            if ("lunar".equals(var2)) {
                this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((var1x) -> {
                    if (!var1x) {
                        MenuBlurMod.this.lIlIlIIIIIIllIlIIIIllIIII();
                    }

                }));
            }

            this.lIllIlIIIlIIIIIIIlllIlIll = new ColorSetting("blur_" + var2 + "_background", var3, () -> {
                return !this.IlllIIIIIIlllIlIIlllIlIIl.llIlllIIIllllIIlllIllIIIl();
            });
        }

        public int lIlIlIlIlIIlIIlIIllIIIIIl() {
            float var1 = this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI();
            if (var1 > 0.75F) {
                this.lIllIlIIIlIIIIIIIlllIlIll.IlllllIlIIIlIIlIIllIIlIll(0.75F);
            }

            return MenuBlurMod.this.IlllIIIIIIlllIlIIlllIlIIl(this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F));
        }

        public boolean lIlIlIlIlIIlIIlIIllIIIIIl(GuiScreenBridge var1) {
            if (!this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl()) {
                return false;
            } else {
                for(Class var2 = var1.getClass(); var2 != Object.class; var2 = var2.getSuperclass()) {
                    if (this.llIlllIIIllllIIlllIllIIIl.contains(var2)) {
                        return true;
                    }
                }

                return false;
            }
        }

        public BooleanSetting IlllIIIIIIlllIlIIlllIlIIl() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }

        public ColorSetting lIllIlIIIlIIIIIIIlllIlIll() {
            return this.lIllIlIIIlIIIIIIIlllIlIll;
        }

        public List llIlllIIIllllIIlllIllIIIl() {
            return this.llIlllIIIllllIIlllIllIIIl;
        }
    }
}