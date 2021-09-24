package com.moonsworth.lunar.client.ui.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Debug {

    class DebugHelper {
        public static boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object object, Object object2) {
            for (Field field : object2.getClass().getDeclaredFields()) {
                try {
                    boolean bl = field.isAccessible();
                    field.setAccessible(true);
                    Object object3 = field.get(object2);
                    field.setAccessible(bl);
                    if (object3 == null || object == null) {
                        return false;
                    }
                    if (!object3.equals(object)) continue;
                    return field.isAnnotationPresent(Debug.class);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            return false;
        }
    }
}
