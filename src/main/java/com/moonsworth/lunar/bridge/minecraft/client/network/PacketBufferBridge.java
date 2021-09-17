package com.moonsworth.lunar.bridge.minecraft.client.network;

import io.netty.buffer.ByteBuf;

public interface PacketBufferBridge {
    public ByteBuf bridge$writeInt(int var1);

    public int bridge$readInt();

    public void bridge$writeString(String var1);

    public String bridge$readStringFromBuffer(int var1);

    public ByteBuf bridge$writeLong(long var1);

    public long bridge$readLong();

    public boolean bridge$readBoolean();

    public void bridge$writeVarIntToBuffer(int var1);

    public int bridge$readVarIntFromBuffer();

    public ByteBuf bridge$writeShort(int var1);

    public short bridge$readShort();

    public ByteBuf bridge$writeBytes(byte[] var1);

    public ByteBuf bridge$readBytes(byte[] var1);

    public float bridge$readFloat();

    public ByteBuf bridge$writeBoolean(boolean var1);

    public int bridge$readableBytes();

    public boolean bridge$release();
}
 