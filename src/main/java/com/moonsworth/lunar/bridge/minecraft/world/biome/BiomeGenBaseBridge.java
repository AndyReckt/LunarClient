package com.moonsworth.lunar.bridge.minecraft.world.biome;

import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 14:14
 */
public interface BiomeGenBaseBridge {
    String bridge$getBiomeName();

    default Optional<Integer> bridge$getBiomeID() {
        return Optional.empty();
    }
}
