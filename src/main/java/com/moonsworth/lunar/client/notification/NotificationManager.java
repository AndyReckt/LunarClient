package com.moonsworth.lunar.client.notification;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.registry.CosmeticManager;
import org.apache.commons.lang3.text.WordUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public class NotificationManager
extends ItemSetLoader {
    public final NotificationUIScreen lIlIlIlIlIIlIIlIIllIIIIIl = new NotificationUIScreen();

    @Override
    public Set lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new LinkedHashSet();
    }

    @Override
    public void b_() {
        super.b_();
        LunarClient.IIllIlIllIlIllIllIllIllII().lIIlllIIIIIlllIIIlIlIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public Notification lIlIlIlIlIIlIIlIIllIIIIIl(String string, String string2) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticManager.lIllIlIIIlIIIIIIIlllIlIll, string, string2);
    }

    public Notification lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticManager.lIllIlIIIlIIIIIIIlllIlIll, string);
    }

    public Notification lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge, String string) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(new Notification(resourceLocationBridge, string));
    }

    public Notification lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge, String string, String string2) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(new Notification(resourceLocationBridge, string, string2));
    }

    public Notification lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType notificationType, String string, String string2) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(new Notification(notificationType.lIlIlIlIlIIlIIlIIllIIIIIl(), string, string2));
    }

    public Notification lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType notificationType, String string) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(new Notification(notificationType.lIlIlIlIlIIlIIlIIllIIIIIl(), (Object) EnumChatColor.lIIlIlllIlIlIIIlllIIlIIII + WordUtils.capitalize(notificationType.name().toLowerCase()) + ": " + (Object)((Object)EnumChatColor.IllIIIlllIIIlIlllIlIIlIII) + string));
    }

    public Notification IlllIIIIIIlllIlIIlllIlIIl(String string, String string2) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(new Notification(string, string2));
    }

    public Notification IlllIIIIIIlllIlIIlllIlIIl(String string) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(new Notification(string));
    }

    public Notification lIlIlIlIlIIlIIlIIllIIIIIl(Notification notification) {
        this.llIlllIIIllllIIlllIllIIIl().add(notification);
        return notification;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(String string, String string2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(new OverlayNotification(string, string2));
    }

    public void llIlllIIIllllIIlllIllIIIl(String string, String string2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(new OverlayNotification(string, string, string2));
    }
}