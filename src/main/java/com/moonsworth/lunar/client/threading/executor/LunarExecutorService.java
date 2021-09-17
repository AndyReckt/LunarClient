package com.moonsworth.lunar.client.threading.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.moonsworth.lunar.client.threading.LunarExecutors;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LunarExecutorService extends AbstractExecutorService implements ScheduledExecutorService, Executor {
    public final ExecutorService lIlIlIlIlIIlIIlIIllIIIIIl = Executors.newCachedThreadPool((new ThreadFactoryBuilder()).setDaemon(true).setNameFormat("scheduler-%d").build());
    public final ScheduledExecutorService IlllIIIIIIlllIlIIlllIlIIl = Executors.newSingleThreadScheduledExecutor((new ThreadFactoryBuilder()).setDaemon(true).setNameFormat("scheduler-timer").build());
    public final Set lIllIlIIIlIIIIIIIlllIlIll = Collections.newSetFromMap(new WeakHashMap());

    public ScheduledFuture lIlIlIlIlIIlIIlIIllIIIIIl(ScheduledFuture var1) {
        synchronized(this.lIllIlIIIlIIIIIIIlllIlIll) {
            this.lIllIlIIIlIIIIIIIlllIlIll.add(var1);
            return var1;
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        synchronized(this.lIllIlIIIlIIIIIIIlllIlIll) {
            Iterator var2 = this.lIllIlIIIlIIIIIIIlllIlIll.iterator();

            while(var2.hasNext()) {
                ScheduledFuture var3 = (ScheduledFuture)var2.next();
                var3.cancel(false);
            }

        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Runnable var1) {
        this.schedule(var1, 50L, TimeUnit.MILLISECONDS);
    }

    public void execute(Runnable var1) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.execute(LunarExecutors.lIlIlIlIlIIlIIlIIllIIIIIl(var1));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Runnable var1, int var2) {
        this.schedule(var1, 50L * (long)var2, TimeUnit.MILLISECONDS);
    }

    public ScheduledFuture schedule(Runnable var1, long var2, TimeUnit var4) {
        Runnable var5 = LunarExecutors.lIlIlIlIlIIlIIlIIllIIIIIl(var1);
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.schedule(() -> {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.execute(var5);
        }, var2, var4));
    }

    public ScheduledFuture schedule(Callable var1, long var2, TimeUnit var4) {
        throw new UnsupportedOperationException();
    }

    public ScheduledFuture scheduleAtFixedRate(Runnable var1, long var2, long var4, TimeUnit var6) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.scheduleAtFixedRate(new LunarExecutorService.Executable(LunarExecutors.lIlIlIlIlIIlIIlIIllIIIIIl(var1)), var2, var4, var6));
    }

    public ScheduledFuture scheduleWithFixedDelay(Runnable var1, long var2, long var4, TimeUnit var6) {
        return this.scheduleAtFixedRate(var1, var2, var4, var6);
    }

    public void shutdown() {
    }

    public List shutdownNow() {
        return Collections.emptyList();
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public boolean awaitTermination(long var1, TimeUnit var3) {
        throw new IllegalStateException("Not shutdown");
    }

    public final class Executable implements Runnable {
        public final Runnable IlllIIIIIIlllIlIIlllIlIIl;
        public final ReentrantLock lIllIlIIIlIIIIIIIlllIlIll;
        public final AtomicInteger llIlllIIIllllIIlllIllIIIl;

        public Executable(Runnable var2) {
            this.lIllIlIIIlIIIIIIIlllIlIll = new ReentrantLock();
            this.llIlllIIIllllIIlllIllIIIl = new AtomicInteger(0);
            this.IlllIIIIIIlllIlIIlllIlIIl = var2;
        }

        public void run() {
            if (this.llIlllIIIllllIIlllIllIIIl.incrementAndGet() > 2) {
                this.llIlllIIIllllIIlllIllIIIl.decrementAndGet();
            } else {
                LunarExecutorService.this.lIlIlIlIlIIlIIlIIllIIIIIl.execute(() -> {
                    this.lIllIlIIIlIIIIIIIlllIlIll.lock();

                    try {
                        this.IlllIIIIIIlllIlIIlllIlIIl.run();
                    } finally {
                        this.lIllIlIIIlIIIIIIIlllIlIll.unlock();
                        this.llIlllIIIllllIIlllIllIIIl.decrementAndGet();
                    }

                });
            }
        }

        // $FF: synthetic method
        public Executable(Runnable var2, Object var3) {
            this(var2);
        }
    }
}