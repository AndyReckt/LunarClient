/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  lunar.G.EntityBridge
 *  lunar.G.EntityLivingBaseBridge
 *  lunar.Q.ItemArmorBridge
 *  lunar.Q.ItemStackBridge
 *  lunar.a.Bridge
 *  lunar.af.ResourceLocationBridge
 *  lunar.c.MatrixStackBridge
 *  lunar.de.lIllIlIIIlIIIIIIIlllIlIll
 */
package mchorse.emoticons.api.animation.model;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import lunar.G.EntityBridge;
import lunar.G.EntityLivingBaseBridge;
import lunar.Q.ItemArmorBridge;
import lunar.Q.ItemStackBridge;
import lunar.a.Bridge;
import lunar.af.ResourceLocationBridge;
import lunar.c.MatrixStackBridge;
import lunar.de.lIllIlIIIlIIIIIIIlllIlIll;
import mchorse.emoticons.common.EntityEquipmentSlot;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMesh;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMeshConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorController;

public class AnimatorEmoticonsController
extends AnimatorController {
    public static final Map ARMOR_TEXTURE_RES_MAP = Maps.newHashMap();
    public ItemStackBridge itemSlot = Bridge.llIlllIIIllllIIlllIllIIIl().initEmptyItemStack();
    public float itemSlotScale = 0.0f;

    public AnimatorEmoticonsController(String string) {
        super(string);
    }

    @Override
    public void renderAnimation(EntityLivingBaseBridge entityLivingBaseBridge, AnimationMesh animationMesh, float f, float f2) {
        this.updateArmor(entityLivingBaseBridge);
        super.renderAnimation(entityLivingBaseBridge, animationMesh, f, f2);
    }

    @Override
    public List renderModern(EntityLivingBaseBridge entityLivingBaseBridge, lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackBridge matrixStackBridge, double d, double d2, double d3, float f, int n) {
        this.updateArmor(entityLivingBaseBridge);
        return super.renderModern(entityLivingBaseBridge, lIllIlIIIlIIIIIIIlllIlIll2, matrixStackBridge, d, d2, d3, f, n);
    }

    public void updateArmor(EntityLivingBaseBridge entityLivingBaseBridge) {
        AnimationMeshConfig animationMeshConfig = (AnimationMeshConfig)this.userConfig.meshes.get("armor_helmet");
        AnimationMeshConfig animationMeshConfig2 = (AnimationMeshConfig)this.userConfig.meshes.get("armor_chest");
        AnimationMeshConfig animationMeshConfig3 = (AnimationMeshConfig)this.userConfig.meshes.get("armor_leggings");
        AnimationMeshConfig animationMeshConfig4 = (AnimationMeshConfig)this.userConfig.meshes.get("armor_feet");
        if (animationMeshConfig != null) {
            this.updateArmorSlot(animationMeshConfig, entityLivingBaseBridge, EntityEquipmentSlot.HEAD);
        }
        if (animationMeshConfig2 != null) {
            this.updateArmorSlot(animationMeshConfig2, entityLivingBaseBridge, EntityEquipmentSlot.CHEST);
        }
        if (animationMeshConfig3 != null) {
            this.updateArmorSlot(animationMeshConfig3, entityLivingBaseBridge, EntityEquipmentSlot.LEGS);
        }
        if (animationMeshConfig4 != null) {
            this.updateArmorSlot(animationMeshConfig4, entityLivingBaseBridge, EntityEquipmentSlot.FEET);
        }
    }

    public void updateArmorSlot(AnimationMeshConfig animationMeshConfig, EntityLivingBaseBridge entityLivingBaseBridge, EntityEquipmentSlot entityEquipmentSlot) {
        ItemStackBridge itemStackBridge = entityLivingBaseBridge.bridge$getEquipmentInSlot(entityEquipmentSlot.ordinal());
        if (itemStackBridge != null && itemStackBridge.bridge$getItem() instanceof ItemArmorBridge) {
            ItemArmorBridge itemArmorBridge = (ItemArmorBridge)itemStackBridge.bridge$getItem();
            animationMeshConfig.visible = true;
            animationMeshConfig.texture = this.getArmorResource((EntityBridge)entityLivingBaseBridge, itemStackBridge, entityEquipmentSlot, null);
            animationMeshConfig.color = 10511680;
            if (itemArmorBridge.bridge$hasColor(itemStackBridge)) {
                animationMeshConfig.color = itemArmorBridge.bridge$getColor(itemStackBridge);
            }
        } else {
            animationMeshConfig.visible = false;
            animationMeshConfig.color = -1;
        }
    }

    public ResourceLocationBridge getArmorResource(EntityBridge entityBridge, ItemStackBridge itemStackBridge, EntityEquipmentSlot entityEquipmentSlot, String string) {
        ItemArmorBridge itemArmorBridge = (ItemArmorBridge)itemStackBridge.bridge$getItem();
        String string2 = itemArmorBridge.bridge$getArmorMaterial().lIlIlIlIlIIlIIlIIllIIIIIl();
        String string3 = "minecraft";
        int n = string2.indexOf(58);
        if (n != -1) {
            string3 = string2.substring(0, n);
            string2 = string2.substring(n + 1);
        }
        Object[] arrobject = new Object[4];
        arrobject[0] = string3;
        arrobject[1] = string2;
        arrobject[2] = this.isLegSlot(entityEquipmentSlot) ? 2 : 1;
        arrobject[3] = string == null ? "" : String.format("_%s", string);
        String string4 = String.format("%s:textures/models/armor/%s_layer_%d%s.png", arrobject);
        ResourceLocationBridge resourceLocationBridge = (ResourceLocationBridge)ARMOR_TEXTURE_RES_MAP.get(string4);
        if (resourceLocationBridge == null) {
            resourceLocationBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation(string4);
            ARMOR_TEXTURE_RES_MAP.put(string4, resourceLocationBridge);
        }
        return resourceLocationBridge;
    }

    public boolean isLegSlot(EntityEquipmentSlot entityEquipmentSlot) {
        return entityEquipmentSlot == EntityEquipmentSlot.LEGS;
    }
}

