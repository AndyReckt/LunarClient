package com.moonsworth.lunar.client.bridge.impl.type.mouse;

import com.moonsworth.lunar.bridge.lunar.input.MouseBridge;
import org.lwjgl.input.Mouse;

public class MouseImplementation implements MouseBridge {
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(int var1) {
        return Mouse.isButtonDown(var1);
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return Mouse.getX();
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return Mouse.getY();
    }
}