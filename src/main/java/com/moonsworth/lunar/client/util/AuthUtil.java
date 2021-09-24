package com.moonsworth.lunar.client.util;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.moonsworth.lunar.client.account.Account;
import com.moonsworth.lunar.client.account.MicrosoftAccount;
import com.moonsworth.lunar.client.account.MinecraftProfileJson;
import com.moonsworth.lunar.client.javafx.MicrosoftAuthApp;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.login.MainMenuLoginUIScreen;
import org.apache.commons.codec.binary.Base64;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.Proxy;
import java.time.Instant;
import java.util.UUID;

public final class AuthUtil {
    public static YggdrasilUserAuthentication SERVICE;
    public static final String IlllIIIIIIlllIlIIlllIlIIl = "00000000402b5328";
    public static final String lIllIlIIIlIIIIIIIlllIlIll = "https://login.live.com/oauth20_authorize.srf?client_id=00000000402b5328&response_type=code&scope=service%3A%3Auser.auth.xboxlive.com%3A%3AMBI_SSL&redirect_uri=https%3A%2F%2Flogin.live.com%2Foauth20_desktop.srf";
    public static final String llIlllIIIllllIIlllIllIIIl = "https://login.live.com/oauth20_desktop.srf";
    public static final String llllIIlIIlIIlIIllIIlIIllI = "https://login.live.com/oauth20_desktop.srf?code=";
    public static final String IlIlIlllllIlIIlIlIlllIlIl = "https://login.live.com/oauth20_token.srf";
    public static final String llIIIIIIIllIIllIlIllIIIIl = "https://user.auth.xboxlive.com/user/authenticate";
    public static final String lIIIllIllIIllIlllIlIIlllI = "https://xsts.auth.xboxlive.com/xsts/authorize";
    public static final String IlllllIlIIIlIIlIIllIIlIll = "https://api.minecraftservices.com/authentication/login_with_xbox";
    public static final String llIIlIlIIIllIlIlIlIIlIIll = "https://api.minecraftservices.com/entitlements/mcstore";
    public static final String llIIIlllIIlllIllllIlIllIl = "https://api.minecraftservices.com/minecraft/profile";

    public static void lIlIlIlIlIIlIIlIIllIIIIIl() {
        MicrosoftAuthApp.start();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(Account account) {
        if (account.getRefreshToken() == null) {
            AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl();
            return;
        }
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("client_id", IlllIIIIIIlllIlIIlllIlIIl, "refresh_token", account.getRefreshToken(), "grant_type", "refresh_token", "redirect_uri", llIlllIIIllllIIlllIllIIIl);
        ImmutableMap<String, String> immutableMap2 = ImmutableMap.of("Content-Type", "application/x-www-form-urlencoded");
        HttpUtil.lIlIlIlIlIIlIIlIIllIIIIIl(IlIlIlllllIlIIlIlIlllIlIl, immutableMap2, immutableMap, false, jsonObject -> {
            account.setRefreshToken(jsonObject.get("refresh_token").getAsString());
            AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject.get("access_token").getAsString(), account);
        });
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("client_id", IlllIIIIIIlllIlIIlllIlIIl, "code", string, "grant_type", "authorization_code", "redirect_uri", llIlllIIIllllIIlllIllIIIl, "scope", "service::user.auth.xboxlive.com::MBI_SSL");
        ImmutableMap<String, String> immutableMap2 = ImmutableMap.of("Content-Type", "application/x-www-form-urlencoded");
        HttpUtil.lIlIlIlIlIIlIIlIIllIIIIIl(IlIlIlllllIlIIlIlIlllIlIl, immutableMap2, immutableMap, false, jsonObject -> {
            MicrosoftAccount microsoftAccount = new MicrosoftAccount(UUID.randomUUID().toString().replace("-", ""));
            microsoftAccount.setRefreshToken(jsonObject.get("refresh_token").getAsString());
            AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject.get("access_token").getAsString(), microsoftAccount);
        });
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String rpsTicket, Account account) {
        ImmutableMap<String, Serializable> immutableMap = ImmutableMap.of("Properties", ImmutableMap.of("AuthMethod", "RPS", "SiteName", "user.auth.xboxlive.com", "RpsTicket", rpsTicket), "RelyingParty", "http://auth.xboxlive.com", "TokenType", "JWT");
        ImmutableMap<String, String> immutableMap2 = ImmutableMap.of("Content-Type", "application/json", "Accept", "application/json");
        HttpUtil.lIlIlIlIlIIlIIlIIllIIIIIl(llIIIIIIIllIIllIlIllIIIIl, immutableMap2, immutableMap, true, jsonObject -> {
            String string = jsonObject.get("Token").getAsString();
            AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl(account, string);
        });
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(Account account, String userTokens) {
        ImmutableMap<String, Serializable> immutableMap = ImmutableMap.of("Properties", ImmutableMap.of("SandboxId", "RETAIL", "UserTokens", ImmutableList.of(userTokens)), "RelyingParty", "rp://api.minecraftservices.com/", "TokenType", "JWT");
        ImmutableMap<String, String> immutableMap2 = ImmutableMap.of("Content-Type", "application/json", "Accept", "application/json");
        HttpUtil.lIlIlIlIlIIlIIlIIllIIIIIl(lIIIllIllIIllIlllIlIIlllI, immutableMap2, immutableMap, true, jsonObject -> {
            String string = jsonObject.get("Token").getAsString();
            JsonObject jsonObject2 = jsonObject.getAsJsonObject("DisplayClaims");
            JsonArray jsonArray = jsonObject2.getAsJsonArray("xui");
            String string2 = jsonArray.get(0).getAsJsonObject().get("uhs").getAsString();
            AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl(account, string2, string);
        });
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(Account account, String x, String string2) {
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("identityToken", "XBL3.0 x=" + x + ";" + string2);
        ImmutableMap<String, String> immutableMap2 = ImmutableMap.of("Content-Type", "application/json", "Accept", "application/json");
        HttpUtil.lIlIlIlIlIIlIIlIIllIIIIIl(IlllllIlIIIlIIlIIllIIlIll, immutableMap2, immutableMap, true, jsonObject -> {
            String string = jsonObject.get("access_token").getAsString();
            account.setAccessToken(string);
            account.setAccessTokenExpiresAt(Instant.now().plusSeconds(jsonObject.get("expires_in").getAsInt()));
            JsonObject jsonObject2 = AuthUtil.IlllIIIIIIlllIlIIlllIlIIl(string);
            if (jsonObject2.has("xuid")) {
                account.setRemoteId(jsonObject2.get("xuid").getAsString());
            }
            AuthUtil.IlllIIIIIIlllIlIIlllIlIIl(account, string);
        });
    }

    public static void IlllIIIIIIlllIlIIlllIlIIl(Account account, String bearer) {
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("Authorization", "Bearer " + bearer);
        HttpUtil.lIlIlIlIlIIlIIlIIllIIIIIl(llIIlIlIIIllIlIlIlIIlIIll, immutableMap, (jsonObject) -> {
            if (jsonObject.get("items").getAsJsonArray().size() == 0) {
                return;
            }
            AuthUtil.lIllIlIIIlIIIIIIIlllIlIll(account, bearer);
        });
    }

    public static void lIllIlIIIlIIIIIIIlllIlIll(Account account, String bearer) {
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("Authorization", "Bearer " + bearer);
        HttpUtil.lIlIlIlIlIIlIIlIIllIIIIIl(llIIIlllIIlllIllllIlIllIl, immutableMap, (jsonObject) -> {
            String name = jsonObject.get("name").getAsString();
            String id = jsonObject.get("id").getAsString();
            //String string3 = AuthUtil.lIllIlIIIlIIIIIIIlllIlIll(id);
            MinecraftProfileJson minecraftProfileJson = new MinecraftProfileJson(id, name);
            account.setProfile(minecraftProfileJson);
            account.setUsername(name);
            Ref.getLC().llIlIIIllIIlIllIllIllllIl().IlllIIIIIIlllIlIIlllIlIIl(account);
            Ref.getLC().llIlIIIllIIlIllIllIllllIl().lIllIlIIIlIIIIIIIlllIlIll(account);
            if (Ref.llIIIlllIIlllIllllIlIllIl() == MainMenuLoginUIScreen.class) {
                Ref.getMinecraft().bridge$displayScreen(null);
            }
        });
    }

    public static JsonObject IlllIIIIIIlllIlIIlllIlIIl(String string) {
        JsonObject jsonObject = new JsonObject();
        if (string.contains(".") && string.split("\\.").length >= 2) {
            String string2 = new String(Base64.decodeBase64(string.split("\\.")[1]), Charsets.UTF_8);
            JsonParser jsonParser = new JsonParser();
            try {
                JsonElement jsonElement = jsonParser.parse(string2);
                if (jsonElement.isJsonObject()) {
                    jsonObject = (JsonObject)jsonElement;
                }
            } catch (Exception exception) {
                return jsonObject;
            }
        }
        return jsonObject;
    }

    public static String lIllIlIIIlIIIIIIIlllIlIll(String string) {
        if (string.contains("-")) {
            return string;
        }
        return string.replaceAll("-", "").replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5");
    }

    public static void llIlllIIIllllIIlllIllIIIl(String string) {
        boolean bl = SERVICE == null;
        if (!bl) {
            YggdrasilAuthenticationService yggdrasilAuthenticationService = SERVICE.getAuthenticationService();
            try {
                bl = !yggdrasilAuthenticationService.getClientToken().equals(string);
            } catch (NoSuchMethodError noSuchMethodError) {
                try {
                    Field field = yggdrasilAuthenticationService.getClass().getField("mojangClientToken");
                    String string2 = (String)field.get(yggdrasilAuthenticationService);
                    bl = !string2.equals(string);
                } catch (IllegalAccessException | NoSuchFieldException reflectiveOperationException) {
                    reflectiveOperationException.printStackTrace();
                }
            }
        }
        if (bl) {
            SERVICE = (YggdrasilUserAuthentication)new YggdrasilAuthenticationService(Proxy.NO_PROXY, string).createUserAuthentication(Agent.MINECRAFT);
            LunarLogger.info("Accounts", "Initialized authentication service with client token " + string);
        }
    }

    public AuthUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
