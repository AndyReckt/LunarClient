package com.moonsworth.lunar.bridge.minecraft.world.biome;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import org.apache.commons.lang3.text.WordUtils;

import javax.annotation.Nullable;
import java.util.Optional;

public enum BiomeType {
    lIlIlIlIlIIlIIlIIllIIIIIl("ocean", 0),
    IlllIIIIIIlllIlIIlllIlIIl("plains", 1),
    lIllIlIIIlIIIIIIIlllIlIll("desert", 2),
    llIlllIIIllllIIlllIllIIIl("mountains", 3),
    llllIIlIIlIIlIIllIIlIIllI("forest", 4),
    IlIlIlllllIlIIlIlIlllIlIl("taiga", 5),
    llIIIIIIIllIIllIlIllIIIIl("swamp", 6),
    lIIIllIllIIllIlllIlIIlllI("river", 7),
    IlllllIlIIIlIIlIIllIIlIll("nether_wastes", 8),
    llIIlIlIIIllIlIlIlIIlIIll("the_end", 9),
    llIIIlllIIlllIllllIlIllIl("frozen_ocean", 10),
    lllllIllIllIllllIlIllllII("frozen_river", 11),
    lllIIIIIlllIIlIllIIlIIIlI("snowy_tundra", 12),
    lIlIIIIIIlIIIllllIllIIlII("snowy_mountains", 13),
    llIlIIIllIIlIllIllIllllIl("mushroom_fields", 14),
    IllIllIIIllIIIlIlIlIIIIll("mushroom_field_shore", 15),
    IIlIllIlllllllIIlIIIllIIl("beach", 16),
    lIIlIlllIlIlIIIlllIIlIIII("desert_hills", 17),
    llIllIlIllIlllIllIIIIllII("wooded_hills", 18),
    IllllllllllIlIIIlllIlllll("taiga_hills", 19),
    lllllIllIlIIlIIlIIIlllIlI("mountain_edge", 20),
    IllIIIlllIIIlIlllIlIIlIII("jungle", 21),
    IIlIllIlIIllIIlIlIllllllI("jungle_hills", 22),
    lIIIlllIIIIllllIlIIIlIIll("jungle_edge", 23),
    llIIIlIllIIIIlIIIlIlIllIl("deep_ocean", 24),
    llllIlIllllIlIlIIIllIlIlI("stone_shore", 25),
    IlIllIIlIIlIIIllIllllIIll("snowy_beach", 26),
    lIllllIllIIlIIlIIIlIIIlII("birch_forest", 27),
    lIlIlIIIIIIllIlIIIIllIIII("birch_forest_hills", 28),
    lIIlIIIIIIlIIlIIllIlIIlII("dark_forest", 29),
    IlIIlIIlIIlIIllIIIllIIllI("snowy_taiga", 30),
    IIlIlIIIllIIllllIllllIlIl("snowy_taiga_hills", 31),
    lllllIIIIlIlllIllIIIlIIlI("giant_tree_taiga", 32),
    IIlllIllIlIllIllIIllIlIIl("giant_tree_taiga_hills", 33),
    lIlIIlIlllIIlIIIlIlIlIllI("wooded_mountains", 34),
    lIIlllIIIIIlllIIIlIlIlllI("savanna", 35),
    IIIlIIIIIIllIIIIllIIIIlII("savanna_plateau", 36),
    IlIIIlIlIlIlIlIllIIllIIlI("badlands", 37),
    IlIlIllIIllllIllllllIIlIl("wooded_badlands_plateau", 38),
    lIIlIIlllIIIIlIlllIIIIlll("badlands_plateau", 39),
    llIllIIIIlIIIIIIlllIllIlI("small_end_islands", 40),
    lIlIIIIIllIIlIIlIIlIlIIlI("end_midlands", 41),
    IIllIlIllIlIllIllIllIllII("end_highlands", 42),
    IlIlllIlIlllIllIIIIIIlllI("end_barrens", 43),
    llllIlIlIIIllllIIlIllIlII("warm_ocean", 44),
    llIIIllllIIIllIIIIlIlIlll("lukewarm_ocean", 45),
    IIIIIIIIIIIIIIIllllIIlIIl("cold_ocean", 46),
    llIIIIllIlIIlIlIIlllIllIl("deep_warm_ocean", 47),
    IIIIlIllIllIlIIIIIlIlIlIl("deep_lukewarm_ocean", 48),
    IlIlIlIlIIIlIIlIIlllIllIl("deep_cold_ocean", 49),
    lIIIlIllllIIlIIlIIlIIIIlI("deep_frozen_ocean", 50),
    lllllIlIllIlIlllIIIlIIlIl("the_void", 127),
    IllIlIIllIIlllIIllIlIlIII("sunflower_plains", 129),
    IlIlllIIIIIllIIllIllIIlll("desert_lakes", 130),
    IllllIIllllIllIIIIlllllII("gravelly_mountains", 131),
    IIllllIIlllIlIIlIIlllIlII("flower_forest", 132),
    IllIlIIlllIIlIIllIIIIIIIl("taiga_mountains", 133),
    IllIllIllIIlIlllIIlllIIll("swamp_hills", 134),
    IlIIIIlllIllllIlIlIllIlII("ice_spikes", 140),
    lIlIIIlIIlIIIlIIIlllIlIII("modified_jungle", 149),
    IlIllIIlIIlIlIIlIIlIllIll("modified_jungle_edge", 151),
    lIlllllIIlllIllIIlIIlIlll("tall_birch_forest", 155),
    lIIlIIllIlIIlIIllIIIIlIIl("tall_birch_hills", 156),
    IllIIlllIllIlllllIlIllIll("dark_forest_hills", 157),
    IIIlIlIllIlIlIIIIIlIllIII("snowy_taiga_mountains", 158),
    IIlllIllIIlllllIllllllIII("giant_spruce_taiga", 160),
    IlIlIIllllllIIlIIllIIllIl("giant_spruce_taiga_hills", 161),
    IIllIIlIIIlIlIlIlIIllIllI("modified_gravelly_mountains", 162),
    llIllllIlIIlIIIIllIllIIll("shattered_savanna", 163),
    lIllIllIllIIIlllIIIlllllI("shattered_savanna_plateau", 164),
    IlIIlllIIllIIlIlIlIlIIlll("eroded_badlands", 165),
    IlllIIIlIllIIIlIIllllllIl("modified_wooded_badlands_plateau", 166),
    lllIIIIllIllIlIIlllIIllII("modified_badlands_plateau", 167),
    IlllllIlIlIlIIIIIllllIlIl("bamboo_jungle", 168),
    lIIllllIllIllllllllIlllII("bamboo_jungle_hills", 169),
    lIlIIllIIIlIIIlIIIlIIlIll("soul_sand_valley"),
    llllIIlIllllllIIllIllIlII("crimson_forest"),
    IIlIIIlIlIlIlIllIlIlIIlll("warped_forest"),
    IIIIlIIlIIIIllIlIlIIIlIlI("basalt_deltas");

    public static final Int2ObjectMap<BiomeType> lIIIlIlIlIIlIllIIIIlllIlI = new Int2ObjectArrayMap<>(lIlIIllIIIlIIIlIIIlIIlIll.ordinal());
    public static final Object2IntMap<BiomeGenBaseBridge> IIllIlIIllIIlIIllllIIllII = new Object2IntArrayMap<>(values().length);
    public final String lIIIIIlIIIlIIIlIIlIIIIIlI;
    public final String lIlllIlllIIIllIIIIIlIIllI;
    public final Integer IIIIlIIIIIllllIlllllllIIl;

    BiomeType(String var3) {
        this(var3, null);
    }

    BiomeType(String var3, Integer var4) {
        this.lIIIIIlIIIlIIIlIIlIIIIIlI = WordUtils.capitalize(var3.replace("_", " "), (char[])null);
        this.lIlllIlllIIIllIIIIIlIIllI = var3;
        this.IIIIlIIIIIllllIlllllllIIl = var4;
    }

    public Optional<Integer> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return Optional.ofNullable(this.IIIIlIIIIIllllIlllllllIIl);
    }

    public static BiomeType lIlIlIlIlIIlIIlIIllIIIIIl(@Nullable BiomeGenBaseBridge var0) {
        if (var0 == null) {
            return IlllIIIIIIlllIlIIlllIlIIl;
        } else {
            int var1 = IIllIlIIllIIlIIllllIIllII.getInt(var0);
            if (var1 != -1) {
                return values()[var1];
            } else {
                Optional<Integer> var2 = var0.bridge$getBiomeID();
                if (var2.isPresent()) {
                    BiomeType var3 = lIIIlIlIlIIlIllIIIIlllIlI.get(var2.get());
                    if (var3 != null) {
                        IIllIlIIllIIlIIllllIIllII.put(var0, var3.ordinal());
                        return var3;
                    }
                }

                BiomeType[] var7 = values();
                int var4 = var7.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    BiomeType var6 = var7[var5];
                    if (var0.bridge$getBiomeName().equals("minecraft:" + var6.lIlllIlllIIIllIIIIIlIIllI)) {
                        IIllIlIIllIIlIIllllIIllII.put(var0, var6.ordinal());
                        return var6;
                    }
                }

                return IlllIIIIIIlllIlIIlllIlIIl;
            }
        }
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIIIIIlIIIlIIIlIIlIIIIIlI;
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlllIlllIIIllIIIIIlIIllI;
    }

    static {
        IIllIlIIllIIlIIllllIIllII.defaultReturnValue(-1);
        BiomeType[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            BiomeType var3 = var0[var2];
            if (var3.IIIIlIIIIIllllIlllllllIIl != null) {
                lIIIlIlIlIIlIllIIIIlllIlI.put(var3.IIIIlIIIIIllllIlllllllIIl, var3);
            }
        }

    }
}