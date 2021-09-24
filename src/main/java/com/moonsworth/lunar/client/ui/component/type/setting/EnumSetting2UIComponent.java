package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.EnumSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;

public class EnumSetting2UIComponent extends AbstractDescritiveSettingUIComponent {
    public final IconButtonUIComponent lIlIlIlIlIIlIIlIIllIIIIIl = new IconButtonUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/settings/arrow-left-18x18.png"), 4.5f);
    public final IconButtonUIComponent llIlIIIllIIlIllIllIllllIl = new IconButtonUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/settings/arrow-right-18x18.png"), 4.5f);

    public EnumSetting2UIComponent(EnumSetting enumSetting, UIComponent uIComponent) {
        super(enumSetting, uIComponent);
        Class<?> clazz = ((Enum)enumSetting.llIlllIIIllllIIlllIllIIIl()).getClass();
        Enum[] enumArray = (Enum[])clazz.getEnumConstants();
        int length = enumArray.length;
        this.lIlIlIlIlIIlIIlIIllIIIIIl.onMouseClick((float f, float f2, int n2) -> {
            int ordinal = ((Enum)enumSetting.llIlllIIIllllIIlllIllIIIl()).ordinal();
            if (ordinal - 1 < 0) {
                enumSetting.lIlIlIlIlIIlIIlIIllIIIIIl(enumArray[length - 1]);
            } else {
                enumSetting.lIlIlIlIlIIlIIlIIllIIIIIl(enumArray[ordinal - 1]);
            }
            return true;
        });
        this.llIlIIIllIIlIllIllIllllIl.onMouseClick((float f, float f2, int n2) -> {
            int ordinal = ((Enum)enumSetting.llIlllIIIllllIIlllIllIIIl()).ordinal();
            if (ordinal + 1 >= length) {
                enumSetting.lIlIlIlIlIIlIIlIIllIIIIIl(enumArray[0]);
            } else {
                enumSetting.lIlIlIlIlIIlIIlIIllIIIIIl(enumArray[ordinal + 1]);
            }
            return true;
        });
        this.onMouseClick((float f, float f2, int n) -> {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(f, f2)) {
                return this.lIlIlIlIlIIlIIlIIllIIIIIl.onMouseClicked(f, f2, n);
            }
            if (this.llIlIIIllIIlIllIllIllllIl.mouseInside(f, f2)) {
                return this.llIlIIIllIIlIllIllIllllIl.onMouseClicked(f, f2, n);
            }
            return false;
        });
    }

    @Override
    public void resoze(float f, float f2, float f3) {
        super.setPositionAndSize(f, f2, f3, this.getHeight());
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setPosition(f + f3 - 60.0f, f2);
        this.llIlIIIllIIlIllIllIllllIl.setPosition(f + f3 - 22.0f, f2);
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
        FontRegistry.IlIlIlllllIlIIlIlIlllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x, this.y + 1.5f, -4079426);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.drawComponent(mouseX, mouseY, bl);
        this.llIlIIIllIIlIllIllIllllIl.drawComponent(mouseX, mouseY, bl);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.setting.llIlllIIIllllIIlllIllIIIl().toString(), this.x + this.width - 34.0f, this.y + 2.5f, -1346256706);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}