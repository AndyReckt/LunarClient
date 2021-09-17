package com.moonsworth.lunar.bridge.minecraft.crash;

/**
 * @author Decencies
 * @since 10/07/2021 12:35
 */
public interface CrashReportBridge {
    String bridge$getTitle();

    Throwable bridge$getCause();
}
