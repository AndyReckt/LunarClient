package com.moonsworth.lunar.client.util;

import com.google.common.base.Preconditions;

import javax.annotation.Nullable;

public class NullUtil {
    public static Object lIlIlIlIlIIlIIlIIllIIIIIl(@Nullable Object object, @Nullable Object object2) {
        return object != null ? object : Preconditions.checkNotNull(object2);
    }
}
 