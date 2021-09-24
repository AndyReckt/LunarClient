package com.moonsworth.lunar.client.account;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.AuthUtil;

import java.time.Instant;

public class MicrosoftAccount extends Account {
    public MicrosoftAccount(String string) {
        super(string);
        this.setType(AccountType.XBOX);
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return true;
    }

    @Override
    public int lIllIlIIIlIIIIIIIlllIlIll() {
        JsonObject jsonObject = AuthUtil.IlllIIIIIIlllIlIIlllIlIIl(this.getAccessToken());
        if (!jsonObject.has("iat")) {
            return 0;
        }
        return jsonObject.get("iat").getAsInt();
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (Instant.now().isAfter(this.getAccessTokenExpiresAt())) {
            AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this);
            return false;
        }
        Ref.getMinecraft().bridge$setSession(Bridge.getInstance().initSession(this.getProfile().getName(), this.getProfile().getId(), this.getAccessToken(), "mojang"));
        return true;
    }
}
