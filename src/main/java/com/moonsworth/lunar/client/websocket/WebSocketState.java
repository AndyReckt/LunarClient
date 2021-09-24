package com.moonsworth.lunar.client.websocket;

public enum WebSocketState {
    DISCONNECTED("DISCONNECTED", 0),
    AWAITING_ENCRYPTION_REQUEST("AWAITING_ENCRYPTION_REQUEST", 1),
    AUTHENTICATING("AUTHENTICATING", 2),
    READY("READY", 3);

    WebSocketState(final String s, final int n) {
    }
}