package com.moonsworth.lunar.client.threading;

import com.moonsworth.lunar.client.threading.executor.LunarExecutorService;
import com.moonsworth.lunar.client.threading.executor.MinecraftEventExecutor;

public class LunarExecutors {
    public static final LunarExecutorService lIlIlIlIlIIlIIlIIllIIIIIl = new LunarExecutorService();
    public static final MinecraftEventExecutor IlllIIIIIIlllIlIIlllIlIIl = new MinecraftEventExecutor();

    public static MinecraftEventExecutor lIlIlIlIlIIlIIlIIllIIIIIl() {
        return IlllIIIIIIlllIlIIlllIlIIl;
    }

    public static LunarExecutorService IlllIIIIIIlllIlIIlllIlIIl() {
        return lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public static Runnable lIlIlIlIlIIlIIlIIllIIIIIl(Runnable var0) {
        return new LunarExecutors.ThrowingExecutor(var0);
    }

    public static final class ThrowingExecutor implements Runnable {
        public final Runnable lIlIlIlIlIIlIIlIIllIIIIIl;

        public ThrowingExecutor(Runnable var1) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
        }

        public void run() {
            try {
                this.lIlIlIlIlIIlIIlIIllIIIIIl.run();
            } catch (Throwable var2) {
                var2.printStackTrace();
            }

        }

        // $FF: synthetic method
        public ThrowingExecutor(Runnable var1, Object var2) {
            this(var1);
        }
    }
}