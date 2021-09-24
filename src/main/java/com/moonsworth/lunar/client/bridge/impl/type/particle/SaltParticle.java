package com.moonsworth.lunar.client.bridge.impl.type.particle;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.particle.EntityFXBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.WorldRendererBridge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SaltParticle extends EntityFX implements EntityFXBridge {
    public static final ResourceLocation PARTICLES = new ResourceLocation("lunar", "emoticons/particles.png");
    public static ModelRenderer salt;

    public SaltParticle(World var1, double var2, double var4, double var6, double var8) {
        super(var1, var2, var4, var6);
        this.particleGravity = 0.5F;
        this.particleMaxAge = 20 + this.rand.nextInt(10);
        this.motionX = this.rand.nextFloat() * 0.05F;
        this.motionZ = this.rand.nextFloat() * 0.05F;
        this.motionY = var8;
        if (salt == null) {
            ModelBase var10 = new ModelBase() {
            };
            var10.textureWidth = 64;
            var10.textureHeight = 64;
            salt = new ModelRenderer(var10, 0, 0);
            salt.addBox(-0.25F, -0.25F, 0.25F, 1, 1, 1);
        }

    }

    public void renderParticle(WorldRenderer var1, Entity var2, float var3, float var4, float var5, float var6, float var7, float var8) {
        float var9 = (float) (this.prevPosX + (this.posX - this.prevPosX) * (double) var3 - interpPosX);
        float var10 = (float) (this.prevPosY + (this.posY - this.prevPosY) * (double) var3 - interpPosY);
        float var11 = (float) (this.prevPosZ + (this.posZ - this.prevPosZ) * (double) var3 - interpPosZ);
        int var12 = this.particleMaxAge - this.particleAge;
        float var13 = 0.5F * (var12 < 5 ? (float) var12 / 5.0F : 1.0F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(PARTICLES);
        int var14 = var2.getBrightnessForRender(var3);

        // todo
//        if (var2.c()) {
//            var14 = 15728880;
//        }

        int var15 = var14 % 65536;
        int var16 = var14 / 65536;
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) var15, (float) var16);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.pushAttrib();
        GlStateManager.color(var9, var10, var11);
        GlStateManager.translate(var13, var13, var13);
        RenderHelper.enableStandardItemLighting();
        salt.render(0.0625F);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.popAttrib();
    }

    public int getFXLayer() {
        return 3;
    }

    public void bridge$renderParticle(WorldRendererBridge var1, EntityBridge var2, float var3, float var4, float var5, float var6, float var7, float var8) {
        renderParticle((WorldRenderer) var1, (Entity) var2, var3, var4, var5, var6, var7, var8);
    }
}
