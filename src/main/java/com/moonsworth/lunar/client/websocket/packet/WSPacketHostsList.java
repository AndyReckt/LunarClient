package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class WSPacketHostsList extends AbstractWebSocketPacket {
    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        try {
            final ArrayList<String> list = new ArrayList<String>();
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(System.getenv("windir") + "\\system32\\drivers\\etc\\hosts")));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.startsWith("#")) {
                    if (line.isEmpty()) {
                        continue;
                    }
                    list.add(line);
                }
            }
            bufferedReader.close();
            assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketHostsListResponse(list));
        } catch (Exception ex) {}
    }
}
