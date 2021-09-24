package com.moonsworth.lunar.bridge.minecraft.util;

import java.util.List;

public interface ChatComponentTextBridge
    extends ChatComponentStyleBridge {
    boolean isLc();

    void setLc(boolean var1);

    String bridge$getRawText();

    List bridge$getSiblings();
}