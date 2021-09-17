package com.moonsworth.lunar.client.json.file;

import com.moonsworth.lunar.client.logger.LunarLogger;
import lombok.Getter;

import java.util.Set;

/**
 * @author Decencies
 * @since 10/07/2021 12:28
 */
public abstract class ItemSetLoader<T> implements ItemLoader {

    // todo: getSet
    @Getter
    private final Set<T> set = lIlIlIlIlIIlIIlIIllIIIIIl();

    // todo "load"
    protected abstract Set<T> lIlIlIlIlIIlIIlIIllIIIIIl();

    @Override
    public void b_() {
        LunarLogger.lIlIlIlIlIIlIIlIIllIIIIIl(getClass().getSimpleName() + " loaded " + set.size() + " items.");
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
    }


    // todo remove
    public Set<T> llIlllIIIllllIIlllIllIIIl() {
        return this.set;
    }

}
