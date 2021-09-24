package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.hud.EventRenderGlint;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LayerArmorBase.class)
public abstract class MixinLayerArmorBasez {

    private static final ResourceLocation[] ARMOR_RESOURCE = new ResourceLocation[] {
        new ResourceLocation("textures/models/armor/leather_layer_1.png"),
        new ResourceLocation("textures/models/armor/leather_layer_2.png"),
        new ResourceLocation("textures/models/armor/chainmail_layer_1.png"),
        new ResourceLocation("textures/models/armor/chainmail_layer_2.png"),
        new ResourceLocation("textures/models/armor/iron_layer_1.png"),
        new ResourceLocation("textures/models/armor/iron_layer_2.png"),
        new ResourceLocation("textures/models/armor/diamond_layer_1.png"),
        new ResourceLocation("textures/models/armor/diamond_layer_2.png"),
        new ResourceLocation("textures/models/armor/gold_layer_1.png"),
        new ResourceLocation("textures/models/armor/gold_layer_2.png"),
        new ResourceLocation("textures/models/armor/leather_layer_1_overlay.png"),
        new ResourceLocation("textures/models/armor/leather_layer_2_overlay.png")
    };

    @Overwrite
    public boolean shouldCombineTextures() {
        return LunarClient.getInstance().lllllIllIllIllllIlIllllII().IlllllIlIIIlIIlIIllIIlIll().IlIllIIlIIlIIIllIllllIIll().isLegacy();
    }

    @Inject(method = "renderGlint", at = @At("HEAD"), cancellable = true)
    public void impl$eventRenderGlint(EntityLivingBase var1, ModelBase var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, CallbackInfo var10) {
        EventRenderGlint var11;
        EventBus.getInstance().call((var11 = new EventRenderGlint(EventRenderGlint.Where.lIlIlIlIlIIlIIlIIllIIIIIl, null, (EntityBridge)var1, null)));
        if (var11.isCancelled()) {
            var10.cancel();
        }
    }

    @Overwrite
    public ResourceLocation getArmorResource(ItemArmor var1, boolean var2) {
        return ARMOR_RESOURCE[(var1.renderIndex << 1) + (var2 ? 1 : 0)];
    }

    @Overwrite
    public ResourceLocation getArmorResource(ItemArmor var1, boolean var2, String var3) {
        return ARMOR_RESOURCE[(var1.renderIndex << 1) + (var2 && var3.equals("overlay") ? 11 : 10)];
    }

}