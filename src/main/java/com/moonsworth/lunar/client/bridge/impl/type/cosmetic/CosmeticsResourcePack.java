package com.moonsworth.lunar.client.bridge.impl.type.cosmetic;

import net.minecraft.client.resources.FolderResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.util.ChatComponentText;

import java.io.File;

public class CosmeticsResourcePack extends FolderResourcePack {
    public CosmeticsResourcePack(File var1) {
        super(var1);
    }

    public IMetadataSection getPackMetadata(IMetadataSerializer var1, String var2) {
        return var2.equals("pack") ? new PackMetadataSection(new ChatComponentText("Lunar Cosmetics"), 1) : null;
    }
}
