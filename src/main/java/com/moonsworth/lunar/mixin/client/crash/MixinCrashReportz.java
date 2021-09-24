package com.moonsworth.lunar.mixin.client.crash;

import com.moonsworth.lunar.bridge.minecraft.crash.CrashReportBridge;
import net.minecraft.crash.CrashReport;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CrashReport.class)
public class MixinCrashReportz implements CrashReportBridge {
    @Final
    @Shadow
    private String description;
    @Final
    @Shadow
    private Throwable cause;

    public MixinCrashReportz() {
    }

    public String bridge$getTitle() {
        return this.description;
    }

    public Throwable bridge$getCause() {
        return this.cause;
    }
}