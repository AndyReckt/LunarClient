package com.moonsworth.lunar.client.bridge.impl.type.blocks;

import com.moonsworth.lunar.bridge.minecraft.block.BlockBridge;
import com.moonsworth.lunar.bridge.minecraft.init.BlocksBridge;
import net.minecraft.init.Blocks;

public class BlocksImplementation implements BlocksBridge {
    public BlockBridge bridge$carpet() {
        return (BlockBridge) Blocks.carpet;
    }

    public BlockBridge bridge$end_portal() {
        return (BlockBridge)Blocks.end_portal;
    }

    public BlockBridge bridge$air() {
        return (BlockBridge)Blocks.air;
    }

    public BlockBridge bridge$stone() {
        return (BlockBridge)Blocks.stone;
    }

    public BlockBridge bridge$snow() {
        return (BlockBridge)Blocks.snow;
    }
}