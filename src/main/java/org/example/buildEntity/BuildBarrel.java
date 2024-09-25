package org.example.buildEntity;

import org.example.entity.Barrel;

public class BuildBarrel  {
    private int volume;
    private String content;
    private String material;

    public BuildBarrel setVolume(int volume) {
        this.volume = volume;
        return this;
    }

    public BuildBarrel setContent(String content) {
        this.content = content;
        return this;
    }

    public BuildBarrel setMaterial(String material) {
        this.material = material;
        return this;
    }

    public Barrel createBarrel() {
        return new Barrel(volume, content, material);
    }
}
