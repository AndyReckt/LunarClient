package com.moonsworth.lunar.client.blog;

import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.IPCListener;
import com.jagrosh.discordipc.entities.DiscordBuild;
import com.jagrosh.discordipc.entities.RichPresence;
import com.jagrosh.discordipc.entities.pipe.PipeStatus;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.logger.LunarLogger;

import java.time.OffsetDateTime;
import java.util.concurrent.TimeUnit;

public class DiscordIPC implements Runnable {
    public IPCClient lIlIlIlIlIIlIIlIIllIIIIIl = new IPCClient(562286213059444737L);
    public OffsetDateTime IlllIIIIIIlllIlIIlllIlIIl = OffsetDateTime.now();

    public DiscordIPC() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setListener(new IPCListener() {
            public void onReady(IPCClient var1) {
                DiscordIPC.this.lIlIlIlIlIIlIIlIIllIIIIIl();
            }
        });
    }

    public void run() {
        while (true) {
            try {
                PipeStatus var1 = this.lIlIlIlIlIIlIIlIIllIIIIIl.getStatus();
                if (var1 == PipeStatus.UNINITIALIZED || var1 == PipeStatus.DISCONNECTED || var1 == PipeStatus.CLOSED) {
                    try {
                        this.lIlIlIlIlIIlIIlIIllIIIIIl.connect();
                        LunarLogger.info("Discord", "Connected to Discord IPC");
                    } catch (Exception ignored) {
                    }
                }

                this.lIlIlIlIlIIlIIlIIllIIIIIl();
                Thread.sleep(TimeUnit.SECONDS.toMillis(5L));
            } catch (Exception ignored) {
            }
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl.getStatus() == PipeStatus.CONNECTED) {
            try {
                RichPresence.Builder var1 = (new RichPresence.Builder()).setDetails("Playing Minecraft " + Bridge.getMinecraftVersion().IlIlIlllllIlIIlIlIlllIlIl()).setStartTimestamp(this.IlllIIIIIIlllIlIIlllIlIIl).setLargeImage("icon_07_11_2020", "Lunar Client");
                this.lIlIlIlIlIIlIIlIIllIIIIIl.sendRichPresence(var1.build());
            } catch (Exception var2) {
                var2.printStackTrace();
            }

        }
    }
}
