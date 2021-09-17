package com.moonsworth.lunar.client.websocket;

import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.type.overlay.ConsoleUIComponent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class llIIIIIIIllIIllIlIllIIIIl {
    public static final DateTimeFormatter lIlIlIlIlIIlIIlIIllIIIIIl = DateTimeFormatter.ofPattern("HH:mm:ss");
    public final String IlllIIIIIIlllIlIIlllIlIIl = LocalDateTime.now().format(lIlIlIlIlIIlIIlIIllIIIIIl);
    public final String lIllIlIIIlIIIIIIIlllIlIll;
    public final List llIlllIIIllllIIlllIllIIIl;

    public llIIIIIIIllIIllIlIllIIIIl(String string) {
        this.lIllIlIIIlIIIIIIIlllIlIll = string;
        this.llIlllIIIllllIIlllIllIIIl = FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl(this.lIllIlIIIlIIIIIIIlllIlIll, ConsoleUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl - 8.0f);
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public List lIllIlIIIlIIIIIIIlllIlIll() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }
}