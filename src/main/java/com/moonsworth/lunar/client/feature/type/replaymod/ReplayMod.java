package com.moonsworth.lunar.client.feature.type.replaymod;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.type.recordingindicator.RecordingIndicatorMod;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;
import com.moonsworth.lunar.client.ui.component.type.setting.lllllIIIIlIlllIllIIIlIIlI;

import java.util.ArrayList;
import java.util.List;

public class ReplayMod
extends ConfigurableFeature {
    public static final ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "replaymod/gui_lunar.png");
    public static final ResourceLocationBridge IlIlIlllllIlIIlIlIlllIlIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "replaymod/gui_replaymod_lunar.png");
    public IReplayModWrapper llIIIIIIIllIIllIlIllIIIIl;
    public JsonObject lIIIllIllIIllIlllIlIIlllI = new JsonObject();
    public RecordingIndicatorMod IlllllIlIIIlIIlIIllIIlIll;
    public BooleanSetting llIIlIlIIIllIlIlIlIIlIIll;
    public LunarKeybindSetting llIIIlllIIlllIllllIlIllIl;
    public LunarKeybindSetting lllIIIIIlllIIlIllIIlIIIlI;

    public ReplayMod() {
        super(false);
        for (KeyBindingBridge keyBindingBridge : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$getKeyBindings()) {
            if (!keyBindingBridge.bridge$getCategory().equals("replaymod.title")) continue;
            this.lIIIllIllIIllIlllIlIIlllI.addProperty(keyBindingBridge.bridge$getKeyDescription(), Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIllIlIIIlIIIIIIIlllIlIll(keyBindingBridge.bridge$getKey()));
        }
        this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (!this.llIIIIIIIllIIllIlIllIIIIl.isViewingReplay()) {
                if (this.llIIIIIIIllIIllIlIllIIIIl.isRecording()) {
                    this.llIIIIIIIllIIllIlIllIIIIl.stopRecording();
                } else {
                    this.llIIIIIIIllIIllIlIllIIIIl.startRecording();
                }
            }
        });
        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (!this.llIIIIIIIllIIllIlIllIIIIl.isViewingReplay()) {
                if (!this.llIIIIIIIllIIllIlIllIIIIl.isRecording()) {
                    return;
                }
                if (this.llIIIIIIIllIIllIlIllIIIIl.isPaused()) {
                    this.llIIIIIIIllIIllIlIllIIIIl.resumeRecording();
                } else {
                    this.llIIIIIIIllIIllIlIllIIIIl.pauseRecording();
                }
            }
        });
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(bl);
        if (this.llIIIIIIIllIIllIlIllIIIIl == null) {
            return;
        }
        if (bl) {
            this.llIIIIIIIllIIllIlIllIIIIl.onEnable();
        } else {
            this.llIIIIIIIllIIllIlIllIIIIl.onDisable();
        }
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        List<AbstractSetting> arrayList = new ArrayList<>();
        arrayList.add(new BooleanSetting("indicator", true, () -> true).IlllIIIIIIlllIlIIlllIlIIl((bl) -> this.IlllllIlIIIlIIlIIllIIlIll.IlllIIIIIIlllIlIIlllIlIIl((boolean)bl)));
        arrayList.add(new BooleanSetting("autoPostProcess", true, () -> true));
        arrayList.add(new BooleanSetting("showServerIPs", true, () -> true));
        arrayList.add(new lllllIIIIlIlllIllIIIlIIlI("camera", "replaymod.camera.classic", () -> true));
        arrayList.add(new BooleanSetting("autosync", true, () -> true));
        arrayList.add(new NumberSetting("timelineLength", 1800, 1500, 2100, 0, () -> true));
        arrayList.add(new lllllIIIIlIlllIllIIIlIIlI("interpolator", "replaymod.gui.editkeyframe.interpolator.catmull.name", () -> true));
        arrayList.add(new BooleanSetting("askForOpenEye", false, () -> true));
        arrayList.add(new BooleanSetting("skipPostRenderGui", false, () -> true));
        arrayList.add(new BooleanSetting("skipPostRenderGui", false, () -> true));
        arrayList.add(new BooleanSetting("skipPostScreenshotGui", false, () -> true));
        arrayList.add(new BooleanSetting("pathpreview", true, () -> true));
        this.llIIlIlIIIllIlIlIlIIlIIll = new BooleanSetting("lunar_ui", true);
        arrayList.add(this.llIIlIlIIIllIlIlIlIIlIIll);
        arrayList.add(new SettingLabel("general"));
        arrayList.add(new BooleanSetting("notifications", true));
        arrayList.add(new lllllIIIIlIlllIllIIIlIIlI("recordingPath", "./replay_recordings/"));
        arrayList.add(new lllllIIIIlIlllIllIIIlIIlI("cachePath", "./.replay_cache/"));
        arrayList.add(new lllllIIIIlIlllIllIIIlIIlI("renderPath", "./replay_videos/"));
        arrayList.add(new SettingLabel("recording"));
        this.llIIIlllIIlllIllllIlIllIl = new LunarKeybindSetting(this, "startStop", KeyType.IlIllIIlIIlIIIllIllllIIll);
        arrayList.add(this.llIIIlllIIlllIllllIlIllIl);
        this.lllIIIIIlllIIlIllIIlIIIlI = new LunarKeybindSetting(this, "pauseResume", KeyType.llllIlIllllIlIlIIIllIlIlI);
        arrayList.add(this.lllIIIIIlllIIlIllIIlIIIlI);
        arrayList.add(new BooleanSetting("recordSingleplayer", true));
        arrayList.add(new BooleanSetting("recordServer", true));
        arrayList.add(new BooleanSetting("autoStartRecording", false));
        arrayList.add(new BooleanSetting("renameDialog", true));
        arrayList.add(new SettingLabel("replay"));
        arrayList.add(new BooleanSetting("showChat", true));
        return arrayList;
    }

    @Override
    public List llllIlIlIIIllllIIlIllIlII() {
        this.IlllllIlIIIlIIlIIllIIlIll = new RecordingIndicatorMod(this);
        return ImmutableList.of(this.IlllllIlIIIlIIlIIllIIlIll);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("ReplayMod", f, f2, f3, f4);
    }

    @Override
    public FeatureDetails llIIIIIIIllIIllIlIllIIIIl() {
        return new FeatureDetails("replaymod", ImmutableList.of(ModuleCategory.lIlIlIlIlIIlIIlIIllIIIIIl, ModuleCategory.llllIIlIIlIIlIIllIIlIIllI, ModuleCategory.IlllIIIIIIlllIlIIlllIlIIl), ImmutableList.of(MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl), "CrushedPixel", "johni0702");
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        this.lIIIllIllIIllIlllIlIIlllI = new JsonObject();
        for (KeyBindingBridge keyBindingBridge : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$getKeyBindings()) {
            if (!keyBindingBridge.bridge$getCategory().equals("replaymod.title")) continue;
            this.lIIIllIllIIllIlllIlIIlllI.addProperty(keyBindingBridge.bridge$getKeyDescription(), Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIllIlIIIlIIIIIIIlllIlIll(keyBindingBridge.bridge$getKey()));
        }
        jsonObject.add("keybinds", this.lIIIllIllIIllIlllIlIIlllI);
        super.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        this.lIIIllIllIIllIlllIlIIlllI = new JsonObject();
        if (jsonObject.isJsonObject() && jsonObject.has("keybinds")) {
            this.lIIIllIllIIllIlllIlIIlllI = jsonObject.get("keybinds").getAsJsonObject();
        }
        super.IlllIIIIIIlllIlIIlllIlIIl(jsonObject);
    }

    public boolean IlIllIIlIIlIIIllIllllIIll() {
        return this.llIIlIlIIIllIlIlIlIIlIIll() != null && this.llIIIIIIIllIIllIlIllIIIIl != null && this.llIIlIlIIIllIlIlIlIIlIIll().lIllIlIIIlIIIIIIIlllIlIll() && this.llIIIIIIIllIIllIlIllIIIIl.isViewingReplay();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(IReplayModWrapper iReplayModWrapper) {
        this.llIIIIIIIllIIllIlIllIIIIl = iReplayModWrapper;
    }

    public IReplayModWrapper lIllllIllIIlIIlIIIlIIIlII() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public JsonObject lIlIlIIIIIIllIlIIIIllIIII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public BooleanSetting lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public LunarKeybindSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public LunarKeybindSetting IIlIlIIIllIIllllIllllIlIl() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }
}
 