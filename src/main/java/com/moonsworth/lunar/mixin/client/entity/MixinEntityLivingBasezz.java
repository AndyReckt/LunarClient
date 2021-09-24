package com.moonsworth.lunar.mixin.client.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public abstract class MixinEntityLivingBasezz extends Entity implements EntityLivingBaseBridge {
    public MixinEntityLivingBasezz(World var1) {
        super(var1);
    }
}
