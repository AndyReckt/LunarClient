package com.moonsworth.lunar.bridge.lunar.lang;

public enum LanguageType {
    DUTCH("nl_NL"),
    FRENCH("fr_FR"),
    ENGLISH("en_US"),
    ITALIAN("it_IT"),
    SPANISH("es_ES"),
    TURKISH("tr_TR");

    public final String llIIIIIIIllIIllIlIllIIIIl;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    LanguageType(String s) {
        this.llIIIIIIIllIIllIlIllIIIIl = s;
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }
}