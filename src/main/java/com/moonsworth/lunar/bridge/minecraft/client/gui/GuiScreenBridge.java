package com.moonsworth.lunar.bridge.minecraft.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;

import java.net.URI;
import java.util.List;

public interface GuiScreenBridge extends GuiBridge {
    default public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Class clazz) {
        boolean bl = clazz.isInstance(this);
        if (this instanceof WrappedGuiScreenBridge) {
            bl |= clazz.isInstance(((WrappedGuiScreenBridge)this).getCustomScreen());
        }
        return bl;
    }

    public void bridge$drawScreen(int var1, int var2, float var3);

    public void bridge$setWorldAndResolution(MinecraftBridge var1, int var2, int var3);

    public void bridge$mouseClicked(int var1, int var2, int var3);

    public void bridge$mouseReleased(int var1, int var2, int var3);

    public void bridge$onGuiClosed();

    public void bridge$updateScreen();

    public void bridge$keyTyped(char var1, KeyType var2);

    public void bridge$handleMouseInput();

    public void bridge$setClickedLinkURI(URI var1);

    default public boolean bridge$isControlsGui() {
        return false;
    }

    public boolean bridge$allowUserInput();

    default public void bridge$drawScrollableHoveringText(List list, int n, int n2) {
    }

    default public void bridge$drawScrollableHoveringText(MatrixStackBridge matrixStackBridge, List list, int n, int n2) {
        if (matrixStackBridge == null) {
            this.bridge$drawScrollableHoveringText(list, n, n2);
        }
    }

    public boolean bridge$doesGuiPauseGame();
}