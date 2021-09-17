package com.moonsworth.lunar.client.registry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.json.file.DefaultJson;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.setting.ColorSetting;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FavoriteColorsConfig
extends ItemSetLoader<ColorSetting>
implements DefaultJson {
    @Override
    public Set<ColorSetting> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new LinkedHashSet<>(12);
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "favorite_colors.json";
    }

    @Override
    public void b_() {
        super.b_();
        this.load();
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            try {
                String string = ((String)entry.getKey()).replace("_clr_nr", "");
                ColorSetting colorSetting = new ColorSetting(string, 0);
                colorSetting.IlllIIIIIIlllIlIIlllIlIIl(jsonObject);
                this.llIlllIIIllllIIlllIllIIIl().add(colorSetting);
            }
            catch (Exception exception) {}
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        for (ColorSetting colorSetting : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                colorSetting.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject);
            }
            catch (Exception exception) {}
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ColorSetting colorSetting) {
        ColorSetting colorSetting2 = new ColorSetting("fav_color_" + this.llIlllIIIllllIIlllIllIIIl().size(), (Integer)colorSetting.llIlllIIIllllIIlllIllIIIl());
        colorSetting2.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(colorSetting.IlllllIlIIIlIIlIIllIIlIll().llIlllIIIllllIIlllIllIIIl());
        colorSetting2.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl((Number)colorSetting.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl());
        colorSetting2.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(colorSetting.llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl());
        this.llIlllIIIllllIIlllIllIIIl().add(colorSetting2);
        this.save();
    }
}
 