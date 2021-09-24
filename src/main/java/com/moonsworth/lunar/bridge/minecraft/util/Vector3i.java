package com.moonsworth.lunar.bridge.minecraft.util;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Vector3i {
    public final int x;
    public final int y;
    public final int z;
}