package com.moonsworth.lunar.client.event.type.input;

import com.moonsworth.lunar.client.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Decencies
 * @since 10/07/2021 13:20
 */
@AllArgsConstructor
@NoArgsConstructor
public class TogglePerspectiveEvent extends CancellableEvent {

    private int perspective;

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        int n = this.perspective + 1;
        if (n > 2) {
            n = 0;
        }
        return n;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.perspective;
    }

}
