package com.moonsworth.lunar.bridge.minecraft.client.entity.player;

import com.mojang.authlib.GameProfile;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.FoodStatsBridge;
import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;

/**
 * @author Decencies
 * @since 10/07/2021 14:10
 */
public interface EntityPlayerBridge extends EntityLivingBaseBridge {
    public GameProfile bridge$getGameProfile();

    public PlayerCapabilitiesBridge bridge$getPlayerCapabilities();

    public boolean bridge$isSpectator();

    public void bridge$addChatMessage(IChatComponentBridge var1);

    public boolean bridge$isBlocking();

    public InventoryPlayerBridge bridge$getInventory();

    public ItemStackBridge bridge$getCurrentEquippedItem();

    public boolean bridge$isSprinting();

    public String bridge$getName();

    public FoodStatsBridge bridge$getFoodStats();

    @Override
    public ItemStackBridge bridge$getHeldItem();

    public void bridge$onEnchantmentCritical(EntityBridge var1);

    public void bridge$preparePlayerToSpawn();

    public ItemStackBridge bridge$getArmor(int var1);

    public int bridge$getItemInUseCount();

    public float bridge$getBedOrientationInDegrees();

    public boolean bridge$isUsingItem();

    public void bridge$setFlyToggleTimer(int var1);
}