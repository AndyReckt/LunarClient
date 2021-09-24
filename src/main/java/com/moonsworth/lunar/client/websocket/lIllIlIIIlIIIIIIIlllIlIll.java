package com.moonsworth.lunar.client.websocket;

import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.profile.FriendProfile;
import com.moonsworth.lunar.client.ui.component.type.overlay.MessageListUIComponent;
import com.moonsworth.lunar.client.util.FontLinesUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class lIllIlIIIlIIIIIIIlllIlIll {
    public static final DateTimeFormatter lIlIlIlIlIIlIIlIIllIIIIIl;
    public final String IlllIIIIIIlllIlIIlllIlIIl;
    public final FriendProfile lIllIlIIIlIIIIIIIlllIlIll;
    public final String llIlllIIIllllIIlllIllIIIl;
    public final List<String> llllIIlIIlIIlIIllIIlIIllI;
    public boolean IlIlIlllllIlIIlIlIlllIlIl;

    public lIllIlIIIlIIIIIIIlllIlIll(final FriendProfile lIllIlIIIlIIIIIIIlllIlIll, final String s) {
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
        this.IlllIIIIIIlllIlIIlllIlIIl = LocalDateTime.now().format(lIlIlIlIlIIlIIlIIllIIIIIl);
        final String string = this.IlllIIIIIIlllIlIIlllIlIIl + " " + lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI() + ": ";
        this.llIlllIIIllllIIlllIllIIIl = string + s;
        this.llllIIlIIlIIlIIllIIlIIllI = FontLinesUtil.lIlIlIlIlIIlIIlIIllIIIIIl(EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlllIIIllllIIlllIllIIIl), MessageListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl, true);
        this.IlIlIlllllIlIIlIlIlllIlIl = false;
        final String replaceFirst = this.llllIIlIIlIIlIIllIIlIIllI().get(0).replaceFirst(string, "");
        this.llllIIlIIlIIlIIllIIlIIllI.remove(0);
        this.llllIIlIIlIIlIIllIIlIIllI.add(0, replaceFirst);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.IlIlIlllllIlIIlIlIlllIlIl = true;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public FriendProfile lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public List<String> llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public boolean IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    static {
        lIlIlIlIlIIlIIlIIllIIIIIl = DateTimeFormatter.ofPattern("HH:mm:ss");
    }
}
