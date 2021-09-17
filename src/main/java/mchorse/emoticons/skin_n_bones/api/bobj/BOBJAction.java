/*
 * Decompiled with CFR 0.150.
 */
package mchorse.emoticons.skin_n_bones.api.bobj;

import java.util.HashMap;
import java.util.Map;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJGroup;

public class BOBJAction {
    public String name;
    public Map groups = new HashMap();

    public BOBJAction(String string) {
        this.name = string;
    }

    public int getDuration() {
        int n = 0;
        for (BOBJGroup bOBJGroup : this.groups.values()) {
            n = Math.max(n, bOBJGroup.getDuration());
        }
        return n;
    }
}

