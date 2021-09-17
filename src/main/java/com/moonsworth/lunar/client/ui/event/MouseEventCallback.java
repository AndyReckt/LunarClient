package com.moonsworth.lunar.client.ui.event;

/**
 * @author Decencies
 * @since 10/07/2021 15:42
 */
@FunctionalInterface
public interface MouseEventCallback {
    public boolean accept(float var1, float var2, int var3);
}