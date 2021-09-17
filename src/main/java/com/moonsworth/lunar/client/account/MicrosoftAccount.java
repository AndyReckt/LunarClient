package com.moonsworth.lunar.client.account;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.AuthUtil;

import java.time.Instant;

public class MicrosoftAccount
extends Account {
    public MicrosoftAccount(String string) {
        super(string);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(AccountType.IlllIIIIIIlllIlIIlllIlIIl);
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return true;
    }

    @Override
    public int lIllIlIIIlIIIIIIIlllIlIll() {
        JsonObject jsonObject = AuthUtil.IlllIIIIIIlllIlIIlllIlIIl(this.llllIIlIIlIIlIIllIIlIIllI());
        if (!jsonObject.has("iat")) {
            return 0;
        }
        return jsonObject.get("iat").getAsInt();
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (Instant.now().isAfter(this.IlIlIlllllIlIIlIlIlllIlIl())) {
            AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this);
            return false;
        }
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$setSession(Bridge.llIlllIIIllllIIlllIllIIIl().initSession(this.lIIIllIllIIllIlllIlIIlllI().IlllIIIIIIlllIlIIlllIlIIl(), this.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(), this.llllIIlIIlIIlIIllIIlIIllI(), "mojang"));
        return true;
    }
}
 