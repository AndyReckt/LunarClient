package com.moonsworth.lunar.client.ui.component;

import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.gui.GuiOpenEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIScreen;

public class MainMenuRedirectListener implements EventHandler {
    public MainMenuRedirectListener() {
        EventBus.getInstance().register(GuiOpenEvent.class, guiOpenEvent -> {
            if (guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == null && Ref.getWorld() == null) {
                guiOpenEvent.setCancelled(true);
                Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuUIScreen()));
            }
        });
    }
}
