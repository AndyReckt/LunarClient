package com.moonsworth.lunar.client.feature.type.chat;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiNewChatBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatComponentTextBridge;
import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.chat.ChatEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.profile.main.GeneralOptions;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.EnumSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;

import java.util.List;

public class ChatMod extends ConfigurableFeature {
    public BooleanSetting llllIIlIIlIIlIIllIIlIIllI;
    public BooleanSetting IlIlIlllllIlIIlIlIlllIlIl;
    public BooleanSetting llIIIIIIIllIIllIlIllIIIIl;
    public BooleanSetting lIIIllIllIIllIlllIlIIlllI;
    public NumberSetting IlllllIlIIIlIIlIIllIIlIll;
    public BooleanSetting llIIlIlIIIllIlIlIlIIlIIll;
    public BooleanSetting llIIIlllIIlllIllllIlIllIl;
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;
    public EnumSetting lIlIIIIIIlIIIllllIllIIlII;
    public IChatComponentBridge llIlIIIllIIlIllIllIllllIl;
    public int IllIllIIIllIIIlIlIlIIIIll;
    public int IIlIllIlllllllIIlIIIllIIl;

    public ChatMod() {
        super(true);
        this.IllIllIIIllIIIlIlIlIIIIll = 1;
        this.IIlIllIlllllllIIlIIIllIIl = 0;
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ChatEvent.class, chatEvent -> {
            if (chatEvent.lIllIlIIIlIIIIIIIlllIlIll() != 2) {
                if (this.llIIIlllIIlllIllllIlIllIl.llIlllIIIllllIIlllIllIIIl()) {
                    chatEvent.setCancelled(true);
                } else if (this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl()) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(chatEvent);
                }
            }
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final ChatEvent chatEvent) {
        final GuiNewChatBridge bridge$getChatGUI = Ref.getMinecraft().bridge$getGuiIngame().bridge$getChatGUI();
        if (chatEvent.IlllIIIIIIlllIlIIlllIlIIl().equals(this.llIlIIIllIIlIllIllIllllIl)) {
            bridge$getChatGUI.bridge$deleteMessage(-this.IllIllIIIllIIIlIlIlIIIIll);
            if (chatEvent.IlllIIIIIIlllIlIIlllIlIIl() instanceof ChatComponentTextBridge) {
                ((ChatComponentTextBridge) chatEvent.IlllIIIIIIlllIlIIlllIlIIl()).bridge$appendSibling(Bridge.getInstance().initChatText(" [x" + this.IIlIllIlllllllIIlIIIllIIl++ + "]"));
                chatEvent.lIlIlIlIlIIlIIlIIllIIIIIl(chatEvent.IlllIIIIIIlllIlIIlllIlIIl());
            }
        } else {
            this.llIlIIIllIIlIllIllIllllIl = chatEvent.IlllIIIIIIlllIlIIlllIlIIl();
            this.IIlIllIlllllllIIlIIIllIIl = 2;
        }
        this.IllIllIIIllIIIlIlIlIIIIll = (this.IllIllIIIllIIIlIlIlIIIIll + 1) % 1000;
        chatEvent.setCancelled(true);
        bridge$getChatGUI.bridge$sendMessageWithId(chatEvent.IlllIIIIIIlllIlIIlllIlIIl(), -this.IllIllIIIllIIIlIlIlIIIIll);
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        final BooleanSetting booleanSetting = new BooleanSetting(this.enabled, "unlimited_chat", true);
        this.IlIlIlllllIlIIlIlIlllIlIl = booleanSetting;
        final BooleanSetting booleanSetting2 = new BooleanSetting(this.enabled, "stackMessages", false);
        this.llIIIIIIIllIIllIlIllIIIIl = booleanSetting2;
        final BooleanSetting booleanSetting3 = new BooleanSetting(this.enabled, "hideBanWave", false);
        this.llllIIlIIlIIlIIllIIlIIllI = booleanSetting3;
        final BooleanSetting booleanSetting4 = new BooleanSetting(this.enabled, "chatHeight", false, () -> Bridge.getMinecraftVersion().lIllIlIIIlIIIIIIIlllIlIll());
        this.lIIIllIllIIllIlllIlIIlllI = booleanSetting4;
        final EnumSetting enumSetting = new EnumSetting("chatNameColor", GeneralOptions.SomeScaleFactorShit.OFF);
        this.lIlIIIIIIlIIIllllIllIIlII = enumSetting;
        final NumberSetting numberSetting = new NumberSetting("chat_bg_opacity", 1.0f, 0.0f, 1.0f);
        this.IlllllIlIIIlIIlIIllIIlIll = numberSetting;
        final BooleanSetting booleanSetting5 = new BooleanSetting(this.enabled, "chat_shadow", true);
        this.llIIlIlIIIllIlIlIlIIlIIll = booleanSetting5;
        final BooleanSetting booleanSetting6 = new BooleanSetting(this.enabled, "disable_chat", false);
        this.llIIIlllIIlllIllllIlIllIl = booleanSetting6;
        final BooleanSetting booleanSetting7 = new BooleanSetting(this.enabled, "no_close_my_chat", true);
        this.lllIIIIIlllIIlIllIIlIIIlI = booleanSetting7;
        return ImmutableList.of(booleanSetting, booleanSetting2, booleanSetting3, booleanSetting4, enumSetting, numberSetting, booleanSetting5, booleanSetting6, booleanSetting7);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final boolean b) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Chat", n, n2, n3, n4);
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("chat", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.NEW, ModuleCategory.HUD));
    }

    public BooleanSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public BooleanSetting lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public BooleanSetting lIlIlIIIIIIllIlIIIIllIIII() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public BooleanSetting lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public NumberSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public BooleanSetting IIlIlIIIllIIllllIllllIlIl() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public BooleanSetting lllllIIIIlIlllIllIIIlIIlI() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public BooleanSetting IIlllIllIlIllIllIIllIlIIl() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public EnumSetting lIlIIlIlllIIlIIIlIlIlIllI() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public IChatComponentBridge lIIlllIIIIIlllIIIlIlIlllI() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public int IIIlIIIIIIllIIIIllIIIIlII() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public int IlIIIlIlIlIlIlIllIIllIIlI() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }
}
