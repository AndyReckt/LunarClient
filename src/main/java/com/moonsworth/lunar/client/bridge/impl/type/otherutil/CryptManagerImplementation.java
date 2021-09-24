package com.moonsworth.lunar.client.bridge.impl.type.otherutil;

import com.moonsworth.lunar.bridge.minecraft.util.CryptManagerBridge;
import net.minecraft.util.CryptManager;

import javax.crypto.SecretKey;
import java.security.PublicKey;

public class CryptManagerImplementation implements CryptManagerBridge {
    public byte[] bridge$encryptData(PublicKey var1, byte[] var2) {
        return CryptManager.encryptData(var1, var2);
    }

    public PublicKey bridge$decodePublicKey(byte[] var1) {
        return CryptManager.decodePublicKey(var1);
    }

    public SecretKey bridge$createNewSharedKey() {
        return CryptManager.createNewSharedKey();
    }

    public byte[] bridge$getServerIdHash(String var1, PublicKey var2, SecretKey var3) {
        return CryptManager.getServerIdHash(var1, var2, var3);
    }
}