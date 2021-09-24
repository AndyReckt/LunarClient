/*
 * Decompiled with CFR 0.150.
 */
package mchorse.emoticons.skin_n_bones.api.bobj;

import java.util.ArrayList;
import java.util.List;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJKeyframe;

public class BOBJChannel {
    public String path;
    public int index;
    public List<BOBJKeyframe> keyframes = new ArrayList<>();

    public BOBJChannel(String string, int n) {
        this.path = string;
        this.index = n;
    }

    public float calculate(float f) {
        int n = this.keyframes.size();
        if (n <= 0) {
            return 0.0f;
        }
        if (n == 1) {
            return this.keyframes.get(0).value;
        }
        BOBJKeyframe bOBJKeyframe = this.keyframes.get(0);
        if ((float)bOBJKeyframe.frame > f) {
            return bOBJKeyframe.value;
        }
        for (int i = 0; i < n; ++i) {
            bOBJKeyframe = this.keyframes.get(i);
            if (!((float)bOBJKeyframe.frame > f) || i == 0) continue;
            BOBJKeyframe bOBJKeyframe2 = this.keyframes.get(i - 1);
            float f2 = (f - (float)bOBJKeyframe2.frame) / (float)(bOBJKeyframe.frame - bOBJKeyframe2.frame);
            return bOBJKeyframe2.interpolate(f2, bOBJKeyframe);
        }
        return bOBJKeyframe.value;
    }

    public BOBJKeyframe get(float f, boolean bl) {
        int n = this.keyframes.size();
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return this.keyframes.get(0);
        }
        BOBJKeyframe bOBJKeyframe = null;
        for (int i = 0; i < n; ++i) {
            bOBJKeyframe = this.keyframes.get(i);
            if (!((float)bOBJKeyframe.frame > f) || i == 0) continue;
            return bl ? bOBJKeyframe : this.keyframes.get(i - 1);
        }
        return bOBJKeyframe;
    }

    public void apply(BOBJBone bOBJBone, float f) {
        switch (this.path) {
        case "location":
            if (this.index == 0) {
                bOBJBone.x = this.calculate(f);
            } else if (this.index == 1) {
                bOBJBone.y = this.calculate(f);
            } else if (this.index == 2) {
                bOBJBone.z = this.calculate(f);
            }
            break;
        case "rotation":
            if (this.index == 0) {
                bOBJBone.rotateX = this.calculate(f);
            } else if (this.index == 1) {
                bOBJBone.rotateY = this.calculate(f);
            } else if (this.index == 2) {
                bOBJBone.rotateZ = this.calculate(f);
            }
            break;
        case "scale":
            if (this.index == 0) {
                bOBJBone.scaleX = this.calculate(f);
            } else if (this.index == 1) {
                bOBJBone.scaleY = this.calculate(f);
            } else if (this.index == 2) {
                bOBJBone.scaleZ = this.calculate(f);
            }
            break;
        }
    }

    public void applyInterpolate(BOBJBone bOBJBone, float f, float f2) {
        float f3 = this.calculate(f);
        switch (this.path) {
        case "location":
            if (this.index == 0) {
                bOBJBone.x = f3 + (bOBJBone.x - f3) * f2;
            } else if (this.index == 1) {
                bOBJBone.y = f3 + (bOBJBone.y - f3) * f2;
            } else if (this.index == 2) {
                bOBJBone.z = f3 + (bOBJBone.z - f3) * f2;
            }
            break;
        case "rotation":
            if (this.index == 0) {
                bOBJBone.rotateX = f3 + (bOBJBone.rotateX - f3) * f2;
            } else if (this.index == 1) {
                bOBJBone.rotateY = f3 + (bOBJBone.rotateY - f3) * f2;
            } else if (this.index == 2) {
                bOBJBone.rotateZ = f3 + (bOBJBone.rotateZ - f3) * f2;
            }
            break;
        case "scale":
            if (this.index == 0) {
                bOBJBone.scaleX = f3 + (bOBJBone.scaleX - f3) * f2;
            } else if (this.index == 1) {
                bOBJBone.scaleY = f3 + (bOBJBone.scaleY - f3) * f2;
            } else if (this.index == 2) {
                bOBJBone.scaleZ = f3 + (bOBJBone.scaleZ - f3) * f2;
            }
            break;
        }
    }
}

