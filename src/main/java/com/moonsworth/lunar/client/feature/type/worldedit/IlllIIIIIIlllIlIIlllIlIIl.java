package com.moonsworth.lunar.client.feature.type.worldedit;

import com.moonsworth.lunar.client.feature.type.worldedit.bp.WorldEditActionEventInterface;
import com.moonsworth.lunar.client.feature.type.worldedit.bp.llIIIIIIIllIIllIlIllIIIIl;
import com.moonsworth.lunar.client.feature.type.worldedit.bq.IWorldEditCUIHighlighter;
import com.moonsworth.lunar.client.feature.type.worldedit.bq.WorldEditCUIRegionHighlighter;

import java.util.EnumMap;
import java.util.Map;

public enum IlllIIIIIIlllIlIIlllIlIIl {
    lIlIlIlIlIIlIIlIIllIIIIIl {
        public WorldEditActionEventInterface lIlIlIlIlIIlIIlIIllIIIIIl() {
            return new com.moonsworth.lunar.client.feature.type.worldedit.bp.llllIIlIIlIIlIIllIIlIIllI();
        }
    },
    IlllIIIIIIlllIlIIlllIlIIl {
        public WorldEditActionEventInterface lIlIlIlIlIIlIIlIIllIIIIIl() {
            return new llIIIIIIIllIIllIlIllIIIIl();
        }
    },
    lIllIlIIIlIIIIIIIlllIlIll {
        public WorldEditActionEventInterface lIlIlIlIlIIlIIlIIllIIIIIl() {
            return new com.moonsworth.lunar.client.feature.type.worldedit.bp.IlIlIlllllIlIIlIlIlllIlIl();
        }
    },
    llIlllIIIllllIIlllIllIIIl {
        public WorldEditActionEventInterface lIlIlIlIlIIlIIlIIllIIIIIl() {
            return new com.moonsworth.lunar.client.feature.type.worldedit.bp.IlllllIlIIIlIIlIIllIIlIll();
        }
    },
    llllIIlIIlIIlIIllIIlIIllI {
        public WorldEditActionEventInterface lIlIlIlIlIIlIIlIIllIIIIIl() {
            return new com.moonsworth.lunar.client.feature.type.worldedit.bp.llIIlIlIIIllIlIlIlIIlIIll();
        }
    };

    public static Map IlIlIlllllIlIIlIlIlllIlIl = new EnumMap(IlllIIIIIIlllIlIIlllIlIIl.class);

    IlllIIIIIIlllIlIIlllIlIIl() {
    }

    public abstract WorldEditActionEventInterface lIlIlIlIlIIlIIlIIllIIIIIl();

    public IWorldEditCUIHighlighter IlllIIIIIIlllIlIIlllIlIIl() {
        return (IWorldEditCUIHighlighter)IlIlIlllllIlIIlIlIlllIlIl.get(this);
    }

    static {
        IlIlIlllllIlIIlIlIlllIlIl.put(lIlIlIlIlIIlIIlIIllIIIIIl, new WorldEditCUIRegionHighlighter());
    }
}
