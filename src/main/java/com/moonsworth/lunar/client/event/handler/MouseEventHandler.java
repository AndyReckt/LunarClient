package com.moonsworth.lunar.client.event.handler;

import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.state.KeyState;
import com.moonsworth.lunar.client.event.type.input.MouseActionEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MouseEventHandler
implements EventHandler {
    public final List<Long> lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList<>(); // name: leftCps
    public final List<Long> IlllIIIIIIlllIlIIlllIlIIl = new ArrayList<>(); // name: rightCps
    public static final Predicate<Long> lIllIlIIIlIIIIIIIlllIlIll = l -> l < System.currentTimeMillis() - 1000L; // name: shouldRemove

    public MouseEventHandler() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(MouseActionEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent tickEvent) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.removeIf(lIllIlIIIlIIIIIIIlllIlIll);
        this.IlllIIIIIIlllIlIIlllIlIIl.removeIf(lIllIlIIIlIIIIIIIlllIlIll);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(MouseActionEvent mouseActionEvent) {
        if (mouseActionEvent.IlllIIIIIIlllIlIIlllIlIIl() == KeyState.DOWN) {
            if (mouseActionEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == 0) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl.add(System.currentTimeMillis());
            }
            if (mouseActionEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == 1) {
                this.IlllIIIIIIlllIlIIlllIlIIl.add(System.currentTimeMillis());
            }
        }
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        return bl ? this.IlllIIIIIIlllIlIIlllIlIIl() : this.llIlllIIIllllIIlllIllIIIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.clear();
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl.size();
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.IlllIIIIIIlllIlIIlllIlIIl.clear();
    }

    public int llIlllIIIllllIIlllIllIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl.size();
    }
}