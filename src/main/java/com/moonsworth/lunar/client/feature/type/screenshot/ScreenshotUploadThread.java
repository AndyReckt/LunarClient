package com.moonsworth.lunar.client.feature.type.screenshot;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiConfirmOpenLinkBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatComponentTextBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ScreenshotUploadThread extends Thread {
    public final File lIlIlIlIlIIlIIlIIllIIIIIl;
    public final boolean IlllIIIIIIlllIlIIlllIlIIl;
    public final boolean lIllIlIIIlIIIIIIIlllIlIll;

    public void run() {
        try {
            BufferedImage var1 = ImageIO.read(this.lIlIlIlIlIIlIIlIIllIIIIIl);
            ByteArrayOutputStream var2 = new ByteArrayOutputStream();
            ImageIO.write(var1, "png", var2);
            if (this.lIllIlIIIlIIIIIIIlllIlIll) {
                ScreenshotUploadThread.lIlIlIlIlIIlIIlIIllIIIIIl var17 = new ScreenshotUploadThread.lIlIlIlIlIIlIIlIIllIIIIIl(var1);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(var17, null);
                ChatComponentTextBridge var18 = Bridge.getInstance().initChatText("Copied screenshot.");
                Ref.getMinecraft().bridge$getGuiIngame().bridge$getChatGUI().bridge$printChatMessage(var18);
                return;
            }

            URL var3 = new URL("https://api.imgur.com/3/image");
            String var4 = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(Base64.encodeBase64String(var2.toByteArray()), "UTF-8");
            var4 = var4 + "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode("68f6709591c60ccd7e54fbcb23c01695ee0dd179", "UTF-8");
            URLConnection var5 = var3.openConnection();
            var5.setDoOutput(true);
            var5.setDoInput(true);
            var5.setRequestProperty("Authorization", "Client-ID 3195c1089c41047");
            var5.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStreamWriter var6 = new OutputStreamWriter(var5.getOutputStream());
            var6.write(var4);
            var6.flush();
            BufferedReader var7 = new BufferedReader(new InputStreamReader(var5.getInputStream()));
            StringBuilder var8 = new StringBuilder();

            String var9;
            while((var9 = var7.readLine()) != null) {
                var8.append(var9).append(System.lineSeparator());
            }

            var7.close();
            JsonObject var10 = LunarClient.GSON.fromJson(var8.toString(), JsonObject.class);
            String var11 = "https://i.imgur.com/" + var10.get("data").getAsJsonObject().get("id").getAsString() + ".png";
            URI var12 = new URI(var11);
            if (this.IlllIIIIIIlllIlIIlllIlIIl) {
                String var19 = "Look what I am up to %F0%9F%91%80";
                var19 = var19.replace(" ", "%20");
                String var14 = "https://twitter.com/intent/tweet?url=" + var12.toURL() + "&via=LunarClient&text=" + var19 + "";
                var12 = new URI(var14);
                GuiConfirmOpenLinkBridge var15 = Bridge.getInstance().initOpenLink(Ref.getMinecraft().bridge$getCurrentScreen(), var14, var12, 31102009, false);
                Ref.getMinecraft().bridge$getCurrentScreen().bridge$setClickedLinkURI(var12);
                Ref.getMinecraft().bridge$displayScreen(var15);
                return;
            }

            GuiConfirmOpenLinkBridge var13 = Bridge.getInstance().initOpenLink(Ref.getMinecraft().bridge$getCurrentScreen(), var11, var12, 31102009, false);
            Ref.getMinecraft().bridge$getCurrentScreen().bridge$setClickedLinkURI(var12);
            Ref.getMinecraft().bridge$displayScreen(var13);
        } catch (Exception var16) {
            var16.printStackTrace();
        }

    }

    public ScreenshotUploadThread(File var1, boolean var2, boolean var3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
        this.IlllIIIIIIlllIlIIlllIlIIl = var2;
        this.lIllIlIIIlIIIIIIIlllIlIll = var3;
    }

    public static class lIlIlIlIlIIlIIlIIllIIIIIl implements Transferable {
        public final Image lIlIlIlIlIIlIIlIIllIIIIIl;

        public lIlIlIlIlIIlIIlIIllIIIIIl(Image var1) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
        }

        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[] {DataFlavor.imageFlavor};
        }

        public boolean isDataFlavorSupported(DataFlavor var1) {
            return DataFlavor.imageFlavor == var1;
        }

        public Object getTransferData(DataFlavor var1) throws UnsupportedFlavorException {
            if (DataFlavor.imageFlavor != var1) {
                throw new UnsupportedFlavorException(var1);
            } else {
                return this.lIlIlIlIlIIlIIlIIllIIIIIl;
            }
        }
    }
}
