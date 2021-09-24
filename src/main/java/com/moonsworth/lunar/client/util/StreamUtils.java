package com.moonsworth.lunar.client.util;


import com.moonsworth.lunar.client.bridge.Bridge;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;

import java.awt.image.BufferedImage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.imageio.ImageIO;

public final class StreamUtils {
    public static InputStream lIlIlIlIlIIlIIlIIllIIIIIl(BufferedImage var0) throws Exception {
        try {
            ByteArrayOutputStream var1 = new ByteArrayOutputStream();
            ImageIO.write(var0, "jpeg", var1);
            return new ByteArrayInputStream(var1.toByteArray());
        } catch (Throwable var2) {
            throw var2;
        }
    }

    public static BufferedImage lIlIlIlIlIIlIIlIIllIIIIIl(InputStream var0) throws IOException {
        if (var0 == null) {
            return null;
        } else {
            BufferedImage var1;
            try {
                var1 = Bridge.getInstance().lIlIlIlIlIIlIIlIIllIIIIIl(var0);
            } finally {
                IOUtils.closeQuietly(var0);
            }

            return var1;
        }
    }

    public static Optional<BufferedImage> lIlIlIlIlIIlIIlIIllIIIIIl(String var0) {
        ByteBuf var1 = Unpooled.copiedBuffer(var0, Charsets.UTF_8);
        ByteBuf var2 = Base64.decode(var1);

        try {
            return Optional.ofNullable(lIlIlIlIlIIlIIlIIllIIIIIl(new ByteBufInputStream(var2)));
        } catch (IOException var7) {
            var7.printStackTrace();
        } finally {
            var1.release();
            var2.release();
        }

        return Optional.empty();
    }

    public StreamUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
