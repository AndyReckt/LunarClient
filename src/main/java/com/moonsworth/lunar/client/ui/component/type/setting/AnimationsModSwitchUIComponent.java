package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.type.animations.AnimationVersion;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.AnimationsModSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ExponentialEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class AnimationsModSwitchUIComponent extends AbstractDescritiveSettingUIComponent {
    public final ExponentialEase ease = new ExponentialEase(100L);

    public AnimationsModSwitchUIComponent(AnimationsModSetting var1, UIComponent var2) {
        super(var1, var2);
        this.ease.lIllIlIIIlIIIIIIIlllIlIll();
        this.onMouseClick((var2x, var3, var4) -> {
            this.ease.lIllIlIIIlIIIIIIIlllIlIll();
            var1.toggle();
            return true;
        });
    }

    public void resoze(float var1, float var2, float var3) {
        super.setPositionAndSize(var1, var2, var3, this.getHeight());
    }

    public float getHeight() {
        return this.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0F : 14.0F;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return true;
    }

    public void onUpdateScreen() {
    }

    public void drawComponent(float mouseX, float mouseY, boolean var3) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x + 36.0F, this.y + 1.5F, -4079426);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + 2.0F, 30.0F, 10.0F, 5.0F, var3 && this.mouseInside(mouseX, mouseY) ? 1088611042 : 551740130, true, true, true, true);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 1.0F, this.y + 3.0F, 28.0F, 8.0F, 2.5F, 905969663, true, true, true, true);
        boolean var4 = ((AnimationsModSetting)this.setting).llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7;
        float var5 = 10.0F;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        float var6 = var4 ? this.ease.getProgress() : 1.0F - this.ease.getProgress();
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x + var5 * var6, this.y + 2.0F, 20.0F, 10.0F, 5.0F, ((AnimationsModSetting)this.setting).llIlllIIIllllIIlllIllIIIl() == AnimationVersion.VERSION_1_7 ? -1356212614 : -1344396974, true, true, true, true);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 1.0F + var5 * var6, this.y + 3.0F, 18.0F, 8.0F, 2.5F, 905969663, true, true, true, true);
        FontRegistry.lIlIIIIIIlIIIllllIllIIlII().IlllIIIIIIlllIlIIlllIlIIl(((AnimationsModSetting)this.setting).llIlllIIIllllIIlllIllIIIl().toString(), this.x + var5 * var6 + 10.0F, this.y + 3.0F, -1);
    }

    public void onKeyTyped(char var1, KeyType var2) {
    }

    public void onGuiClosed() {
    }
}
