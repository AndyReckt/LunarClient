package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.ItemModelMesherBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.BuiltInModelBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.IBakedModelBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemModelMesher.class)
public abstract class MixinItemModelMesherz implements ItemModelMesherBridge {

    @Shadow
    public abstract IBakedModel getItemModel(ItemStack var1);

    @Shadow
    protected abstract IBakedModel getItemModel(Item var1, int var2);

    public IBakedModelBridge bridge$getItemModel(ItemStackBridge var1) {
        return (IBakedModelBridge) this.getItemModel((ItemStack) var1);
    }

    public IBakedModelBridge bridge$getItemModel(ItemBridge var1, int var2) {
        return (IBakedModelBridge) this.getItemModel((Item) var1, var2);
    }
}