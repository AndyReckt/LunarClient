package com.moonsworth.lunar.bridge.minecraft.util;

import javax.crypto.SecretKey;
import java.security.PublicKey;

public interface CryptManagerBridge {
    byte[] bridge$encryptData(PublicKey var1, byte[] var2);

    PublicKey bridge$decodePublicKey(byte[] var1);

    SecretKey bridge$createNewSharedKey();

    byte[] bridge$getServerIdHash(String var1, PublicKey var2, SecretKey var3);
}
