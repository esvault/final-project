package org.example.director;


import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.BuildBarrel;
import org.example.buildEntity.BuildHuman;


import java.util.LinkedHashMap;

public class DirectorFile {
    private int index =0;
    private Object[] array ;
    public DirectorFile(Object[] arr)  {
        array =arr;
    }

    public void createAnimal(BuildAnimal builder){
        var temp = (LinkedHashMap<String,String>)array[index];
        builder.setEyeColor(temp.get("eyeColor"));
        builder.setSpecies(temp.get("species"));
        builder.setWool(Boolean.parseBoolean(temp.get("wool")));
        index++;
    }
    public void createBarrel(BuildBarrel builder) {
        var temp = (LinkedHashMap)array[index];
        builder.setVolume(Integer.parseInt(temp.get("volume").toString()));
        builder.setContent(temp.get("content").toString());
        builder.setMaterial(temp.get("material").toString());
        index++;
    }
    public void createHuman(BuildHuman builder) {
        var temp = (LinkedHashMap)array[index];
        builder.setGender(temp.get("gender").toString());
        builder.setAge(Integer.parseInt(temp.get("age").toString()));
        builder.setSurname(temp.get("surname").toString());
        index++;
    }

}
