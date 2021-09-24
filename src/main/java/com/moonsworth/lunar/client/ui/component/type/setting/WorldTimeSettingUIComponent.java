package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.WorldTimeSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class WorldTimeSettingUIComponent extends AbstractDescritiveSettingUIComponent {
    public final ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl = Bridge.getInstance().initResourceLocation("lunar", "icons/sun-64.png");
    public final ResourceLocationBridge llIlIIIllIIlIllIllIllllIl = Bridge.getInstance().initResourceLocation("lunar", "icons/moon-64.png");
    public final IntSliderUIComponent IllIllIIIllIIIlIlIlIIIIll;

    public WorldTimeSettingUIComponent(WorldTimeSetting var1, UIComponent var2) {
        super(var1, var2);
        this.IllIllIIIllIIIlIlIlIIIIll = new IntSliderUIComponent(var1, this);
        this.setting = var1;
        this.onMouseClick((var1x, var2x, var3) -> {
            return this.IllIllIIIllIIIlIlIlIIIIll.mouseInside(var1x, var2x) && this.IllIllIIIllIIIlIlIlIIIIll.onMouseClicked(var1x, var2x, var3);
        });
    }

    public void resoze(float var1, float var2, float var3) {
        super.resoze(var1, var2, var3);
        this.IllIllIIIllIIIlIlIlIIIIll.setPositionAndSize(var1 + var3 / 3.0F, var2 + 16.0F, var3 - var3 / 3.0F, 14.0F);
    }

    public float getHeight() {
        return this.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0F : 30.0F;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    public void onUpdateScreen() {
    }

    public void drawComponent(float mouseX, float mouseY, boolean var3) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x, this.y + 1.5F, -4079426);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl, this.IllIllIIIllIIIlIlIlIIIIll.getX(), this.y + 3.0F, 7.5F, 7.5F);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.IllIllIIIllIIIlIlIlIIIIll.getX() + 3.5F, this.y + 13.0F, this.IllIllIIIllIIIlIlIlIIIIll.getX() + 4.5F, this.y + 16.0F, 1623310526);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl, this.IllIllIIIllIIIlIlIlIIIIll.getX() + this.IllIllIIIllIIIlIlIlIIIIll.getWidth() - 10.0F, this.y + 2.0F, 10.0F, 10.0F);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.IllIllIIIllIIIlIlIlIIIIll.getX() + this.IllIllIIIllIIIlIlIlIIIIll.getWidth() - 3.5F, this.y + 13.0F, this.IllIllIIIllIIIlIlIlIIIIll.getX() + this.IllIllIIIllIIIlIlIlIIIIll.getWidth() - 4.5F, this.y + 16.0F, 1623310526);
        this.IllIllIIIllIIIlIlIlIIIIll.IlllIIIIIIlllIlIIlllIlIIl(mouseX, mouseY, var3);
    }

    public void onKeyTyped(char var1, KeyType var2) {
    }

    public void onGuiClosed() {
    }
}
