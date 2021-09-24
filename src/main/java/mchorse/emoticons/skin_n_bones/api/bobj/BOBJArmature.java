/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  javax.vecmath.Matrix4f
 */
package mchorse.emoticons.skin_n_bones.api.bobj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.vecmath.Matrix4f;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;

public class BOBJArmature {
    public String name;
    public String action = "";
    public Map<String, BOBJBone> bones = new HashMap<>();
    public List<BOBJBone> orderedBones = new ArrayList<>();
    public List<BOBJBone> ikBones = new ArrayList<>();
    public Matrix4f[] matrices;
    public boolean initialized;

    public BOBJArmature(String string) {
        this.name = string;
    }

    public void addBone(BOBJBone bOBJBone) {
        this.bones.put(bOBJBone.name, bOBJBone);
        this.orderedBones.add(bOBJBone);
    }

    public void initArmature() {
        if (!this.initialized) {
            ArrayList<BOBJBone> arrayList = new ArrayList<>();
            for (BOBJBone bOBJBone : this.bones.values()) {
                if (bOBJBone.hasModifiers()) {
                    arrayList.add(bOBJBone);
                }
                if (!bOBJBone.parent.isEmpty()) {
                    bOBJBone.parentBone = this.bones.get(bOBJBone.parent);
                    bOBJBone.relBoneMat.set(bOBJBone.parentBone.boneMat);
                    bOBJBone.relBoneMat.invert();
                    bOBJBone.relBoneMat.mul(bOBJBone.boneMat);
                    continue;
                }
                bOBJBone.relBoneMat.set(bOBJBone.boneMat);
            }
            if (!arrayList.isEmpty()) {
                this.ikBones = arrayList;
            }

            this.orderedBones.sort(Comparator.comparingInt(o -> o.index));
            this.matrices = new Matrix4f[this.orderedBones.size()];
            this.initialized = true;
        }
    }

    public void setupMatrices() {
        for (BOBJBone bOBJBone : this.orderedBones) {
            this.matrices[bOBJBone.index] = bOBJBone.compute();
        }
    }
}

