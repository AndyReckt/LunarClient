package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.ConfigCategory;
import com.moonsworth.lunar.client.setting.SettingLabel;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.Debug;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.*;
import com.moonsworth.lunar.client.ui.component.type.setting.TextboxWithIcon;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.UIScreenCloseException;
import com.moonsworth.lunar.client.util.LanguageParser;
import org.lwjgl.opengl.GL11;

import java.util.*;

public class lIlIIIIIIlIIIllllIllIIlII extends AbstractListUIComponent<UIComponent> {
    public List<SettingsCategoryUIComponent> categoryUIComponents;
    public Map<ConfigCategory, List<AbstractDescritiveSettingUIComponent<?>>> configCategoryListMap;
    public ConfigCategory category = ConfigCategory.GENERAL;
    public TextboxWithIcon searchBox;
    public ScrollbarUIComponent scrollbar;
    public Set llIllIlIllIlllIllIIIIllII = new HashSet();
    public boolean IllllllllllIlIIIlllIlllll = true;

    public lIlIIIIIIlIIIllllIllIIlII(UIComponent parent) {
        super(parent);
        this.scrollbar = new ScrollbarUIComponent(this);
        this.onMouseClick((float f, float f2, int n) -> {
            for (UIComponent uIComponent : this.categoryUIComponents) {
                if (!uIComponent.mouseInside(f, f2)) continue;
                return uIComponent.onMouseClicked(f, f2, n);
            }
            for (UIComponent uIComponent : this.configCategoryListMap.get(this.category)) {
                if (!uIComponent.mouseInside(f, f2 - this.scrollbar.getYOffset())) continue;
                return uIComponent.onMouseClicked(f, f2 - this.scrollbar.getYOffset(), n);
            }
            if (n == 1 && this.searchBox.mouseInside(f, f2)) {
                this.searchBox.setText("");
            }
            return this.scrollbar.mouseInside(f, f2) && this.scrollbar.onMouseClicked(f, f2, n) || this.searchBox.mouseInside(f, f2) && this.searchBox.onMouseClicked(f, f2, n);
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> this.searchBox.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n));
        this.categoryUIComponents = new ArrayList();
        for (ConfigCategory configCategory : ConfigCategory.values()) {
            SettingsCategoryUIComponent i18nBridge = new SettingsCategoryUIComponent(configCategory, this);
            this.categoryUIComponents.add(i18nBridge);
            if (configCategory == ConfigCategory.GENERAL) {
                i18nBridge.setSelected(true);
            }
            i18nBridge.onMouseClick((arg_0, arg_1, arg_2) -> this.lIlIlIlIlIIlIIlIIllIIIIIl(i18nBridge, arg_0, arg_1, arg_2));
        }
        this.configCategoryListMap = new HashMap<>();
        for (Map.Entry<ConfigCategory, ItemSetLoader<? extends I18nBridge>> entry : this.lc.lllIIIIIlllIIlIllIIlIIIlI().llIlllIIIllllIIlllIllIIIl().entrySet()) {
            this.configCategoryListMap.putIfAbsent(entry.getKey(), new ArrayList<>());
            ItemSetLoader<I18nBridge> itemSetLoader = (ItemSetLoader)entry.getValue();
            for (I18nBridge i18nBridge : itemSetLoader.llIlllIIIllllIIlllIllIIIl()) {
                if (((AbstractSetting)i18nBridge).llIllIlIllIlllIllIIIIllII() != null && ((AbstractSetting)i18nBridge).llIllIlIllIlllIllIIIIllII().getAsBoolean() || Debug.DebugHelper.lIlIlIlIlIIlIIlIIllIIIIIl(i18nBridge, itemSetLoader) && !Ref.isConnectedToWebSocket()) continue;
                this.configCategoryListMap.get(entry.getKey()).add(((AbstractSetting)i18nBridge).getUIComponent(this));
            }
        }
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        float f5 = 100.0f;
        float f6 = 14.0f;
        this.searchBox.setPositionAndSize(x + width - f5 - 4.0f, y + 1.0f, f5, f6);
        float f7 = 0.0f;
        for (SettingsCategoryUIComponent settingsCategoryUIComponent : this.categoryUIComponents) {
            settingsCategoryUIComponent.setPosition(x + f7, y + 1.0f);
            f7 += settingsCategoryUIComponent.getWidth() + 4.0f;
        }
        this.scrollbar.setPositionAndSize(x + width - 6.0f, y + 20.0f, 4.0f, height - 20.0f);
        HashSet hashSet = new HashSet();
        width -= 30.0f;
        float f8 = y + 27.0f;
        float f9 = 0.0f;
        int n = 0;
        ArrayList<AbstractDescritiveSettingUIComponent> arrayList = new ArrayList<>();
        if (!this.searchBox.getText().isEmpty()) {
            String string = this.searchBox.getText();
            for (AbstractDescritiveSettingUIComponent abstractDescritiveSettingUIComponent : this.configCategoryListMap.get(this.category)) {
                if (abstractDescritiveSettingUIComponent instanceof llIlIIIllIIlIllIllIllllIl) continue;
                AbstractSetting<?> abstractSetting = abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl();
                if (abstractSetting.f_().toLowerCase().contains(this.searchBox.getText())) {
                    arrayList.add(abstractDescritiveSettingUIComponent);
                    continue;
                }
                for (String string2 : abstractSetting.f_().split(" ")) {
                    if (!LanguageParser.normalize(string2).toLowerCase().startsWith(string.toLowerCase())) continue;
                    arrayList.add(abstractDescritiveSettingUIComponent);
                }
            }
        }
        for (Object object : this.configCategoryListMap.get(this.category)) {
            float f10;
            if (!this.searchBox.getText().isEmpty() && !arrayList.contains(object)) {
                ((AbstractDescritiveSettingUIComponent)object).resoze(x - width, y, width);
                continue;
            }
            if (object instanceof ColorPickerUIComponent && ((ColorPickerUIComponent)object).llIlllIIIllllIIlllIllIIIl()) {
                hashSet.add(((ColorPickerUIComponent)object).llIIIIIIIllIIllIlIllIIIIl());
            }
            boolean bl = ((AbstractDescritiveSettingUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll();
            boolean bl2 = ((AbstractDescritiveSettingUIComponent)object).llIIIIIIIllIIllIlIllIIIIl() instanceof SettingLabel;
            float f11 = f10 = bl ? width / 2.0f : width;
            if (n == 2) {
                n = 0;
                f8 += f9;
                f9 = 0.0f;
            }
            if (!bl) {
                n = 0;
                f8 += f9;
                f9 = 0.0f;
            }
            if (((AbstractDescritiveSettingUIComponent)object).getHeight() > f9) {
                f9 = ((AbstractDescritiveSettingUIComponent)object).getHeight();
            }
            ((AbstractDescritiveSettingUIComponent)object).resoze(x + (bl2 ? 0.0f : 15.0f) + (float)n * (width / 2.0f), f8, f10);
            if (!bl) {
                f8 += f9;
                f9 = 0.0f;
                continue;
            }
            ++n;
        }
        if (!this.llIllIlIllIlllIllIIIIllII.equals(hashSet) && !this.IllllllllllIlIIIlllIlllll && this.llIllIlIllIlllIllIIIIllII.size() <= hashSet.size()) {
            this.scrollbar.setYOffset(this.scrollbar.getYOffset() - 65.0f);
        }
        this.llIllIlIllIlllIllIIIIllII = hashSet;
        this.IllllllllllIlIIIlllIlllll = false;
        this.scrollbar.setContentHeight(f8 - (y + 27.0f) + 6.0f);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        UIComponent[] uIComponentArray = new UIComponent[1];
        this.searchBox = new TextboxWithIcon(this, Bridge.getInstance().initResourceLocation("lunar", "icons/assets/magnifying-glass-12x12.png"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI, "searchPlaceholder", 0x20FFFFFF, 0x35FFFFFF);
        uIComponentArray[0] = this.searchBox;
        return Arrays.asList(uIComponentArray);
    }

    @Override
    public void drawComponent(final float mouseX, final float mouseY, final boolean b) {
        for (SettingsCategoryUIComponent categoryUIComponent : this.categoryUIComponents) {
            categoryUIComponent.drawComponent(mouseX, mouseY, b);
        }
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
        for (final UIComponent uiComponent : this.configCategoryListMap.get(this.category)) {
            final boolean b2 = uiComponent.getY() + uiComponent.getHeight() + this.scrollbar.getYOffset() < this.scrollbar.getY();
            final boolean b3 = uiComponent.getY() + this.scrollbar.getYOffset() > this.scrollbar.getY() + this.scrollbar.getHeight();
            if (uiComponent.getX() >= this.x && !b2 && !b3) {
                uiComponent.drawComponent(mouseX, mouseY - this.scrollbar.getYOffset(), b && !this.scrollbar.lIIIllIllIIllIlllIlIIlllI());
            }
        }
        this.scrollbar.llllIIlIIlIIlIIllIIlIIllI(mouseX, mouseY, b);
        GL11.glDisable(3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        for (final AbstractDescritiveSettingUIComponent<?> abstractDescritiveSettingUIComponent : this.configCategoryListMap.get(this.category)) {
            final boolean b4 = abstractDescritiveSettingUIComponent.getY() + abstractDescritiveSettingUIComponent.getHeight() + this.scrollbar.getYOffset() < this.scrollbar.getY();
            final boolean b5 = abstractDescritiveSettingUIComponent.getY() + this.scrollbar.getYOffset() > this.scrollbar.getY() + this.scrollbar.getHeight();
            if (!b4) {
                if (b5) {
                    continue;
                }
                if (abstractDescritiveSettingUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(mouseX, mouseY - this.scrollbar.getYOffset())) {
                    abstractDescritiveSettingUIComponent.lIllIlIIIlIIIIIIIlllIlIll(mouseX, mouseY);
                }
                if (!(abstractDescritiveSettingUIComponent instanceof ClashesWithWarningUIComponent) || !((ClashesWithWarningUIComponent)abstractDescritiveSettingUIComponent).llllIIlIIlIIlIIllIIlIIllI().mouseInside(mouseX, mouseY - this.scrollbar.getYOffset())) {
                    continue;
                }
                ((ClashesWithWarningUIComponent)abstractDescritiveSettingUIComponent).llIlllIIIllllIIlllIllIIIl(mouseX, mouseY);
            }
        }
        super.drawComponent(mouseX, mouseY, b);
    }

    @Override
    public void onUpdateScreen() {
        super.onUpdateScreen();
        for (UIComponent uIComponent : this.configCategoryListMap.get(this.category)) {
            uIComponent.onUpdateScreen();
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        for (UIComponent uIComponent : this.configCategoryListMap.get(this.category)) {
            uIComponent.onKeyTyped(c, keyType);
        }
        if (this.searchBox.isTyping()) {
            if (keyType == KeyType.KEY_ESCAPE) {
                this.searchBox.setText("");
                this.searchBox.setTyping(false);
                return;
            }
            this.searchBox.onKeyTyped(c, keyType);
        }
        this.setPositionAndSize(this.x, this.y, this.width, this.height);
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        this.scrollbar.handleMouseScrollDelta(n);
        super.handleMouseScrollDelta(n);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    @Override
    public boolean shouldCancel() {
        return super.shouldCancel() || (this.configCategoryListMap.get(this.category)).stream().anyMatch(setting -> setting instanceof UIScreenCloseException && ((UIScreenCloseException) setting).shouldCancel());
    }

    public TextboxWithIcon llllIIlIIlIIlIIllIIlIIllI() {
        return this.searchBox;
    }

    public ScrollbarUIComponent llIIIIIIIllIIllIlIllIIIIl() {
        return this.scrollbar;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(SettingsCategoryUIComponent settingsCategoryUIComponent, float f, float f2, int n) {
        for (SettingsCategoryUIComponent settingsCategoryUIComponent2 : this.categoryUIComponents) {
            settingsCategoryUIComponent2.setSelected(false);
        }
        settingsCategoryUIComponent.setSelected(true);
        this.category = settingsCategoryUIComponent.lIllIlIIIlIIIIIIIlllIlIll();
        this.setPositionAndSize(this.x, this.y, this.width, this.height);
        return true;
    }
}
