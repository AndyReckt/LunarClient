package com.moonsworth.lunar.bridge.minecraft.tileentity;

import com.moonsworth.lunar.bridge.minecraft.block.BlockBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vec3iBridge;

public interface TileEntityBridge {
    Vec3iBridge bridge$getPos();

    BlockBridge bridge$getBlockType();
}
