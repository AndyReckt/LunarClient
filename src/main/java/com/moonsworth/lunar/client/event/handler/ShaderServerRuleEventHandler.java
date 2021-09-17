package com.moonsworth.lunar.client.event.handler;

import com.lunarclient.bukkitapi.nethandler.client.obj.ServerRule;
import com.moonsworth.lunar.bridge.optifine.ShadersBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.event.type.world.PreRunTickEvent;

public class ShaderServerRuleEventHandler
implements EventHandler {
    public ShaderServerRuleEventHandler() {

        this.lIlIlIlIlIIlIIlIIllIIIIIl(PreRunTickEvent.class, preRunTickEvent -> {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl() && ((Boolean)ServerIntegration.lIlIlIlIlIIlIIlIIllIIIIIl(ServerRule.SHADERS_DISABLED)).booleanValue()) {
                Bridge.lIllIlIIIlIIIIIIIlllIlIll().ifPresent(optifineBridge -> {
                    ShadersBridge shadersBridge = optifineBridge.getShaders();
                    shadersBridge.setShaderPack(shadersBridge.getPackNone());
                });
            }
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, netHandlerConnectionStateUpdateEvent -> {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl() && ((Boolean)ServerIntegration.lIlIlIlIlIIlIIlIIllIIIIIl(ServerRule.SHADERS_DISABLED)).booleanValue()) {
                Bridge.lIllIlIIIlIIIIIIIlllIlIll().ifPresent(optifineBridge -> {
                    ShadersBridge shadersBridge = optifineBridge.getShaders();
                    shadersBridge.setShaderPack(shadersBridge.getPackNone());
                });
            }
        });
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return Bridge.lIllIlIIIlIIIIIIIlllIlIll().map(optifineBridge -> {
            ShadersBridge shadersBridge = optifineBridge.getShaders();
            String string = shadersBridge.getShaderPack();
            return string != null && !string.equalsIgnoreCase(shadersBridge.getPackNone()) && !string.equalsIgnoreCase(shadersBridge.getPackDefault());
        }).orElse(false);
    }
}
 