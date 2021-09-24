package com.moonsworth.lunar.client.bridge.impl.type.otherutil;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.TessellatorBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ModelCloak;
import com.moonsworth.lunar.bridge.minecraft.util.Vector3f;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.util.GLBufferUtil;
import org.lwjgl.opengl.GL11;

import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ModelCloakImplementation implements ModelCloak {
    public float[] texCoords;
    public final float[] rawTexCoords;
    public final Vector3f[] rawVertices;
    public final Map<Integer, Integer> displayLists;
    public int lastFrame;

    public static ModelCloakImplementation create(float var0, float var1, float var2, int var3, int var4, int var5, int var6, int var7) {
        Vector3f var8 = new Vector3f(var0 - (float)var3, var1 - (float)var4, var2 - (float)var5);
        Vector3f var9 = new Vector3f(var0 + (float)var3, var1 + (float)var4, var2 + (float)var5);
        return new ModelCloakImplementation(var9, var8, var6, var7);
    }

    public static ModelCloakImplementation createDefault(int var0, int var1) {
        return create(0.0F, 16.0F, -1.0F, 10, 16, 1, var0, var1);
    }

    public ModelCloakImplementation(Vector3f var1, Vector3f var2, int var3, int var4) {
        Vector3f var5 = Vector3f.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2, null);
        var5.llIIIIIIIllIIllIlIllIIIIl /= 2.0F;
        var5.lIIIllIllIIllIlllIlIIlllI /= 2.0F;
        var5.IlllllIlIIIlIIlIIllIIlIll /= 2.0F;
        float var6 = var5.llIIIIIIIllIIllIlIllIIIIl;
        float var7 = var5.lIIIllIllIIllIlllIlIIlllI;
        float var8 = var5.IlllllIlIIIlIIlIIllIIlIll;
        this.rawVertices = GLBufferUtil.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2);
        this.displayLists = new HashMap();
        FloatBuffer var9 = FloatBuffer.allocate(48);
        var9.put(GLBufferUtil.lIlIlIlIlIIlIIlIIllIIIIIl((int)var8, (int)var8, var3, var4, (int)var6, (int)var7, 1));
        var9.put(GLBufferUtil.lIlIlIlIlIIlIIlIIllIIIIIl((int)(var8 + var6), 0, var3, var4, (int)var6, (int)var8, 1));
        var9.put(GLBufferUtil.lIlIlIlIlIIlIIlIIllIIIIIl((int)var8, 0, var3, var4, (int)var6, (int)var8, 1));
        var9.put(GLBufferUtil.lIlIlIlIlIIlIIlIIllIIIIIl((int)(var6 + var8), (int)var8, var3, var4, (int)var8, (int)var7, 1));
        var9.put(GLBufferUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0, (int)var8, var3, var4, 1, (int)var7, 1));
        var9.put(GLBufferUtil.lIlIlIlIlIIlIIlIIllIIIIIl((int)(var6 + var8 + var8), (int)var8, var3, var4, (int)var6, (int)var7, 1));
        this.rawTexCoords = var9.array();
    }

    public void updateUVPosition(int var1, int var2) {
        if (this.lastFrame != var1) {
            this.lastFrame = var1 / var2;
            if (!this.displayLists.containsKey(this.lastFrame)) {
                float[] var3 = Arrays.copyOf(this.rawTexCoords, this.rawTexCoords.length);

                for(int var4 = 0; var4 < this.rawTexCoords.length; var4 += 2) {
                    var3[var4 + 1] = this.mapV(var3[var4 + 1], var1, var2);
                }

                this.texCoords = var3;
            }
        }
    }

    public float mapV(float var1, int var2, int var3) {
        return var1 / (float)var3 + Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$floor_float((float)var2 / (float)var3) / (float)var3;
    }

    public void render(int var1, float var2) {
        this.render(Bridge.getInstance().initTessellator(), (var0) -> {
        }, var2);
    }

    public void render(Consumer var1, float var2) {
        this.render(Bridge.getInstance().initTessellator(), var1, var2);
    }

    public void render(TessellatorBridge var1, Consumer var2, float var3) {
        if (!var1.bridge$isDrawing()) {
            if (this.texCoords != null) {
                if (!this.displayLists.containsKey(this.lastFrame)) {
                    int var4 = GL11.glGenLists(1);
                    GL11.glNewList(var4, 4865);
                    var1.bridge$setTranslation(0.0D, 0.0D, 0.0D);
                    if (Bridge.getMinecraftVersion().ordinal() > MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl.ordinal()) {
                        var1.bridge$begin(7, Bridge.IllllllllllIlIIIlllIlllll().bridge$position_tex_normal());
                    } else {
                        var1.bridge$begin(7, true, false);
                    }

                    int var5 = 0;
                    int var6 = 0;

                    for(int var7 = 0; var7 < this.rawVertices.length; var7 += 4) {
                        Vector3f var8 = this.rawVertices[var7];
                        Vector3f var9 = this.rawVertices[var7 + 1];
                        Vector3f var10 = this.rawVertices[var7 + 2];
                        Vector3f var11 = this.rawVertices[var7 + 3];
                        Vector3f var12 = new Vector3f(GLBufferUtil.lIlIlIlIlIIlIIlIIllIIIIIl[var6], GLBufferUtil.lIlIlIlIlIIlIIlIIllIIIIIl[var6 + 1], GLBufferUtil.lIlIlIlIlIIlIIlIIllIIIIIl[var6 + 2]);
                        var1.bridge$pos(var8.getX() * var3, var8.getY() * var3, var8.getZ() * var3).bridge$uv(this.texCoords[var5], this.texCoords[var5 + 1]).bridge$normal(var12.getX(), var12.getY(), var12.getZ()).bridge$endVertex();
                        var1.bridge$pos(var9.getX() * var3, var9.getY() * var3, var9.getZ() * var3).bridge$uv(this.texCoords[var5 + 2], this.texCoords[var5 + 3]).bridge$normal(var12.getX(), var12.getY(), var12.getZ()).bridge$endVertex();
                        var1.bridge$pos(var10.getX() * var3, var10.getY() * var3, var10.getZ() * var3).bridge$uv(this.texCoords[var5 + 4], this.texCoords[var5 + 5]).bridge$normal(var12.getX(), var12.getY(), var12.getZ()).bridge$endVertex();
                        var1.bridge$pos(var11.getX() * var3, var11.getY() * var3, var11.getZ() * var3).bridge$uv(this.texCoords[var5 + 6], this.texCoords[var5 + 7]).bridge$normal(var12.getX(), var12.getY(), var12.getZ()).bridge$endVertex();
                        if (var5 + 2 < this.rawTexCoords.length) {
                            var5 += 8;
                        }

                        var6 += 3;
                    }

                    var1.bridge$end();
                    GL11.glEndList();
                    this.displayLists.put(this.lastFrame, var4);
                } else {
                    GL11.glCallList(this.displayLists.get(this.lastFrame));
                }

            }
        }
    }
}