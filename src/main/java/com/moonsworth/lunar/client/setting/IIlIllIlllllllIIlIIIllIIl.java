package com.moonsworth.lunar.client.setting;

import java.util.function.BooleanSupplier;

/**
 * @author Decencies
 * @since 10/07/2021 15:51
 */
public class IIlIllIlllllllIIlIIIllIIl extends BooleanSetting {
    public final String lIlIlIlIlIIlIIlIIllIIIIIl;

    public IIlIllIlllllllIIlIIIllIIl(BooleanSetting booleanSetting, String string, String string2, Boolean bl, BooleanSupplier booleanSupplier) {
        super(booleanSetting, string, bl, booleanSupplier);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string2 + "_bl";
    }

    public IIlIllIlllllllIIlIIIllIIl(BooleanSetting booleanSetting, String string, String string2, Boolean bl) {
        super(booleanSetting, string, bl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string2 + "_bl";
    }

    public IIlIllIlllllllIIlIIIllIIl(String string, String string2, Boolean bl, BooleanSupplier booleanSupplier) {
        super(string, bl, booleanSupplier);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string2 + "_bl";
    }

    public IIlIllIlllllllIIlIIIllIIl(String string, String string2, Boolean bl) {
        super(string, bl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string2 + "_bl";
    }

    @Override
    public String f_() {
        return this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public String llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
