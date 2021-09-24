package com.moonsworth.lunar.client.notification;

import com.moonsworth.lunar.client.setting.IEnumSetting;

public enum NotificationPosition implements IEnumSetting {
    TOP_LEFT("TOP_LEFT", 0, (p0, p1, p2, n13) -> n13, (p0, p1, n9, n14) -> n14 + n9),
    BOTTOM_LEFT("BOTTOM_LEFT", 1, (p0, p1, p2, n15) -> n15, (n, n5, n10, n16) -> n - n16 - n10 - n5),
    TOP_RIGHT("TOP_RIGHT", 2, (n2, n6, p2, n17) -> n2 - n17 - n6, (p0, p1, n11, n18) -> n18 + n11),
    BOTTOM_RIGHT("BOTTOM_RIGHT", 3, (n3, n7, p2, p3) -> n3 - 5.0f - n7, (n4, n8, n12, n19) -> n4 - n19 - n12 - n8);

    public final PositionCalculator llllIIlIIlIIlIIllIIlIIllI;
    public final PositionCalculator IlIlIlllllIlIIlIlIlllIlIl;

    // todo remap above and replace with this#name()
    String nameProxy;

    @Override
    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.name().toLowerCase();
    }

    @Override
    public String toString() {
        return this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    NotificationPosition(final String s, final int n, final PositionCalculator llllIIlIIlIIlIIllIIlIIllI, final PositionCalculator ilIlIlllllIlIIlIlIlllIlIl) {
        this.nameProxy = s;
        this.llllIIlIIlIIlIIllIIlIIllI = llllIIlIIlIIlIIllIIlIIllI;
        this.IlIlIlllllIlIIlIlIlllIlIl = ilIlIlllllIlIIlIlIlllIlIl;
    }

    public PositionCalculator IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public PositionCalculator lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }
}
