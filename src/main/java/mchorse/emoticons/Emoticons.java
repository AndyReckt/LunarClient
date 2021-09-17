/*
 * Decompiled with CFR 0.150.
 */
package mchorse.emoticons;

import mchorse.emoticons.ClientProxy;
import mchorse.emoticons.common.emotes.Emotes;

public final class Emoticons {
    public static boolean debug = true;
    public static Emoticons instance;
    public static String config;

    public Emoticons() {
        instance = this;
        Emotes.register();
        new ClientProxy().init();
    }
}

