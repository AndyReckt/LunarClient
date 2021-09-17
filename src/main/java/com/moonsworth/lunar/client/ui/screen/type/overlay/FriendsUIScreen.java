package com.moonsworth.lunar.client.ui.screen.type.overlay;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.overlay.ConsoleUIComponent;
import com.moonsworth.lunar.client.ui.component.type.overlay.FriendsListUIComponent;
import com.moonsworth.lunar.client.ui.component.type.overlay.MessageListUIComponent;
import com.moonsworth.lunar.client.ui.ease.QuadraticEase;
import com.moonsworth.lunar.client.ui.ease.SinusoidalEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;
import com.moonsworth.lunar.client.websocket.FriendProfile;
import com.moonsworth.lunar.client.websocket.WebSocketState;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Decencies
 * @since 11/07/2021 00:41
 */
public class FriendsUIScreen extends AbstractUIScreen {
    public static FriendsUIScreen lIlIlIlIlIIlIIlIIllIIIIIl;
    public GuiScreenBridge IlllIIIIIIlllIlIIlllIlIIl = null;
    public final QuadraticEase lIllIlIIIlIIIIIIIlllIlIll;
    public FriendsListUIComponent llIlllIIIllllIIlllIllIIIl;
    public final float llIIIlllIIlllIllllIlIllIl = 130.0f;
    public ConsoleUIComponent lllllIllIllIllllIlIllllII;
    public final SinusoidalEase lllIIIIIlllIIlIllIIlIIIlI = new SinusoidalEase(1500L);
    public final SinusoidalEase lIlIIIIIIlIIIllllIllIIlII = new SinusoidalEase(1500L);
    public final SinusoidalEase llIlIIIllIIlIllIllIllllIl = new SinusoidalEase(1500L);

    public FriendsUIScreen() {
        this.lIllIlIIIlIIIIIIIlllIlIll = new QuadraticEase(100L);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll();
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10242, (int)10496);
        GL11.glTexParameteri((int)3553, (int)10243, (int)10496);
    }

    public static FriendsUIScreen llIIIIIIIllIIllIlIllIIIIl() {
        return lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public static FriendsUIScreen lIlIlIlIlIIlIIlIIllIIIIIl(GuiScreenBridge guiScreenBridge) {
        if (guiScreenBridge == null || !guiScreenBridge.lIlIlIlIlIIlIIlIIllIIIIIl(FriendsUIScreen.class)) {
            FriendsUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl = guiScreenBridge;
        }
        FriendsUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll();
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
        return lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public static void save() {
        lIlIlIlIlIIlIIlIIllIIIIIl = new FriendsUIScreen();
    }

    public void IlllllIlIIIlIIlIIllIIlIll() {
        this.llIlllIIIllllIIlllIllIIIl.llllIIlIIlIIlIIllIIlIIllI();
        this.llIIIlllIIlllIllllIlIllIl();
    }

    @Override
    public List llIIlIlIIIllIlIlIlIIlIIll() {
        ArrayList<FriendsListUIComponent> arrayList = new ArrayList<FriendsListUIComponent>();
        this.llIlllIIIllllIIlllIllIIIl = new FriendsListUIComponent(null);
        arrayList.add(this.llIlllIIIllllIIlllIllIIIl);
        return arrayList;
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(-130.0f, 0.0f, 130.0f, this.lllllIllIlIIlIIlIIIlllIlI());
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            this.IlllIIIIIIlllIlIIlllIlIIl.bridge$updateScreen();
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(MinecraftBridge minecraftBridge, int n, int n2) {
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            this.IlllIIIIIIlllIlIIlllIlIIl.bridge$setWorldAndResolution(minecraftBridge, n, n2);
        }
        super.lIlIlIlIlIIlIIlIIllIIIIIl(minecraftBridge, n, n2);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2, float f) {
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            this.IlllIIIIIIlllIlIIlllIlIIl.bridge$drawScreen(0, 0, f);
        }
        if (!Ref.getAssetsWebsocket().isPresent() || ((AssetsWebSocket)Ref.getAssetsWebsocket().get()).lIlIlIlIlIIlIIlIIllIIIIIl() != WebSocketState.READY) {
            float f2 = FriendsUIScreen.lIIlIlllIlIlIIIlllIIlIIII();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(f2, f2, f2);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0f - 60.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 16.0f, 120.0f, 40.0f, 4.0f, 0x20000000);
            if (!this.lllIIIIIlllIIlIllIIlIIIlI.llllIIlIIlIIlIIllIIlIIllI()) {
                this.lllIIIIIlllIIlIllIIlIIIlI.lIllIlIIIlIIIIIIIlllIlIll();
                this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl();
                this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(200L);
                this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl();
                this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(400L);
                this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl();
            }
            FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(this.get("connecting", new Object[0]), this.IllllllllllIlIIIlllIlllll() / 2.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 10.0f, -1);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((double)(this.IllllllllllIlIIIlllIlllll() / 2.0f - 10.0f), (double)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 10.0f), 2.0, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.8f, 0.8f, 0.8f, 1.0f * this.lllIIIIIlllIIlIllIIlIIIlI.IlllllIlIIIlIIlIIllIIlIll()));
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((double)(this.IllllllllllIlIIIlllIlllll() / 2.0f), (double)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 10.0f), 2.0, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.8f, 0.8f, 0.8f, 1.0f * this.lIlIIIIIIlIIIllllIllIIlII.IlllllIlIIIlIIlIIllIIlIll()));
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((double)(this.IllllllllllIlIIIlllIlllll() / 2.0f + 10.0f), (double)(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 10.0f), 2.0, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.8f, 0.8f, 0.8f, 1.0f * this.llIlIIIllIIlIllIllIllllIl.IlllllIlIIIlIIlIIllIIlIll()));
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
            return;
        }
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n, n2, f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll.lIIIllIllIIllIlllIlIIlllI()) {
            this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(-130.0f + 130.0f * this.lIllIlIIIlIIIIIIIlllIlIll.IlllllIlIIIlIIlIIllIIlIll(), 0.0f, 130.0f, this.lllllIllIlIIlIIlIIIlllIlI());
        } else if (this.llIlllIIIllllIIlllIllIIIl.lllIIIIIlllIIlIllIIlIIIlI() != 0.0f) {
            this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f, 0.0f, 130.0f, this.lllllIllIlIIlIIlIIIlllIlI());
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
        if (keyType == KeyType.IllIIlllIllIlllllIlIllIll) {
            Ref.getAssetsWebsocket().ifPresent(assetsWebSocket -> {
                if (!assetsWebSocket.IlllIIIIIIlllIlIIlllIlIIl()) {
                    return;
                }
                if (this.lllllIllIllIllllIlIllllII == null) {
                    this.lllllIllIllIllllIlIllllII = new ConsoleUIComponent(this);
                    this.llIIlIlIIIllIlIlIlIIlIIll.add(this.lllllIllIllIllllIlIllllII);
                    this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> true);
                    this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl(160.0f, 50.0f, ConsoleUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl, 300.0f);
                } else {
                    this.lllIIIIIlllIIlIllIIlIIIlI();
                }
            });
        }
        if (keyType == KeyType.lIIIlIllllIIlIIlIIlIIIIlI) {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(this.IlllIIIIIIlllIlIIlllIlIIl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void lllIIIIIlllIIlIllIIlIIIlI() {
        List list = this.llIIlIlIIIllIlIlIlIIlIIll;
        synchronized (list) {
            this.llIIlIlIIIllIlIlIlIIlIIll.removeIf(uIComponent -> uIComponent instanceof ConsoleUIComponent);
            this.lllllIllIllIllllIlIllllII = null;
        }
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    public MessageListUIComponent IlIllIIlIIlIIIllIllllIIll() {
        for (UIComponent uIComponent : this.llIIlIlIIIllIlIlIlIIlIIll) {
            if (!(uIComponent instanceof MessageListUIComponent)) continue;
            return (MessageListUIComponent)uIComponent;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void lIlIlIlIlIIlIIlIIllIIIIIl(FriendProfile websocketProfile) {
        MessageListUIComponent messageListUIComponent = this.IlIllIIlIIlIIIllIllllIIll();
        if (messageListUIComponent == null) {
            List list = this.llIIlIlIIIllIlIlIlIIlIIll;
            synchronized (list) {
                messageListUIComponent = new MessageListUIComponent(this);
                this.llIIlIlIIIllIlIlIlIIlIIll.add(messageListUIComponent);
                messageListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlllIIIllllIIlllIllIIIl.lllIIIIIlllIIlIllIIlIIIlI() + this.llIlllIIIllllIIlllIllIIIl.llIlIIIllIIlIllIllIllllIl() + 10.0f, 30.0f, 215.0f, 134.0f);
            }
        }
        messageListUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(websocketProfile);
    }

    @Override
    public String getLanguagePath() {
        return super.getLanguagePath() + ".friends";
    }

    public GuiScreenBridge llIlIIIllIIlIllIllIllllIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public ConsoleUIComponent IllIllIIIllIIIlIlIlIIIIll() {
        return this.lllllIllIllIllllIlIllllII;
    }
}

