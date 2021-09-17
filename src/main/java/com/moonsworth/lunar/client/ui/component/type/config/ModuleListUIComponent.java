package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.CustomScreen;
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
import com.moonsworth.lunar.client.ui.component.type.overlay.ClientSettingsParentUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IIlIllIlIIllIIlIlIllllllI;
import com.moonsworth.lunar.client.ui.component.type.setting.lllllIllIlIIlIIlIIIlllIlI;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.LanguageParser;
import org.lwjgl.opengl.GL11;

import java.util.*;
import java.util.stream.Collectors;

public class ModuleListUIComponent
extends AbstractListUIComponent {
    public List<ModuleCategoryButtonUIComponent> lIlIlIlIlIIlIIlIIllIIIIIl;
    public List<AbstractFeatureUIComponent> IlllIIIIIIlllIlIIlllIlIIl;
    public ModuleCategory lIllIlIIIlIIIIIIIlllIlIll = ModuleCategory.lIlIlIlIlIIlIIlIIllIIIIIl;
    public AbstractFeatureUIComponent IIlIllIlllllllIIlIIIllIIl = null;
    public float lIIlIlllIlIlIIIlllIIlIIII = 0.0f;
    public float llIllIlIllIlllIllIIIIllII = 0.0f;
    public AbstractFeatureUIComponent IllllllllllIlIIIlllIlllll = null;
    public long lllllIllIlIIlIIlIIIlllIlI = 0L;
    public com.moonsworth.lunar.client.ui.component.type.setting.IIlIllIlIIllIIlIlIllllllI IllIIIlllIIIlIlllIlIIlIII = new IIlIllIlIIllIIlIlIllllllI(this);
    public com.moonsworth.lunar.client.ui.component.type.setting.lllllIllIlIIlIIlIIIlllIlI IIlIllIlIIllIIlIlIllllllI;
    public FeaturesLayoutSwitchButtonUIComponent lIIIlllIIIIllllIlIIIlIIll;
    public boolean llIIIlIllIIIIlIIIlIlIllIl;

    public ModuleListUIComponent(UIComponent parent) {
        super(parent);
        this.lIllIlIIIlIIIIIIIlllIlIll((f, f2, n) -> {
            if (this.llIIIlIllIIIIlIIIlIlIllIl) {
                for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                    if (!(f2 > this.y + 20.0f) || !abstractFeatureUIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll())) continue;
                    this.llIIIlIllIIIIlIIIlIlIllIl = false;
                    return abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), n);
                }
            }
            this.llIIIlIllIIIIlIIIlIlIllIl = false;
            return false;
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            this.llIIIlIllIIIIlIIIlIlIllIl = true;
            if (this.lIIIlllIIIIllllIlIIIlIIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                LunarClient.IIllIlIllIlIllIllIllIllII().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl((Boolean)LunarClient.IIllIlIllIlIllIllIllIllII().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIlIIIIIIllIlIIIIllIIII().llIlllIIIllllIIlllIllIIIl() == false);
                if (Ref.llIIIIIIIllIIllIlIllIIIIl() != null) {
                    LunarClient.IIllIlIllIlIllIllIllIllII().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().save();
                }
                this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, this.width, this.height);
                return true;
            }
            for (UIComponent uIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
                this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, this.width, this.height);
                return uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                if (!(f2 > this.y + 20.0f) || !uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll()) || !uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), n)) continue;
                this.IIlIllIlllllllIIlIIIllIIl = null;
                this.llIllIlIllIlllIllIIIIllII = 0.0f;
                this.lIIlIlllIlIlIIIlllIIlIIII = 0.0f;
                this.IllllllllllIlIIIlllIlllll = null;
                this.lllllIllIlIIlIIlIIIlllIlI = 0L;
                return true;
            }
            return this.IllIIIlllIIIlIlllIlIIlIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n) || this.IIlIllIlIIllIIlIlIllllllI.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> this.IIlIllIlIIllIIlIlIllllllI.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n));
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList();
        for (ModuleCategory moduleCategory : ModuleCategory.values()) {
            if (moduleCategory == ModuleCategory.IlIlIlllllIlIIlIlIlllIlIl) continue;
            ModuleCategoryButtonUIComponent moduleCategoryButtonUIComponent = new ModuleCategoryButtonUIComponent(moduleCategory, this);
            this.lIlIlIlIlIIlIIlIIllIIIIIl.add(moduleCategoryButtonUIComponent);
            if (moduleCategory == ModuleCategory.lIlIlIlIlIIlIIlIIllIIIIIl) {
                moduleCategoryButtonUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            }
            moduleCategoryButtonUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
                for (ModuleCategoryButtonUIComponent moduleCategoryButtonUIComponent2 : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                    moduleCategoryButtonUIComponent2.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                }
                moduleCategoryButtonUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(true);
                this.lIllIlIIIlIIIIIIIlllIlIll = moduleCategoryButtonUIComponent.lIllIlIIIlIIIIIIIlllIlIll();
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height);
                return true;
            });
        }
        this.lIIIlllIIIIllllIlIIIlIIll = new FeaturesLayoutSwitchButtonUIComponent(this);
        this.IlllIIIIIIlllIlIIlllIlIIl = new LinkedList();
        this.llllIIlIIlIIlIIllIIlIIllI();
    }

    @Override
    public void IlIlIlllllIlIIlIlIlllIlIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height);
    }

    public void llllIIlIIlIIlIIllIIlIIllI() {
        this.IlllIIIIIIlllIlIIlllIlIIl.clear();
        this.IIlIllIlllllllIIlIIIllIIl = null;
        this.IllllllllllIlIIIlllIlllll = null;
        for (ConfigurableFeature configurableFeature : this.lIlIIIIIIlIIIllllIllIIlII.lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl()) {
            if (!configurableFeature.llIIlIlIIIllIlIlIlIIlIIll().lIllIlIIIlIIIIIIIlllIlIll()) continue;
            this.IlllIIIIIIlllIlIIlllIlIIl.add((Boolean)LunarClient.IIllIlIllIlIllIllIllIllII().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIlIIIIIIllIlIIIIllIIII().llIlllIIIllllIIlllIllIIIl() != false ? new IlllIIIIIIlllIlIIlllIlIIl(this, (ClientSettingsParentUIComponent)this.lIIIllIllIIllIlllIlIIlllI, this, configurableFeature) : new NewLabelHolderUIComponent(this, (ClientSettingsParentUIComponent)this.lIIIllIllIIllIlllIlIIlllI, configurableFeature));
        }
        if (Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIIlIlllIIlIIIlIlIlIllI().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SortingOptions.IlllIIIIIIlllIlIIlllIlIIl) {
            this.IlllIIIIIIlllIlIIlllIlIIl = this.IlllIIIIIIlllIlIIlllIlIIl.stream().sorted(Comparator.comparing(abstractFeatureUIComponent -> abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIIlIlIIIllIlIlIlIIlIIll().get("name", new Object[0]))).collect(Collectors.toList());
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        int n;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
            if (!abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl().contains(ModuleCategory.lIlIlIlIlIIlIIlIIllIIIIIl)) continue;
            if (arrayList.contains(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI())) {
                abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(0.0f);
                abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IlllIIIIIIlllIlIIlllIlIIl(0.0f);
                abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(0);
                abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl(true);
                continue;
            }
            arrayList.add(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI());
        }
        float f5 = arrayList.stream().max(Integer::compare).orElse(0).intValue();
        float f6 = arrayList.stream().min(Integer::compare).orElse(0).intValue();
        if (f5 != (float)(arrayList.size() - 1)) {
            for (n = 0; n < arrayList.size() - 1; ++n) {
                if (arrayList.contains(n)) continue;
                for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                    if (abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() < n) continue;
                    abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() - 1);
                }
                break;
            }
        }
        if (f6 != 0.0f) {
            for (n = 0; n < arrayList.size() - 1; ++n) {
                if (arrayList.contains(n)) continue;
                for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                    if (abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() >= n) continue;
                    abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() + 1);
                }
                break;
            }
        }
        float f7 = this.lllIIIIIlllIIlIllIIlIIIlI();
        float f8 = this.lIlIIIIIIlIIIllllIllIIlII();
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        float f9 = 0.0f;
        for (ModuleCategoryButtonUIComponent moduleCategoryButtonUIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            moduleCategoryButtonUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f + f9, f2 + 1.0f);
            f9 += moduleCategoryButtonUIComponent.llIlIIIllIIlIllIllIllllIl() + 4.0f;
        }
        int n2 = 0;
        int n3 = 0;
        HashMap<String, AbstractFeatureUIComponent> hashMap = new HashMap<String, AbstractFeatureUIComponent>();
        if (!this.IIlIllIlIIllIIlIlIllllllI.llllIIlIIlIIlIIllIIlIIllI().isEmpty()) {
            String string = LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlIIllIIlIlIllllllI.llllIIlIIlIIlIIllIIlIIllI());
            for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                String string2 = abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIIlIlIIIllIlIlIlIIlIIll().get("name", new Object[0]);
                if (hashMap.containsKey(string2) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll(), string)) continue;
                hashMap.put(string2, abstractFeatureUIComponent);
            }
        }
        for (AbstractFeatureUIComponent object : this.IlllIIIIIIlllIlIIlllIlIIl) {
            if (!((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl().contains(this.lIllIlIIIlIIIIIIIlllIlIll) || !this.IIlIllIlIIllIIlIlIllllllI.llllIIlIIlIIlIIllIIlIIllI().isEmpty() && !hashMap.containsKey(((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().llIIlIlIIIllIlIlIlIIlIIll().get("name", new Object[0]))) {
                ((UIComponent)object).lIlIlIlIlIIlIIlIIllIIIIIl(f - this.llIIlIlIIIllIlIlIlIIlIIll() - 10.0f, f2, this.llIIlIlIIIllIlIlIlIIlIIll(), this.IllllllllllIlIIIlllIlllll());
                continue;
            }
            if (n2 == 3) {
                n2 = 0;
                ++n3;
            }
            int n4 = n2 + n3 * 3;
            if (((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlllllllIIlIIIllIIl() && ((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().lllllIllIlIIlIIlIIIlllIlI() == 0.0f && ((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().IllIIIlllIIIlIlllIlIIlIII() == 0.0f && ((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() == 0) {
                ((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(n4);
                ((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(f + (this.llIIlIlIIIllIlIlIlIIlIIll() + 8.0f) * (float)n2);
                ((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().IlllIIIIIIlllIlIIlllIlIIl(f2 + 22.0f + (this.IllllllllllIlIIIlllIlllll() + 8.0f) * (float)n3);
                ((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl(false);
                for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                    if (!abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl().contains(ModuleCategory.lIlIlIlIlIIlIIlIIllIIIIIl) || abstractFeatureUIComponent.equals(object) || abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlllllllIIlIIIllIIl() && abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lllllIllIlIIlIIlIIIlllIlI() == 0.0f && abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IllIIIlllIIIlIlllIlIIlIII() == 0.0f && abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() == 0 || n4 > abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI()) continue;
                    abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() + 1);
                    abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(f + (this.llIIlIlIIIllIlIlIlIIlIIll() + 8.0f) * (float)(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() % 3));
                    abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IlllIIIIIIlllIlIIlllIlIIl(f2 + 22.0f + (this.IllllllllllIlIIIlllIlllll() + 8.0f) * (float)(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() - abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() % 3) / 3.0f);
                    abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl(false);
                }
            }
            if (this.IllllllllllIlIIIlllIlllll == null && this.IIlIllIlllllllIIlIIIllIIl == null) {
                ((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(f + (this.llIIlIlIIIllIlIlIlIIlIIll() + 8.0f) * (float)(((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() % 3));
                ((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().IlllIIIIIIlllIlIIlllIlIIl(f2 + 22.0f + (this.IllllllllllIlIIIlllIlllll() + 8.0f) * (float)(((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() - ((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() % 3) / 3.0f);
            }
            if (Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIIlIlllIIlIIIlIlIlIllI().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SortingOptions.lIlIlIlIlIIlIIlIIllIIIIIl && this.lIllIlIIIlIIIIIIIlllIlIll == ModuleCategory.lIlIlIlIlIIlIIlIIllIIIIIl && this.IIlIllIlIIllIIlIlIllllllI.llllIIlIIlIIlIIllIIlIIllI().isEmpty()) {
                ((UIComponent)object).lIlIlIlIlIIlIIlIIllIIIIIl(((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().lllllIllIlIIlIIlIIIlllIlI(), ((AbstractFeatureUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll().IllIIIlllIIIlIlllIlIIlIII(), this.llIIlIlIIIllIlIlIlIIlIIll(), this.IllllllllllIlIIIlllIlllll());
            } else {
                ((UIComponent)object).lIlIlIlIlIIlIIlIIllIIIIIl(f + (((UIComponent)object).llIlIIIllIIlIllIllIllllIl() + 8.0f) * (float)n2, f2 + 22.0f + (((UIComponent)object).IllIllIIIllIIIlIlIlIIIIll() + 8.0f) * (float)n3, this.llIIlIlIIIllIlIlIlIIlIIll(), this.IllllllllllIlIIIlllIlllll());
            }
            ++n2;
        }
        this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 6.0f, f2 + 20.0f, 4.0f, f4 - 20.0f);
        this.IllIIIlllIIIlIlllIlIIlIII.IlIlIlllllIlIIlIlIlllIlIl(n3 == 0 ? this.llIIlIlIIIllIlIlIlIIlIIll() + 4.0f : 4.0f + this.IllllllllllIlIIIlllIlllll() + (this.IllllllllllIlIIIlllIlllll() + 8.0f) * (float)n3);
        this.lIIIlllIIIIllllIlIIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f + f9, this.IIlIllIlIIllIIlIlIllllllI.lIlIIIIIIlIIIllllIllIIlII(), 14.0f, 14.0f);
        float f10 = 100.0f;
        float f11 = 14.0f;
        this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl(f + (f9 += 16.0f), f2 + 1.0f, f3 - f9 - 2.0f, f11);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        UIComponent[] uIComponentArray = new UIComponent[1];
        this.IIlIllIlIIllIIlIlIllllllI = new lllllIllIlIIlIIlIIIlllIlI(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/magnifying-glass-12x12.png"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI, "searchPlaceholder", 0x20FFFFFF, 0x35FFFFFF);
        uIComponentArray[0] = this.IIlIllIlIIllIIlIlIllllllI;
        return Arrays.asList(uIComponentArray);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        WrappedGuiScreenBridge aaa;
        for (ModuleCategoryButtonUIComponent object2 : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            ((ModuleCategoryButtonUIComponent)object2).lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        }
        this.lIIIlllIIIIllllIlIIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        if (!this.llIIIlIllIIIIlIIIlIlIllIl) {
            if (this.IIlIllIlllllllIIlIIIllIIl != null) {
                for (AbstractFeatureUIComponent object2 : this.IlllIIIIIIlllIlIIlllIlIIl) {
                    ((AbstractFeatureUIComponent)object2).lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.x + (this.llIIlIlIIIllIlIlIlIIlIIll() + 8.0f) * (float)(((AbstractFeatureUIComponent)object2).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() % 3));
                    ((AbstractFeatureUIComponent)object2).lIllIlIIIlIIIIIIIlllIlIll().IlllIIIIIIlllIlIIlllIlIIl(this.y + 22.0f + (this.IllllllllllIlIIIlllIlllll() + 8.0f) * (float)(((AbstractFeatureUIComponent)object2).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() - ((AbstractFeatureUIComponent)object2).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() % 3) / 3.0f);
                }
                this.IIlIllIlllllllIIlIIIllIIl = null;
            }
            if (this.IllllllllllIlIIIlllIlllll != null) {
                this.IllllllllllIlIIIlllIlllll = null;
                this.lllllIllIlIIlIIlIIIlllIlI = 0L;
            }
        } else if (this.lllllIllIlIIlIIlIIIlllIlI != 0L && this.IllllllllllIlIIIlllIlllll != null && System.currentTimeMillis() - this.lllllIllIlIIlIIlIIIlllIlI >= 350L) {
            this.IIlIllIlllllllIIlIIIllIIl = this.IllllllllllIlIIIlllIlllll;
            this.IllllllllllIlIIIlllIlllll = null;
            this.lllllIllIlIIlIIlIIIlllIlI = 0L;
        }
        if (this.IIlIllIlllllllIIlIIIllIIl != null) {
            this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(Math.max(this.x, Math.min(this.lIIlIlllIlIlIIIlllIIlIIII + f, this.x + this.width - this.llIIlIlIIIllIlIlIlIIlIIll())));
            if (this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll().IllIIIlllIIIlIlllIlIIlIII() >= this.y + this.height - this.IllllllllllIlIIIlllIlllll() - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll()) {
                this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIIIlllIIIlIlllIlIIlIII.llllIIlIIlIIlIIllIIlIIllI() - 10.0);
            } else if (this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll().IllIIIlllIIIlIlllIlIIlIII() <= this.y + 20.0f - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll()) {
                this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIIIlllIIIlIlllIlIIlIII.llllIIlIIlIIlIIllIIlIIllI() + 10.0);
            }
            this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll().IlllIIIIIIlllIlIIlllIlIIl(Math.max(this.y - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), Math.min(this.y + this.height - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), this.llIllIlIllIlllIllIIIIllII + f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll())));
            for (Object object2 : this.IlllIIIIIIlllIlIIlllIlIIl) {
                if (object2.equals(this.IIlIllIlllllllIIlIIIllIIl) || !((UIComponent)object2).IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll())) continue;
                boolean bl2 = ((AbstractFeatureUIComponent)object2).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() - this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() < 0;
                float f3 = this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI();
                this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(((AbstractFeatureUIComponent)object2).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI());
                for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                    if (abstractFeatureUIComponent.equals(this.IIlIllIlllllllIIlIIIllIIl)) continue;
                    if (bl2 && abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() >= ((AbstractFeatureUIComponent)object2).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() && (float)abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() < f3) {
                        abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() + 1);
                    }
                    if (!bl2 && abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() <= ((AbstractFeatureUIComponent)object2).lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() && (float)abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() > f3) {
                        abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() - 1);
                    }
                    abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.x + (this.llIIlIlIIIllIlIlIlIIlIIll() + 8.0f) * (float)(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() % 3));
                    abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IlllIIIIIIlllIlIIlllIlIIl(this.y + 22.0f + (this.IllllllllllIlIIIlllIlllll() + 8.0f) * (float)(abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() - abstractFeatureUIComponent.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() % 3) / 3.0f);
                }
            }
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable((int)3089);
        float f4 = 0.0f;
        if (this.lllIIIIIlllIIlIllIIlIIIlI.bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && (aaa = (WrappedGuiScreenBridge)this.lllIIIIIlllIIlIllIIlIIIlI.bridge$getCurrentScreen()).getCustomScreen() instanceof AbstractUIScreen) {
            AbstractUIScreen abstractUIScreen = (AbstractUIScreen) aaa.getCustomScreen();
            f4 = abstractUIScreen.lllllIllIlIIlIIlIIIlllIlI();
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x - 2.0f), (int)(this.y + 20.0f), (int)(this.x + this.width + 2.0f), (int)(this.y + this.height + 5.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)f4);
        if (this.IIlIllIlllllllIIlIIIllIIl != null) {
            float f5 = this.x + (this.llIIlIlIIIllIlIlIlIIlIIll() + 8.0f) * (float)(this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() % 3);
            float f6 = this.y + 22.0f + (this.IllllllllllIlIIIlllIlllll() + 8.0f) * (float)(this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() - this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll().IIlIllIlIIllIIlIlIllllllI() % 3) / 3.0f + this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll();
            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(f5, f6, this.llIIlIlIIIllIlIlIlIIlIIll(), this.IllllllllllIlIIIlllIlllll(), 3.0f, 0x2AFFFFFF);
        }
        this.IllIIIlllIIIlIlllIlIIlIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2, bl);
        for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
            boolean bl3;
            boolean bl4 = abstractFeatureUIComponent.lIlIIIIIIlIIIllllIllIIlII() + abstractFeatureUIComponent.IllIllIIIllIIIlIlIlIIIIll() + this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll() < this.IllIIIlllIIIlIlllIlIIlIII.lIlIIIIIIlIIIllllIllIIlII();
            boolean bl5 = bl3 = abstractFeatureUIComponent.lIlIIIIIIlIIIllllIllIIlII() + this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll() > this.IllIIIlllIIIlIlllIlIIlIII.lIlIIIIIIlIIIllllIllIIlII() + this.IllIIIlllIIIlIlllIlIIlIII.IllIllIIIllIIIlIlIlIIIIll();
            if (!(abstractFeatureUIComponent.lllIIIIIlllIIlIllIIlIIIlI() >= this.x) || bl4 || bl3) continue;
            if (this.IIlIllIlllllllIIlIIIllIIl != null && this.IIlIllIlllllllIIlIIIllIIl.equals(abstractFeatureUIComponent)) {
                abstractFeatureUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(abstractFeatureUIComponent.lllIIIIIlllIIlIllIIlIIIlI(), abstractFeatureUIComponent.lIlIIIIIIlIIIllllIllIIlII(), abstractFeatureUIComponent.llIlIIIllIIlIllIllIllllIl() + 3.0f, abstractFeatureUIComponent.IllIllIIIllIIIlIlIlIIIIll() + 3.0f);
            }
            abstractFeatureUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll(), this.IIlIllIlllllllIIlIIIllIIl == null && bl && !this.IllIIIlllIIIlIlllIlIIlIII.lIIIllIllIIllIlllIlIIlllI());
        }
        this.IllIIIlllIIIlIlllIlIIlIII.llllIIlIIlIIlIIllIIlIIllI(f, f2, bl);
        GL11.glDisable((int)3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll == ModuleCategory.lIlIlIlIlIIlIIlIIllIIIIIl && !(Boolean) Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIIlllIIIIIlllIIIlIlIlllI().llIlllIIIllllIIlllIllIIIl() && Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIIlIlllIIlIIIlIlIlIllI().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SortingOptions.lIlIlIlIlIIlIIlIIllIIIIIl && this.IIlIllIlIIllIIlIlIllllllI.llllIIlIIlIIlIIllIIlIIllI().isEmpty() && f2 > this.y + 20.0f && f2 < this.y + this.height) {
            for (AbstractFeatureUIComponent abstractFeatureUIComponent : this.IlllIIIIIIlllIlIIlllIlIIl) {
                boolean bl;
                boolean bl2 = abstractFeatureUIComponent.lIlIIIIIIlIIIllllIllIIlII() + abstractFeatureUIComponent.IllIllIIIllIIIlIlIlIIIIll() + this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll() < this.IllIIIlllIIIlIlllIlIIlIII.lIlIIIIIIlIIIllllIllIIlII();
                boolean bl3 = bl = abstractFeatureUIComponent.lIlIIIIIIlIIIllllIllIIlII() + this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll() > this.IllIIIlllIIIlIlllIlIIlIII.lIlIIIIIIlIIIllllIllIIlII() + this.IllIIIlllIIIlIlllIlIIlIII.IllIllIIIllIIIlIlIlIIIIll();
                if (!(abstractFeatureUIComponent.lllIIIIIlllIIlIllIIlIIIlI() >= this.x) || bl2 || bl || !abstractFeatureUIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll()) || this.IllllllllllIlIIIlllIlllll != null || this.IIlIllIlllllllIIlIIIllIIl != null) continue;
                this.IllllllllllIlIIIlllIlllll = abstractFeatureUIComponent;
                this.lllllIllIlIIlIIlIIIlllIlI = System.currentTimeMillis();
                this.lIIlIlllIlIlIIIlllIIlIIII = this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll().lllllIllIlIIlIIlIIIlllIlI() - f;
                this.llIllIlIllIlllIllIIIIllII = this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll().IllIIIlllIIIlIlllIlIIlIII() - f2 + this.IllIIIlllIIIlIlllIlIIlIII.lIllIlIIIlIIIIIIIlllIlIll();
                break;
            }
        }
        return super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        if (keyType == KeyType.lIIIlIllllIIlIIlIIlIIIIlI && this.IIlIllIlIIllIIlIlIllllllI.llIllIlIllIlllIllIIIIllII()) {
            this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl("");
            return;
        }
        super.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        if (!this.IIlIllIlIIllIIlIlIllllllI.llIllIlIllIlllIllIIIIllII()) {
            this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        }
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl(float f, float f2) {
        if (this.IIlIllIlllllllIIlIIIllIIl != null) {
            return true;
        }
        return super.IlllIIIIIIlllIlIIlllIlIIl(f, f2);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        super.IlllIIIIIIlllIlIIlllIlIIl();
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    public float llIIlIlIIIllIlIlIlIIlIIll() {
        return (Boolean)LunarClient.IIllIlIllIlIllIllIllIllII().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIlIIIIIIllIlIIIIllIIII().llIlllIIIllllIIlllIllIIIl() != false ? 115.0f : 115.0f;
    }

    public float IllllllllllIlIIIlllIlllll() {
        return (Boolean)LunarClient.IIllIlIllIlIllIllIllIllII().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIlIIIIIIllIlIIIIllIIII().llIlllIIIllllIIlllIllIIIl() != false ? 22.0f : 112.0f;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Feature feature, String string) {
        for (String string2 : feature.lIIIllIllIIllIlllIlIIlllI()) {
            if (!string2.startsWith(string.toLowerCase())) continue;
            return true;
        }
        if (((Boolean)Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IIIlIIIIIIllIIIIllIIIIlII().llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
            for (String string2 : feature.IlllllIlIIIlIIlIIllIIlIll()) {
                if (!string2.startsWith(string.toLowerCase())) continue;
                return true;
            }
        }
        return false;
    }

    public AbstractFeatureUIComponent llIIIIIIIllIIllIlIllIIIIl() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public IIlIllIlIIllIIlIlIllllllI lIIIllIllIIllIlllIlIIlllI() {
        return this.IllIIIlllIIIlIlllIlIIlIII;
    }

    public lllllIllIlIIlIIlIIIlllIlI IlllllIlIIIlIIlIIllIIlIll() {
        return this.IIlIllIlIIllIIlIlIllllllI;
    }
}
 