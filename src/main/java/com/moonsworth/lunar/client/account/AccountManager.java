package com.moonsworth.lunar.client.account;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.AccountsConfig;
import com.moonsworth.lunar.client.util.AuthUtil;
import lombok.SneakyThrows;

import java.util.UUID;

public class AccountManager
extends Account {
    public AccountManager(String string) {
        super(string);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(AccountType.lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIllIlIIIlIIIIIIIlllIlIll(UUID.randomUUID().toString().replace("-", ""));
    }

    // todo: missing exception?
    @SneakyThrows
    public AccountManager(String string, String string2) {
        super(UUID.randomUUID().toString().replace("-", ""));
        this.IlIlIlllllIlIIlIlIlllIlIl(Ref.IlllIIIIIIlllIlIIlllIlIIl().llIlIIIllIIlIllIllIllllIl().lllllIllIllIllllIlIllllII());
        YggdrasilUserAuthentication yggdrasilUserAuthentication = AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl;
        if (yggdrasilUserAuthentication.isLoggedIn()) {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Logged in to new account with username and pass while logged in, logging out of previous account.", new Object[0]);
            yggdrasilUserAuthentication.logOut();
        }
        yggdrasilUserAuthentication.setPassword(string2);
        yggdrasilUserAuthentication.setUsername(string);
        yggdrasilUserAuthentication.logIn();
        this.llIlllIIIllllIIlllIllIIIl(string);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(yggdrasilUserAuthentication.getAuthenticatedToken());
        this.lIlIlIlIlIIlIIlIIllIIIIIl(new MinecraftProfile(yggdrasilUserAuthentication.getSelectedProfile().getId().toString().replace("-", ""), yggdrasilUserAuthentication.getSelectedProfile().getName()));
        this.lIlIlIlIlIIlIIlIIllIIIIIl(AccountType.lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIllIlIIIlIIIIIIIlllIlIll(UUID.randomUUID().toString().replace("-", ""));
        AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Was able to log into account [%s] by username and password", string);
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        if (this.llllIIlIIlIIlIIllIIlIIllI() == null) {
            return false;
        }
        JsonObject jsonObject = AuthUtil.IlllIIIIIIlllIlIIlllIlIIl(this.llllIIlIIlIIlIIllIIlIIllI());
        if (!jsonObject.has("exp")) {
            return false;
        }
        return System.currentTimeMillis() < (long)jsonObject.get("exp").getAsInt() * 1000L;
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
        this.IlIlIlllllIlIIlIlIlllIlIl(Ref.IlllIIIIIIlllIlIIlllIlIIl().llIlIIIllIIlIllIllIllllIl().lllllIllIllIllllIlIllllII());
        YggdrasilUserAuthentication yggdrasilUserAuthentication = AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl;
        if (yggdrasilUserAuthentication.isLoggedIn()) {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Logged in to new account with username and pass while logged in, logging out of previous account.", new Object[0]);
            yggdrasilUserAuthentication.logOut();
        }
        yggdrasilUserAuthentication.loadFromStorage(ImmutableMap.of("displayName", this.lIIIllIllIIllIlllIlIIlllI().IlllIIIIIIlllIlIIlllIlIIl(), "uuid", this.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(), "accessToken", this.llllIIlIIlIIlIIllIIlIIllI(), "username", this.llIIIlllIIlllIllllIlIllIl()));
        try {
            yggdrasilUserAuthentication.logIn();
        }
        catch (AuthenticationException authenticationException) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl((String)null);
            authenticationException.printStackTrace();
            return false;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(yggdrasilUserAuthentication.getAuthenticatedToken());
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$setSession(Bridge.llIlllIIIllllIIlllIllIIIl().initSession(yggdrasilUserAuthentication.getSelectedProfile().getName(), yggdrasilUserAuthentication.getSelectedProfile().getId().toString().replace("-", ""), yggdrasilUserAuthentication.getAuthenticatedToken(), "mojang"));
        return true;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(String string) {
        if (string == null) {
            string = UUID.randomUUID().toString().replace("-", "");
            Ref.IlllIIIIIIlllIlIIlllIlIIl().llIlIIIllIIlIllIllIllllIl().lIlIlIlIlIIlIIlIIllIIIIIl(string);
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Generated client token: %s", string);
        } else {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Reused client token: %s", string);
        }
        AuthUtil.llIlllIIIllllIIlllIllIIIl(string);
    }
}
 