package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.client.feature.type.hologram.Hologram;
import com.moonsworth.lunar.client.json.file.ItemMapLoader;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HologramsRegistry extends ItemMapLoader<UUID, Hologram> {
    @Override
    public Map<UUID, Hologram> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentHashMap<>();
    }
}
