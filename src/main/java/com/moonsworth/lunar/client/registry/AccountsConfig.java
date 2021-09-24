package com.moonsworth.lunar.client.registry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.account.Account;
import com.moonsworth.lunar.client.account.MojangAccount;
import com.moonsworth.lunar.client.account.AccountType;
import com.moonsworth.lunar.client.account.MicrosoftAccount;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.json.file.ItemMapLoader;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.AuthUtil;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountsConfig extends ItemMapLoader<String, Account> implements EventHandler, JsonFile {
    public String mojangClientToken;
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public MicrosoftAccountsRegistry lIllIlIIIlIIIIIIIlllIlIll;

    public Account IlllllIlIIIlIIlIIllIIlIll() {
        if (this.IlllIIIIIIlllIlIIlllIlIIl == null) {
            return null;
        }
        return this.llIlllIIIllllIIlllIllIIIl().get(this.IlllIIIIIIlllIlIIlllIlIIl);
    }

    @Override
    public Map<String, Account> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentHashMap<>();
    }

    @Override
    public File IlIlIlllllIlIIlIlIlllIlIl() {
        return new File(Ref.getMinecraft().bridge$getMcDataDir(), this.llllIIlIIlIIlIIllIIlIIllI());
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "launcher_accounts.json";
    }

    @Override
    public void b_() {
        super.b_();
        this.load();
        this.lIllIlIIIlIIIIIIIlllIlIll = new MicrosoftAccountsRegistry();
        this.lIllIlIIIlIIIIIIIlllIlIll.load();
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Logging into account %s ", this.IlllIIIIIIlllIlIIlllIlIIl);
            if (!this.lIllIlIIIlIIIIIIIlllIlIll(this.IlllllIlIIIlIIlIIllIIlIll())) {
                this.IlllIIIIIIlllIlIIlllIlIIl((String)null);
            }
        }
    }

    @Override
    public void read(JsonObject jsonObject) {
        if (jsonObject.has("mojangClientToken")) {
            this.mojangClientToken = jsonObject.get("mojangClientToken").getAsString();
        }
        String activeAccountLocalId = "";
        if (jsonObject.has("activeAccountLocalId")) {
            activeAccountLocalId = jsonObject.get("activeAccountLocalId").getAsString();
        }
        JsonObject accountsObject = jsonObject.get("accounts").getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : accountsObject.entrySet()) {
            Account account;
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Attempting to load account [%s]", entry.getKey());
            JsonObject accountObject = entry.getValue().getAsJsonObject();
            AccountType accountType = AccountType.valueOf(accountObject.get("type").getAsString().toUpperCase());
            if (accountType == AccountType.XBOX) {
                account = new MicrosoftAccount(entry.getKey());
            } else if (accountType == AccountType.MOJANG) {
                account = new MojangAccount(entry.getKey());
            } else {
                throw new IllegalArgumentException("Unknown type for " + accountType.name());
            }
            account.read(accountObject);
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Loaded content for [%s] Token IAT", account.getUsername(), account.lIllIlIIIlIIIIIIIlllIlIll());
            Account account2 = this.llIlllIIIllllIIlllIllIIIl().get(account.getUsername());
            if (account2 != null) {
                if (!account.IlllIIIIIIlllIlIIlllIlIIl()) {
                    AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Account was skipped due to double account which is invalid.", new Object[0]);
                    continue;
                }
                if (account2.lIllIlIIIlIIIIIIIlllIlIll() < account.lIllIlIIIlIIIIIIIlllIlIll()) {
                    AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Double Account, getting the newer one so we're skipping this one.", new Object[0]);
                    continue;
                }
                this.llIlllIIIllllIIlllIllIIIl().remove(account.getUsername());
                if (this.IlllIIIIIIlllIlIIlllIlIIl.equals(account.getUsername())) {
                    this.IlllIIIIIIlllIlIIlllIlIIl = account.getUsername();
                    activeAccountLocalId = entry.getKey();
                }
                AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Removing old account.", new Object[0]);
                AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Duplicate account found!", new Object[0]);
            }
            this.llIlllIIIllllIIlllIllIIIl().put(account.getUsername(), account);
            if (!activeAccountLocalId.equals(entry.getKey()) && (account2 == null || !account2.getLocalId().equals(entry.getKey()))) continue;
            this.IlllIIIIIIlllIlIIlllIlIIl = account.getUsername();
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
        this.lIllIlIIIlIIIIIIIlllIlIll.save();
    }

    @Override
    public void write(JsonObject jsonObject) {
        jsonObject.addProperty("mojangClientToken", this.mojangClientToken);
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            jsonObject.addProperty("activeAccountLocalId", this.IlllllIlIIIlIIlIIllIIlIll().getLocalId());
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.add("accounts", jsonObject2);
        for (Account account : this.llIlllIIIllllIIlllIllIIIl().values()) {
            account.write(jsonObject2);
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Account account) {
        this.llIlllIIIllllIIlllIllIIIl().remove(account.getUsername());
        this.save();
        return true;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(Account account) {
        this.llIlllIIIllllIIlllIllIIIl().put(account.getUsername(), account);
        this.save();
        return true;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll(Account account) {
        if (account == null || account.getAccessToken() == null) {
            return false;
        }
        String string = this.IlllIIIIIIlllIlIIlllIlIIl;
        this.IlllIIIIIIlllIlIIlllIlIIl = account.getUsername();
        if (account.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Able to login %s", this.IlllIIIIIIlllIlIIlllIlIIl);
            return true;
        }
        AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Failed to login to account! Resetting currentAccount to %s", string);
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
        return false;
    }

    public boolean llIIlIlIIIllIlIlIlIIlIIll() {
        return LunarClient.getInstance().llIlIIIllIIlIllIllIllllIl().IlllllIlIIIlIIlIIllIIlIll() != null && LunarClient.getInstance().llIlIIIllIIlIllIllIllllIl().IlllllIlIIIlIIlIIllIIlIll().getAccessToken() != null && this.IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl();
    }

    public boolean llIIIlllIIlllIllllIlIllIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl != null && this.IlllllIlIIIlIIlIIllIIlIll() != null && (this.IlllllIlIIIlIIlIIllIIlIll().getType() == AccountType.XBOX || AuthUtil.SERVICE != null && AuthUtil.SERVICE.canPlayOnline());
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(Object object, Object ... objectArray) {
        LunarLogger.info("Accounts", object, objectArray);
    }

    @Override
    public Map<String, Account> llIlllIIIllllIIlllIllIIIl() {
        return super.llIlllIIIllllIIlllIllIIIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.mojangClientToken = string;
    }

    public String lllllIllIllIllllIlIllllII() {
        return this.mojangClientToken;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String string) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
    }
}
