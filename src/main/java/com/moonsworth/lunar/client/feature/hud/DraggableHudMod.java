package com.moonsworth.lunar.client.feature.hud;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.event.type.render.RenderScaledGameOverlayEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.NumberSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.movement.MovementUI;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class DraggableHudMod extends ConfigurableFeature {
    public static final float lllIIIIIlllIIlIllIIlIIIlI = 18.0f;
    public float llllIIlIIlIIlIIllIIlIIllI;
    public float IlIlIlllllIlIIlIlIlllIlIl;
    public float llIIIIIIIllIIllIlIllIIIIl;
    public float lIIIllIllIIllIlllIlIIlllI;
    public Anchor lIlIIIIIIlIIIllllIllIIlII;
    public final Anchor llIlIIIllIIlIllIllIllllIl;
    public boolean IllIllIIIllIIIlIlIlIIIIll = false;
    public boolean IIlIllIlllllllIIlIIIllIIl;
    public Consumer IlllllIlIIIlIIlIIllIIlIll = draggableHudMod -> {};
    public NumberSetting llIIlIlIIIllIlIlIlIIlIIll;
    public double lIIlIlllIlIlIIIlllIIlIIII;
    public double llIllIlIllIlllIllIIIIllII;
    public static final float llIIIlllIIlllIllllIlIllIl = 2.0f;

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderScaledGameOverlayEvent renderScaledGameOverlayEvent, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(renderScaledGameOverlayEvent.lIlIlIlIlIIlIIlIIllIIIIIl(), renderScaledGameOverlayEvent.IlllIIIIIIlllIlIIlllIlIIl());
        if (!bl) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(renderScaledGameOverlayEvent, (float)this.IIlllIllIlIllIllIIllIlIIl() / this.lIIlIIIIIIlIIlIIllIlIIlII(), (float)this.lIlIIlIlllIIlIIIlIlIlIllI() / this.lIIlIIIIIIlIIlIIllIlIIlII());
        } else {
            this.IlllIIIIIIlllIlIIlllIlIIl(renderScaledGameOverlayEvent, (float)this.IIlllIllIlIllIllIIllIlIIl() / this.lIIlIIIIIIlIIlIIllIlIIlII(), (float)this.lIlIIlIlllIIlIIIlIlIlIllI() / this.lIIlIIIIIIlIIlIIllIlIIlII());
        }
        this.lIIlllIIIIIlllIIIlIlIlllI();
    }

    public DraggableHudMod(boolean bl, Anchor anchor) {
        super(bl);
        this.lIlIIIIIIlIIIllllIllIIlII = anchor;
        this.llIlIIIllIIlIllIllIllllIl = anchor;
        this.lIllllIllIIlIIlIIIlIIIlII();
    }

    @Override
    public List llllIIlIIlIIlIIllIIlIIllI() {
        ArrayList<NumberSetting> arrayList = new ArrayList<NumberSetting>(this.IlIlIlllllIlIIlIlIlllIlIl());
        this.llIIlIlIIIllIlIlIlIIlIIll = new NumberSetting("scale", Float.valueOf(1.0f), Float.valueOf(0.5f), Float.valueOf(1.5f));
        arrayList.add(0, this.llIIlIlIIIllIlIlIlIIlIIll);
        return arrayList;
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f, 0.0f);
    }

    public void lIlIlIIIIIIllIlIIIIllIIII() {
        this.lIllllIllIIlIIlIIIlIIIlII();
    }

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3);

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent renderGameOverlayEvent, float f, float f2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(renderGameOverlayEvent, f, f2);
    }

    public float lIIlIIIIIIlIIlIIllIlIIlII() {
        return ((Float)this.llIIlIlIIIllIlIlIlIIlIIll.llIlllIIIllllIIlllIllIIIl()).floatValue();
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float f) {
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(Float.valueOf(f));
    }

    public float IlIIlIIlIIlIIllIIIllIIllI() {
        return this.llIIIIIIIllIIllIlIllIIIIl * this.lIIlIIIIIIlIIlIIllIlIIlII();
    }

    public float IIlIlIIIllIIllllIllllIlIl() {
        return this.lIIIllIllIIllIlllIlIIlllI * this.lIIlIIIIIIlIIlIIllIlIIlII();
    }

    public float[] lllllIIIIlIlllIllIIIlIIlI() {
        ScaledResolutionHelper scaledResolutionHelper = AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI();
        float f = (float)this.lIlIlIlIlIIlIIlIIllIIIIIl((double)scaledResolutionHelper.lIlIlIlIlIIlIIlIIllIIIIIl());
        float f2 = (float)this.IlllIIIIIIlllIlIIlllIlIIl((double)scaledResolutionHelper.IlllIIIIIIlllIlIIlllIlIIl());
        return new float[]{f, f2};
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        this.llllIIlIIlIIlIIllIIlIIllI = f;
        this.IlIlIlllllIlIIlIlIlllIlIl = f2;
        this.IlllllIlIIIlIIlIIllIIlIll.accept(this);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2) {
        this.llIIIIIIIllIIllIlIllIIIIl = f;
        this.lIIIllIllIIllIlllIlIIlllI = f2;
    }

    public double IIlllIllIlIllIllIIllIlIIl() {
        return this.lIIlIlllIlIlIIIlllIIlIIII * (double)this.lIIlIIIIIIlIIlIIllIlIIlII();
    }

    public double lIlIIlIlllIIlIIIlIlIlIllI() {
        return this.llIllIlIllIlllIllIIIIllII * (double)this.lIIlIIIIIIlIIlIIllIlIIlII();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(this.lIIlIIIIIIlIIlIIllIlIIlII(), this.lIIlIIIIIIlIIlIIllIlIIlII(), this.lIIlIIIIIIlIIlIIllIlIIlII());
        this.lIIlIlllIlIlIIIlllIIlIIII = this.lIlIlIlIlIIlIIlIIllIIIIIl(d);
        this.llIllIlIllIlllIllIIIIllII = this.IlllIIIIIIlllIlIIlllIlIIl(d2);
    }

    public void lIIlllIIIIIlllIIIlIlIlllI() {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(1.0f / this.lIIlIIIIIIlIIlIIllIlIIlII(), 1.0f / this.lIIlIIIIIIlIIlIIllIlIIlII(), 1.0f / this.lIIlIIIIIIlIIlIIllIlIIlII());
    }

    public double lIlIlIlIlIIlIIlIIllIIIIIl(double d) {
        if (this.IIlIllIlllllllIIlIIIllIIl) {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl(Anchor.MIDDLE_CENTER, d);
        }
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII, d);
    }

    public double lIlIlIlIlIIlIIlIIllIIIIIl(Anchor anchor, double d) {
        float f = this.IlIIlIIlIIlIIllIIIllIIllI();
        float f2 = 2.0f;
        switch (anchor) {
            case TOP_LEFT: 
            case MIDDLE_LEFT: 
            case BOTTOM_LEFT: {
                break;
            }
            case TOP_CENTER: 
            case MIDDLE_CENTER: {
                f2 = (float)(d / 2.0) - f / 2.0f;
                break;
            }
            case BOTTOM_CENTER_L: {
                f2 = (float)(d / 2.0) - f + 30.0f;
                break;
            }
            case BOTTOM_CENTER_R: {
                f2 = (float)(d / 2.0) - 30.0f;
                break;
            }
            case TOP_RIGHT: 
            case MIDDLE_RIGHT: 
            case BOTTOM_RIGHT: {
                f2 = (float)(d - (double)f - 2.0);
            }
        }
        return (f2 + this.llllIIlIIlIIlIIllIIlIIllI) / this.lIIlIIIIIIlIIlIIllIlIIlII();
    }

    public double IlllIIIIIIlllIlIIlllIlIIl(double d) {
        return this.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIIIIIIlIIIllllIllIIlII, d);
    }

    public double IlllIIIIIIlllIlIIlllIlIIl(Anchor anchor, double d) {
        float f = this.IIlIlIIIllIIllllIllllIlIl();
        float f2 = 2.0f;
        switch (anchor) {
            case TOP_LEFT: 
            case TOP_CENTER: 
            case TOP_RIGHT: {
                break;
            }
            case MIDDLE_LEFT: 
            case MIDDLE_CENTER: 
            case MIDDLE_RIGHT: {
                f2 = (float)(d / 2.0) - f / 2.0f;
                break;
            }
            case BOTTOM_LEFT: 
            case BOTTOM_CENTER_L: 
            case BOTTOM_CENTER_R: 
            case BOTTOM_RIGHT: {
                f2 = (float)(d - (double)f - 2.0);
            }
        }
        return (f2 + this.IlIlIlllllIlIIlIlIlllIlIl) / this.lIIlIIIIIIlIIlIIllIlIIlII();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        if (!this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl().equalsIgnoreCase(this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl())) {
            jsonObject.addProperty("position", this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl());
        }
        if (this.llllIIlIIlIIlIIllIIlIIllI != 0.0f) {
            jsonObject.addProperty("x", (Number)Float.valueOf(this.llllIIlIIlIIlIIllIIlIIllI));
        }
        if (this.IlIlIlllllIlIIlIlIlllIlIl != 0.0f) {
            jsonObject.addProperty("y", (Number)Float.valueOf(this.IlIlIlllllIlIIlIlIlllIlIl));
        }
        super.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        if (jsonObject == null || jsonObject.isJsonNull()) {
            return;
        }
        JsonObject jsonObject2 = jsonObject.getAsJsonObject();
        this.lIlIIIIIIlIIIllllIllIIlII = !jsonObject2.has("position") || jsonObject2.get("position").isJsonNull() ? this.llIlIIIllIIlIllIllIllllIl : Anchor.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2.get("position").getAsString());
        float f = jsonObject2.has("x") && !jsonObject2.get("x").isJsonNull() ? jsonObject2.get("x").getAsFloat() : 0.0f;
        float f2 = jsonObject2.has("y") && !jsonObject2.get("y").isJsonNull() ? jsonObject2.get("y").getAsFloat() : 0.0f;
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2);
        super.IlllIIIIIIlllIlIIlllIlIIl(jsonObject);
    }

    public boolean IIIlIIIIIIllIIIIllIIIIlII() {
        return true;
    }

    public float IlIIIlIlIlIlIlIllIIllIIlI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public float IlIlIllIIllllIllllllIIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public float lIIlIIlllIIIIlIlllIIIIlll() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public float llIllIIIIlIIIIIIlllIllIlI() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Anchor anchor) {
        this.lIlIIIIIIlIIIllllIllIIlII = anchor;
    }

    public Anchor lIlIIIIIllIIlIIlIIlIlIIlI() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public Anchor IIllIlIllIlIllIllIllIllII() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public boolean IlIlllIlIlllIllIIIIIIlllI() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(boolean bl) {
        this.IllIllIIIllIIIlIlIlIIIIll = bl;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(boolean bl) {
        this.IIlIllIlllllllIIlIIIllIIl = bl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Consumer consumer) {
        this.IlllllIlIIIlIIlIIllIIlIll = consumer;
    }

    static {
        EventBus.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(RenderScaledGameOverlayEvent.class, renderScaledGameOverlayEvent -> {
            boolean bl;
            Class clazz = Ref.llIIIlllIIlllIllllIlIllIl();
            if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$showDebugInfo() && !((Boolean) LunarClient.IIllIlIllIlIllIllIllIllII().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIIIIIIlIIIllllIllIIlII().llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
                return;
            }
            if (clazz == FriendsUIScreen.class && !((Boolean)Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llIlIIIllIIlIllIllIllllIl().llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
                return;
            }
            boolean bl2 = bl = clazz == MovementUI.class || clazz == SettingsUIScreen.class;
            if (LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll() && !bl) {
                return;
            }
            for (ConfigurableFeature configurableFeature : Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl()) {
                if (!configurableFeature.IlllIIIIIIlllIlIIlllIlIIl()) continue;
                if (!configurableFeature.llIIIllllIIIllIIIIlIlIlll().isEmpty()) {
                    for (AbstractFeatureContainerChild abstractFeatureContainerChild : configurableFeature.llIIIllllIIIllIIIIlIlIlll()) {
                        if (!abstractFeatureContainerChild.IlllIIIIIIlllIlIIlllIlIIl() || !configurableFeature.lllllIllIllIllllIlIllllII.test(abstractFeatureContainerChild) && !bl) continue;
                        abstractFeatureContainerChild.lIlIlIlIlIIlIIlIIllIIIIIl((RenderScaledGameOverlayEvent)renderScaledGameOverlayEvent, bl);
                    }
                }
                if (!(configurableFeature instanceof DraggableHudMod)) continue;
                DraggableHudMod draggableHudMod = (DraggableHudMod)configurableFeature;
                draggableHudMod.lIlIlIlIlIIlIIlIIllIIIIIl((RenderScaledGameOverlayEvent)renderScaledGameOverlayEvent, bl);
            }
        });
    }
}