package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.profile.main.GeneralOptions;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.ScrollbarUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.TextboxWithIcon;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.LanguageParser;
import org.lwjgl.opengl.GL11;

import java.util.*;
import java.util.stream.Collectors;

public class ModuleListUIComponent extends AbstractListUIComponent<UIComponent> {
    public List<ModuleCategoryButtonUIComponent> categoryButtons;
    public List<AbstractFeatureUIComponent> featureUIComponents;
    public ModuleCategory category = ModuleCategory.ALL;
    public AbstractFeatureUIComponent dragging = null;
    public float dragOffsetX = 0.0f;
    public float dragOffsetY = 0.0f;
    public AbstractFeatureUIComponent clicked = null;
    public long mouseDownTime = 0L;
    public ScrollbarUIComponent scrollContainer = new ScrollbarUIComponent(this);
    public TextboxWithIcon searchBox;
    public FeaturesLayoutSwitchButtonUIComponent layoutSwitchButton;
    public boolean mouseDown;

    public ModuleListUIComponent(UIComponent parent) {
        super(parent);
        this.onMouseRelease((f, f2, n) -> {
            if (this.mouseDown) {
                for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.featureUIComponents) {
                    if (!(f2 > this.y + 20.0f) || !abstractFeatureUIComponent.mouseInside(f, f2 - this.scrollContainer.getYOffset())) continue;
                    this.mouseDown = false;
                    return abstractFeatureUIComponent.onMouseReleased(f, f2 - this.scrollContainer.getYOffset(), n);
                }
            }
            this.mouseDown = false;
            return false;
        });
        this.onMouseClick((mouseX, mouseY, mouseButton) -> {
            this.mouseDown = true;
            if (this.layoutSwitchButton.mouseInside(mouseX, mouseY)) {
                LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().getCompactMenu().lIlIlIlIlIIlIIlIIllIIIIIl(LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().getCompactMenu().llIlllIIIllllIIlllIllIIIl() == false);
                if (Ref.getWorld() != null) {
                    LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().save();
                }
                this.setPositionAndSize(mouseX, mouseY, this.width, this.height);
                return true;
            }
            for (UIComponent component : this.categoryButtons) {
                if (!component.mouseInside(mouseX, mouseY)) continue;
                this.setPositionAndSize(mouseX, mouseY, this.width, this.height);
                return component.onMouseClicked(mouseX, mouseY, mouseButton);
            }
            for (UIComponent component : this.featureUIComponents) {
                if (!(mouseY > this.y + 20.0f) || !component.mouseInside(mouseX, mouseY - this.scrollContainer.getYOffset()) || !component.onMouseClicked(mouseX, mouseY - this.scrollContainer.getYOffset(), mouseButton)) continue;
                this.dragging = null;
                this.dragOffsetY = 0.0f;
                this.dragOffsetX = 0.0f;
                this.clicked = null;
                this.mouseDownTime = 0L;
                return true;
            }
            return this.scrollContainer.mouseInside(mouseX, mouseY) && this.scrollContainer.onMouseClicked(mouseX, mouseY, mouseButton) || this.searchBox.mouseInside(mouseX, mouseY) && this.searchBox.onMouseClicked(mouseX, mouseY, mouseButton);
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> this.searchBox.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n));
        this.categoryButtons = new ArrayList<>();
        for (ModuleCategory moduleCategory : ModuleCategory.values()) {
            if (moduleCategory == ModuleCategory.NONE) continue;
            ModuleCategoryButtonUIComponent categoryButton = new ModuleCategoryButtonUIComponent(moduleCategory, this);
            this.categoryButtons.add(categoryButton);
            if (moduleCategory == ModuleCategory.ALL) {
                categoryButton.setSelected(true);
            }
            categoryButton.onMouseClick((f, f2, n) -> {
                for (ModuleCategoryButtonUIComponent buttonUIComponent : this.categoryButtons) {
                    buttonUIComponent.setSelected(false);
                }
                categoryButton.setSelected(true);
                this.category = categoryButton.getCategory();
                this.setPositionAndSize(this.x, this.y, this.width, this.height);
                return true;
            });
        }
        this.layoutSwitchButton = new FeaturesLayoutSwitchButtonUIComponent(this);
        this.featureUIComponents = new LinkedList<>();
        this.initialize();
    }

    @Override
    public void IlIlIlllllIlIIlIlIlllIlIl() {
        this.setPositionAndSize(this.x, this.y, this.width, this.height);
    }

    public void initialize() {
        this.featureUIComponents.clear();
        this.dragging = null;
        this.clicked = null;
        for (ConfigurableFeature configurableFeature : this.lc.lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl()) {
            if (!configurableFeature.getDetails().isEnabledOnCurrentVersion()) continue;
            this.featureUIComponents.add(
                LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().getCompactMenu().llIlllIIIllllIIlllIllIIIl() ?
                new CompactModuleUIComponent(this, (ClientSettingsParentUIComponent)this.parent, this, configurableFeature) :
                new DefaultModuleUIComponent(this, (ClientSettingsParentUIComponent)this.parent, configurableFeature)
            );
        }
        if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIIlIlllIIlIIIlIlIlIllI().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SortingOptions.ALPHABETICAL) {
            this.featureUIComponents = this.featureUIComponents.stream().sorted(Comparator.comparing(abstractFeatureUIComponent -> abstractFeatureUIComponent.getFeature().getDetails().get("name"))).collect(Collectors.toList());
        }
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {

        if (mouseDown) {
            float left = x;
            float top = y;
            float right = x + width;
            float bottom = y + height;
            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(left, top, bottom, right, -1);
        }

        ArrayList<Integer> panelIndexes = new ArrayList<>();
        for (AbstractFeatureUIComponent featureUIComponent : this.featureUIComponents) {
            if (!featureUIComponent.getFeature().getDetails().getCategories().contains(ModuleCategory.ALL)) continue;
            if (panelIndexes.contains(featureUIComponent.getFeature().getPanelIndex())) {
                featureUIComponent.getFeature().setPanelX(0.0f);
                featureUIComponent.getFeature().setPanelY(0.0f);
                featureUIComponent.getFeature().setPanelIndex(0);
                featureUIComponent.getFeature().llIlllIIIllllIIlllIllIIIl(true);
                continue;
            }
            panelIndexes.add(featureUIComponent.getFeature().getPanelIndex());
        }
        int max = panelIndexes.stream().max(Integer::compare).orElse(0);
        int min = panelIndexes.stream().min(Integer::compare).orElse(0);
        if (max != panelIndexes.size() - 1) {
            for (int panelIndex = 0; panelIndex < panelIndexes.size() - 1; ++panelIndex) {
                if (panelIndexes.contains(panelIndex)) continue;
                for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.featureUIComponents) {
                    if (abstractFeatureUIComponent.getFeature().getPanelIndex() < panelIndex) continue;
                    abstractFeatureUIComponent.getFeature().setPanelIndex(abstractFeatureUIComponent.getFeature().getPanelIndex() - 1);
                }
                break;
            }
        }
        if (min != 0) {
            for (int panelIndex = 0; panelIndex < panelIndexes.size() - 1; ++panelIndex) {
                if (panelIndexes.contains(panelIndex)) continue;
                for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.featureUIComponents) {
                    if (abstractFeatureUIComponent.getFeature().getPanelIndex() >= panelIndex) continue;
                    abstractFeatureUIComponent.getFeature().setPanelIndex(abstractFeatureUIComponent.getFeature().getPanelIndex() + 1);
                }
                break;
            }
        }
        super.setPositionAndSize(x, y, width, height);
        float f9 = 0.0f;
        for (ModuleCategoryButtonUIComponent categoryButtonUIComponent : this.categoryButtons) {
            categoryButtonUIComponent.setPosition(x + f9, y + 1.0f);
            f9 += categoryButtonUIComponent.getWidth() + 4.0f;
        }
        int column = 0;
        int row = 0;
        HashMap<String, AbstractFeatureUIComponent> searchResults = new HashMap<>();
        if (!this.searchBox.getText().isEmpty()) {
            String normalized = LanguageParser.normalize(this.searchBox.getText());
            for (AbstractFeatureUIComponent featureUIComponent : this.featureUIComponents) {
                String name = featureUIComponent.getFeature().getDetails().get("name");
                if (searchResults.containsKey(name) || !this.isFilterMatch(featureUIComponent.getFeature(), normalized)) continue;
                searchResults.put(name, featureUIComponent);
            }
        }
        for (AbstractFeatureUIComponent component : this.featureUIComponents) {
            if (!component.getFeature().getDetails().getCategories().contains(this.category) || !this.searchBox.getText().isEmpty() && !searchResults.containsKey(component.getFeature().getDetails().get("name"))) {
                component.setPositionAndSize(x - this.getTileWidth() - 10.0f, y, this.getTileWidth(), this.getTileHeight());
                continue;
            }
            if (column == 3) {
                column = 0;
                ++row;
            }
            int index = column + row * 3;
            if (component.getFeature().IIlIllIlllllllIIlIIIllIIl() && component.getFeature().getPanelX() == 0.0f && component.getFeature().getPanelY() == 0.0f && component.getFeature().getPanelIndex() == 0) {
                component.getFeature().setPanelIndex(index);
                component.getFeature().setPanelX(x + (this.getTileWidth() + 8.0f) * (float)column);
                component.getFeature().setPanelY(y + 22.0f + (this.getTileHeight() + 8.0f) * (float)row);
                component.getFeature().llIlllIIIllllIIlllIllIIIl(false);
                for (AbstractFeatureUIComponent featureUIComponent : this.featureUIComponents) {
                    if (!featureUIComponent.getFeature().getDetails().getCategories().contains(ModuleCategory.ALL) ||
                            featureUIComponent.equals(component) ||
                            featureUIComponent.getFeature().IIlIllIlllllllIIlIIIllIIl() &&
                            featureUIComponent.getFeature().getPanelX() == 0.0f &&
                            featureUIComponent.getFeature().getPanelY() == 0.0f &&
                            featureUIComponent.getFeature().getPanelIndex() == 0
                            || index > featureUIComponent.getFeature().getPanelIndex()
                       ) continue;
                    featureUIComponent.getFeature().setPanelIndex(featureUIComponent.getFeature().getPanelIndex() + 1);
                    featureUIComponent.getFeature().setPanelX(x + (this.getTileWidth() + 8.0f) * (float)(featureUIComponent.getFeature().getPanelIndex() % 3));
                    featureUIComponent.getFeature().setPanelY(y + 22.0f + (this.getTileHeight() + 8.0f) * (float)(featureUIComponent.getFeature().getPanelIndex() - featureUIComponent.getFeature().getPanelIndex() % 3) / 3.0f);
                    featureUIComponent.getFeature().llIlllIIIllllIIlllIllIIIl(false);
                }
            }
            if (this.clicked == null && this.dragging == null) {
                component.getFeature().setPanelX(x + (this.getTileWidth() + 8.0f) * (float)(component.getFeature().getPanelIndex() % 3));
                component.getFeature().setPanelY(y + 22.0f + (this.getTileHeight() + 8.0f) * (float)(component.getFeature().getPanelIndex() - component.getFeature().getPanelIndex() % 3) / 3.0f);
            }
            if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIIlIlllIIlIIIlIlIlIllI().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SortingOptions.CUSTOM && this.category == ModuleCategory.ALL && this.searchBox.getText().isEmpty()) {
                component.setPositionAndSize(component.getFeature().getPanelX(), component.getFeature().getPanelY(), this.getTileWidth(), this.getTileHeight());
            } else {
                component.setPositionAndSize(x + (component.getWidth() + 8.0f) * (float)column, y + 22.0f + (component.getHeight() + 8.0f) * (float)row, this.getTileWidth(), this.getTileHeight());
            }
            ++column;
        }
        this.scrollContainer.setPositionAndSize(x + width - 6.0f, y + 20.0f, 4.0f, height - 20.0f);
        this.scrollContainer.setContentHeight(row == 0 ? this.getTileWidth() + 4.0f : 4.0f + this.getTileHeight() + (this.getTileHeight() + 8.0f) * (float)row);
        this.layoutSwitchButton.setPositionAndSize(x + f9, y + 1.0f, 14.0f, 14.0f);
        float f10 = 100.0f;
        float f11 = 14.0f;
        this.searchBox.setPositionAndSize(x + (f9 += 16.0f), y + 1.0f, width - f9 - 2.0f, f11);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    @Override
    public List<UIComponent> lIllIlIIIlIIIIIIIlllIlIll() {
        return Arrays.asList(this.searchBox = new TextboxWithIcon(this, Bridge.getInstance().initResourceLocation("lunar", "icons/assets/magnifying-glass-12x12.png"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI, "searchPlaceholder", 0x20FFFFFF, 0x35FFFFFF));
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        WrappedGuiScreenBridge aaa;
        for (ModuleCategoryButtonUIComponent object2 : this.categoryButtons) {
            object2.drawComponent(mouseX, mouseY, bl);
        }
        this.layoutSwitchButton.drawComponent(mouseX, mouseY, bl);
        if (!this.mouseDown) {
            if (this.dragging != null) {
                for (AbstractFeatureUIComponent object2 : this.featureUIComponents) {
                    object2.getFeature().setPanelX(this.x + (this.getTileWidth() + 8.0f) * (float)(object2.getFeature().getPanelIndex() % 3));
                    object2.getFeature().setPanelY(this.y + 22.0f + (this.getTileHeight() + 8.0f) * (float)(object2.getFeature().getPanelIndex() - object2.getFeature().getPanelIndex() % 3) / 3.0f);
                }
                this.dragging = null;
            }
            if (this.clicked != null) {
                this.clicked = null;
                this.mouseDownTime = 0L;
            }
        } else if (this.mouseDownTime != 0L && this.clicked != null && System.currentTimeMillis() - this.mouseDownTime >= 350L) {
            this.dragging = this.clicked;
            this.clicked = null;
            this.mouseDownTime = 0L;
        }
        if (this.dragging != null) {
            this.dragging.getFeature().setPanelX(Math.max(this.x, Math.min(this.dragOffsetX + mouseX, this.x + this.width - this.getTileWidth())));
            if (this.dragging.getFeature().getPanelY() >= this.y + this.height - this.getTileHeight() - this.scrollContainer.getYOffset()) {
                this.scrollContainer.setScrollAmount(this.scrollContainer.getScrollAmount() - 10.0);
            } else if (this.dragging.getFeature().getPanelY() <= this.y + 20.0f - this.scrollContainer.getYOffset()) {
                this.scrollContainer.setScrollAmount(this.scrollContainer.getScrollAmount() + 10.0);
            }
            this.dragging.getFeature().setPanelY(Math.max(this.y - this.scrollContainer.getYOffset(), Math.min(this.y + this.height - this.scrollContainer.getYOffset(), this.dragOffsetY + mouseY - this.scrollContainer.getYOffset())));
            for (AbstractFeatureUIComponent featureUIComponent : this.featureUIComponents) {
                if (featureUIComponent.equals(this.dragging) || !featureUIComponent.mouseInside(mouseX, mouseY - this.scrollContainer.getYOffset())) continue;
                boolean bl2 = featureUIComponent.getFeature().getPanelIndex() - this.dragging.getFeature().getPanelIndex() < 0;
                float f3 = this.dragging.getFeature().getPanelIndex();
                this.dragging.getFeature().setPanelIndex(featureUIComponent.getFeature().getPanelIndex());
                for (AbstractFeatureUIComponent otherFeature : this.featureUIComponents) {
                    if (otherFeature.equals(this.dragging)) continue;
                    if (bl2 && otherFeature.getFeature().getPanelIndex() >= featureUIComponent.getFeature().getPanelIndex() && (float)otherFeature.getFeature().getPanelIndex() < f3) {
                        otherFeature.getFeature().setPanelIndex(otherFeature.getFeature().getPanelIndex() + 1);
                    }
                    if (!bl2 && otherFeature.getFeature().getPanelIndex() <= featureUIComponent.getFeature().getPanelIndex() && (float)otherFeature.getFeature().getPanelIndex() > f3) {
                        otherFeature.getFeature().setPanelIndex(otherFeature.getFeature().getPanelIndex() - 1);
                    }
                    otherFeature.getFeature().setPanelX(this.x + (this.getTileWidth() + 8.0f) * (float)(otherFeature.getFeature().getPanelIndex() % 3));
                    otherFeature.getFeature().setPanelY(this.y + 22.0f + (this.getTileHeight() + 8.0f) * (float)(otherFeature.getFeature().getPanelIndex() - otherFeature.getFeature().getPanelIndex() % 3) / 3.0f);
                }
            }
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable(3089);
        float f4 = 0.0f;
        if (this.mc.bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && (aaa = (WrappedGuiScreenBridge)this.mc.bridge$getCurrentScreen()).getCustomScreen() instanceof AbstractUIScreen) {
            AbstractUIScreen abstractUIScreen = (AbstractUIScreen) aaa.getCustomScreen();
            f4 = abstractUIScreen.lllllIllIlIIlIIlIIIlllIlI();
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x - 2.0f), (int)(this.y + 20.0f), (int)(this.x + this.width + 2.0f), (int)(this.y + this.height + 5.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)f4);
        if (this.dragging != null) {
            float f5 = this.x + (this.getTileWidth() + 8.0f) * (float)(this.dragging.getFeature().getPanelIndex() % 3);
            float f6 = this.y + 22.0f + (this.getTileHeight() + 8.0f) * (float)(this.dragging.getFeature().getPanelIndex() - this.dragging.getFeature().getPanelIndex() % 3) / 3.0f + this.scrollContainer.getYOffset();
            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(f5, f6, this.getTileWidth(), this.getTileHeight(), 3.0f, 0x2AFFFFFF);
        }
        this.scrollContainer.onDraw(mouseX, mouseY, bl);
        for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.featureUIComponents) {
            boolean bl4 = abstractFeatureUIComponent.getY() + abstractFeatureUIComponent.getHeight() + this.scrollContainer.getYOffset() < this.scrollContainer.getY();
            boolean bl3 = abstractFeatureUIComponent.getY() + this.scrollContainer.getYOffset() > this.scrollContainer.getY() + this.scrollContainer.getHeight();
            if (!(abstractFeatureUIComponent.getX() >= this.x) || bl4 || bl3) continue;
            if (this.dragging != null && this.dragging.equals(abstractFeatureUIComponent)) {
                abstractFeatureUIComponent.setPositionAndSize(abstractFeatureUIComponent.getX(), abstractFeatureUIComponent.getY(), abstractFeatureUIComponent.getWidth() + 3.0f, abstractFeatureUIComponent.getHeight() + 3.0f);
            }
            abstractFeatureUIComponent.drawComponent(mouseX, mouseY - this.scrollContainer.getYOffset(), this.dragging == null && bl && !this.scrollContainer.lIIIllIllIIllIlllIlIIlllI());
        }
        this.scrollContainer.llllIIlIIlIIlIIllIIlIIllI(mouseX, mouseY, bl);
        GL11.glDisable(3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        super.drawComponent(mouseX, mouseY, bl);
//        // todo debugging lol
//        if (mouseDown) {
//            float left = 20;
//            float top = 20;
//            float bottom = 120;
//            float right = 120;
//            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(left, top, bottom, right, -1);
//        }
    }

    @Override
    public boolean onMouseClicked(float mouseX, float mouseY, int mouseButton) {
        if (this.category == ModuleCategory.ALL && !(Boolean) Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIIlllIIIIIlllIIIlIlIlllI().llIlllIIIllllIIlllIllIIIl() && Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIIlIlllIIlIIIlIlIlIllI().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SortingOptions.CUSTOM && this.searchBox.getText().isEmpty() && mouseY > this.y + 20.0f && mouseY < this.y + this.height) {
            for (AbstractFeatureUIComponent component : this.featureUIComponents) {
                boolean bl2 = component.getY() + component.getHeight() + this.scrollContainer.getYOffset() < this.scrollContainer.getY();
                boolean bl = component.getY() + this.scrollContainer.getYOffset() > this.scrollContainer.getY() + this.scrollContainer.getHeight();
                if (!(component.getX() >= this.x) || bl2 || bl || !component.mouseInside(mouseX, mouseY - this.scrollContainer.getYOffset()) || this.clicked != null || this.dragging != null) continue;
                this.clicked = component;
                this.mouseDownTime = System.currentTimeMillis();
                this.dragOffsetX = this.clicked.getFeature().getPanelX() - mouseX;
                this.dragOffsetY = this.clicked.getFeature().getPanelY() - mouseY + this.scrollContainer.getYOffset();
                break;
            }
        }
        return super.onMouseClicked(mouseX, mouseY, mouseButton);
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
    public boolean mouseInside(float mouseX, float mouseY) {
        if (this.dragging != null) {
            return true;
        }
        return super.mouseInside(mouseX, mouseY);
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        this.scrollContainer.handleMouseScrollDelta(n);
        super.handleMouseScrollDelta(n);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    public float getTileWidth() {
        return LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().getCompactMenu().llIlllIIIllllIIlllIllIIIl() ? 115.0f : 115.0f;
    }

    public float getTileHeight() {
        return LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().getCompactMenu().llIlllIIIllllIIlllIllIIIl() ? 22.0f : 112.0f;
    }

    public boolean isFilterMatch(Feature feature, String string) {
        for (String string2 : feature.lIIIllIllIIllIlllIlIIlllI()) {
            if (!string2.startsWith(string.toLowerCase())) continue;
            return true;
        }
        if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().getSearchOptions().llIlllIIIllllIIlllIllIIIl()) {
            for (String string2 : feature.IlllllIlIIIlIIlIIllIIlIll()) {
                if (!string2.startsWith(string.toLowerCase())) continue;
                return true;
            }
        }
        return false;
    }

    public AbstractFeatureUIComponent getDragging() {
        return this.dragging;
    }

    public ScrollbarUIComponent lIIIllIllIIllIlllIlIIlllI() {
        return this.scrollContainer;
    }

    public TextboxWithIcon IlllllIlIIIlIIlIIllIIlIll() {
        return this.searchBox;
    }
}
