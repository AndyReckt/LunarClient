package com.moonsworth.lunar.client.cosmetic.builder;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vector3f;
import com.moonsworth.lunar.client.cosmetic.type.HatCosmetic;
import com.moonsworth.lunar.client.util.CosmeticRotationHelper;

public class HeadwearCosmeticBuilder {

    public static final BiMap<EntityPlayerBridge, HatCosmetic> lIlIlIlIlIIlIIlIIllIIIIIl = ((ImmutableBiMap.Builder) ImmutableBiMap.builder().put("panda", new HatCosmetic("panda", true, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.0f, 0.1f, 0.0f))))).put("frog", new HatCosmetic("frog", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.0f, 0.1f, 0.0f)))).put("pig", new HatCosmetic("pig", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.0f, 0.1f, 0.0f)))).put("koala", new HatCosmetic("koala", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.0f, 0.15f, 0.0f)))).put("lion", new HatCosmetic("lion", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.0f, 0.135f, 0.0f)))).put("penguin", new HatCosmetic("penguin", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.0475f, 0.125f, 0.0f)), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl(new Vector3f(1.035f, 1.035f, 1.035f)))).put("bandanna", new HatCosmetic("bandanna", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.0f, -0.4f, 0.0f)), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(180.0f, 0.0f, 1.0f, 0.0f)).lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(HatCosmetic.Type.BANDANNA)).put("fox", new HatCosmetic("fox", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.0f, -0.4f, 0.0f)))).put("dog", new HatCosmetic("dog", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.0f, -0.4f, 0.0f)), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(180.0f, 1.0f, 0.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.01f, 0.0f, 0.0f)))).put("bunnyears", new HatCosmetic("bunnyears", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, -0.2825f, 0.0f);
        }
        return new Vector3f(0.0f, -0.15f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl(new Vector3f(1.0245f, 1.0245f, 1.0245f))).IllIllIIIllIIIlIlIlIIIIll()).put("mask", ((HatCosmetic) new HatCosmetic("mask", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(180.0f, 1.0f, 0.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, 0.125f, 0.0f);
        }
        return new Vector3f(0.1f, 0.4f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(1.25f, 1.25f, 1.25f);
        }
        return null;
    })).lIIlIlllIlIlIIIlllIIlIIII().IllIllIIIllIIIlIlIlIIIIll().lIlIlIlIlIIlIIlIIllIIIIIl(new String[] {"any"}).lIlIlIlIlIIlIIlIIllIIIIIl("beard_stpatrick").lIlIlIlIlIIlIIlIIllIIIIIl("dragon").lIlIlIlIlIIlIIlIIllIIIIIl("beard")).lIlIlIlIlIIlIIlIIllIIIIIl(HatCosmetic.Type.MASK)).put("dragon", new HatCosmetic("dragon", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.85f, 0.85f, 0.85f);
        }
        return new Vector3f(1.1f, 1.1f, 1.1f);
    }), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.48f, 0.05f);
        }
        return new Vector3f(0.0f, -0.325f, 0.06f);
    }))).put("halloween_mask", ((HatCosmetic) new HatCosmetic("halloween_mask", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.5f, 0.0f);
        }
        return new Vector3f(0.0f, -0.25f, 0.0f);
    })).IllIllIIIllIIIlIlIlIIIIll().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl("mask").lIlIlIlIlIIlIIlIIllIIIIIl("devil_horns", "top_hat_newyears", "witch", "spider", "knife", "top_hat", "halo", "tophats").lIlIlIlIlIIlIIlIIllIIIIIl("beard").lIlIlIlIlIIlIIlIIllIIIIIl("beard_stpatrick")).lIlIlIlIlIIlIIlIIllIIIIIl(HatCosmetic.Type.MASK)).put("pumpkin", new HatCosmetic("pumpkin", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.5f, 0.0f);
        }
        return new Vector3f(0.0f, -0.425f, 0.0f);
    }))).put("witch", new HatCosmetic("witch", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.25f, 0.0f);
        }
        return new Vector3f(0.0f, -0.36f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.65f, 0.65f, 0.65f);
        }
        return new Vector3f(1.1f, 1.1f, 1.1f);
    }))).put("devil_horns", new HatCosmetic("devil_horns", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.0f, -0.5f, 0.0f)))).put("black_devil_horns", new HatCosmetic("black_devil_horns", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(new Vector3f(0.0f, -0.5f, 0.0f)))).put("spider", new HatCosmetic("spider", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.25f, 0.0f);
        }
        return new Vector3f(0.0f, -0.35f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.95f, 0.95f, 0.95f);
        }
        return null;
    }))).put("top_hat", new HatCosmetic("top_hat", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.25f, 0.0f);
        }
        return new Vector3f(0.0f, -0.36f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.65f, 0.65f, 0.65f);
        }
        return null;
    }))).put("knife", new HatCosmetic("knife", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.5f, 0.0f);
        }
        return new Vector3f(0.0f, -0.48f, 0.0f);
    }))).put("paperbag", new HatCosmetic("paperbag", false, CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(1.05f, 1.05f, 1.05f);
        }
        return new Vector3f(1.15f, 1.15f, 1.15f);
    }), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.525f, 0.0f);
        }
        return new Vector3f(0.0f, -0.4f, 0.0f);
    }))).put("chef", new HatCosmetic("chef", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.25f, 0.0f);
        }
        return new Vector3f(0.0f, -0.425f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.7f, 0.7f, 0.7f);
        }
        return null;
    }))).put("legomaestro", new HatCosmetic("legomaestro", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.45f, 0.0f);
        }
        return new Vector3f(0.0f, -0.45f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.7f, 0.7f, 0.7f);
        }
        return null;
    }))).put("enderman", new HatCosmetic("enderman", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.5f, 0.0f);
        }
        return new Vector3f(0.0f, -0.45f, 0.0f);
    }))).put("cowboy", new HatCosmetic("cowboy", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.4f, 0.0f);
        }
        return new Vector3f(0.0f, -0.35f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return null;
        }
        return new Vector3f(1.15f, 1.15f, 1.15f);
    }))).put("crown", new HatCosmetic("crown", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.45f, 0.0f);
        }
        return new Vector3f(0.0f, -0.45f, 0.0f);
    }))).put("wolf", new HatCosmetic("wolf", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.5f, 0.0f);
        }
        return new Vector3f(0.0f, -0.45f, 0.0f);
    }))).put("sombrero", new HatCosmetic("sombrero", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.35f, 0.0f);
        }
        return new Vector3f(0.0f, -0.4f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.7f, 0.7f, 0.7f);
        }
        return new Vector3f(0.935f, 0.935f, 0.935f);
    }))).put("pilgrim", new HatCosmetic("pilgrim", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.25f, 0.0f);
        }
        return new Vector3f(0.0f, -0.36f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.65f, 0.65f, 0.65f);
        }
        return null;
    }))).put("antlers", new HatCosmetic("antlers", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.35f, 0.0f);
        }
        return new Vector3f(0.0f, -0.45f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.65f, 0.65f, 0.65f);
        }
        return null;
    })).IllIllIIIllIIIlIlIlIIIIll()).put("beard", ((HatCosmetic) new HatCosmetic("beard", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(-0.295f, -0.6f, 0.0f);
        }
        return new Vector3f(0.0f, 0.05f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge != null) {
            return new Vector3f(0.95f, 0.95f, 0.95f);
        }
        return null;
    })).lIlIlIlIlIIlIIlIIllIIIIIl(new String[] {"any"}).lIlIlIlIlIIlIIlIIllIIIIIl("beard_stpatrick").lIlIlIlIlIIlIIlIIllIIIIIl("halloween_mask").lIlIlIlIlIIlIIlIIllIIIIIl("mask").lIlIlIlIlIIlIIlIIllIIIIIl("dragon")).IllIllIIIllIIIlIlIlIIIIll()).put("bee", new HatCosmetic("bee", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.15f, 0.0f);
        }
        return new Vector3f(0.0f, -0.3f, 0.0f);
    }))).put("elf", new HatCosmetic("elf", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.1f, 0.0f);
        }
        return new Vector3f(0.0f, -0.35f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.85f, 0.85f, 0.85f);
        }
        return null;
    }))).put("ghast", new HatCosmetic("ghast", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.35f, 0.0f);
        }
        return new Vector3f(0.0f, -0.3f, 0.0f);
    }))).put("kitten", new HatCosmetic("kitten", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.25f, 0.0f);
        }
        return new Vector3f(0.0f, -0.3f, 0.0f);
    }))).put("santa", new HatCosmetic("santa", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.275f, 0.0f);
        }
        return new Vector3f(0.0f, -0.35f, 0.0f);
    })).lIlIlIlIlIIlIIlIIllIIIIIl(new String[] {"beard"})).put("chimney", new HatCosmetic("chimney", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.8f, 0.8f, 0.8f);
        }
        return null;
    }), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.15f, 0.0f);
        }
        return new Vector3f(0.0f, -0.35f, 0.0f);
    }))).put("xmaslights", new HatCosmetic("xmaslights", true, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.4f, 0.0f);
        }
        return new Vector3f(0.0f, -0.4f, 0.0f);
    }))).put("nutcracker", new HatCosmetic("nutcracker", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.8f, 0.8f, 0.8f);
        }
        return null;
    }), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.3f, 0.0f);
        }
        return new Vector3f(0.0f, -0.35f, 0.0f);
    }))).put("top_hat_newyears", new HatCosmetic("top_hat_newyears", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.25f, 0.0f);
        }
        return new Vector3f(0.0f, -0.36f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.65f, 0.65f, 0.65f);
        }
        return null;
    }))).put("halo", new HatCosmetic("halo", true, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(180.0f, 1.0f, 0.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, 0.6f, 0.0f);
        }
        return new Vector3f(0.0f, 0.425f, 0.0f);
    })).lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(new String[] {"bandanna"})).put("cat_ears", new HatCosmetic("cat_ears", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, -0.4f, 0.0f);
        }
        return new Vector3f(0.0f, -0.35f, 0.0f);
    }))).put("gaming_headset", new HatCosmetic("gaming_headset", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, -0.35f, 0.15f);
        }
        return new Vector3f(0.0f, -0.45f, 0.15f);
    })).lIIlIlllIlIlIIIlllIIlIIII()).put("heartband", new HatCosmetic("heartband", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, -0.5f, 0.0f);
        }
        return new Vector3f(0.0f, -0.45f, 0.0f);
    })).IllIllIIIllIIIlIlIlIIIIll()).put("cute_cat_ears", new HatCosmetic("cute_cat_ears", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.25f, 0.0f);
        }
        return new Vector3f(0.0f, -0.4215f, 0.1f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(1.5f, 1.5f, 1.5f);
        }
        return new Vector3f(0.95f, 0.95f, 0.95f);
    })).lIIlIlllIlIlIIIlllIIlIIII()).put("tophats", new HatCosmetic("tophats", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.25f, 0.0f);
        }
        return new Vector3f(0.0f, -0.36f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.65f, 0.65f, 0.65f);
        }
        return null;
    })).lIIlIlllIlIlIIIlllIIlIIII()).put("beard_stpatrick", ((HatCosmetic) new HatCosmetic("beard_stpatrick", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.4f, 0.0f);
        }
        return new Vector3f(0.0f, 0.125f, 0.2f);
    })).lIlIlIlIlIIlIIlIIllIIIIIl(new String[] {"any"}).lIlIlIlIlIIlIIlIIllIIIIIl("mask").lIlIlIlIlIIlIIlIIllIIIIIl("beard").lIlIlIlIlIIlIIlIIllIIIIIl("halloween_mask").lIlIlIlIlIIlIIlIIllIIIIIl("dragon")).IllIllIIIllIIIlIlIlIIIIll()).put("potofgold", new HatCosmetic("potofgold", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge == null) {
            return new Vector3f(0.0f, -0.35f, 0.0f);
        }
        return new Vector3f(0.0f, -0.3f, 0.0f);
    }))).put("cloverheadband", new HatCosmetic("cloverheadband", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, -0.4f, 0.0f);
        }
        return new Vector3f(0.0f, -0.4f, -0.05f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl(new Vector3f(0.95f, 0.95f, 0.95f))).IllIllIIIllIIIlIlIlIIIIll()).put("lunarbunnyears", new HatCosmetic("lunarbunnyears", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, -0.405f, 0.0f);
        }
        return new Vector3f(0.0f, -0.35f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl(new Vector3f(0.925f, 0.925f, 0.925f))).IllIllIIIllIIIlIlIlIIIIll()).put("bunnyhat", new HatCosmetic("bunnyhat", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, -0.35f, 0.0f);
        }
        return new Vector3f(0.0f, -0.45f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(0.875f, 0.875f, 0.875f);
        }
        return null;
    }))).put("pirate", new HatCosmetic("pirate", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, -0.45f, 0.0f);
        }
        return new Vector3f(0.0f, -0.45f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl(new Vector3f(0.98f, 0.98f, 0.98f)))).put("rose_crown", new HatCosmetic("rose_crown", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(90.0f, 0.0f, 1.0f, 0.0f), CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.02f, -0.35f, 0.0f);
        }
        return new Vector3f(0.0f, -0.5f, 0.0f);
    }))).build();
}
