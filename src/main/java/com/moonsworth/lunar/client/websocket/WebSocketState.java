package com.moonsworth.lunar.client.websocket;

public enum WebSocketState {
    DISCONNECTED,
    AWAITING_ENCRYPTION_REQUEST,
    AUTHENTICATING,
    READY;

}