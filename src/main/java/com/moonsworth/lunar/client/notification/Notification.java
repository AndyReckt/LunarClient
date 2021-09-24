package com.moonsworth.lunar.client.notification;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.ease.QuadraticEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.List;

public class Notification {
    public static final float lIlIlIlIlIIlIIlIIllIIIIIl = 200.0f;
    public static final float IlllIIIIIIlllIlIIlllIlIIl = 125.0f;
    public static final float lIllIlIIIlIIIIIIIlllIlIll = 20.0f;
    public static final long lIIIllIllIIllIlllIlIIlllI = 2500L;
    public NotificationPosition llIlllIIIllllIIlllIllIIIl = NotificationPosition.TOP_RIGHT;
    public final QuadraticEase IlllllIlIIIlIIlIIllIIlIll;
    public long llIIlIlIIIllIlIlIlIIlIIll;
    public long llIIIlllIIlllIllllIlIllIl;
    public final ResourceLocationBridge lllllIllIllIllllIlIllllII;
    public boolean lllIIIIIlllIIlIllIIlIIIlI;
    public final String lIlIIIIIIlIIIllllIllIIlII;
    public final List<String> llllIIlIIlIIlIIllIIlIIllI;
    public float IlIlIlllllIlIIlIlIlllIlIl;
    public float llIIIIIIIllIIllIlIllIIIIl;
    public int llIlIIIllIIlIllIllIllllIl = -1;
    public int IllIllIIIllIIIlIlIlIIIIll = -1358954496;
    public int IIlIllIlllllllIIlIIIllIIl = 1076176165;
    public int lIIlIlllIlIlIIIlllIIlIIII = 0x20FFFFFF;

    public Notification(String string) {
        this(null, null, string);
    }

    public Notification(String string, String string2) {
        this(null, string, string2);
    }

    public Notification(ResourceLocationBridge resourceLocationBridge, String string) {
        this(resourceLocationBridge, null, string);
    }

    public Notification(ResourceLocationBridge resourceLocationBridge, String string, String string2) {
        this.lIlIIIIIIlIIIllllIllIIlII = string;
        this.lllllIllIllIllllIlIllllII = resourceLocationBridge;
        this.IlllllIlIIIlIIlIIllIIlIll = new QuadraticEase(250L);
        this.llIIIlllIIlllIllllIlIllIl = 2500L;
        float f = this.IlllIIIIIIlllIlIIlllIlIIl() ? 22.0f : 6.0f;
        float f2 = 200.0f - f - 8.0f;
        this.llllIIlIIlIIlIIllIIlIIllI = FontRegistry.llIlIIIllIIlIllIllIllllIl().lIllIlIIIlIIIIIIIlllIlIll(string2, f2);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((NotificationPosition) Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl());
        this.IllIIIlllIIIlIlllIlIIlIII();
        this.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lllllIllIllIllllIlIllllII != null;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.lIlIIIIIIlIIIllllIllIIlII != null && !this.lIlIIIIIIlIIIllllIllIIlII.isEmpty();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, this.IlIlIlllllIlIIlIlIlllIlIl(), this.llIIIIIIIllIIllIlIllIIIIl(), 4.0f, this.IIlIllIlllllllIIlIIIllIIl, this.lIIlIlllIlIlIIIlllIIlIIII, this.IllIllIIIllIIIlIlIlIIIIll);
        this.lIllIlIIIlIIIIIIIlllIlIll(f, f2);
        this.IlllIIIIIIlllIlIIlllIlIIl(f, f2);
        int n = 0;
        for (String string : this.llllIIlIIlIIlIIllIIlIIllI) {
            float f3 = f + (this.IlllIIIIIIlllIlIIlllIlIIl() ? 22.0f : 6.0f);
            float f4 = f2 + 5.0f + (float)(this.llIlllIIIllllIIlllIllIIIl() ? 8 : 0) + (float)n;
            FontRegistry.llIlIIIllIIlIllIllIllllIl().lIlIlIlIlIIlIIlIIllIIIIIl(string, f3, f4, this.llIlIIIllIIlIllIllIllllIl);
            n += 8;
        }
    }

    public float llllIIlIIlIIlIIllIIlIIllI() {
        if (this.llIIlIlIIIllIlIlIlIIlIIll == 0L) {
            this.llIIlIlIIIllIlIlIlIIlIIll = System.currentTimeMillis();
        }
        if (this.IlllllIlIIIlIIlIIllIIlIll() <= 250L && !this.IlllllIlIIIlIIlIIllIIlIll.llllIIlIIlIIlIIllIIlIIllI()) {
            this.IlllllIlIIIlIIlIIllIIlIll.lIllIlIIIlIIIIIIIlllIlIll();
        } else if (this.lIIIllIllIIllIlllIlIIlllI() <= 250L && !this.IlllllIlIIIlIIlIIllIIlIll.lIIIllIllIIllIlllIlIIlllI() && !this.llIIlIlIIIllIlIlIlIIlIIll()) {
            this.IlllllIlIIIlIIlIIllIIlIll.lIllIlIIIlIIIIIIIlllIlIll();
        }
        if (this.IlllllIlIIIlIIlIIllIIlIll.lIIIllIllIIllIlllIlIIlllI()) {
            if (this.lIIIllIllIIllIlllIlIIlllI() <= 250L) {
                return this.IlllllIlIIIlIIlIIllIIlIll.getProgress() * (10.0f + this.IlIlIlllllIlIIlIlIlllIlIl);
            }
            return 10.0f + this.IlIlIlllllIlIIlIlIlllIlIl - this.IlllllIlIIIlIIlIIllIIlIll.getProgress() * (10.0f + this.IlIlIlllllIlIIlIlIlllIlIl);
        }
        return 0.0f;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2) {
        if (this.llIlllIIIllllIIlllIllIIIl()) {
            float f3 = f + (this.IlllIIIIIIlllIlIIlllIlIIl() ? 22.0f : 6.0f);
            FontRegistry.lIlIIIIIIlIIIllllIllIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII, f3, f2 + 5.0f, -1);
        }
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float f, float f2) {
        if (this.IlllIIIIIIlllIlIIlllIlIIl()) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll(), 6.0f, f + 6.0f, f2 + 6.0f);
            if (this.lllIIIIIlllIIlIllIIlIIIlI) {
                AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f + 6.0f, f2 + 6.0f, 12.0f, 12.0f, 4.0f, -4210753);
            }
        }
    }

    public void IllIIIlllIIIlIlllIlIIlIII() {
        float f = this.IlllIIIIIIlllIlIIlllIlIIl() ? 22.0f : 6.0f;
        float f2 = 125.0f;
        for (String string : this.llllIIlIIlIIlIIllIIlIIllI) {
            float f3 = (float)FontRegistry.llIlIIIllIIlIllIllIllllIl().IlllIIIIIIlllIlIIlllIlIIl(string) + f + 6.0f;
            if (!(f3 > f2)) continue;
            f2 = f3;
        }
        this.IlIlIlllllIlIIlIlIlllIlIl = f2;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        float f = this.llllIIlIIlIIlIIllIIlIIllI.size() * 8 + 10 + (this.llIlllIIIllllIIlllIllIIIl() ? 8 : 0);
        this.llIIIIIIIllIIllIlIllIIIIl = Math.max(20.0f, f);
    }

    public float IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public float llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public long lIIIllIllIIllIlllIlIIlllI() {
        return this.llIIlIlIIIllIlIlIlIIlIIll + this.llIIIlllIIlllIllllIlIllIl - System.currentTimeMillis();
    }

    public long IlllllIlIIIlIIlIIllIIlIll() {
        return System.currentTimeMillis() - this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public boolean llIIlIlIIIllIlIlIlIIlIIll() {
        return this.llIIlIlIIIllIlIlIlIIlIIll != 0L && this.IlllllIlIIIlIIlIIllIIlIll() >= this.llIIIlllIIlllIllllIlIllIl;
    }

    public Notification lIlIlIlIlIIlIIlIIllIIIIIl(NotificationPosition notificationPosition) {
        this.llIlllIIIllllIIlllIllIIIl = notificationPosition;
        return this;
    }

    public Notification lIlIlIlIlIIlIIlIIllIIIIIl(long l) {
        this.llIIIlllIIlllIllllIlIllIl = l;
        return this;
    }

    public NotificationPosition llIIIlllIIlllIllllIlIllIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public QuadraticEase lllllIllIllIllllIlIllllII() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public long lllIIIIIlllIIlIllIIlIIIlI() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public long lIlIIIIIIlIIIllllIllIIlII() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public boolean llIlIIIllIIlIllIllIllllIl() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public String IllIllIIIllIIIlIlIlIIIIll() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public List IIlIllIlllllllIIlIIIllIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public int lIIlIlllIlIlIIIlllIIlIIII() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public int llIllIlIllIlllIllIIIIllII() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public int IllllllllllIlIIIlllIlllll() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public int lllllIllIlIIlIIlIIIlllIlI() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public ResourceLocationBridge lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lllllIllIllIllllIlIllllII;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lllIIIIIlllIIlIllIIlIIIlI = bl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.llIlIIIllIIlIllIllIllllIl = n;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.IllIllIIIllIIIlIlIlIIIIll = n;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(int n) {
        this.IIlIllIlllllllIIlIIIllIIl = n;
    }

    public void llIlllIIIllllIIlllIllIIIl(int n) {
        this.lIIlIlllIlIlIIIlllIIlIIII = n;
    }
}
