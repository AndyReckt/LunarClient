package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.cosmetic.*;
import com.moonsworth.lunar.client.cosmetic.type.BandanaCosmeticType;
import com.moonsworth.lunar.client.cosmetic.type.HatCosmeticType;
import com.moonsworth.lunar.client.cosmetic.type.MaskCosmeticType;
import com.moonsworth.lunar.client.cosmetic.type.WingsCosmeticTypeWithRenderf;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class WSPacketClientUnknownCosmetic extends AbstractWebSocketPacket {
    public List<Cosmetic> IlllIIIIIIlllIlIIlllIlIIl;
    public UUID lIllIlIIIlIIIIIIIlllIlIll;
    public int llIlllIIIllllIIlllIllIIIl;
    public boolean llllIIlIIlIIlIIllIIlIIllI;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.lIllIlIIIlIIIIIIIlllIlIll = new UUID(packetBufferBridge.bridge$readLong(), packetBufferBridge.bridge$readLong());
        final int bridge$readVarIntFromBuffer = packetBufferBridge.bridge$readVarIntFromBuffer();
        final Map<Integer, CosmeticIndexEntry> llIIIIIIIllIIllIlIllIIIIl = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().llIIIIIIIllIIllIlIllIIIIl();
        this.IlllIIIIIIlllIlIIlllIlIIl = new ArrayList<>(bridge$readVarIntFromBuffer);
        for (int i = 0; i < bridge$readVarIntFromBuffer; ++i) {
            final int bridge$readVarIntFromBuffer2 = packetBufferBridge.bridge$readVarIntFromBuffer();
            final boolean bridge$readBoolean = packetBufferBridge.bridge$readBoolean();
            final CosmeticIndexEntry cosmeticIndexEntry = llIIIIIIIllIIllIlIllIIIIl.get(bridge$readVarIntFromBuffer2);
            if (cosmeticIndexEntry != null) {
                try {
                    this.IlllIIIIIIlllIlIIlllIlIIl.add(this.lIlIlIlIlIIlIIlIIllIIIIIl(bridge$readVarIntFromBuffer2, cosmeticIndexEntry.llIlllIIIllllIIlllIllIIIl(), cosmeticIndexEntry.llllIIlIIlIIlIIllIIlIIllI(), cosmeticIndexEntry.IlllIIIIIIlllIlIIlllIlIIl(), cosmeticIndexEntry.lIllIlIIIlIIIIIIIlllIlIll(), bridge$readBoolean));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        this.llIlllIIIllllIIlllIllIIIl = packetBufferBridge.bridge$readInt();
        this.llllIIlIIlIIlIIllIIlIIllI = packetBufferBridge.bridge$readBoolean();
    }

    public Cosmetic lIlIlIlIlIIlIIlIIllIIIIIl(final int n, final String s, String s2, final float n2, final String s3, final boolean b) {
        if (s3.contains("bandannas")) {
            s2 = "bandanna";
        } else if (s3.contains("masks")) {
            s2 = "mask";
        }
        final String s4 = s2;
        switch (s4) {
        case "cloak":
        case "cape": {
            return new CloakCosmetic(n, s, n2, s3, b);
        }
        case "dragon_wings": {
            return new WingsCosmeticTypeWithRenderf(n, s, n2, s3, b);
        }
        case "hat": {
            return new HatCosmeticType(n, s, n2, s3, b);
        }
        case "mask": {
            return new MaskCosmeticType(n, s, n2, s3, b);
        }
        case "bandanna": {
            return new BandanaCosmeticType(n, s, n2, s3, b);
        }
        case "bodywear": {
            return new RenderableCosmeticType(n, s, n2, s3, CosmeticType.BODYWEAR, b);
        }
        default: {
            return null;
        }
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public List<Cosmetic> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public UUID IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }
}