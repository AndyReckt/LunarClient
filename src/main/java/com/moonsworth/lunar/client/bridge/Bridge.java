package com.moonsworth.lunar.client.bridge;

import com.moonsworth.lunar.bridge.lunar.input.MouseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.OpenGlHelperBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderEntityItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RendererLivingEntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.UnknownRenderEntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureUtilBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.vertex.DefaultVertexFormatsBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.AbstractResourcePackBridge;
import com.moonsworth.lunar.bridge.minecraft.enchantment.EnchantmentHelperBridge;
import com.moonsworth.lunar.bridge.minecraft.init.BlocksBridge;
import com.moonsworth.lunar.bridge.minecraft.init.ItemsBridge;
import com.moonsworth.lunar.bridge.lunar.CosmeticBridge;
import com.moonsworth.lunar.bridge.lunar.RenderUtilBridge;
import com.moonsworth.lunar.bridge.minecraft.potion.PotionBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ClipboardBridge;
import com.moonsworth.lunar.bridge.minecraft.util.CryptManagerBridge;
import com.moonsworth.lunar.bridge.lunar.input.KeyboardBridge;
import com.moonsworth.lunar.bridge.minecraft.util.MathHelperBridge;
import com.moonsworth.lunar.bridge.opengl.GLContextBridge;
import com.moonsworth.lunar.bridge.optifine.OptifineBridge;

import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 15:47
 */
public class Bridge {

    public static IBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public static MinecraftBridge IlllIIIIIIlllIlIIlllIlIIl;
    public static CryptManagerBridge lIllIlIIIlIIIIIIIlllIlIll;
    public static GlStateManagerBridge llIlllIIIllllIIlllIllIIIl;
    public static TextureUtilBridge llllIIlIIlIIlIIllIIlIIllI;
    public static RenderUtilBridge IlIlIlllllIlIIlIlIlllIlIl;
    public static KeyboardBridge llIIIIIIIllIIllIlIllIIIIl;
    public static MouseBridge lIIIllIllIIllIlllIlIIlllI;
    public static GLContextBridge IlllllIlIIIlIIlIIllIIlIll;
    public static CosmeticBridge llIIlIlIIIllIlIlIlIIlIIll;
    public static OpenGlHelperBridge llIIIlllIIlllIllllIlIllIl;
    public static ItemsBridge lllllIllIllIllllIlIllllII;
    public static BlocksBridge lllIIIIIlllIIlIllIIlIIIlI;
    public static PotionBridge lIlIIIIIIlIIIllllIllIIlII;
    public static MathHelperBridge llIlIIIllIIlIllIllIllllIl;
    public static EnchantmentHelperBridge IllIllIIIllIIIlIlIlIIIIll;
    public static DefaultVertexFormatsBridge IIlIllIlllllllIIlIIIllIIl;
    public static OptifineBridge lIIlIlllIlIlIIIlllIIlIIII;
    public static UnknownRenderEntityBridge llIllIlIllIlllIllIIIIllII;
    public static String IllllllllllIlIIIlllIlllll;
    public static ClipboardBridge lllllIllIlIIlIIlIIIlllIlI;
    public static RenderEntityItemBridge IllIIIlllIIIlIlllIlIIlIII;
    public static AbstractResourcePackBridge IIlIllIlIIllIIlIlIllllllI;

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(IBridge iBridge) {
        if (lIlIlIlIlIIlIIlIIllIIIIIl != null) {
            throw new IllegalStateException("Can't reset Bridge Implementation!");
        }
        lIlIlIlIlIIlIIlIIllIIIIIl = iBridge;
        System.out.println("[Bridge] Setting Bridge Implementation to " + iBridge.getClass().getName());
        lIlIlIlIlIIlIIlIIllIIIIIl.enable();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(MinecraftBridge minecraftBridge) {
        if (IlllIIIIIIlllIlIIlllIlIIl != null) {
            throw new IllegalStateException("Can't reset Minecraft Client instance!");
        }
        IlllIIIIIIlllIlIIlllIlIIl = minecraftBridge;
        System.out.println("[Bridge] Setting Minecraft Client instance to " + minecraftBridge.getClass().getName());
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractResourcePackBridge abstractResourcePackBridge) {
        if (IIlIllIlIIllIIlIlIllllllI != null) {
            throw new IllegalStateException("Can't reset Cosmetic Resource Pack!");
        }
        IIlIllIlIIllIIlIlIllllllI = abstractResourcePackBridge;
    }

    public static Optional lIlIlIlIlIIlIIlIIllIIIIIl() {
        return Optional.ofNullable(IIlIllIlIIllIIlIlIllllllI);
    }

    public static MinecraftVersion IlllIIIIIIlllIlIIlllIlIIl() {
        return lIlIlIlIlIIlIIlIIllIIIIIl.getMinecraftVersion();
    }

    public static Optional<OptifineBridge> lIllIlIIIlIIIIIIIlllIlIll() {
        return Optional.ofNullable(lIIlIlllIlIlIIIlllIIlIIII);
    }

    public static IBridge llIlllIIIllllIIlllIllIIIl() {
        return lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public static MinecraftBridge llllIIlIIlIIlIIllIIlIIllI() {
        return IlllIIIIIIlllIlIIlllIlIIl;
    }

    public static CryptManagerBridge IlIlIlllllIlIIlIlIlllIlIl() {
        return lIllIlIIIlIIIIIIIlllIlIll;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(CryptManagerBridge cryptManagerBridge) {
        lIllIlIIIlIIIIIIIlllIlIll = cryptManagerBridge;
    }

    public static GlStateManagerBridge llIIIIIIIllIIllIlIllIIIIl() {
        return llIlllIIIllllIIlllIllIIIl;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(GlStateManagerBridge glStateManagerBridge) {
        llIlllIIIllllIIlllIllIIIl = glStateManagerBridge;
    }

    public static TextureUtilBridge lIIIllIllIIllIlllIlIIlllI() {
        return llllIIlIIlIIlIIllIIlIIllI;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(TextureUtilBridge textureUtilBridge) {
        llllIIlIIlIIlIIllIIlIIllI = textureUtilBridge;
    }

    public static RenderUtilBridge IlllllIlIIIlIIlIIllIIlIll() {
        return IlIlIlllllIlIIlIlIlllIlIl;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(RenderUtilBridge renderUtilBridge) {
        IlIlIlllllIlIIlIlIlllIlIl = renderUtilBridge;
    }

    public static KeyboardBridge llIIlIlIIIllIlIlIlIIlIIll() {
        return llIIIIIIIllIIllIlIllIIIIl;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(KeyboardBridge keyboardBridge) {
        llIIIIIIIllIIllIlIllIIIIl = keyboardBridge;
    }

    public static MouseBridge llIIIlllIIlllIllllIlIllIl() {
        return lIIIllIllIIllIlllIlIIlllI;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(MouseBridge mouseBridge) {
        lIIIllIllIIllIlllIlIIlllI = mouseBridge;
    }

    public static GLContextBridge lllllIllIllIllllIlIllllII() {
        return IlllllIlIIIlIIlIIllIIlIll;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(GLContextBridge gLContextBridge) {
        IlllllIlIIIlIIlIIllIIlIll = gLContextBridge;
    }

    public static CosmeticBridge lllIIIIIlllIIlIllIIlIIIlI() {
        return llIIlIlIIIllIlIlIlIIlIIll;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(CosmeticBridge cosmeticBridge) {
        llIIlIlIIIllIlIlIlIIlIIll = cosmeticBridge;
    }

    public static OpenGlHelperBridge lIlIIIIIIlIIIllllIllIIlII() {
        return llIIIlllIIlllIllllIlIllIl;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(OpenGlHelperBridge openGlHelperBridge) {
        llIIIlllIIlllIllllIlIllIl = openGlHelperBridge;
    }

    public static ItemsBridge llIlIIIllIIlIllIllIllllIl() {
        return lllllIllIllIllllIlIllllII;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(ItemsBridge itemsBridge) {
        lllllIllIllIllllIlIllllII = itemsBridge;
    }

    public static BlocksBridge IllIllIIIllIIIlIlIlIIIIll() {
        return lllIIIIIlllIIlIllIIlIIIlI;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(BlocksBridge blocksBridge) {
        lllIIIIIlllIIlIllIIlIIIlI = blocksBridge;
    }

    public static PotionBridge IIlIllIlllllllIIlIIIllIIl() {
        return lIlIIIIIIlIIIllllIllIIlII;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(PotionBridge potionBridge) {
        lIlIIIIIIlIIIllllIllIIlII = potionBridge;
    }

    public static MathHelperBridge lIIlIlllIlIlIIIlllIIlIIII() {
        return llIlIIIllIIlIllIllIllllIl;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(MathHelperBridge mathHelperBridge) {
        llIlIIIllIIlIllIllIllllIl = mathHelperBridge;
    }

    public static EnchantmentHelperBridge llIllIlIllIlllIllIIIIllII() {
        return IllIllIIIllIIIlIlIlIIIIll;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(EnchantmentHelperBridge enchantmentHelperBridge) {
        IllIllIIIllIIIlIlIlIIIIll = enchantmentHelperBridge;
    }

    public static DefaultVertexFormatsBridge IllllllllllIlIIIlllIlllll() {
        return IIlIllIlllllllIIlIIIllIIl;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(DefaultVertexFormatsBridge defaultVertexFormatsBridge) {
        IIlIllIlllllllIIlIIIllIIl = defaultVertexFormatsBridge;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(OptifineBridge optifineBridge) {
        lIIlIlllIlIlIIIlllIIlIIII = optifineBridge;
    }

    public static UnknownRenderEntityBridge lllllIllIlIIlIIlIIIlllIlI() {
        return llIllIlIllIlllIllIIIIllII;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(UnknownRenderEntityBridge rendererLivingEntityBridge) {
        llIllIlIllIlllIllIIIIllII = rendererLivingEntityBridge;
    }

    public static String IllIIIlllIIIlIlllIlIIlIII() {
        return IllllllllllIlIIIlllIlllll;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        IllllllllllIlIIIlllIlllll = string;
    }

    public static ClipboardBridge IIlIllIlIIllIIlIlIllllllI() {
        return lllllIllIlIIlIIlIIIlllIlI;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(ClipboardBridge clipboardBridge) {
        lllllIllIlIIlIIlIIIlllIlI = clipboardBridge;
    }

    public static RenderEntityItemBridge lIIIlllIIIIllllIlIIIlIIll() {
        return IllIIIlllIIIlIlllIlIIlIII;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(RenderEntityItemBridge droppedItemRenderer) {
        IllIIIlllIIIlIlllIlIIlIII = droppedItemRenderer;
    }

    static {
        IllllllllllIlIIIlllIlllll = "http://s.optifine.net";
    }

}
