package com.moonsworth.lunar.client.event.type.input;

import com.moonsworth.lunar.client.event.Event;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Decencies
 * @since 10/07/2021 13:20
 */
@AllArgsConstructor
@NoArgsConstructor
public class MouseScrollEvent extends Event {

    private int delta;

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.delta;
    }

}
