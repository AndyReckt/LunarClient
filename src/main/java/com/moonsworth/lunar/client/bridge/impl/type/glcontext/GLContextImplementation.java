package com.moonsworth.lunar.client.bridge.impl.type.glcontext;

import com.moonsworth.lunar.bridge.opengl.GLContextBridge;
import org.lwjgl.opengl.GLContext;

public class GLContextImplementation implements GLContextBridge {
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return GLContext.getCapabilities().GL_KHR_debug;
    }
}
