package com.moonsworth.lunar.client.feature.type.zoom;

import com.google.common.collect.ImmutableList;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.bridge.optifine.OptifineBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.gui.GuiCloseEvent;
import com.moonsworth.lunar.client.event.type.gui.GuiResizeEvent;
import com.moonsworth.lunar.client.event.type.hud.FOVChangeEvent;
import com.moonsworth.lunar.client.event.type.input.ScrollIngameEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;
import com.moonsworth.lunar.client.util.MathHelperUtil;

import java.util.List;

public class ZoomMod extends ConfigurableFeature {
    public float llllIIlIIlIIlIIllIIlIIllI = 1.0F;
    public float IlIlIlllllIlIIlIlIlllIlIl;
    public float llIIIIIIIllIIllIlIllIIIIl;
    public boolean lIIIllIllIIllIlllIlIIlllI = false;
    public boolean IlllllIlIIIlIIlIIllIIlIll;
    public boolean llIIlIlIIIllIlIlIlIIlIIll = false;
    public LunarKeybindSetting llIIIlllIIlllIllllIlIllIl;
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;
    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;
    public NumberSetting IIlIllIlllllllIIlIIIllIIl;
    public boolean lIIlIlllIlIlIIIlllIIlIIII;

    public ZoomMod() {
        super(true);
        this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (!this.lIIlIlllIlIlIIIlllIIlIIII) {
                this.lIIlIlllIlIlIIIlllIIlIIII = true;
            } else {
                this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(0L);
            }

        }).lIlIlIlIlIIlIIlIIllIIIIIl((var1) -> {
            if (!(Boolean) this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() || !var1) {
                this.lIIlIlllIlIlIIIlllIIlIIII = false;
            }
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ScrollIngameEvent.class, (var1) -> {
            if (this.lIIIllIllIIllIlllIlIIlllI && this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl()) {
                if (Ref.llIIIlllIIlllIllllIlIllIl() == null) {
                    int var2 = var1.lIlIlIlIlIIlIIlIIllIIIIIl() < 0.0D ? -1 : 1;
                    this.llllIIlIIlIIlIIllIIlIIllI = (float) MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl((double) this.llllIIlIIlIIlIIllIIlIIllI + (double) var2 * 0.5D, 1.4D / (double) (Integer) this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl(), 10.0D);
                    Ref.getMinecraft().bridge$getRenderGlobal().bridge$setDisplayListEntitiesDirty(true);
                    var1.setCancelled(true);
                }
            }
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, (var1) -> {
            if (this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) {
                float var2 = 1.0F;
                double var3 = 1.0D / (double) this.IlIllIIlIIlIIIllIllllIIll();
                if (this.lIIIllIllIIllIlllIlIIlllI) {
                    var2 = (float) var3;
                }

                this.llIIIIIIIllIIllIlIllIIIIl = this.IlIlIlllllIlIIlIlIlllIlIl;
                this.IlIlIlllllIlIIlIlIlllIlIl += (var2 - this.IlIlIlllllIlIIlIlIlllIlIl) * 0.75F;
            }

        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiResizeEvent.class, (var1) -> {
            this.lIIlIlllIlIlIIIlllIIlIIII = false;
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiCloseEvent.class, (var1) -> {
            if (this.lIIIllIllIIllIlllIlIIlllI && !this.lIIlIlllIlIlIIIlllIIlIIII) {
                this.IlIlIlllllIlIIlIlIlllIlIl = 1.0F;
            }

        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(FOVChangeEvent.class, (var1) -> {
            if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() == FOVChangeEvent.Result.CONSTANT) {
                Ref.getMinecraft().bridge$getGameSettings().bridge$getZoomKey().ifPresent((var0) -> {
                    var0.bridge$setKeyBindState(false);
                });
            } else if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() == FOVChangeEvent.Result.RETURN && Ref.llIIIlllIIlllIllllIlIllIl() == null) {
                boolean var2 = Bridge.lIllIlIIIlIIIIIIIlllIlIll().isPresent() && Bridge.lIllIlIIIlIIIIIIIlllIlIll().get().getConfig().isZooming();
                if (this.lIIlIlllIlIlIIIlllIIlIIII) {
                    if (!this.lIIIllIllIIllIlllIlIIlllI) {
                        this.lIIIllIllIIllIlllIlIIlllI = true;
                        this.llIIlIlIIIllIlIlIlIIlIIll = false;
                        if (!var2) {
                            this.IlllllIlIIIlIIlIIllIIlIll = Ref.getMinecraft().bridge$getGameSettings().bridge$getSmoothCamera();
                        }

                        Ref.getMinecraft().bridge$getRenderGlobal().bridge$setDisplayListEntitiesDirty(true);
                    }

                    if (this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl() && !var2) {
                        Ref.getMinecraft().bridge$getGameSettings().bridge$setSmoothCamera(true);
                    }

                    float var3 = var1.IlllIIIIIIlllIlIIlllIlIIl();
                    if (Bridge.lIllIlIIIlIIIIIIIlllIlIll().isPresent() && Bridge.lIllIlIIIlIIIIIIIlllIlIll().get().getConfig().isZooming()) {
                        var3 *= 4.0F;
                    }

                    if (this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) {
                        var3 *= MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIIIIIIllIIllIlIllIIIIl, this.IlIlIlllllIlIIlIlIlllIlIl, var1.lIllIlIIIlIIIIIIIlllIlIll());
                    } else {
                        var3 /= this.IlIllIIlIIlIIIllIllllIIll();
                    }

                    var1.lIlIlIlIlIIlIIlIIllIIIIIl(var3);
                } else {
                    if (this.lIIIllIllIIllIlllIlIIlllI) {
                        this.lIIIllIllIIllIlllIlIIlllI = false;
                        if (!var2) {
                            Ref.getMinecraft().bridge$getGameSettings().bridge$setSmoothCamera(this.IlllllIlIIIlIIlIIllIIlIll);
                        }

                        Ref.getMinecraft().bridge$getRenderGlobal().bridge$setDisplayListEntitiesDirty(true);
                        this.llllIIlIIlIIlIIllIIlIIllI = 1.0F;
                    }

                    if (this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) {
                        if (this.IlIlIlllllIlIIlIlIlllIlIl != 1.0F) {
                            var1.lIlIlIlIlIIlIIlIIllIIIIIl(var1.IlllIIIIIIlllIlIIlllIlIIl() * MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIIIIIIllIIllIlIllIIIIl, this.IlIlIlllllIlIIlIlIlllIlIl, var1.lIllIlIIIlIIIIIIIlllIlIll()));
                            Ref.getMinecraft().bridge$getRenderGlobal().bridge$setDisplayListEntitiesDirty(true);
                        } else if (!this.llIIlIlIIIllIlIlIlIIlIIll) {
                            Ref.getMinecraft().bridge$getRenderGlobal().bridge$setDisplayListEntitiesDirty(true);
                            this.llIIlIlIIIllIlIlIlIIlIIll = true;
                        }
                    }
                }

            }
        });
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(
                   this.llIIIlllIIlllIllllIlIllIl = new LunarKeybindSetting(this, "zoom", Ref.getMinecraft().bridge$getGameSettings().bridge$getZoomKey().isPresent() ? Ref.getMinecraft().bridge$getGameSettings().bridge$getZoomKey().get().bridge$getKey() : KeyType.KEY_Z, false),
                   this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("toggleKeyZoom", false),
                   this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting("smoothCamera", true),
                   this.lIlIIIIIIlIIIllllIllIIlII = new BooleanSetting("smoothZoom", true),
                   this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("variable_zoom", false),
                   this.IIlIllIlllllllIIlIIIllIIl = new NumberSetting("zoomDivisor", 4, 2, 10)
               );
    }

    public float IlIllIIlIIlIIIllIllllIIll() {
        return (float) (Integer) this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl() * (this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl() ? this.llllIIlIIlIIlIIllIIlIIllI : 1.0F);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Zoom", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("zoom", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.NEW));
    }
}
