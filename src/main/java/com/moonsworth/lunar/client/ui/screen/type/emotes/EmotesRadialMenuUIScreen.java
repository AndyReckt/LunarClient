package com.moonsworth.lunar.client.ui.screen.type.emotes;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.emote.AbstractEmote;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.screen.type.radial.RadialMenuEntry;
import com.moonsworth.lunar.client.ui.screen.type.radial.RadialMenuUIScreen;

import java.util.stream.Collectors;

public class EmotesRadialMenuUIScreen extends RadialMenuUIScreen {
    public EmotesRadialMenuUIScreen(KeyType keyType) {
        super(keyType, Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIIIllIllIIllIlllIlIIlllI().stream().map(LunarClient.getInstance().lIIlIlllIlIlIIIlllIIlIIII()::lIlIlIlIlIIlIIlIIllIIIIIl).map(abstractEmote -> {
            if (abstractEmote != null) {
                return new RadialMenuEntry(abstractEmote, abstractEmote.llIlllIIIllllIIlllIllIIIl(), abstractEmote.llIIIIIIIllIIllIlIllIIIIl());
            }
            return null;
        }).collect(Collectors.toList()));
        this.lIllIlIIIlIIIIIIIlllIlIll = radialMenuEntry -> {
            if (radialMenuEntry != null) {
                AbstractEmote abstractEmote = (AbstractEmote)radialMenuEntry.lIlIlIlIlIIlIIlIIllIIIIIl();
                Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(abstractEmote);
            }
        };
        this.llIlllIIIllllIIlllIllIIIl = () -> Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new EmotesUIScreen()));
    }

    @Override
    public boolean IlIlIlllllIlIIlIlIlllIlIl() {
        return true;
    }
}