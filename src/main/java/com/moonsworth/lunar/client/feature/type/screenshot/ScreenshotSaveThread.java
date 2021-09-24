package com.moonsworth.lunar.client.feature.type.screenshot;

import com.moonsworth.lunar.bridge.minecraft.client.event.ClickEventAction;
import com.moonsworth.lunar.bridge.minecraft.client.event.HoverEventAction;
import com.moonsworth.lunar.bridge.minecraft.client.shader.FramebufferBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatComponentTextBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatStyleBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.IBridge;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotSaveThread
    extends Thread {
    public final ScreenshotMod lIlIlIlIlIIlIIlIIllIIIIIl;
    public final int[] IlllIIIIIIlllIlIIlllIlIIl;
    public final int lIllIlIIIlIIIIIIIlllIlIll;
    public final int llIlllIIIllllIIlllIllIIIl;
    public final FramebufferBridge llllIIlIIlIIlIIllIIlIIllI;
    public final File IlIlIlllllIlIIlIlIlllIlIl;

    @Override
    public void run() {
        BufferedImage bufferedImage;
        ScreenshotMod.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl, this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl);
        if (Bridge.lIlIIIIIIlIIIllllIllIIlII().bridge$isFramebufferEnabled()) {
            int n;
            bufferedImage = new BufferedImage(this.llllIIlIIlIIlIIllIIlIIllI.bridge$framebufferWidth(), this.llllIIlIIlIIlIIllIIlIIllI.bridge$framebufferHeight(), 1);
            for (int i = n = this.llllIIlIIlIIlIIllIIlIIllI.bridge$framebufferTextureHeight() - this.llllIIlIIlIIlIIllIIlIIllI.bridge$framebufferHeight(); i < this.llllIIlIIlIIlIIllIIlIIllI.bridge$framebufferTextureHeight(); ++i) {
                for (int j = 0; j < this.llllIIlIIlIIlIIllIIlIIllI.bridge$framebufferWidth(); ++j) {
                    bufferedImage.setRGB(j, i - n, this.IlllIIIIIIlllIlIIlllIlIIl[i * this.llllIIlIIlIIlIIllIIlIIllI.bridge$framebufferTextureWidth() + j]);
                }
            }
        } else {
            bufferedImage = new BufferedImage(this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl, 1);
            bufferedImage.setRGB(0, 0, this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl, this.IlllIIIIIIlllIlIIlllIlIIl, 0, this.lIllIlIIIlIIIIIIIlllIlIll);
        }
        File file = ScreenshotMod.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlIlIlllllIlIIlIlIlllIlIl);
        try {
            String string;
            ImageIO.write(bufferedImage, "png", file);
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl().booleanValue()) {
                string = "Saved and copied screenshot";
                ScreenshotUploadThread.lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl2 = new ScreenshotUploadThread.lIlIlIlIlIIlIIlIIllIIIIIl(bufferedImage);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(lIlIlIlIlIIlIIlIIllIIIIIl2, null);
            } else {
                string = "Saved screenshot";
            }
            ChatComponentTextBridge chatComponentTextBridge = Bridge.getInstance().initChatText(string);
            chatComponentTextBridge.bridge$getChatStyle().bridge$setUnderlined(true);
            ChatComponentTextBridge chatComponentTextBridge2 = Bridge.getInstance().initChatText(EnumChatColor.llIIIIIIIllIIllIlIllIIIIl + "" + EnumChatColor.lIIlIlllIlIlIIIlllIIlIIII + " [Open]");
            chatComponentTextBridge2.bridge$getChatStyle().bridge$setChatClickEvent(Bridge.getInstance().initChatClickEvent(ClickEventAction.OPEN_FILE, file.getCanonicalPath()));
            chatComponentTextBridge2.bridge$getChatStyle().bridge$setChatHoverEvent(Bridge.getInstance().initChatHoverEvent(HoverEventAction.SHOW_TEXT, Bridge.getInstance().initChatText(file.getName())));
            ChatComponentTextBridge chatComponentTextBridge3 = Bridge.getInstance().initChatText(EnumChatColor.llIIIlllIIlllIllllIlIllIl + "" + EnumChatColor.lIIlIlllIlIlIIIlllIIlIIII + " [Upload]");
            ChatStyleBridge chatStyleBridge = chatComponentTextBridge3.bridge$getChatStyle();
            IBridge iBridge = Bridge.getInstance();
            StringBuilder stringBuilder = new StringBuilder();
            this.lIlIlIlIlIIlIIlIIllIIIIIl.getClass();
            chatStyleBridge.bridge$setChatClickEvent(iBridge.initChatClickEvent(ClickEventAction.RUN_COMMAND, stringBuilder.append("/lc_upload_screenshot").append(" ").append(file.getName()).toString()));
            chatComponentTextBridge3.bridge$getChatStyle().bridge$setChatHoverEvent(Bridge.getInstance().initChatHoverEvent(HoverEventAction.SHOW_TEXT, Bridge.getInstance().initChatText("Upload to " + EnumChatColor.llIIIlllIIlllIllllIlIllIl + "imgur.com & open")));
            ChatComponentTextBridge chatComponentTextBridge4 = Bridge.getInstance().initChatText(EnumChatColor.lllllIllIllIllllIlIllllII + "" + EnumChatColor.lIIlIlllIlIlIIIlllIIlIIII + " [Tweet]");
            ChatStyleBridge chatStyleBridge2 = chatComponentTextBridge4.bridge$getChatStyle();
            IBridge iBridge2 = Bridge.getInstance();
            StringBuilder stringBuilder2 = new StringBuilder();
            this.lIlIlIlIlIIlIIlIIllIIIIIl.getClass();
            chatStyleBridge2.bridge$setChatClickEvent(iBridge2.initChatClickEvent(ClickEventAction.RUN_COMMAND, stringBuilder2.append("/lc_upload_screenshot").append("_tweet ").append(file.getName()).toString()));
            chatComponentTextBridge4.bridge$getChatStyle().bridge$setChatHoverEvent(Bridge.getInstance().initChatHoverEvent(HoverEventAction.SHOW_TEXT, Bridge.getInstance().initChatText("Upload to " + EnumChatColor.lllllIllIllIllllIlIllllII + "imgur.com & Tweet")));
            ChatComponentTextBridge chatComponentTextBridge5 = Bridge.getInstance().initChatText(EnumChatColor.llIIlIlIIIllIlIlIlIIlIIll + "" + EnumChatColor.lIIlIlllIlIlIIIlllIIlIIII + " [Copy]");
            ChatStyleBridge chatStyleBridge3 = chatComponentTextBridge5.bridge$getChatStyle();
            IBridge iBridge3 = Bridge.getInstance();
            StringBuilder stringBuilder3 = new StringBuilder();
            this.lIlIlIlIlIIlIIlIIllIIIIIl.getClass();
            chatStyleBridge3.bridge$setChatClickEvent(iBridge3.initChatClickEvent(ClickEventAction.RUN_COMMAND, stringBuilder3.append("/lc_upload_screenshot").append("_copy ").append(file.getName()).toString()));
            chatComponentTextBridge5.bridge$getChatStyle().bridge$setChatHoverEvent(Bridge.getInstance().initChatHoverEvent(HoverEventAction.SHOW_TEXT, Bridge.getInstance().initChatText("Copy the screenshot")));
            chatComponentTextBridge.bridge$appendSibling(chatComponentTextBridge2);
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl().booleanValue()) {
                chatComponentTextBridge.bridge$appendSibling(chatComponentTextBridge5);
            }
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl().booleanValue()) {
                chatComponentTextBridge.bridge$appendSibling(chatComponentTextBridge3);
            }
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl().booleanValue()) {
                chatComponentTextBridge.bridge$appendSibling(chatComponentTextBridge4);
            }
            Ref.getMinecraft().bridge$getGuiIngame().bridge$getChatGUI().bridge$printChatMessage(chatComponentTextBridge);
        } catch (IOException iOException) {
            LunarLogger.warn("Couldn't save screenshot");
            iOException.printStackTrace();
        }
    }

    public ScreenshotSaveThread(ScreenshotMod screenshotMod, int[] nArray, int n, int n2, FramebufferBridge framebufferBridge, File file) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = screenshotMod;
        this.IlllIIIIIIlllIlIIlllIlIIl = nArray;
        this.lIllIlIIIlIIIIIIIlllIlIll = n;
        this.llIlllIIIllllIIlllIllIIIl = n2;
        this.llllIIlIIlIIlIIllIIlIIllI = framebufferBridge;
        this.IlIlIlllllIlIIlIlIlllIlIl = file;
    }
}
