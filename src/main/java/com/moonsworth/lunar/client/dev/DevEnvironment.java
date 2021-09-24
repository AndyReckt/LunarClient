package com.moonsworth.lunar.client.dev;

import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.util.AuthUtil;

import java.lang.reflect.Field;

public class DevEnvironment {

    public static void init() throws Exception {
        // force the auth server to appear online.
        {
            YggdrasilUserAuthentication authentication = AuthUtil.SERVICE;
            Field field = authentication.getClass().getField("isOnline");
            field.setAccessible(true);
            field.set(authentication, true);

            if (!authentication.canPlayOnline()) {
                throw new RuntimeException("bruh");
            }
        }

        // set the auth token to "hello", for testing.
        LunarClient client = LunarClient.getInstance();
        client.accountsConfig.IlllIIIIIIlllIlIIlllIlIIl("hello");
    }

}
