package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityFX.class)
public abstract class MixinEntityFX extends Entity {

    public MixinEntityFX(World var1) {
        super(var1);
    }

    public void moveEntity(double var1, double var3, double var5) {
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
    }

}