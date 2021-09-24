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
import com.moonsworth.lunar.client.profile.FriendProfile;
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
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10242, 10496);
        GL11.glTexParameteri(3553, 10243, 10496);
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
        this.llIlllIIIllllIIlllIllIIIl.setPositionAndSize(-130.0f, 0.0f, 130.0f, this.lllllIllIlIIlIIlIIIlllIlI());
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            this.IlllIIIIIIlllIlIIlllIlIIl.bridge$updateScreen();
        }
    }

    @Override
    public void setWorldAndResolution(MinecraftBridge minecraftBridge, int n, int n2) {
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            this.IlllIIIIIIlllIlIIlllIlIIl.bridge$setWorldAndResolution(minecraftBridge, n, n2);
        }
        super.setWorldAndResolution(minecraftBridge, n, n2);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            this.IlllIIIIIIlllIlIIlllIlIIl.bridge$drawScreen(0, 0, f);
        }
        if (!Ref.getAssetsWebsocket().isPresent() || Ref.getAssetsWebsocket().get().lIlIlIlIlIIlIIlIIllIIIIIl() != WebSocketState.READY) {
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
            FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(this.get("connecting"), this.IllllllllllIlIIIlllIlllll() / 2.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 10.0f, -1);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0f - 10.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 10.0f, 2.0, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.8f, 0.8f, 0.8f, 1.0f * this.lllIIIIIlllIIlIllIIlIIIlI.getProgress()));
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 10.0f, 2.0, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.8f, 0.8f, 0.8f, 1.0f * this.lIlIIIIIIlIIIllllIllIIlII.getProgress()));
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0f + 10.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 10.0f, 2.0, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.8f, 0.8f, 0.8f, 1.0f * this.llIlIIIllIIlIllIllIllllIl.getProgress()));
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
            return;
        }
        super.drawScreen(n, n2, f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll.lIIIllIllIIllIlllIlIIlllI()) {
            this.llIlllIIIllllIIlllIllIIIl.setPositionAndSize(-130.0f + 130.0f * this.lIllIlIIIlIIIIIIIlllIlIll.getProgress(), 0.0f, 130.0f, this.lllllIllIlIIlIIlIIIlllIlI());
        } else if (this.llIlllIIIllllIIlllIllIIIl.getX() != 0.0f) {
            this.llIlllIIIllllIIlllIllIIIl.setPositionAndSize(0.0f, 0.0f, 130.0f, this.lllllIllIlIIlIIlIIIlllIlI());
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
        if (keyType == KeyType.KEY_F1) {
            Ref.getAssetsWebsocket().ifPresent(assetsWebSocket -> {
                if (!assetsWebSocket.IlllIIIIIIlllIlIIlllIlIIl()) {
                    return;
                }
                if (this.lllllIllIllIllllIlIllllII == null) {
                    this.lllllIllIllIllllIlIllllII = new ConsoleUIComponent(this);
                    this.components.add(this.lllllIllIllIllllIlIllllII);
                    this.lllllIllIllIllllIlIllllII.onMouseClick((float f, float f2, int n) -> true);
                    this.lllllIllIllIllllIlIllllII.setPositionAndSize(160.0f, 50.0f, ConsoleUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl, 300.0f);
                } else {
                    this.lllIIIIIlllIIlIllIIlIIIlI();
                }
            });
        }
        if (keyType == KeyType.KEY_ESCAPE) {
            Ref.getMinecraft().bridge$displayScreen(this.IlllIIIIIIlllIlIIlllIlIIl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void lllIIIIIlllIIlIllIIlIIIlI() {
        List list = this.components;
        synchronized (list) {
            this.components.removeIf(uIComponent -> uIComponent instanceof ConsoleUIComponent);
            this.lllllIllIllIllllIlIllllII = null;
        }
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    public MessageListUIComponent IlIllIIlIIlIIIllIllllIIll() {
        for (UIComponent uIComponent : this.components) {
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
            List list = this.components;
            synchronized (list) {
                messageListUIComponent = new MessageListUIComponent(this);
                this.components.add(messageListUIComponent);
                messageListUIComponent.setPositionAndSize(this.llIlllIIIllllIIlllIllIIIl.getX() + this.llIlllIIIllllIIlllIllIIIl.getWidth() + 10.0f, 30.0f, 215.0f, 134.0f);
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

