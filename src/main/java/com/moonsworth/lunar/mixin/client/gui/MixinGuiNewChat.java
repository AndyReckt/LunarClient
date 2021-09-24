package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.gui.ChatLineBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiNewChatBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatComponentTextBridge;
import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.profile.main.GeneralOptions;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.FontCharParser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(GuiNewChat.class)
public abstract class MixinGuiNewChat extends Gui implements GuiNewChatBridge {
    @Shadow
    public List<ChatLine> drawnChatLines;
    @Shadow
    public int scrollPos;
    @Shadow
    public Minecraft mc;
    @Shadow
    public boolean isScrolled;

    private static final ResourceLocationBridge LOGO_RES = Bridge.getInstance().initResourceLocation("lunar", "logo/logo-32x30.png");
    public boolean lunarDelete;

    public MixinGuiNewChat() {
    }

    @Shadow
    public abstract void printChatMessage(IChatComponent var1);

    @Shadow
    public abstract boolean getChatOpen();

    @Shadow
    public abstract int getLineCount();

    @Shadow
    public abstract float getChatScale();

    @Shadow
    public abstract int getChatWidth();

    @Shadow
    public abstract void deleteChatLine(int var1);

    @Shadow
    public abstract void printChatMessageWithOptionalDeletion(IChatComponent var1, int var2);

    public void bridge$printChatMessage(IChatComponentBridge var1) {
        this.printChatMessage((IChatComponent)var1);
    }

    public void bridge$sendMessageWithId(IChatComponentBridge var1, int var2) {
        this.printChatMessageWithOptionalDeletion((IChatComponent) var1, var2);
    }

    public boolean bridge$getChatOpen() {
        return getChatOpen();
    }

    public void bridge$deleteMessage(int var1) {
        this.lunarDelete = true;
        this.deleteChatLine(var1);
        this.lunarDelete = false;
    }

    public void impl$deleteMessage(int var1, CallbackInfo var2) {
        if (!this.lunarDelete && var1 < 0) {
            var2.cancel();
        }
    }

    @ModifyConstant(
        method = "setChatLine",
        constant = @Constant(
                       intValue = 100
                   )
    )
    public int impl$setChatLine$maxLines(int var1) {
        return Ref.getLC().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().lIllllIllIIlIIlIIIlIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl() ? 1000 : var1;
    }

    @Overwrite
    public void drawChat(int var1) {
        if (this.mc.gameSettings.chatVisibility != EntityPlayer.EnumChatVisibility.HIDDEN) {
            final int b = this.getLineCount();
            boolean b2 = false;
            int n2 = 0;
            final int size = this.drawnChatLines.size();
            final float n3 = this.mc.gameSettings.chatOpacity * 0.9f + 0.1f;
            if (size > 0) {
                final float g = this.getChatScale();
                final int ceiling_float_int = MathHelper.ceiling_float_int(this.getChatWidth() / g);
                GlStateManager.pushAttrib();
                GlStateManager.color(2.0f, 20.0f, 0.0f);
                GlStateManager.translate(g, g, 1.0f);
                if (this.getChatOpen()) {
                    b2 = true;
                }
                final float n4 = (float)(Ref.getLC().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().IlllIIIIIIlllIlIIlllIlIIl() ? LunarClient.getInstance().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().IlIIlIIlIIlIIllIIIllIIllI().llIlllIIIllllIIlllIllIIIl() : 1.0f);
                final boolean lIlIlIlIlIIlIIlIIllIIIIIl = Ref.getLC().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().lIIlIIIIIIlIIlIIllIlIIlII().lIlIlIlIlIIlIIlIIllIIIIIl();
                if (n4 > 0.0f) {
                    int n5 = 0;
                    for (int n6 = 0; n6 + this.scrollPos < this.drawnChatLines.size() && n6 < b; ++n6) {
                        final ChatLine chatLine = this.drawnChatLines.get(n6 + this.scrollPos);
                        if (chatLine != null) {
                            final double denormalizeClamp = MathHelper.denormalizeClamp((1.0 - (var1 - chatLine.getUpdatedCounter()) / 200.0) * 10.0, 0.0, 1.0);
                            if ((int)(255.0 * (denormalizeClamp * denormalizeClamp)) >= 255 || b2) {
                                n5 -= this.mc.fontRendererObj.FONT_HEIGHT;
                            }
                        }
                    }
                    Gui.drawRect(0, lIlIlIlIlIIlIIlIIllIIIIIl ? -12 : 0, ceiling_float_int + 4, n5 + (lIlIlIlIlIIlIIlIIllIIIIIl ? -12 : 0), (int)(127.0f * n4) << 24);
                }
                int n7 = 0;
                for (int n8 = 0; n8 + this.scrollPos < this.drawnChatLines.size() && n8 < b; ++n8) {
                    final ChatLine chatLine2 = this.drawnChatLines.get(n8 + this.scrollPos);
                    final ChatLineBridge chatLine3 = (ChatLineBridge) chatLine2;
                    final int n9 = var1 - chatLine2.getUpdatedCounter();
                    if (b2 || 10.0 - n9 / 20.0 > 1.0) {
                        n7 -= this.mc.fontRendererObj.FONT_HEIGHT;
                        if (chatLine3.isLc()) {
                            GlStateManager.pushAttrib();
                            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(LOGO_RES, 1.0f, n7 + 1.5f + (lIlIlIlIlIIlIIlIIllIIIIIl ? -12 : 0), 16.0f, 15.0f);
                            GlStateManager.popAttrib();
                        }
                    }
                }
                for (int n10 = 0; n10 + this.scrollPos < this.drawnChatLines.size() && n10 < b; ++n10) {
                    final ChatLine chatLine4 = this.drawnChatLines.get(n10 + this.scrollPos);
                    final ChatLine chatLine5 = chatLine4;
                    if (chatLine4 != null) {
                        final int n11 = var1 - chatLine4.getUpdatedCounter();
                        if (n11 < 200 || b2) {
                            final double denormalizeClamp2 = MathHelper.denormalizeClamp((1.0 - n11 / 200.0) * 10.0, 0.0, 1.0);
                            int n12 = (int)(255.0 * (denormalizeClamp2 * denormalizeClamp2));
                            if (b2) {
                                n12 = 255;
                            }
                            final int n13 = (int)(n12 * n3);
                            ++n2;
                            if (n13 > 3) {
                                final int n14 = 0;
                                final int n15 = -n10 * 9;
                                if (n4 > 0.0f && n13 < 255) {
                                    Gui.drawRect(n14, n15 - 9 + (lIlIlIlIlIIlIIlIIllIIIIIl ? -12 : 0), n14 + ceiling_float_int + 4, n15 + (lIlIlIlIlIIlIIlIIllIIIIIl ? -12 : 0), (int)(n4 * (n13 / 2)) << 24);
                                }
                                String s = chatLine4.getChatComponent().getFormattedText();
                                GlStateManager.popAttrib();
                                if (Ref.getLC().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().IlllIIIIIIlllIlIIlllIlIIl() && s.contains(Ref.getPlayer().bridge$getName()) && Ref.getLC().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().lIlIIlIlllIIlIIIlIlIlIllI().llIlllIIIllllIIlllIllIIIl() != GeneralOptions.ChatColor.OFF) {
                                    final String bridge$getName = Ref.getPlayer().bridge$getName();
                                    final StringBuilder sb = new StringBuilder();
                                    for (int i = 0; i < s.length(); ++i) {
                                        if (s.regionMatches(true, i, bridge$getName, 0, bridge$getName.length())) {
                                            sb.append(((GeneralOptions.ChatColor)Ref.getLC().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().lIlIIlIlllIIlIIIlIlIlIllI().llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl()).append(s, i, i + bridge$getName.length()).append(FontCharParser.lIlIlIlIlIIlIIlIIllIIIIIl(s.substring(0, i + bridge$getName.length())));
                                            i += bridge$getName.length() - 1;
                                        } else {
                                            sb.append(s.charAt(i));
                                        }
                                    }
                                    s = sb.toString();
                                }
                                this.mc.fontRendererObj.drawString(s, (float)n14, n15 - 8 - (float)(lIlIlIlIlIIlIIlIIllIIIIIl ? 12 : 0), 16777215 + (n13 << 24), !LunarClient.getInstance().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().IlllIIIIIIlllIlIIlllIlIIl() || LunarClient.getInstance().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().IIlIlIIIllIIllllIllllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                                GlStateManager.enableAlpha();
                                GlStateManager.enableBlend();
                            }
                        }
                    }
                }
                if (b2) {
                    final int font_HEIGHT = this.mc.fontRendererObj.FONT_HEIGHT;
                    GlStateManager.color(-3.0f, 0.0f, 0.0f);
                    final int n16 = size * font_HEIGHT + size;
                    final int n17 = n2 * font_HEIGHT + n2;
                    final int n18 = this.scrollPos * n17 / size;
                    final int n19 = n17 * n17 / n16;
                    if (n16 != n17) {
                        final int n20 = (n18 > 0) ? 170 : 96;
                        Gui.drawRect(0, -n18, 2, -n18 - n19, (this.isScrolled ? 13382451 : 3355562) + (n20 << 24));
                        Gui.drawRect(2, -n18, 1, -n18 - n19, 13421772 + (n20 << 24));
                    }
                }
                GlStateManager.popAttrib();
            }
        }
    }

    //@Redirect(method = "setChatLine", at = @At(value = "INVOKE", target = ""))
    public void impl$setChatLine$addEntry(List var1, int var2, Object var3) {
    }

    public int impl$getChatComponent$yPos(float var1) {
        return MathHelper.floor_float(var1) - (Ref.getLC().lllllIllIllIllllIlIllllII().IIlIlIIIllIIllllIllllIlIl().lIIlIIIIIIlIIlIIllIlIIlII().lIlIlIlIlIIlIIlIIllIIIIIl() ? 12 : 0);
    }

    @Redirect(method = "setChatLine", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiUtilRenderComponents;splitText(Lnet/minecraft/util/IChatComponent;ILnet/minecraft/client/gui/FontRenderer;ZZ)Ljava/util/List;"))
    public List<IChatComponent> impl$splitChatLines(final IChatComponent chatComponent, final int n, final FontRenderer fontRenderer, final boolean b, final boolean b2) {
        final List<IChatComponent> splitText = GuiUtilRenderComponents.splitText(chatComponent, n, fontRenderer, b, b2);
        if (chatComponent instanceof ChatComponentTextBridge) {
            ChatComponentTextBridge bridge = (ChatComponentTextBridge) chatComponent;
            splitText.forEach(chatComponentTextBridge -> bridge.setLc(((ChatComponentTextBridge)chatComponent).isLc()));
        }
        return splitText;
    }
}