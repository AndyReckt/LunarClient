package com.moonsworth.lunar.client.registry;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.websocket.ConsoleLine;

public final class ConsoleLines extends ItemSetLoader<ConsoleLine> {
    private static final int MAX_LINES = 500;

    @Override
    public Set<ConsoleLine> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return Collections.synchronizedSet(new LinkedHashSet<>());
    }

    public void addLine(String string) {
        Set<ConsoleLine> set = this.llIlllIIIllllIIlllIllIIIl();
        if (set.size() > MAX_LINES) {
            set.remove(set.iterator().next());
        }
        set.add(new ConsoleLine(string));
    }
}
