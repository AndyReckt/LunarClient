package com.moonsworth.lunar.mixin.client.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.potion.PotionBridge;
import com.moonsworth.lunar.bridge.minecraft.potion.PotionEffectBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.entity.EntityDeathEvent;
import com.moonsworth.lunar.client.event.type.entity.EntityLivingBaseEvent;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Mixin(EntityLivingBase.class)
public abstract class MixinEntityLivingBasez extends Entity implements EntityLivingBaseBridge {
    @Shadow
    private int lastAttackerTime;
    @Shadow
    private EntityLivingBase lastAttacker;
    @Shadow
    public int hurtTime;
    @Shadow
    public int deathTime;
    @Shadow
    public float renderYawOffset;
    @Shadow
    public float rotationYawHead;
    @Shadow
    public float prevRotationYawHead;
    @Shadow
    public float prevRenderYawOffset;
    @Shadow
    public float moveForward;

    public MixinEntityLivingBasez(World worldIn) {
        super(worldIn);
    }

    @Shadow
    public abstract boolean isPotionActive(Potion var1);

    @Shadow
    public abstract Collection<PotionEffect> getActivePotionEffects();

    @Shadow
    public abstract boolean isOnLadder();

    @Shadow
    public abstract ItemStack getEquipmentInSlot(int var1);

    @Shadow
    public abstract float getHealth();

    @Shadow
    public abstract boolean isPlayerSleeping();

    @Shadow
    public abstract ItemStack getHeldItem();

    @Shadow
    public abstract PotionEffect getActivePotionEffect(Potion var1);

    @Shadow protected int recentlyHit;

    public int bridge$getLastAttackerTime() {
        return this.lastAttackerTime;
    }

    public int bridge$getHurtTime() {
        return this.hurtTime;
    }

    public int bridge$getDeathTime() {
        return this.deathTime;
    }

    public Optional<EntityLivingBase> bridge$getLastAttacker() {
        return Optional.ofNullable(this.lastAttacker);
    }

    public void impl$swingItem(CallbackInfo var1) {
        if ((EntityLivingBaseBridge) this instanceof EntityPlayer) {
            Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((EntityPlayerBridge)this, false);
        }
    }

    public boolean a() {
        return this.canAttackWithItem();
    }

    public boolean bridge$isPotionActive(PotionBridge var1) {
        return this.isPotionActive((Potion) var1);
    }

    public List bridge$getActivePotionEffects() {
        return Collections.singletonList(this.getActivePotionEffects());
    }

    public boolean bridge$isOnLadder() {
        return this.isOnLadder();
    }

    public boolean bridge$isInWater() {
        return this.isInWater();
    }

    public float bridge$getRenderYawOffset() {
        return this.renderYawOffset;
    }

    public void bridge$setRenderYawOffset(float var1) {
        this.renderYawOffset = var1;
    }

    public float bridge$getRotationYawHead() {
        return this.rotationYawHead;
    }

    public void bridge$setRotationYawHead(float var1) {
        this.rotationYawHead = var1;
    }

    public float bridge$getPrevRotationYawHead() {
        return this.prevRotationYawHead;
    }

    public void bridge$setPrevRotationYawHead(float var1) {
        this.prevRotationYawHead = var1;
    }

    public float bridge$getPreviousRotationYawOffset() {
        return this.prevRenderYawOffset;
    }

    public ItemStackBridge bridge$getEquipmentInSlot(int var1) {
        return (ItemStackBridge) this.getEquipmentInSlot(var1);
    }

    public float bridge$getHealth() {
        return this.getHealth();
    }

    public boolean bridge$isPlayerSleeping() {
        return this.isPlayerSleeping();
    }

    public float bridge$getMoveForward() {
        return this.moveForward;
    }

    public ItemStackBridge bridge$getHeldItem() {
        return (ItemStackBridge) this.getHeldItem();
    }

    public boolean bridge$shouldAlwaysRenderNametag() {
        return this.getAlwaysRenderNameTag();
    }

    public void bridge$setAlwaysRenderNameTag(boolean var1) {
        this.setAlwaysRenderNameTag(var1);
    }

    public float bridge$getPrevRenderYawOffset() {
        return this.prevRenderYawOffset;
    }

    public String bridge$getDisplayName() {
        return this.getDisplayName().getFormattedText();
    }

    public void impl$onDeath(DamageSource var1, CallbackInfo var2) {
        final EntityDeathEvent entityDeathEvent = new EntityDeathEvent(this);
        EventBus.getInstance().call(entityDeathEvent);
        if (entityDeathEvent.isCancelled()) {
            var2.cancel();
        }
    }

    public void impl$onUpdate(CallbackInfo var1) {
        EventBus.getInstance().call(new EntityLivingBaseEvent.UpdateEvent(this));
    }

    public PotionEffectBridge bridge$getActivePotionEffect(PotionBridge var1) {
        return (PotionEffectBridge) this.getActivePotionEffect((Potion) var1);
    }
}