package com.moonsworth.lunar.client.account;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.AccountsConfig;
import com.moonsworth.lunar.client.registry.PlayerHeadManager;
import com.moonsworth.lunar.client.setting.Json;

import java.time.Instant;

public abstract class Account
implements Json {
    public static final ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "steve.png");
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public Instant lIllIlIIIlIIIIIIIlllIlIll;
    public String llIlllIIIllllIIlllIllIIIl;
    public MinecraftProfile llllIIlIIlIIlIIllIIlIIllI;
    public String IlIlIlllllIlIIlIlIlllIlIl;
    public AccountType llIIIIIIIllIIllIlIllIIIIl;
    public String lIIIllIllIIllIlllIlIIlllI;
    public MojangAccount IlllllIlIIIlIIlIIllIIlIll;
    public transient String llIIlIlIIIllIlIlIlIIlIIll;
    public transient ResourceLocationBridge llIIIlllIIlllIllllIlIllIl;

    public Account(String string) {
        this.llIlllIIIllllIIlllIllIIIl = string;
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        this.lIllIlIIIlIIIIIIIlllIlIll = jsonObject.has("accessTokenExpiresAt") && !jsonObject.get("accessTokenExpiresAt").isJsonNull() ? Instant.parse(jsonObject.get("accessTokenExpiresAt").getAsString()) : null;
        this.llIlllIIIllllIIlllIllIIIl = jsonObject.get("localId").getAsString();
        this.llllIIlIIlIIlIIllIIlIIllI = new MinecraftProfile();
        this.llllIIlIIlIIlIIllIIlIIllI.IlllIIIIIIlllIlIIlllIlIIl(jsonObject.get("minecraftProfile").getAsJsonObject());
        this.IlIlIlllllIlIIlIlIlllIlIl = jsonObject.get("remoteId").getAsString();
        this.llIIIIIIIllIIllIlIllIIIIl = AccountType.valueOf(jsonObject.get("type").getAsString().toUpperCase());
        if (jsonObject.has("username")) {
            this.lIIIllIllIIllIlllIlIIlllI = jsonObject.get("username").getAsString();
        }
        if (jsonObject.has("accessToken")) {
            this.IlllIIIIIIlllIlIIlllIlIIl = jsonObject.get("accessToken").getAsString();
        } else {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("No access token found for [%s]", this.lIIIllIllIIllIlllIlIIlllI);
        }
        this.IlllllIlIIIlIIlIIllIIlIll = new MojangAccount();
        this.IlllllIlIIIlIIlIIllIIlIll.IlllIIIIIIlllIlIIlllIlIIl(jsonObject);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.add(this.llIlllIIIllllIIlllIllIIIl, jsonObject2);
        jsonObject2.addProperty("accessToken", this.IlllIIIIIIlllIlIIlllIlIIl);
        if (this.lIllIlIIIlIIIIIIIlllIlIll != null) {
            jsonObject2.addProperty("accessTokenExpiresAt", this.lIllIlIIIlIIIIIIIlllIlIll.toString());
        }
        if (this.IlllllIlIIIlIIlIIllIIlIll == null) {
            this.IlllllIlIIIlIIlIIllIIlIll = new MojangAccount();
        }
        this.IlllllIlIIIlIIlIIllIIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2);
        jsonObject2.addProperty("localId", this.llIlllIIIllllIIlllIllIIIl);
        this.llllIIlIIlIIlIIllIIlIIllI.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2);
        jsonObject2.addProperty("remoteId", this.IlIlIlllllIlIIlIlIlllIlIl);
        jsonObject2.addProperty("type", this.llIIIIIIIllIIllIlIllIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl());
        jsonObject2.addProperty("username", this.lIIIllIllIIllIlllIlIIlllI);
    }

    public abstract boolean lIlIlIlIlIIlIIlIIllIIIIIl();

    public abstract boolean IlllIIIIIIlllIlIIlllIlIIl();

    public abstract int lIllIlIIIlIIIIIIIlllIlIll();

    public ResourceLocationBridge llIlllIIIllllIIlllIllIIIl() {
        if (this.llIIIlllIIlllIllllIlIllIl == null) {
            if (this.llllIIlIIlIIlIIllIIlIIllI == null) {
                return lIlIlIlIlIIlIIlIIllIIIIIl;
            }
            this.llIIIlllIIlllIllllIlIllIl = PlayerHeadManager.lIlIlIlIlIIlIIlIIllIIIIIl(this.llllIIlIIlIIlIIllIIlIIllI.lIlIlIlIlIIlIIlIIllIIIIIl());
        }
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public String llllIIlIIlIIlIIllIIlIIllI() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public Instant IlIlIlllllIlIIlIlIlllIlIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public String llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public MinecraftProfile lIIIllIllIIllIlllIlIIlllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public String IlllllIlIIIlIIlIIllIIlIll() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public AccountType llIIlIlIIIllIlIlIlIIlIIll() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public String llIIIlllIIlllIllllIlIllIl() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public MojangAccount lllllIllIllIllllIlIllllII() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public String lllIIIIIlllIIlIllIIlIIIlI() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Instant instant) {
        this.lIllIlIIIlIIIIIIIlllIlIll = instant;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String string) {
        this.llIlllIIIllllIIlllIllIIIl = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(MinecraftProfile minecraftProfile) {
        this.llllIIlIIlIIlIIllIIlIIllI = minecraftProfile;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(String string) {
        this.IlIlIlllllIlIIlIlIlllIlIl = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AccountType accountType) {
        this.llIIIIIIIllIIllIlIllIIIIl = accountType;
    }

    public void llIlllIIIllllIIlllIllIIIl(String string) {
        this.lIIIllIllIIllIlllIlIIlllI = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(MojangAccount mojangAccount) {
        this.IlllllIlIIIlIIlIIllIIlIll = mojangAccount;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(String string) {
        this.llIIlIlIIIllIlIlIlIIlIIll = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge) {
        this.llIIIlllIIlllIllllIlIllIl = resourceLocationBridge;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Account)) {
            return false;
        }
        Account account = (Account)object;
        if (!account.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
            return false;
        }
        String string = this.llllIIlIIlIIlIIllIIlIIllI();
        String string2 = account.llllIIlIIlIIlIIllIIlIIllI();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        Instant instant = this.IlIlIlllllIlIIlIlIlllIlIl();
        Instant instant2 = account.IlIlIlllllIlIIlIlIlllIlIl();
        if (instant == null ? instant2 != null : !((Object)instant).equals(instant2)) {
            return false;
        }
        String string3 = this.llIIIIIIIllIIllIlIllIIIIl();
        String string4 = account.llIIIIIIIllIIllIlIllIIIIl();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        MinecraftProfile minecraftProfile = this.lIIIllIllIIllIlllIlIIlllI();
        MinecraftProfile minecraftProfile2 = account.lIIIllIllIIllIlllIlIIlllI();
        if (minecraftProfile == null ? minecraftProfile2 != null : !((Object)minecraftProfile).equals(minecraftProfile2)) {
            return false;
        }
        String string5 = this.IlllllIlIIIlIIlIIllIIlIll();
        String string6 = account.IlllllIlIIIlIIlIIllIIlIll();
        if (string5 == null ? string6 != null : !string5.equals(string6)) {
            return false;
        }
        AccountType accountType = this.llIIlIlIIIllIlIlIlIIlIIll();
        AccountType accountType2 = account.llIIlIlIIIllIlIlIlIIlIIll();
        if (accountType == null ? accountType2 != null : !((Object)((Object)accountType)).equals((Object)accountType2)) {
            return false;
        }
        String string7 = this.llIIIlllIIlllIllllIlIllIl();
        String string8 = account.llIIIlllIIlllIllllIlIllIl();
        if (string7 == null ? string8 != null : !string7.equals(string8)) {
            return false;
        }
        MojangAccount mojangAccount = this.lllllIllIllIllllIlIllllII();
        MojangAccount mojangAccount2 = account.lllllIllIllIllllIlIllllII();
        return !(mojangAccount == null ? mojangAccount2 != null : !mojangAccount.equals(mojangAccount2));
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
        return object instanceof Account;
    }

    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.llllIIlIIlIIlIIllIIlIIllI();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        Instant instant = this.IlIlIlllllIlIIlIlIlllIlIl();
        n2 = n2 * 59 + (instant == null ? 43 : ((Object)instant).hashCode());
        String string2 = this.llIIIIIIIllIIllIlIllIIIIl();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        MinecraftProfile minecraftProfile = this.lIIIllIllIIllIlllIlIIlllI();
        n2 = n2 * 59 + (minecraftProfile == null ? 43 : ((Object)minecraftProfile).hashCode());
        String string3 = this.IlllllIlIIIlIIlIIllIIlIll();
        n2 = n2 * 59 + (string3 == null ? 43 : string3.hashCode());
        AccountType accountType = this.llIIlIlIIIllIlIlIlIIlIIll();
        n2 = n2 * 59 + (accountType == null ? 43 : ((Object)((Object)accountType)).hashCode());
        String string4 = this.llIIIlllIIlllIllllIlIllIl();
        n2 = n2 * 59 + (string4 == null ? 43 : string4.hashCode());
        MojangAccount mojangAccount = this.lllllIllIllIllllIlIllllII();
        n2 = n2 * 59 + (mojangAccount == null ? 43 : mojangAccount.hashCode());
        return n2;
    }

    public String toString() {
        return "Account(accessToken=" + this.llllIIlIIlIIlIIllIIlIIllI() + ", accessTokenExpiresAt=" + this.IlIlIlllllIlIIlIlIlllIlIl() + ", localId=" + this.llIIIIIIIllIIllIlIllIIIIl() + ", profile=" + this.lIIIllIllIIllIlllIlIIlllI() + ", remoteId=" + this.IlllllIlIIIlIIlIIllIIlIll() + ", type=" + (Object)((Object)this.llIIlIlIIIllIlIlIlIIlIIll()) + ", username=" + this.llIIIlllIIlllIllllIlIllIl() + ", accountComplianceData=" + this.lllllIllIllIllllIlIllllII() + ", refreshToken=" + this.lllIIIIIlllIIlIllIIlIIIlI() + ", head=" + this.llIlllIIIllllIIlllIllIIIl() + ")";
    }
}
 