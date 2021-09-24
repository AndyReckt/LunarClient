package com.moonsworth.lunar.client.feature.type.nick;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiEditSignBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBookBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.chat.ChatEvent;
import com.moonsworth.lunar.client.event.type.gui.GuiOpenEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.server.ServerIntegration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NickHiderEventHandler implements EventHandler {
    public final Pattern lIlIlIlIlIIlIIlIIllIIIIIl = Pattern.compile("you will be nicked as ?(?:[\\[\\]a-zA-Z0-9+]+)? (?<name>[a-zA-Z0-9_]{3,16}).");
    public final Pattern IlllIIIIIIlllIlIIlllIlIIl = Pattern.compile("You are now nicked as (?<name>[a-zA-Z0-9_]{3,16})!");
    public String lIllIlIIIlIIIIIIIlllIlIll = "";
    public final NickHiderMod llIlllIIIllllIIlllIllIIIl;

    public NickHiderEventHandler(NickHiderMod var1) {
        this.llIlllIIIllllIIlllIllIIIl = var1;
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiOpenEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ChatEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ChatEvent var1) {
        if (LunarClient.getInstance().lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl() == ServerIntegration.Server.HYPIXEL) {
            if (var1.lIlIlIlIlIIlIIlIIllIIIIIl().equalsIgnoreCase("Your nick has been reset!")) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            } else {
                Matcher var2 = this.IlllIIIIIIlllIlIIlllIlIIl.matcher(var1.lIlIlIlIlIIlIIlIIllIIIIIl());
                if (var2.find()) {
                    String var3 = var2.group("name");
                    this.IlllIIIIIIlllIlIIlllIlIIl(var3);
                }
            }
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiOpenEvent var1) {
        if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() != null) {
            if (var1.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(GuiScreenBookBridge.class)) {
                GuiScreenBookBridge var2 = (GuiScreenBookBridge)var1.lIlIlIlIlIIlIIlIIllIIIIIl();
                String var3 = var2.bridge$getPageContents(var2.bridge$getCurrentPage());
                Matcher var4 = this.lIlIlIlIlIIlIIlIIllIIIIIl.matcher(EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(var3));
                if (var4.find()) {
                    this.IlllIIIIIIlllIlIIlllIlIIl(var4.group("name"));
                }
            }
        } else {
            GuiScreenBridge var5 = Ref.getMinecraft().bridge$getCurrentScreen();
            if (var5 != null && var5.lIlIlIlIlIIlIIlIIllIIIIIl(GuiEditSignBridge.class)) {
                GuiEditSignBridge var6 = (GuiEditSignBridge)var5;
                if ((var6.bridge$getLine(2) + " " + var6.bridge$getLine(3)).equalsIgnoreCase("Enter your desired username here")) {
                    String var7 = var6.bridge$getLine(0);
                    this.IlllIIIIIIlllIlIIlllIlIIl(var7);
                }
            }
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (!this.lIllIlIIIlIIIIIIIlllIlIll.isEmpty()) {
            this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll, true);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1) {
        if (!this.lIllIlIIIlIIIIIIIlllIlIll.isEmpty()) {
            this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll);
            if (var1) {
                this.lIllIlIIIlIIIIIIIlllIlIll = "";
            }
        }

    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String var1) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        this.lIllIlIIIlIIIIIIIlllIlIll = var1;
        this.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1) {
        this.lIllIlIIIlIIIIIIIlllIlIll = var1;
    }
}
