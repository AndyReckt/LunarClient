package com.moonsworth.lunar.client.notification;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;

public enum NotificationType {
    INFO("INFO", 0, "info"),
    SUCCESS("SUCCESS", 1, "success"),
    WARNING("WARNING", 2, "warning"),
    ERROR("ERROR", 3, "error");

    // todo remap above and replace with this#name()
    String nameProxy;

    public final ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI;

    NotificationType(final String s, final int n, final String s2) {
        this.nameProxy = s;
        this.llllIIlIIlIIlIIllIIlIIllI = Bridge.getInstance().initResourceLocation("lunar", "icons/notifications/" + s2 + "-24x24.png");
    }

    public ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }
}
