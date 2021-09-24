package com.moonsworth.lunar.client.bridge.impl.type.model;

import mchorse.emoticons.common.emotes.model.ModelPopcornParticle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelPopcornParticleImplementation implements ModelPopcornParticle {
    public ModelRenderer kernel;

    public ModelPopcornParticleImplementation(int var1, int var2) {
        ModelBase var3 = new ModelBase() {
        };
        var3.textureWidth = 64;
        var3.textureHeight = 64;
        this.kernel = new ModelRenderer(var3, var1, var2);
        this.kernel.addBox(-0.5F, -0.5F, 0.5F, 1, 1, 1);
    }

    public void render(float var1) {
        this.kernel.render(var1);
    }
}
