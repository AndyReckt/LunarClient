package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import io.netty.util.internal.ConcurrentSet;

import java.util.Set;

public final class TitlesSetLoader
extends ItemSetLoader {
    @Override
    public Set lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentSet();
    }
}
 