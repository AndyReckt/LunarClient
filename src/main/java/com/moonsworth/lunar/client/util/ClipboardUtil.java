package com.moonsworth.lunar.client.util;

import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ClipboardUtil {
    public static String lIlIlIlIlIIlIIlIIllIIIIIl() {
        try {
            Transferable var0 = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (var0 != null && var0.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String)var0.getTransferData(DataFlavor.stringFlavor);
            }
        } catch (Exception var1) {
        }

        return "";
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String var0) {
        if (!StringUtils.isEmpty(var0)) {
            try {
                StringSelection var1 = new StringSelection(var0);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(var1, null);
            } catch (Exception var2) {
            }
        }

    }
}
