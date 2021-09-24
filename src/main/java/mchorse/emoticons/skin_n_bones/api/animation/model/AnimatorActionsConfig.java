package mchorse.emoticons.skin_n_bones.api.animation.model;

import java.util.HashMap;
import java.util.Map;
import mchorse.emoticons.skin_n_bones.api.animation.model.ActionConfig;

public class AnimatorActionsConfig {
    public Map<String, ActionConfig> actions = new HashMap<>();

    public void copy(AnimatorActionsConfig animatorActionsConfig) {
        this.actions.clear();
        this.actions.putAll(animatorActionsConfig.actions);
    }

    public ActionConfig getConfig(String string) {
        ActionConfig actionConfig = this.actions.get(string);
        return actionConfig == null ? new ActionConfig(string) : actionConfig;
    }

    public String toKey(String string) {
        return string.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }
}

