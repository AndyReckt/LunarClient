/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonNull
 *  com.google.gson.JsonPrimitive
 *  lunar.a.Bridge
 *  lunar.af.ResourceLocationBridge
 */
package mchorse.mclib.utils.resources;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import lunar.a.Bridge;
import lunar.af.ResourceLocationBridge;
import mchorse.mclib.utils.resources.MultiResourceLocation;

public class RLUtils {
    public static ResourceLocationBridge create(String string) {
        if (string.startsWith("blockbuster.actors:")) {
            string = "b.a" + string.substring(18);
        }
        return Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation(string);
    }

    public static ResourceLocationBridge create(String string, String string2) {
        if (string.equals("blockbuster.actors")) {
            string = "b.a";
        }
        return Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation(string, string2);
    }

    public static ResourceLocationBridge create() {
        return null;
    }

    public static ResourceLocationBridge create(JsonElement jsonElement) {
        if (jsonElement.isJsonArray()) {
            JsonElement jsonElement2;
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            int n = jsonArray.size();
            if (n > 0 && (jsonElement2 = jsonArray.get(0)).isJsonPrimitive()) {
                MultiResourceLocation multiResourceLocation = new MultiResourceLocation(jsonElement2.getAsString());
                for (int i = 1; i < n; ++i) {
                    multiResourceLocation.children.add(RLUtils.create(jsonArray.get(i)));
                }
                return multiResourceLocation;
            }
        } else if (jsonElement.isJsonPrimitive()) {
            return RLUtils.create(jsonElement.getAsString());
        }
        return null;
    }

    public static JsonElement writeJson(ResourceLocationBridge resourceLocationBridge) {
        if (resourceLocationBridge instanceof MultiResourceLocation) {
            MultiResourceLocation multiResourceLocation = (MultiResourceLocation)resourceLocationBridge;
            JsonArray jsonArray = new JsonArray();
            for (ResourceLocationBridge resourceLocationBridge2 : multiResourceLocation.children) {
                jsonArray.add((JsonElement)new JsonPrimitive(resourceLocationBridge2.toString()));
            }
            return jsonArray;
        }
        if (resourceLocationBridge != null) {
            return new JsonPrimitive(resourceLocationBridge.toString());
        }
        return JsonNull.INSTANCE;
    }

    public static ResourceLocationBridge clone(ResourceLocationBridge resourceLocationBridge) {
        if (resourceLocationBridge instanceof MultiResourceLocation) {
            MultiResourceLocation multiResourceLocation = (MultiResourceLocation)resourceLocationBridge;
            MultiResourceLocation multiResourceLocation2 = new MultiResourceLocation(multiResourceLocation.toString());
            multiResourceLocation2.children.clear();
            multiResourceLocation2.children.addAll(multiResourceLocation.children);
            return multiResourceLocation2;
        }
        if (resourceLocationBridge != null) {
            return RLUtils.create(resourceLocationBridge.toString());
        }
        return null;
    }

    public static ResourceLocationBridge fromString(String string, String string2) {
        if (string.isEmpty()) {
            return null;
        }
        if (string.indexOf(":") == -1) {
            String string3 = string.indexOf("/") == -1 ? string2 + "/" : "";
            return RLUtils.create("b.a", string3 + string);
        }
        return RLUtils.create(string);
    }

    public static String fromResource(ResourceLocationBridge resourceLocationBridge) {
        if (resourceLocationBridge == null) {
            return "";
        }
        if (resourceLocationBridge.bridge$getDomain().equals("b.a")) {
            String[] arrstring = resourceLocationBridge.bridge$getDomain().split("/");
            return arrstring[arrstring.length - 1];
        }
        return resourceLocationBridge.toString();
    }
}

