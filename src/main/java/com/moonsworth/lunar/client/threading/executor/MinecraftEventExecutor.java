package com.moonsworth.lunar.client.threading.executor;

import com.google.common.collect.ImmutableSet;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.threading.LunarExecutors;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MinecraftEventExecutor implements java.util.concurrent.Executor, EventHandler {
    public Map<Runnable, Integer> lIlIlIlIlIIlIIlIIllIIIIIl = new ConcurrentHashMap<>();

    public MinecraftEventExecutor() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, tickEvent -> {
            ConcurrentHashMap<Runnable, Integer> concurrentHashMap = new ConcurrentHashMap<>();
            ArrayList<Runnable> arrayList = new ArrayList<Runnable>();
            for (Map.Entry<Runnable, Integer> entry : ImmutableSet.copyOf(this.lIlIlIlIlIIlIIlIIllIIIIIl.entrySet())) {
                int n = entry.getValue();
                Runnable runnable = entry.getKey();
                if (n <= 0) {
                    arrayList.add(runnable);
                    continue;
                }
                concurrentHashMap.put(runnable, n - 1);
            }
            this.lIlIlIlIlIIlIIlIIllIIIIIl = concurrentHashMap;
            arrayList.forEach(Runnable::run);
        });
    }

    //@Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(Runnable runnable) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.put(LunarExecutors.lIlIlIlIlIIlIIlIIllIIIIIl(runnable), 0);
    }

    @Override
    public void execute(Runnable runnable) {
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$submit(LunarExecutors.lIlIlIlIlIIlIIlIIllIIIIIl(runnable));
    }

    //@Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(Runnable runnable, int n) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.put(LunarExecutors.lIlIlIlIlIIlIIlIIllIIIIIl(runnable), n);
    }
}