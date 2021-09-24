package com.moonsworth.lunar.client.bridge.impl.type.otherutil;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.enchantment.EnchantmentHelperBridge;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;

public class EnchantmentHelperImplementation implements EnchantmentHelperBridge {
    public float bridge$getEnchantmentModifierLiving(EntityLivingBaseBridge var1, EntityLivingBaseBridge var2) {
        return EnchantmentHelper.getModifierForCreature(((EntityLivingBase)var1).getHeldItem(), ((EntityLivingBase)var2).getCreatureAttribute());
    }
}
