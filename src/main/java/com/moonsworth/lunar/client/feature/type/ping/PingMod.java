package com.moonsworth.lunar.client.feature.type.ping;

import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.ServerDataBridge;
import com.moonsworth.lunar.bridge.minecraft.client.network.OldServerPingerBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.threading.LunarExecutors;

import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class PingMod
    extends SimpleHudMod {
    public long IllIIIlllIIIlIlllIlIIlIII;
    public long IIlIllIlIIllIIlIlIllllllI = -1L;
    public OldServerPingerBridge lIIIlllIIIIllllIlIIIlIIll = Bridge.getInstance().initOldServerPinger();

    public PingMod() {
        super(false, HudModPosition.TOP_LEFT);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, tickEvent -> {
            ServerDataBridge serverDataBridge = Ref.getMinecraft().bridge$getCurrentServerData();
            this.lIlIlIlIlIIlIIlIIllIIIIIl(serverDataBridge);
            if (serverDataBridge != null && serverDataBridge.bridge$getPingToServer() > 0L) {
                this.IIlIllIlIIllIIlIlIllllllI = serverDataBridge.bridge$getPingToServer();
            }
        });
    }

    @Override
    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(70.0f, 86.0f);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ServerDataBridge serverDataBridge) {
        if (serverDataBridge != null && System.currentTimeMillis() - this.IllIIIlllIIIlIlllIlIIlIII >= TimeUnit.SECONDS.toMillis(15L)) {
            LunarExecutors.getLunarExecutor().execute(() -> {
                try {
                    this.lIIIlllIIIIllllIlIIIlIIll.bridge$ping(serverDataBridge);
                } catch (UnknownHostException unknownHostException) {
                    // empty catch block
                }
            });
            this.IllIIIlllIIIlIlllIlIIlIII = System.currentTimeMillis();
        }
    }

    @Override
    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "[13 ms]";
    }

    @Override
    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 40, 56, 62);
    }

    @Override
    public String lllllIlIllIlIlllIIIlIIlIl() {
        return this.IIlIllIlIIllIIlIlIllllllI + " ms";
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("ping");
    }
}