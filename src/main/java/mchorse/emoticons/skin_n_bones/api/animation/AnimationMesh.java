/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Matrix4f
 *  javax.vecmath.Tuple3f
 *  javax.vecmath.Tuple4f
 *  javax.vecmath.Vector3f
 *  javax.vecmath.Vector4f
 *  lunar.R.RenderUtilBridge
 *  lunar.a.Bridge
 *  lunar.af.ResourceLocationBridge
 *  lunar.c.MatrixStackEntryBridge
 *  lunar.c.lIllIlIIIlIIIIIIIlllIlIll
 *  lunar.dc.ColorUtil
 *  lunar.h.MinecraftBridge
 *  lunar.q.GlStateManagerBridge
 *  lunar.q.OpenGlHelperBridge
 *  lunar.y.TextureManagerBridge
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL15
 */
package mchorse.emoticons.skin_n_bones.api.animation;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.vecmath.Matrix4f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Tuple4f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

import com.moonsworth.lunar.bridge.current.MatrixStackEntryBridge;
import com.moonsworth.lunar.bridge.current.lIllIlIIIlIIIIIIIlllIlIll;
import com.moonsworth.lunar.bridge.lunar.RenderUtilBridge;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.OpenGlHelperBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.util.ColorUtil;
import mchorse.emoticons.skin_n_bones.api.animation.Animation;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMeshConfig;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJLoader;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

public class AnimationMesh {
    public Animation owner;
    public ResourceLocationBridge texture;
    public String name;
    public BOBJLoader.CompiledData data;
    public BOBJArmature armature;
    public FloatBuffer vertices;
    public FloatBuffer normals;
    public FloatBuffer textcoords;
    public IntBuffer indices;
    public int vertexBuffer;
    public int normalBuffer;
    public int texcoordBuffer;
    public int indexBuffer;
    public float[] currentVertices;
    public float[] currentNormals;

    public AnimationMesh(Animation animation, String string, BOBJLoader.CompiledData compiledData) {
        this.owner = animation;
        this.name = string;
        this.data = compiledData;
        this.armature = this.data.mesh.armature;
        this.armature.initArmature();
        this.initBuffers();
    }

    public void initBuffers() {
        this.vertices = BufferUtils.createFloatBuffer((int)this.data.posData.length);
        this.vertices.put(this.data.posData).flip();
        this.normals = BufferUtils.createFloatBuffer((int)this.data.normData.length);
        this.normals.put(this.data.normData).flip();
        this.textcoords = BufferUtils.createFloatBuffer((int)this.data.texData.length);
        this.textcoords.put(this.data.texData).flip();
        this.indices = BufferUtils.createIntBuffer((int)this.data.indexData.length);
        this.indices.put(this.data.indexData).flip();
        this.vertexBuffer = GL15.glGenBuffers();
        GL15.glBindBuffer((int)34962, (int)this.vertexBuffer);
        GL15.glBufferData((int)34962, (FloatBuffer)this.vertices, (int)35048);
        this.normalBuffer = GL15.glGenBuffers();
        GL15.glBindBuffer((int)34962, (int)this.normalBuffer);
        GL15.glBufferData((int)34962, (FloatBuffer)this.normals, (int)35044);
        this.texcoordBuffer = GL15.glGenBuffers();
        GL15.glBindBuffer((int)34962, (int)this.texcoordBuffer);
        GL15.glBufferData((int)34962, (FloatBuffer)this.textcoords, (int)35044);
        this.indexBuffer = GL15.glGenBuffers();
        GL15.glBindBuffer((int)34963, (int)this.indexBuffer);
        GL15.glBufferData((int)34963, (IntBuffer)this.indices, (int)35044);
        GL15.glBindBuffer((int)34962, (int)0);
        GL15.glBindBuffer((int)34963, (int)0);
    }

    public void setFiltering(int n) {
        GL11.glTexParameteri((int)3553, (int)10241, (int)n);
        GL11.glTexParameteri((int)3553, (int)10240, (int)n);
    }

    public int getFiltering() {
        return GL11.glGetTexParameteri((int)3553, (int)10241);
    }

    public void delete() {
        GL15.glDeleteBuffers((int)this.vertexBuffer);
        GL15.glDeleteBuffers((int)this.normalBuffer);
        GL15.glDeleteBuffers((int)this.texcoordBuffer);
        GL15.glDeleteBuffers((int)this.indexBuffer);
        this.vertices = null;
        this.normals = null;
        this.textcoords = null;
        this.indices = null;
    }

    public void updateMesh(boolean bl) {
        Vector4f vector4f = new Vector4f();
        Vector4f vector4f2 = new Vector4f(0.0f, 0.0f, 0.0f, 0.0f);
        Vector3f vector3f = new Vector3f();
        Vector3f vector3f2 = new Vector3f(0.0f, 0.0f, 0.0f);
        float[] arrf = this.data.posData;
        float[] arrf2 = new float[arrf.length];
        float[] arrf3 = this.data.normData;
        float[] arrf4 = new float[arrf3.length];
        Matrix4f[] arrmatrix4f = this.armature.matrices;
        int n = arrf2.length / 4;
        for (int i = 0; i < n; ++i) {
            int n2 = 0;
            for (int j = 0; j < 4; ++j) {
                float f = this.data.weightData[i * 4 + j];
                if (!(f > 0.0f)) continue;
                int n3 = this.data.boneIndexData[i * 4 + j];
                vector4f.set(arrf[i * 4], arrf[i * 4 + 1], arrf[i * 4 + 2], 1.0f);
                arrmatrix4f[n3].transform((Tuple4f)vector4f);
                vector4f.scale(f);
                vector4f2.add((Tuple4f)vector4f);
                vector3f.set(arrf3[i * 3], arrf3[i * 3 + 1], arrf3[i * 3 + 2]);
                arrmatrix4f[n3].transform(vector3f);
                vector3f.scale(f);
                vector3f2.add((Tuple3f)vector3f);
                ++n2;
            }
            if (n2 == 0) {
                vector3f2.set(arrf3[i * 3], arrf3[i * 3 + 1], arrf3[i * 3 + 2]);
                vector4f2.set(arrf[i * 4], arrf[i * 4 + 1], arrf[i * 4 + 2], 1.0f);
            }
            arrf2[i * 4] = vector4f2.x;
            arrf2[i * 4 + 1] = vector4f2.y;
            arrf2[i * 4 + 2] = vector4f2.z;
            arrf2[i * 4 + 3] = vector4f2.w;
            arrf4[i * 3] = vector3f2.x;
            arrf4[i * 3 + 1] = vector3f2.y;
            arrf4[i * 3 + 2] = vector3f2.z;
            vector4f2.set(0.0f, 0.0f, 0.0f, 0.0f);
            vector3f2.set(0.0f, 0.0f, 0.0f);
        }
        if (bl) {
            this.currentNormals = arrf4;
            this.currentVertices = arrf2;
        } else {
            this.updateVertices(arrf2);
            this.updateNormals(arrf4);
        }
    }

    public void updateVertices(float[] arrf) {
        this.vertices.clear();
        this.vertices.put(arrf).flip();
        GL15.glBindBuffer((int)34962, (int)this.vertexBuffer);
        GL15.glBufferData((int)34962, (FloatBuffer)this.vertices, (int)35048);
    }

    public void updateNormals(float[] arrf) {
        this.normals.clear();
        this.normals.put(arrf).flip();
        GL15.glBindBuffer((int)34962, (int)this.normalBuffer);
        GL15.glBufferData((int)34962, (FloatBuffer)this.normals, (int)35048);
    }

    public void render(MinecraftBridge minecraftBridge, AnimationMeshConfig animationMeshConfig, lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackEntryBridge matrixStackEntryBridge, int n) {
        if (animationMeshConfig != null && !animationMeshConfig.visible) {
            return;
        }
        if (this.currentVertices == null) {
            this.currentVertices = this.data.posData;
        }
        if (this.currentNormals == null) {
            this.currentNormals = this.data.normData;
        }
        float[] arrf = this.currentVertices;
        float[] arrf2 = this.currentNormals;
        int n2 = animationMeshConfig != null ? animationMeshConfig.color : 0xFFFFFF;
        ResourceLocationBridge resourceLocationBridge = this.getTexture(animationMeshConfig);
        if (resourceLocationBridge != null && !resourceLocationBridge.bridge$getPath().contains("leather")) {
            n2 = 0xFFFFFF;
        }
        int n3 = ColorUtil.IlllIIIIIIlllIlIIlllIlIIl((int)n2);
        int n4 = ColorUtil.llIlllIIIllllIIlllIllIIIl((int)n2);
        int n5 = ColorUtil.IlIlIlllllIlIIlIlIlllIlIl((int)n2);
        for (int i = 0; i < arrf.length / 4; ++i) {
            float f = arrf[i * 4];
            float f2 = arrf[i * 4 + 1];
            float f3 = arrf[i * 4 + 2];
            float f4 = arrf[i * 4 + 3];
            float f5 = arrf2[i * 3];
            float f6 = arrf2[i * 3 + 1];
            float f7 = arrf2[i * 3 + 2];
            lIllIlIIIlIIIIIIIlllIlIll2.lIlIlIlIlIIlIIlIIllIIIIIl(matrixStackEntryBridge.lIlIlIlIlIIlIIlIIllIIIIIl(), f / f4, f2 / f4, f3 / f4).lIlIlIlIlIIlIIlIIllIIIIIl(matrixStackEntryBridge.IlllIIIIIIlllIlIIlllIlIIl(), f5, f6, f7).lIlIlIlIlIIlIIlIIllIIIIIl(n3, n4, n5, 255).lIlIlIlIlIIlIIlIIllIIIIIl(this.data.texData[i * 2], this.data.texData[i * 2 + 1]).IlllIIIIIIlllIlIIlllIlIIl(n & 0xFF, n >> 16 & 0xFF).lIlIlIlIlIIlIIlIIllIIIIIl();
        }
    }

    public void render(MinecraftBridge minecraftBridge, AnimationMeshConfig animationMeshConfig) {
        int n;
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        OpenGlHelperBridge openGlHelperBridge = Bridge.lIlIIIIIIlIIIllllIllIIlII();
        TextureManagerBridge textureManagerBridge = Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getTextureManager();
        RenderUtilBridge renderUtilBridge = Bridge.IlllllIlIIIlIIlIIllIIlIll();
        if (animationMeshConfig != null && !animationMeshConfig.visible) {
            return;
        }
        ResourceLocationBridge resourceLocationBridge = this.getTexture(animationMeshConfig);
        boolean bl = animationMeshConfig != null && animationMeshConfig.smooth;
        boolean bl2 = animationMeshConfig != null && animationMeshConfig.normals;
        boolean bl3 = animationMeshConfig == null || animationMeshConfig.lighting;
        float f = openGlHelperBridge.bridge$lastBrightnessY();
        float f2 = openGlHelperBridge.bridge$lastBrightnessY();
        if (resourceLocationBridge != null) {
            textureManagerBridge.bridge$bindTexture(resourceLocationBridge);
            if (animationMeshConfig != null) {
                this.setFiltering(animationMeshConfig.filtering);
            }
        }
        if (bl && bl2) {
            GL11.glShadeModel((int)7425);
        }
        if (!bl2) {
            renderUtilBridge.bridge$disableStandardItemLighting();
        }
        if (!bl3) {
            openGlHelperBridge.bridge$setLightmapTextureCoords(openGlHelperBridge.bridge$lightmapTexUnit(), 240.0f, 240.0f);
        }
        int n2 = n = animationMeshConfig != null ? animationMeshConfig.color : 0xFFFFFF;
        if (resourceLocationBridge != null && !resourceLocationBridge.bridge$getPath().contains("leather")) {
            n = 0xFFFFFF;
        }
        float f3 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n & 0xFF) / 255.0f;
        glStateManagerBridge.bridge$color(f3, f4, f5, 1.0f);
        glStateManagerBridge.bridge$disableBlend();
        glStateManagerBridge.bridge$enableRescaleNormal();
        GL15.glBindBuffer((int)34962, (int)this.vertexBuffer);
        GL11.glVertexPointer((int)4, (int)5126, (int)0, (long)0L);
        GL15.glBindBuffer((int)34962, (int)this.normalBuffer);
        GL11.glNormalPointer((int)5126, (int)0, (long)0L);
        GL15.glBindBuffer((int)34962, (int)this.texcoordBuffer);
        GL11.glTexCoordPointer((int)2, (int)5126, (int)0, (long)0L);
        GL11.glEnableClientState((int)32884);
        GL11.glEnableClientState((int)32885);
        GL11.glEnableClientState((int)32888);
        GL15.glBindBuffer((int)34963, (int)this.indexBuffer);
        GL11.glDrawElements((int)4, (int)this.data.indexData.length, (int)5125, (long)0L);
        GL15.glBindBuffer((int)34963, (int)0);
        GL15.glBindBuffer((int)34962, (int)0);
        GL11.glDisableClientState((int)32884);
        GL11.glDisableClientState((int)32885);
        GL11.glDisableClientState((int)32888);
        if (bl && bl2) {
            GL11.glShadeModel((int)7424);
        }
        if (!bl2) {
            renderUtilBridge.bridge$enableStandardItemLighting();
        }
        if (!bl3) {
            openGlHelperBridge.bridge$setLightmapTextureCoords(openGlHelperBridge.bridge$lightmapTexUnit(), f, f2);
        }
        glStateManagerBridge.bridge$disableRescaleNormal();
        glStateManagerBridge.bridge$enableBlend();
        glStateManagerBridge.bridge$blendFunc(770, 771);
        if (minecraftBridge.bridge$getGameSettings().bridge$showDebugInfo() && !minecraftBridge.bridge$getGameSettings().bridge$isHideGui()) {
            glStateManagerBridge.bridge$disableLighting();
            glStateManagerBridge.bridge$disableDepth();
            glStateManagerBridge.bridge$disableTexture2D();
            for (BOBJBone bOBJBone : this.data.mesh.armature.orderedBones) {
                Vector4f vector4f = new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);
                Vector4f vector4f2 = new Vector4f(0.0f, bOBJBone.length, 0.0f, 1.0f);
                Vector4f vector4f3 = new Vector4f(0.1f, 0.0f, 0.0f, 1.0f);
                Vector4f vector4f4 = new Vector4f(0.0f, 0.1f, 0.0f, 1.0f);
                Vector4f vector4f5 = new Vector4f(0.0f, 0.0f, 0.1f, 1.0f);
                Matrix4f matrix4f = bOBJBone.mat;
                matrix4f.transform((Tuple4f)vector4f);
                matrix4f.transform((Tuple4f)vector4f2);
                matrix4f.transform((Tuple4f)vector4f3);
                matrix4f.transform((Tuple4f)vector4f4);
                matrix4f.transform((Tuple4f)vector4f5);
                GL11.glPointSize((float)5.0f);
                GL11.glBegin((int)0);
                glStateManagerBridge.bridge$color(1.0f, 1.0f, 1.0f);
                GL11.glVertex3f((float)vector4f.x, (float)vector4f.y, (float)vector4f.z);
                GL11.glEnd();
                GL11.glLineWidth((float)1.0f);
                GL11.glBegin((int)1);
                glStateManagerBridge.bridge$color(0.9f, 0.9f, 0.9f);
                GL11.glVertex3f((float)vector4f.x, (float)vector4f.y, (float)vector4f.z);
                GL11.glVertex3f((float)vector4f2.x, (float)vector4f2.y, (float)vector4f2.z);
                GL11.glEnd();
                GL11.glLineWidth((float)2.0f);
                GL11.glBegin((int)1);
                glStateManagerBridge.bridge$color(1.0f, 0.0f, 0.0f);
                GL11.glVertex3f((float)vector4f.x, (float)vector4f.y, (float)vector4f.z);
                GL11.glVertex3f((float)vector4f3.x, (float)vector4f3.y, (float)vector4f3.z);
                GL11.glEnd();
                GL11.glBegin((int)1);
                glStateManagerBridge.bridge$color(0.0f, 1.0f, 0.0f);
                GL11.glVertex3f((float)vector4f.x, (float)vector4f.y, (float)vector4f.z);
                GL11.glVertex3f((float)vector4f4.x, (float)vector4f4.y, (float)vector4f4.z);
                GL11.glEnd();
                GL11.glBegin((int)1);
                glStateManagerBridge.bridge$color(0.0f, 0.0f, 1.0f);
                GL11.glVertex3f((float)vector4f.x, (float)vector4f.y, (float)vector4f.z);
                GL11.glVertex3f((float)vector4f5.x, (float)vector4f5.y, (float)vector4f5.z);
                GL11.glEnd();
            }
            glStateManagerBridge.bridge$color(1.0f, 1.0f, 1.0f);
            GL11.glLineWidth((float)1.0f);
            glStateManagerBridge.bridge$enableDepth();
            glStateManagerBridge.bridge$enableLighting();
            glStateManagerBridge.bridge$enableTexture2D();
        }
    }

    public ResourceLocationBridge getTexture(AnimationMeshConfig animationMeshConfig) {
        if (animationMeshConfig == null) {
            return this.texture;
        }
        return animationMeshConfig.texture == null ? this.texture : animationMeshConfig.texture;
    }
}

