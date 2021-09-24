package com.moonsworth.lunar.client.feature.hud;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.event.type.render.RenderScaledGameOverlayEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.movement.MovementUI;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class DraggableHudMod extends ConfigurableFeature {
    public static final float lllIIIIIlllIIlIllIIlIIIlI = 18.0f;
    public float x;
    public float y;
    public float llIIIIIIIllIIllIlIllIIIIl;
    public float lIIIllIllIIllIlllIlIIlllI;
    public HudModPosition hudModPosition;
    public final HudModPosition llIlIIIllIIlIllIllIllllIl;
    public boolean IllIllIIIllIIIlIlIlIIIIll = false;
    public boolean IIlIllIlllllllIIlIIIllIIl;
    public Consumer<DraggableHudMod> IlllllIlIIIlIIlIIllIIlIll = draggableHudMod -> {};
    public NumberSetting scale;
    public double width;
    public double height;
    public static final float llIIIlllIIlllIllllIlIllIl = 2.0f;

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderScaledGameOverlayEvent renderScaledGameOverlayEvent, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(renderScaledGameOverlayEvent.lIlIlIlIlIIlIIlIIllIIIIIl(), renderScaledGameOverlayEvent.IlllIIIIIIlllIlIIlllIlIIl());
        if (!bl) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(renderScaledGameOverlayEvent, (float)this.getScaledWidth() / this.getScale(), (float)this.getScaledHeight() / this.getScale());
        } else {
            this.IlllIIIIIIlllIlIIlllIlIIl(renderScaledGameOverlayEvent, (float)this.getScaledWidth() / this.getScale(), (float)this.getScaledHeight() / this.getScale());
        }
        this.lIIlllIIIIIlllIIIlIlIlllI();
    }

    public DraggableHudMod(boolean bl, HudModPosition hudModPosition) {
        super(bl);
        this.hudModPosition = hudModPosition;
        this.llIlIIIllIIlIllIllIllllIl = hudModPosition;
        this.lIllllIllIIlIIlIIIlIIIlII();
    }

    @Override
    public List llllIIlIIlIIlIIllIIlIIllI() {
        ArrayList<AbstractSetting<?>> arrayList = new ArrayList<>(this.IlIlIlllllIlIIlIlIlllIlIl());
        this.scale = new NumberSetting("scale", Float.valueOf(1.0f), Float.valueOf(0.5f), Float.valueOf(1.5f));
        arrayList.add(0, this.scale);
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

    public float getScale() {
        return this.scale.llIlllIIIllllIIlllIllIIIl().floatValue();
    }

    public void setScale(float f) {
        this.scale.lIlIlIlIlIIlIIlIIllIIIIIl(Float.valueOf(f));
    }

    public float IlIIlIIlIIlIIllIIIllIIllI() {
        return this.llIIIIIIIllIIllIlIllIIIIl * this.getScale();
    }

    public float IIlIlIIIllIIllllIllllIlIl() {
        return this.lIIIllIllIIllIlllIlIIlllI * this.getScale();
    }

    public float[] lllllIIIIlIlllIllIIIlIIlI() {
        ScaledResolutionHelper scaledResolutionHelper = AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI();
        float f = (float)this.lIlIlIlIlIIlIIlIIllIIIIIl(scaledResolutionHelper.lIlIlIlIlIIlIIlIIllIIIIIl());
        float f2 = (float)this.IlllIIIIIIlllIlIIlllIlIIl(scaledResolutionHelper.IlllIIIIIIlllIlIIlllIlIIl());
        return new float[] {f, f2};
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        this.x = f;
        this.y = f2;
        this.IlllllIlIIIlIIlIIllIIlIll.accept(this);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2) {
        this.llIIIIIIIllIIllIlIllIIIIl = f;
        this.lIIIllIllIIllIlllIlIIlllI = f2;
    }

    public double getScaledWidth() {
        return this.width * (double)this.getScale();
    }

    public double getScaledHeight() {
        return this.height * (double)this.getScale();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(this.getScale(), this.getScale(), this.getScale());
        this.width = this.lIlIlIlIlIIlIIlIIllIIIIIl(d);
        this.height = this.IlllIIIIIIlllIlIIlllIlIIl(d2);
    }

    public void lIIlllIIIIIlllIIIlIlIlllI() {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(1.0f / this.getScale(), 1.0f / this.getScale(), 1.0f / this.getScale());
    }

    public double lIlIlIlIlIIlIIlIIllIIIIIl(double d) {
        if (this.IIlIllIlllllllIIlIIIllIIl) {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl(HudModPosition.MIDDLE_CENTER, d);
        }
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(this.hudModPosition, d);
    }

    public double lIlIlIlIlIIlIIlIIllIIIIIl(HudModPosition hudModPosition, double d) {
        float f = this.IlIIlIIlIIlIIllIIIllIIllI();
        float f2 = 2.0f;
        switch (hudModPosition) {
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
        return (f2 + this.x) / this.getScale();
    }

    public double IlllIIIIIIlllIlIIlllIlIIl(double d) {
        return this.IlllIIIIIIlllIlIIlllIlIIl(this.hudModPosition, d);
    }

    public double IlllIIIIIIlllIlIIlllIlIIl(HudModPosition hudModPosition, double d) {
        float f = this.IIlIlIIIllIIllllIllllIlIl();
        float f2 = 2.0f;
        switch (hudModPosition) {
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
        return (f2 + this.y) / this.getScale();
    }

    @Override
    public void write(JsonObject jsonObject) {
        if (!this.hudModPosition.lIlIlIlIlIIlIIlIIllIIIIIl().equalsIgnoreCase(this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl())) {
            jsonObject.addProperty("position", this.hudModPosition.lIlIlIlIlIIlIIlIIllIIIIIl());
        }
        if (this.x != 0.0f) {
            jsonObject.addProperty("x", x);
        }
        if (this.y != 0.0f) {
            jsonObject.addProperty("y", y);
        }
        super.write(jsonObject);
    }

    @Override
    public void read(JsonObject jsonObject) {
        if (jsonObject == null || jsonObject.isJsonNull()) {
            return;
        }
        JsonObject jsonObject2 = jsonObject.getAsJsonObject();
        this.hudModPosition = !jsonObject2.has("position") || jsonObject2.get("position").isJsonNull() ? this.llIlIIIllIIlIllIllIllllIl : HudModPosition.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2.get("position").getAsString());
        float f = jsonObject2.has("x") && !jsonObject2.get("x").isJsonNull() ? jsonObject2.get("x").getAsFloat() : 0.0f;
        float f2 = jsonObject2.has("y") && !jsonObject2.get("y").isJsonNull() ? jsonObject2.get("y").getAsFloat() : 0.0f;
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2);
        super.read(jsonObject);
    }

    public boolean IIIlIIIIIIllIIIIllIIIIlII() {
        return true;
    }

    public float IlIIIlIlIlIlIlIllIIllIIlI() {
        return this.x;
    }

    public float IlIlIllIIllllIllllllIIlIl() {
        return this.y;
    }

    public float lIIlIIlllIIIIlIlllIIIIlll() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public float llIllIIIIlIIIIIIlllIllIlI() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(HudModPosition hudModPosition) {
        this.hudModPosition = hudModPosition;
    }

    public HudModPosition lIlIIIIIllIIlIIlIIlIlIIlI() {
        return this.hudModPosition;
    }

    public HudModPosition IIllIlIllIlIllIllIllIllII() {
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
        EventBus.getInstance().register(RenderScaledGameOverlayEvent.class, renderScaledGameOverlayEvent -> {
            boolean bl;
            Class<?> clazz = Ref.llIIIlllIIlllIllllIlIllIl();
            if (Ref.getMinecraft().bridge$getGameSettings().bridge$showDebugInfo() && !LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIIIIIIlIIIllllIllIIlII().llIlllIIIllllIIlllIllIIIl()) {
                return;
            }
            if (clazz == FriendsUIScreen.class && !Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llIlIIIllIIlIllIllIllllIl().llIlllIIIllllIIlllIllIIIl()) {
                return;
            }
            boolean bl2 = bl = clazz == MovementUI.class || clazz == SettingsUIScreen.class;
            if (LunarClient.getInstance().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll() && !bl) {
                return;
            }
            for (ConfigurableFeature configurableFeature : Ref.getLC().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl()) {
                if (!configurableFeature.IlllIIIIIIlllIlIIlllIlIIl()) continue;
                if (!configurableFeature.llIIIllllIIIllIIIIlIlIlll().isEmpty()) {
                    for (AbstractFeatureContainerChild abstractFeatureContainerChild : configurableFeature.llIIIllllIIIllIIIIlIlIlll()) {
                        if (!abstractFeatureContainerChild.IlllIIIIIIlllIlIIlllIlIIl() || !configurableFeature.lllllIllIllIllllIlIllllII.test(abstractFeatureContainerChild) && !bl) continue;
                        abstractFeatureContainerChild.lIlIlIlIlIIlIIlIIllIIIIIl(renderScaledGameOverlayEvent, bl);
                    }
                }
                if (!(configurableFeature instanceof DraggableHudMod)) continue;
                DraggableHudMod draggableHudMod = (DraggableHudMod)configurableFeature;
                draggableHudMod.lIlIlIlIlIIlIIlIIllIIIIIl(renderScaledGameOverlayEvent, bl);
            }
        });
    }
}