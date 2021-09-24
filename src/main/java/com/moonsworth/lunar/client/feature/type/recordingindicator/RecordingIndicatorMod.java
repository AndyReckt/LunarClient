package com.moonsworth.lunar.client.feature.type.recordingindicator;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.type.replaymod.ReplayMod;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;

import java.util.List;

public class RecordingIndicatorMod
    extends AbstractFeatureContainerChild {
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;

    public RecordingIndicatorMod(ConfigurableFeature configurableFeature) {
        super(configurableFeature, true, HudModPosition.TOP_LEFT);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent renderGameOverlayEvent, float f, float f2) {
        String string = LunarClient.getInstance().lIlIIlIlllIIlIIIlIlIlIllI().lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of("replaymod"), "replaymod.gui.recording");
        this.lIlIlIlIlIIlIIlIIllIIIIIl(string, f, f2);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent renderGameOverlayEvent, float f, float f2) {
        ReplayMod replayMod = (ReplayMod)this.IlIllIIlIIlIIIllIllllIIll();
        if (replayMod.lIllllIllIIlIIlIIIlIIIlII().isRecording() && replayMod.lIllllIllIIlIIlIIIlIIIlII().showRecordingIndicator()) {
            String string = replayMod.lIllllIllIIlIIlIIIlIIIlII().isPaused() ? LunarClient.getInstance().lIlIIlIlllIIlIIIlIlIlIllI().lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of("replaymod"), "replaymod.gui.paused") : LunarClient.getInstance().lIlIIlIlllIIlIIIlIlIlIllI().lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of("replaymod"), "replaymod.gui.recording");
            this.lIlIlIlIlIIlIIlIIllIIIIIl(string, f, f2);
        } else {
            this.IlllIIIIIIlllIlIIlllIlIIl(24.0f, 24.0f);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, float f2) {
        ReplayMod replayMod = (ReplayMod)this.IlIllIIlIIlIIIllIllllIIll();
        FontRendererBridge fontRendererBridge = Ref.getFontRenderer();
        fontRendererBridge.bridge$drawString(string.toUpperCase(), f + 20.0f, f2 + 8.0f - (float)fontRendererBridge.lIlIlIlIlIIlIIlIIllIIIIIl() / 2.0f, -1, this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
        Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(replayMod.lIllllIllIIlIIlIIIlIIIlII().getReplayModTexture());
        int n = replayMod.lIllllIllIIlIIlIIIlIIIlII().getTextureSize();
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawModalRectWithCustomSizedTexture((int)f, (int)f2, 58.0f, 20.0f, 16, 16, n, n);
        this.IlllIIIIIIlllIlIIlllIlIIl(24.0f + fontRendererBridge.bridge$getStringWidth(string), fontRendererBridge.lIlIlIlIlIIlIIlIIllIIIIIl() + 6);
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting("text_shadow", false);
        return ImmutableList.of(this.lllIIIIIlllIIlIllIIlIIIlI);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("recording_indicator", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.HUD));
    }
}
