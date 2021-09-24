package com.moonsworth.lunar.bridge.minecraft.client.network;

import io.netty.buffer.ByteBuf;

public interface PacketBufferBridge {
    ByteBuf bridge$writeInt(int var1);

    int bridge$readInt();

    void bridge$writeString(String var1);

    String bridge$readStringFromBuffer(int var1);

    ByteBuf bridge$writeLong(long var1);

    long bridge$readLong();

    boolean bridge$readBoolean();

    void bridge$writeVarIntToBuffer(int var1);

    int bridge$readVarIntFromBuffer();

    ByteBuf bridge$writeShort(int var1);

    short bridge$readShort();

    ByteBuf bridge$writeBytes(byte[] var1);

    ByteBuf bridge$readBytes(byte[] var1);

    float bridge$readFloat();

    ByteBuf bridge$writeBoolean(boolean var1);

    int bridge$readableBytes();

    boolean bridge$release();
}
