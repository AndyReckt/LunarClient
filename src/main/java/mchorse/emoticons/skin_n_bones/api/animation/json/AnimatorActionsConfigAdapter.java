package mchorse.emoticons.skin_n_bones.api.animation.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Map;
import mchorse.emoticons.skin_n_bones.api.animation.model.ActionConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorActionsConfig;

public class AnimatorActionsConfigAdapter implements JsonDeserializer<AnimatorActionsConfig> {
    public AnimatorActionsConfig deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        if (!jsonElement.isJsonObject()) {
            return null;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        AnimatorActionsConfig animatorActionsConfig = new AnimatorActionsConfig();
        for (Map.Entry entry : jsonObject.entrySet()) {
            JsonElement jsonElement2 = (JsonElement)entry.getValue();
            String string = animatorActionsConfig.toKey((String)entry.getKey());
            if (jsonElement2.isJsonObject()) {
                ((JsonObject)jsonElement2).addProperty("name", string);
            }
            animatorActionsConfig.actions.put(string, jsonDeserializationContext.deserialize(jsonElement2, ActionConfig.class));
        }
        return animatorActionsConfig;
    }
}

