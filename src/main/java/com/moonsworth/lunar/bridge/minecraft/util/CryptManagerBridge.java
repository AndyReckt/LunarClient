package com.moonsworth.lunar.bridge.minecraft.util;

import javax.crypto.SecretKey;
import java.security.PublicKey;

public interface CryptManagerBridge {
    public byte[] bridge$encryptData(PublicKey var1, byte[] var2);

    public PublicKey bridge$decodePublicKey(byte[] var1);

    public SecretKey bridge$createNewSharedKey();

    public byte[] bridge$getServerIdHash(String var1, PublicKey var2, SecretKey var3);
}
 