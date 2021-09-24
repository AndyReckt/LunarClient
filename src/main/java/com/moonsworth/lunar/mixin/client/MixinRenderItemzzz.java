package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.optifine.CustomColorsBridge;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderItem.class)
public abstract class MixinRenderItemzzz {
    public boolean nextModel;

    public MixinRenderItemzzz() {
    }

    public void impl$renderItem(ItemStack var1, IBakedModel var2, CallbackInfo var3) {
    }

    public void impl$renderModel(IBakedModel var1, int var2, ItemStack var3, CallbackInfo var4) {
    }

    public void impl$renderItemOverlayIntoGUI(RenderItem var1, WorldRenderer var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, FontRenderer var11, ItemStack var12, int var13, int var14, String var15) {
//        int var16 = (int)Math.round(13.0D - (double)var12.getItemDamage() * 13.0D / (double)var12.getMaxDamage());
//        int var17 = (int)Math.round(255.0D - (double)var12.getItemDamage() * 255.0D / (double)var12.getMaxDamage());
//        ReturnValue var18 = new ReturnValue();
//        ItemHook.getDurabilityForDisplay(var12, var18);
//        if (var18.isCancelled()) {
//            var16 = (int)Math.round(13.0D - (Double)var18.getReturnValue() * 13.0D);
//            var17 = (int)Math.round(255.0D - (Double)var18.getReturnValue() * 255.0D);
//        }
//
//        if (var5 == 12) {
//            var7 = (255 - var17) / 4;
//        } else if (var6 == 1) {
//            var5 = var16;
//            var7 = 255 - var17;
//            var8 = var17;
//            var9 = 0;
//            Optional var20 = Bridge.lIllIlIIIlIIIIIIIlllIlIll().flatMap(OptifineBridge::getCustomColors).map((var1x) -> {
//                return var1x.getDurabilityColor(var17);
//            });
//            if (var20.isPresent()) {
//                int var21 = (Integer)var20.get();
//                if (var21 >= 0) {
//                    var7 = var21 >> 16 & 255;
//                    var8 = var21 >> 8 & 255;
//                    var9 = var21 >> 0 & 255;
//                }
//            }
//        }
//
//        var1.draw(var2, var3, var4, var5, var6, var7, var8, var9, var10);
    }

//    // $FF: synthetic method
//    public static Integer lambda$impl$renderItemOverlayIntoGUI$0(int var0, CustomColorsBridge var1) {
//    }
}