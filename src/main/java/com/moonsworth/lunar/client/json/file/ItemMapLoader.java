package com.moonsworth.lunar.client.json.file;

import com.moonsworth.lunar.client.logger.LunarLogger;
import lombok.Getter;

import java.util.Map;

/**
 * @author Decencies
 * @since 10/07/2021 12:27
 */
public abstract class ItemMapLoader<K, V> implements ItemLoader {

    @Getter
    private final Map<K, V> map = lIlIlIlIlIIlIIlIIllIIIIIl();

    protected abstract Map<K,V> lIlIlIlIlIIlIIlIIllIIIIIl();

    @Override
    public void b_() {
        LunarLogger.lIlIlIlIlIIlIIlIIllIIIIIl(getClass().getSimpleName() + " loaded " + map.size() + " items.");
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
    }

    public Map<K, V> llIlllIIIllllIIlllIllIIIl() {
        return map;
    }


}
