package com.moonsworth.lunar.client.feature.type.hologram;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public final class Hologram {
    public final UUID uuid;
    @Setter
    public String[] lines;
    public final double x;
    public final double y;
    public final double z;
}
