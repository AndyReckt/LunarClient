package com.moonsworth.lunar.client.registry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.account.Account;
import com.moonsworth.lunar.client.account.AccountManager;
import com.moonsworth.lunar.client.account.AccountType;
import com.moonsworth.lunar.client.account.MicrosoftAccount;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.json.file.ItemMapLoader;
import com.moonsworth.lunar.client.json.file.DefaultJson;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.AuthUtil;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountsConfig
extends ItemMapLoader<Object, Account>
implements EventHandler,
        DefaultJson {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public MicrosoftAccountsConfig lIllIlIIIlIIIIIIIlllIlIll;

    public Account IlllllIlIIIlIIlIIllIIlIll() {
        if (this.IlllIIIIIIlllIlIIlllIlIIl == null) {
            return null;
        }
        return this.llIlllIIIllllIIlllIllIIIl().get(this.IlllIIIIIIlllIlIIlllIlIIl);
    }

    @Override
    public Map lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentHashMap();
    }

    @Override
    public File IlIlIlllllIlIIlIlIlllIlIl() {
        return new File(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getMcDataDir(), this.llllIIlIIlIIlIIllIIlIIllI());
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "launcher_accounts.json";
    }

    @Override
    public void b_() {
        super.b_();
        this.load();
        this.lIllIlIIIlIIIIIIIlllIlIll = new MicrosoftAccountsConfig();
        this.lIllIlIIIlIIIIIIIlllIlIll.load();
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Logging into account %s ", this.IlllIIIIIIlllIlIIlllIlIIl);
            if (!this.lIllIlIIIlIIIIIIIlllIlIll(this.IlllllIlIIIlIIlIIllIIlIll())) {
                this.IlllIIIIIIlllIlIIlllIlIIl((String)null);
            }
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        if (jsonObject.has("mojangClientToken")) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = jsonObject.get("mojangClientToken").getAsString();
        }
        String string = "";
        if (jsonObject.has("activeAccountLocalId")) {
            string = jsonObject.get("activeAccountLocalId").getAsString();
        }
        JsonObject jsonObject2 = jsonObject.get("accounts").getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject2.entrySet()) {
            Account account;
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Attempting to load account [%s]", entry.getKey());
            JsonObject jsonObject3 = entry.getValue().getAsJsonObject();
            AccountType accountType = AccountType.valueOf(jsonObject3.get("type").getAsString().toUpperCase());
            if (accountType == AccountType.IlllIIIIIIlllIlIIlllIlIIl) {
                account = new MicrosoftAccount(entry.getKey());
            } else if (accountType == AccountType.lIlIlIlIlIIlIIlIIllIIIIIl) {
                account = new AccountManager(entry.getKey());
            } else {
                throw new IllegalArgumentException("Unknown type for " + accountType.name());
            }
            account.IlllIIIIIIlllIlIIlllIlIIl(jsonObject3);
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Loaded content for [%s] Token IAT", account.llIIIlllIIlllIllllIlIllIl(), account.lIllIlIIIlIIIIIIIlllIlIll());
            Account account2 = this.llIlllIIIllllIIlllIllIIIl().get(account.llIIIlllIIlllIllllIlIllIl());
            if (account2 != null) {
                if (!account.IlllIIIIIIlllIlIIlllIlIIl()) {
                    AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Account was skipped due to double account which is invalid.", new Object[0]);
                    continue;
                }
                if (account2.lIllIlIIIlIIIIIIIlllIlIll() < account.lIllIlIIIlIIIIIIIlllIlIll()) {
                    AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Double Account, getting the newer one so we're skipping this one.", new Object[0]);
                    continue;
                }
                this.llIlllIIIllllIIlllIllIIIl().remove(account.llIIIlllIIlllIllllIlIllIl());
                if (this.IlllIIIIIIlllIlIIlllIlIIl.equals(account.llIIIlllIIlllIllllIlIllIl())) {
                    this.IlllIIIIIIlllIlIIlllIlIIl = account.llIIIlllIIlllIllllIlIllIl();
                    string = entry.getKey();
                }
                AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Removing old account.", new Object[0]);
                AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Duplicate account found!", new Object[0]);
            }
            this.llIlllIIIllllIIlllIllIIIl().put(account.llIIIlllIIlllIllllIlIllIl(), account);
            if (!string.equals(entry.getKey()) && (account2 == null || !account2.llIIIIIIIllIIllIlIllIIIIl().equals(entry.getKey()))) continue;
            this.IlllIIIIIIlllIlIIlllIlIIl = account.llIIIlllIIlllIllllIlIllIl();
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
        this.lIllIlIIIlIIIIIIIlllIlIll.save();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        jsonObject.addProperty("mojangClientToken", this.lIlIlIlIlIIlIIlIIllIIIIIl);
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            jsonObject.addProperty("activeAccountLocalId", this.IlllllIlIIIlIIlIIllIIlIll().llIIIIIIIllIIllIlIllIIIIl());
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.add("accounts", jsonObject2);
        for (Account account : this.llIlllIIIllllIIlllIllIIIl().values()) {
            account.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2);
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Account account) {
        this.llIlllIIIllllIIlllIllIIIl().remove(account.llIIIlllIIlllIllllIlIllIl());
        this.save();
        return true;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(Account account) {
        this.llIlllIIIllllIIlllIllIIIl().put(account.llIIIlllIIlllIllllIlIllIl(), account);
        this.save();
        return true;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll(Account account) {
        if (account == null || account.llllIIlIIlIIlIIllIIlIIllI() == null) {
            return false;
        }
        String string = this.IlllIIIIIIlllIlIIlllIlIIl;
        this.IlllIIIIIIlllIlIIlllIlIIl = account.llIIIlllIIlllIllllIlIllIl();
        if (account.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Able to login %s", this.IlllIIIIIIlllIlIIlllIlIIl);
            return true;
        }
        AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("Failed to login to account! Resetting currentAccount to %s", string);
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
        return false;
    }

    public boolean llIIlIlIIIllIlIlIlIIlIIll() {
        return LunarClient.IIllIlIllIlIllIllIllIllII().llIlIIIllIIlIllIllIllllIl().IlllllIlIIIlIIlIIllIIlIll() != null && LunarClient.IIllIlIllIlIllIllIllIllII().llIlIIIllIIlIllIllIllllIl().IlllllIlIIIlIIlIIllIIlIll().llllIIlIIlIIlIIllIIlIIllI() != null && this.IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl();
    }

    public boolean llIIIlllIIlllIllllIlIllIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl != null && this.IlllllIlIIIlIIlIIllIIlIll() != null && (this.IlllllIlIIIlIIlIIllIIlIll().llIIlIlIIIllIlIlIlIIlIIll() == AccountType.IlllIIIIIIlllIlIIlllIlIIl || AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl != null && AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl.canPlayOnline());
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(Object object, Object ... objectArray) {
        LunarLogger.IlllIIIIIIlllIlIIlllIlIIl("Accounts", object, objectArray);
    }

    @Override
    public Map<Object, Account> llIlllIIIllllIIlllIllIIIl() {
        return super.llIlllIIIllllIIlllIllIIIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
    }

    public String lllllIllIllIllllIlIllllII() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String string) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
    }
}
 