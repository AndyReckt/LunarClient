package com.moonsworth.lunar.client.bridge.impl.type.glstatemanager;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.UnknownRenderEntityBridge;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RendererLivingEntityImplementation extends RendererLivingEntity<EntityLivingBase> implements UnknownRenderEntityBridge {
    public RendererLivingEntityImplementation(RenderManager var1, ModelBase var2, float var3) {
        super(var1, var2, var3);
    }

    public int getColorMultiplier(EntityLivingBase var1, float var2, float var3) {
        return 0;
    }

    @Override protected ResourceLocation getEntityTexture(EntityLivingBase entity) {
        return null;
    }

    public boolean bridge$canRenderName(EntityLivingBaseBridge var1) {
        return this.canRenderName((EntityLivingBase)var1);
    }

    public boolean bridge$setBrightness(EntityLivingBaseBridge var1, float var2) {
        return this.setBrightness((EntityLivingBase)var1, var2, true);
    }

    public void bridge$unsetBrightness() {
        this.unsetBrightness();
    }

    public void bridge$create() {
    }

}