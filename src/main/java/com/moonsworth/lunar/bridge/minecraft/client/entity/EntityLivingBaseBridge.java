package com.moonsworth.lunar.bridge.minecraft.client.entity;

import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.potion.PotionBridge;
import com.moonsworth.lunar.bridge.minecraft.potion.PotionEffectBridge;

import java.util.List;
import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 14:11
 */
public interface EntityLivingBaseBridge extends EntityBridge {
    Optional bridge$getLastAttacker();

    int bridge$getLastAttackerTime();

    int bridge$getHurtTime();

    int bridge$getDeathTime();

    boolean bridge$isPotionActive(PotionBridge var1);

    PotionEffectBridge bridge$getActivePotionEffect(PotionBridge var1);

    List bridge$getActivePotionEffects();

    boolean bridge$isOnLadder();

    boolean bridge$isInWater();

    void bridge$swingItem0();

    float bridge$getRenderYawOffset();

    float bridge$getPreviousRotationYawOffset();

    void bridge$setRenderYawOffset(float var1);

    float bridge$getRotationYawHead();

    void bridge$setRotationYawHead(float var1);

    float bridge$getPrevRotationYawHead();

    void bridge$setPrevRotationYawHead(float var1);

    float bridge$getPrevRenderYawOffset();

    void IlllIIIIIIlllIlIIlllIlIIl(float var1);

    ItemStackBridge bridge$getEquipmentInSlot(int var1);

    float bridge$getHealth();

    boolean bridge$isPlayerSleeping();

    float bridge$getMoveForward();

    ItemStackBridge bridge$getHeldItem();

    boolean bridge$shouldAlwaysRenderNametag();

    void bridge$setAlwaysRenderNameTag(boolean var1);

    String bridge$getDisplayName();

default boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return false;
    }

default boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }
}
