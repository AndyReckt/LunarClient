package com.moonsworth.lunar.client.cosmetic.model;

import com.moonsworth.lunar.bridge.current.MatrixStackEntryBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.OpenGlHelperBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJLoader;
import org.lwjgl.BufferUtils;

import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Model {
    public ModelMesh llIIlIlIIIllIlIlIlIIlIIll;
    public BOBJLoader.CompiledData llIIIlllIIlllIllllIlIllIl;
    public int lllllIllIllIllllIlIllllII = 0xFFFFFF;
    public int lllIIIIIlllIIlIllIIlIIIlI = 9728;
    public boolean lIlIIIIIIlIIIllllIllIIlII = true;
    public boolean llIlIIIllIIlIllIllIllllIl = true;
    public boolean IllIllIIIllIIIlIlIlIIIIll = true;
    public ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public FloatBuffer IlllIIIIIIlllIlIIlllIlIIl;
    public FloatBuffer lIllIlIIIlIIIIIIIlllIlIll;
    public FloatBuffer llIlllIIIllllIIlllIllIIIl;
    public IntBuffer llllIIlIIlIIlIIllIIlIIllI;
    public int IlIlIlllllIlIIlIlIlllIlIl;
    public int llIIIIIIIllIIllIlIllIIIIl;
    public int lIIIllIllIIllIlllIlIIlllI;
    public int IlllllIlIIIlIIlIIllIIlIll;
    public int IIlIllIlllllllIIlIIIllIIl = -1;
    public int lIIlIlllIlIlIIIlllIIlIIII = -1;

    public Model(ModelMesh modelMesh, BOBJLoader.CompiledData compiledData) {
        this.llIIIlllIIlllIllllIlIllIl = compiledData;
        this.llIIlIlIIIllIlIlIlIIlIIll = modelMesh;
        this.llllIIlIIlIIlIIllIIlIIllI();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2) {
        if (this.IIlIllIlllllllIIlIIIllIIl == n) {
            return;
        }
        this.IIlIllIlllllllIIlIIIllIIl = n;
        this.lIIlIlllIlIlIIIlllIIlIIII = n2;
        this.llIlllIIIllllIIlllIllIIIl.clear();
        for (int i = 0; i < this.llIIIlllIIlllIllllIlIllIl.texData.length; i += 2) {
            this.llIlllIIIllllIIlllIllIIIl.put(this.llIIIlllIIlllIllllIlIllIl.texData[i]);
            this.llIlllIIIllllIIlllIllIIIl.put(this.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIIlllIIlllIllllIlIllIl.texData[i + 1], n, n2));
        }
        this.llIlllIIIllllIIlllIllIIIl.flip();
        GL15.glBindBuffer(34962, this.lIIIllIllIIllIlllIlIIlllI);
        GL15.glBufferData(34962, this.llIlllIIIllllIIlllIllIIIl, 35048);
        GL15.glBindBuffer(34962, 0);
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(float f, int n, int n2) {
        return f / (float)n2 + Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$floor_float((float)n / (float)n2) / (float)n2;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        OpenGlHelperBridge openGlHelperBridge = Bridge.lIlIIIIIIlIIIllllIllIIlII();
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        float f = openGlHelperBridge.bridge$lastBrightnessX();
        float f2 = openGlHelperBridge.bridge$lastBrightnessY();
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl != null) {
            Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(this.lIlIlIlIlIIlIIlIIllIIIIIl);
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllIIIIIlllIIlIllIIlIIIlI);
        }
        if (this.lIlIIIIIIlIIIllllIllIIlII && this.llIlIIIllIIlIllIllIllllIl) {
            GL11.glShadeModel(7425);
        }
        if (!this.llIlIIIllIIlIllIllIllllIl) {
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$disableStandardItemLighting();
        }
        if (!this.IllIllIIIllIIIlIlIlIIIIll) {
            Bridge.lIlIIIIIIlIIIllllIllIIlII().bridge$setLightmapTextureCoords(openGlHelperBridge.bridge$lightmapTexUnit(), 240.0f, 240.0f);
        }
        float f3 = (float)(this.lllllIllIllIllllIlIllllII >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(this.lllllIllIllIllllIlIllllII >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(this.lllllIllIllIllllIlIllllII & 0xFF) / 255.0f;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableRescaleNormal();
        GL15.glBindBuffer(34962, this.IlIlIlllllIlIIlIlIlllIlIl);
        GL11.glVertexPointer(4, 5126, 0, 0L);
        GL15.glBindBuffer(34962, this.llIIIIIIIllIIllIlIllIIIIl);
        GL11.glNormalPointer(5126, 0, 0L);
        GL15.glBindBuffer(34962, this.lIIIllIllIIllIlllIlIIlllI);
        GL11.glTexCoordPointer(2, 5126, 0, 0L);
        GL11.glEnableClientState(32884);
        GL11.glEnableClientState(32885);
        GL11.glEnableClientState(32888);
        GL15.glBindBuffer(34963, this.IlllllIlIIIlIIlIIllIIlIll);
        GL11.glDrawElements(4, this.llIIIlllIIlllIllllIlIllIl.indexData.length, 5125, 0L);
        GL15.glBindBuffer(34963, 0);
        GL15.glBindBuffer(34962, 0);
        GL11.glDisableClientState(32884);
        GL11.glDisableClientState(32885);
        GL11.glDisableClientState(32888);
        if (this.lIlIIIIIIlIIIllllIllIIlII && this.llIlIIIllIIlIllIllIllllIl) {
            GL11.glShadeModel(7424);
        }
        if (!this.llIlIIIllIIlIllIllIllllIl) {
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableStandardItemLighting();
        }
        if (!this.IllIllIIIllIIIlIlIlIIIIll) {
            openGlHelperBridge.bridge$setLightmapTextureCoords(openGlHelperBridge.bridge$lightmapTexUnit(), f, f2);
        }
        glStateManagerBridge.bridge$disableRescaleNormal();
        glStateManagerBridge.bridge$blendFunc(770, 771);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(com.moonsworth.lunar.bridge.current.lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackEntryBridge matrixStackEntryBridge, int n) {
//        OpenGlHelperBridge openGlHelperBridge = Bridge.lIlIIIIIIlIIIllllIllIIlII();
//        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
//        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$turnOnLighting();
//        GL11.glEnable((int)2912);
//        glStateManagerBridge.bridge$enableRescaleNormal();
//        openGlHelperBridge.bridge$enableLightMap();
//        glStateManagerBridge.bridge$pushMatrix();
//        glStateManagerBridge.lIlIlIlIlIIlIIlIIllIIIIIl(matrixStackEntryBridge.lIlIlIlIlIIlIIlIIllIIIIIl());
//        GL15.glBindBuffer((int)34962, (int)this.IlIlIlllllIlIIlIlIlllIlIl);
//        GL11.glVertexPointer((int)4, (int)5126, (int)0, (long)0L);
//        GL15.glBindBuffer((int)34962, (int)this.llIIIIIIIllIIllIlIllIIIIl);
//        GL11.glNormalPointer((int)5126, (int)0, (long)0L);
//        GL13.glClientActiveTexture((int)(33984 + openGlHelperBridge.bridge$defaultTexUnit()));
//        GL15.glBindBuffer((int)34962, (int)this.lIIIllIllIIllIlllIlIIlllI);
//        GL11.glTexCoordPointer((int)2, (int)5126, (int)0, (long)0L);
//        glMultiTexCoord2s((int)(33984 + openGlHelperBridge.bridge$lightmapTexUnit()), (short)((short)(n & 0xFF)), (short)((short)(n >> 16 & 0xFF)));
//        GL11.glEnableClientState((int)32884);
//        GL11.glEnableClientState((int)32885);
//        GL11.glEnableClientState((int)32888);
//        GL15.glBindBuffer((int)34963, (int)this.IlllllIlIIIlIIlIIllIIlIll);
//        GL11.glDrawElements((int)4, (int)this.llIIIlllIIlllIllllIlIllIl.indexData.length, (int)5125, (long)0L);
//        GL15.glBindBuffer((int)34963, (int)0);
//        GL15.glBindBuffer((int)34962, (int)0);
//        GL11.glDisableClientState((int)32884);
//        GL11.glDisableClientState((int)32885);
//        GL11.glDisableClientState((int)32888);
//        glStateManagerBridge.bridge$popMatrix();
//        GL11.glDisable((int)2912);
//        openGlHelperBridge.bridge$disableLightMap();
    }

    public void llllIIlIIlIIlIIllIIlIIllI() {
        this.IlllIIIIIIlllIlIIlllIlIIl = BufferUtils.createFloatBuffer(this.llIIIlllIIlllIllllIlIllIl.posData.length);
        this.IlllIIIIIIlllIlIIlllIlIIl.put(this.llIIIlllIIlllIllllIlIllIl.posData).flip();
        this.lIllIlIIIlIIIIIIIlllIlIll = BufferUtils.createFloatBuffer(this.llIIIlllIIlllIllllIlIllIl.normData.length);
        this.lIllIlIIIlIIIIIIIlllIlIll.put(this.llIIIlllIIlllIllllIlIllIl.normData).flip();
        this.llIlllIIIllllIIlllIllIIIl = BufferUtils.createFloatBuffer(this.llIIIlllIIlllIllllIlIllIl.texData.length);
        this.llIlllIIIllllIIlllIllIIIl.put(this.llIIIlllIIlllIllllIlIllIl.texData).flip();
        this.llllIIlIIlIIlIIllIIlIIllI = BufferUtils.createIntBuffer(this.llIIIlllIIlllIllllIlIllIl.indexData.length);
        this.llllIIlIIlIIlIIllIIlIIllI.put(this.llIIIlllIIlllIllllIlIllIl.indexData).flip();
        this.IlIlIlllllIlIIlIlIlllIlIl = GL15.glGenBuffers();
        GL15.glBindBuffer(34962, this.IlIlIlllllIlIIlIlIlllIlIl);
        GL15.glBufferData(34962, this.IlllIIIIIIlllIlIIlllIlIIl, 35048);
        this.llIIIIIIIllIIllIlIllIIIIl = GL15.glGenBuffers();
        GL15.glBindBuffer(34962, this.llIIIIIIIllIIllIlIllIIIIl);
        GL15.glBufferData(34962, this.lIllIlIIIlIIIIIIIlllIlIll, 35044);
        this.lIIIllIllIIllIlllIlIIlllI = GL15.glGenBuffers();
        GL15.glBindBuffer(34962, this.lIIIllIllIIllIlllIlIIlllI);
        GL15.glBufferData(34962, this.llIlllIIIllllIIlllIllIIIl, 35044);
        this.IlllllIlIIIlIIlIIllIIlIll = GL15.glGenBuffers();
        GL15.glBindBuffer(34963, this.IlllllIlIIIlIIlIIllIIlIll);
        GL15.glBufferData(34963, this.llllIIlIIlIIlIIllIIlIIllI, 35044);
        GL15.glBindBuffer(34962, 0);
        GL15.glBindBuffer(34963, 0);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        GL11.glTexParameteri(3553, 10241, n);
        GL11.glTexParameteri(3553, 10240, n);
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return GL11.glGetTexParameteri(3553, 10241);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        GL15.glDeleteBuffers(this.IlIlIlllllIlIIlIlIlllIlIl);
        GL15.glDeleteBuffers(this.llIIIIIIIllIIllIlIllIIIIl);
        GL15.glDeleteBuffers(this.lIIIllIllIIllIlllIlIIlllI);
        GL15.glDeleteBuffers(this.IlllllIlIIIlIIlIIllIIlIll);
        this.IlllIIIIIIlllIlIIlllIlIIl = null;
        this.lIllIlIIIlIIIIIIIlllIlIll = null;
        this.llIlllIIIllllIIlllIllIIIl = null;
        this.llllIIlIIlIIlIIllIIlIIllI = null;
    }

    public void llIlllIIIllllIIlllIllIIIl() {
        Vector4f vector4f = new Vector4f();
        Vector4f vector4f2 = new Vector4f(0.0f, 0.0f, 0.0f, 0.0f);
        Vector3f vector3f = new Vector3f();
        Vector3f vector3f2 = new Vector3f(0.0f, 0.0f, 0.0f);
        float[] fArray = this.llIIIlllIIlllIllllIlIllIl.posData;
        float[] fArray2 = new float[fArray.length];
        float[] fArray3 = this.llIIIlllIIlllIllllIlIllIl.normData;
        float[] fArray4 = new float[fArray3.length];
        int n = fArray2.length / 4;
        for (int i = 0; i < n; ++i) {
            int n2 = 0;
            for (int j = 0; j < 4; ++j) {
                float f = this.llIIIlllIIlllIllllIlIllIl.weightData[i * 4 + j];
                if (!(f > 0.0f)) continue;
                vector4f.set(fArray[i * 4], fArray[i * 4 + 1], fArray[i * 4 + 2], 1.0f);
                vector4f.mul(f);
                vector4f2.add(vector4f);
                vector3f.set(fArray3[i * 3], fArray3[i * 3 + 1], fArray3[i * 3 + 2]);
                vector3f.mul(f);
                vector3f2.add(vector3f);
                ++n2;
            }
            if (n2 == 0) {
                vector3f2.set(fArray3[i * 3], fArray3[i * 3 + 1], fArray3[i * 3 + 2]);
                vector4f2.set(fArray[i * 4], fArray[i * 4 + 1], fArray[i * 4 + 2], 1.0f);
            }
            fArray2[i * 4] = vector4f2.x;
            fArray2[i * 4 + 1] = vector4f2.y;
            fArray2[i * 4 + 2] = vector4f2.z;
            fArray2[i * 4 + 3] = vector4f2.w;
            fArray4[i * 3] = vector3f2.x;
            fArray4[i * 3 + 1] = vector3f2.y;
            fArray4[i * 3 + 2] = vector3f2.z;
            vector4f2.set(0.0f, 0.0f, 0.0f, 0.0f);
            vector3f2.set(0.0f, 0.0f, 0.0f);
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(fArray2);
        this.IlllIIIIIIlllIlIIlllIlIIl(fArray4);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float[] fArray) {
        this.IlllIIIIIIlllIlIIlllIlIIl.clear();
        this.IlllIIIIIIlllIlIIlllIlIIl.put(fArray).flip();
        GL15.glBindBuffer(34962, this.IlIlIlllllIlIIlIlIlllIlIl);
        GL15.glBufferData(34962, this.IlllIIIIIIlllIlIIlllIlIIl, 35048);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float[] fArray) {
        this.lIllIlIIIlIIIIIIIlllIlIll.clear();
        this.lIllIlIIIlIIIIIIIlllIlIll.put(fArray).flip();
        GL15.glBindBuffer(34962, this.llIIIIIIIllIIllIlIllIIIIl);
        GL15.glBufferData(34962, this.lIllIlIIIlIIIIIIIlllIlIll, 35048);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float[] fArray) {
        this.llIlllIIIllllIIlllIllIIIl.clear();
        this.llIlllIIIllllIIlllIllIIIl.put(fArray).flip();
        GL15.glBindBuffer(34962, this.lIIIllIllIIllIlllIlIIlllI);
        GL15.glBufferData(34962, this.llIlllIIIllllIIlllIllIIIl, 35048);
    }
}
