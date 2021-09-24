package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.client.feature.type.title.Title;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import io.netty.util.internal.ConcurrentSet;

import java.util.Set;

public final class TitlesSetLoader extends ItemSetLoader<Title> {
    @Override
    public Set<Title> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentSet<>();
    }
}
