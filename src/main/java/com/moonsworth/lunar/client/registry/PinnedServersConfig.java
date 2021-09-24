package com.moonsworth.lunar.client.registry;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.server.FeaturedServer;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class PinnedServersConfig extends ItemSetLoader<FeaturedServer> {
    @Override
    public Set<FeaturedServer> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new LinkedHashSet<>(ImmutableList.of(new FeaturedServer("Lunar Network", "lunar.gg", -1L, ImmutableList.of(MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl, MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl))));
    }

    @Override
    public Set<FeaturedServer> llIlllIIIllllIIlllIllIIIl() {
        return super.llIlllIIIllllIIlllIllIIIl().stream().filter(FeaturedServer::isSupportedOnCurrentVersion).collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
