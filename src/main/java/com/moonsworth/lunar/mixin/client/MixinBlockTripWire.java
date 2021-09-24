package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockTripWire.class)
public abstract class MixinBlockTripWire extends Block {

    public MixinBlockTripWire(Material var1) {
        super(var1);
    }

    public int colorMultiplier(IBlockAccess blockAccess, BlockPos blockPos, int var3) {
        return LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIIlIlllIlIlIIIlllIIlIIII().llIlllIIIllllIIlllIllIIIl() ? 16711680 : super.colorMultiplier(blockAccess, blockPos, var3);
    }

}
