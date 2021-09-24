package com.moonsworth.lunar.mixin.client.util;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.util.MovingObjectPositionBridge;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @author Decencies
 * @since 12/07/2021 23:54
 */
@Mixin(MovingObjectPosition.class)
public abstract class MixinMovingObjectPosition implements MovingObjectPositionBridge {

    @Shadow public MovingObjectPosition.MovingObjectType typeOfHit;
    @Shadow public Entity entityHit;
    private boolean border;

    @Override public EntityBridge bridge$getEntityHit() {
        return (EntityBridge)this.entityHit;
    }

    @Override public boolean bridge$isTypeOfHit(com.moonsworth.lunar.bridge.minecraft.util.MovingObjectPosition var1) {
        return var1.ordinal() == this.typeOfHit.ordinal();
    }

    @Override public void bridge$border() {
        this.border = true;
    }

    @Override public boolean bridge$isBorder() {
        return border;
    }
}
