package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import net.minecraft.client.ClientBrandRetriever;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ClientBrandRetriever.class)
public abstract class MixinClientBrandRetriever {

    @Overwrite
    public static String getClientModName() {
        return "lunarclient:" + LunarClient.IlIlllIlIlllIllIIIIIIlllI();
    }

}
