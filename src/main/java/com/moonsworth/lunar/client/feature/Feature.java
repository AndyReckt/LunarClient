package com.moonsworth.lunar.client.feature;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.IntergratedServerInterface;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.Json;
import com.moonsworth.lunar.client.util.LanguageParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author Decencies
 * @since 10/07/2021 17:52
 */
public abstract class Feature implements I18nBridge, Json {
    public final List llllIIlIIlIIlIIllIIlIIllI = new ArrayList();
    public final List IlIlIlllllIlIIlIlIlllIlIl = new ArrayList();
    public final FeatureDetails llIIIIIIIllIIllIlIllIIIIl = this.llIIIIIIIllIIllIlIllIIIIl();
    public final BooleanSetting lIlIlIlIlIIlIIlIIllIIIIIl;
    public boolean lIIIllIllIIllIlllIlIIlllI;
    public final List<AbstractSetting<?>> IlllIIIIIIlllIlIIlllIlIIl;
    public final boolean IlllllIlIIIlIIlIIllIIlIll;
    public final MinecraftBridge lIllIlIIIlIIIIIIIlllIlIll;
    public final LunarClient llIlllIIIllllIIlllIllIIIl;
    public float llIIlIlIIIllIlIlIlIIlIIll;
    public float llIIIlllIIlllIllllIlIllIl;
    public int lllllIllIllIllllIlIllllII;
    public boolean lllIIIIIlllIIlIllIIlIIIlI;
    public boolean lIlIIIIIIlIIIllllIllIIlII;
    public Boolean llIlIIIllIIlIllIllIllllIl;
    public Boolean IllIllIIIllIIIlIlIlIIIIll;
    public Map<Class<?>, Consumer<? extends Event>> IIlIllIlllllllIIlIIIllIIl = new HashMap<>();
    public final ResourceLocationBridge lIIlIlllIlIlIIIlllIIlIIII = this.getIcon("20x20");
    public final ResourceLocationBridge llIllIlIllIlllIllIIIIllII = this.getIcon("52x52");

    public Feature(boolean bl2) {
        this.lIllIlIIIlIIIIIIIlllIlIll = Ref.lIlIlIlIlIIlIIlIIllIIIIIl();
        this.llIlllIIIllllIIlllIllIIIl = LunarClient.IIllIlIllIlIllIllIllIllII();
        this.IlllllIlIIIlIIlIIllIIlIll = bl2;
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new BooleanSetting(this.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl() + "_enabled", bl2);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl2);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((bl) -> {
            if (bl && !this.llIIIIIIIllIIllIlIllIIIIl.lIllIlIIIlIIIIIIIlllIlIll()) {
                this.lIlIIIIIIlIIIllllIllIIlII = true;
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                return;
            }
            if (this.IllIllIIIllIIIlIlIlIIIIll != null && bl != this.IllIllIIIllIIIlIlIlIIIIll) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll);
                return;
            }
            this.lIlIlIlIlIIlIIlIIllIIIIIl((boolean)bl);
            if (!(this instanceof IntergratedServerInterface)) {
                if (bl.booleanValue()) {
                    LunarLogger.lIlIlIlIlIIlIIlIIllIIIIIl((Object)("Enabled " + this.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl()), new Object[0]);
                    this.lIllIlIIIlIIIIIIIlllIlIll();
                } else {
                    LunarLogger.lIlIlIlIlIIlIIlIIllIIIIIl((Object)("Disabled " + this.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl()), new Object[0]);
                    this.llIlllIIIllllIIlllIllIIIl();
                }
            } else {
                LunarClient.IIllIlIllIlIllIllIllIllII().lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(this, (boolean)bl);
            }
        });
        this.IlllIIIIIIlllIlIIlllIlIIl = this.llllIIlIIlIIlIIllIIlIIllI();
    }

    public void a_() {
        String string = this.llIIIIIIIllIIllIlIllIIIIl.get("name", new Object[0]);
        String[] stringArray = string.split(" ");
        this.llllIIlIIlIIlIIllIIlIIllI.add(LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(string).toLowerCase());
        this.llllIIlIIlIIlIIllIIlIIllI.add(LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl()).toLowerCase());
        for (String string2 : stringArray) {
            String stringArray2 = LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(string2);
            this.llllIIlIIlIIlIIllIIlIIllI.add(stringArray2.toLowerCase());
        }
        if (this.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl() != null) {
            for (String string2 : this.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl()) {
                for (String string3 : string2.split(" ")) {
                    this.llllIIlIIlIIlIIllIIlIIllI.add(LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(string3).toLowerCase());
                }
            }
        }
        for (AbstractSetting abstractSetting : this.IlllIIIIIIlllIlIIlllIlIIl) {
            String[] stringArray4;
            for (String string3 : stringArray4 = abstractSetting.f_().split(" ")) {
                this.IlIlIlllllIlIIlIlIlllIlIl.add(LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(string3).toLowerCase());
            }
        }
        if (this instanceof ConfigurableFeature && !((ConfigurableFeature)this).llIIIllllIIIllIIIIlIlIlll().isEmpty()) {
            for (AbstractFeatureContainerChild abstractFeatureContainerChild : ((ConfigurableFeature)this).llIIIllllIIIllIIIIlIlIlll()) {
                abstractFeatureContainerChild.a_();
                this.llllIIlIIlIIlIIllIIlIIllI.addAll(abstractFeatureContainerChild.lIIIllIllIIllIlllIlIIlllI());
                this.IlIlIlllllIlIIlIlIlllIlIl.addAll(abstractFeatureContainerChild.IlllllIlIIIlIIlIIllIIlIll());
            }
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Boolean bl) {
        boolean bl2 = this.IlllIIIIIIlllIlIIlllIlIIl();
        if (this.IllIllIIIllIIIlIlIlIIIIll == null) {
            this.llIlIIIllIIlIllIllIllllIl = bl2;
        }
        this.IllIllIIIllIIIlIlIlIIIIll = bl;
        if (this.IllIllIIIllIIIlIlIlIIIIll == null) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl);
        } else if (this.IllIllIIIllIIIlIlIlIIIIll != bl2) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll);
        }
        return bl2 != this.IlllIIIIIIlllIlIIlllIlIIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl);
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return !this.llIIlIlIIIllIlIlIlIIlIIll().lIllIlIIIlIIIIIIIlllIlIll() ? false : (this.IllIllIIIllIIIlIlIlIIIIll != null ? this.IllIllIIIllIIIlIlIlIIIIll.booleanValue() : ((Boolean)this.lIlIlIlIlIIlIIlIIllIIIIIl.llIlllIIIllllIIlllIllIIIl()).booleanValue());
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        for (Map.Entry<Class<?>, Consumer<? extends Event>> entry : this.IIlIllIlllllllIIlIIIllIIl.entrySet()) {
            Class clazz = (Class)entry.getKey();
            Consumer consumer = (Consumer)entry.getValue();
            EventBus.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(clazz, consumer);
        }
    }

    public void llIlllIIIllllIIlllIllIIIl() {
        for (Map.Entry entry : this.IIlIllIlllllllIIlIIIllIIl.entrySet()) {
            Class clazz = (Class)entry.getKey();
            Consumer consumer = (Consumer)entry.getValue();
            EventBus.lIlIlIlIlIIlIIlIIllIIIIIl().IlllIIIIIIlllIlIIlllIlIIl(clazz, consumer);
        }
    }

    public <T extends Event> void lIlIlIlIlIIlIIlIIllIIIIIl(Class<T> clazz, Consumer<T> consumer) {
        this.IIlIllIlllllllIIlIIIllIIl.put(clazz, consumer);
    }

    public List llllIIlIIlIIlIIllIIlIIllI() {
        return this.IlIlIlllllIlIIlIlIlllIlIl();
    }

    public abstract List IlIlIlllllIlIIlIlIlllIlIl();

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7);

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, float f2, float f3, float f4) {
        float f5 = Ref.IlllllIlIIIlIIlIIllIIlIll().bridge$getStringWidth(string);
        float f6 = f + f3 / 2.0f - f5 / 2.0f;
        Ref.IlllllIlIIIlIIlIIllIIlIll().bridge$drawString(string, f6, f2 + f4 / 2.0f, -1, true);
    }

    public abstract FeatureDetails llIIIIIIIllIIllIlIllIIIIl();

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        if (!this.llIIIIIIIllIIllIlIllIIIIl.lIllIlIIIlIIIIIIIlllIlIll()) {
            jsonObject.addProperty(this.lIlIlIlIlIIlIIlIIllIIIIIl.lIIlIlllIlIlIIIlllIIlIIII(), Boolean.valueOf(this.lIIIlllIIIIllllIlIIIlIIll()));
        } else {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject);
        }
        jsonObject.addProperty("panelIndex", (Number)this.lllllIllIllIllllIlIllllII);
        jsonObject.addProperty("seen", Boolean.valueOf(this.lIIIllIllIIllIlllIlIIlllI));
        JsonObject jsonObject2 = new JsonObject();
        for (AbstractSetting abstractSetting : this.IlllIIIIIIlllIlIIlllIlIIl) {
            abstractSetting.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2);
        }
        if (!jsonObject2.entrySet().isEmpty()) {
            jsonObject.add("options", jsonObject2);
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        JsonObject jsonObject2 = jsonObject.getAsJsonObject();
        this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(jsonObject2);
        this.lllllIllIllIllllIlIllllII = jsonObject2.has("panelIndex") && !jsonObject2.get("panelIndex").isJsonNull() ? jsonObject2.get("panelIndex").getAsInt() : 0;
        if (jsonObject2.has("seen")) {
            this.lIIIllIllIIllIlllIlIIlllI = jsonObject2.get("seen").getAsBoolean();
        }
        JsonObject jsonObject3 = jsonObject2.has("options") && !jsonObject2.get("options").isJsonNull() ? jsonObject2.getAsJsonObject("options") : new JsonObject();
        for (AbstractSetting abstractSetting : this.IlllIIIIIIlllIlIIlllIlIIl) {
            try {
                abstractSetting.IlllIIIIIIlllIlIIlllIlIIl(jsonObject3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public String getLanguagePath() {
        return "features." + this.llIIIIIIIllIIllIlIllIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    public String toString() {
        return this.llIIlIlIIIllIlIlIlIIlIIll().toString();
    }

    public ResourceLocationBridge getIcon(String string) {
        ResourceLocationBridge resourceLocationBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/features/" + this.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl().toLowerCase() + "-" + string + ".png");
        try {
            if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getResourceManager().bridge$getResource(resourceLocationBridge) != null) {
                return resourceLocationBridge;
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return null;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.lllllIllIllIllllIlIllllII = n;
        Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().save();
    }

    public List<String> lIIIllIllIIllIlllIlIIlllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public List<String> IlllllIlIIIlIIlIIllIIlIll() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public FeatureDetails llIIlIlIIIllIlIlIlIIlIIll() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public BooleanSetting llIIIlllIIlllIllllIlIllIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public boolean lllllIllIllIllllIlIllllII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public List<AbstractSetting<?>> lllIIIIIlllIIlIllIIlIIIlI() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public boolean lIlIIIIIIlIIIllllIllIIlII() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public MinecraftBridge llIlIIIllIIlIllIllIllllIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public LunarClient IllIllIIIllIIIlIlIlIIIIll() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public boolean IIlIllIlllllllIIlIIIllIIl() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public Boolean lIIlIlllIlIlIIIlllIIlIIII() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public Boolean llIllIlIllIlllIllIIIIllII() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public Map IllllllllllIlIIIlllIlllll() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(boolean bl) {
        this.lIIIllIllIIllIlllIlIIlllI = bl;
    }

    public float lllllIllIlIIlIIlIIIlllIlI() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public float IllIIIlllIIIlIlllIlIIlIII() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.llIIlIlIIIllIlIlIlIIlIIll = f;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float f) {
        this.llIIIlllIIlllIllllIlIllIl = f;
    }

    public int IIlIllIlIIllIIlIlIllllllI() {
        return this.lllllIllIllIllllIlIllllII;
    }

    public void llIlllIIIllllIIlllIllIIIl(boolean bl) {
        this.lllIIIIIlllIIlIllIIlIIIlI = bl;
    }

    public boolean lIIIlllIIIIllllIlIIIlIIll() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public ResourceLocationBridge llIIIlIllIIIIlIIIlIlIllIl() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public ResourceLocationBridge llllIlIllllIlIlIIIllIlIlI() {
        return this.llIllIlIllIlllIllIIIIllII;
    }
}