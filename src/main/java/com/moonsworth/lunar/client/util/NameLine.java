package com.moonsworth.lunar.client.util;

import java.util.LinkedHashSet;
import java.util.Set;

public class NameLine {
    public Set lIlIlIlIlIIlIIlIIllIIIIIl = new LinkedHashSet();

    public NameLine(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.add(new NameLineData(-1, string));
    }

    public NameLine(NameLineData nameLineData) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.add(nameLineData);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NameLineData nameLineData) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.add(nameLineData);
    }

    public Set lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new LinkedHashSet(this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public static class NameLineData {
        public int lIlIlIlIlIIlIIlIIllIIIIIl;
        public String IlllIIIIIIlllIlIIlllIlIIl;

        public int lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public String IlllIIIIIIlllIlIIlllIlIIl() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
            this.IlllIIIIIIlllIlIIlllIlIIl = string;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof NameLineData)) {
                return false;
            }
            NameLineData nameLineData = (NameLineData)object;
            if (!nameLineData.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
                return false;
            }
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl() != nameLineData.lIlIlIlIlIIlIIlIIllIIIIIl()) {
                return false;
            }
            String string = this.IlllIIIIIIlllIlIIlllIlIIl();
            String string2 = nameLineData.IlllIIIIIIlllIlIIlllIlIIl();
            return !(string == null ? string2 != null : !string.equals(string2));
        }

        public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
            return object instanceof NameLineData;
        }

        public int hashCode() {
            int n = 59;
            int n2 = 1;
            n2 = n2 * 59 + this.lIlIlIlIlIIlIIlIIllIIIIIl();
            String string = this.IlllIIIIIIlllIlIIlllIlIIl();
            n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
            return n2;
        }

        public String toString() {
            return "NameLine.NameLineData(color=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", text=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ")";
        }

        public NameLineData(int n, String string) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
            this.IlllIIIIIIlllIlIIlllIlIIl = string;
        }
    }
}
