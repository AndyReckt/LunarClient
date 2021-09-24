package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.HKTextSetting;
import com.moonsworth.lunar.client.setting.SettingLabel;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.Debug;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.*;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import org.lwjgl.opengl.GL11;

import java.util.*;

public class FeatureSettingsUIComponent extends AbstractListUIComponent<AbstractDescritiveSettingUIComponent<?>> {
    public final Feature lIlIlIlIlIIlIIlIIllIIIIIl;
    public final String featureName;
    public final ResourceLocationBridge backIcon;
    public lIlIlIIIIIIllIlIIIIllIIII resetToDefaults;
    public lIlIlIIIIIIllIlIIIIllIIII resetPosition;
    public ScrollbarUIComponent scrollbar;
    public AbstractDescritiveSettingUIComponent<?> IllllllllllIlIIIlllIlllll = null;
    public boolean configurable;
    public boolean IllIIIlllIIIlIlllIlIIlIII = true;
    public Set<AbstractSetting<?>> IIlIllIlIIllIIlIlIllllllI = new HashSet<>();
    public Set lIIIlllIIIIllllIlIIIlIIll = new HashSet();

    public FeatureSettingsUIComponent(ClientSettingsParentUIComponent clientSettingsParentUIComponent, Feature feature) {
        super(clientSettingsParentUIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = feature;
        this.featureName = feature.getDetails().get("name").toUpperCase().replace("", " ").trim();
        this.backIcon = Bridge.getInstance().initResourceLocation("lunar", "icons/settings/arrow-left-32x32.png");
        this.scrollbar = new ScrollbarUIComponent(this);
        this.configurable = feature instanceof DraggableHudMod || feature instanceof ConfigurableFeature && !((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll().isEmpty();
        this.resetToDefaults = new lIlIlIIIIIIllIlIIIIllIIII(this, "resetToDefaults");
        if (this.configurable) {
            this.resetPosition = new lIlIlIIIIIIllIlIIIIllIIII(this, "resetPosition");
            this.resetPosition.onMouseClick((float f, float f2, int n) -> {
                if (feature instanceof DraggableHudMod) {
                    ((DraggableHudMod)feature).lIlIlIlIlIIlIIlIIllIIIIIl(((DraggableHudMod)feature).IIllIlIllIlIllIllIllIllII());
                    ((DraggableHudMod)feature).lIlIlIIIIIIllIlIIIIllIIII();
                }
                if (feature instanceof ConfigurableFeature) {
                    for (AbstractFeatureContainerChild abstractFeatureContainerChild : ((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll()) {
                        abstractFeatureContainerChild.lIlIlIlIlIIlIIlIIllIIIIIl(abstractFeatureContainerChild.IIllIlIllIlIllIllIllIllII());
                        abstractFeatureContainerChild.lIlIlIIIIIIllIlIIIIllIIII();
                    }
                }
                WrappedGuiScreenBridge wrappedGuiScreenBridge = (WrappedGuiScreenBridge)Ref.getMinecraft().bridge$getCurrentScreen();
                wrappedGuiScreenBridge.getCustomScreen().llllIIlIIlIIlIIllIIlIIllI();
                return true;
            });
        }
        this.resetToDefaults.onMouseClick((mouseX, mouseY, button) -> {
            for (AbstractSetting<?> setting : feature.lllIIIIIlllIIlIllIIlIIIlI()) {
                setting.d_();
            }
            if (feature instanceof ConfigurableFeature && ((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll() != null) {
                for (Feature i18nBridge : ((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll()) {
                    i18nBridge.llIIIlllIIlllIllllIlIllIl().d_();
                    for (AbstractSetting<?> setting : i18nBridge.lllIIIIIlllIIlIllIIlIIIlI()) {
                        setting.d_();
                    }
                }
            }
            WrappedGuiScreenBridge wrappedGuiScreenBridge = (WrappedGuiScreenBridge) Ref.getMinecraft().bridge$getCurrentScreen();
            wrappedGuiScreenBridge.getCustomScreen().llllIIlIIlIIlIIllIIlIIllI();
            return true;
        });
        this.onMouseClick((mouseX, mouseY, button) -> {
            if (this.resetToDefaults.mouseInside(mouseX, mouseY)) {
                return this.resetToDefaults.onMouseClicked(mouseX, mouseY, button);
            }
            if (this.configurable && this.resetPosition.mouseInside(mouseX, mouseY)) {
                return this.resetPosition.onMouseClicked(mouseX, mouseY, button);
            }
            if (this.mouseInside(mouseX, mouseY) && mouseY >= this.y + 3.0f && mouseY < this.y + 21.0f && mouseX >= 4.0f && mouseX <= mouseX + 25.0f) {
                clientSettingsParentUIComponent.llIIIIIIIllIIllIlIllIIIIl().IlllllIlIIIlIIlIIllIIlIll().setText("");
                clientSettingsParentUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(clientSettingsParentUIComponent.llIIIIIIIllIIllIlIllIIIIl());
                clientSettingsParentUIComponent.IlllIIIIIIlllIlIIlllIlIIl(0);
                return true;
            }
            for (AbstractDescritiveSettingUIComponent<?> component : this.components) {
                if (component.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII() == null || component.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() || !component.mouseInside(mouseX, mouseY - this.scrollbar.getYOffset())) continue;
                return component.onMouseClicked(mouseX, mouseY - this.scrollbar.getYOffset(), button);
            }
            if (this.scrollbar.mouseInside(mouseX, mouseY)) {
                return this.scrollbar.onMouseClicked(mouseX, mouseY, button);
            }
            return false;
        });
        if (feature instanceof ConfigurableFeature && !((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll().isEmpty()) {
            for (AbstractFeatureContainerChild i18nBridge : ((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll()) {
                this.components.add(new FeatureContainerUIComponent(i18nBridge, this));
            }
        }
        for (AbstractSetting<?> i18nBridge : feature.lllIIIIIlllIIlIllIIlIIIlI()) {
            if (Debug.DebugHelper.lIlIlIlIlIIlIIlIIllIIIIIl(i18nBridge, feature) && !Ref.isConnectedToWebSocket()) continue;
            this.components.add(i18nBridge.getUIComponent(this));
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(true);
    }

    @Override
    public List<AbstractDescritiveSettingUIComponent<?>> lIllIlIIIlIIIIIIIlllIlIll() {
        return new ArrayList<>();
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        float f5 = y + 27.0f;
        float f6 = 0.0f;
        String string = this.lIlIlIlIlIIlIIlIIllIIIIIl.getDetails().get("description");
        if (!string.equalsIgnoreCase("") && !string.equals("description")) {
            List<String> strings = FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIllIlIIIlIIIIIIIlllIlIll(string, width - 12.0f);
            f6 += (float)strings.size() * 8.0f + 8.0f;
            boolean hasAuthors = this.lIlIlIlIlIIlIIlIIllIIIIIl.getDetails().getOriginalAuthors() != null && !this.lIlIlIlIlIIlIIlIIllIIIIIl.getDetails().getOriginalAuthors().isEmpty();
            if (hasAuthors) {
                String string2 = this.get("originalAuthors") + String.join(", ", this.lIlIlIlIlIIlIIlIIllIIIIIl.getDetails().getOriginalAuthors());
                List<String> list = FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIllIlIIIlIIIIIIIlllIlIll(string2, width - 12.0f);
                f6 += (float)list.size() * 8.0f + 4.0f;
            }
        }
        this.scrollbar.setPositionAndSize(x + width - 6.0f, f5 += f6, 4.0f, height - 40.0f - f6);
        Set<AbstractSetting<?>> set = new HashSet<>();
        HashSet<AbstractSetting<?>> hashSet = new HashSet<>();
        width -= 30.0f;
        float f7 = 0.0f;
        int n = 0;
        float f8 = f5;
        for (AbstractDescritiveSettingUIComponent<?> component : this.components) {
            float f9;
            if (component.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII() != null && component.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean()) {
                set.add(component.llIIIIIIIllIIllIlIllIIIIl());
                continue;
            }
            if (component instanceof ColorPickerUIComponent && ((ColorPickerUIComponent)component).llIlllIIIllllIIlllIllIIIl()) {
                hashSet.add(component.llIIIIIIIllIIllIlIllIIIIl());
            }
            boolean bl = component.lIllIlIIIlIIIIIIIlllIlIll();
            boolean bl3 = component.llIIIIIIIllIIllIlIllIIIIl() instanceof SettingLabel;
            float f10 = f9 = bl ? width / 2.0f : width;
            if (n == 2) {
                n = 0;
                f8 += f7;
                f7 = 0.0f;
            }
            if (!bl) {
                n = 0;
                f8 += f7;
                f7 = 0.0f;
            }
            if (component.getHeight() > f7) {
                f7 = component.getHeight();
            }
            component.resoze(x + (bl3 ? 0.0f : 15.0f) + (float)n * (width / 2.0f), f8, f9);
            if (!bl) {
                f8 += f7;
                f7 = 0.0f;
                continue;
            }
            if (this.components.get(this.components.size() - 1) == component) {
                f8 += f7;
            }
            ++n;
        }
        if (!set.equals(this.IIlIllIlIIllIIlIlIllllllI) && !this.IllIIIlllIIIlIlllIlIIlIII) {
            this.components.removeIf(abstractDescritiveSettingUIComponent -> abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean());
            this.IIlIllIlIIllIIlIlIllllllI.removeAll(set);
            for (AbstractSetting<?> setting : this.IIlIllIlIIllIIlIlIllllllI) {
                this.components.add(setting.getUIComponent(this));
            }
            this.components.sort(Comparator.comparingInt(abstractDescritiveSettingUIComponent -> this.lIlIlIlIlIIlIIlIIllIIIIIl.lllIIIIIlllIIlIllIIlIIIlI().indexOf(abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl())));
        }
        if (!this.lIIIlllIIIIllllIlIIIlIIll.equals(hashSet) && !this.IllIIIlllIIIlIlllIlIIlIII && this.lIIIlllIIIIllllIlIIIlIIll.size() <= hashSet.size()) {
            this.scrollbar.setYOffset(this.scrollbar.getYOffset() - 65.0f);
        }
        this.lIIIlllIIIIllllIlIIIlIIll = hashSet;
        if (!this.IllIIIlllIIIlIlllIlIIlIII) {
            this.IIlIllIlIIllIIlIlIllllllI = set;
        }
        this.IllIIIlllIIIlIlllIlIIlIII = false;
        this.scrollbar.setContentHeight(f8 - f5 + 4.0f);
        this.resetToDefaults.setPositionAndSize(x + width - 50.0f, y + 4.0f, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.resetToDefaults.getTranslationText()) + 8, 16.0f);
        if (this.configurable) {
            this.resetPosition.setPositionAndSize(x + width - (float)(FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.resetToDefaults.getTranslationText()) + 8 + FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.resetPosition.getTranslationText())), y + 4.0f, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.resetPosition.getTranslationText()) + 8, 16.0f);
        }
        if (this.IllllllllllIlIIIlllIlllll != null) {
            this.scrollbar.setYOffset(-(this.IllllllllllIlIIIlllIlllll.getY() - f5));
            this.IllllllllllIlIIIlllIlllll = null;
        }
    }

    @Override
    public void onUpdateScreen() {
        super.onUpdateScreen();
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        WrappedGuiScreenBridge wrappedGuiScreenBridge;
        int n;
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y, this.width, 25.0f, 8.0f, 0x35000000, true, true, false, false);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + 25.0f, this.width, this.height - 25.0f, 12.0f, 0x20000000, false, false, true, true);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 24.0f, this.width, 1.0f, 0x20FFFFFF);
        FontRegistry.lllllIllIllIllllIlIllllII().lIlIlIlIlIIlIIlIIllIIIIIl(this.featureName, this.x + 30.0f, this.y + 7.0f, -1);
        float f3 = 0.0f;
        String string = this.lIlIlIlIlIIlIIlIIllIIIIIl.getDetails().get("description");
        if (!string.equals("") && !string.equals("description")) {
            List<String> strings = FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIllIlIIIlIIIIIIIlllIlIll(string, this.width - 12.0f);
            int n2 = 0;
            for (String string2 : strings) {
                FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(string2, this.x + 6.0f, this.y + 28.0f + (float)n2 * 8.0f + 0.5f, -1);
                ++n2;
            }
            f3 += (float)n2 * 8.0f + 8.0f;
            boolean bl2 = this.lIlIlIlIlIIlIIlIIllIIIIIl.getDetails().getOriginalAuthors() != null && !this.lIlIlIlIlIIlIIlIIllIIIIIl.getDetails().getOriginalAuthors().isEmpty();
            n = 0;
            if (bl2) {
                String string3 = this.get("originalAuthors") + String.join(", ", this.lIlIlIlIlIIlIIlIIllIIIIIl.getDetails().getOriginalAuthors());
                List<String> list2 = FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIllIlIIIlIIIIIIIlllIlIll(string3, this.width - 12.0f);
                for (String string4 : list2) {
                    FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(string4, this.x + 6.0f, this.y + 24.0f + f3 + (float)n * 8.0f + 0.5f, -1);
                    ++n;
                }
                f3 += (float)n * 8.0f + 4.0f;
            }
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 24.0f + (bl2 ? 2.0f : 0.0f), this.width, f3, 0x15000000);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 25.0f + (bl2 ? 3.0f : 0.0f) + (float)n2 * 8.0f + (float)n * 8.0f + 8.0f, this.width, 1.0f, 0x20FFFFFF);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.backIcon, 8.0f, this.x + 7.0f, this.y + 4.0f);
        if (this.mouseInside(mouseX, mouseY) && mouseY > this.y + 3.0f && mouseY < this.y + 21.0f && mouseX >= this.x + 4.0f && mouseX <= this.x + 25.0f) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.backIcon, 8.0f, this.x + 7.0f, this.y + 4.0f);
        }
        this.resetToDefaults.drawComponent(mouseX, mouseY, bl);
        if (this.configurable) {
            this.resetPosition.drawComponent(mouseX, mouseY, bl);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable(3089);
        float f4 = 0.0f;
        if (this.mc.bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && (wrappedGuiScreenBridge = (WrappedGuiScreenBridge)this.mc.bridge$getCurrentScreen()).getCustomScreen() instanceof AbstractUIScreen) {
            AbstractUIScreen abstractUIScreen = (AbstractUIScreen)wrappedGuiScreenBridge.getCustomScreen();
            f4 = abstractUIScreen.lllllIllIlIIlIIlIIIlllIlI();
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)this.x, (int)(this.y + 26.0f + f3), (int)(this.x + this.width), (int)(this.y + this.height), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)f4);
        this.scrollbar.onDraw(mouseX, mouseY, bl);
        for (UIComponent uIComponent : this.components) {
            boolean bl3;
            n = uIComponent.getY() + uIComponent.getHeight() + this.scrollbar.getYOffset() < this.scrollbar.getY() ? 1 : 0;
            boolean bl4 = bl3 = uIComponent.getY() + this.scrollbar.getYOffset() > this.scrollbar.getY() + this.scrollbar.getHeight();
            if (n != 0 || bl3) continue;
            uIComponent.drawComponent(mouseX, mouseY - this.scrollbar.getYOffset(), bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, mouseX, mouseY));
        }
        if (this.sumTing != null) {
            this.sumTing.drawComponent(mouseX, mouseY - this.scrollbar.getYOffset(), bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.sumTing, mouseX, mouseY));
        }
        this.scrollbar.llllIIlIIlIIlIIllIIlIIllI(mouseX, mouseY, bl);
        GL11.glDisable(3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        for (AbstractDescritiveSettingUIComponent<?> abstractDescritiveSettingUIComponent : this.components) {
            boolean bl5;
            n = abstractDescritiveSettingUIComponent.getY() + abstractDescritiveSettingUIComponent.getHeight() + this.scrollbar.getYOffset() < this.scrollbar.getY() ? 1 : 0;
            boolean bl6 = bl5 = abstractDescritiveSettingUIComponent.getY() + this.scrollbar.getYOffset() > this.scrollbar.getY() + this.scrollbar.getHeight();
            if (n != 0 || bl5) continue;
            if (abstractDescritiveSettingUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(mouseX, mouseY - this.scrollbar.getYOffset())) {
                abstractDescritiveSettingUIComponent.lIllIlIIIlIIIIIIIlllIlIll(mouseX, mouseY);
            }
            if (abstractDescritiveSettingUIComponent instanceof ClashesWithWarningUIComponent && ((ClashesWithWarningUIComponent)abstractDescritiveSettingUIComponent).llllIIlIIlIIlIIllIIlIIllI().mouseInside(mouseX, mouseY - this.scrollbar.getYOffset())) {
                ((ClashesWithWarningUIComponent)abstractDescritiveSettingUIComponent).llIlllIIIllllIIlllIllIIIl(mouseX, mouseY);
            }
            if (!(abstractDescritiveSettingUIComponent instanceof HKTextSettingUIComponent) || !((HKTextSettingUIComponent)abstractDescritiveSettingUIComponent).llllIIlIIlIIlIIllIIlIIllI().mouseInside(mouseX, mouseY - this.scrollbar.getYOffset())) continue;
            ((HKTextSettingUIComponent)abstractDescritiveSettingUIComponent).llIlllIIIllllIIlllIllIIIl(mouseX, mouseY);
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        super.onKeyTyped(c, keyType);
        if (keyType == KeyType.KEY_BACK || keyType == KeyType.KEY_LEFT) {
            if (this.components.stream().anyMatch(abstractDescritiveSettingUIComponent -> abstractDescritiveSettingUIComponent instanceof HKTextSettingUIComponent && ((HKTextSetting) abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl()).IlllIIIIIIlllIlIIlllIlIIl() || abstractDescritiveSettingUIComponent instanceof TextSettingUIComponent && ((TextSetting) abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl()).getBool())) {
                return;
            }
            ((ClientSettingsParentUIComponent)this.parent).llIIIIIIIllIIllIlIllIIIIl().IlllllIlIIIlIIlIIllIIlIll().setText("");
            ((ClientSettingsParentUIComponent)this.parent).lIlIlIlIlIIlIIlIIllIIIIIl(((ClientSettingsParentUIComponent)this.parent).llIIIIIIIllIIllIlIllIIIIl());
            ((ClientSettingsParentUIComponent)this.parent).IlllIIIIIIlllIlIIlllIlIIl(0);
        }
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
        this.scrollbar.handleMouseScrollDelta(n);
    }

    @Override
    public void onGuiClosed() {
    }

    public Feature llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public ScrollbarUIComponent llIIIIIIIllIIllIlIllIIIIl() {
        return this.scrollbar;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractDescritiveSettingUIComponent<?> uIComponent) {
        this.IllllllllllIlIIIlllIlllll = uIComponent;
    }
}
