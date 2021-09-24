package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.BindableSetting;
import com.moonsworth.lunar.client.ui.screen.UIScreenCloseException;
import com.moonsworth.lunar.client.ui.component.UIComponent;

/**
 * @author Decencies
 * @since 10/07/2021 18:13
 */
public class BindableSettingUIComponent extends ClashesWithWarningUIComponent implements UIScreenCloseException {

    public boolean editing;

    public BindableSettingUIComponent(BindableSetting bindableSetting, UIComponent uIComponent) {
        super(bindableSetting, uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new DefaultButtonUIComponent(this, this.lIIIllIllIIllIlllIlIIlllI());
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (!this.editing && !bindableSetting.IlIlIlllllIlIIlIlIlllIlIl()) {
                return -2538942;
            }
            return -4275267;
        });
        this.onMouseClick((float f, float f2, int n) -> {
            if ((n == 4 || n == 5 || n == 3 || n == 2) && this.editing) {
                this.editing = false;
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                bindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.valueOf("KEY_MOUSE" + (n + 1)).name());
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bindableSetting.llIlllIIIllllIIlllIllIIIl());
                return true;
            }
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(f, f2)) {
                if (n == 1 && !this.editing) {
                    bindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_NONE.name());
                    this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIllIllIIllIlllIlIIlllI());
                } else {
                    boolean bl = this.editing = !this.editing;
                    if (this.editing) {
                        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl("?");
                    } else {
                        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIllIllIIllIlllIlIIlllI());
                    }
                }
                return true;
            }
            return false;
        });
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
        this.lIlIlIlIlIIlIIlIIllIIIIIl.onUpdateScreen();
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x, this.y + 1.5f, -4079426);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setPositionAndSize(this.x + this.width - 70.0f, this.y + 2.0f, 70.0f, 12.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        if (this.editing) {
            if (keyType == KeyType.KEY_ESCAPE) {
                this.setting.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_NONE.name());
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIllIllIIllIlllIlIIlllI());
                this.editing = false;
                return;
            }
            this.editing = false;
            this.setting.lIlIlIlIlIIlIIlIIllIIIIIl(keyType.name());
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIllIllIIllIlllIlIIlllI());
        }
    }

    @Override
    public void onGuiClosed() {
    }

    public String lIIIllIllIIllIlllIlIIlllI() {
        return KeyType.valueOf(((BindableSetting) this.setting).llIlllIIIllllIIlllIllIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        return super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2) && !this.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(f, f2);
    }

    @Override
    public boolean shouldCancel() {
        return this.editing;
    }

    @Override
    public boolean mouseInside(float mouseX, float mouseY) {
        return super.mouseInside(mouseX, mouseY) || this.shouldCancel();
    }
}