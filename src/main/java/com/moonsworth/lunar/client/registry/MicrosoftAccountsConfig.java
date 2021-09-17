package com.moonsworth.lunar.client.registry;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.account.Account;
import com.moonsworth.lunar.client.json.file.DefaultJson;
import com.moonsworth.lunar.client.ref.Ref;

public class MicrosoftAccountsConfig
implements DefaultJson {
    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "launcher_lc_msa.json";
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        JsonObject jsonObject2 = jsonObject.get("accounts").getAsJsonObject();
        for (Account account : Ref.IlllIIIIIIlllIlIIlllIlIIl().llIlIIIllIIlIllIllIllllIl().llIlllIIIllllIIlllIllIIIl().values()) {
            if (!jsonObject2.has(account.IlllllIlIIIlIIlIIllIIlIll())) continue;
            account.llllIIlIIlIIlIIllIIlIIllI(jsonObject2.get(account.IlllllIlIIIlIIlIIllIIlIll()).getAsString());
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.add("accounts", jsonObject2);
        for (Account account : Ref.IlllIIIIIIlllIlIIlllIlIIl().llIlIIIllIIlIllIllIllllIl().llIlllIIIllllIIlllIllIIIl().values()) {
            if (account.IlllllIlIIIlIIlIIllIIlIll() == null) continue;
            jsonObject2.addProperty(account.IlllllIlIIIlIIlIIllIIlIll(), account.lllIIIIIlllIIlIllIIlIIIlI());
        }
    }
}
 