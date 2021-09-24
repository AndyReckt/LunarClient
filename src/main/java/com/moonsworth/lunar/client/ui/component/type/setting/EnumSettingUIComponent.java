package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.EnumSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;

/**
 * @author Decencies
 * @since 10/07/2021 18:26
 */
public class EnumSettingUIComponent extends AbstractDescritiveSettingUIComponent {
    public final IconButtonUIComponent left = new IconButtonUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/settings/arrow-left-18x18.png"), 4.5f);
    public final IconButtonUIComponent right = new IconButtonUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/settings/arrow-right-18x18.png"), 4.5f);

    public EnumSettingUIComponent(EnumSetting enumSetting, UIComponent uIComponent) {
        super(enumSetting, uIComponent);
        Class<?> clazz = ((Enum)enumSetting.llIlllIIIllllIIlllIllIIIl()).getClass();
        Enum[] enumArray = (Enum[])clazz.getEnumConstants();
        int length = enumArray.length;
        this.left.onMouseClick((float f, float f2, int n2) -> {
            int n3 = ((Enum)enumSetting.llIlllIIIllllIIlllIllIIIl()).ordinal();
            if (n3 - 1 < 0) {
                enumSetting.lIlIlIlIlIIlIIlIIllIIIIIl(enumArray[length - 1]);
            } else {
                enumSetting.lIlIlIlIlIIlIIlIIllIIIIIl(enumArray[n3 - 1]);
            }
            return true;
        });
        this.right.onMouseClick((float f, float f2, int n2) -> {
            int n3 = ((Enum)enumSetting.llIlllIIIllllIIlllIllIIIl()).ordinal();
            if (n3 + 1 >= length) {
                enumSetting.lIlIlIlIlIIlIIlIIllIIIIIl(enumArray[0]);
            } else {
                enumSetting.lIlIlIlIlIIlIIlIIllIIIIIl(enumArray[n3 + 1]);
            }
            return true;
        });
        this.onMouseClick((float f, float f2, int n) -> {
            if (this.left.mouseInside(f, f2)) {
                return this.left.onMouseClicked(f, f2, n);
            }
            if (this.right.mouseInside(f, f2)) {
                return this.right.onMouseClicked(f, f2, n);
            }
            return false;
        });
    }

    @Override
    public void resoze(float f, float f2, float f3) {
        super.setPositionAndSize(f, f2, f3, this.getHeight());
        this.left.setPosition(f + f3 - 115.0f, f2);
        this.right.setPosition(f + f3 - 30.0f, f2);
    }

    @Override
    public float getHeight() {
        return this.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : 14.0f;
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x, this.y + 1.5f, -4079426);
        this.left.drawComponent(mouseX, mouseY, bl);
        this.right.drawComponent(mouseX, mouseY, bl);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.setting.llIlllIIIllllIIlllIllIIIl().toString(), this.x + this.width - 64.0f, this.y + 2.5f, -1346256706);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        return this.mouseInside(f, f2) && f < this.left.getX() - 5.0f;
    }
}