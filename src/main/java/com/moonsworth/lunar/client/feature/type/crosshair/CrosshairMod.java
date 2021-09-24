package com.moonsworth.lunar.client.feature.type.crosshair;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.monster.EntityMobBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.passive.EntityAnimalBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.CustomScreen;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiChatBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventWithResult;
import com.moonsworth.lunar.client.event.type.hud.RenderCrosshairEvent;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.event.type.render.RenderScaledGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;
import com.moonsworth.lunar.client.ui.component.type.config.FeatureSettingsUIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;

import java.util.List;
import java.util.UUID;

public class CrosshairMod
    extends ConfigurableFeature {
    public BooleanSetting llllIIlIIlIIlIIllIIlIIllI;
    public BooleanSetting IlIlIlllllIlIIlIlIlllIlIl;
    public ColorSetting llIIIIIIIllIIllIlIllIIIIl;
    public ColorSetting lIIIllIllIIllIlllIlIIlllI;
    public ColorSetting IlllllIlIIIlIIlIIllIIlIll;
    public ColorSetting llIIlIlIIIllIlIlIlIIlIIll;
    public BooleanSetting llIIIlllIIlllIllllIlIllIl;
    public NumberSetting lllIIIIIlllIIlIllIIlIIIlI;
    public NumberSetting lIlIIIIIIlIIIllllIllIIlII;
    public NumberSetting llIlIIIllIIlIllIllIllllIl;
    public NumberSetting IllIllIIIllIIIlIlIlIIIIll;
    public EnumSetting IIlIllIlllllllIIlIIIllIIl;

    public CrosshairMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderScaledGameOverlayEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderCrosshairEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl((crosshairModDisplayType) -> {});
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderCrosshairEvent renderCrosshairEvent) {
        renderCrosshairEvent.lIlIlIlIlIIlIIlIIllIIIIIl(EventWithResult.EventStateResult.DENY);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent renderGameOverlayEvent) {
        GuiScreenBridge guiScreenBridge = this.mc.bridge$getCurrentScreen();
        if (guiScreenBridge != null && !(guiScreenBridge instanceof GuiChatBridge) && guiScreenBridge instanceof WrappedGuiScreenBridge) {
            CustomScreen customScreen = ((WrappedGuiScreenBridge)guiScreenBridge).getCustomScreen();
            if (!(customScreen instanceof SettingsUIScreen)) return;
            SettingsUIScreen settingsUIScreen = (SettingsUIScreen)customScreen;
            if (!(settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl().lIIlIlllIlIlIIIlllIIlIIII() instanceof FeatureSettingsUIComponent)) return;
            FeatureSettingsUIComponent featureSettingsUIComponent = (FeatureSettingsUIComponent)settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl().lIIlIlllIlIlIIIlllIIlIIII();
            if (!featureSettingsUIComponent.llllIIlIIlIIlIIllIIlIIllI().getDetails().getId().equals(this.getDetails().getId())) {
                return;
            }
        }
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll()) {
            return;
        }
        double d = renderGameOverlayEvent.lIlIlIlIlIIlIIlIIllIIIIIl();
        double d2 = renderGameOverlayEvent.IlllIIIIIIlllIlIIlllIlIIl();
        float f = (float)d / 2.0f;
        float f2 = (float)d2 / 2.0f;
        if (Ref.getMinecraft().bridge$getGameSettings().bridge$getThirdPersonView() != 0 && !Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllIIIlllIIIlIlllIlIIlIII().llIlllIIIllllIIlllIllIIIl().booleanValue()) {
            return;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        float f3;
        int n;
        float f4 = this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl().floatValue();
        float f5 = this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl().floatValue();
        float f6 = this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl().floatValue();
        float f7 = f + f2;
        if (this.llIIIlllIIlllIllllIlIllIl.llIlllIIIllllIIlllIllIIIl().booleanValue()) {
            EntityBridge entityBridge = Ref.getMinecraft().bridge$getPointedEntity().orElse(null);
            if (entityBridge instanceof EntityAnimalBridge) {
                n = this.IlllllIlIIIlIIlIIllIIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f7);
            } else if (entityBridge instanceof EntityMobBridge) {
                n = this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f7);
            } else if (entityBridge instanceof EntityPlayerBridge) {
                UUID uUID = entityBridge.bridge$getUniqueID();
                n = this.lc.getFriendRegistry().llIlllIIIllllIIlllIllIIIl().containsKey(uUID) ? this.IlllllIlIIIlIIlIIllIIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f7) : (!entityBridge.bridge$isInvisibleTo(Ref.getPlayer()) ? this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f7).intValue() : this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(f7).intValue());
            } else {
                n = this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(f7);
            }
        } else {
            n = this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(f7);
        }
        boolean bl = this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl();
        if (this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl().booleanValue()) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, (double) this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl().floatValue(), n == this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(f7) ? this.llIIIIIIIllIIllIlIllIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f7) : n);
            if (bl) {
                int n2 = -16777216;
                f3 = 0.5f;
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, (double)(this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl().floatValue() + f3), n2);
            }
        }
        switch ((CrosshairModDisplayType)this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl()) {
        case CROSS: {
            if (bl) {
                int n3 = -16777216;
                f3 = 0.5f;
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f - f5 - f4, f2 - f6 / 2.0f, f4, f6, f3, n3, n);
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f + f5, f2 - f6 / 2.0f, f4, f6, f3, n3, n);
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f - f6 / 2.0f, f2 - f5 - f4, f6, f4, f3, n3, n);
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f - f6 / 2.0f, f2 + f5, f6, f4, f3, n3, n);
                break;
            }
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRect(f - f5 - f4, f2 - f6 / 2.0f, f4, f6, n);
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRect(f + f5, f2 - f6 / 2.0f, f4, f6, n);
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRect(f - f6 / 2.0f, f2 - f5 - f4, f6, f4, n);
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRect(f - f6 / 2.0f, f2 + f5, f6, f4, n);
            break;
        }
        case CIRCLE: {
            f6 = f6 == 1.0f ? 1.25f : (f6 == 0.5f ? 1.15f : f6);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f5 *= 2.0f, f5 / f6, 1.0, 1, 0.0, n);
            if (!bl) break;
            int n4 = -16777216;
            f3 = 1.0f;
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f5 + f3, f5, 1.0, 1, 0.0, n4);
            break;
        }
        case ARROW: {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            if (bl) {
                int n5 = -16777216;
                f3 = 2.0f;
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(new float[] {f - f4 - 0.5f, f2 + f4 + 0.5f, f, f2, f, f2, f + f4 + 0.5f, f2 + f4 + 0.5f}, f6 * 2.0f + f3, n5);
            }
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(new float[] {f - f4, f2 + f4, f, f2, f, f2, f + f4, f2 + f4}, f6 * 2.0f, n);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        }
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        this.llllIIlIIlIIlIIllIIlIIllI = new BooleanSetting("dot", false);
        this.IlIlIlllllIlIIlIlIlllIlIl = new BooleanSetting("outline", false);
        this.IIlIllIlllllllIIlIIIllIIl = new EnumSetting("styleOption", CrosshairModDisplayType.CROSS);
        this.lllIIIIIlllIIlIllIIlIIIlI = new NumberSetting("thickness", Float.valueOf(1.0f), Float.valueOf(0.5f), Float.valueOf(2.5f), 2);
        this.lIlIIIIIIlIIIllllIllIIlII = new NumberSetting("size", Float.valueOf(4.0f), Float.valueOf(1.0f), Float.valueOf(10.0f), 2);
        this.IllIllIIIllIIIlIlIlIIIIll = new NumberSetting("gap", Float.valueOf(1.75f), Float.valueOf(1.0f), Float.valueOf(7.5f), 2);
        this.llIlIIIllIIlIllIllIllllIl = new NumberSetting("dotSize", Float.valueOf(1.0f), Float.valueOf(0.5f), Float.valueOf(2.5f), 2);
        this.llIIIlllIIlllIllllIlIllIl = new BooleanSetting("dynamic_colors", true);
        AbstractSetting[] abstractSettingArray = new AbstractSetting[4];
        this.lIIIllIllIIllIlllIlIIlllI = new ColorSetting("color", -1);
        abstractSettingArray[0] = this.lIIIllIllIIllIlllIlIIlllI;
        this.llIIIIIIIllIIllIlIllIIIIl = new ColorSetting("dotColor", -1, () -> this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl() == false);
        abstractSettingArray[1] = this.llIIIIIIIllIIllIlIllIIIIl;
        this.IlllllIlIIIlIIlIIllIIlIll = new ColorSetting("friendly", -13369549, () -> this.llIIIlllIIlllIllllIlIllIl.llIlllIIIllllIIlllIllIIIl() == false);
        abstractSettingArray[2] = this.IlllllIlIIIlIIlIIllIIlIll;
        this.llIIlIlIIIllIlIlIlIIlIIll = new ColorSetting("enemy", -52429, () -> this.llIIIlllIIlllIllllIlIllIl.llIlllIIIllllIIlllIllIIIl() == false);
        abstractSettingArray[3] = this.llIIlIlIIIllIlIlIlIIlIIll;
        return ImmutableList.of(new SettingLabel("crosshairPreview"), new CrosshairPreviewSetting(this), new SettingLabel("generalOptions"), this.llllIIlIIlIIlIIllIIlIIllI, this.IlIlIlllllIlIIlIlIlllIlIl, this.IIlIllIlllllllIIlIIIllIIl, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIlIIIIIIlIIIllllIllIIlII, this.IllIllIIIllIIIlIlIlIIIIll, this.llIlIIIllIIlIllIllIllllIl, new SettingLabel("colorOptions"), this.llIIIlllIIlllIllllIlIllIl, abstractSettingArray);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 / 2.0f - 16.0f, f2 + f4 / 2.0f - 1.5f, 10.0f, 3.0f, 0.5f, -16777216, -1);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 / 2.0f + 6.0f, f2 + f4 / 2.0f - 1.5f, 10.0f, 3.0f, 0.5f, -16777216, -1);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 / 2.0f - 1.5f, f2 + f4 / 2.0f - 16.0f, 3.0f, 10.0f, 0.5f, -16777216, -1);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 / 2.0f - 1.5f, f2 + f4 / 2.0f + 6.0f, 3.0f, 10.0f, 0.5f, -16777216, -1);
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("crosshair", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.NEW));
    }
}