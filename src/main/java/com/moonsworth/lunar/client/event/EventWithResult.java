package com.moonsworth.lunar.client.event;

/**
 * @author Decencies
 * @since 10/07/2021 13:03
 */
public class EventWithResult extends Event {
    public EventStateResult lIlIlIlIlIIlIIlIIllIIIIIl = EventStateResult.DEFAULT;

    public EventStateResult lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EventStateResult eventStateResult) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = eventStateResult;
    }

    public enum EventStateResult {
        ALLOW, // lIlIlIlIlIIlIIlIIllIIIIIl
        DENY, // IlllIIIIIIlllIlIIlllIlIIl
        DEFAULT // lIllIlIIIlIIIIIIIlllIlIll
    }
}
