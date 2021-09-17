/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Objects
 *  lunar.af.ResourceLocationBridge
 */
package mchorse.mclib.utils.resources;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import lunar.af.ResourceLocationBridge;
import mchorse.mclib.utils.resources.RLUtils;

public class MultiResourceLocation
implements ResourceLocationBridge {
    public List children = new ArrayList();

    public MultiResourceLocation(String string) {
        this.children.add(RLUtils.create(string));
    }

    public MultiResourceLocation(String string, String string2) {
        this.children.add(RLUtils.create(string, string2));
    }

    public String bridge$getDomain() {
        return this.children.isEmpty() ? "" : ((ResourceLocationBridge)this.children.get(0)).bridge$getDomain();
    }

    public String bridge$getPath() {
        return this.children.isEmpty() ? "" : ((ResourceLocationBridge)this.children.get(0)).bridge$getPath();
    }

    public String toString() {
        return this.bridge$getDomain() + ":" + this.bridge$getPath();
    }

    public boolean equals(Object object) {
        if (object instanceof MultiResourceLocation) {
            boolean bl;
            MultiResourceLocation multiResourceLocation = (MultiResourceLocation)object;
            boolean bl2 = bl = this.children.size() == multiResourceLocation.children.size();
            if (bl) {
                int n = this.children.size();
                for (int i = 0; i < n; ++i) {
                    bl = bl && Objects.equal(this.children.get(i), multiResourceLocation.children.get(i));
                }
            }
            return bl;
        }
        return super.equals(object);
    }

    public int hashCode() {
        int n = super.hashCode();
        int n2 = this.children.size();
        for (int i = 0; i < n2; ++i) {
            n = 31 * n + this.children.hashCode();
        }
        return n;
    }
}

