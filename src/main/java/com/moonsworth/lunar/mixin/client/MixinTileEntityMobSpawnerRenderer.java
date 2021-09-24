package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import net.minecraft.client.renderer.tileentity.TileEntityMobSpawnerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TileEntityMobSpawnerRenderer.class)
public abstract class MixinTileEntityMobSpawnerRenderer {

    @Redirect(method = "renderMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/tileentity/MobSpawnerBaseLogic;func_180612_a(Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;"))
    private static Entity impl$renderTileEntityAt(MobSpawnerBaseLogic mobSpawnerBaseLogic, World world) {
        final Entity entity = mobSpawnerBaseLogic.func_180612_a(world);
        final BlockPos spawnerPosition = mobSpawnerBaseLogic.getSpawnerPosition();
        if (!LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl((EntityBridge) entity, spawnerPosition.getX(), spawnerPosition.getY(), spawnerPosition.getZ())) {
            return null;
        }
        return entity;
    }
}
