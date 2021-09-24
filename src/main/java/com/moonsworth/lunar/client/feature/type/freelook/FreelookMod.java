package com.moonsworth.lunar.client.feature.type.freelook;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.state.EventState;
import com.moonsworth.lunar.client.event.type.entity.EntityRendererSetAnglesEvent;
import com.moonsworth.lunar.client.event.type.gui.GuiResizeEvent;
import com.moonsworth.lunar.client.event.type.input.TogglePerspectiveEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.BindableSetting;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.EnumSetting;

import java.util.List;

public class FreelookMod
    extends ConfigurableFeature {
    public BindableSetting llllIIlIIlIIlIIllIIlIIllI;
    public EnumSetting IlIlIlllllIlIIlIlIlllIlIl;
    public BooleanSetting llIIIIIIIllIIllIlIllIIIIl;
    public BooleanSetting lIIIllIllIIllIlllIlIIlllI;
    public BooleanSetting IlllllIlIIIlIIlIIllIIlIll;
    public float llIIlIlIIIllIlIlIlIIlIIll;
    public float llIIIlllIIlllIllllIlIllIl;
    public boolean lllIIIIIlllIIlIllIIlIIIlI;
    public int lIlIIIIIIlIIIllllIllIIlII;

    public FreelookMod() {
        super(true);
        this.llllIIlIIlIIlIIllIIlIIllI.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (!this.lllIIIIIlllIIlIllIIlIIIlI) {
                this.IIlIlIIIllIIllllIllllIlIl();
            } else {
                this.llllIIlIIlIIlIIllIIlIIllI.lIlIlIlIlIIlIIlIIllIIIIIl(0L);
            }
        }).lIlIlIlIlIIlIIlIIllIIIIIl(bl -> {
            if (this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl().booleanValue() && bl) {
                return;
            }
            this.lllllIIIIlIlllIllIIIlIIlI();
        }).IlllIIIIIIlllIlIIlllIlIIl(true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiResizeEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TogglePerspectiveEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(EntityRendererSetAnglesEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiResizeEvent guiResizeEvent) {
        if (guiResizeEvent.lIlIlIlIlIIlIIlIIllIIIIIl() != EventState.POST) {
            return;
        }
        if (this.lllIIIIIlllIIlIllIIlIIIlI) {
            this.lllllIIIIlIlllIllIIIlIIlI();
        }
    }

    public void IIlIlIIIllIIllllIllllIlIl() {
        this.lllIIIIIlllIIlIllIIlIIIlI = true;
        this.llIIlIlIIIllIlIlIlIIlIIll = (float) Ref.getPlayer().bridge$getRotationYaw();
        this.llIIIlllIIlllIllllIlIllIl = (float)Ref.getPlayer().bridge$getRotationPitch();
        this.lIlIIIIIIlIIIllllIllIIlII = this.mc.bridge$getGameSettings().bridge$getThirdPersonView();
        if (Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(this.mc.bridge$getPlayer()) && Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl) {
            this.lIlIIIIIIlIIIllllIllIIlII = 0;
        }
        this.mc.bridge$getGameSettings().bridge$setThirdPersonView(((FreelookPerspective)this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl()).lIllIlIIIlIIIIIIIlllIlIll());
    }

    public void lllllIIIIlIlllIllIIIlIIlI() {
        this.mc.bridge$getGameSettings().bridge$setThirdPersonView(this.lIlIIIIIIlIIIllllIllIIlII);
        this.lllIIIIIlllIIlIllIIlIIIlI = false;
        Ref.getMinecraft().bridge$getRenderGlobal().bridge$setDisplayListEntitiesDirty(true);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityRendererSetAnglesEvent entityRendererSetAnglesEvent) {
        if (this.lllIIIIIlllIIlIllIIlIIIlI) {
            this.llIIlIlIIIllIlIlIlIIlIIll += entityRendererSetAnglesEvent.lIlIlIlIlIIlIIlIIllIIIIIl() * (float)(this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl() != false ? -1 : 1) / 8.0f;
            this.llIIIlllIIlllIllllIlIllIl = Bridge.getMinecraftVersion().lIlIlIlIlIIlIIlIIllIIIIIl() ? (this.llIIIlllIIlllIllllIlIllIl += entityRendererSetAnglesEvent.IlllIIIIIIlllIlIIlllIlIIl() * (float)(this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() != false ? -1 : 1) / 8.0f) : (this.llIIIlllIIlllIllllIlIllIl += entityRendererSetAnglesEvent.IlllIIIIIIlllIlIIlllIlIIl() * (float)(this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() != false ? 1 : -1) / 8.0f);
            if (Math.abs(this.llIIIlllIIlllIllllIlIllIl) > 90.0f) {
                this.llIIIlllIIlllIllllIlIllIl = this.llIIIlllIIlllIllllIlIllIl > 0.0f ? 90.0f : -90.0f;
            }
            Ref.getMinecraft().bridge$getRenderGlobal().bridge$setDisplayListEntitiesDirty(true);
            this.llIIlIlIIIllIlIlIlIIlIIll = this.lIllIlIIIlIIIIIIIlllIlIll(this.llIIlIlIIIllIlIlIlIIlIIll);
            entityRendererSetAnglesEvent.cancel();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TogglePerspectiveEvent togglePerspectiveEvent) {
        if (this.lllIIIIIlllIIlIllIIlIIIlI) {
            togglePerspectiveEvent.setCancelled(true);
        }
    }

    public float lIllIlIIIlIIIIIIIlllIlIll(float f) {
        float f2;
        block3: {
            block2: {
                f2 = f;
                if (!(f2 < 0.0f)) break block2;
                while (f2 < 0.0f) {
                    f2 += 360.0f;
                }
                break block3;
            }
            if (!(f2 > 360.0f)) break block3;
            while (f2 > 360.0f) {
                f2 -= 360.0f;
            }
        }
        return f2;
    }

    @Override
    public List<AbstractSetting<?>> IlIlIlllllIlIIlIlIlllIlIl() {
        AbstractSetting[] abstractSettingArray = new AbstractSetting[5];
        this.IlIlIlllllIlIIlIlIlllIlIl = new EnumSetting("mode", FreelookPerspective.THIRD);
        abstractSettingArray[0] = this.IlIlIlllllIlIIlIlIlllIlIl;
        this.lIIIllIllIIllIlllIlIIlllI = new BooleanSetting("invertPitch", false);
        abstractSettingArray[1] = this.lIIIllIllIIllIlllIlIIlllI;
        this.llIIIIIIIllIIllIlIllIIIIl = new BooleanSetting("invertYaw", false);
        abstractSettingArray[2] = this.llIIIIIIIllIIllIlIllIIIIl;
        this.IlllllIlIIIlIIlIIllIIlIll = new BooleanSetting("toggleKeyFreelook", false);
        abstractSettingArray[3] = this.IlllllIlIIIlIIlIIllIIlIll;
        this.llllIIlIIlIIlIIllIIlIIllI = new BindableSetting(this, "freelook", KeyType.KEY_LMENU);
        abstractSettingArray[4] = this.llllIIlIIlIIlIIllIIlIIllI;
        return Lists.newArrayList(abstractSettingArray);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Freelook", f, f2, f3, f4);
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("freelook", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.MECHANIC), new String[0]).lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of("Perspective", "360"));
    }

    public BindableSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public EnumSetting lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public float lIlIlIIIIIIllIlIIIIllIIII() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public float lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public boolean IlIIlIIlIIlIIllIIIllIIllI() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }
}
