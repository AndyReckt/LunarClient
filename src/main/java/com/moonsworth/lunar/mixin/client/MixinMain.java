package com.moonsworth.lunar.mixin.client;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import net.minecraft.client.main.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.io.File;

/**
 * @author Decencies
 * @since 09/07/2021 23:03
 */
@Mixin(Main.class)
public class MixinMain {

    private static OptionSpec<String> launcherVersion;
    private static OptionSpec<String> texturesDir;

    @Inject(method = "main", at = @At("HEAD"))
    private static void init(CallbackInfo ci) {
        System.out.println("LUNARCLIENT_STATUS_INIT");
        System.setProperty("jna.noclasspath", "true");
        System.setProperty("jna.nounpack", "true");
        System.setProperty("jna.library.path", System.getProperty("java.library.path"));
        //Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new BridgeImplementation());
    }

    @Redirect(method = "main", at = @At(value = "INVOKE", target = "Ljoptsimple/OptionParser;parse([Ljava/lang/String;)Ljoptsimple/OptionSet;"))
    private static OptionSet setLauncherVersionAndTexturesDirectory(OptionParser parser, String[] arguments) {
        OptionSet optionSet = parser.parse(arguments);
        System.out.println("launcherVersion: " + optionSet.valueOf(launcherVersion));
        //AssetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl = (String)optionSet.valueOf(launcherVersion);
        String string = optionSet.valueOf(texturesDir);
        if (string != null) {
            System.out.println("[Bridge] Found textures dir: " + new File(string).getAbsolutePath());
            //Bridge.lIlIlIlIlIIlIIlIIllIIIIIl(new CosmeticsResourcePack(new File(string)));
        }
        return optionSet;
    }

    @Inject(method = "main", at = @At(value = "INVOKE", target = "Ljoptsimple/OptionParser;allowsUnrecognizedOptions()V"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void addParserSpecifications(String[] p_main_0_, CallbackInfo ci, OptionParser parser) {
        launcherVersion = parser.accepts("launcherVersion").withRequiredArg().defaultsTo("not supplied");
        texturesDir = parser.accepts("texturesDir").withRequiredArg();
    }

}
