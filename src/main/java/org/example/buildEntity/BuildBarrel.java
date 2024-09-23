package org.example.buildEntity;

import org.example.entity.Barrel;

public class BuildBarrel  {
    private int volume;
    private String content;
    private String material;

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Barrel createBarrel() {
        return new Barrel(volume, content, material);
    }
}
