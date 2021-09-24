package com.moonsworth.lunar.bridge.minecraft.client.resources.I18n;

import com.moonsworth.lunar.LunarClient;

/**
 * @author Decencies
 * @since 09/07/2021 23:35
 */
public interface I18nBridge {
    String getLanguagePath();

default String get(String string, Object... objectArray) {
        return LunarClient.getInstance().lIlIIlIlllIIlIIIlIlIlIllI().lIlIlIlIlIIlIIlIIllIIIIIl(this, string, objectArray);
    }
}
