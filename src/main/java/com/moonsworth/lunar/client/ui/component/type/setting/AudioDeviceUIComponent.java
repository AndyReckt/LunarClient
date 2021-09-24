package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.AudioDeviceSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;

import java.util.List;

public class AudioDeviceUIComponent extends AbstractDescritiveSettingUIComponent<AudioDeviceSetting> {
    public final IconButtonUIComponent lIlIlIlIlIIlIIlIIllIIIIIl = new IconButtonUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/settings/arrow-left-18x18.png"), 4.5F);
    public final IconButtonUIComponent llIlIIIllIIlIllIllIllllIl = new IconButtonUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/settings/arrow-right-18x18.png"), 4.5F);

    public AudioDeviceUIComponent(AudioDeviceSetting var1, UIComponent var2) {
        super(var1, var2);
        List var3 = var1.IlllIIIIIIlllIlIIlllIlIIl();
        int var4 = var3.size() - 1;
        this.lIlIlIlIlIIlIIlIIllIIIIIl.onMouseClick((var2x, var3x, var4x) -> {
            int var5 = var1.IlllIIIIIIlllIlIIlllIlIIl().indexOf(var1.llIlllIIIllllIIlllIllIIIl());
            if (var5 - 1 < 0) {
                var1.lIlIlIlIlIIlIIlIIllIIIIIl(var1.IlllIIIIIIlllIlIIlllIlIIl().get(var4));
            } else {
                var1.lIlIlIlIlIIlIIlIIllIIIIIl(var1.IlllIIIIIIlllIlIIlllIlIIl().get(var5 - 1));
            }

            return true;
        });
        this.llIlIIIllIIlIllIllIllllIl.onMouseClick((var2x, var3x, var4x) -> {
            int var5 = var1.IlllIIIIIIlllIlIIlllIlIIl().indexOf(var1.llIlllIIIllllIIlllIllIIIl());
            if (var5 + 1 > var4) {
                var1.lIlIlIlIlIIlIIlIIllIIIIIl(var1.IlllIIIIIIlllIlIIlllIlIIl().get(0));
            } else {
                var1.lIlIlIlIlIIlIIlIIllIIIIIl(var1.IlllIIIIIIlllIlIIlllIlIIl().get(var5 + 1));
            }

            return true;
        });
        this.onMouseClick((var1x, var2x, var3x) -> {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(var1x, var2x)) {
                return this.lIlIlIlIlIIlIIlIIllIIIIIl.onMouseClicked(var1x, var2x, var3x);
            } else {
                return this.llIlIIIllIIlIllIllIllllIl.mouseInside(var1x, var2x) && this.llIlIIIllIIlIllIllIllllIl.onMouseClicked(var1x, var2x, var3x);
            }
        });
    }

    public void resoze(float var1, float var2, float var3) {
        super.setPositionAndSize(var1, var2, var3, this.getHeight());
    }

    public float getHeight() {
        return this.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0F : 14.0F;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    public void onUpdateScreen() {
    }

    public void drawComponent(float mouseX, float mouseY, boolean var3) {
        String label = "No Device Selected";
        if (((AudioDeviceSetting)this.setting).llIlllIIIllllIIlllIllIIIl() != null) {
            label = ((AudioDeviceSetting)this.setting).llIlllIIIllllIIlllIllIIIl().toString();
        }

        if (label.length() > 30) {
            label = label.substring(0, 30) + "...";
        }

        float var5 = FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(label, this.x + this.width - (float)FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(label) - 10.0F, this.y + 1.5F, -1346256706);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setPosition(var5 - (float)FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(label) - 12.0F, this.y);
        this.llIlIIIllIIlIllIllIllllIl.setPosition(var5, this.y);
        FontRegistry.IlIlIlllllIlIIlIlIlllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x, this.y + 1.5F, -4079426);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.drawComponent(((AudioDeviceSetting)this.setting).llIlllIIIllllIIlllIllIIIl() == null || ((AudioDeviceSetting)this.setting).IlllIIIIIIlllIlIIlllIlIIl().indexOf(((AudioDeviceSetting)this.setting).llIlllIIIllllIIlllIllIIIl()) == 0);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.drawComponent(mouseX, mouseY, var3);
        this.llIlIIIllIIlIllIllIllllIl.drawComponent(((AudioDeviceSetting)this.setting).llIlllIIIllllIIlllIllIIIl() == null || ((AudioDeviceSetting)this.setting).IlllIIIIIIlllIlIIlllIlIIl().indexOf(((AudioDeviceSetting)this.setting).llIlllIIIllllIIlllIllIIIl()) == ((AudioDeviceSetting)this.setting).IlllIIIIIIlllIlIIlllIlIIl().size() - 1);
        this.llIlIIIllIIlIllIllIllllIl.drawComponent(mouseX, mouseY, var3);
    }

    public void onKeyTyped(char var1, KeyType var2) {
    }

    public void onGuiClosed() {
    }
}
