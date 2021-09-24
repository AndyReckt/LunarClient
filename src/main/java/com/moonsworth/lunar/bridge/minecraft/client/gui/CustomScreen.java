package com.moonsworth.lunar.bridge.minecraft.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;

public interface CustomScreen {
    int lIlIlIlIlIIlIIlIIllIIIIIl();

    int mouseReleased();

    void drawScreen(int var1, int var2, float var3);

    void setWorldAndResolution(MinecraftBridge var1, int var2, int var3);

    void mouseClicked(int var1, int var2, int var3);

    void mouseReleased(int var1, int var2, int var3);

    void onGuiClosed();

    void updateScreen();

    void keyTyped(char var1, KeyType var2);

    void llllIIlIIlIIlIIllIIlIIllI();

    void handleMouseScrollDelta(int var1);

    boolean IlIlIlllllIlIIlIlIlllIlIl();
}