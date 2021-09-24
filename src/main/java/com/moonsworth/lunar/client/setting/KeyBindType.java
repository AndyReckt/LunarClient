package com.moonsworth.lunar.client.setting;

public enum KeyBindType implements IEnumSetting {
    HOLD,
    TOGGLE;

    @Override
    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.name();
    }

    @Override
    public String toString() {
        return this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl().toLowerCase());
    }
}
