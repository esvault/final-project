package org.example.entity;

//TODO Implement class
public class Barrel implements Comparable<Barrel>, SupportedTypes {
    private final int volume;
    private final String content;
    private final String material;

    public Barrel(int volume, String content, String material) {
        this.volume = volume;
        this.content = content;
        this.material = material;
    }

    public int getVolume() {
        return volume;
    }

    public String getContent() {
        return content;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Barrel{" +
                "volume=" + volume +
                ", content='" + content + '\'' +
                ", material='" + material + '\'' +
                '}';
    }


    @Override
    public int compareTo(Barrel o) {
        return 0;
    }
}
