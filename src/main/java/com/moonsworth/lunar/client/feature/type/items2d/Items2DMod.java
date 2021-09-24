package com.moonsworth.lunar.client.feature.type.items2d;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.entity.item.EntityItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderEntityItemBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.type.entity.render.RenderEntityItemEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.EnumSetting;
import com.moonsworth.lunar.client.setting.IEnumSetting;
import org.apache.commons.lang3.text.WordUtils;

import java.util.List;

public class Items2DMod extends ConfigurableFeature {
    public EnumSetting llllIIlIIlIIlIIllIIlIIllI;

    public Items2DMod() {
        super(false);
        if (Bridge.getInstance().getMinecraftVersion().ordinal() > MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl.ordinal()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderEntityItemEvent.class, (var0) -> {
                if (!var0.lIIIllIllIIllIlllIlIIlllI()) {
                    if (!Ref.getLC().lllllIllIllIllllIlIllllII().IllllllllllIlIIIlllIlllll().IlllIIIIIIlllIlIIlllIlIIl()) {
                        var0.setCancelled(true);
                        EntityItemBridge var1 = var0.llIlllIIIllllIIlllIllIIIl();
                        RenderEntityItemBridge var2 = Bridge.lIIIlllIIIIllllIlIIIlIIll();
                        if (Bridge.getMinecraftVersion().lIllIlIIIlIIIIIIIlllIlIll()) {
                            var2.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var0.lIllIlIIIlIIIIIIIlllIlIll(), var0.llllIIlIIlIIlIIllIIlIIllI(), var0.IlIlIlllllIlIIlIlIlllIlIl(), var0.llIIIIIIIllIIllIlIllIIIIl(), var0.lIlIlIlIlIIlIIlIIllIIIIIl(), var0.IlllllIlIIIlIIlIIllIIlIll());
                        } else {
                            GlStateManagerBridge var3 = Bridge.llIIIIIIIllIIllIlIllIIIIl();
                            var3.bridge$pushMatrix();
                            var2.renderItemSprite(var1, var0.llllIIlIIlIIlIIllIIlIIllI(), var0.IlIlIlllllIlIIlIlIlllIlIl(), var0.llIIIIIIIllIIllIlIllIIIIl(), var0.IlllllIlIIIlIIlIIllIIlIll());
                            var3.bridge$popMatrix();
                        }

                    }
                }
            });
        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llllIIlIIlIIlIIllIIlIIllI = new EnumSetting("renderingOptions", Items2DMod.RenderingOptions.lIlIlIlIlIIlIIlIIllIIIIIl));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("2D Items", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("items2d", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.NEW, ModuleCategory.MECHANIC), true, ImmutableList.of(MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl));
    }

    public EnumSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public enum RenderingOptions implements IEnumSetting {
        lIlIlIlIlIIlIIlIIllIIIIIl,
        IlllIIIIIIlllIlIIlllIlIIl;

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.name().toLowerCase();
        }

        public String toString() {
            return WordUtils.capitalize(this.name());
        }
    }
}
