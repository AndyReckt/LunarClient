package com.moonsworth.lunar.client.feature.type.togglesneak;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.PlayerCapabilitiesBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.GameSettingsBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.state.KeyState;
import com.moonsworth.lunar.client.event.type.entity.EntityPlayerSPUpdateEvent;
import com.moonsworth.lunar.client.event.type.gui.GuiPostOpenEvent;
import com.moonsworth.lunar.client.event.type.input.KeyPressEvent;
import com.moonsworth.lunar.client.event.type.input.MouseActionEvent;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;

import java.text.DecimalFormat;
import java.util.List;

public class ToggleSneakMod extends DraggableHudMod {
    public final DecimalFormat IllllllllllIlIIIlllIlllll = new DecimalFormat("#.00");
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;
    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;
    public NumberSetting IIlIllIlllllllIIlIIIllIIl;
    public BooleanSetting lllllIllIlIIlIIlIIIlllIlI;
    public BooleanSetting lIIlIlllIlIlIIIlllIIlIIII;
    public BooleanSetting llIllIlIllIlllIllIIIIllII;
    public ColorSetting IllIIIlllIIIlIlllIlIIlIII;
    public boolean IIlIllIlIIllIIlIlIllllllI;
    public boolean lIIIlllIIIIllllIlIIIlIIll;
    public Float llIIIlIllIIIIlIIIlIlIllIl = null;
    public boolean llllIlIllllIlIlIIIllIlIlI;
    public boolean IlIllIIlIIlIIIllIllllIIll;
    public boolean lIllllIllIIlIIlIIIlIIIlII;
    public final GameSettingsBridge lIlIlIIIIIIllIlIIIIllIIII = Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getGameSettings();
    public long lIIlIIIIIIlIIlIIllIlIIlII;
    public long IlIIlIIlIIlIIllIIIllIIllI;
    public boolean IIlIlIIIllIIllllIllllIlIl;

    public ToggleSneakMod() {
        super(true, HudModPosition.TOP_LEFT);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyPressEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiPostOpenEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerSPUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(MouseActionEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        if (Bridge.getMinecraftVersion() == MinecraftVersion.lIllIlIIIlIIIIIIIlllIlIll) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        }

    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(10.0F, 10.0F);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent var1) {
        if (!this.IIlIllIlIIllIIlIlIllllllI) {
            this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSprint().bridge$setKeyBindState(this.llllIlIllllIlIlIIIllIlIlI);
            this.IIlIllIlIIllIIlIlIllllllI = true;
        }

        if (!this.lIIIlllIIIIllllIlIIIlIIll) {
            this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSneak().bridge$setKeyBindState(this.IlIllIIlIIlIIIllIllllIIll);
            this.lIIIlllIIIIllllIlIIIlIIll = true;
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerSPUpdateEvent var1) {
        EntityPlayerSPBridge var2 = this.mc.bridge$getPlayer();
        PlayerCapabilitiesBridge var3 = var2.bridge$getPlayerCapabilities();
        if (var3.bridge$isFlying()) {
            this.lIllllIllIIlIIlIIIlIIIlII = true;
        } else if (this.lIllllIllIIlIIlIIIlIIIlII) {
            if (this.llllIlIllllIlIlIIIllIlIlI) {
                this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSprint().bridge$setKeyBindState(this.llllIlIllllIlIlIIIllIlIlI);
            }

            this.lIllllIllIIlIIlIIIlIIIlII = false;
        }

        boolean var4 = var3.bridge$isCreativeMode() || this.mc.bridge$getPlayerController().bridge$isSpectator();
        boolean var5 = Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.mc.bridge$getGameSettings().bridge$keyBindSprint().bridge$getKey());
        boolean var6 = var3.bridge$isFlying();
        if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() && var4 && var6 && var5) {
            if (this.llIIIlIllIIIIlIIIlIlIllIl == null) {
                this.llIIIlIllIIIIlIIIlIlIllIl = var3.bridge$getFlySpeed();
                var3.bridge$setFlySpeed(0.05F * (float)(Integer)this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl());
            }

            if (var2.bridge$getMovementInput().bridge$isSneaking()) {
                var2.bridge$setMotionY(var2.bridge$getMotionY() - 0.15D * (double)(Integer)this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl());
            }

            if (var2.bridge$getMovementInput().bridge$isJumping()) {
                var2.bridge$setMotionY(var2.bridge$getMotionY() + 0.15D * (double)(Integer)this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl());
            }
        }

        if (this.llIIIlIllIIIIlIIIlIlIllIl != null && (!var5 || !var6)) {
            var3.bridge$setFlySpeed(this.llIIIlIllIIIIlIIIlIlIllIl);
            this.llIIIlIllIIIIlIIIlIlIllIl = null;
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiPostOpenEvent var1) {
        if (this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl()) {
            this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSprint().bridge$setKeyBindState(this.llllIlIllllIlIlIIIllIlIlI);
        }

        if (this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl() && this.IlIlIIllllllIIlIIllIIllIl()) {
            this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSneak().bridge$setKeyBindState(this.IlIllIIlIIlIIIllIllllIIll);
        }

        if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() != null && !(var1.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof WrappedGuiScreenBridge) && this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSneak().bridge$isKeyDown() && !this.llIllllIlIIlIIIIllIllIIll()) {
            this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSneak().bridge$setKeyBindState(false);
        }

    }

    public boolean IlIlIIllllllIIlIIllIIllIl() {
        return this.IlIllIIlIIlIIIllIllllIIll != this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSneak().bridge$isKeyDown();
    }

    public boolean IIllIIlIIIlIlIlIlIIllIllI() {
        return this.llllIlIllllIlIlIIIllIlIlI != this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSprint().bridge$isKeyDown();
    }

    public boolean llIllllIlIIlIIIIllIllIIll() {
        return this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl() && (Ref.getLC().llllIIlIIlIIlIIllIIlIIllI().llIIIIIIIllIIllIlIllIIIIl() == null || !Ref.getLC().llllIIlIIlIIlIIllIIlIIllI().llIIIIIIIllIIllIlIllIIIIl().toLowerCase().contains("hypixel.net"));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(MouseActionEvent var1) {
        if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() != -1) {
            KeyType var2 = KeyType.valueOf("KEY_MOUSE" + (var1.lIlIlIlIlIIlIIlIIllIIIIIl() + 1));
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl(var1.IlllIIIIIIlllIlIIlllIlIIl(), var2)) {
                var1.cancel();
            }
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeyPressEvent var1) {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl(var1.IlllIIIIIIlllIlIIlllIlIIl(), var1.lIlIlIlIlIIlIIlIIllIIIIIl())) {
            var1.cancel();
        }

    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(KeyState var1, KeyType var2) {
        if (Ref.getWorld() == null) {
            return false;
        } else if (Ref.llIIIlllIIlllIllllIlIllIl() != null) {
            this.lIIlIIIIIIlIIlIIllIlIIlII = 0L;
            this.IlIIlIIlIIlIIllIIIllIIllI = 0L;
            this.IIlIlIIIllIIllllIllllIlIl = false;
            return false;
        } else if (var1 == KeyState.DOWN) {
            if (var2 == this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSneak().bridge$getKey() && this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) {
                this.lIIlIIIIIIlIIlIIllIlIIlII = System.currentTimeMillis();
            }

            if (var2 == this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSprint().bridge$getKey() && this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl()) {
                this.IlIIlIIlIIlIIllIIIllIIllI = System.currentTimeMillis();
                this.IIlIlIIIllIIllllIllllIlIl = true;
            }

            return false;
        } else {
            if (var2 == this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSprint().bridge$getKey() && this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl()) {
                this.IIlIlIIIllIIllllIllllIlIl = false;
            }

            if (!Ref.getPlayer().bridge$getPlayerCapabilities().bridge$isFlying() && var2 == this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSneak().bridge$getKey() && this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl() && System.currentTimeMillis() - this.lIIlIIIIIIlIIlIIllIlIIlII <= 200L) {
                this.IlIllIIlIIlIIIllIllllIIll = !this.IlIllIIlIIlIIIllIllllIIll;
                if (Bridge.getMinecraftVersion() == MinecraftVersion.lIllIlIIIlIIIIIIIlllIlIll) {
                    this.lIIIlllIIIIllllIlIIIlIIll = false;
                } else {
                    this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSneak().bridge$setKeyBindState(this.IlIllIIlIIlIIIllIllllIIll);
                }

                return true;
            } else if (!this.mc.bridge$getPlayer().bridge$getPlayerCapabilities().bridge$isFlying() && var2 == this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSprint().bridge$getKey() && this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl() && System.currentTimeMillis() - this.IlIIlIIlIIlIIllIIIllIIllI <= 400L) {
                this.llllIlIllllIlIlIIIllIlIlI = !this.llllIlIllllIlIlIIIllIlIlI;
                if (Bridge.getMinecraftVersion() == MinecraftVersion.lIllIlIIIlIIIIIIIlllIlIll) {
                    this.IIlIllIlIIllIIlIlIllllllI = false;
                } else {
                    this.lIlIlIIIIIIllIlIIIIllIIII.bridge$keyBindSprint().bridge$setKeyBindState(this.llllIlIllllIlIlIIIllIlIlI);
                }

                return true;
            } else {
                return false;
            }
        }
    }

    public void IlIllIIlIIlIIIllIllllIIll() {
        this.llllIlIllllIlIlIIIllIlIlI = this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl();
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl()) {
            String var4 = (Ref.getPlayer() != null && !this.lIllIllIllIIIlllIIIlllllI().isEmpty() ? this.lIllIllIllIIIlllIIIlllllI() : "[Sprinting (Toggled)]").trim();
            float var5 = Ref.getFontRenderer().bridge$getStringWidth(var4);
            this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var2, var3, this.lllllIllIlIIlIIlIIIlllIlI.llIlllIIIllllIIlllIllIIIl());
            this.IlllIIIIIIlllIlIIlllIlIIl(var5, (float)Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl()) {
            float var4 = Ref.getFontRenderer().bridge$getStringWidth(this.lIllIllIllIIIlllIIIlllllI());
            this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIllIllIIIlllIIIlllllI(), var2, var3, this.lllllIllIlIIlIIlIIIlllIlI.llIlllIIIllllIIlllIllIIIl());
            this.IlllIIIIIIlllIlIIlllIlIIl(var4, (float)Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
    }

    public String lIllIllIllIIIlllIIIlllllI() {
        String var1 = "";
        boolean var2 = this.mc.bridge$getPlayer().bridge$getPlayerCapabilities().bridge$isFlying();
        boolean var3 = this.mc.bridge$getPlayer().bridge$isRiding();
        boolean var4 = Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.mc.bridge$getGameSettings().bridge$keyBindSneak().bridge$getKey());
        boolean var5 = Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.mc.bridge$getGameSettings().bridge$keyBindSprint().bridge$getKey());
        if (var2) {
            if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() && var5) {
                var1 = var1 + "[Flying (" + this.IllllllllllIlIIIlllIlllll.format(this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl()) + "x boost)]";
            } else {
                var1 = var1 + "[Flying]";
            }
        }

        if (var3) {
            var1 = var1 + "[Riding]";
        }

        if (this.mc.bridge$getGameSettings().bridge$keyBindSneak().bridge$isKeyDown()) {
            if (var2) {
                var1 = var1 + " [Descending]";
            } else if (var3) {
                var1 = var1 + " [Dismounting]";
            } else if (var4 && !this.IlIllIIlIIlIIIllIllllIIll) {
                var1 = var1 + "[Sneaking (Key Held)]";
            } else {
                var1 = var1 + "[Sneaking (Toggled)]";
            }
        } else if (this.mc.bridge$getGameSettings().bridge$keyBindSprint().bridge$isKeyDown()) {
            if (!var2 && !var3) {
                boolean var6 = !(Boolean)this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl();
                if (var5 && !this.llllIlIllllIlIlIIIllIlIlI) {
                    var1 = var1 + "[Sprinting (Key Held)]";
                } else if (this.IIlIlIIIllIIllllIllllIlIl) {
                    var1 = var1 + "[Sprinting (Key Held)]";
                } else if (var6) {
                    var1 = var1 + "[Sprinting (Vanilla)]";
                } else {
                    var1 = var1 + "[Sprinting (Toggled)]";
                }
            }
        } else if (!var2 && Ref.getPlayer().bridge$isSprinting()) {
            var1 = var1 + "[Sprinting (Vanilla)]";
        }

        return var1;
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(new SettingLabel("generalOptions"), this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting("toggle_sprint", true), this.lIlIIIIIIlIIIllllIllIIlII = new BooleanSetting("toggle_sneak", false), this.llIllIlIllIlllIllIIIIllII = new BooleanSetting("double_tap", true), this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("toggle_sneak_container", false, () -> {
            return !(Boolean)this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl();
        }), new SettingLabel("flyBoostOptions"), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("fly_boost", true), this.IIlIllIlllllllIIlIIIllIIl = new NumberSetting("boost_amnt", 4, 2, 8), new SettingLabel("colorOptions"), this.IllIIIlllIIIlIlllIlIIlIII = new ColorSetting("text", -1), this.lllllIllIlIIlIIlIIIlllIlI = new BooleanSetting("shadow", true), this.lIIlIlllIlIlIIIlllIIlIIII = new BooleanSetting("showHudText", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("[Sprinting (Toggled)]", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("toggleSneak", ImmutableList.of(ModuleCategory.HUD, ModuleCategory.ALL));
    }

    public DecimalFormat IIIIIIIIIIIIIIIllllIIlIIl() {
        return this.IllllllllllIlIIIlllIlllll;
    }

    public BooleanSetting llIIIIllIlIIlIlIIlllIllIl() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public BooleanSetting IIIIlIllIllIlIIIIIlIlIlIl() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public BooleanSetting IlIlIlIlIIIlIIlIIlllIllIl() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public BooleanSetting lIIIlIllllIIlIIlIIlIIIIlI() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public NumberSetting lllllIlIllIlIlllIIIlIIlIl() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public BooleanSetting IllIlIIllIIlllIIllIlIlIII() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }

    public BooleanSetting IlIlllIIIIIllIIllIllIIlll() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public BooleanSetting IllllIIllllIllIIIIlllllII() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public ColorSetting IIllllIIlllIlIIlIIlllIlII() {
        return this.IllIIIlllIIIlIlllIlIIlIII;
    }

    public boolean IllIlIIlllIIlIIllIIIIIIIl() {
        return this.IIlIllIlIIllIIlIlIllllllI;
    }

    public boolean IllIllIllIIlIlllIIlllIIll() {
        return this.lIIIlllIIIIllllIlIIIlIIll;
    }

    public Float IlIIIIlllIllllIlIlIllIlII() {
        return this.llIIIlIllIIIIlIIIlIlIllIl;
    }

    public boolean lIlIIIlIIlIIIlIIIlllIlIII() {
        return this.llllIlIllllIlIlIIIllIlIlI;
    }

    public boolean IlIllIIlIIlIlIIlIIlIllIll() {
        return this.IlIllIIlIIlIIIllIllllIIll;
    }

    public boolean lIlllllIIlllIllIIlIIlIlll() {
        return this.lIllllIllIIlIIlIIIlIIIlII;
    }

    public GameSettingsBridge lIIlIIllIlIIlIIllIIIIlIIl() {
        return this.lIlIlIIIIIIllIlIIIIllIIII;
    }

    public long IllIIlllIllIlllllIlIllIll() {
        return this.lIIlIIIIIIlIIlIIllIlIIlII;
    }

    public long IIIlIlIllIlIlIIIIIlIllIII() {
        return this.IlIIlIIlIIlIIllIIIllIIllI;
    }

    public boolean IIlllIllIIlllllIllllllIII() {
        return this.IIlIlIIIllIIllllIllllIlIl;
    }
}