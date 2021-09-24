package com.moonsworth.lunar.client.registry;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.account.Account;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.ref.Ref;

public class MicrosoftAccountsRegistry implements JsonFile {
    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "launcher_lc_msa.json";
    }

    @Override
    public void read(JsonObject jsonObject) {
        JsonObject jsonObject2 = jsonObject.get("accounts").getAsJsonObject();
        for (Account account : Ref.getLC().llIlIIIllIIlIllIllIllllIl().llIlllIIIllllIIlllIllIIIl().values()) {
            if (!jsonObject2.has(account.getRemoteId())) continue;
            account.setRefreshToken(jsonObject2.get(account.getRemoteId()).getAsString());
        }
    }

    @Override
    public void write(JsonObject jsonObject) {
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.add("accounts", jsonObject2);
        for (Account account : Ref.getLC().llIlIIIllIIlIllIllIllllIl().llIlllIIIllllIIlllIllIIIl().values()) {
            if (account.getRemoteId() == null) continue;
            jsonObject2.addProperty(account.getRemoteId(), account.getRefreshToken());
        }
    }
}
