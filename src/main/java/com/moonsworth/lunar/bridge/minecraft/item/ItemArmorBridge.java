package com.moonsworth.lunar.bridge.minecraft.item;

public interface ItemArmorBridge extends ItemBridge {
    int bridge$getArmorType();

    boolean bridge$hasColor(ItemStackBridge var1);

    int bridge$getColor(ItemStackBridge var1);

    ItemArmorBridge.ArmorMaterial bridge$getArmorMaterial();

    enum ArmorMaterial {
        lIlIlIlIlIIlIIlIIllIIIIIl("leather"),
        IlllIIIIIIlllIlIIlllIlIIl("chainmail"),
        lIllIlIIIlIIIIIIIlllIlIll("iron"),
        llIlllIIIllllIIlllIllIIIl("gold"),
        llllIIlIIlIIlIIllIIlIIllI("diamond"),
        IlIlIlllllIlIIlIlIlllIlIl("turtle"),
        llIIIIIIIllIIllIlIllIIIIl("netherite");

        public String lIIIllIllIIllIlllIlIIlllI;

        ArmorMaterial(String var3) {
            this.lIIIllIllIIllIlllIlIIlllI = var3;
        }

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.lIIIllIllIIllIlllIlIIlllI;
        }
    }
}
