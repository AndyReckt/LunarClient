package com.moonsworth.lunar.client.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Decencies
 * @since 10/07/2021 12:30
 */
public class LunarLogger {
    public static final Logger logger = LogManager.getLogger("Lunar Client");

    public static void debug(Object object, Object ... objectArray) {
        logger.debug("[LC] " + String.format(object.toString(), objectArray));
    }

    public static void debug(String string, Object object, Object ... objectArray) {
        logger.debug("[LC " + string + "] " + String.format(object.toString(), objectArray));
    }

    public static void info(Object object, Object ... objectArray) {
        logger.info("[LC] " + String.format(object.toString(), objectArray));
    }

    public static void info(String string, Object object, Object ... objectArray) {
        logger.info("[LC " + string + "] " + String.format(object.toString(), objectArray));
    }

    public static void warn(Object object, Object ... objectArray) {
        logger.warn("[LC] " + String.format(object.toString(), objectArray));
    }

    public static void warn(String string, Object object, Object ... objectArray) {
        logger.warn("[LC " + string + "] " + String.format(object.toString(), objectArray));
    }

    public static void error(Object object, Object ... objectArray) {
        logger.error("[LC] " + String.format(object.toString(), objectArray));
    }

    public static void error(String string, Object object, Object ... objectArray) {
        logger.error("[LC " + string + "] " + String.format(object.toString(), objectArray));
    }
}
