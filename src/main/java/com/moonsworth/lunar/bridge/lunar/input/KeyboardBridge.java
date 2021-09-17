package com.moonsworth.lunar.bridge.lunar.input;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;

/**
 * @author Decencies
 * @since 10/07/2021 17:14
 */
public interface KeyboardBridge {
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(KeyType var1);

    public String IlllIIIIIIlllIlIIlllIlIIl(KeyType var1);

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl();

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1);

    public int lIllIlIIIlIIIIIIIlllIlIll(KeyType var1);

    default public boolean lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        if (!string.startsWith("KEY_")) {
            string = "KEY_" + string;
        }
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.valueOf(string));
    }

    default public KeyType IlllIIIIIIlllIlIIlllIlIIl(String string) {
        if (!string.startsWith("KEY_")) {
            string = "KEY_" + string;
        }
        return KeyType.valueOf(string);
    }
}