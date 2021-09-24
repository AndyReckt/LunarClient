package com.moonsworth.lunar.client.notification;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotificationRenderer extends AbstractUIScreen {
    public static final int lIlIlIlIlIIlIIlIIllIIIIIl = 1;
    public NotificationManager IlllIIIIIIlllIlIIlllIlIIl;
    public final List<Notification> lIllIlIIIlIIIIIIIlllIlIll = new ArrayList();

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        this.IlllIIIIIIlllIlIIlllIlIIl = LunarClient.getInstance().IIIlIIIIIIllIIIIllIIIIlII();
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
        this.llIIIIIIIllIIllIlIllIIIIl();
        if (!this.IlllIIIIIIlllIlIIlllIlIIl.llIlllIIIllllIIlllIllIIIl().isEmpty() && this.lIllIlIIIlIIIIIIIlllIlIll.size() < 1) {
            List list = this.lIllIlIIIlIIIIIIIlllIlIll;
            synchronized (list) {
                this.lIllIlIIIlIIIIIIIlllIlIll.addAll(this.IlllIIIIIIlllIlIIlllIlIIl.llIlllIIIllllIIlllIllIIIl());
            }
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll.isEmpty()) {
            return;
        }
        List list = this.lIllIlIIIlIIIIIIIlllIlIll;
        synchronized (list) {
            float f3 = 5.0f;
            for (NotificationPosition notificationPosition : NotificationPosition.values()) {
                float f4 = 0.0f;
                for (Notification notification : this.lIlIlIlIlIIlIIlIIllIIIIIl(notificationPosition)) {
                    if (notification.llIIlIlIIIllIlIlIlIIlIIll()) continue;
                    float f5 = notificationPosition.IlllIIIIIIlllIlIIlllIlIIl().calc(this.lIIIllIllIIllIlllIlIIlllI, notification.IlIlIlllllIlIIlIlIlllIlIl(), 0.0f, 5.0f);
                    float f6 = notificationPosition.lIllIlIIIlIIIIIIIlllIlIll().calc(this.IlllllIlIIIlIIlIIllIIlIll, notification.llIIIIIIIllIIllIlIllIIIIl(), f4, 5.0f);
                    f5 = notificationPosition == NotificationPosition.BOTTOM_LEFT || notificationPosition == NotificationPosition.TOP_LEFT ? (f5 -= notification.llllIIlIIlIIlIIllIIlIIllI()) : (f5 += notification.llllIIlIIlIIlIIllIIlIIllI());
                    notification.lIlIlIlIlIIlIIlIIllIIIIIl(f5, f6);
                    f4 += notification.llIIIIIIIllIIllIlIllIIIIl() + 5.0f;
                }
            }
        }
    }

    public List<Notification> lIlIlIlIlIIlIIlIIllIIIIIl(NotificationPosition notificationPosition) {
        return this.lIllIlIIIlIIIIIIIlllIlIll.stream().filter(notification -> notification.llIIIlllIIlllIllllIlIllIl().equals(notificationPosition)).collect(Collectors.toList());
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
    }

    @Override
    public List llIIlIlIIIllIlIlIlIIlIIll() {
        return ImmutableList.of();
    }

    public void llIIIIIIIllIIllIlIllIIIIl() {
        this.lIllIlIIIlIIIIIIIlllIlIll.removeIf(Notification::llIIlIlIIIllIlIlIlIIlIIll);
    }
}