package com.moonsworth.lunar.client.util;

import java.awt.*;
import java.net.URI;

public final class BrowserUtil {
    public static boolean lIlIlIlIlIIlIIlIIllIIIIIl(URI uRI) {
        Desktop desktop;
        Desktop desktop2 = desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uRI);
                return true;
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }

    public static boolean lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        try {
            return BrowserUtil.lIlIlIlIlIIlIIlIIllIIIIIl(new URI(string));
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public BrowserUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}