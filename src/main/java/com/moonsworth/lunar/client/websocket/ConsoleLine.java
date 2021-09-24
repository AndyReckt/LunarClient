package com.moonsworth.lunar.client.websocket;

import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.type.overlay.ConsoleUIComponent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class ConsoleLine {
    public static final DateTimeFormatter lIlIlIlIlIIlIIlIIllIIIIIl;
    public final String IlllIIIIIIlllIlIIlllIlIIl;
    public final String lIllIlIIIlIIIIIIIlllIlIll;
    public final List llIlllIIIllllIIlllIllIIIl;

    public ConsoleLine(final String lIllIlIIIlIIIIIIIlllIlIll) {
        this.IlllIIIIIIlllIlIIlllIlIIl = LocalDateTime.now().format(ConsoleLine.lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
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

    static {
        lIlIlIlIlIIlIIlIIllIIIIIl = DateTimeFormatter.ofPattern("HH:mm:ss");
    }
}