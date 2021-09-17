package com.moonsworth.lunar.client.feature.external;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ThirdPartyMod {
    public String lIlIlIlIlIIlIIlIIllIIIIIl();

    public String IlllIIIIIIlllIlIIlllIlIIl() default "";

    public String lIllIlIIIlIIIIIIIlllIlIll() default "";

    public String llIlllIIIllllIIlllIllIIIl() default "";

    public boolean llllIIlIIlIIlIIllIIlIIllI() default false;

    public boolean IlIlIlllllIlIIlIlIlllIlIl() default false;

    public boolean llIIIIIIIllIIllIlIllIIIIl() default false;

    public String lIIIllIllIIllIlllIlIIlllI() default "";

    public String IlllllIlIIIlIIlIIllIIlIll() default "";

    public String llIIlIlIIIllIlIlIlIIlIIll() default "";

    public String llIIIlllIIlllIllllIlIllIl() default "";

    public String lllllIllIllIllllIlIllllII() default "java";

    public String lllIIIIIlllIIlIllIIlIIIlI() default "";

    public boolean lIlIIIIIIlIIIllllIllIIlII() default false;

    public String llIlIIIllIIlIllIllIllllIl() default "";

    public String IllIllIIIllIIIlIlIlIIIIll() default "";
}