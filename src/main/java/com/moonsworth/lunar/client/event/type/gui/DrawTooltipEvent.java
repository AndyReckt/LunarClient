package com.moonsworth.lunar.client.event.type.gui;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

import java.util.List;
import java.util.Optional;

public class DrawTooltipEvent
extends CancellableEvent {
    public GuiScreenBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public List IlllIIIIIIlllIlIIlllIlIIl;
    public int lIllIlIIIlIIIIIIIlllIlIll;
    public int llIlllIIIllllIIlllIllIIIl;
    public ItemStackBridge llllIIlIIlIIlIIllIIlIIllI;
    public MatrixStackBridge IlIlIlllllIlIIlIlIlllIlIl;

    public DrawTooltipEvent(GuiScreenBridge guiScreenBridge, MatrixStackBridge matrixStackBridge, ItemStackBridge itemStackBridge, List list, int n, int n2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = guiScreenBridge;
        this.IlIlIlllllIlIIlIlIlllIlIl = matrixStackBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = list;
        this.lIllIlIIIlIIIIIIIlllIlIll = n;
        this.llIlllIIIllllIIlllIllIIIl = n2;
        this.llllIIlIIlIIlIIllIIlIIllI = itemStackBridge;
    }

    public DrawTooltipEvent(GuiScreenBridge guiScreenBridge, List list, int n, int n2) {
        this(guiScreenBridge, list, n, n2, null);
    }

    public DrawTooltipEvent(GuiScreenBridge guiScreenBridge, List list, int n, int n2, ItemStackBridge itemStackBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = guiScreenBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = list;
        this.lIllIlIIIlIIIIIIIlllIlIll = n;
        this.llIlllIIIllllIIlllIllIIIl = n2;
        this.llllIIlIIlIIlIIllIIlIIllI = itemStackBridge;
    }

    public Optional<ItemStackBridge> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return Optional.ofNullable(this.llllIIlIIlIIlIIllIIlIIllI);
    }

    public Optional<MatrixStackBridge> IlllIIIIIIlllIlIIlllIlIIl() {
        return Optional.ofNullable(this.IlIlIlllllIlIIlIlIlllIlIl);
    }

    public GuiScreenBridge lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public List llIlllIIIllllIIlllIllIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public int IlIlIlllllIlIIlIlIlllIlIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiScreenBridge guiScreenBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = guiScreenBridge;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List list) {
        this.IlllIIIIIIlllIlIIlllIlIIl = list;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.lIllIlIIIlIIIIIIIlllIlIll = n;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.llIlllIIIllllIIlllIllIIIl = n;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ItemStackBridge itemStackBridge) {
        this.llllIIlIIlIIlIIllIIlIIllI = itemStackBridge;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(MatrixStackBridge matrixStackBridge) {
        this.IlIlIlllllIlIIlIlIlllIlIl = matrixStackBridge;
    }
}