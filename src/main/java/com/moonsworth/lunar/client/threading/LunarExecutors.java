package com.moonsworth.lunar.client.threading;

import com.moonsworth.lunar.client.threading.executor.LunarExecutorService;
import com.moonsworth.lunar.client.threading.executor.MinecraftEventExecutor;

public class LunarExecutors {
    public static final LunarExecutorService lunarExecutor = new LunarExecutorService();
    public static final MinecraftEventExecutor minecraftExecutor = new MinecraftEventExecutor();

    public static MinecraftEventExecutor getMinecraftExecutor() {
        return minecraftExecutor;
    }

    public static LunarExecutorService getLunarExecutor() {
        return lunarExecutor;
    }

    public static Runnable run(Runnable runnable) {
        return new LunarExecutors.ThrowingExecutor(runnable);
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
    }
}