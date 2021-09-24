package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.ItemModelMesherBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.BuiltInModelBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.IBakedModelBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.bridge.optifine.CustomItemsBridge;
import com.moonsworth.lunar.bridge.optifine.OptifineBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.hud.EventRenderGlint;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(RenderItem.class)
public abstract class MixinRenderItemzz implements RenderItemBridge {
    @Shadow
    public float zLevel;
    @Final
    @Shadow
    public ItemModelMesher itemModelMesher;
    @Final
    @Shadow
    private TextureManager textureManager;
    @Final
    @Shadow
    private static ResourceLocation RES_ITEM_GLINT;

    public boolean renderItemGui;

    @Shadow
    protected abstract void renderModel(IBakedModel var1, int var2);

    @Shadow
    public abstract void renderItemAndEffectIntoGUI(ItemStack var1, int var2, int var3);

    @Shadow
    public abstract void renderItemOverlays(FontRenderer var1, ItemStack var2, int var3, int var4);

    @Shadow
    public abstract void renderItem(ItemStack var1, IBakedModel var2);

    @Shadow
    protected abstract void renderModel(IBakedModel var1, ItemStack var2);

    @Shadow
    protected abstract void renderEffect(IBakedModel var1);

    public void bridge$renderModel(IBakedModelBridge var1, int var2) {
        renderModel((IBakedModel) var1, var2);
    }

    public Optional<ItemModelMesherBridge> bridge$getItemModelShaper() {
        return Optional.of((ItemModelMesherBridge) this.itemModelMesher);
    }

    public void bridge$renderItem(ItemStackBridge var1, BuiltInModelBridge var2) {
        this.renderItem((ItemStack) var1, (IBakedModel) var2);
    }

    public void bridge$setZLevel(float var1) {
        this.zLevel = var1;
    }

    public float bridge$getZLevel() {
        return this.zLevel;
    }

    public void bridge$renderItemAndEffectIntoGUI(ItemStackBridge var1, int var2, int var3) {
        this.renderItemAndEffectIntoGUI((ItemStack) var1, var2, var3);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void bridge$renderItemOverlayIntoGUI(ItemStackBridge var1, int var2, int var3) {
        this.renderItemOverlays(Minecraft.getMinecraft().fontRendererObj, (ItemStack) var1, var2, var3);
    }


    // todo
    //@Redirect(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/resources/model/IBakedModel;)V", at = @At(value = "INVOKE", target = ""))
    public void impl$renderItem(ItemStack var1, IBakedModel var2, CallbackInfo var3) {
        if (!var2.isBuiltInRenderer()) {
            GlStateManager.color(-0.5F, -0.5F, -0.5F);
            Optional<OptifineBridge> var4 = Bridge.lIllIlIIIlIIIIIIIlllIlIll();
            if (var4.isPresent()) {
                OptifineBridge var5 = var4.get();
                if (var5.getConfig().hasCustomItems()) {
                    Optional var6 = var5.getCustomItems();
                    if (var6.isPresent()) {
                        CustomItemsBridge var7 = (CustomItemsBridge) var6.get();
                        ResourceLocationBridge var8 = this.bridge$getModelLocation().orElse(null);
                        Optional<IBakedModel> var9 = var7.getCustomItemModel((ItemStackBridge) var1, (BuiltInModelBridge) var2, var8, false);
                        if (var9.isPresent()) {
                            var2 = var9.get();
                        }
                    }
                }
            }

            boolean var10 = Ref.getLC().lllllIllIllIllllIlIllllII().IIlIllIlllllllIIlIIIllIIl().IlllIIIIIIlllIlIIlllIlIIl() && this.renderItemGui && var1.getItem() != null && var1.getItem() instanceof ItemPotion && var1.hasEffect();
            if (!var10 || !(Boolean) Ref.getLC().lllllIllIllIllllIlIllllII().IIlIllIlllllllIIlIIIllIIl().lIllllIllIIlIIlIIIlIIIlII().llIlllIIIllllIIlllIllIIIl()) {
                this.renderModel(var2, var1);
            }

            if (var10) {
                GlStateManager.pushAttrib();
                this.renderPotion(var2, Ref.getLC().lllllIllIllIllllIlIllllII().IIlIllIlllllllIIlIIIllIIl().lIlIlIlIlIIlIIlIIllIIIIIl((ItemStackBridge) var1));
                GlStateManager.popAttrib();
            }

            if (var10 && Ref.getLC().lllllIllIllIllllIlIllllII().IIlIllIlllllllIIlIIIllIIl().lIllllIllIIlIIlIIIlIIIlII().llIlllIIIllllIIlllIllIIIl()) {
                this.renderModel(var2, var1);
            }

            IBakedModel finalVar = var2;
            boolean var11 = var4.flatMap(OptifineBridge::getCustomItems).map((var3x) -> var3x.renderCustomEffect(this, (ItemStackBridge) var1, (BuiltInModelBridge) finalVar)).orElse(false);
            if (!var10 && var1.hasEffect() && !var11) {
                EventRenderGlint.Where var13 = this.renderItemGui ? EventRenderGlint.Where.lIllIlIIIlIIIIIIIlllIlIll : EventRenderGlint.Where.IlllIIIIIIlllIlIIlllIlIIl;
                EventRenderGlint var12;
                EventBus.getInstance().call((var12 = new EventRenderGlint(var13, (IBakedModelBridge) var2, null, (ItemStackBridge) var1)));
                if (var12.isCancelled()) {
                    GlStateManager.popAttrib();
                    var3.cancel();
                    return;
                }

                this.renderEffect(var2);
            }

            GlStateManager.popAttrib();
            var3.cancel();
        }
    }

    @Inject(method = "renderItemIntoGUI", at = @At("HEAD"))
    public void impl$renderItemIntoGui$HEAD(ItemStack var1, int var2, int var3, CallbackInfo var4) {
        this.renderItemGui = true;
    }

    @Inject(method = "renderItemIntoGUI", at = @At("TAIL"))
    public void impl$renderItemIntoGui$TAIL(ItemStack var1, int var2, int var3, CallbackInfo var4) {
        this.renderItemGui = false;
    }

    public void renderPotion(IBakedModel var1, int var2) {
        GlStateManager.depthMask(false);
        GlStateManager.pushAttrib();
        GlStateManager.colorMaterial(768, 1);
        this.textureManager.bindTexture(RES_ITEM_GLINT);
        GlStateManager.matrixMode(5890);
        GlStateManager.pushAttrib();
        GlStateManager.translate(8.0F, 8.0F, 8.0F);
        float var3 = (float) (Minecraft.getSystemTime() % 3000L) / 3000.0F / 8.0F;
        GlStateManager.color(var3, 0.0F, 0.0F);
        GlStateManager.rotate(-50.0F, 0.0F, 0.0F, 1.0F);
        this.renderModel(var1, var2);
        GlStateManager.popAttrib();
        GlStateManager.pushAttrib();
        GlStateManager.translate(8.0F, 8.0F, 8.0F);
        float var4 = (float) (Minecraft.getSystemTime() % 4873L) / 4873.0F / 8.0F;
        GlStateManager.color(-var4, 0.0F, 0.0F);
        GlStateManager.rotate(10.0F, 0.0F, 0.0F, 1.0F);
        this.renderModel(var1, var2);
        GlStateManager.popAttrib();
        GlStateManager.matrixMode(5888);
        GlStateManager.colorMaterial(770, 771);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(true);
        this.textureManager.bindTexture(TextureMap.locationBlocksTexture);
    }
}