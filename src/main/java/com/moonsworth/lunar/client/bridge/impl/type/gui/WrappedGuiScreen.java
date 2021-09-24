package com.moonsworth.lunar.client.bridge.impl.type.gui;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.CustomScreen;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.client.bridge.impl.type.keyboard.KeyboardImplementation;
import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.gui.CloseCustomScreenEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Mouse;

import java.io.IOException;
import java.net.URI;

public class WrappedGuiScreen extends GuiScreen implements WrappedGuiScreenBridge {
    public final CustomScreen customScreen;

    public void bridge$drawScreen(int var1, int var2, float var3) {
        this.drawScreen(var1, var2, var3);
    }

    public void bridge$setWorldAndResolution(MinecraftBridge var1, int var2, int var3) {
        this.setWorldAndResolution((Minecraft)var1, var2, var3);
    }

    public void bridge$mouseClicked(int var1, int var2, int var3) {
        this.mouseClicked(var1, var2, var3);
    }

    public void bridge$mouseReleased(int var1, int var2, int var3) {
        this.mouseReleased(var1, var2, var3);
    }

    public void bridge$onGuiClosed() {
        this.onGuiClosed();
    }

    public void bridge$updateScreen() {
        this.updateScreen();
    }

    public void bridge$keyTyped(char var1, KeyType var2) throws IOException {
        this.keyTyped(var1, KeyboardImplementation.llIlllIIIllllIIlllIllIIIl(var2));
    }

    public void bridge$handleMouseInput() throws IOException {
        this.handleMouseInput();
    }

    public void bridge$setClickedLinkURI(URI var1) {
    }

    public boolean bridge$allowUserInput() {
        return false;
    }

    public boolean bridge$doesGuiPauseGame() {
        return true;
    }

    public void drawScreen(int var1, int var2, float var3) {
        this.customScreen.drawScreen(var1, var2, var3);
    }

    public void setWorldAndResolution(Minecraft var1, int var2, int var3) {
        super.setWorldAndResolution(var1, var2, var3);
        this.customScreen.setWorldAndResolution((MinecraftBridge)var1, var2, var3);
    }

    public void mouseClicked(int var1, int var2, int var3) {
        this.customScreen.mouseClicked(var1, var2, var3);
    }

    public void mouseReleased(int var1, int var2, int var3) {
        this.customScreen.mouseReleased(var1, var2, var3);
    }

    public void onGuiClosed() {
        this.customScreen.onGuiClosed();
    }

    public void updateScreen() {
        this.customScreen.updateScreen();
    }

    public void keyTyped(char var1, int var2) throws IOException {
        if (var2 == 1) {
            CloseCustomScreenEvent var3 = new CloseCustomScreenEvent(this.customScreen);
            EventBus.getInstance().call((Event)var3);
            if (!var3.isCancelled()) {
                super.keyTyped(var1, var2);
            }
        } else {
            super.keyTyped(var1, var2);
        }

        this.customScreen.keyTyped(var1, KeyboardImplementation.lIlIlIlIlIIlIIlIIllIIIIIl(var2));
    }

    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int var1 = Mouse.getEventDWheel();
        this.customScreen.handleMouseScrollDelta(var1);
    }

    public CustomScreen getCustomScreen() {
        return this.customScreen;
    }

    public WrappedGuiScreen(CustomScreen var1) {
        this.customScreen = var1;
    }
}
