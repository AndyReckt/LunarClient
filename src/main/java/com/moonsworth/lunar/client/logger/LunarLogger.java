package com.moonsworth.lunar.client.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Decencies
 * @since 10/07/2021 12:30
 */
public class LunarLogger {
    public static final Logger lIlIlIlIlIIlIIlIIllIIIIIl = LogManager.getLogger("Lunar Client");

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(Object object, Object ... objectArray) {
        lIlIlIlIlIIlIIlIIllIIIIIl.debug("[LC] " + String.format(object.toString(), objectArray));
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string, Object object, Object ... objectArray) {
        lIlIlIlIlIIlIIlIIllIIIIIl.debug("[LC " + string + "] " + String.format(object.toString(), objectArray));
    }

    public static void IlllIIIIIIlllIlIIlllIlIIl(Object object, Object ... objectArray) {
        lIlIlIlIlIIlIIlIIllIIIIIl.info("[LC] " + String.format(object.toString(), objectArray));
    }

    public static void IlllIIIIIIlllIlIIlllIlIIl(String string, Object object, Object ... objectArray) {
        lIlIlIlIlIIlIIlIIllIIIIIl.info("[LC " + string + "] " + String.format(object.toString(), objectArray));
    }

    public static void lIllIlIIIlIIIIIIIlllIlIll(Object object, Object ... objectArray) {
        lIlIlIlIlIIlIIlIIllIIIIIl.warn("[LC] " + String.format(object.toString(), objectArray));
    }

    public static void lIllIlIIIlIIIIIIIlllIlIll(String string, Object object, Object ... objectArray) {
        lIlIlIlIlIIlIIlIIllIIIIIl.warn("[LC " + string + "] " + String.format(object.toString(), objectArray));
    }

    public static void llIlllIIIllllIIlllIllIIIl(Object object, Object ... objectArray) {
        lIlIlIlIlIIlIIlIIllIIIIIl.error("[LC] " + String.format(object.toString(), objectArray));
    }

    public static void llIlllIIIllllIIlllIllIIIl(String string, Object object, Object ... objectArray) {
        lIlIlIlIlIIlIIlIIllIIIIIl.error("[LC " + string + "] " + String.format(object.toString(), objectArray));
    }
}
