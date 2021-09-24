package com.moonsworth.lunar.client.bridge.impl.type.items;

import com.moonsworth.lunar.bridge.minecraft.init.ItemsBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ItemsImplementation implements ItemsBridge {
    public ItemBridge bridge$carrotOnAStick() {
        return (ItemBridge) Items.carrot_on_a_stick;
    }

    public ItemBridge bridge$fishingRod() {
        return (ItemBridge)Items.fishing_rod;
    }

    public ItemBridge bridge$nameTag() {
        return (ItemBridge)Items.name_tag;
    }

    public ItemBridge bridge$lead() {
        return (ItemBridge)Items.lead;
    }

    public ItemBridge bridge$skull() {
        return (ItemBridge)Items.skull;
    }

    public ItemBridge bridge$blazeRod() {
        return (ItemBridge)Items.blaze_rod;
    }

    public ItemBridge bridge$bow() {
        return (ItemBridge)Items.bow;
    }

    public ItemBridge bridge$potionItem() {
        return (ItemBridge)Items.potionitem;
    }

    public ItemBridge bridge$stick() {
        return (ItemBridge)Items.stick;
    }

    public ItemBridge bridge$arrow() {
        return (ItemBridge)Items.arrow;
    }

    public ItemBridge bridge$diamond_helmet() {
        return (ItemBridge)Items.diamond_helmet;
    }

    public ItemBridge bridge$diamond_chestplate() {
        return (ItemBridge)Items.diamond_chestplate;
    }

    public ItemBridge bridge$diamond_leggings() {
        return (ItemBridge)Items.diamond_leggings;
    }

    public ItemBridge bridge$diamond_boots() {
        return (ItemBridge)Items.diamond_boots;
    }

    public ItemBridge bridge$diamond_sword() {
        return (ItemBridge)Items.diamond_sword;
    }

    public ItemBridge bridge$green_dye() {
        return (ItemBridge)Items.dye;
    }

    public ItemBridge bridge$getItem(int var1) {
        return (ItemBridge)Item.getItemById(var1);
    }

    public ItemBridge bridge$getItem(String var1) {
        return (ItemBridge)Item.getByNameOrId(var1);
    }

    public int bridge$getItemID(ItemBridge var1) {
        return Item.getIdFromItem((Item)var1);
    }

    public ItemBridge bridge$golden_sword() {
        return (ItemBridge)Items.golden_sword;
    }

    public ItemBridge bridge$enderpearl() {
        return (ItemBridge)Items.ender_pearl;
    }

    public ItemBridge bridge$enchanted_book() {
        return (ItemBridge)Items.enchanted_book;
    }

    public ItemBridge bridge$air() {
        return null;
    }
}