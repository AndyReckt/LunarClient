package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.ItemRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.block.model.ItemCameraTransformsBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.hud.RenderItemFirstPersonEvent;
import com.moonsworth.lunar.client.feature.type.freelook.FreelookMod;
import com.moonsworth.lunar.client.feature.type.freelook.FreelookPerspective;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class MixinItemRendererz implements ItemRendererBridge {

    @Shadow
    private ItemStack itemToRender;

    @Final
    @Shadow
    private Minecraft mc;

    @Shadow
    private float equippedProgress;

    @Shadow
    private float prevEquippedProgress;

    @Shadow
    protected abstract void transformFirstPersonItem(float var1, float var2);

    @Shadow
    protected abstract void doBlockTransformations();

    @Shadow
    protected abstract void doBowTransformations(float var1, AbstractClientPlayer var2);

    @Shadow
    public abstract void renderItem(EntityLivingBase var1, ItemStack var2, ItemCameraTransforms.TransformType var3);

    @Inject(method = "performDrinking", at = @At("HEAD"), cancellable = true)
    public void impl$performDrinking(AbstractClientPlayer var1, float var2, CallbackInfo var3) {
        if (LunarClient.getInstance().lllllIllIllIllllIlIllllII().IlllllIlIIIlIIlIIllIIlIll().IlIIlIIlIIlIIllIIIllIIllI().isLegacy()) {
            final float n2 = var1.getItemInUseCount() - var2 + 1.0f;
            final float n3 = 1.0f - n2 / this.itemToRender.getMaxItemUseDuration();
            final float n4 = 1.0f - n3;
            final float n5 = n4 * n4 * n4;
            final float n6 = n5 * n5 * n5;
            final float n7 = 1.0f - n6 * n6 * n6;
            GL11.glTranslatef(0.0f, MathHelper.sin(MathHelper.sqrt_float(n2 / 4.0f * 3.1415927f) * 0.1f) * (float) ((n3 > 0.2) ? 1 : 0), 0.0f);
            GL11.glTranslatef(n7 * 0.66f, -n7 * 0.5f, 0.0f);
            GL11.glRotatef(n7 * 90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(n7 * 5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(n7 * 28.0f, 0.0f, 0.0f, 1.0f);
            var3.cancel();
        }
    }

    @Inject(method = "renderItemInFirstPerson", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/ItemRenderer;performDrinking(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V", shift = At.Shift.BEFORE), cancellable = true)
    public void impl$renderItemInFirstPersonDrink(float var1, CallbackInfo var2) {
        if (LunarClient.getInstance().lllllIllIllIllllIlIllllII().IlllllIlIIIlIIlIIllIIlIll().lllllIIIIlIlllIllIIIlIIlI().isLegacy()) {
            float var3 = 1.0F - (this.prevEquippedProgress + (this.equippedProgress - this.prevEquippedProgress) * var1);
            this.transformFirstPersonItem(var3, Ref.getLC().lllllIllIllIllllIlIllllII().IlllllIlIIIlIIlIIllIIlIll().lllllIIIIlIlllIllIIIlIIlI().isLegacy() ? this.mc.thePlayer.getSwingProgress(var1) : 0.0F);
            this.finishrenderItemInFirstPerson(var1);
            var2.cancel();
        }
    }

    public void impl$rotateWithPlayerRotations$rotateYaw(EntityPlayerSP var1, float var2, CallbackInfo var3) {
        FreelookMod var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI();
        if (var4.IlIIlIIlIIlIIllIIIllIIllI() && var4.lIllllIllIIlIIlIIIlIIIlII().llIlllIIIllllIIlllIllIIIl() == FreelookPerspective.FIRST) {
            float var5 = var4.IlIIlIIlIIlIIllIIIllIIllI() ? var1.rotationYaw - var4.lIlIlIIIIIIllIlIIIIllIIII() : 0.0F;
            float var6 = var1.prevRenderArmYaw + (var1.renderArmYaw - var1.prevRenderArmYaw) * var2 + var5 * 10.0F;
            GlStateManager.rotate((var1.rotationYaw - var6) * 0.1F, 0.0F, 1.0F, 0.0F);
            var3.cancel();
        }
    }

    @Inject(method = "renderFireInFirstPerson", at = @At("HEAD"), cancellable = true)
    public void impl$renderItemInFirstPersonBlock(float var1, CallbackInfo var2) {
        if (LunarClient.getInstance().lllllIllIllIllllIlIllllII().IlllllIlIIIlIIlIIllIIlIll().lIllllIllIIlIIlIIIlIIIlII().isLegacy()) {
            this.transformFirstPersonItem(0.2F, this.mc.thePlayer.getSwingProgress(var1));
            this.doBlockTransformations();
            GlStateManager.color(-0.55F, 0.2F, 0.1F);
            GlStateManager.translate(0.85F, 0.85F, 0.85F);
            GlStateManager.rotate(1.0F, 0.0F, 0.0F, -1.0F);
            GlStateManager.rotate(1.0F, 0.25F, 0.0F, 0.0F);
            GlStateManager.rotate(2.0F, 0.0F, 2.0F, 0.0F);
            this.finishrenderItemInFirstPerson(var1);
            var2.cancel();
        }
    }

    public void impl$renderItemInFirstPersonBow(float var1, CallbackInfo var2) {
        if (LunarClient.getInstance().lllllIllIllIllllIlIllllII().IlllllIlIIIlIIlIIllIIlIll().IIlIlIIIllIIllllIllllIlIl().isLegacy()) {
            float var3 = 1.0F - (this.prevEquippedProgress + (this.equippedProgress - this.prevEquippedProgress) * var1);
            this.transformFirstPersonItem(var3, this.mc.thePlayer.getSwingProgress(var1));
            GlStateManager.translate(-0.2D, 0.0D, -0.175D);
            GlStateManager.rotate(1.0F, 0.0F, 0.0F, -1.25F);
            this.doBowTransformations(var1, this.mc.thePlayer);
            this.finishrenderItemInFirstPerson(var1);
            var2.cancel();
        }
    }

    public void impl$onRenderItemInFirstPerson(float var1, CallbackInfo var2) {
        EventBus.getInstance().call((new RenderItemFirstPersonEvent((ItemBridge) this.itemToRender.getItem())));
    }

    public void finishrenderItemInFirstPerson(float var1) {
        this.renderItem(this.mc.thePlayer, this.itemToRender, ItemCameraTransforms.TransformType.FIRST_PERSON);
        GlStateManager.popAttrib();
        GlStateManager.pushAttrib();
        RenderHelper.disableStandardItemLighting();
    }

    public void bridge$renderItem(EntityLivingBaseBridge var1, ItemStackBridge var2, ItemCameraTransformsBridge.lIlIlIlIlIIlIIlIIllIIIIIl var3) {
    }
}