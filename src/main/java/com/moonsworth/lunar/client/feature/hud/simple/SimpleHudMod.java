package com.moonsworth.lunar.client.feature.hud.simple;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.hud.Anchor;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;

import java.util.ArrayList;
import java.util.List;

public abstract class SimpleHudMod
extends DraggableHudMod {
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;
    public NumberSetting lIlIIIIIIlIIIllllIllIIlII;
    public NumberSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;
    public BooleanSetting IIlIllIlllllllIIlIIIllIIl;
    public ColorSetting lIIlIlllIlIlIIIlllIIlIIII;
    public ColorSetting llIllIlIllIlllIllIIIIllII;
    public ColorSetting IllllllllllIlIIIlllIlllll;
    public NumberSetting lllllIllIlIIlIIlIIIlllIlI;

    public SimpleHudMod(boolean bl, Anchor anchor) {
        super(bl, anchor);
        this.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl().intValue(), this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl().intValue());
        if (this.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl() != null) {
            ArrayList<ModuleCategory> arrayList = new ArrayList<>();
            arrayList.addAll(this.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl());
            if (!arrayList.contains(ModuleCategory.lIllIlIIIlIIIIIIIlllIlIll)) {
                arrayList.add(ModuleCategory.lIllIlIIIlIIIIIIIlllIlIll);
            }
            this.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(ImmutableList.copyOf(arrayList));
        } else {
            this.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(ImmutableList.of(ModuleCategory.lIlIlIlIlIIlIIlIIllIIIIIl, ModuleCategory.lIllIlIIIlIIIIIIIlllIlIll));
        }
    }

    public List IlIllIIlIIlIIIllIllllIIll() {
        return new ArrayList();
    }

    public List IIIIIIIIIIIIIIIllllIIlIIl() {
        return new ArrayList();
    }

    public boolean llIIIIllIlIIlIlIIlllIllIl() {
        return true;
    }

    public boolean IIIIlIllIllIlIIIIIlIlIlIl() {
        return false;
    }

    public abstract String IlIlIlIlIIIlIIlIIlllIllIl();

    public abstract SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI();

    public abstract String lllllIlIllIlIlllIIIlIIlIl();

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent renderGameOverlayEvent, float f, float f2) {
        String string = this.lllllIlIllIlIlllIIIlIIlIl();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(string, f, f2);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, float f2) {
        if (string == null || string.isEmpty()) {
            return;
        }
        if (this.IIIIlIllIllIlIIIIIlIlIlIl()) {
            this.IlllIIIIIIlllIlIIlllIlIIl(Ref.IlllllIlIIIlIIlIIllIIlIll().bridge$getStringWidth(string) + 8.0f, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl().intValue());
        } else {
            this.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl().intValue(), this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl().intValue());
        }
        float f3 = this.llIIIIIIIllIIllIlIllIIIIl / 2.0f;
        float f4 = this.lIIIllIllIIllIlllIlIIlllI / 1.88f - (float) Ref.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl() / 2.0f + 0.5f;
        if (this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl().booleanValue()) {
            this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, this.llIIIIIIIllIIllIlIllIIIIl, this.lIIIllIllIIllIlllIlIIlllI);
            if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl().booleanValue()) {
                float f5 = this.lllllIllIlIIlIIlIIIlllIlI.llIlllIIIllllIIlllIllIIIl().floatValue();
                this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - f5, this.llIIIIIIIllIIllIlIllIIIIl, f5);
                this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + this.lIIIllIllIIllIlllIlIIlllI, this.llIIIIIIIllIIllIlIllIIIIl, f5);
                this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(f - f5, f2 - f5, f5, this.lIIIllIllIIllIlllIlIIlllI + f5 * 2.0f);
                this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(f + this.llIIIIIIIllIIllIlIllIIIIl, f2 - f5, f5, this.lIIIllIllIIllIlllIlIIlllI + f5 * 2.0f);
            }
        } else if (this.llIIIIllIlIIlIlIIlllIllIl()) {
            string = "[" + string + "]";
        }
        if (this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl().booleanValue()) {
            this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(string, f + f3, f2 + f4);
        } else {
            this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll(string, f + f3, f2 + f4);
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent renderGameOverlayEvent, float f, float f2) {
        String string = this.lllllIlIllIlIlllIIIlIIlIl();
        if (string == null || string.isEmpty()) {
            string = this.IllIlIIllIIlllIIllIlIlIII();
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(string, f, f2);
    }

    public String IllIlIIllIIlllIIllIlIlIII() {
        return "";
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        ArrayList<AbstractSetting> arrayList = new ArrayList<>();
        List list = this.IIIIIIIIIIIIIIIllllIIlIIl();
        if (!list.isEmpty()) {
            arrayList.add(new SettingLabel("settings"));
            arrayList.addAll(list);
        }
        this.IIlIllIlllllllIIlIIIllIIl = new BooleanSetting("shadow", true);
        this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting("background", true);
        this.llIlIIIllIIlIllIllIllllIl = new NumberSetting("backgroundHeight", this.lIIIlIllllIIlIIlIIlIIIIlI().IlllIIIIIIlllIlIIlllIlIIl(), this.lIIIlIllllIIlIIlIIlIIIIlI().lIlIlIlIlIIlIIlIIllIIIIIl(), this.lIIIlIllllIIlIIlIIlIIIIlI().lIllIlIIIlIIIIIIIlllIlIll());
        this.lIlIIIIIIlIIIllllIllIIlII = new NumberSetting("backgroundWidth", this.lIIIlIllllIIlIIlIIlIIIIlI().llllIIlIIlIIlIIllIIlIIllI(), this.lIIIlIllllIIlIIlIIlIIIIlI().llIlllIIIllllIIlllIllIIIl(), this.lIIIlIllllIIlIIlIIlIIIIlI().IlIlIlllllIlIIlIlIlllIlIl(), 0, this::IIIIlIllIllIlIIIIIlIlIlIl);
        this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("border", false);
        this.lllllIllIlIIlIIlIIIlllIlI = new NumberSetting("border_thickness", Float.valueOf(0.5f), Float.valueOf(0.5f), Float.valueOf(3.0f));
        this.lIIlIlllIlIlIIIlllIIlIIII = new ColorSetting("text", -1);
        this.llIllIlIllIlllIllIIIIllII = new ColorSetting("background", 0x6F000000);
        this.IllllllllllIlIIIlllIlllll = new ColorSetting("border", -1627389952);
        arrayList.addAll(ImmutableList.of(new SettingLabel("generalOptions"), this.IIlIllIlllllllIIlIIIllIIl, this.lllIIIIIlllIIlIllIIlIIIlI, this.llIlIIIllIIlIllIllIllllIl, this.lIlIIIIIIlIIIllllIllIIlII, this.IllIllIIIllIIIlIlIlIIIIll, this.lllllIllIlIIlIIlIIIlllIlI, new SettingLabel("colorOptions"), this.lIIlIlllIlIlIIIlllIIlIIII, this.llIllIlIllIlllIllIIIIllII, this.IllllllllllIlIIIlllIlllll));
        return arrayList;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlIlIlIlIIIlIIlIIlllIllIl(), f, f2, f3, f4);
    }
}