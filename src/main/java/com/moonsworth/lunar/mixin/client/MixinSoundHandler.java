package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.audio.SoundHandlerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SoundHandler.class)
public abstract class MixinSoundHandler implements SoundHandlerBridge {

    @Shadow
    public abstract void playSound(ISound var1);

    public void bridge$playSound(ResourceLocationBridge var1) {
        this.playSound(PositionedSoundRecord.create((ResourceLocation)var1, 1.0f));
    }
}
