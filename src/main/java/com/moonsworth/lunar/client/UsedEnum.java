package com.moonsworth.lunar.client;

import com.moonsworth.lunar.client.setting.IEnumSetting;

public enum UsedEnum implements IEnumSetting {
    ALL,
    MOVEMENT_UI,
    F3_KEYS,
    ASSET_SERVER;


    @Override
    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.name().replace("_", " ");
    }
}
