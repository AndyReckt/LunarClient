package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import org.apache.commons.lang3.text.WordUtils;

public class EnumChoiceUIComponent extends UIComponent {
    public final IconButtonUIComponent left;
    public final IconButtonUIComponent right;
    public Enum lIlIlIlIlIIlIIlIIllIIIIIl;
    public final String llIlIIIllIIlIllIllIllllIl;

    public <T extends Enum<T>> EnumChoiceUIComponent(Enum<T> var1, String var2, UIComponent var3) {
        super(var3);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
        this.llIlIIIllIIlIllIllIllllIl = var2;
        this.left = new IconButtonUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/settings/arrow-left-18x18.png"), 4.5F);
        this.right = new IconButtonUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/settings/arrow-right-18x18.png"), 4.5F);
        Class<?> clazz = var1.getClass();
        Enum<T>[] constants = (Enum<T>[])clazz.getEnumConstants();
        int var6 = constants.length;
        this.left.onMouseClick((var4x, var5x, var6x) -> {
            int var7 = var1.ordinal();
            if (var7 - 1 < 0) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl = constants[var6 - 1];
            } else {
                this.lIlIlIlIlIIlIIlIIllIIIIIl = constants[var7 - 1];
            }

            return true;
        });
        this.right.onMouseClick((var4x, var5x, var6x) -> {
            int var7 = var1.ordinal();
            if (var7 + 1 >= var6) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl = constants[0];
            } else {
                this.lIlIlIlIlIIlIIlIIllIIIIIl = constants[var7 + 1];
            }

            return true;
        });
        this.onMouseClick((var1x, var2x, var3x) -> {
            if (this.left.mouseInside(var1x, var2x)) {
                return this.left.onMouseClicked(var1x, var2x, var3x);
            } else {
                return this.right.mouseInside(var1x, var2x) && this.right.onMouseClicked(var1x, var2x, var3x);
            }
        });
    }

    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, this.getHeight());
        this.left.setPosition(x + width - 115.0F, y);
        this.right.setPosition(x + width - 30.0F, y);
    }

    public void onUpdateScreen() {
    }

    public void drawComponent(float mouseX, float mouseY, boolean var3) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl, this.x, this.y + 1.5F, -4079426);
        this.left.drawComponent(mouseX, mouseY, var3);
        this.right.drawComponent(mouseX, mouseY, var3);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(WordUtils.capitalize(this.lIlIlIlIlIIlIIlIIllIIIIIl.name().toLowerCase().replace("_", " ")), this.x + this.width - 64.0F, this.y + 2.5F, -1346256706);
    }

    public boolean onMouseClicked(float mouseX, float mouseY, int mouseButton) {
        if (this.left.mouseInside(mouseX, mouseY)) {
            return this.left.onMouseClicked(mouseX, mouseY, mouseButton);
        } else {
            return this.right.mouseInside(mouseX, mouseY) && this.right.onMouseClicked(mouseX, mouseY, mouseButton);
        }
    }

    public void onKeyTyped(char var1, KeyType var2) {
    }

    public void onGuiClosed() {
    }

    public Enum lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
