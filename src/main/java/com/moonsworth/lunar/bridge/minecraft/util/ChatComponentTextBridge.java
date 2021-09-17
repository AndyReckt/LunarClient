package com.moonsworth.lunar.bridge.minecraft.util;

import java.util.List;

public interface ChatComponentTextBridge
extends ChatComponentStyleBridge {
    public boolean isLc();

    public void setLc(boolean var1);

    public String bridge$getRawText();

    public List bridge$getSiblings();
}