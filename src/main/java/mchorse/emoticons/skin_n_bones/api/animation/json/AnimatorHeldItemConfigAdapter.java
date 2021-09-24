package mchorse.emoticons.skin_n_bones.api.animation.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorHeldItemConfig;

public class AnimatorHeldItemConfigAdapter implements JsonDeserializer<AnimatorHeldItemConfig> {
    public AnimatorHeldItemConfig deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        if (!jsonElement.isJsonObject()) {
            return null;
        }
        JsonObject jsonObject = (JsonObject)jsonElement;
        AnimatorHeldItemConfig animatorHeldItemConfig = new AnimatorHeldItemConfig("");
        if (jsonObject.has("x")) {
            animatorHeldItemConfig.x = jsonObject.get("x").getAsFloat();
        }
        if (jsonObject.has("y")) {
            animatorHeldItemConfig.y = jsonObject.get("y").getAsFloat();
        }
        if (jsonObject.has("z")) {
            animatorHeldItemConfig.z = jsonObject.get("z").getAsFloat();
        }
        if (jsonObject.has("sx")) {
            animatorHeldItemConfig.scaleX = jsonObject.get("sx").getAsFloat();
        }
        if (jsonObject.has("sy")) {
            animatorHeldItemConfig.scaleY = jsonObject.get("sy").getAsFloat();
        }
        if (jsonObject.has("sz")) {
            animatorHeldItemConfig.scaleZ = jsonObject.get("sz").getAsFloat();
        }
        if (jsonObject.has("rx")) {
            animatorHeldItemConfig.rotateX = jsonObject.get("rx").getAsFloat();
        }
        if (jsonObject.has("ry")) {
            animatorHeldItemConfig.rotateY = jsonObject.get("ry").getAsFloat();
        }
        if (jsonObject.has("rz")) {
            animatorHeldItemConfig.rotateZ = jsonObject.get("rz").getAsFloat();
        }
        return animatorHeldItemConfig;
    }
}

