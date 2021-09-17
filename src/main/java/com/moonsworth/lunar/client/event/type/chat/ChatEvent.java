package com.moonsworth.lunar.client.event.type.chat;

import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class ChatEvent
extends CancellableEvent {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public IChatComponentBridge IlllIIIIIIlllIlIIlllIlIIl;
    public int lIllIlIIIlIIIIIIIlllIlIll;

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public IChatComponentBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public ChatEvent(String string, IChatComponentBridge iChatComponentBridge, int n) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = iChatComponentBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = n;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(IChatComponentBridge iChatComponentBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = iChatComponentBridge;
    }
}