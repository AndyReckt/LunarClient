package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.settings.GameSettingsBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.bridge.minecraft.util.LunarOptionsParser;
import com.moonsworth.lunar.client.bridge.impl.type.keyboard.KeyboardImplementation;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

@Mixin(value= GameSettings.class)
public abstract class MixinGameSettingszz implements GameSettingsBridge {
    @Shadow
    public int thirdPersonView;
    @Shadow
    public KeyBinding keyBindScreenshot;
    @Shadow
    public KeyBinding keyBindForward;
    @Shadow
    public KeyBinding keyBindLeft;
    @Shadow
    public KeyBinding keyBindBack;
    @Shadow
    public KeyBinding keyBindRight;
    @Shadow
    public KeyBinding keyBindJump;
    @Shadow
    public KeyBinding keyBindAttack;
    @Shadow
    public KeyBinding keyBindUseItem;
    @Shadow
    public KeyBinding keyBindSprint;
    @Shadow
    public KeyBinding keyBindSneak;
    @Shadow
    public int renderDistanceChunks;
    @Shadow
    public float gammaSetting;
    @Shadow
    public boolean showDebugInfo;
    @Shadow
    public boolean hideGUI;
    @Shadow
    public KeyBinding[] keyBindings;
    @Shadow
    public boolean fancyGraphics;
    @Shadow
    public float chatScale;
    @Shadow
    public List resourcePacks;
    @Shadow
    public boolean enableVsync;
    @Shadow
    public boolean useVbo;
    @Shadow
    public int limitFramerate;
    @Shadow
    public Minecraft mc;
    @Shadow
    public KeyBinding keyBindTogglePerspective;
    @Shadow
    public boolean smoothCamera;
    @Shadow
    public File optionsFile;

    @Shadow
    public abstract Set getModelParts();

    @Shadow
    public abstract void setOptionFloatValue(GameSettings.Options var1, float var2);

    @Override
    public void bridge$setThirdPersonView(int var1) {
        thirdPersonView = var1;
    }

    @Override
    public int bridge$getThirdPersonView() {
        return thirdPersonView;
    }

    @Override
    public KeyType bridge$getScreenshotKey() {
        return KeyboardImplementation.lIlIlIlIlIIlIIlIIllIIIIIl(this.keyBindScreenshot.getKeyCode());
    }

    @Override
    public KeyBindingBridge bridge$keyBindForward() {
        return (KeyBindingBridge) this.keyBindForward;
    }

    @Override
    public KeyBindingBridge bridge$keyBindLeft() {
        return (KeyBindingBridge) this.keyBindLeft;
    }

    @Override
    public KeyBindingBridge bridge$keyBindBack() {
        return (KeyBindingBridge) this.keyBindBack;
    }

    @Override
    public KeyBindingBridge bridge$keyBindRight() {
        return (KeyBindingBridge) this.keyBindRight;
    }

    @Override
    public KeyBindingBridge bridge$keyBindJump() {
        return (KeyBindingBridge) this.keyBindJump;
    }

    @Override
    public KeyBindingBridge bridge$keyBindAttack() {
        return (KeyBindingBridge) this.keyBindAttack;
    }

    @Override
    public KeyBindingBridge bridge$keyBindUseItem() {
        return (KeyBindingBridge) this.keyBindUseItem;
    }

    @Override
    public KeyBindingBridge bridge$keyBindSprint() {
        return (KeyBindingBridge) this.keyBindSprint;
    }

    @Override
    public KeyBindingBridge bridge$keyBindSneak() {
        return (KeyBindingBridge) this.keyBindSneak;
    }

    @Override
    public int bridge$getRenderDistance() {
        return renderDistanceChunks;
    }

    @Override
    public void bridge$setGamma(float var1) {
        gammaSetting = var1;
    }

    public void impl$setOptionValue(GameSettings.Options var1, int var2, CallbackInfo var3) {

    }

    public void impl$setOption(GameSettings.Options var1, float var2, CallbackInfo var3) {
        if (var1 == GameSettings.Options.GAMMA) {
            if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl()) {
                Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(false);
            }
            Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl(var2);
        }
    }

    @Override
    public boolean bridge$showDebugInfo() {
        return showDebugInfo;
    }

    @Override
    public Set bridge$getModelParts() {
        return getModelParts();
    }

    @Override
    public boolean bridge$isHideGui() {
        return hideGUI;
    }

    @Override
    public KeyBindingBridge[] bridge$getKeyBindings() {
        return (KeyBindingBridge[]) keyBindings;
    }

    @Override
    public float bridge$getChatScale() {
        return chatScale;
    }

    @Override
    public void bridge$setOptionFloatValue(int var1, float var2) {

    }

    @Override
    public void bridge$setKeyBindState(KeyType var1, boolean var2) {

    }

    @Override
    public void bridge$unpressAllKeys() {

    }

    @Override
    public List getResourcePacks() {
        return resourcePacks;
    }

    @Override
    public void bridge$setSmoothCamera(boolean var1) {
        smoothCamera = var1;
    }

    @Override
    public boolean bridge$getSmoothCamera() {
        return smoothCamera;
    }

    @Override
    public void bridge$setFancyGraphics(boolean var1) {
        fancyGraphics = var1;
    }

    @Override
    public boolean bridge$isFancyGraphics() {
        return fancyGraphics;
    }

    public void saveOptions(CallbackInfo var1) {

    }

    public void impl$onSave(CallbackInfo var1) {

    }

    public void impl$saveSetting(PrintWriter printWriter, String string) {
        LunarOptionsParser.IlllIIIIIIlllIlIIlllIlIIl(string);
        printWriter.println(string);
    }

    public void impl$saveOptionsOverwrite(CallbackInfo var1) {
        LunarOptionsParser.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    public void impl$loadOptionsOverwrite(CallbackInfo var1) {
        LunarOptionsParser.lIlIlIlIlIIlIIlIIllIIIIIl(this.optionsFile.getParentFile());
    }

    public String[] impl$loadOptions$split(String string, String string2) {
        if (string2.equals(":")) {
            if (string.startsWith("maxFps:")) {
                this.limitFramerate = Integer.parseInt(string.split(":")[1]);
                this.enableVsync = false;
                if (this.limitFramerate <= 0) {
                    this.limitFramerate = (int) GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
                    this.enableVsync = true;
                }
                this.bridge$updateVSync();
                return new String[] {"Invalid", "1"};
            }
            if (string.startsWith("enableVsync:")) {
                return new String[] {"Invalid", "1"};
            }
            if (string.startsWith("useVbo:")) {
                this.useVbo = true;
                return new String[] {"Invalid", "1"};
            }
        }
        return LunarOptionsParser.lIlIlIlIlIIlIIlIIllIIIIIl(string.split(string2));
    }

    @Override
    public KeyBindingBridge bridge$keyBindTogglePerspective() {
        return (KeyBindingBridge) this.keyBindTogglePerspective;
    }
}