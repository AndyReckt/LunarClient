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
    public final List<String> namesFilterList = new ArrayList<>();
    public final List<String> settingsFilterList = new ArrayList<>();
    public final FeatureDetails details = initDetails();
    public final BooleanSetting enabled;
    public boolean seen;
    public final List<AbstractSetting<?>> settings;
    public final boolean IlllllIlIIIlIIlIIllIIlIll;
    public final MinecraftBridge mc;
    public final LunarClient lc;
    public float panelX;
    public float panelY;
    public int panelIndex;
    public boolean lllIIIIIlllIIlIllIIlIIIlI;
    public boolean lIlIIIIIIlIIIllllIllIIlII;
    public Boolean llIlIIIllIIlIllIllIllllIl;
    public Boolean IllIllIIIllIIIlIlIlIIIIll;
    public Map<Class<?>, Consumer<? extends Event>> eventMap = new HashMap<>();
    public final ResourceLocationBridge compactIcon = this.getIcon("20x20");
    public final ResourceLocationBridge icon = this.getIcon("52x52");

    public Feature(boolean managedByServer) {
        this.mc = Ref.getMinecraft();
        this.lc = LunarClient.getInstance();
        this.IlllllIlIIIlIIlIIllIIlIll = managedByServer;
        this.enabled = new BooleanSetting(this.getDetails().getId() + "_enabled", managedByServer);
        this.enabled.lIlIlIlIlIIlIIlIIllIIIIIl(managedByServer);
        this.enabled.lIlIlIlIlIIlIIlIIllIIIIIl((bl) -> {
            if (bl && !this.details.isEnabledOnCurrentVersion()) {
                this.lIlIIIIIIlIIIllllIllIIlII = true;
                this.enabled.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                return;
            }
            if (this.IllIllIIIllIIIlIlIlIIIIll != null && bl != this.IllIllIIIllIIIlIlIlIIIIll) {
                this.enabled.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll);
                return;
            }
            this.lIlIlIlIlIIlIIlIIllIIIIIl((boolean)bl);
            if (!(this instanceof IntergratedServerInterface)) {
                if (bl) {
                    LunarLogger.debug("Enabled " + this.getDetails().getId());
                    this.lIllIlIIIlIIIIIIIlllIlIll();
                } else {
                    LunarLogger.debug("Disabled " + this.getDetails().getId());
                    this.llIlllIIIllllIIlllIllIIIl();
                }
            } else {
                LunarClient.getInstance().lIIIllIllIIllIlllIlIIlllI().updateFeature(this, bl);
            }
        });
        this.settings = this.llllIIlIIlIIlIIllIIlIIllI();
    }

    public void setupNameFilter() {
        String string = this.details.get("name");
        String[] nameSplit = string.split(" ");
        this.namesFilterList.add(LanguageParser.normalize(string).toLowerCase());
        this.namesFilterList.add(LanguageParser.normalize(this.getDetails().getId()).toLowerCase());
        for (String name : nameSplit) {
            String translatedName = LanguageParser.normalize(name);
            this.namesFilterList.add(translatedName.toLowerCase());
        }
        if (this.getDetails().getAliases() != null) {
            for (String alias : this.getDetails().getAliases()) {
                for (String aliasSplit : alias.split(" ")) {
                    this.namesFilterList.add(LanguageParser.normalize(aliasSplit).toLowerCase());
                }
            }
        }
        for (AbstractSetting<?> abstractSetting : this.settings) {
            for (String settingName : abstractSetting.f_().split(" ")) {
                this.settingsFilterList.add(LanguageParser.normalize(settingName).toLowerCase());
            }
        }
        if (this instanceof ConfigurableFeature && !((ConfigurableFeature)this).llIIIllllIIIllIIIIlIlIlll().isEmpty()) {
            for (AbstractFeatureContainerChild abstractFeatureContainerChild : ((ConfigurableFeature)this).llIIIllllIIIllIIIIlIlIlll()) {
                abstractFeatureContainerChild.setupNameFilter();
                this.namesFilterList.addAll(abstractFeatureContainerChild.lIIIllIllIIllIlllIlIIlllI());
                this.settingsFilterList.addAll(abstractFeatureContainerChild.IlllllIlIIIlIIlIIllIIlIll());
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
            this.enabled.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl);
        } else if (this.IllIllIIIllIIIlIlIlIIIIll != bl2) {
            this.enabled.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll);
        }
        return bl2 != this.IlllIIIIIIlllIlIIlllIlIIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.enabled.lIlIlIlIlIIlIIlIIllIIIIIl(bl);
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.getDetails().isEnabledOnCurrentVersion() && (this.IllIllIIIllIIIlIlIlIIIIll != null ? this.IllIllIIIllIIIlIlIlIIIIll : this.enabled.llIlllIIIllllIIlllIllIIIl());
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        for (Map.Entry<Class<?>, Consumer<? extends Event>> entry : this.eventMap.entrySet()) {
            Class clazz = entry.getKey();
            Consumer consumer = entry.getValue();
            EventBus.getInstance().register(clazz, consumer);
        }
    }

    public <T extends Event> void llIlllIIIllllIIlllIllIIIl() {
        for (Map.Entry entry : this.eventMap.entrySet()) {
            Class clazz = (Class)entry.getKey();
            Consumer consumer = (Consumer)entry.getValue();
            EventBus.getInstance().remove(clazz, consumer);
        }
    }

    public <T extends Event> void lIlIlIlIlIIlIIlIIllIIIIIl(Class<T> clazz, Consumer<T> consumer) {
        this.eventMap.put(clazz, consumer);
    }

    public List<AbstractSetting<?>> llllIIlIIlIIlIIllIIlIIllI() {
        return this.IlIlIlllllIlIIlIlIlllIlIl();
    }

    public abstract List<AbstractSetting<?>> IlIlIlllllIlIIlIlIlllIlIl();

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7);

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, float f2, float f3, float f4) {
        float f5 = Ref.getFontRenderer().bridge$getStringWidth(string);
        float f6 = f + f3 / 2.0f - f5 / 2.0f;
        Ref.getFontRenderer().bridge$drawString(string, f6, f2 + f4 / 2.0f, -1, true);
    }

    public abstract FeatureDetails initDetails();

    @Override
    public void write(JsonObject jsonObject) {
        if (!this.details.isEnabledOnCurrentVersion()) {
            jsonObject.addProperty(this.enabled.lIIlIlllIlIlIIIlllIIlIIII(), this.lIIIlllIIIIllllIlIIIlIIll());
        } else {
            this.enabled.write(jsonObject);
        }
        jsonObject.addProperty("panelIndex", this.panelIndex);
        jsonObject.addProperty("seen", this.seen);
        JsonObject jsonObject2 = new JsonObject();
        for (AbstractSetting<?> abstractSetting : this.settings) {
            abstractSetting.write(jsonObject2);
        }
        if (!jsonObject2.entrySet().isEmpty()) {
            jsonObject.add("options", jsonObject2);
        }
    }

    @Override
    public void read(JsonObject jsonObject) {
        JsonObject jsonObject2 = jsonObject.getAsJsonObject();
        this.enabled.read(jsonObject2);
        this.panelIndex = jsonObject2.has("panelIndex") && !jsonObject2.get("panelIndex").isJsonNull() ? jsonObject2.get("panelIndex").getAsInt() : 0;
        if (jsonObject2.has("seen")) {
            this.seen = jsonObject2.get("seen").getAsBoolean();
        }
        JsonObject jsonObject3 = jsonObject2.has("options") && !jsonObject2.get("options").isJsonNull() ? jsonObject2.getAsJsonObject("options") : new JsonObject();
        for (AbstractSetting<?> abstractSetting : this.settings) {
            try {
                abstractSetting.read(jsonObject3);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public String getLanguagePath() {
        return "features." + this.details.getId();
    }

    public String toString() {
        return this.getDetails().toString();
    }

    public ResourceLocationBridge getIcon(String string) {
        ResourceLocationBridge resourceLocationBridge = Bridge.getInstance().initResourceLocation("lunar", "icons/features/" + this.getDetails().getId().toLowerCase() + "-" + string + ".png");
        try {
            if (Ref.getMinecraft().bridge$getResourceManager().bridge$getResource(resourceLocationBridge) != null) {
                return resourceLocationBridge;
            }
        } catch (IOException iOException) {
            // empty catch block
        }
        return null;
    }

    public void setPanelIndex(int n) {
        this.panelIndex = n;
        Ref.getLC().lllllIllIllIllllIlIllllII().save();
    }

    public List<String> lIIIllIllIIllIlllIlIIlllI() {
        return this.namesFilterList;
    }

    public List<String> IlllllIlIIIlIIlIIllIIlIll() {
        return this.settingsFilterList;
    }

    public FeatureDetails getDetails() {
        return this.details;
    }

    public BooleanSetting llIIIlllIIlllIllllIlIllIl() {
        return this.enabled;
    }

    public boolean lllllIllIllIllllIlIllllII() {
        return this.seen;
    }

    public List<AbstractSetting<?>> lllIIIIIlllIIlIllIIlIIIlI() {
        return this.settings;
    }

    public boolean lIlIIIIIIlIIIllllIllIIlII() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public MinecraftBridge llIlIIIllIIlIllIllIllllIl() {
        return this.mc;
    }

    public LunarClient IllIllIIIllIIIlIlIlIIIIll() {
        return this.lc;
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
        return this.eventMap;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(boolean bl) {
        this.seen = bl;
    }

    public float getPanelX() {
        return this.panelX;
    }

    public float getPanelY() {
        return this.panelY;
    }

    public void setPanelX(float f) {
        this.panelX = f;
    }

    public void setPanelY(float f) {
        this.panelY = f;
    }

    public int getPanelIndex() {
        return this.panelIndex;
    }

    public void llIlllIIIllllIIlllIllIIIl(boolean bl) {
        this.lllIIIIIlllIIlIllIIlIIIlI = bl;
    }

    public boolean lIIIlllIIIIllllIlIIIlIIll() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public ResourceLocationBridge llIIIlIllIIIIlIIIlIlIllIl() {
        return this.compactIcon;
    }

    public ResourceLocationBridge llllIlIllllIlIlIIIllIlIlI() {
        return this.icon;
    }
}