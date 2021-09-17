package com.moonsworth.lunar.client.ui.screen.type.mainmenu;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.stream.Stream;

public class MainMenuUIWrapper extends BaseMainMenuUIScreen {
    public final AbstractUIScreen llIlIIIllIIlIllIllIllllIl;
    public boolean IllIllIIIllIIIlIlIlIIIIll;

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(MinecraftBridge minecraftBridge, int n, int n2) {
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(minecraftBridge, n, n2);
        super.lIlIlIlIlIIlIIlIIllIIIIIl(minecraftBridge, n, n2);
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        if (!this.IllIllIIIllIIIlIlIlIIIIll) {
            this.IllIllIIIllIIIlIlIlIIIIll = true;
            this.llIIlIlIIIllIlIlIlIIlIIll = Stream.concat(this.llIIlIlIIIllIlIlIlIIlIIll.stream(), this.llIlIIIllIIlIllIllIllllIl.llIIIlIllIIIIlIIIlIlIllIl().stream()).collect(Collectors.toList());
        }
        this.llIlIIIllIIlIllIllIllllIl.llIIIlllIIlllIllllIlIllIl();
        super.llIIIlllIIlllIllllIlIllIl();
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
        this.llIlIIIllIIlIllIllIllllIl.lllllIllIllIllllIlIllllII();
        super.lllllIllIllIllllIlIllllII();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2);
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
        this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
        super.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
        this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(c, keyType);
        super.IlllIIIIIIlllIlIIlllIlIIl(c, keyType);
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
        this.llIlIIIllIIlIllIllIllllIl.lIlIIIIIIlIIIllllIllIIlII();
        super.lIlIIIIIIlIIIllllIllIIlII();
    }

    public MainMenuUIWrapper(AbstractUIScreen abstractUIScreen) {
        this.llIlIIIllIIlIllIllIllllIl = abstractUIScreen;
    }

    public AbstractUIScreen llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }
}