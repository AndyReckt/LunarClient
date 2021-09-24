package com.moonsworth.lunar.bridge.lunar.input;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;

/**
 * @author Decencies
 * @since 10/07/2021 17:14
 */
public interface KeyboardBridge {
    boolean lIlIlIlIlIIlIIlIIllIIIIIl(KeyType var1);

    String IlllIIIIIIlllIlIIlllIlIIl(KeyType var1);

    boolean lIlIlIlIlIIlIIlIIllIIIIIl();

    void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1);

    int lIllIlIIIlIIIIIIIlllIlIll(KeyType var1);

default boolean lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        if (!string.startsWith("KEY_")) {
            string = "KEY_" + string;
        }
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.valueOf(string));
    }

default KeyType IlllIIIIIIlllIlIIlllIlIIl(String string) {
        if (!string.startsWith("KEY_")) {
            string = "KEY_" + string;
        }
        return KeyType.valueOf(string);
    }
}