package mchorse.emoticons.api.animation.model;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemArmorBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.de.lIllIlIIIlIIIIIIIlllIlIll;
import mchorse.emoticons.common.EntityEquipmentSlot;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMesh;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMeshConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorController;

public class AnimatorEmoticonsController extends AnimatorController {
    public static final Map<String, ResourceLocationBridge> ARMOR_TEXTURE_RES_MAP = Maps.newHashMap();
    public ItemStackBridge itemSlot = Bridge.getInstance().initEmptyItemStack();
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
        AnimationMeshConfig animationMeshConfig = this.userConfig.meshes.get("armor_helmet");
        AnimationMeshConfig animationMeshConfig2 = this.userConfig.meshes.get("armor_chest");
        AnimationMeshConfig animationMeshConfig3 = this.userConfig.meshes.get("armor_leggings");
        AnimationMeshConfig animationMeshConfig4 = this.userConfig.meshes.get("armor_feet");
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
            animationMeshConfig.texture = this.getArmorResource(entityLivingBaseBridge, itemStackBridge, entityEquipmentSlot, null);
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
        ItemArmorBridge var5 = (ItemArmorBridge)itemStackBridge.bridge$getItem();
        String var6 = var5.bridge$getArmorMaterial().lIlIlIlIlIIlIIlIIllIIIIIl();
        String var7 = "minecraft";
        int var8 = var6.indexOf(58);
        if (var8 != -1) {
            var7 = var6.substring(0, var8);
            var6 = var6.substring(var8 + 1);
        }
        String var9 = String.format("%s:textures/models/armor/%s_layer_%d%s.png", var7, var6, this.isLegSlot(entityEquipmentSlot) ? 2 : 1, string == null ? "" : String.format("_%s", string));
        ResourceLocationBridge var10 = ARMOR_TEXTURE_RES_MAP.get(var9);
        if (var10 == null) {
            var10 = Bridge.getInstance().initResourceLocation(var9);
            ARMOR_TEXTURE_RES_MAP.put(var9, var10);
        }
        return var10;
    }

    public boolean isLegSlot(EntityEquipmentSlot entityEquipmentSlot) {
        return entityEquipmentSlot == EntityEquipmentSlot.LEGS;
    }
}

