package com.moonsworth.lunar.client.websocket;

import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.profile.Profile;
import com.moonsworth.lunar.client.ui.component.type.overlay.MessageListUIComponent;
import com.moonsworth.lunar.client.util.FontLinesUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class lIllIlIIIlIIIIIIIlllIlIll {
    public static final DateTimeFormatter lIlIlIlIlIIlIIlIIllIIIIIl = DateTimeFormatter.ofPattern("HH:mm:ss");
    public final String IlllIIIIIIlllIlIIlllIlIIl;
    public final Profile lIllIlIIIlIIIIIIIlllIlIll;
    public final String llIlllIIIllllIIlllIllIIIl;
    public final List llllIIlIIlIIlIIllIIlIIllI;
    public boolean IlIlIlllllIlIIlIlIlllIlIl;

    public lIllIlIIIlIIIIIIIlllIlIll(Profile profile, String string) {
        this.lIllIlIIIlIIIIIIIlllIlIll = profile;
        this.IlllIIIIIIlllIlIIlllIlIIl = LocalDateTime.now().format(lIlIlIlIlIIlIIlIIllIIIIIl);
        String string2 = this.IlllIIIIIIlllIlIIlllIlIIl + " " + profile.llllIIlIIlIIlIIllIIlIIllI() + ": ";
        this.llIlllIIIllllIIlllIllIIIl = string2 + string;
        this.llllIIlIIlIIlIIllIIlIIllI = FontLinesUtil.lIlIlIlIlIIlIIlIIllIIIIIl(EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlllIIIllllIIlllIllIIIl), MessageListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl, true);
        this.IlIlIlllllIlIIlIlIlllIlIl = false;
        String string3 = ((String)this.llllIIlIIlIIlIIllIIlIIllI().get(0)).replaceFirst(string2, "");
        this.llllIIlIIlIIlIIllIIlIIllI.remove(0);
        this.llllIIlIIlIIlIIllIIlIIllI.add(0, string3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.IlIlIlllllIlIIlIlIlllIlIl = true;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public Profile lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public List llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public boolean IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }
}