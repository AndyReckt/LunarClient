package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.client.json.file.ItemMapLoader;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmptyMapLoader
extends ItemMapLoader {
    @Override
    public Map lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentHashMap();
    }
}
 