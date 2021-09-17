package com.moonsworth.lunar.client.notification;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.registry.PlayerHeadManager;
import com.moonsworth.lunar.client.setting.KeyBind;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.websocket.Status;

public class OverlayNotification
extends Notification {
    public final String lIIIllIllIIllIlllIlIIlllI;

    public OverlayNotification(String string, String string2) {
        super(string2);
        this.lIIIllIllIIllIlllIlIIlllI = string;
        this.lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    public OverlayNotification(String string, String string2, String string3) {
        super(string2, string3);
        this.lIIIllIllIIllIlllIlIIlllI = string;
        this.lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        if (Ref.IlllIIIIIIlllIlIIlllIlIIl().llllIIlIIlIIlIIllIIlIIllI().llIllIlIllIlllIllIIIIllII() == Status.lIllIlIIIlIIIIIIIlllIlIll) {
            return;
        }
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2);
        this.IlllIIIIIIlllIlIIlllIlIIl(f, f2);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2) {
        LunarKeybindSetting lunarKeybindSetting = LunarClient.IIllIlIllIlIllIllIllIllII().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().lllIIIIIlllIIlIllIIlIIIlI();
        boolean bl = lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() || lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() || lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll();
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f + 5.0f, f2 + this.llIIIIIIIllIIllIlIllIIIIl() - 12.0f, this.IlIlIlllllIlIIlIlIlllIlIl() - 12.0f, 0.5f, 0x40FFFFFF);
        float f3 = FontRegistry.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl("Press ", f + 5.0f, f2 + this.llIIIIIIIllIIllIlIllIIIIl() - 10.0f, 0x75FFFFFF);
        if (bl) {
            String string = lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT" : (lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT" : "CTRL");
            float f4 = FontRegistry.IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl(string);
            AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(f3 + 2.0f, f2 + this.llIIIIIIIllIIllIlIllIIIIl() - 10.0f, f4 + 2.0f, 7.0f, 4.0f, -1241513985);
            f3 = FontRegistry.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl("  " + string + " ", f3, f2 + this.llIIIIIIIllIIllIlIllIIIIl() - 10.0f, -1358954496);
            f3 = FontRegistry.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(" + ", f3, f2 + this.llIIIIIIIllIIllIlIllIIIIl() - 10.0f, -1241513985);
        }
        float f5 = FontRegistry.IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl(lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(f3 + 1.0f, f2 + this.llIIIIIIIllIIllIlIllIIIIl() - 10.0f, f5 + 2.0f, 7.0f, 4.0f, -1241513985);
        f3 = FontRegistry.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(" " + lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() + " ", f3, f2 + this.llIIIIIIIllIIllIlIllIIIIl() - 10.0f, -1358954496);
        FontRegistry.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl("  to open friends overlay ", f3, f2 + this.llIIIIIIIllIIllIlIllIIIIl() - 10.0f, 0x75FFFFFF);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        super.lIlIlIlIlIIlIIlIIllIIIIIl();
        this.llIIIIIIIllIIllIlIllIIIIl = Math.max(20.0f, this.llIIIIIIIllIIllIlIllIIIIl + 12.0f);
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return true;
    }

    @Override
    public ResourceLocationBridge lIllIlIIIlIIIIIIIlllIlIll() {
        return PlayerHeadManager.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIllIllIIllIlllIlIIlllI);
    }
}
 