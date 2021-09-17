package com.moonsworth.lunar.client.registry;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.websocket.llIIIIIIIllIIllIlIllIIIIl;

public final class EmptySetLoader
extends ItemSetLoader {
    public static final int lIlIlIlIlIIlIIlIIllIIIIIl = 500;

    @Override
    public Set lIlIlIlIlIIlIIlIIllIIIIIl() {
        return Collections.synchronizedSet(new LinkedHashSet());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        Set set = this.llIlllIIIllllIIlllIllIIIl();
        if (set.size() > 500) {
            set.remove(set.iterator().next());
        }
        set.add(new llIIIIIIIllIIllIlIllIIIIl(string));
    }
}
 