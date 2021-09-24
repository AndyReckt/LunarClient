package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.model.ModelRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ModelRenderer.class)
public abstract class MixinModelRendererz implements ModelRendererBridge {
    @Shadow
    public float offsetX;
    @Shadow
    public float offsetY;
    @Shadow
    public float offsetZ;
    @Shadow
    public float rotateAngleX;
    @Shadow
    public float rotateAngleY;
    @Shadow
    public float rotateAngleZ;
    @Shadow
    public float rotationPointX;
    @Shadow
    public float rotationPointY;
    @Shadow
    public float rotationPointZ;
    @Shadow
    public int textureOffsetX;
    @Shadow
    public int textureOffsetY;

    public MixinModelRendererz() {
    }

    @Shadow
    public abstract void render(float var1);

    @Shadow
    public abstract void postRender(float var1);

    public void bridge$setTextureOffsetX(int var1) {
        this.textureOffsetX = var1;
    }

    public void bridge$setTextureOffsetY(int var1) {
        this.textureOffsetY = var1;
    }

    public void bridge$setOffsetX(float var1) {
        this.offsetX = var1;
    }

    public void bridge$setOffsetY(float var1) {
        this.offsetY = var1;
    }

    public void bridge$setOffsetZ(float var1) {
        this.offsetZ = var1;
    }

    public float bridge$getOffsetX() {
        return this.offsetX;
    }

    public float bridge$getOffsetY() {
        return this.offsetY;
    }

    public float bridge$getOffsetZ() {
        return this.offsetZ;
    }

    public void bridge$setRotateAngleX(float var1) {
        this.rotateAngleX = var1;
    }

    public void bridge$setRotateAngleY(float var1) {
        this.rotateAngleY = var1;
    }

    public void bridge$setRotateAngleZ(float var1) {
        this.rotateAngleZ = var1;
    }

    public float bridge$getRotateAngleX() {
        return this.rotateAngleX;
    }

    public float bridge$getRotateAngleY() {
        return this.rotateAngleY;
    }

    public float bridge$getRotateAngleZ() {
        return this.rotateAngleZ;
    }

    public void bridge$setRotatePointX(float var1) {
        this.rotationPointX = var1;
    }

    public void bridge$setRotatePointY(float var1) {
        this.rotationPointY = var1;
    }

    public void bridge$setRotatePointZ(float var1) {
        this.rotationPointY = var1;
    }

    public float bridge$getRotatePointX() {
        return this.rotationPointX;
    }

    public float bridge$getRotatePointY() {
        return this.rotationPointY;
    }

    public float bridge$getRotatePointZ() {
        return this.rotationPointZ;
    }

    public void bridge$render(float var1, ResourceLocationBridge var2) {
        this.render(var1);
    }

    public void bridge$postRender(float n) {
        if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
            if (this.rotationPointX != 0.0f || this.rotationPointY != 0.0f || this.rotationPointZ != 0.0f) {
                GlStateManager.color(this.rotationPointX * n, this.rotationPointY * n, this.rotationPointZ * n);
            }
        } else {
            GlStateManager.color(this.rotationPointX * n, this.rotationPointY * n, this.rotationPointZ * n);
            if (this.rotateAngleZ != 0.0f) {
                GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
            }
            if (this.rotateAngleY != 0.0f) {
                GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
            }
            if (this.rotateAngleX != 0.0f) {
                GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
            }
        }
    }
}