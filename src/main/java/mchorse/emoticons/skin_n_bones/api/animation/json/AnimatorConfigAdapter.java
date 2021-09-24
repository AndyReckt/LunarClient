package mchorse.emoticons.skin_n_bones.api.animation.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMeshConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorActionsConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorHeldItemConfig;

public class AnimatorConfigAdapter implements JsonDeserializer<AnimatorConfig> {
    public AnimatorConfig deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        if (!jsonElement.isJsonObject()) {
            return null;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        AnimatorConfig animatorConfig = new AnimatorConfig();
        if (jsonObject.has("name")) {
            animatorConfig.name = jsonObject.get("name").getAsString();
        }
        if (jsonObject.has("primaryMesh")) {
            animatorConfig.primaryMesh = jsonObject.get("primaryMesh").getAsString();
        }
        if (jsonObject.has("scale")) {
            animatorConfig.scale = jsonObject.get("scale").getAsFloat();
        }
        if (jsonObject.has("scaleGui")) {
            animatorConfig.scaleGui = jsonObject.get("scaleGui").getAsFloat();
        }
        if (jsonObject.has("scaleItems")) {
            animatorConfig.scaleItems = jsonObject.get("scaleItems").getAsFloat();
        }
        if (jsonObject.has("renderHeldItems")) {
            animatorConfig.renderHeldItems = jsonObject.get("renderHeldItems").getAsBoolean();
        }
        if (jsonObject.has("leftHands")) {
            this.addHeldConfig(animatorConfig.leftHands, jsonObject.get("leftHands"), jsonDeserializationContext);
        }
        if (jsonObject.has("rightHands")) {
            this.addHeldConfig(animatorConfig.rightHands, jsonObject.get("rightHands"), jsonDeserializationContext);
        }
        if (jsonObject.has("head")) {
            animatorConfig.head = jsonObject.get("head").getAsString();
        }
        if (jsonObject.has("actions")) {
            animatorConfig.actions = jsonDeserializationContext.deserialize(jsonObject.get("actions"), AnimatorActionsConfig.class);
        }
        if (jsonObject.has("meshes")) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : jsonObject.getAsJsonObject("meshes").entrySet()) {
                hashMap.put(entry.getKey(), jsonDeserializationContext.deserialize((JsonElement)entry.getValue(), AnimationMeshConfig.class));
            }
            animatorConfig.meshes = hashMap;
        }
        return animatorConfig;
    }

    public void addHeldConfig(Map map, JsonElement jsonElement, JsonDeserializationContext jsonDeserializationContext) {
        block3: {
            block2: {
                map.clear();
                if (!jsonElement.isJsonArray()) break block2;
                for (String string : AnimatorConfigAdapter.toStringArray(jsonElement.getAsJsonArray())) {
                    map.put(string, new AnimatorHeldItemConfig(string));
                }
                break block3;
            }
            if (!jsonElement.isJsonObject()) break block3;
            for (Map.Entry entry : ((JsonObject)jsonElement).entrySet()) {
                AnimatorHeldItemConfig animatorHeldItemConfig = jsonDeserializationContext.deserialize((JsonElement)entry.getValue(), AnimatorHeldItemConfig.class);
                animatorHeldItemConfig.boneName = (String)entry.getKey();
                map.put(animatorHeldItemConfig.boneName, animatorHeldItemConfig);
            }
        }
    }

    public static String[] toStringArray(JsonArray jsonArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n = jsonArray.size();
        for (int i = 0; i < n; ++i) {
            JsonElement jsonElement = jsonArray.get(i);
            if (!jsonElement.isJsonPrimitive()) continue;
            arrayList.add(jsonElement.getAsString());
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }
}

