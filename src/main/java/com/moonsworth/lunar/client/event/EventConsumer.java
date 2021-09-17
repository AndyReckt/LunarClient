package com.moonsworth.lunar.client.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Consumer;

/**
 * @author Decencies
 * @since 10/07/2021 12:56
 */
public class EventConsumer implements Consumer<Event> {

    public final Object lIlIlIlIlIIlIIlIIllIIIIIl;
    public final Method IlllIIIIIIlllIlIIlllIlIIl;

    public EventConsumer(Object object, Method method) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = object;
        this.IlllIIIIIIlllIlIIlllIlIIl = method;
        method.setAccessible(true);
    }

    @Override public void accept(Event event) {
        try {
            this.IlllIIIIIIlllIlIIlllIlIIl.invoke(this.lIlIlIlIlIIlIIlIIllIIIIIl, event);
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            reflectiveOperationException.printStackTrace();
        }
    }

    public Object lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
