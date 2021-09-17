package com.moonsworth.lunar.bridge.minecraft.util;

import com.moonsworth.lunar.bridge.minecraft.client.event.ClickEventBridge;
import com.moonsworth.lunar.bridge.minecraft.client.event.HoverEventBridge;

public interface ChatStyleBridge {
    public void bridge$setUnderlined(Boolean var1);

    public void bridge$setChatClickEvent(ClickEventBridge var1);

    public void bridge$setChatHoverEvent(HoverEventBridge var1);

    public HoverEventBridge bridge$getHoverEvent();

    public ClickEventBridge bridge$getClickEvent();
}
 