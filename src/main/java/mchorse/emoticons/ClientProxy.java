/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  lunar.a.Bridge
 *  lunar.a.MinecraftVersion
 *  lunar.aH.PreRenderPlayerEvent
 *  lunar.aw.EventBus
 *  org.apache.commons.io.IOUtils
 */
package mchorse.emoticons;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.entity.player.PreRenderPlayerEvent;
import mchorse.emoticons.client.EntityModelHandler;
import mchorse.emoticons.skin_n_bones.api.animation.Animation;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationManager;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorConfig;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJLoader;
import org.apache.commons.io.IOUtils;

public class ClientProxy {
    public static File configFolder;

    public void init() {
        EntityModelHandler entityModelHandler = new EntityModelHandler();
        EventBus.getInstance().register(PreRenderPlayerEvent.class, entityModelHandler::onRenderPlayer);
        Bridge.lllllIllIlIIlIIlIIIlllIlI().bridge$create();
        try {
            Class<?> class_ = this.getClass();
            AnimationManager animationManager = AnimationManager.INSTANCE;
            BOBJLoader.BOBJData bOBJData = BOBJLoader.readData(class_.getResourceAsStream("/assets/emoticons/models/entity/props.bobj"));
            BOBJLoader.BOBJData bOBJData2 = BOBJLoader.readData(class_.getResourceAsStream("/assets/emoticons/models/entity/props_simple.bobj"));
            String string = String.format("/assets/emoticons/models/entity/default%s.bobj", Bridge.getMinecraftVersion() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl ? "_1_7" : "");
            BOBJLoader.BOBJData bOBJData3 = BOBJLoader.readData(class_.getResourceAsStream(string));
            BOBJLoader.BOBJData bOBJData4 = BOBJLoader.readData(class_.getResourceAsStream("/assets/emoticons/models/entity/slim.bobj"));
            BOBJLoader.BOBJData bOBJData5 = BOBJLoader.readData(class_.getResourceAsStream("/assets/emoticons/models/entity/default_simple.bobj"));
            BOBJLoader.BOBJData bOBJData6 = BOBJLoader.readData(class_.getResourceAsStream("/assets/emoticons/models/entity/slim_simple.bobj"));
            BOBJLoader.BOBJData bOBJData7 = BOBJLoader.readData(class_.getResourceAsStream("/assets/emoticons/models/entity/actions.bobj"));
            BOBJLoader.BOBJData bOBJData8 = BOBJLoader.readData(class_.getResourceAsStream("/assets/emoticons/models/entity/extra.bobj"));
            bOBJData3.actions.putAll(bOBJData7.actions);
            bOBJData3.actions.putAll(bOBJData8.actions);
            bOBJData4.actions.putAll(bOBJData7.actions);
            bOBJData4.actions.putAll(bOBJData8.actions);
            bOBJData5.actions.putAll(bOBJData7.actions);
            bOBJData5.actions.putAll(bOBJData8.actions);
            bOBJData6.actions.putAll(bOBJData7.actions);
            BOBJLoader.merge(bOBJData3, bOBJData);
            BOBJLoader.merge(bOBJData4, bOBJData);
            BOBJLoader.merge(bOBJData5, bOBJData2);
            BOBJLoader.merge(bOBJData6, bOBJData2);
            Animation animation = new Animation("default", bOBJData3);
            Animation animation2 = new Animation("slim", bOBJData4);
            Animation animation3 = new Animation("default_simple", bOBJData5);
            Animation animation4 = new Animation("slim_simple", bOBJData6);
            animation.init();
            animation2.init();
            animation3.init();
            animation4.init();
            animationManager.animations.put("default", new AnimationManager.AnimationEntry(animation, configFolder, 1L));
            animationManager.animations.put("slim", new AnimationManager.AnimationEntry(animation2, configFolder, 1L));
            animationManager.animations.put("default_simple", new AnimationManager.AnimationEntry(animation3, configFolder, 1L));
            animationManager.animations.put("slim_simple", new AnimationManager.AnimationEntry(animation4, configFolder, 1L));
            AnimatorConfig animatorConfig = animationManager.gson.fromJson(IOUtils.toString(class_.getResourceAsStream("/assets/emoticons/models/entity/default.json"), Charset.defaultCharset()), AnimatorConfig.class);
            AnimatorConfig animatorConfig2 = animationManager.gson.fromJson(IOUtils.toString(class_.getResourceAsStream("/assets/emoticons/models/entity/slim.json"), Charset.defaultCharset()), AnimatorConfig.class);
            AnimatorConfig animatorConfig3 = animationManager.gson.fromJson(IOUtils.toString(class_.getResourceAsStream("/assets/emoticons/models/entity/default_simple.json"), Charset.defaultCharset()), AnimatorConfig.class);
            AnimatorConfig animatorConfig4 = animationManager.gson.fromJson(IOUtils.toString(class_.getResourceAsStream("/assets/emoticons/models/entity/slim_simple.json"), Charset.defaultCharset()), AnimatorConfig.class);
            animationManager.configs.put("default", new AnimatorConfig.AnimatorConfigEntry(animatorConfig, 1L));
            animationManager.configs.put("slim", new AnimatorConfig.AnimatorConfigEntry(animatorConfig2, 1L));
            animationManager.configs.put("default_simple", new AnimatorConfig.AnimatorConfigEntry(animatorConfig3, 1L));
            animationManager.configs.put("slim_simple", new AnimatorConfig.AnimatorConfigEntry(animatorConfig4, 1L));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

