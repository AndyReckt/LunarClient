package com.moonsworth.lunar.client.server;

import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import lombok.Getter;

import java.util.List;

@Getter
public class FeaturedServer {
    public String name;
    public String ip;
    public Long ping;
    public boolean supportedOnCurrentVersion;

    public FeaturedServer(String name, String ip, Long ping, List<MinecraftVersion> supportedVersions) {
        this.name = name;
        this.ip = ip;
        this.ping = ping;
        this.supportedOnCurrentVersion = supportedVersions.contains(Bridge.getMinecraftVersion());
    }
}
