package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.client.json.file.ItemSetLoader;

import java.util.Set;

public final class PinnedServersConfig
extends ItemSetLoader {
    @Override
    public Set lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new LinkedHashSet<FeaturedServer>(ImmutableList.of(new FeaturedServer("Lunar Network", "lunar.gg", -1L, ImmutableList.of(MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl, MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl))));
    }

    @Override
    public Set llIlllIIIllllIIlllIllIIIl() {
        return super.llIlllIIIllllIIlllIllIIIl().stream().filter(FeaturedServer::llIlllIIIllllIIlllIllIIIl).collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
 