package com.moonsworth.lunar.client.feature.external;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ThirdPartyMod {
    String lIlIlIlIlIIlIIlIIllIIIIIl();

String IlllIIIIIIlllIlIIlllIlIIl() default "";

String lIllIlIIIlIIIIIIIlllIlIll() default "";

String llIlllIIIllllIIlllIllIIIl() default "";

boolean llllIIlIIlIIlIIllIIlIIllI() default false;

boolean IlIlIlllllIlIIlIlIlllIlIl() default false;

boolean llIIIIIIIllIIllIlIllIIIIl() default false;

String lIIIllIllIIllIlllIlIIlllI() default "";

String IlllllIlIIIlIIlIIllIIlIll() default "";

String llIIlIlIIIllIlIlIlIIlIIll() default "";

String llIIIlllIIlllIllllIlIllIl() default "";

String lllllIllIllIllllIlIllllII() default "java";

String lllIIIIIlllIIlIllIIlIIIlI() default "";

boolean lIlIIIIIIlIIIllllIllIIlII() default false;

String llIlIIIllIIlIllIllIllllIl() default "";

String IllIllIIIllIIIlIlIlIIIIll() default "";
}