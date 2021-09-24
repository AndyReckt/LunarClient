package com.moonsworth.lunar.mixin.client;

import com.mojang.authlib.GameProfile;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityOtherPlayerMPBridge;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityOtherPlayerMP.class)
public abstract class MixinEntityOtherPlayerMP extends AbstractClientPlayer implements EntityOtherPlayerMPBridge {
    public MixinEntityOtherPlayerMP(World var1, GameProfile var2) {
        super(var1, var2);
    }

    public boolean attackEntityFrom(DamageSource var1, float var2) {
        return false; // todo.
    }
}
