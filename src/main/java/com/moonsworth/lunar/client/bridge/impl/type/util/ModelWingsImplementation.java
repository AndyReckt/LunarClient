package com.moonsworth.lunar.client.bridge.impl.type.util;

import com.moonsworth.lunar.bridge.lunar.SkeletalWings;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ModelWingsImplementation extends ModelBase implements SkeletalWings {
    public ModelRenderer wing;
    public ModelRenderer wingTip;

    public ModelWingsImplementation() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.setTextureOffset("wing.skin", -56, 88);
        this.setTextureOffset("wingtip.skin", -56, 144);
        this.setTextureOffset("wing.bone", 112, 88);
        this.setTextureOffset("wingtip.bone", 112, 136);
        this.wing = new ModelRenderer(this, "wing");
        this.wing.setRotationPoint(-12.0F, 5.0F, 2.0F);
        this.wing.addBox("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8);
        this.wing.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
        this.wingTip = new ModelRenderer(this, "wingtip");
        this.wingTip.setRotationPoint(-56.0F, 0.0F, 0.0F);
        this.wingTip.addBox("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4);
        this.wingTip.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
        this.wing.addChild(this.wingTip);
    }

    public void renderLegacy(float var1, float var2, ResourceLocationBridge var3) {
        Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)var3);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(var1, var1, var1);
        GL11.glRotatef(15.0F, 1.0F, 0.0F, 0.0F);
        GL11.glTranslatef(0.0F, 0.5F, 0.25F);
        float var4 = (float)(System.currentTimeMillis() % 2000L) / 2000.0F * 3.1415927F * 2.0F;

        for(int var5 = 0; var5 < 2; ++var5) {
            GL11.glEnable(2884);
            this.wing.rotateAngleX = -0.125F - (float)Math.cos(var4) * 0.2F;
            this.wing.rotateAngleY = 0.75F;
            this.wing.rotateAngleZ = (float)(Math.sin(var4) + 0.125D) * 0.8F;
            this.wingTip.rotateAngleZ = (float)(Math.sin(var4 + 2.0F) + 0.5D) * 0.75F;
            this.wing.render(var2);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(-1.0D, 1.0D, 1.0D);
            if (var5 == 0) {
                GL11.glCullFace(1028);
            }

            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$shadeModel(7424);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        }

        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        GL11.glCullFace(1029);
        GL11.glDisable(2884);
    }
}