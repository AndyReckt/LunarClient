package com.moonsworth.lunar.client.util;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;

public final class PlayerNameUtil {
    public static boolean lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerBridge entityPlayerBridge) {
        if (entityPlayerBridge.bridge$getUniqueID().version() != 4) {
            return true;
        }
        if (entityPlayerBridge.bridge$getName().contains(" ")) {
            return true;
        }
        return entityPlayerBridge.bridge$getName().contains("§");
    }

    public PlayerNameUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
