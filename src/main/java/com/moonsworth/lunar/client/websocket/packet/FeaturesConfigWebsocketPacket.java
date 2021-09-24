package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.FriendStatusUtil;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.HashMap;
import java.util.Map;

public class FeaturesConfigWebsocketPacket extends AbstractWebSocketPacket {
    public final String IlllIIIIIIlllIlIIlllIlIIl;
    public final Map<String, Boolean> lIllIlIIIlIIIIIIIlllIlIll;

    public FeaturesConfigWebsocketPacket() {
        this.lIllIlIIIlIIIIIIIlllIlIll = new HashMap<>();
        for (final ConfigurableFeature configurableFeature : Ref.getLC().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl()) {
            this.lIllIlIIIlIIIIIIIlllIlIll.put(configurableFeature.getDetails().getId(), configurableFeature.IlllIIIIIIlllIlIIlllIlIIl());
        }
        this.IlllIIIIIIlllIlIIlllIlIIl = ((FriendStatusUtil.IlllIIIIIIlllIlIIlllIlIIl() == null) ? "" : FriendStatusUtil.IlllIIIIIIlllIlIIlllIlIIl());
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeVarIntToBuffer(this.lIllIlIIIlIIIIIIIlllIlIll.size());
        this.lIllIlIIIlIIIIIIIlllIlIll.forEach((s, b) -> {
            packetBufferBridge.bridge$writeString(s);
            packetBufferBridge.bridge$writeBoolean(b);
            return;
        });
        packetBufferBridge.bridge$writeString(this.IlllIIIIIIlllIlIIlllIlIIl);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
    }
}