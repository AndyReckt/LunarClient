/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonDeserializer
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonSerializationContext
 *  com.google.gson.JsonSerializer
 */
package mchorse.emoticons.skin_n_bones.api.animation.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMeshConfig;
import mchorse.mclib.utils.resources.RLUtils;

public class AnimationMeshConfigAdapter
implements JsonDeserializer,
JsonSerializer {
    public AnimationMeshConfig deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        if (!jsonElement.isJsonObject()) {
            return null;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        AnimationMeshConfig animationMeshConfig = new AnimationMeshConfig();
        if (jsonObject.has("texture")) {
            animationMeshConfig.texture = RLUtils.create(jsonObject.get("texture"));
        }
        if (jsonObject.has("filtering")) {
            int n = animationMeshConfig.filtering = jsonObject.get("filtering").getAsString().equalsIgnoreCase("linear") ? 9729 : 9728;
        }
        if (jsonObject.has("normals")) {
            animationMeshConfig.normals = jsonObject.get("normals").getAsBoolean();
        }
        if (jsonObject.has("smooth")) {
            animationMeshConfig.smooth = jsonObject.get("smooth").getAsBoolean();
        }
        if (jsonObject.has("visible")) {
            animationMeshConfig.visible = jsonObject.get("visible").getAsBoolean();
        }
        if (jsonObject.has("lighting")) {
            animationMeshConfig.lighting = jsonObject.get("lighting").getAsBoolean();
        }
        if (jsonObject.has("color")) {
            animationMeshConfig.color = jsonObject.get("color").getAsInt();
        }
        return animationMeshConfig;
    }

    public JsonElement serialize(AnimationMeshConfig animationMeshConfig, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        if (animationMeshConfig.texture != null) {
            jsonObject.add("texture", RLUtils.writeJson(animationMeshConfig.texture));
        }
        jsonObject.addProperty("filtering", animationMeshConfig.filtering == 9729 ? "linear" : "nearest");
        jsonObject.addProperty("normals", Boolean.valueOf(animationMeshConfig.normals));
        jsonObject.addProperty("smooth", Boolean.valueOf(animationMeshConfig.smooth));
        jsonObject.addProperty("visible", Boolean.valueOf(animationMeshConfig.visible));
        jsonObject.addProperty("lighting", Boolean.valueOf(animationMeshConfig.lighting));
        jsonObject.addProperty("color", (Number)animationMeshConfig.color);
        return jsonObject;
    }
}

