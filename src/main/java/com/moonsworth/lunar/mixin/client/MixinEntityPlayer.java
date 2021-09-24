package com.moonsworth.lunar.mixin.client;

import com.mojang.authlib.GameProfile;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.InventoryPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.PlayerCapabilitiesBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.BlockPosBridge;
import com.moonsworth.lunar.bridge.minecraft.util.FoodStatsBridge;
import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.entity.EntityDeathEvent;
import com.moonsworth.lunar.client.event.type.entity.player.TrySleepEvent;
import mchorse.emoticons.capabilities.cosmetic.Cosmetic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityPlayer.class)
public abstract class MixinEntityPlayer extends EntityLivingBase implements EntityBridge, EntityPlayerBridge {
    @Final
    @Shadow
    private GameProfile gameProfile;
    @Shadow
    public PlayerCapabilities capabilities;
    @Shadow
    public InventoryPlayer inventory;
    @Shadow
    protected int flyToggleTimer;

    @Shadow
    public abstract boolean isSpectator();

    @Shadow
    public abstract ItemStack getCurrentEquippedItem();

    @Shadow
    public abstract FoodStats getFoodStats();

    @Shadow
    public abstract boolean isBlocking();

    @Shadow
    public abstract ItemStack getHeldItem();

    @Shadow
    public abstract void onEnchantmentCritical(Entity var1);

    @Shadow
    public abstract ItemStack getCurrentArmor(int var1);

    @Shadow
    public abstract int getItemInUseCount();

    @Shadow
    public abstract float getBedOrientationInDegrees();

    @Shadow
    public abstract boolean isUsingItem();

    @Shadow public BlockPos playerLocation;

    @Shadow public abstract ItemStack[] getInventory();

    @Shadow public float renderOffsetX;

    @Shadow public float renderOffsetY;

    @Shadow public abstract String getName();

    @Shadow protected FoodStats foodStats;

    @Shadow public abstract void preparePlayerToSpawn();

    @Shadow private int itemInUseCount;

    @Shadow public float renderOffsetZ;

    public MixinEntityPlayer(World var1) {
        super(var1);
    }

    public GameProfile bridge$getGameProfile() {
        return this.gameProfile;
    }

    public PlayerCapabilitiesBridge bridge$getPlayerCapabilities() {
        return (PlayerCapabilitiesBridge) capabilities;
    }

    public boolean bridge$isSpectator() {
        return this.isSpectator();
    }

    public void bridge$addChatMessage(IChatComponentBridge var1) {
        this.addChatMessage((IChatComponent) var1);
    }

    public InventoryPlayerBridge bridge$getInventory() {
        return (InventoryPlayerBridge) this.inventory;
    }

    public ItemStackBridge bridge$getCurrentEquippedItem() {
        return (ItemStackBridge) this.getCurrentEquippedItem();
    }

    public boolean bridge$isSprinting() {
        return this.isSprinting();
    }

    public String bridge$getName() {
        return this.getName();
    }

    public FoodStatsBridge bridge$getFoodStats() {
        return (FoodStatsBridge) this.foodStats;
    }

    public boolean bridge$isBlocking() {
        return this.isBlocking();
    }

    public ItemStackBridge bridge$getHeldItem() {
        return (ItemStackBridge) this.getHeldItem();
    }

    public void bridge$onEnchantmentCritical(EntityBridge var1) {
        this.onEnchantmentCritical((Entity) var1);
    }

    public void bridge$preparePlayerToSpawn() {
        this.preparePlayerToSpawn();
    }

    public ItemStackBridge bridge$getArmor(int var1) {
        return (ItemStackBridge) this.getCurrentArmor(var1);
    }

    public int bridge$getItemInUseCount() {
        return this.itemInUseCount;
    }

    public float bridge$getBedOrientationInDegrees() {
        return getBedOrientationInDegrees();
    }

    @Inject(method = "onUpdate", at = @At("RETURN"))
    public void impl$cosmeticPostUpdate(CallbackInfo var1) {
        Cosmetic.postUpdate(this);
    }

    @Inject(method = "onDeath", at = @At("HEAD"), cancellable = true)
    public void impl$onDeath(DamageSource var1, CallbackInfo var2) {
        EntityDeathEvent var3 = new EntityDeathEvent(this);
        EventBus.getInstance().call(var3);
        if (var3.isCancelled()) {
            var2.cancel();
        }
    }

    public boolean bridge$isUsingItem() {
        return isUsingItem();
    }

    public void bridge$setFlyToggleTimer(int var1) {
        this.flyToggleTimer = var1;
    }

    public void impl$onTrySleep(BlockPos var1, CallbackInfoReturnable<EntityPlayer.EnumStatus> var2) {
        TrySleepEvent event = new TrySleepEvent(this, (BlockPosBridge)var1);
        LunarClient.EVENT_BUS.call(event);
        if (event.IlllIIIIIIlllIlIIlllIlIIl() != null) {
            var2.setReturnValue(EntityPlayer.EnumStatus.values()[event.IlllIIIIIIlllIlIIlllIlIIl().ordinal()]);
        }
    }
}
