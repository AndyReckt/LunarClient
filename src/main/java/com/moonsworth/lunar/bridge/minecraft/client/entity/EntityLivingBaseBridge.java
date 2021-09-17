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
    public Optional bridge$getLastAttacker();

    public int bridge$getLastAttackerTime();

    public int bridge$getHurtTime();

    public int bridge$getDeathTime();

    public boolean bridge$isPotionActive(PotionBridge var1);

    public PotionEffectBridge bridge$getActivePotionEffect(PotionBridge var1);

    public List bridge$getActivePotionEffects();

    public boolean bridge$isOnLadder();

    public boolean bridge$isInWater();

    public void bridge$swingItem0();

    public float bridge$getRenderYawOffset();

    public float bridge$getPreviousRotationYawOffset();

    public void bridge$setRenderYawOffset(float var1);

    public float bridge$getRotationYawHead();

    public void bridge$setRotationYawHead(float var1);

    public float bridge$getPrevRotationYawHead();

    public void bridge$setPrevRotationYawHead(float var1);

    public float bridge$getPrevRenderYawOffset();

    public void IlllIIIIIIlllIlIIlllIlIIl(float var1);

    public ItemStackBridge bridge$getEquipmentInSlot(int var1);

    public float bridge$getHealth();

    public boolean bridge$isPlayerSleeping();

    public float bridge$getMoveForward();

    public ItemStackBridge bridge$getHeldItem();

    public boolean bridge$shouldAlwaysRenderNametag();

    public void bridge$setAlwaysRenderNameTag(boolean var1);

    public String bridge$getDisplayName();

    default public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return false;
    }

    default public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }
}
