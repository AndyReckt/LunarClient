package mchorse.emoticons.skin_n_bones.api.bobj;

import java.util.ArrayList;
import java.util.List;

public class BOBJGroup {
    public String name;
    public List<BOBJChannel> channels = new ArrayList<>();

    public BOBJGroup(String string) {
        this.name = string;
    }

    public void apply(BOBJBone bOBJBone, float f) {
        for (BOBJChannel bOBJChannel : this.channels) {
            bOBJChannel.apply(bOBJBone, f);
        }
    }

    public void applyInterpolate(BOBJBone bOBJBone, float f, float f2) {
        for (BOBJChannel bOBJChannel : this.channels) {
            bOBJChannel.applyInterpolate(bOBJBone, f, f2);
        }
    }

    public int getDuration() {
        int n = 0;
        for (BOBJChannel bOBJChannel : this.channels) {
            int n2 = bOBJChannel.keyframes.size();
            if (n2 <= 0) continue;
            n = Math.max(n, bOBJChannel.keyframes.get(n2 - 1).frame);
        }
        return n;
    }
}

