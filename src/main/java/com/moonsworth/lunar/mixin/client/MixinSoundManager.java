package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.audio.SoundPoolEntry;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SoundManager.class)
public abstract class MixinSoundManager {

    // todo: skyblock addons
    public float impl$getNormalizedVolume(SoundManager soundManager, ISound sound, SoundPoolEntry soundPoolEntry, SoundCategory soundCategory) {
        //return SoundManagerHook.getNormalizedVolume(this, sound, soundPoolEntry, soundCategory);
        return 0;
    }
}
