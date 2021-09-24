package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBookBridge;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.nbt.NBTTagList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GuiScreenBook.class)
public abstract class MixinGuiScreenBook implements GuiScreenBookBridge {
    @Shadow
    public int bookTotalPages;
    @Shadow
    public int currPage;
    @Shadow
    public NBTTagList bookPages;

    public MixinGuiScreenBook() {
    }

    public int bridge$getPageCount() {
        return bookTotalPages;
    }

    public int bridge$getCurrentPage() {
        return currPage;
    }

    public String bridge$getPageContents(int var1) {
        return bookPages.getStringTagAt(var1);
    }
}