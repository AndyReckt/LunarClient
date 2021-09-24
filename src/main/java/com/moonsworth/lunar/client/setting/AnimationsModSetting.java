package com.moonsworth.lunar.client.setting;

import com.moonsworth.lunar.client.feature.type.animations.AnimationVersion;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AnimationsModSwitchUIComponent;

public class AnimationsModSetting extends EnumSetting<AnimationVersion> {
    public final BooleanSetting enabled;

    public AnimationsModSetting(BooleanSetting var1, String var2, AnimationVersion var3) {
        super(var2, var3);
        this.enabled = var1;
    }

    public boolean isLegacy() {
        return this.enabled.llIlllIIIllllIIlllIllIIIl() && this.llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7;
    }

    public void toggle() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7 ? AnimationVersion.VERSION_1_8 : AnimationVersion.VERSION_1_7);
    }

    public AbstractDescritiveSettingUIComponent getUIComponent(UIComponent var1) {
        return new AnimationsModSwitchUIComponent(this, var1);
    }
}