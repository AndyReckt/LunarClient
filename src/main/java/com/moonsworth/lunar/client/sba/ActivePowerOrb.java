package com.moonsworth.lunar.client.sba;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

public class ActivePowerOrb {
    public int lIlIlIlIlIIlIIlIIllIIIIIl;
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public double lIllIlIIIlIIIIIIIlllIlIll;
    public double llIlllIIIllllIIlllIllIIIl;
    public int llllIIlIIlIIlIIllIIlIIllI;
    public double IlIlIlllllIlIIlIlIlllIlIl;
    public ResourceLocationBridge llIIIIIIIllIIllIlIllIIIIl;

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(double d) {
        return d <= 324.0;
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public double lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public double llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public int llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public double IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public ResourceLocationBridge llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(double d) {
        this.lIllIlIIIlIIIIIIIlllIlIll = d;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(double d) {
        this.llIlllIIIllllIIlllIllIIIl = d;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.llllIIlIIlIIlIIllIIlIIllI = n;
    }

    public void llIlllIIIllllIIlllIllIIIl(double d) {
        this.IlIlIlllllIlIIlIlIlllIlIl = d;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge) {
        this.llIIIIIIIllIIllIlIllIIIIl = resourceLocationBridge;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ActivePowerOrb)) {
            return false;
        }
        ActivePowerOrb activePowerOrb = (ActivePowerOrb)object;
        if (!activePowerOrb.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
            return false;
        }
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl() != activePowerOrb.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            return false;
        }
        if (Double.compare(this.lIllIlIIIlIIIIIIIlllIlIll(), activePowerOrb.lIllIlIIIlIIIIIIIlllIlIll()) != 0) {
            return false;
        }
        if (Double.compare(this.llIlllIIIllllIIlllIllIIIl(), activePowerOrb.llIlllIIIllllIIlllIllIIIl()) != 0) {
            return false;
        }
        if (this.llllIIlIIlIIlIIllIIlIIllI() != activePowerOrb.llllIIlIIlIIlIIllIIlIIllI()) {
            return false;
        }
        if (Double.compare(this.IlIlIlllllIlIIlIlIlllIlIl(), activePowerOrb.IlIlIlllllIlIIlIlIlllIlIl()) != 0) {
            return false;
        }
        String string = this.IlllIIIIIIlllIlIIlllIlIIl();
        String string2 = activePowerOrb.IlllIIIIIIlllIlIIlllIlIIl();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        ResourceLocationBridge resourceLocationBridge = this.llIIIIIIIllIIllIlIllIIIIl();
        ResourceLocationBridge resourceLocationBridge2 = activePowerOrb.llIIIIIIIllIIllIlIllIIIIl();
        return !(resourceLocationBridge == null ? resourceLocationBridge2 != null : !resourceLocationBridge.equals(resourceLocationBridge2));
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
        return object instanceof ActivePowerOrb;
    }

    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + this.lIlIlIlIlIIlIIlIIllIIIIIl();
        long l = Double.doubleToLongBits(this.lIllIlIIIlIIIIIIIlllIlIll());
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        long l2 = Double.doubleToLongBits(this.llIlllIIIllllIIlllIllIIIl());
        n2 = n2 * 59 + (int)(l2 >>> 32 ^ l2);
        n2 = n2 * 59 + this.llllIIlIIlIIlIIllIIlIIllI();
        long l3 = Double.doubleToLongBits(this.IlIlIlllllIlIIlIlIlllIlIl());
        n2 = n2 * 59 + (int)(l3 >>> 32 ^ l3);
        String string = this.IlllIIIIIIlllIlIIlllIlIIl();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        ResourceLocationBridge resourceLocationBridge = this.llIIIIIIIllIIllIlIllIIIIl();
        n2 = n2 * 59 + (resourceLocationBridge == null ? 43 : resourceLocationBridge.hashCode());
        return n2;
    }

    public String toString() {
        return "ActivePowerOrb(seconds=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", display=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", healthRegen=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ", manaRegen=" + this.llIlllIIIllllIIlllIllIIIl() + ", strength=" + this.llllIIlIIlIIlIIllIIlIIllI() + ", healIncrease=" + this.IlIlIlllllIlIIlIlIlllIlIl() + ", resourceLocationBridge=" + this.llIIIIIIIllIIllIlIllIIIIl() + ")";
    }

    public ActivePowerOrb(int n, String string, double d, double d2, int n2, double d3, ResourceLocationBridge resourceLocationBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
        this.lIllIlIIIlIIIIIIIlllIlIll = d;
        this.llIlllIIIllllIIlllIllIIIl = d2;
        this.llllIIlIIlIIlIIllIIlIIllI = n2;
        this.IlIlIlllllIlIIlIlIlllIlIl = d3;
        this.llIIIIIIIllIIllIlIllIIIIl = resourceLocationBridge;
    }
}
