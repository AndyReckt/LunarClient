package com.moonsworth.lunar.client.feature.type.animations;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.IBakedModelBridge;
import com.moonsworth.lunar.bridge.minecraft.item.*;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.bridge.optifine.CustomItemsBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.type.entity.SetRenderLivingBrightnessEvent;
import com.moonsworth.lunar.client.event.type.entity.player.TranslateEyeHeightEvent;
import com.moonsworth.lunar.client.event.type.entity.render.RenderHeldItemEvent;
import com.moonsworth.lunar.client.event.type.hud.EventRenderGlint;
import com.moonsworth.lunar.client.event.type.hud.RenderItemFirstPersonEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.profile.main.PerformanceConfig;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.AnimationsModSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.setting.SettingLabel;
import com.moonsworth.lunar.client.ui.ease.ExponentialEase;
import com.moonsworth.lunar.client.ui.ease.LinearEase;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AnimationsMod extends ConfigurableFeature {
    public AnimationsModSetting llllIIlIIlIIlIIllIIlIIllI;
    public ColorSetting IlIlIlllllIlIIlIlIlllIlIl;
    public AnimationsModSetting llIIIIIIIllIIllIlIllIIIIl;
    public AnimationsModSetting lIIIllIllIIllIlllIlIIlllI;
    public AnimationsModSetting IlllllIlIIIlIIlIIllIIlIll;
    public AnimationsModSetting llIIlIlIIIllIlIlIlIIlIIll;
    public AnimationsModSetting llIIIlllIIlllIllllIlIllIl;
    public AnimationsModSetting lllIIIIIlllIIlIllIIlIIIlI;
    public AnimationsModSetting lIlIIIIIIlIIIllllIllIIlII;
    public AnimationsModSetting llIlIIIllIIlIllIllIllllIl;
    public AnimationsModSetting IllIllIIIllIIIlIlIlIIIIll;
    public AnimationsModSetting IIlIllIlllllllIIlIIIllIIl;
    public AnimationsModSetting lIIlIlllIlIlIIIlllIIlIIII;
    public AnimationsModSetting llIllIlIllIlllIllIIIIllII;
    public AnimationsModSetting IllllllllllIlIIIlllIlllll;
    public static final Set lllllIllIlIIlIIlIIIlllIlI = ImmutableSet.of(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$carrotOnAStick(), Bridge.llIlIIIllIIlIllIllIllllIl().bridge$fishingRod(), Bridge.llIlIIIllIIlIllIllIllllIl().bridge$nameTag(), Bridge.llIlIIIllIIlIllIllIllllIl().bridge$lead(), Bridge.llIlIIIllIIlIllIllIllllIl().bridge$skull());
    public static final Set IllIIIlllIIIlIlllIlIIlIII = ImmutableSet.of(ItemSwordBridge.class, ItemSpadeBridge.class, ItemAxeBridge.class, ItemHoeBridge.class, ItemPickaxeBridge.class);
    public static final Set IIlIllIlIIllIIlIlIllllllI = ImmutableSet.of(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$stick(), Bridge.llIlIIIllIIlIllIllIllllIl().bridge$blazeRod());
    public LinearEase lIIIlllIIIIllllIlIIIlIIll = new ExponentialEase(50L);
    public boolean llIIIlIllIIIIlIIIlIlIllIl;
    public boolean llllIlIllllIlIlIIIllIlIlI = false;
    public static final ResourceLocationBridge IlIllIIlIIlIIIllIllllIIll = Bridge.getInstance().initResourceLocation("textures/misc/enchanted_item_glint.png");

    public AnimationsMod() {
        super(true);
        if (Bridge.getInstance().getMinecraftVersion().ordinal() > MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl.ordinal()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(TranslateEyeHeightEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
            this.lIlIlIlIlIIlIIlIIllIIIIIl(SetRenderLivingBrightnessEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
            this.lIlIlIlIlIIlIIlIIllIIIIIl(EventRenderGlint.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
            this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderHeldItemEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
            this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderItemFirstPersonEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderItemFirstPersonEvent var1) {
        if (this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7 && Bridge.getInstance().bridge$getBlockFromItem(var1.lIlIlIlIlIIlIIlIIllIIIIIl()) == Bridge.IllIllIIIllIIIlIlIlIIIIll().bridge$carpet()) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0F, -0.25F, 0.0F);
        }

        if (this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7 && var1.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof ItemSwordBridge) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0F, 0.0F, -0.02F);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(1.0F, 0.0F, 0.0F, -0.1F);
        }

        if (this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7 && var1.lIlIlIlIlIIlIIlIIllIIIIIl() == Bridge.llIlIIIllIIlIllIllIllllIl().bridge$potionItem()) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(-0.0225F, -0.02F, 0.0F);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(1.0F, 0.0F, 0.0F, 0.1F);
        }

        if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7 && (var1.lIlIlIlIlIIlIIlIIllIIIIIl() == Bridge.llIlIIIllIIlIllIllIllllIl().bridge$fishingRod() || var1.lIlIlIlIlIIlIIlIIllIIIIIl() == Bridge.llIlIIIllIIlIllIllIllllIl().bridge$carrotOnAStick())) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.08F, -0.0275F, -0.33F);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(0.949999988079071D, 1.0D, 1.0D);
        }

        if (this.llIllIlIllIlllIllIIIIllII.llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7 && var1.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof ItemBowBridge) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0F, 0.0F, 0.0F);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(0.9F, 0.0F, 0.001F, 0.0F);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderHeldItemEvent var1) {
        boolean var2 = var1.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof EntityPlayerBridge && ((EntityPlayerBridge) var1.lIlIlIlIlIIlIIlIIllIIIIIl()).bridge$isBlocking();
        ItemBridge var3 = var1.IlllIIIIIIlllIlIIlllIlIIl().bridge$getItem();
        if (!lllllIllIlIIlIIlIIIlllIlI.contains(var3)) {
            if (var2 && this.lIllllIllIIlIIlIIIlIIIlII().isLegacy()) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(-0.05F, 0.1F, -0.12F);
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(-45.0F, 0.0F, 1.0F, 0.0F);
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(-30.0F, 1.0F, 0.0F, 0.0F);
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(-60.0F, 0.0F, 0.0F, 1.0F);
            }

            if (this.lIlIIIIIIlIIIllllIllIIlII.isLegacy()) {
                boolean var4 = IIlIllIlIIllIIlIlIllllllI.contains(var3);
                if (!var4) {
                    Iterator var5 = IllIIIlllIIIlIlllIlIIlIII.iterator();

                    while (var5.hasNext()) {
                        Class var6 = (Class) var5.next();
                        if (var6.isAssignableFrom(var3.getClass())) {
                            var4 = true;
                            break;
                        }
                    }
                }

                if (var4) {
                    if (!var2) {
                        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(20.0F, -1.0F, 0.0F, 0.0F);
                        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(5.0F, 0.0F, 0.0F, 1.0F);
                        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(-0.01F, 0.03F, 0.1F);
                    } else {
                        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(15.0F, 0.0F, 1.0F, 0.0F);
                        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.1F, 0.08F, 0.0F);
                    }
                } else {
                    boolean var7 = var3 instanceof ItemBlockBridge;
                    if (!var7) {
                        if (var3 == Bridge.llIlIIIllIIlIllIllIllllIl().bridge$bow()) {
                            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.03F, -0.05F, -0.1F);
                            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(10.0F, -1.5F, -1.0F, 1.0F);
                        } else {
                            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(180.0F, 0.0F, 0.0F, 1.0F);
                            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0F, -(var1.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$isSneaking() ? 0.695F : 0.295F), -0.03F);
                            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(13.5F, 1.0F, 0.15F, 0.0F);
                            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(15.0F, 0.0F, 0.9F, 0.8F);
                            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.01F, 0.0F, 0.0F);
                        }
                    }
                }
            }

        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TranslateEyeHeightEvent var1) {
        if (this.llIIlIlIIIllIlIlIlIIlIIll.isLegacy() && var1.lIlIlIlIlIIlIIlIIllIIIIIl() == Ref.getPlayer()) {
            float var2 = var1.IlllIIIIIIlllIlIIlllIlIIl();
            if (var1.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$isSneaking()) {
                this.llllIlIllllIlIlIIIllIlIlI = true;
                var2 += 0.08F;
            }

            if (var1.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$isSneaking() && !this.llIIIlIllIIIIlIIIlIlIllIl) {
                this.llIIIlIllIIIIlIIIlIlIllIl = true;
                this.llllIlIllllIlIlIIIllIlIlI = true;
                this.lIIIlllIIIIllllIlIIIlIIll.lIllIlIIIlIIIIIIIlllIlIll();
            } else if (this.llIIIlIllIIIIlIIIlIlIllIl && !var1.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$isSneaking()) {
                this.llIIIlIllIIIIlIIIlIlIllIl = false;
                this.llllIlIllllIlIlIIIllIlIlI = true;
                this.lIIIlllIIIIllllIlIIIlIIll.lIllIlIIIlIIIIIIIlllIlIll();
            }

            float var3;
            if (this.llIIIlIllIIIIlIIIlIlIllIl) {
                var3 = 0.08F * this.lIIIlllIIIIllllIlIIIlIIll.getProgress();
            } else {
                var3 = 0.08F * (1.0F - this.lIIIlllIIIIllllIlIIIlIIll.getProgress());
            }

            if (!this.llllIlIllllIlIlIIIllIlIlI) {
                var3 = 0.0F;
            }

            var1.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var3);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(SetRenderLivingBrightnessEvent var1) {
        var1.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlIlIlllllIlIIlIlIlllIlIl.IlllIIIIIIlllIlIIlllIlIIl(0.0F));
        var1.IlllIIIIIIlllIlIIlllIlIIl(this.IlIlIlllllIlIIlIlIlllIlIl.lIllIlIIIlIIIIIIIlllIlIll(0.0F));
        var1.lIllIlIIIlIIIIIIIlllIlIll(this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl(0.0F));
        var1.llIlllIIIllllIIlllIllIIIl(this.IlIlIlllllIlIIlIlIlllIlIl.llllIIlIIlIIlIIllIIlIIllI(0.0F));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EventRenderGlint var1) {
        if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl() == PerformanceConfig.GlintOption.IlllIIIIIIlllIlIIlllIlIIl) {
            if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() != EventRenderGlint.Where.lIllIlIIIlIIIIIIIlllIlIll) {
                return;
            }
        } else if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl() == PerformanceConfig.GlintOption.lIllIlIIIlIIIIIIIlllIlIll) {
            return;
        }

        if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() == EventRenderGlint.Where.lIlIlIlIlIIlIIlIIllIIIIIl) {
            if (this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7) {
                EntityLivingBaseBridge var2 = (EntityLivingBaseBridge) var1.lIllIlIIIlIIIIIIIlllIlIll();
                if (var2.bridge$getHurtTime() > 0 || var2.bridge$getDeathTime() > 0) {
                    var1.setCancelled(true);
                }
            }
        } else if (this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7) {
            boolean var3 = Bridge.lIllIlIIIlIIIIIIIlllIlIll().map((var0) -> {
                return (!var0.getConfig().hasShaders() || !var0.getShaders().hasShadowPass()) && var0.getCustomItems().map(CustomItemsBridge::useGlint).orElse(true);
            }).orElse(true);
            if (!var3) {
                return;
            }

            if (var1.llIlllIIIllllIIlllIllIIIl() != null && var1.lIlIlIlIlIIlIIlIIllIIIIIl() == EventRenderGlint.Where.IlllIIIIIIlllIlIIlllIlIIl && var1.llIlllIIIllllIIlllIllIIIl().bridge$getStackSize() > 1) {
                return;
            }

            var1.setCancelled(true);
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var1.IlllIIIIIIlllIlIIlllIlIIl());
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(IBakedModelBridge var1) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$depthMask(false);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$depthFunc(514);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableLighting();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$blendFunc(768, 1);
        Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(IlIllIIlIIlIIIllIllllIIll);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$matrixMode(5890);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(8.0D, 8.0D, 8.0D);
        float var2 = (float) (Ref.getMinecraft().bridge$getSystemTime() % 4873L) / 4873.0F / 8.0F;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(var2, 0.0F, 0.0F);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(10.0F, 0.0F, 0.0F, 1.0F);
        this.mc.bridge$getRenderItem().bridge$renderModel(var1, -8372020);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$tryBlendFuncSeparate(770, 771, 1, 0);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$matrixMode(5888);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$blendFunc(770, 771);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableLighting();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$depthFunc(515);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$depthMask(true);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$tryBlendFuncSeparate(770, 771, 1, 0);
    }

    public List<AbstractSetting<?>> IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(
                   new SettingLabel("animations"),
                   this.IlllllIlIIIlIIlIIllIIlIll = new AnimationsModSetting(this.enabled, "glint_anim", AnimationVersion.VERSION_1_7),
                   this.llllIIlIIlIIlIIllIIlIIllI = new AnimationsModSetting(this.enabled, "armor_hit_anim", AnimationVersion.VERSION_1_7),
                   this.llIIIIIIIllIIllIlIllIIIIl = new AnimationsModSetting(this.enabled, "block_hit_anim", AnimationVersion.VERSION_1_7),
                   this.lIIIllIllIIllIlllIlIIlllI = new AnimationsModSetting(this.enabled, "health_anim", AnimationVersion.VERSION_1_7),
                   this.llIIlIlIIIllIlIlIlIIlIIll = new AnimationsModSetting(this.enabled, "sneak_anim", AnimationVersion.VERSION_1_7),
                   this.llIIIlllIIlllIllllIlIllIl = new AnimationsModSetting(this.enabled, "hurt_camera_shake", AnimationVersion.VERSION_1_7),
                   this.lllIIIIIlllIIlIllIIlIIIlI = new AnimationsModSetting(this.enabled, "potion_drinking", AnimationVersion.VERSION_1_7),
                   new SettingLabel("heldItems"),
                   this.lIlIIIIIIlIIIllllIllIIlII = new AnimationsModSetting(this.enabled, "tp_held_items", AnimationVersion.VERSION_1_7),
                   this.llIlIIIllIIlIllIllIllllIl = new AnimationsModSetting(this.enabled, "fp_carpet", AnimationVersion.VERSION_1_7),
                   this.IllIllIIIllIIIlIlIlIIIIll = new AnimationsModSetting(this.enabled, "fp_fishing_rod", AnimationVersion.VERSION_1_7),
                   new AbstractSetting<?>[] {
                       this.IIlIllIlllllllIIlIIIllIIl = new AnimationsModSetting(this.enabled, "fp_sword", AnimationVersion.VERSION_1_7),
                       this.lIIlIlllIlIlIIIlllIIlIIII = new AnimationsModSetting(this.enabled, "fp_potion", AnimationVersion.VERSION_1_7),
                       this.llIllIlIllIlllIllIIIIllII = new AnimationsModSetting(this.enabled, "fp_bow", AnimationVersion.VERSION_1_7),
                       new SettingLabel("mechanics"),
                       this.IllllllllllIlIIIlllIlllll = new AnimationsModSetting(this.enabled, "use_item_while_digging", AnimationVersion.VERSION_1_7),
                       new SettingLabel("colorOptions"),
                       this.IlIlIlllllIlIIlIlIlllIlIl = new ColorSetting("hit_armor_color", 0.6F, 0.0F, 0.0F, 0.4F)
                   }
               );
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("1.7 <-> 1.8", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return (new FeatureDetails("one_seven_visuals", ImmutableList.of(ModuleCategory.ALL), ImmutableList.of(MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl), new String[0])).lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of("Animations"));
    }

    public AnimationsModSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public AnimationsModSetting lIllllIllIIlIIlIIIlIIIlII() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public AnimationsModSetting lIlIlIIIIIIllIlIIIIllIIII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public AnimationsModSetting lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public AnimationsModSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public AnimationsModSetting IIlIlIIIllIIllllIllllIlIl() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public AnimationsModSetting lllllIIIIlIlllIllIIIlIIlI() {
        return this.IllllllllllIlIIIlllIlllll;
    }
}
