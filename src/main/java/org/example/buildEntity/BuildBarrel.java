package org.example.buildEntity;

import org.example.entity.Barrel;

public class BuildBarrel implements Builder {
    private int volume;
    private String content;
    private String material;


    @Override
    public void setFirstParam(String volume) {
        this.volume = Integer.parseInt(volume);
    }

    @Override
    public void setSecondParam(String content) {
        this.content = content;
    }

    @Override
    public void setLastParam(String material) {
        this.material = material;
    }

    public Barrel createBarrel() {
        return new Barrel(volume, content, material);
    }
}
