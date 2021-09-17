/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  lunar.G.EntityLivingBaseBridge
 */
package mchorse.emoticons.skin_n_bones.api.animation.model;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import mchorse.emoticons.skin_n_bones.api.animation.model.ActionPlayback;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;

public interface IAnimator {
    public void refresh();

    public void setEmote(ActionPlayback var1);

    public void update(EntityLivingBaseBridge var1);

    public void applyActions(BOBJArmature var1, float var2);
}

