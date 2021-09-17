package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.profile.Profile;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.config.*;
import com.moonsworth.lunar.client.ui.component.type.setting.llIllIlIllIlllIllIIIIllII;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.BooleanCallbackSetting;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.movement.MovementUI;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ClientSettingsParentUIComponent
extends UIComponent
implements BooleanCallbackSetting {
    public List<UIComponent> lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList<>();
    public EditHudLayoutButtonUIComponent IlllIIIIIIlllIlIIlllIlIIl;
    public MainUITopBarButtonUIComponent lIllIlIIIlIIIIIIIlllIlIll;
    public ModuleListUIComponent llIlIIIllIIlIllIllIllllIl;
    public SearchBoxUIComponent IllIllIIIllIIIlIlIlIIIIll;
    public lIlIIIIIIlIIIllllIllIIlII IIlIllIlllllllIIlIIIllIIl;
    public WaypointsListUIComponent lIIlIlllIlIlIIIlllIIlIIII;
    public UIComponent asasasasasasas;
    public llIllIlIllIlllIllIIIIllII IllllllllllIlIIIlllIlllll;
    public Map<Profile, UIComponent> lllllIllIlIIlIIlIIIlllIlI = new LinkedHashMap();
    public ResourceLocationBridge IllIIIlllIIIlIlllIlIIlIII = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/pencil-64.png");
    public ResourceLocationBridge IIlIllIlIIllIIlIlIllllllI = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/exit-17x17.png");
    public final SettingsUIScreen lIIIlllIIIIllllIlIIIlIIll;

    public ClientSettingsParentUIComponent(SettingsUIScreen settingsUIScreen, UIComponent parent) {
        super(parent);
        this.lIIIlllIIIIllllIlIIIlIIll = settingsUIScreen;
        this.llIlIIIllIIlIllIllIllllIl = new ModuleListUIComponent(this);
        this.IIlIllIlllllllIIlIIIllIIl = new lIlIIIIIIlIIIllllIllIIlII(this);
        this.lIIlIlllIlIlIIIlllIIlIIII = new WaypointsListUIComponent(this);
        this.IllIllIIIllIIIlIlIlIIIIll = new SearchBoxUIComponent(this);
        this.asasasasasasas = this.llIlIIIllIIlIllIllIllllIl;
        MainUITopBarButtonUIComponent mainUITopBarButtonUIComponent = new MainUITopBarButtonUIComponent(this, "mods");
        this.lIlIlIlIlIIlIIlIIllIIIIIl.add(mainUITopBarButtonUIComponent);
        mainUITopBarButtonUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        MainUITopBarButtonUIComponent mainUITopBarButtonUIComponent2 = new MainUITopBarButtonUIComponent(this, "settings");
        this.lIlIlIlIlIIlIIlIIllIIIIIl.add(mainUITopBarButtonUIComponent2);
        MainUITopBarButtonUIComponent mainUITopBarButtonUIComponent3 = new MainUITopBarButtonUIComponent(this, "waypoints");
        this.lIlIlIlIlIIlIIlIIllIIIIIl.add(mainUITopBarButtonUIComponent3);
        MainUITopBarButtonUIComponent mainUITopBarButtonUIComponent4 = null;
        for (AbstractStaffModManager abstractStaffModManager : Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlllllllIIlIIIllIIl().llIlllIIIllllIIlllIllIIIl()) {
            if (!abstractStaffModManager.lIllllIllIIlIIlIIIlIIIlII()) continue;
            mainUITopBarButtonUIComponent4 = new MainUITopBarButtonUIComponent(this, "staff");
            this.lIlIlIlIlIIlIIlIIllIIIIIl.add(mainUITopBarButtonUIComponent4);
            break;
        }
        this.IllllllllllIlIIIlllIlllll = new llIllIlIllIlllIllIIIIllII(null, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/exit-17x17.png"));
        this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(0x20FFFFFF, 1358901296));
        this.IlllIIIIIIlllIlIIlllIlIIl = new EditHudLayoutButtonUIComponent(this, "editHudLayout", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        this.lIllIlIIIlIIIIIIIlllIlIll = new MainUITopBarButtonUIComponent(this, "saveNewProfile", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        this.lIllIlIIIlIIIIIIIlllIlIll();
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            for (UIComponent uIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
                return uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            for (UIComponent uIComponent : this.lllllIllIlIIlIIlIIIlllIlI.values()) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
                uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            if (this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            return this.asasasasasasas.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> {
            for (UIComponent uIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
                return uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
            }
            for (UIComponent uIComponent : this.lllllIllIlIIlIIlIIIlllIlI.values()) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
                uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
            }
            if (!this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
            }
            if (!this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
            }
            return this.asasasasasasas != null && this.asasasasasasas.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
        });
        this.lIllIlIIIlIIIIIIIlllIlIll((f, f2, n) -> {
            if (this.IllllllllllIlIIIlllIlllll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(settingsUIScreen.IlllllIlIIIlIIlIIllIIlIll());
                return true;
            }
            for (UIComponent uIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
                return uIComponent.lIllIlIIIlIIIIIIIlllIlIll(f, f2, n);
            }
            for (UIComponent uIComponent : this.lllllIllIlIIlIIlIIIlllIlI.values()) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
                uIComponent.lIllIlIIIlIIIIIIIlllIlIll(f, f2, n);
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll(f, f2, n);
            }
            if (this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll(f, f2, n);
            }
            if (this.asasasasasasas.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.asasasasasasas.lIllIlIIIlIIIIIIIlllIlIll(f, f2, n);
            }
            return false;
        });
        mainUITopBarButtonUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl);
            this.IlllIIIIIIlllIlIIlllIlIIl(0);
            return true;
        });
        mainUITopBarButtonUIComponent2.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlllllllIIlIIIllIIl);
            this.IlllIIIIIIlllIlIIlllIlIIl(1);
            return true;
        });
        mainUITopBarButtonUIComponent3.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIlIlllIlIlIIIlllIIlIIII);
            this.IlllIIIIIIlllIlIIlllIlIIl(2);
            return true;
        });
        if (mainUITopBarButtonUIComponent4 != null) {
            mainUITopBarButtonUIComponent4.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll);
                this.IlllIIIIIIlllIlIIlllIlIIl(3);
                return true;
            });
        }
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl().size() >= 8) {
                return false;
            }
            Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl(this.get("profile", ThreadLocalRandom.current().nextInt()));
            this.lIllIlIIIlIIIIIIIlllIlIll();
            settingsUIScreen.llIIIlllIIlllIllllIlIllIl();
            return true;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            try {
                if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getWorld() == null) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIWrapper(new MovementUI())));
                } else {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MovementUI()));
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return true;
        });
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.lllllIllIlIIlIIlIIIlllIlI.clear();
        List list = Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl();
        Collections.reverse(list);
        for (Object object : list) {
            this.lllllIllIlIIlIIlIIIlllIlI.put(object, new lIlIlIIIIIIllIlIIIIllIIII(this, ""));
        }
        float f = 43.0f;
        for (Map.Entry entry : this.lllllIllIlIIlIIlIIIlllIlI.entrySet()) {
            float f4 = f;
            ((lIlIlIIIIIIllIlIIIIllIIII)entry.getValue()).lIlIlIlIlIIlIIlIIllIIIIIl((float f2, float f3, int n) -> {
                if (this.IlllIIIIIIlllIlIIlllIlIIl(f2, f3) && f3 > this.y + f4 && f3 < this.y + f4 + 14.0f && f2 >= this.x + 95.0f && f2 <= this.x + 104.0f) {
                    if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getWorld() == null) {
                        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIWrapper(new ProfileEditUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen(), (Profile)entry.getKey()))));
                    } else {
                        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new ProfileEditUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen(), (Profile)entry.getKey())));
                    }
                    return true;
                }
                if (Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIIIIIIllIlIIIIllIIII().llllIIlIIlIIlIIllIIlIIllI().equals(entry.getKey())) {
                    return false;
                }
                Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl((Profile)entry.getKey());
                this.lIIIlllIIIIllllIlIIIlIIll.llIIIlllIIlllIllllIlIllIl();
                return true;
            });
            f += 16.0f;
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        if (this.asasasasasasas instanceof ModuleListUIComponent && !(uIComponent instanceof ModuleListUIComponent)) {
            Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().save();
        }
        this.asasasasasasas = uIComponent;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        for (int i = 0; i < this.lIlIlIlIlIIlIIlIIllIIIIIl.size(); ++i) {
            ((MainUITopBarButtonUIComponent)this.lIlIlIlIlIIlIIlIIllIIIIIl.get(i)).lIlIlIlIlIIlIIlIIllIIIIIl(i == n);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        float f5 = 0.0f;
        float f6 = 0.0f;
        this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(f + this.llIlIIIllIIlIllIllIllllIl() - 24.0f, f2 + 8.0f, 16.0f, 16.0f);
        for (Object object : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            f6 += ((UIComponent)object).llIlIIIllIIlIllIllIllllIl() + (this.lIlIlIlIlIIlIIlIIllIIIIIl.indexOf(object) == this.lIlIlIlIlIIlIIlIIllIIIIIl.size() - 1 ? 0.0f : 8.0f);
        }
        for (Object object : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            ((MainUITopBarButtonUIComponent)object).lIlIlIlIlIIlIIlIIllIIIIIl(f + this.llIlIIIllIIlIllIllIllllIl() / 2.0f - f6 / 2.0f + f5, f2 + 8.0f);
            f5 += ((UIComponent)object).llIlIIIllIIlIllIllIllllIl() + (this.lIlIlIlIlIIlIIlIIllIIIIIl.indexOf(object) == this.lIlIlIlIlIIlIIlIIllIIIIIl.size() - 1 ? 0.0f : 8.0f);
        }
        float f7 = 43.0f;
        for (Map.Entry entry : this.lllllIllIlIIlIIlIIIlllIlI.entrySet()) {
            if (!LunarClient.IIllIlIllIlIllIllIllIllII().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl().contains(entry.getKey())) continue;
            ((lIlIlIIIIIIllIlIIIIllIIII)entry.getValue()).lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + (f7 - 1.0f), 105.0f, 16.0f);
            f7 += 16.0f;
        }
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + 8.0f, f2 + f4 - 15.5f, 88.0f, 11.0f);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f + 5.0f, f2 + f4 - 46.0f, 94.0f, 12.0f);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(1.0f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.asasasasasasas.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        return this.IlllllIlIIIlIIlIIllIIlIll != null && this.IlllllIlIIIlIIlIIllIIlIll.accept(f, f2, n);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 1.0f, this.y, this.width + 2.0f, this.height, 4.0f, 1612586526);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 3.25f, 1075715614);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 5.0f, -1306912744);
        AbstractUIScreen.lIIIllIllIIllIlllIlIIlllI(this.x, this.y + 1.0f, this.width, 32.0f, 5.0f, 0x36000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 32.5f, this.width, 0.5f, 0x20FFFFFF);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + this.height - 20.0f, 105.0f, 19.0f, 7.0f, 0x20000000, false, true, true, false);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + 42.0f, 105.0f, this.height - 70.0f, 8.0f, 0x20000000, false, true, false, true);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + this.height - 52.0f, 105.0f, 24.0f, 8.0f, 0x40000000, false, false, false, true);
        this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl && this.IllllllllllIlIIIlllIlllll.IlllIIIIIIlllIlIIlllIlIIl(f, f2));
        float f3 = 43.0f;
        int n = 0;
        for (Object object : this.lllllIllIlIIlIIlIIIlllIlI.keySet()) {
            boolean bl2;
            boolean bl3 = bl2 = n == 0;
            if (((Profile)object).llllIIlIIlIIlIIllIIlIIllI()) {
                AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + f3 - 1.0f, 105.0f, 16.0f, 8.0f, 0x20FFFFFF, false, bl2, false, false);
            }
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y + f3, 104.0f, 14.0f, 5.0f, 0x20FFFFFF, false, bl2, false, false);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.2f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIIIlllIIIlIlllIlIIlIII, 3.5f, this.x + 95.0f, this.y + (f3 + 3.5f));
            if (this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && f2 > this.y + f3 && f2 < this.y + f3 + 14.0f && f >= this.x + 95.0f && f <= this.x + 104.0f) {
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIIIlllIIIlIlllIlIIlIII, 3.5f, this.x + 95.0f, this.y + (f3 + 3.5f));
            }
            float f4 = 8.0f;
            if (((Profile)object).lIlIlIlIlIIlIIlIIllIIIIIl() != null) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.65f);
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(((Profile)object).lIlIlIlIlIIlIIlIIllIIIIIl(), this.x + 2.0f, this.y + (f3 + 3.5f), 8.0f, 8.0f);
                f4 += 6.0f;
            }
            StringBuilder stringBuilder = new StringBuilder();
            char[] cArray = ((Profile)object).lIllIlIIIlIIIIIIIlllIlIll().toCharArray();
            int n2 = cArray.length;
            for (int i = 0; i < n2; ++i) {
                Character c = Character.valueOf(cArray[i]);
                stringBuilder.append(c).append(" ");
            }
            FontRegistry.lIlIIIIIIlIIIllllIllIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(stringBuilder.toString(), this.x + f4, this.y + (f3 + 3.5f), -1342177281);
            f3 += 16.0f;
            ++n;
        }
        this.asasasasasasas.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 110.0f, this.y + 42.5f, this.width - 115.0f, this.height - 48.0f);
        for (Object object : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            ((UIComponent)object).lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        }
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl && Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl().size() < 7);
        this.asasasasasasas.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        this.asasasasasasas.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        this.asasasasasasas.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        this.asasasasasasas.IlllIIIIIIlllIlIIlllIlIIl();
    }

    @Override
    public boolean c_() {
        return this.asasasasasasas instanceof BooleanCallbackSetting && ((BooleanCallbackSetting)((Object)this.asasasasasasas)).c_();
    }

    public List llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public ModuleListUIComponent llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public SearchBoxUIComponent lIIIllIllIIllIlllIlIIlllI() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public lIlIIIIIIlIIIllllIllIIlII IlllllIlIIIlIIlIIllIIlIll() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public WaypointsListUIComponent llIIlIlIIIllIlIlIlIIlIIll() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public UIComponent lIIlIlllIlIlIIIlllIIlIIII() {
        return this.asasasasasasas;
    }

    public Map llIllIlIllIlllIllIIIIllII() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }
}
 