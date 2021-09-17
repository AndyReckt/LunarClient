package com.moonsworth.lunar.client.event;

import com.moonsworth.lunar.client.event.annotation.SubscribeEvent;
import com.moonsworth.lunar.client.logger.LunarLogger;
import lombok.Getter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author Decencies
 * @since 10/07/2021 12:32
 */
public class EventBus {

    private static final EventBus IlllIIIIIIlllIlIIlllIlIIl = new EventBus();
    public static final boolean lIllIlIIIlIIIIIIIlllIlIll = true;
    public ConcurrentHashMap<Class<?>, CopyOnWriteArrayList<Consumer<? extends Event>>> lIlIlIlIlIIlIIlIIllIIIIIl = new ConcurrentHashMap<>();
    public EventConsumerClassLoader llIlllIIIllllIIlllIllIIIl = new EventConsumerClassLoader(EventBus.class.getClassLoader());

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
        for (Method method : this.lIllIlIIIlIIIIIIIlllIlIll(object)) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.computeIfAbsent(method.getParameterTypes()[0], clazz -> new CopyOnWriteArrayList<>()).add(new EventConsumer(object, method));
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(Object object) {
        for (Method method : lIllIlIIIlIIIIIIIlllIlIll(object)) {
            List<Consumer<? extends Event>> list = lIlIlIlIlIIlIIlIIllIIIIIl.get(method.getParameterTypes()[0]);
            if (list == null) continue;
            list.removeIf(consumer -> consumer instanceof EventConsumer && ((EventConsumer) consumer).lIlIlIlIlIIlIIlIIllIIIIIl() == object);
        }
    }

    public List<Method> lIllIlIIIlIIIIIIIlllIlIll(Object object) {
        return Arrays.stream(object.getClass().getDeclaredMethods())
                .filter(method ->
                                method.isAnnotationPresent(SubscribeEvent.class) &&
                                        method.getParameterCount() == 1 &&
                                        Event.class.isAssignableFrom(method.getParameterTypes()[0])
                ).collect(Collectors.toList());
    }

    public <T extends Event> boolean lIlIlIlIlIIlIIlIIllIIIIIl(Class<T> clazz2, Consumer<T> consumer) {
        return lIlIlIlIlIIlIIlIIllIIIIIl.computeIfAbsent(clazz2, clazz -> new CopyOnWriteArrayList<>()).add(consumer);
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(Class<?> clazz, Consumer<Event> consumer) {
        CopyOnWriteArrayList<Consumer<? extends Event>> copyOnWriteArrayList = lIlIlIlIlIIlIIlIIllIIIIIl.get(clazz);
        return copyOnWriteArrayList != null && copyOnWriteArrayList.remove(consumer);
    }

    @SuppressWarnings("unchcecked")
    public <T extends Event> T lIlIlIlIlIIlIIlIIllIIIIIl(T event) {
        try {
            CopyOnWriteArrayList<Consumer<? extends Event>> copyOnWriteArrayList = lIlIlIlIlIIlIIlIIllIIIIIl.get(event.getClass());
            if (copyOnWriteArrayList != null) {
                for (Consumer<? extends Event> consumer : copyOnWriteArrayList) {
                    try {
                        Consumer<T> consumer1 = (Consumer<T>) consumer;
                        consumer1.accept(event);
                    } catch (Throwable throwable) {
                        LunarLogger.llIlllIIIllllIIlllIllIIIl("EventBus [" + event.getClass() + "]: " + throwable.getMessage());
                    }
                }
                return event;
            }
        } catch (Error | Exception throwable) {
            LunarLogger.llIlllIIIllllIIlllIllIIIl("EventBus [" + event.getClass() + "]: " + throwable.getMessage());
            throwable.printStackTrace();
        }
        return null;
    }

    public static EventBus lIlIlIlIlIIlIIlIIllIIIIIl() {
        return IlllIIIIIIlllIlIIlllIlIIl;
    }

    public EventConsumerClassLoader IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }


}
