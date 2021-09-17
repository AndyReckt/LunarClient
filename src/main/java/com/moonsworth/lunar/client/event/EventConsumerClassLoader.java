package com.moonsworth.lunar.client.event;

import java.net.URLClassLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Decencies
 * @since 10/07/2021 12:53
 */
public class EventConsumerClassLoader extends URLClassLoader {

    public Map<String, Class<?>> lIlIlIlIlIIlIIlIIllIIIIIl = new ConcurrentHashMap<>();

    public EventConsumerClassLoader(ClassLoader classLoader) {
        super(((URLClassLoader)classLoader).getURLs(), classLoader);
    }

    public Class<?> lIlIlIlIlIIlIIlIIllIIIIIl(String string, byte[] byArray) {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl.containsKey(string)) {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl.get(string);
        }
        Class<?> clazz = this.defineClass(string, byArray, 0, byArray.length);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.put(string, clazz);
        return clazz;
    }


}
