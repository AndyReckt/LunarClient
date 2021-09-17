/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonDeserializer
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 */
package mchorse.emoticons.skin_n_bones.api.animation.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import mchorse.emoticons.skin_n_bones.api.animation.model.ActionConfig;

public class ActionConfigAdapter
implements JsonDeserializer {
    public ActionConfig deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        ActionConfig actionConfig = new ActionConfig();
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = (JsonObject)jsonElement;
            if (jsonObject.has("name")) {
                actionConfig.name = jsonObject.get("name").getAsString();
            }
            if (jsonObject.has("clamp")) {
                actionConfig.clamp = jsonObject.get("clamp").getAsBoolean();
            }
            if (jsonObject.has("reset")) {
                actionConfig.reset = jsonObject.get("reset").getAsBoolean();
            }
            if (jsonObject.has("speed")) {
                actionConfig.speed = jsonObject.get("speed").getAsFloat();
            }
            if (jsonObject.has("fade")) {
                actionConfig.fade = jsonObject.get("fade").getAsInt();
            }
            if (jsonObject.has("tick")) {
                actionConfig.tick = jsonObject.get("tick").getAsInt();
            }
        } else if (jsonElement.isJsonPrimitive()) {
            actionConfig.name = jsonElement.getAsString();
        }
        return actionConfig;
    }
}

