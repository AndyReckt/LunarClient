package com.moonsworth.lunar.client.event;

/**
 * @author Decencies
 * @since 10/07/2021 13:02
 */
public class CancellableEvent extends Event {
    public boolean cancelled;

    public void cancel() {
        this.cancelled = true;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean bl) {
        this.cancelled = bl;
    }
}

