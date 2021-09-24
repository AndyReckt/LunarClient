package mchorse.emoticons.skin_n_bones.api.animation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.de.IlllIIIIIIlllIlIIlllIlIIl;
import mchorse.emoticons.skin_n_bones.api.animation.model.ActionConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.ActionPlayback;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJAction;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJLoader;
import mchorse.mclib.utils.resources.RLUtils;
import org.lwjgl.opengl.GL15;

public class Animation {
    public String name;
    public BOBJLoader.BOBJData data;
    public List<AnimationMesh> meshes;
    public MinecraftBridge mc;

    public Animation(String string, BOBJLoader.BOBJData bOBJData) {
        this.name = string;
        this.data = bOBJData;
        this.mc = Bridge.llllIIlIIlIIlIIllIIlIIllI();
        this.meshes = new ArrayList();
    }

    public void reload(BOBJLoader.BOBJData bOBJData) {
        this.data = bOBJData;
        this.delete();
        this.init();
    }

    public ActionPlayback createAction(ActionPlayback actionPlayback, ActionConfig actionConfig, boolean bl) {
        return this.createAction(actionPlayback, actionConfig, bl, 1);
    }

    public ActionPlayback createAction(ActionPlayback actionPlayback, ActionConfig actionConfig, boolean bl, int n) {
        BOBJAction bOBJAction = (BOBJAction) this.data.actions.get(actionConfig.name);
        if (bOBJAction == null) {
            return null;
        }
        if (actionPlayback != null && actionPlayback.action == bOBJAction) {
            actionPlayback.config = actionConfig;
            actionPlayback.setSpeed(1.0f);
            return actionPlayback;
        }
        return new ActionPlayback(bOBJAction, actionConfig, bl, n);
    }

    public void init() {
        Map<String, BOBJLoader.CompiledData> map = BOBJLoader.loadMeshes(this.data);
        for (Map.Entry<String, BOBJLoader.CompiledData> entry : map.entrySet()) {
            String string = entry.getKey();
            BOBJLoader.CompiledData compiledData = entry.getValue();
            AnimationMesh animationMesh = new AnimationMesh(this, entry.getKey(), compiledData);
            animationMesh.texture = RLUtils.create("s_b", this.name + "/textures/" + string + "/default.png");
            this.meshes.add(animationMesh);
        }
    }

    public void delete() {
        for (AnimationMesh animationMesh : this.meshes) {
            animationMesh.delete();
        }
        this.meshes.clear();
    }

    public void render(Map map) {
        for (AnimationMesh animationMesh : this.meshes) {
            animationMesh.render(this.mc, map == null ? null : (AnimationMeshConfig) map.get(animationMesh.name));
        }
        GL15.glBindBuffer(34962, 0);
        GL15.glBindBuffer(34963, 0);
    }

    public List<IlllIIIIIIlllIlIIlllIlIIl> renderPasses(Map<String, AnimationMeshConfig> map, int n) {
        ArrayList<IlllIIIIIIlllIlIIlllIlIIl> arrayList = new ArrayList<>();
        for (AnimationMesh animationMesh : this.meshes) {
            arrayList.add(new IlllIIIIIIlllIlIIlllIlIIl
                          (animationMesh.getTexture(map.get(animationMesh.name)),
                           (matrixStackBridge, lIllIlIIIlIIIIIIIlllIlIll2) ->
                           animationMesh.render(
                               this.mc, map.get(animationMesh.name),
                               lIllIlIIIlIIIIIIIlllIlIll2,
                               matrixStackBridge.llIlllIIIllllIIlllIllIIIl(), n
                           ), true
                          )
                         );
        }
        return arrayList;
    }
}

