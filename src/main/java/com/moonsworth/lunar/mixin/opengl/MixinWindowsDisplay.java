package com.moonsworth.lunar.mixin.opengl;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public abstract class MixinWindowsDisplay {
    public static int WM_XBUTTONDOWN;
    public static int XBUTTON1;

    public MixinWindowsDisplay() {
    }

    public abstract void handleMouseButton(int var1, int var2, long var3);

    public void impl$doHandleMessage(long var1, int var3, long var4, long var6, long var8, CallbackInfoReturnable var10) {
    }
}
