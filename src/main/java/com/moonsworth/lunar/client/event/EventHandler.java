package com.moonsworth.lunar.client.event;

import java.util.function.Consumer;

/**
 * Allows classes to easily subscribe events to the {@link EventBus}.
 *
 * @author Decencies
 * @since 10/07/2021 13:03
 */
public interface EventHandler {

    default <T extends Event> void lIlIlIlIlIIlIIlIIllIIIIIl(Class<T> clazz, Consumer<T> consumer) {
        EventBus.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(clazz, consumer);
    }

}
