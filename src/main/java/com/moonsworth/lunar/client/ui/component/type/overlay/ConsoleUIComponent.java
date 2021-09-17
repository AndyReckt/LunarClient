package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.google.common.collect.Iterables;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDraggableUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IIlIllIlIIllIIlIlIllllllI;
import com.moonsworth.lunar.client.ui.component.type.setting.llIllIlIllIlllIllIIIIllII;
import com.moonsworth.lunar.client.ui.component.type.setting.lllllIllIlIIlIIlIIIlllIlI;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class ConsoleUIComponent
extends AbstractDraggableUIComponent {
    public static float lIlIlIlIlIIlIIlIIllIIIIIl = 500.0f;
    public llIIlIlIIIllIlIlIlIIlIIll IlllIIIIIIlllIlIIlllIlIIl;
    public lllllIllIlIIlIIlIIIlllIlI lIllIlIIIlIIIIIIIlllIlIll;
    public llIllIlIllIlllIllIIIIllII IIlIllIlllllllIIlIIIllIIl;
    public IIlIllIlIIllIIlIlIllllllI lIIlIlllIlIlIIIlllIIlIIII;
    public FriendsUIScreen friendsScreen;
    public static List<String> IllllllllllIlIIIlllIlllll = new ArrayList();
    public int asasas = Integer.MAX_VALUE;
    public static final ResourceLocationBridge IllIIIlllIIIlIlllIlIIlIII = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/console.png");

    public ConsoleUIComponent(FriendsUIScreen friendsUIScreen) {
        super(null);
        this.friendsScreen = friendsUIScreen;
        this.lIIlIlllIlIlIIIlllIIlIIII = new IIlIllIlIIllIIlIlIllllllI(this);
        this.IlllIIIIIIlllIlIIlllIlIIl = new llIIlIlIIIllIlIlIlIIlIIll(this, "SEND");
        this.IIlIllIlllllllIIlIIIllIIl = new llIllIlIllIlllIllIIIIllII(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/exit-17x17-small.png"));
        this.lIllIlIIIlIIIIIIIlllIlIll = new lllllIllIlIIlIIlIIIlllIlI(this, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "commandPlaceholder", 0x20FFFFFF, 0x40FFFFFF);
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().length() > 0) {
                if (this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().equals("cls") || this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().equals("clear")) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI(), false);
                    LunarClient.IIllIlIllIlIllIllIllIllII().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl().clear();
                    this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl("");
                } else {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI(), true);
                    this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl("");
                }
                return true;
            }
            return false;
        });
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (friendsUIScreen.IllIllIIIllIIIlIlIlIIIIll() != null) {
                friendsUIScreen.lllIIIIIlllIIlIllIIlIIIlI();
                return true;
            }
            return false;
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, boolean bl) {
        if (bl) {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new WSPacketConsole(string));
            LunarClient.IIllIlIllIlIllIllIllIllII().IllIllIIIllIIIlIlIlIIIIll().lIlIlIlIlIIlIIlIIllIIIIIl((Object)((Object)EnumChatColor.lIIIllIllIIllIlllIlIIlllI) + "> " + this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI());
        }
        if (IllllllllllIlIIIlllIlllll.isEmpty() || !((String) Iterables.getLast(IllllllllllIlIIIlllIlllll)).equals(string)) {
            IllllllllllIlIIIlllIlllll.add(string);
            if (IllllllllllIlIIIlllIlllll.size() > 120) {
                IllllllllllIlIIIlllIlllll.remove(0);
            }
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll.llIllIlIllIlllIllIIIIllII()) {
            if (this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().length() > 0 && keyType == KeyType.IlIlIlIlIIIlIIlIIlllIllIl) {
                if (this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().equals("cls") || this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI().equals("clear")) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI(), false);
                    LunarClient.IIllIlIllIlIllIllIllIllII().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl().clear();
                    this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl("");
                } else {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.llllIIlIIlIIlIIllIIlIIllI(), true);
                    this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl("");
                }
            } else {
                if (!IllllllllllIlIIIlllIlllll.isEmpty()) {
                    if (keyType == KeyType.IlIlllIIIIIllIIllIllIIlll) {
                        if (this.asasas == Integer.MAX_VALUE) {
                            this.asasas = IllllllllllIlIIIlllIlllll.size() - 1;
                            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl((String)IllllllllllIlIIIlllIlllll.get(this.asasas));
                        } else {
                            --this.asasas;
                            if (this.asasas < 0) {
                                this.asasas = 0;
                            }
                            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl((String)IllllllllllIlIIIlllIlllll.get(this.asasas));
                        }
                        return;
                    }
                    if (keyType == KeyType.lIlIIllIIIlIIIlIIIlIIlIll && this.asasas != Integer.MAX_VALUE) {
                        ++this.asasas;
                        if (this.asasas == IllllllllllIlIIIlllIlllll.size()) {
                            this.asasas = Integer.MAX_VALUE;
                            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl("");
                        } else {
                            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl((String)IllllllllllIlIIIlllIlllll.get(this.asasas));
                        }
                        return;
                    }
                }
                this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
            }
        }
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        boolean bl;
        if (this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        if (this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        if (this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        if (this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        }
        boolean bl2 = f > this.x && f < this.x + 24.0f && f2 > this.y + 4.0f && f2 < this.y + this.height - 4.0f;
        boolean bl3 = bl = !bl2 && !this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && !this.lIIlIlllIlIlIIIlllIIlIIII.lIIIllIllIIllIlllIlIIlllI() && !this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && !this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2);
        if (bl) {
            this.lIllIlIIIlIIIIIIIlllIlIll(f, f2);
        }
        return this.IlllllIlIIIlIIlIIllIIlIll != null && this.IlllllIlIIIlIIlIIllIIlIll.accept(f, f2, n);
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
        this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
        this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
        return this.llIIlIlIIIllIlIlIlIIlIIll != null && this.llIIlIlIIIllIlIlIlIIlIIll.accept(f, f2, n);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f + 4.0f, f2 + f4 - 18.0f, f3 - 40.0f, 13.0f);
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 32.0f, f2 + f4 - 18.0f, 26.0f, 13.0f);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 20.0f, f2 + 4.0f, 16.0f, 16.0f);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(false);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 24.0f, this.width, 0.5f, 0x20FFFFFF);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height - 23.0f, this.width, 0.5f, 0x20FFFFFF);
        AbstractUIScreen.llIIIIIIIllIIllIlIllIIIIl(this.x, this.y + this.height - 22.5f, this.width, 21.5f, 5.0f, 0x45000000);
        AbstractUIScreen.llllIIlIIlIIlIIllIIlIIllI(this.x, this.y + 1.0f, this.width, 23.0f, 5.0f, 0x25000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 1.0f, this.y, this.width + 2.0f, this.height, 4.0f, 0x40000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 3.0f, 0x20FFFFFF);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 5.0f, Integer.MIN_VALUE);
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.6862745f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(IllIIIlllIIIlIlllIlIIlIII, 6.0f, this.x + 6.0f, this.y + 6.0f);
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl("Admin Console", this.x + 25.0f, this.y + 7.0f, -1342177281);
        float f3 = this.y + this.height - 35.0f;
        float f4 = 8.5f;
        LCFontRenderer lCFontRenderer = FontRegistry.llIIlIlIIIllIlIlIlIIlIIll();
        boolean bl2 = bl && f > this.x + 26.0f && f < this.x + this.x + this.width - 2.0f && f2 > this.y + 26.0f && f2 < this.y + this.height - 24.0f;
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - 5.0f, this.y + 26.0f, 3.0f, this.height - 50.0f);
        this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl(f, f2, bl2);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable((int)3089);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x + 4.0f), (int)(this.y + 26.0f), (int)(this.x + this.width - 2.0f), (int)(this.y + this.height - 24.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.friendsScreen.lllllIllIlIIlIIlIIIlllIlI());
        int n = 0;
        try {
            for (int i = this.lIlIIIIIIlIIIllllIllIIlII.IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl().size() - 1; i >= 0; --i) {
                com.moonsworth.lunar.client.websocket.llIIIIIIIllIIllIlIllIIIIl llIIIIIIIllIIllIlIllIIIIl2 = (llIIIIIIIllIIllIlIllIIIIl)this.lIlIIIIIIlIIIllllIllIIlII.IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl().toArray()[i];
                for (int j = llIIIIIIIllIIllIlIllIIIIl2.lIllIlIIIlIIIIIIIlllIlIll().size() - 1; j >= 0; --j) {
                    String string = (String)llIIIIIIIllIIllIlIllIIIIl2.lIllIlIIIlIIIIIIIlllIlIll().get(j);
                    lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(string, this.x + 6.0f, f3 - (float)n * f4, -4671304);
                    ++n;
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        GL11.glDisable((int)3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        this.lIIlIlllIlIlIIIlllIIlIIII.IlIlIlllllIlIIlIlIlllIlIl((float)n * f4 + 4.0f);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll(f, f2, bl2);
    }
}
 