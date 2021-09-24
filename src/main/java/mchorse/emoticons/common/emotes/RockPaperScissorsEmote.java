package mchorse.emoticons.common.emotes;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import mchorse.emoticons.api.animation.model.AnimatorEmoticonsController;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;

public class RockPaperScissorsEmote
    extends Emote {
    public String suffix = "";

    public RockPaperScissorsEmote(String string, int n, boolean bl) {
        super(string, n, bl);
    }

    public RockPaperScissorsEmote(String string, int n, boolean bl, String string2) {
        super(string, n, bl);
        this.suffix = string2;
    }

    @Override
    public Emote getDynamicEmote() {
        int n = LunarClient.RANDOM.nextInt(30);
        String string = "";
        if (n <= 10) {
            string = "rock";
        } else if (n <= 20) {
            string = "paper";
        } else if (n <= 30) {
            string = "scissors";
        }
        return this.getDynamicEmote(string);
    }

    @Override
    public Emote getDynamicEmote(String string) {
        return new RockPaperScissorsEmote(this.name, this.duration, this.looping, string);
    }

    @Override
    public String getKey() {
        return this.name + (this.suffix.isEmpty() ? "" : ":" + this.suffix);
    }

    @Override
    public void startAnimation(AnimatorEmoticonsController animatorEmoticonsController) {
        if (this.suffix.equals("rock")) {
            animatorEmoticonsController.itemSlot = Bridge.getInstance().initItemStack(Bridge.IllIllIIIllIIIlIlIlIIIIll().bridge$stone());
        } else if (this.suffix.equals("paper")) {
            animatorEmoticonsController.itemSlot = Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItem("paper"));
        } else if (this.suffix.equals("scissors")) {
            animatorEmoticonsController.itemSlot = Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItem("shears"));
        }
        animatorEmoticonsController.itemSlotScale = 0.0f;
    }

    @Override
    public void progressAnimation(EntityLivingBaseBridge entityLivingBaseBridge, BOBJArmature bOBJArmature, AnimatorEmoticonsController animatorEmoticonsController, int n, float f) {
        animatorEmoticonsController.itemSlotScale = n > 25 && n < 55 ? (n < 30 ? ((float)(n - 25) + f) / 5.0f : (n >= 50 ? 1.0f - ((float)(n - 50) + f) / 5.0f : 1.0f)) : 0.0f;
    }

    @Override
    public void stopAnimation(AnimatorEmoticonsController animatorEmoticonsController) {
        animatorEmoticonsController.itemSlot = Bridge.getInstance().initEmptyItemStack();
        animatorEmoticonsController.itemSlotScale = 0.0f;
    }
}

