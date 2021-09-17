package com.lunarclient.bukkitapi.nethandler.server;

import com.lunarclient.bukkitapi.nethandler.ByteBufWrapper;
import com.lunarclient.bukkitapi.nethandler.LCPacket;
import com.lunarclient.bukkitapi.nethandler.client.LCNetHandlerClient;
import com.lunarclient.bukkitapi.nethandler.shared.LCNetHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public final class LCPacketVoice extends LCPacket {
    /**
     * The UUID of all the senders, since we're using multiplex
     * we don't actually know the bytes per user
     */
    @Getter private Set<UUID> uuids;

    /**
     * The "smashed" bytes of all the voice.
     */
    @Getter private byte[] data;

    @Override
    public void write(ByteBufWrapper b) {
        b.writeVarInt(uuids.size());
        uuids.forEach(b::writeUUID);
        writeBlob(b, this.data);
    }

    @Override
    public void read(ByteBufWrapper b) {
        uuids = new HashSet<>();
        int size = b.readVarInt();
        for (int i = 0; i < size; i++) {
            uuids.add(b.readUUID());
        }
        this.data = readBlob(b);
    }

    @Override
    public void process(LCNetHandler handler) {
        ((LCNetHandlerClient) handler).handleVoice(this);
    }

    /**
     * For comparability, will be removed.
     * @return The 0 index of the sent players.
     */
    @Deprecated
    public UUID getUuid() {
        return new ArrayList<>(uuids).get(0);
    }
}
