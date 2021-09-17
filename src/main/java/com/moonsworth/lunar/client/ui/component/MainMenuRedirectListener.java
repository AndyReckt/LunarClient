package com.moonsworth.lunar.client.ui.component;

import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.gui.GuiOpenEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIScreen;

public class MainMenuRedirectListener
implements EventHandler {
    public MainMenuRedirectListener() {
        EventBus.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(GuiOpenEvent.class, guiOpenEvent -> {
            if (guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == null && Ref.llIIIIIIIllIIllIlIllIIIIl() == null) {
                guiOpenEvent.setCancelled(true);
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIScreen()));
            }
        });
    }
}
 