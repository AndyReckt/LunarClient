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
    GameProfile bridge$getGameProfile();

    PlayerCapabilitiesBridge bridge$getPlayerCapabilities();

    boolean bridge$isSpectator();

    void bridge$addChatMessage(IChatComponentBridge var1);

    boolean bridge$isBlocking();

    InventoryPlayerBridge bridge$getInventory();

    ItemStackBridge bridge$getCurrentEquippedItem();

    boolean bridge$isSprinting();

    String bridge$getName();

    FoodStatsBridge bridge$getFoodStats();

    @Override ItemStackBridge bridge$getHeldItem();

    void bridge$onEnchantmentCritical(EntityBridge var1);

    void bridge$preparePlayerToSpawn();

    ItemStackBridge bridge$getArmor(int var1);

    int bridge$getItemInUseCount();

    float bridge$getBedOrientationInDegrees();

    boolean bridge$isUsingItem();

    void bridge$setFlyToggleTimer(int var1);
}