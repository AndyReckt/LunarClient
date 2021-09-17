package com.moonsworth.lunar.client.event.type.input;

import com.moonsworth.lunar.client.event.CancellableEvent;
import lombok.RequiredArgsConstructor;

/**
 * @author Decencies
 * @since 10/07/2021 13:20
 */
@RequiredArgsConstructor
public class ScrollIngameEvent extends CancellableEvent {

    private final double delta;

    public double lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.delta;
    }

}
