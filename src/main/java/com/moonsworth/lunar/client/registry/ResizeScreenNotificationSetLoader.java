package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.gui.ResizeWindowEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.notification.NotificationRenderer;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;

import java.util.LinkedHashSet;
import java.util.Set;

public class ResizeScreenNotificationSetLoader extends ItemSetLoader<AbstractUIScreen> implements EventHandler {
    public ResizeScreenNotificationSetLoader() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::onTick);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ResizeWindowEvent.class, this::onResize);
    }

    @Override
    public Set<AbstractUIScreen> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new LinkedHashSet<>();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractUIScreen abstractUIScreen) {
        this.llIlllIIIllllIIlllIllIIIl().add(abstractUIScreen);
        ScaledResolutionHelper scaledResolutionHelper = new ScaledResolutionHelper(Ref.getMinecraft());
        abstractUIScreen.setWorldAndResolution(Ref.getMinecraft(), scaledResolutionHelper.lIlIlIlIlIIlIIlIIllIIIIIl(), scaledResolutionHelper.IlllIIIIIIlllIlIIlllIlIIl());
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(AbstractUIScreen abstractUIScreen) {
        this.llIlllIIIllllIIlllIllIIIl().removeIf(abstractUIScreen2 -> abstractUIScreen2 == abstractUIScreen);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl() {
        // todo: a method under "keybinds" string in ReplayMod.java
        if (LunarClient.getInstance().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll()) {
            this.llIlllIIIllllIIlllIllIIIl().stream().filter(abstractUIScreen -> abstractUIScreen instanceof NotificationRenderer).findFirst().ifPresent(abstractUIScreen -> abstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f, 0.0f));
            return;
        }
        for (AbstractUIScreen abstractUIScreen2 : this.llIlllIIIllllIIlllIllIIIl()) {
            abstractUIScreen2.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f, 0.0f);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(MinecraftBridge minecraftBridge, int n, int n2) {
        for (AbstractUIScreen abstractUIScreen : this.llIlllIIIllllIIlllIllIIIl()) {
            abstractUIScreen.setWorldAndResolution(minecraftBridge, n, n2);
        }
    }

    public void onTick(TickEvent tickEvent) {
        for (AbstractUIScreen abstractUIScreen : this.llIlllIIIllllIIlllIllIIIl()) {
            abstractUIScreen.lllllIllIllIllllIlIllllII();
        }
    }

    public void onResize(ResizeWindowEvent resizeWindowEvent) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft(), resizeWindowEvent.lIlIlIlIlIIlIIlIIllIIIIIl(), resizeWindowEvent.IlllIIIIIIlllIlIIlllIlIIl());
    }
}