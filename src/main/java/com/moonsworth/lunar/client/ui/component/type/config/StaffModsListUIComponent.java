package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.staff.AbstractStaffMod;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.ScrollbarUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.TextboxWithIcon;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.LanguageParser;
import org.lwjgl.opengl.GL11;

import java.util.*;

public class StaffModsListUIComponent extends AbstractListUIComponent<UIComponent> {
    public List<DefaultModuleUIComponent> modules;
    public ScrollbarUIComponent scrollbar = new ScrollbarUIComponent(this);
    public TextboxWithIcon searchBox;

    public StaffModsListUIComponent(UIComponent parent) {
        super(parent);
        this.onMouseClick((float f, float f2, int n) -> {
            for (DefaultModuleUIComponent module : this.modules) {
                if (!(f2 > this.y + 20.0f) || !module.mouseInside(f, f2 - this.scrollbar.getYOffset())) continue;
                return module.onMouseClicked(f, f2 - this.scrollbar.getYOffset(), n);
            }
            return this.scrollbar.mouseInside(f, f2) && this.scrollbar.onMouseClicked(f, f2, n) || this.searchBox.mouseInside(f, f2) && this.searchBox.onMouseClicked(f, f2, n);
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> this.searchBox.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n));
        this.modules = new ArrayList();
        for (AbstractStaffMod abstractStaffMod : this.lc.IIlIllIlllllllIIlIIIllIIl().llIlllIIIllllIIlllIllIIIl()) {
            if (!abstractStaffMod.lIllllIllIIlIIlIIIlIIIlII()) continue;
            this.modules.add(new DefaultModuleUIComponent(this, (ClientSettingsParentUIComponent)parent, abstractStaffMod));
        }
    }

    @Override
    public void IlIlIlllllIlIIlIlIlllIlIl() {
        this.setPositionAndSize(this.x, this.y, this.width, this.height);
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        int n = 0;
        int n2 = 0;
        float f5 = 112.0f;
        float f6 = 115.0f;
        HashMap<String, DefaultModuleUIComponent> hashMap = new HashMap<String, DefaultModuleUIComponent>();
        if (!this.searchBox.getText().isEmpty()) {
            for (DefaultModuleUIComponent defaultModuleUIComponent : this.modules) {
                String string = defaultModuleUIComponent.getFeature().getDetails().get("name");
                if (hashMap.containsKey(string)) continue;
                string = EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(string);
                String string2 = LanguageParser.normalize(this.searchBox.getText());
                for (String string3 : string.split(" ")) {
                    if (!LanguageParser.normalize(string3).toLowerCase().startsWith(string2.toLowerCase())) continue;
                    hashMap.put(defaultModuleUIComponent.getFeature().getDetails().get("name"), defaultModuleUIComponent);
                }
            }
        }
        for (DefaultModuleUIComponent defaultModuleUIComponent : this.modules) {
            if (!this.searchBox.getText().isEmpty() && !hashMap.containsKey(defaultModuleUIComponent.getFeature().getDetails().get("name"))) {
                defaultModuleUIComponent.setPositionAndSize(x - f6 - 10.0f, y, f6, f5);
                continue;
            }
            if (n == 3) {
                n = 0;
                ++n2;
            }
            defaultModuleUIComponent.setPositionAndSize(x + (f6 + 8.0f) * (float)n, y + 22.0f + (f5 + 8.0f) * (float)n2, f6, f5);
            ++n;
        }
        this.scrollbar.setPositionAndSize(x + width - 6.0f, y + 20.0f, 4.0f, height - 20.0f);
        this.scrollbar.setContentHeight(n2 == 0 ? f5 + 4.0f : 4.0f + f5 + (f5 + 8.0f) * (float)n2);
        float f7 = 100.0f;
        float f8 = 16.0f;
        this.searchBox.setPositionAndSize(x + width - f7 - 15.0f, y + 1.0f, f7, f8);
    }

    @Override
    public List<UIComponent> lIllIlIIIlIIIIIIIlllIlIll() {
        UIComponent[] uIComponentArray = new UIComponent[1];
        this.searchBox = new TextboxWithIcon(this, Bridge.getInstance().initResourceLocation("lunar", "icons/assets/magnifying-glass-12x12.png"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI, "searchPlaceholder", 0x20FFFFFF, 0x35FFFFFF);
        uIComponentArray[0] = this.searchBox;
        return Arrays.asList(uIComponentArray);
    }

    @Override
    public void drawComponent(final float mouseX, final float mouseY, final boolean b) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable(3089);
        float lllllIllIlIIlIIlIIIlllIlI = 0.0f;
        if (this.mc.bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge) {
            final WrappedGuiScreenBridge wrappedGuiScreenBridge = (WrappedGuiScreenBridge)this.mc.bridge$getCurrentScreen();
            if (wrappedGuiScreenBridge.getCustomScreen() instanceof AbstractUIScreen) {
                lllllIllIlIIlIIlIIIlllIlI = ((AbstractUIScreen)wrappedGuiScreenBridge.getCustomScreen()).lllllIllIlIIlIIlIIIlllIlI();
            }
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x - 2.0f), (int)(this.y + 20.0f), (int)(this.x + this.width + 2.0f), (int)(this.y + this.height + 5.0f), (float)(int)(AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII()), (int)lllllIllIlIIlIIlIIIlllIlI);
        this.scrollbar.onDraw(mouseX, mouseY, b);
        for (final DefaultModuleUIComponent defaultModuleUIComponent : this.modules) {
            final boolean b2 = defaultModuleUIComponent.getY() + defaultModuleUIComponent.getHeight() + this.scrollbar.getYOffset() < this.scrollbar.getY();
            final boolean b3 = defaultModuleUIComponent.getY() + this.scrollbar.getYOffset() > this.scrollbar.getY() + this.scrollbar.getHeight();
            if (defaultModuleUIComponent.getX() >= this.x && !b2 && !b3) {
                defaultModuleUIComponent.drawComponent(mouseX, mouseY - this.scrollbar.getYOffset(), b && !this.scrollbar.lIIIllIllIIllIlllIlIIlllI());
            }
        }
        this.scrollbar.llllIIlIIlIIlIIllIIlIIllI(mouseX, mouseY, b);
        GL11.glDisable(3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        super.drawComponent(mouseX, mouseY, b);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        if (keyType == KeyType.KEY_ESCAPE && this.searchBox.isTyping()) {
            this.searchBox.setTyping(false);
            this.searchBox.setText("");
            return;
        }
        super.onKeyTyped(c, keyType);
        if (!this.searchBox.isTyping()) {
            this.searchBox.setTyping(true);
            this.searchBox.onKeyTyped(c, keyType);
        }
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        this.scrollbar.handleMouseScrollDelta(n);
        super.handleMouseScrollDelta(n);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    public ScrollbarUIComponent llllIIlIIlIIlIIllIIlIIllI() {
        return this.scrollbar;
    }

    public TextboxWithIcon llIIIIIIIllIIllIlIllIIIIl() {
        return this.searchBox;
    }
}
