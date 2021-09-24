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

public class MojangAccount extends Account {
    public MojangAccount(String string) {
        super(string);
        this.setType(AccountType.MOJANG);
        this.setRemoteId(UUID.randomUUID().toString().replace("-", ""));
    }

    @SneakyThrows
    public MojangAccount(String username, String password) throws AuthenticationException {
        super(UUID.randomUUID().toString().replace("-", ""));
        this.IlIlIlllllIlIIlIlIlllIlIl(Ref.getLC().llIlIIIllIIlIllIllIllllIl().lllllIllIllIllllIlIllllII());
        YggdrasilUserAuthentication yggdrasilUserAuthentication = AuthUtil.SERVICE;
        if (yggdrasilUserAuthentication.isLoggedIn()) {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Logged in to new account with username and pass while logged in, logging out of previous account.", new Object[0]);
            yggdrasilUserAuthentication.logOut();
        }
        yggdrasilUserAuthentication.setPassword(password);
        yggdrasilUserAuthentication.setUsername(username);
        yggdrasilUserAuthentication.logIn();
        this.setUsername(username);
        this.setAccessToken(yggdrasilUserAuthentication.getAuthenticatedToken());
        this.setProfile(new MinecraftProfileJson(yggdrasilUserAuthentication.getSelectedProfile().getId().toString().replace("-", ""), yggdrasilUserAuthentication.getSelectedProfile().getName()));
        this.setType(AccountType.MOJANG);
        this.setRemoteId(UUID.randomUUID().toString().replace("-", ""));
        AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Was able to log into account [%s] by username and password", username);
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        if (this.getAccessToken() == null) {
            return false;
        }
        JsonObject jsonObject = AuthUtil.IlllIIIIIIlllIlIIlllIlIIl(this.getAccessToken());
        if (!jsonObject.has("exp")) {
            return false;
        }
        return System.currentTimeMillis() < (long)jsonObject.get("exp").getAsInt() * 1000L;
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
        this.IlIlIlllllIlIIlIlIlllIlIl(Ref.getLC().llIlIIIllIIlIllIllIllllIl().lllllIllIllIllllIlIllllII());
        YggdrasilUserAuthentication yggdrasilUserAuthentication = AuthUtil.SERVICE;
        if (yggdrasilUserAuthentication.isLoggedIn()) {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Logged in to new account with username and pass while logged in, logging out of previous account.", new Object[0]);
            yggdrasilUserAuthentication.logOut();
        }
        yggdrasilUserAuthentication.loadFromStorage(ImmutableMap.of("displayName", this.getProfile().getName(), "uuid", this.getProfile().getId(), "accessToken", this.getAccessToken(), "username", this.getUsername()));
        try {
            yggdrasilUserAuthentication.logIn();
        } catch (AuthenticationException authenticationException) {
            this.setAccessToken(null);
            authenticationException.printStackTrace();
            return false;
        }
        this.setAccessToken(yggdrasilUserAuthentication.getAuthenticatedToken());
        Ref.getMinecraft().bridge$setSession(Bridge.getInstance().initSession(yggdrasilUserAuthentication.getSelectedProfile().getName(), yggdrasilUserAuthentication.getSelectedProfile().getId().toString().replace("-", ""), yggdrasilUserAuthentication.getAuthenticatedToken(), "mojang"));
        return true;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(String token) {
        if (token == null) {
            token = UUID.randomUUID().toString().replace("-", "");
            Ref.getLC().llIlIIIllIIlIllIllIllllIl().lIlIlIlIlIIlIIlIIllIIIIIl(token);
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Generated client token: %s", token);
        } else {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Reused client token: %s", token);
        }
        AuthUtil.llIlllIIIllllIIlllIllIIIl(token);
    }
}
