package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.CustomScreen;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.overlay.ClientSettingsParentUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IIlIllIlIIllIIlIlIllllllI;
import com.moonsworth.lunar.client.ui.component.type.setting.lllllIllIlIIlIIlIIIlllIlI;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.LanguageParser;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SearchBoxUIComponent
extends AbstractListUIComponent {
    public List<NewLabelHolderUIComponent> lIlIlIlIlIIlIIlIIllIIIIIl;
    public IIlIllIlIIllIIlIlIllllllI IlllIIIIIIlllIlIIlllIlIIl = new IIlIllIlIIllIIlIlIllllllI(this);
    public lllllIllIlIIlIIlIIIlllIlI lIllIlIIIlIIIIIIIlllIlIll;

    public SearchBoxUIComponent(UIComponent parent) {
        super(parent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            for (NewLabelHolderUIComponent newLabelHolderUIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!(f2 > this.y + 20.0f) || !newLabelHolderUIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll())) continue;
                return newLabelHolderUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll(), n);
            }
            return this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n) || this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n));
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList();
        for (AbstractStaffModManager abstractStaffModManager : this.lIlIIIIIIlIIIllllIllIIlII.IIlIllIlllllllIIlIIIllIIl().llIlllIIIllllIIlllIllIIIl()) {
            if (!abstractStaffModManager.lIllllIllIIlIIlIIIlIIIlII()) continue;
            this.lIlIlIlIlIIlIIlIIllIIIIIl.add(new NewLabelHolderUIComponent(this, (ClientSettingsParentUIComponent)parent, abstractStaffModManager));
        }
    }

    @Override
    public void IlIlIlllllIlIIlIlIlllIlIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        int n = 0;
        int n2 = 0;
        float f5 = 112.0f;
        float f6 = 115.0f;
        HashMap<String, NewLabelHolderUIComponent> hashMap = new HashMap<String, NewLabelHolderUIComponent>();
        if (!this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().isEmpty()) {
            for (NewLabelHolderUIComponent newLabelHolderUIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                String[] stringArray;
                String string = newLabelHolderUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIIlIlIIIllIlIlIlIIlIIll().get("name", new Object[0]);
                if (hashMap.containsKey(string)) continue;
                string = EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(string);
                String string2 = this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI();
                string2 = LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(string2);
                for (String string3 : stringArray = string.split(" ")) {
                    if (!(string3 = LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(string3)).toLowerCase().startsWith(string2.toLowerCase())) continue;
                    hashMap.put(newLabelHolderUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIIlIlIIIllIlIlIlIIlIIll().get("name", new Object[0]), newLabelHolderUIComponent);
                }
            }
        }
        for (NewLabelHolderUIComponent newLabelHolderUIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            if (!this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().isEmpty() && !hashMap.containsKey(newLabelHolderUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIIlIlIIIllIlIlIlIIlIIll().get("name", new Object[0]))) {
                newLabelHolderUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f - f6 - 10.0f, f2, f6, f5);
                continue;
            }
            if (n == 3) {
                n = 0;
                ++n2;
            }
            newLabelHolderUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f + (f6 + 8.0f) * (float)n, f2 + 22.0f + (f5 + 8.0f) * (float)n2, f6, f5);
            ++n;
        }
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 6.0f, f2 + 20.0f, 4.0f, f4 - 20.0f);
        this.IlllIIIIIIlllIlIIlllIlIIl.IlIlIlllllIlIIlIlIlllIlIl(n2 == 0 ? f5 + 4.0f : 4.0f + f5 + (f5 + 8.0f) * (float)n2);
        float f7 = 100.0f;
        float f8 = 16.0f;
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - f7 - 15.0f, f2 + 1.0f, f7, f8);
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        UIComponent[] uIComponentArray = new UIComponent[1];
        this.lIllIlIIIlIIIIIIIlllIlIll = new lllllIllIlIIlIIlIIIlllIlI(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/magnifying-glass-12x12.png"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI, "searchPlaceholder", 0x20FFFFFF, 0x35FFFFFF);
        uIComponentArray[0] = this.lIllIlIIIlIIIIIIIlllIlIll;
        return Arrays.asList(uIComponentArray);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        Object object;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable((int)3089);
        float f3 = 0.0f;
        if (this.lllIIIIIlllIIlIllIIlIIIlI.bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && (object = (WrappedGuiScreenBridge)this.lllIIIIIlllIIlIllIIlIIIlI.bridge$getCurrentScreen()).getCustomScreen() instanceof AbstractUIScreen) {
            CustomScreen i18nBridge = ((WrappedGuiScreenBridge)object).getCustomScreen();
            f3 = ((AbstractUIScreen)i18nBridge).lllllIllIlIIlIIlIIIlllIlI();
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x - 2.0f), (int)(this.y + 20.0f), (int)(this.x + this.width + 2.0f), (int)(this.y + this.height + 5.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)f3);
        this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2, bl);
        for (I18nBridge i18nBridge : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            boolean bl2;
            boolean bl3 = ((UIComponent)i18nBridge).lIlIIIIIIlIIIllllIllIIlII() + ((UIComponent)i18nBridge).IllIllIIIllIIIlIlIlIIIIll() + this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll() < this.IlllIIIIIIlllIlIIlllIlIIl.lIlIIIIIIlIIIllllIllIIlII();
            boolean bl4 = bl2 = ((UIComponent)i18nBridge).lIlIIIIIIlIIIllllIllIIlII() + this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll() > this.IlllIIIIIIlllIlIIlllIlIIl.lIlIIIIIIlIIIllllIllIIlII() + this.IlllIIIIIIlllIlIIlllIlIIl.IllIllIIIllIIIlIlIlIIIIll();
            if (!(((UIComponent)i18nBridge).lllIIIIIlllIIlIllIIlIIIlI() >= this.x) || bl3 || bl2) continue;
            ((NewLabelHolderUIComponent)i18nBridge).lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll(), bl && !this.IlllIIIIIIlllIlIIlllIlIIl.lIIIllIllIIllIlllIlIIlllI());
        }
        this.IlllIIIIIIlllIlIIlllIlIIl.llllIIlIIlIIlIIllIIlIIllI(f, f2, bl);
        GL11.glDisable((int)3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        if (keyType == KeyType.lIIIlIllllIIlIIlIIlIIIIlI && this.lIllIlIIIlIIIIIIIlllIlIll.llIllIlIllIlllIllIIIIllII()) {
            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl("");
            return;
        }
        super.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        if (!this.lIllIlIIIlIIIIIIIlllIlIll.llIllIlIllIlllIllIIIIllII()) {
            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        super.IlllIIIIIIlllIlIIlllIlIIl();
    }

    public IIlIllIlIIllIIlIlIllllllI llllIIlIIlIIlIIllIIlIIllI() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public lllllIllIlIIlIIlIIIlllIlI llIIIIIIIllIIllIlIllIIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
 