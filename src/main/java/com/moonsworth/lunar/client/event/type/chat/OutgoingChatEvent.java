package com.moonsworth.lunar.client.event.type.chat;

import com.moonsworth.lunar.client.event.CancellableEvent;

public class OutgoingChatEvent
extends CancellableEvent {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        String[] stringArray = this.lIlIlIlIlIIlIIlIIllIIIIIl.split(" ", 2);
        return stringArray.length > 0 && stringArray[0].equals(string);
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        String[] stringArray = this.lIlIlIlIlIIlIIlIIllIIIIIl.split(" ", 2);
        if (stringArray.length < 2) {
            return "";
        }
        return stringArray[1];
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public OutgoingChatEvent(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
    }
}