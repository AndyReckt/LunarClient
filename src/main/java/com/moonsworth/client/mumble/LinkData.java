package com.moonsworth.client.mumble;

public final class LinkData {
    public String playerName;
    public String context;
    public MumbleVec avatarFront;
    public MumbleVec avatarTop;
    public MumbleVec avatarPosition;
    public MumbleVec cameraPosition;
    public MumbleVec cameraFront;
    public MumbleVec cameraTop;

    public String getPlayerName() {
        return this.playerName;
    }

    public String getContext() {
        return this.context;
    }

    public MumbleVec getAvatarFront() {
        return this.avatarFront;
    }

    public MumbleVec getAvatarTop() {
        return this.avatarTop;
    }

    public MumbleVec getAvatarPosition() {
        return this.avatarPosition;
    }

    public MumbleVec getCameraPosition() {
        return this.cameraPosition;
    }

    public MumbleVec getCameraFront() {
        return this.cameraFront;
    }

    public MumbleVec getCameraTop() {
        return this.cameraTop;
    }

    public void setPlayerName(String var1) {
        this.playerName = var1;
    }

    public void setContext(String var1) {
        this.context = var1;
    }

    public void setAvatarFront(MumbleVec var1) {
        this.avatarFront = var1;
    }

    public void setAvatarTop(MumbleVec var1) {
        this.avatarTop = var1;
    }

    public void setAvatarPosition(MumbleVec var1) {
        this.avatarPosition = var1;
    }

    public void setCameraPosition(MumbleVec var1) {
        this.cameraPosition = var1;
    }

    public void setCameraFront(MumbleVec var1) {
        this.cameraFront = var1;
    }

    public void setCameraTop(MumbleVec var1) {
        this.cameraTop = var1;
    }

    public LinkData(String var1, String var2, MumbleVec var3, MumbleVec var4, MumbleVec var5, MumbleVec var6, MumbleVec var7, MumbleVec var8) {
        this.playerName = var1;
        this.context = var2;
        this.avatarFront = var3;
        this.avatarTop = var4;
        this.avatarPosition = var5;
        this.cameraPosition = var6;
        this.cameraFront = var7;
        this.cameraTop = var8;
    }
}