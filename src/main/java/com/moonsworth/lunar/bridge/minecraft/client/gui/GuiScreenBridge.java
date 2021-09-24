package com.moonsworth.lunar.bridge.minecraft.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public interface GuiScreenBridge extends GuiBridge {
default boolean lIlIlIlIlIIlIIlIIllIIIIIl(Class clazz) {
        boolean bl = clazz.isInstance(this);
        if (this instanceof WrappedGuiScreenBridge) {
            bl |= clazz.isInstance(((WrappedGuiScreenBridge)this).getCustomScreen());
        }
        return bl;
    }

    void bridge$drawScreen(int var1, int var2, float var3);

    void bridge$setWorldAndResolution(MinecraftBridge var1, int var2, int var3);

    void bridge$mouseClicked(int var1, int var2, int var3);

    void bridge$mouseReleased(int var1, int var2, int var3);

    void bridge$onGuiClosed();

    void bridge$updateScreen();

    void bridge$keyTyped(char var1, KeyType var2) throws IOException;

    void bridge$handleMouseInput() throws IOException;

    void bridge$setClickedLinkURI(URI var1);

default boolean bridge$isControlsGui() {
        return false;
    }

    boolean bridge$allowUserInput();

default void bridge$drawScrollableHoveringText(List<IChatComponentBridge> list, int n, int n2) {
    }

default void bridge$drawScrollableHoveringText(MatrixStackBridge matrixStackBridge, List<IChatComponentBridge> list, int n, int n2) {
        if (matrixStackBridge == null) {
            this.bridge$drawScrollableHoveringText(list, n, n2);
        }
    }

    boolean bridge$doesGuiPauseGame();
}