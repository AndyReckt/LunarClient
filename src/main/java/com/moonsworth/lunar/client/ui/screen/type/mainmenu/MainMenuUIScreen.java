package com.moonsworth.lunar.client.ui.screen.type.mainmenu;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.blog.BlogCache;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.type.setting.DefaultButtonUIComponent;
import com.moonsworth.lunar.client.ui.screen.AnimatedLunarLogoUIComponent;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.login.MainMenuLoginUIScreen;
import com.moonsworth.lunar.client.util.BrowserUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Decencies
 * @since 10/07/2021 18:48
 */
public class MainMenuUIScreen extends BaseMainMenuUIScreen {
    public DefaultButtonUIComponent singleplayerButton;
    public DefaultButtonUIComponent multiplayerButton;
    public AnimatedLunarLogoUIComponent IIlIllIlllllllIIlIIIllIIl;
    public List<BlogPostUIComponent> lIIlIlllIlIlIIIlllIIlIIII;
    public ScheduledExecutorService llIllIlIllIlllIllIIIIllII = Executors.newScheduledThreadPool(1);
    public int IllllllllllIlIIIlllIlllll = 0;

    public MainMenuUIScreen() {
        this.singleplayerButton = new DefaultButtonUIComponent(null, "singleplayer");
        this.components.add(this.singleplayerButton);
        this.multiplayerButton = new DefaultButtonUIComponent(null, "multiplayer");
        this.components.add(this.multiplayerButton);
        this.IIlIllIlllllllIIlIIIllIIl = new AnimatedLunarLogoUIComponent(null, true, true);
        this.components.add(this.IIlIllIlllllllIIlIIIllIIl);
        this.singleplayerButton.onMouseClick((f, f2, n) -> {
            if (!Ref.getLC().llIlIIIllIIlIllIllIllllIl().llIIIlllIIlllIllllIlIllIl()) {
                Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuLoginUIScreen()));
                return false;
            }
            Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initGuiSelectWorld(null));
            return true;
        });
        this.multiplayerButton.onMouseClick((f, f2, n) -> {
            if (!Ref.getLC().llIlIIIllIIlIllIllIllllIl().llIIIlllIIlllIllllIlIllIl()) {
                Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuLoginUIScreen()));
                return false;
            }
            Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initGuiMultiplayer(null));
            return true;
        });
        this.llIIIIIIIllIIllIlIllIIIIl();
        Runnable runnable = () -> {
            if (this.lIIlIlllIlIlIIIlllIIlIIII != null && !this.lIIlIlllIlIlIIIlllIIlIIII.isEmpty()) {
                this.lIIlIlllIlIlIIIlllIIlIIII.get(this.IllllllllllIlIIIlllIlllll).llllIIlIIlIIlIIllIIlIIllI().lIllIlIIIlIIIIIIIlllIlIll();
                this.lIIlIlllIlIlIIIlllIIlIIII.get(this.IllllllllllIlIIIlllIlllll).lIlIlIlIlIIlIIlIIllIIIIIl(false);
                this.IllllllllllIlIIIlllIlllll = this.IllllllllllIlIIIlllIlllll == this.lIIlIlllIlIlIIIlllIIlIIII.size() - 1 ? 0 : ++this.IllllllllllIlIIIlllIlllll;
                this.lIIlIlllIlIlIIIlllIIlIIII.get(this.IllllllllllIlIIIlllIlllll).llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll();
                this.lIIlIlllIlIlIIIlllIIlIIII.get(this.IllllllllllIlIIIlllIlllll).lIlIlIlIlIIlIIlIIllIIIIIl(true);
            }
        };
        this.llIllIlIllIlllIllIIIIllII.scheduleAtFixedRate(runnable, 10L, 10L, TimeUnit.SECONDS);
    }

    @Override
    public void llIIIIIIIllIIllIlIllIIIIl() {
        if (!LunarClient.getInstance().IIlllIllIlIllIllIIllIlIIl().llIlllIIIllllIIlllIllIIIl().isEmpty() && (this.lIIlIlllIlIlIIIlllIIlIIII == null || this.lIIlIlllIlIlIIIlllIIlIIII.isEmpty())) {
            this.lIIlIlllIlIlIIIlllIIlIIII = new ArrayList<>();
            for (BlogCache blogCache : LunarClient.getInstance().IIlllIllIlIllIllIIllIlIIl().llIlllIIIllllIIlllIllIIIl()) {
                this.lIIlIlllIlIlIIIlllIIlIIII.add(new BlogPostUIComponent(null, this, blogCache));
            }
            this.llIIIlllIIlllIllllIlIllIl();
            this.lIIlIlllIlIlIIIlllIIlIIII.get(0).lIlIlIlIlIIlIIlIIllIIIIIl(true);
            this.lIIlIlllIlIlIIIlllIIlIIII.get(0).llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll();
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        if (this.lIIlIlllIlIlIIIlllIIlIIII != null) {
            for (BlogPostUIComponent blogPostUIComponent : this.lIIlIlllIlIlIIIlllIIlIIII) {
                if (!blogPostUIComponent.mouseInside(f, f2) || this.IllllllllllIlIIIlllIlllll != this.lIIlIlllIlIlIIIlllIIlIIII.indexOf(blogPostUIComponent)) continue;
                BrowserUtil.lIlIlIlIlIIlIIlIIllIIIIIl(blogPostUIComponent.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl());
            }
        }
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
        super.lIlIIIIIIlIIIllllIllIIlII();
        this.llIllIlIllIlllIllIIIIllII.shutdownNow();
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
        super.lllllIllIllIllllIlIllllII();
        if (this.lIIlIlllIlIlIIIlllIIlIIII == null || this.lIIlIlllIlIlIIIlllIIlIIII.isEmpty()) {
            this.llIIIIIIIllIIllIlIllIIIIl();
        }
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        super.llIIIlllIIlllIllllIlIllIl();
        float f = this.IllllllllllIlIIIlllIlllll() / 2.0f - 100.0f;
        float f2 = 200.0f;
        this.singleplayerButton.setPositionAndSize(f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f, f2, 17.0f);
        this.multiplayerButton.setPositionAndSize(f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + 23.0f, f2, 17.0f);
        float f3 = 64.0f;
        float f4 = this.IllllllllllIlIIIlllIlllll() / 2.0f;
        float f5 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - f3 * 1.5f;
        this.IIlIllIlllllllIIlIIIllIIl.setPositionAndSize(f4 - f3 / 2.0f, f5, f3, 58.5f);
        if (this.lIIlIlllIlIlIIIlllIIlIIII != null && !this.lIIlIlllIlIlIIIlllIIlIIII.isEmpty()) {
            for (BlogPostUIComponent blogPostUIComponent : this.lIIlIlllIlIlIIIlllIIlIIII) {
                blogPostUIComponent.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() - 100.5f - 10.0f, this.lllllIllIlIIlIIlIIIlllIlI() - 42.5f - 22.0f, 100.5f, 42.5f);
            }
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2);
        if (this.lIIlIlllIlIlIIIlllIIlIIII != null) {
            for (BlogPostUIComponent blogPostUIComponent : this.lIIlIlllIlIlIIIlllIIlIIII) {
                blogPostUIComponent.drawComponent(f, f2, this.lIlIlIlIlIIlIIlIIllIIIIIl(blogPostUIComponent, f, f2));
            }
        }
        String string = "LUNAR";
        float f3 = FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.IlllIIIIIIlllIlIIlllIlIIl(string);
        FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(string, this.IllllllllllIlIIIlllIlllll() / 2.0f - f3 - 2.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 27.0f, 0x3A000000);
        FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(string, this.IllllllllllIlIIIlllIlllll() / 2.0f - f3 - 2.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 28.0f, -1);
        FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl("CLIENT", this.IllllllllllIlIIIlllIlllll() / 2.0f + 2.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 27.0f, 0x3A000000);
        FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl("CLIENT", this.IllllllllllIlIIIlllIlllll() / 2.0f + 2.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 28.0f, -1);
    }
}