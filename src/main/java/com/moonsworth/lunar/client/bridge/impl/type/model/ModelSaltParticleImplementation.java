package com.moonsworth.lunar.client.bridge.impl.type.model;

import mchorse.emoticons.common.emotes.model.ModelSaltParticle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelSaltParticleImplementation implements ModelSaltParticle {
    public ModelRenderer salt;

    public ModelSaltParticleImplementation() {
        ModelBase var1 = new ModelBase() {
        };
        var1.textureWidth = 64;
        var1.textureHeight = 64;
        this.salt = new ModelRenderer(var1, 0, 0);
        this.salt.addBox(-0.25F, -0.25F, 0.25F, 1, 1, 1);
    }

    public void render(float partialTicks) {
        this.salt.render(partialTicks);
    }
}
