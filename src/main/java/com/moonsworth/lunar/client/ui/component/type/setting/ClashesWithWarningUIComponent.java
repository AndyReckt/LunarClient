package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.*;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.List;

public abstract class ClashesWithWarningUIComponent
extends AbstractDescritiveSettingUIComponent {
    public IlllIIIIIIlllIlIIlllIlIIl lIlIlIlIlIIlIIlIIllIIIIIl;

    public ClashesWithWarningUIComponent(AbstractSetting abstractSetting, UIComponent uIComponent) {
        super(abstractSetting, uIComponent);
    }

    public void llIlllIIIllllIIlllIllIIIl(float f, float f2) {
        List list = null;
        if (this.IlllIIIIIIlllIlIIlllIlIIl instanceof BindableSetting && this.IlllIIIIIIlllIlIIlllIlIIl.llIlllIIIllllIIlllIllIIIl().equals("NONE") || this.IlllIIIIIIlllIlIIlllIlIIl instanceof LunarKeybindSetting && ((KeyBind)this.IlllIIIIIIlllIlIIlllIlIIl.llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl().equals((Object)KeyType.lIlIlIlIlIIlIIlIIllIIIIIl) || this.IlllIIIIIIlllIlIIlllIlIIl instanceof HKTextSetting && ((KeyBind)((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).equals(KeyType.lIlIlIlIlIIlIIlIIllIIIIIl)) {
            return;
        }
        List list2 = this.IlllIIIIIIlllIlIIlllIlIIl instanceof AbstractFeatureSetting ? ((AbstractFeatureSetting)this.IlllIIIIIIlllIlIIlllIlIIl).llIIIIIIIllIIllIlIllIIIIl() : (list = this.IlllIIIIIIlllIlIIlllIlIIl instanceof HKTextSetting ? ((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIllIlIIIlIIIIIIIlllIlIll().llIIIIIIIllIIllIlIllIIIIl() : null);
        if (list != null && !list.isEmpty()) {
            String string = this.get("clashesWith", EnumChatColor.lllIIIIIlllIIlIllIIlIIIlI + list.toString());
            float f3 = FontRegistry.lIIIllIllIIllIlllIlIIlllI().IlllIIIIIIlllIlIIlllIlIIl(string);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f + 8.0f, f2 + 6.0f, f3 + 10.0f, 14.0f, 4.0f, -1879048192);
            FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(string, f + 12.5f, f2 + 9.0f, -1);
        }
    }

    public IlllIIIIIIlllIlIIlllIlIIl llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
 