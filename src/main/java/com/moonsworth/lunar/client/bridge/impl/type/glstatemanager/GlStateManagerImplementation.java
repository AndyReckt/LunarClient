package com.moonsworth.lunar.client.bridge.impl.type.glstatemanager;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class GlStateManagerImplementation implements GlStateManagerBridge {
    public void bridge$pushMatrix() {
        GlStateManager.pushMatrix();
    }

    public void bridge$popMatrix() {
        GlStateManager.popMatrix();
    }

    public void bridge$scale(double var1, double var3, double var5) {
        GlStateManager.scale(var1, var3, var5);
    }

    public void bridge$bindTexture(int var1) {
        GlStateManager.bindTexture(var1);
    }

    public void bridge$color(float var1, float var2, float var3, float var4) {
        GlStateManager.color(var1, var2, var3, var4);
    }

    public void bridge$color(float var1, float var2, float var3) {
        GlStateManager.color(var1, var2, var3, 1.0f);
    }

    public void bridge$enableBlend() {
        GlStateManager.enableBlend();
    }

    public void bridge$enableTexture2D() {
        GlStateManager.enableTexture2D();
    }

    public void bridge$disableBlend() {
        GlStateManager.disableBlend();
    }

    public void bridge$disableTexture2D() {
        GlStateManager.disableTexture2D();
    }

    public void bridge$blendFunc(int var1, int var2) {
        GlStateManager.blendFunc(var1, var2);
    }

    public void bridge$disableAlpha() {
        GlStateManager.disableAlpha();
    }

    public void bridge$alphaFunc(int var1, float var2) {
        GlStateManager.alphaFunc(var1, var2);
    }

    public void bridge$tryBlendFuncSeparate(int var1, int var2, int var3, int var4) {
        GlStateManager.tryBlendFuncSeparate(var1, var2, var3, var4);
    }

    public void bridge$shadeModel(int var1) {
        GlStateManager.shadeModel(var1);
    }

    public void bridge$enableAlpha() {
        GlStateManager.enableAlpha();
    }

    public void bridge$translate(float var1, float var2, float var3) {
        GlStateManager.translate(var1, var2, var3);
    }

    public void bridge$rotate(float var1, float var2, float var3, float var4) {
        GlStateManager.rotate(var1, var2, var3, var4);
    }

    public void bridge$depthMask(boolean var1) {
        GlStateManager.depthMask(var1);
    }

    public void bridge$depthFunc(int var1) {
        GlStateManager.depthFunc(var1);
    }

    public void bridge$disableLighting() {
        GlStateManager.disableLighting();
    }

    public void bridge$enableLighting() {
        GlStateManager.enableLighting();
    }

    public void bridge$matrixMode(int var1) {
        GlStateManager.matrixMode(var1);
    }

    public void bridge$disableDepth() {
        GlStateManager.disableDepth();
    }

    public void bridge$enableDepth() {
        GlStateManager.enableDepth();
    }

    public void bridge$enableRescaleNormal() {
        GlStateManager.enableRescaleNormal();
    }

    public void bridge$disableRescaleNormal() {
        GlStateManager.disableRescaleNormal();
    }

    public void bridge$enableCull() {
        GlStateManager.enableCull();
    }

    public void bridge$disableCull() {
        GlStateManager.disableCull();
    }

    public void bridge$getFloat(int var1, FloatBuffer var2) {
        GL11.glGetFloat(var1, var2);
    }

    public void bridge$glGetInteger(int var1, IntBuffer var2) {
        GL11.glGetInteger(var1, var2);
    }

    public void bridge$callList(int var1) {
        GL11.glCallList(var1);
    }

    public void bridge$deleteLists(int var1, int var2) {
        GL11.glDeleteLists(var1, var2);
    }

    public void bridge$enableColorMaterial() {
        GlStateManager.enableColorMaterial();
    }

    public void bridge$setActiveTexture(int var1) {
        GlStateManager.setActiveTexture(var1);
    }

    public void bridge$enablePolygonOffset() {
        GlStateManager.enablePolygonOffset();
    }

    public void bridge$doPolygonOffset(float var1, float var2) {
        GlStateManager.doPolygonOffset(var1, var2);
    }

    public void bridge$disablePolygonOffset() {
        GlStateManager.disablePolygonOffset();
    }

    public void bridge$multMatrix(FloatBuffer var1) {
        GL11.glMultMatrix(var1);
    }

    public void bridge$glLineWidth(float var1) {
        GL11.glLineWidth(var1);
    }
}