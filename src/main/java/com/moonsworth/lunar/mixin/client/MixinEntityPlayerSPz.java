package com.moonsworth.lunar.mixin.client;

import com.mojang.authlib.GameProfile;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.bridge.minecraft.client.network.NetHandlerPlayClientBridge;
import com.moonsworth.lunar.bridge.minecraft.util.MovementInputBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.entity.EntityCriticalStrikeEvent;
import com.moonsworth.lunar.client.event.type.entity.EntityEnchantCriticalStrike;
import com.moonsworth.lunar.client.event.type.entity.EntityPlayerSPUpdateEvent;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovementInput;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(EntityPlayerSP.class)
public abstract class MixinEntityPlayerSPz extends AbstractClientPlayer implements EntityPlayerSPBridge {

    @Final
    @Shadow
    public NetHandlerPlayClient sendQueue;
    @Shadow
    protected int sprintToggleTimer;
    @Shadow
    private int horseJumpPowerCounter;
    @Shadow
    private float horseJumpPower;
    @Shadow
    public MovementInput movementInput;
    @Shadow
    public int sprintingTicksLeft;
    @Shadow
    public float prevTimeInPortal;
    @Shadow
    public float timeInPortal;

    @Shadow
    public abstract void onCriticalHit(Entity var1);

    @Shadow
    public abstract void setSprinting(boolean var1);

    @Shadow
    protected abstract boolean pushOutOfBlocks(double var1, double var3, double var5);

    @Shadow
    public abstract void sendPlayerAbilities();

    @Shadow
    public abstract boolean isRidingHorse();

    @Shadow
    public abstract String getClientBrand();

    @Shadow
    public float renderArmPitch;

    public MixinEntityPlayerSPz(World var1, GameProfile var2) {
        super(var1, var2);
    }

    public void event$entityLivingHurt(DamageSource var1, float var2, CallbackInfoReturnable var3) {
    }

    @Inject(method = "damageEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;setHealth(F)V", shift = At.Shift.BEFORE))
    public void impl$stopAnimatingOnDamage(DamageSource var1, float var2, CallbackInfo var3) {
        if (var2 > 0.0F) {
            Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(this, false);
        }
    }


    public void event$criticalStrike(Entity var1, CallbackInfo var2) {
        EntityCriticalStrikeEvent var3 = new EntityCriticalStrikeEvent((EntityBridge) var1);
        EventBus.getInstance().call(var3);
        if (var3.isCancelled()) {
            var2.cancel();
        }
    }

    public void event$enchantCriticalStrike(Entity var1, CallbackInfo var2) {
        EntityEnchantCriticalStrike event = new EntityEnchantCriticalStrike((EntityBridge) var1);
        EventBus.getInstance().call(event);
        if (event.isCancelled()) {
            var2.cancel();
        }
    }

    public void event$livingUpdate(CallbackInfo var1) {
        EntityPlayerSPUpdateEvent var2 = new EntityPlayerSPUpdateEvent(super::onLivingUpdate, this, this.sprintToggleTimer, this.inPortal, this.flyToggleTimer, this.horseJumpPowerCounter, this.horseJumpPower);
        EventBus.getInstance().call(var2);
        if (var2.isCancelled()) {
            var1.cancel();
        }
    }

    public void impl$onSprinting(EntityPlayerSP var1, boolean var2) {
        if (!var2 || !Ref.getLC().lllllIllIllIllllIlIllllII().lIIlIlllIlIlIIIlllIIlIIII().IlllIIIIIIlllIlIIlllIlIIl() || Ref.getLC().lllllIllIllIllllIlIllllII().lIIlIlllIlIlIIIlllIIlIIII().IllllIIllllIllIIIIlllllII().llIlllIIIllllIIlllIllIIIl()) {
            var1.setInvisible(var2);
        }
    }

    public Optional<String> bridge$getClientBrand() {
        return Optional.ofNullable(getClientBrand());
    }

    public void sendChatMessage(String var1) {
    }

//    public Vec3 ap(float var1) {
//    }

    public NetHandlerPlayClientBridge bridge$getSendQueue() {
        return (NetHandlerPlayClientBridge) sendQueue;
    }

    public void bridge$sendChatMessage(String var1) {
    }

    public MovementInputBridge bridge$getMovementInput() {
        return (MovementInputBridge) movementInput;
    }

    public void bridge$onCriticalHit(EntityBridge var1) {
    }

    public void bridge$setMovementInput(MovementInputBridge var1) {
    }

    public void bridge$swingItem0() {
    }

    public boolean bridge$isSprinting() {
        return isSprinting();
    }

    public void bridge$setSprinting(boolean var1) {
    }

    public void bridge$pushOutOfBlocks(double var1, double var3, double var5) {
    }

    public void bridge$sendPlayerAbilities() {
    }

    public boolean bridge$isRidingHorse() {
        return isRidingHorse();
    }

    public void bridge$playPortalSound() {
    }

    public void bridge$sendRidingJumpPacket() {
    }

    public int bridge$getSprintingTicksLeft() {
        return sprintingTicksLeft;
    }

    public void bridge$setSprintingTicksLeft(int var1) {
        this.sprintingTicksLeft = var1;
    }

    public int bridge$getSprintToggleTimer() {
        return sprintToggleTimer;
    }

    public void bridge$setSprintToggleTimer(int var1) {
        this.sprintToggleTimer = var1;
    }

    public float bridge$getPrevTimeInPortal() {
        return prevTimeInPortal;
    }

    public void bridge$setPrevTimeInPortal(float var1) {
        this.prevTimeInPortal = var1;
    }

    public float bridge$getTimeInPortal() {
        return timeInPortal;
    }

    public void bridge$setTimeInPortal(float var1) {
        this.timeInPortal = var1;
    }

    public void bridge$setInPortal(boolean var1) {
        this.inPortal = var1;
    }

    public int bridge$getTimeUntilPortal() {
        return timeUntilPortal;
    }

    public void bridge$setTimeUntilPortal(int var1) {
        this.timeUntilPortal = var1;
    }

    public void bridge$setHorseJumpPowerCounter(int var1) {
        this.horseJumpPowerCounter = var1;
    }

    public void bridge$setHorseJumpPower(float var1) {
        this.horseJumpPower = var1;
    }

    public float bridge$getHorseJumpPower() {
        return horseJumpPower;
    }

    public int bridge$getHorseJumpPowerCounter() {
        return horseJumpPowerCounter;
    }

    // $FF: synthetic method
//    public void lambda$event$livingUpdate$0() {
//    }
}
