package com.moonsworth.lunar.bridge.minecraft.util;

import com.moonsworth.lunar.bridge.minecraft.client.event.ClickEventBridge;
import com.moonsworth.lunar.bridge.minecraft.client.event.HoverEventBridge;

public interface ChatStyleBridge {
    void bridge$setUnderlined(Boolean var1);

    void bridge$setChatClickEvent(ClickEventBridge var1);

    void bridge$setChatHoverEvent(HoverEventBridge var1);

    HoverEventBridge bridge$getHoverEvent();

    ClickEventBridge bridge$getClickEvent();
}
