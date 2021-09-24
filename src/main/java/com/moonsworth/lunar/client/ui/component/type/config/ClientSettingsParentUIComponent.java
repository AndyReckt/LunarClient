package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.staff.AbstractStaffMod;
import com.moonsworth.lunar.client.profile.Profile;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.lIlIlIIIIIIllIlIIIIllIIII;
import com.moonsworth.lunar.client.ui.component.type.setting.SmallIconUIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.UIScreenCloseException;
import com.moonsworth.lunar.client.ui.screen.type.ProfileEditUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIWrapper;
import com.moonsworth.lunar.client.ui.screen.type.movement.MovementUI;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ClientSettingsParentUIComponent extends UIComponent implements UIScreenCloseException {
    public List<UIComponent> topBar = new ArrayList<>();
    public EditHudLayoutButtonUIComponent IlllIIIIIIlllIlIIlllIlIIl;
    public MainUITopBarButtonUIComponent lIllIlIIIlIIIIIIIlllIlIll;
    public ModuleListUIComponent llIlIIIllIIlIllIllIllllIl;
    public StaffModsListUIComponent IllIllIIIllIIIlIlIlIIIIll;
    public lIlIIIIIIlIIIllllIllIIlII IIlIllIlllllllIIlIIIllIIl;
    public WaypointsListUIComponent lIIlIlllIlIlIIIlllIIlIIII;
    public UIComponent asasasasasasas;
    public SmallIconUIComponent IllllllllllIlIIIlllIlllll;
    public Map<Profile, UIComponent> lllllIllIlIIlIIlIIIlllIlI = new LinkedHashMap<>();
    public ResourceLocationBridge IllIIIlllIIIlIlllIlIIlIII = Bridge.getInstance().initResourceLocation("lunar", "icons/pencil-64.png");
    public ResourceLocationBridge IIlIllIlIIllIIlIlIllllllI = Bridge.getInstance().initResourceLocation("lunar", "icons/exit-17x17.png");
    public final SettingsUIScreen lIIIlllIIIIllllIlIIIlIIll;

    public ClientSettingsParentUIComponent(SettingsUIScreen settingsUIScreen, UIComponent parent) {
        super(parent);
        this.lIIIlllIIIIllllIlIIIlIIll = settingsUIScreen;
        this.llIlIIIllIIlIllIllIllllIl = new ModuleListUIComponent(this);
        this.IIlIllIlllllllIIlIIIllIIl = new lIlIIIIIIlIIIllllIllIIlII(this);
        this.lIIlIlllIlIlIIIlllIIlIIII = new WaypointsListUIComponent(this);
        this.IllIllIIIllIIIlIlIlIIIIll = new StaffModsListUIComponent(this);
        this.asasasasasasas = this.llIlIIIllIIlIllIllIllllIl;
        MainUITopBarButtonUIComponent mods = new MainUITopBarButtonUIComponent(this, "mods");
        this.topBar.add(mods);
        mods.setSelected(true);
        MainUITopBarButtonUIComponent settings = new MainUITopBarButtonUIComponent(this, "settings");
        this.topBar.add(settings);
        MainUITopBarButtonUIComponent waypoints = new MainUITopBarButtonUIComponent(this, "waypoints");
        this.topBar.add(waypoints);
        MainUITopBarButtonUIComponent staffMods = null;
        for (AbstractStaffMod abstractStaffMod : Ref.getLC().IIlIllIlllllllIIlIIIllIIl().llIlllIIIllllIIlllIllIIIl()) {
            if (!abstractStaffMod.lIllllIllIIlIIlIIIlIIIlII()) continue;
            staffMods = new MainUITopBarButtonUIComponent(this, "staff");
            this.topBar.add(staffMods);
            break;
        }
        this.IllllllllllIlIIIlllIlllll = new SmallIconUIComponent(null, Bridge.getInstance().initResourceLocation("lunar", "icons/mainmenu/exit-17x17.png"));
        this.IllllllllllIlIIIlllIlllll.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(0x20FFFFFF, 1358901296));
        this.IlllIIIIIIlllIlIIlllIlIIl = new EditHudLayoutButtonUIComponent(this, "editHudLayout", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        this.lIllIlIIIlIIIIIIIlllIlIll = new MainUITopBarButtonUIComponent(this, "saveNewProfile", FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
        this.lIllIlIIIlIIIIIIIlllIlIll();
        this.onMouseClick((float f, float f2, int n) -> {
            for (UIComponent uIComponent : this.topBar) {
                if (!uIComponent.mouseInside(f, f2)) continue;
                return uIComponent.onMouseClicked(f, f2, n);
            }
            for (UIComponent uIComponent : this.lllllIllIlIIlIIlIIIlllIlI.values()) {
                if (!uIComponent.mouseInside(f, f2)) continue;
                uIComponent.onMouseClicked(f, f2, n);
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl.mouseInside(f, f2)) {
                return this.IlllIIIIIIlllIlIIlllIlIIl.onMouseClicked(f, f2, n);
            }
            if (this.lIllIlIIIlIIIIIIIlllIlIll.mouseInside(f, f2)) {
                return this.lIllIlIIIlIIIIIIIlllIlIll.onMouseClicked(f, f2, n);
            }
            return this.asasasasasasas.onMouseClicked(f, f2, n);
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> {
            for (UIComponent uIComponent : this.topBar) {
                if (!uIComponent.mouseInside(f, f2)) continue;
                return uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
            }
            for (UIComponent uIComponent : this.lllllIllIlIIlIIlIIIlllIlI.values()) {
                if (!uIComponent.mouseInside(f, f2)) continue;
                uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
            }
            if (!this.IlllIIIIIIlllIlIIlllIlIIl.mouseInside(f, f2)) {
                return this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
            }
            if (!this.lIllIlIIIlIIIIIIIlllIlIll.mouseInside(f, f2)) {
                return this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
            }
            return this.asasasasasasas != null && this.asasasasasasas.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
        });
        this.onMouseRelease((f, f2, n) -> {
            if (this.IllllllllllIlIIIlllIlllll.mouseInside(f, f2)) {
                Ref.getMinecraft().bridge$displayScreen(settingsUIScreen.IlllllIlIIIlIIlIIllIIlIll());
                return true;
            }
            for (UIComponent uIComponent : this.topBar) {
                if (!uIComponent.mouseInside(f, f2)) continue;
                return uIComponent.onMouseReleased(f, f2, n);
            }
            for (UIComponent uIComponent : this.lllllIllIlIIlIIlIIIlllIlI.values()) {
                if (!uIComponent.mouseInside(f, f2)) continue;
                uIComponent.onMouseReleased(f, f2, n);
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl.mouseInside(f, f2)) {
                return this.IlllIIIIIIlllIlIIlllIlIIl.onMouseReleased(f, f2, n);
            }
            if (this.lIllIlIIIlIIIIIIIlllIlIll.mouseInside(f, f2)) {
                return this.lIllIlIIIlIIIIIIIlllIlIll.onMouseReleased(f, f2, n);
            }
            if (this.asasasasasasas.mouseInside(f, f2)) {
                return this.asasasasasasas.onMouseReleased(f, f2, n);
            }
            return false;
        });
        mods.onMouseClick((float f, float f2, int n) -> {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl);
            this.IlllIIIIIIlllIlIIlllIlIIl(0);
            return true;
        });
        settings.onMouseClick((float f, float f2, int n) -> {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlllllllIIlIIIllIIl);
            this.IlllIIIIIIlllIlIIlllIlIIl(1);
            return true;
        });
        waypoints.onMouseClick((float f, float f2, int n) -> {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIlIlllIlIlIIIlllIIlIIII);
            this.IlllIIIIIIlllIlIIlllIlIIl(2);
            return true;
        });
        if (staffMods != null) {
            staffMods.onMouseClick((float f, float f2, int n) -> {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll);
                this.IlllIIIIIIlllIlIIlllIlIIl(3);
                return true;
            });
        }
        this.lIllIlIIIlIIIIIIIlllIlIll.onMouseClick((float f, float f2, int n) -> {
            if (Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl().size() >= 8) {
                return false;
            }
            Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().add(this.get("profile", ThreadLocalRandom.current().nextInt()));
            this.lIllIlIIIlIIIIIIIlllIlIll();
            settingsUIScreen.llIIIlllIIlllIllllIlIllIl();
            return true;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl.onMouseClick((float f, float f2, int n) -> {
            try {
                if (Ref.getMinecraft().bridge$getWorld() == null) {
                    Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuUIWrapper(new MovementUI())));
                } else {
                    Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MovementUI()));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return true;
        });
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.lllllIllIlIIlIIlIIIlllIlI.clear();
        List<Profile> list = Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl();
        Collections.reverse(list);
        for (Profile object : list) {
            this.lllllIllIlIIlIIlIIIlllIlI.put(object, new lIlIlIIIIIIllIlIIIIllIIII(this, ""));
        }
        float f = 43.0f;
        for (Map.Entry<Profile, UIComponent> entry : this.lllllIllIlIIlIIlIIIlllIlI.entrySet()) {
            float f4 = f;
            entry.getValue().onMouseClick((float f2, float f3, int n) -> {
                if (this.mouseInside(f2, f3) && f3 > this.y + f4 && f3 < this.y + f4 + 14.0f && f2 >= this.x + 95.0f && f2 <= this.x + 104.0f) {
                    if (Ref.getMinecraft().bridge$getWorld() == null) {
                        Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuUIWrapper(new ProfileEditUIScreen(Ref.getMinecraft().bridge$getCurrentScreen(), entry.getKey()))));
                    } else {
                        Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new ProfileEditUIScreen(Ref.getMinecraft().bridge$getCurrentScreen(), entry.getKey())));
                    }
                    return true;
                }
                if (Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().getSelectedProfile().equals(entry.getKey())) {
                    return false;
                }
                Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl(entry.getKey());
                this.lIIIlllIIIIllllIlIIIlIIll.llIIIlllIIlllIllllIlIllIl();
                return true;
            });
            f += 16.0f;
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        if (this.asasasasasasas instanceof ModuleListUIComponent && !(uIComponent instanceof ModuleListUIComponent)) {
            Ref.getLC().lllllIllIllIllllIlIllllII().save();
        }
        this.asasasasasasas = uIComponent;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        for (int i = 0; i < this.topBar.size(); ++i) {
            ((MainUITopBarButtonUIComponent)this.topBar.get(i)).setSelected(i == n);
        }
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        float f5 = 0.0f;
        float f6 = 0.0f;
        this.IllllllllllIlIIIlllIlllll.setPositionAndSize(x + this.getWidth() - 24.0f, y + 8.0f, 16.0f, 16.0f);
        for (UIComponent object : this.topBar) {
            f6 += object.getWidth() + (this.topBar.indexOf(object) == this.topBar.size() - 1 ? 0.0f : 8.0f);
        }
        for (UIComponent object : this.topBar) {
            ((MainUITopBarButtonUIComponent)object).setPosition(x + this.getWidth() / 2.0f - f6 / 2.0f + f5, y + 8.0f);
            f5 += object.getWidth() + (this.topBar.indexOf(object) == this.topBar.size() - 1 ? 0.0f : 8.0f);
        }
        float f7 = 43.0f;
        for (Map.Entry<Profile, UIComponent> entry : this.lllllIllIlIIlIIlIIIlllIlI.entrySet()) {
            if (!LunarClient.getInstance().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl().contains(entry.getKey())) continue;
            entry.getValue().setPositionAndSize(x, y + (f7 - 1.0f), 105.0f, 16.0f);
            f7 += 16.0f;
        }
        this.IlllIIIIIIlllIlIIlllIlIIl.setPositionAndSize(x + 8.0f, y + height - 15.5f, 88.0f, 11.0f);
        this.lIllIlIIIlIIIIIIIlllIlIll.setPositionAndSize(x + 5.0f, y + height - 46.0f, 94.0f, 12.0f);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(1.0f);
    }

    @Override
    public void onUpdateScreen() {
        this.asasasasasasas.onUpdateScreen();
    }

    @Override
    public boolean onMouseClicked(float mouseX, float mouseY, int mouseButton) {
        return this.onMouseClick != null && this.onMouseClick.accept(mouseX, mouseY, mouseButton);
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 1.0f, this.y, this.width + 2.0f, this.height, 4.0f, 1612586526);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 3.25f, 1075715614);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 5.0f, -1306912744);
        AbstractUIScreen.lIIIllIllIIllIlllIlIIlllI(this.x, this.y + 1.0f, this.width, 32.0f, 5.0f, 0x36000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 32.5f, this.width, 0.5f, 0x20FFFFFF);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + this.height - 20.0f, 105.0f, 19.0f, 7.0f, 0x20000000, false, true, true, false);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + 42.0f, 105.0f, this.height - 70.0f, 8.0f, 0x20000000, false, true, false, true);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + this.height - 52.0f, 105.0f, 24.0f, 8.0f, 0x40000000, false, false, false, true);
        this.IllllllllllIlIIIlllIlllll.drawComponent(mouseX, mouseY, bl && this.IllllllllllIlIIIlllIlllll.mouseInside(mouseX, mouseY));
        float f3 = 43.0f;
        int n = 0;
        for (Profile object : this.lllllIllIlIIlIIlIIIlllIlI.keySet()) {
            boolean bl2;
            boolean bl3 = bl2 = n == 0;
            if (object.isActive()) {
                AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + f3 - 1.0f, 105.0f, 16.0f, 8.0f, 0x20FFFFFF, false, bl2, false, false);
            }
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y + f3, 104.0f, 14.0f, 5.0f, 0x20FFFFFF, false, bl2, false, false);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.2f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIIIlllIIIlIlllIlIIlIII, 3.5f, this.x + 95.0f, this.y + (f3 + 3.5f));
            if (this.mouseInside(mouseX, mouseY) && mouseY > this.y + f3 && mouseY < this.y + f3 + 14.0f && mouseX >= this.x + 95.0f && mouseX <= this.x + 104.0f) {
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIIIlllIIIlIlllIlIIlIII, 3.5f, this.x + 95.0f, this.y + (f3 + 3.5f));
            }
            float f4 = 8.0f;
            if (object.getIcon() != null) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.65f);
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(object.getIcon(), this.x + 2.0f, this.y + (f3 + 3.5f), 8.0f, 8.0f);
                f4 += 6.0f;
            }
            StringBuilder stringBuilder = new StringBuilder();
            char[] cArray = object.getDisplayName().toCharArray();
            for (Character c : cArray) {
                stringBuilder.append(c).append(" ");
            }
            FontRegistry.lIlIIIIIIlIIIllllIllIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(stringBuilder.toString(), this.x + f4, this.y + (f3 + 3.5f), -1342177281);
            f3 += 16.0f;
            ++n;
        }
        this.asasasasasasas.setPositionAndSize(this.x + 110.0f, this.y + 42.5f, this.width - 115.0f, this.height - 48.0f);
        for (UIComponent object : this.topBar) {
            object.drawComponent(mouseX, mouseY, bl);
        }
        this.IlllIIIIIIlllIlIIlllIlIIl.drawComponent(mouseX, mouseY, bl);
        this.lIllIlIIIlIIIIIIIlllIlIll.drawComponent(mouseX, mouseY, bl && Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl().size() < 7);
        this.asasasasasasas.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        this.asasasasasasas.onKeyTyped(c, keyType);
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
        this.asasasasasasas.handleMouseScrollDelta(n);
    }

    @Override
    public void onGuiClosed() {
        this.asasasasasasas.onGuiClosed();
    }

    @Override
    public boolean shouldCancel() {
        return this.asasasasasasas instanceof UIScreenCloseException && ((UIScreenCloseException) this.asasasasasasas).shouldCancel();
    }

    public List llllIIlIIlIIlIIllIIlIIllI() {
        return this.topBar;
    }

    public ModuleListUIComponent llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public StaffModsListUIComponent lIIIllIllIIllIlllIlIIlllI() {
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

    public Map<Profile, UIComponent> llIllIlIllIlllIllIIIIllII() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }
}
