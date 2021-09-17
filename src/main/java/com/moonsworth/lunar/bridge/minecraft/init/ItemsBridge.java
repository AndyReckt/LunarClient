package com.moonsworth.lunar.bridge.minecraft.init;

import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;

public interface ItemsBridge {
    public ItemBridge bridge$carrotOnAStick();

    public ItemBridge bridge$fishingRod();

    public ItemBridge bridge$nameTag();

    public ItemBridge bridge$lead();

    public ItemBridge bridge$skull();

    public ItemBridge bridge$blazeRod();

    public ItemBridge bridge$bow();

    public ItemBridge bridge$potionItem();

    public ItemBridge bridge$stick();

    public ItemBridge bridge$arrow();

    public ItemBridge bridge$diamond_helmet();

    public ItemBridge bridge$diamond_chestplate();

    public ItemBridge bridge$diamond_leggings();

    public ItemBridge bridge$diamond_boots();

    public ItemBridge bridge$diamond_sword();

    public ItemBridge bridge$green_dye();

    default public ItemBridge bridge$golden_sword() {
        return this.bridge$getItem("golden_sword");
    }

    default public ItemBridge bridge$enderpearl() {
        return this.bridge$getItem("enderpearl");
    }

    public ItemBridge bridge$getItem(int var1);

    public ItemBridge bridge$getItem(String var1);

    public int bridge$getItemID(ItemBridge var1);

    public ItemBridge bridge$enchanted_book();

    public ItemBridge bridge$air();
}