package com.moonsworth.lunar.client.ui.event;

/**
 * @author Decencies
 * @since 10/07/2021 15:42
 */
@FunctionalInterface
public interface MouseEventCallback {
    boolean accept(float mouseX, float mouseY, int button);
}