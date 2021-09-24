package com.moonsworth.lunar.bridge.minecraft.client.entity.player;

import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;

import java.util.List;

public interface InventoryPlayerBridge {
    List<ItemStackBridge> bridge$getMainInventory();

    List bridge$getArmorInventory();
}
