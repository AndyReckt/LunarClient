package com.moonsworth.lunar.bridge.minecraft.init;

import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;

public interface ItemsBridge {
    ItemBridge bridge$carrotOnAStick();

    ItemBridge bridge$fishingRod();

    ItemBridge bridge$nameTag();

    ItemBridge bridge$lead();

    ItemBridge bridge$skull();

    ItemBridge bridge$blazeRod();

    ItemBridge bridge$bow();

    ItemBridge bridge$potionItem();

    ItemBridge bridge$stick();

    ItemBridge bridge$arrow();

    ItemBridge bridge$diamond_helmet();

    ItemBridge bridge$diamond_chestplate();

    ItemBridge bridge$diamond_leggings();

    ItemBridge bridge$diamond_boots();

    ItemBridge bridge$diamond_sword();

    ItemBridge bridge$green_dye();

default ItemBridge bridge$golden_sword() {
        return this.bridge$getItem("golden_sword");
    }

default ItemBridge bridge$enderpearl() {
        return this.bridge$getItem("enderpearl");
    }

    ItemBridge bridge$getItem(int var1);

    ItemBridge bridge$getItem(String var1);

    int bridge$getItemID(ItemBridge var1);

    ItemBridge bridge$enchanted_book();

    ItemBridge bridge$air();
}