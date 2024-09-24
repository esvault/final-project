package org.example.model;

import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.BuildBarrel;
import org.example.buildEntity.BuildHuman;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;


//TODO Implement class
public class FileFillStrategy implements FillStrategy {
    private File file;
    public FileFillStrategy(File file)  {
        this.file = file;
    }

    @Override
    public Animal[] fillArrayByAnimals()  {
        BuildAnimal builder = new BuildAnimal();
        var array = mapArrayFromJson();
        Animal[] animals = new Animal[array.length];
        for(int i=0;i<animals.length;i++){
            var temp = (LinkedHashMap<String,String>)array[i];
            builder.setEyeColor(temp.get("eyeColor"));
            builder.setSpecies(temp.get("species"));
            builder.setWool(Boolean.parseBoolean(temp.get("wool")));
            animals[i] = builder.createAnimal();
        }
        return animals;
    }
    @Override
    public Barrel[] fillArrayByBarrels() {
        BuildBarrel builder = new BuildBarrel();
        var array = mapArrayFromJson();
        Barrel[] barrels = new Barrel[array.length];
        for(int i=0;i<barrels.length;i++){
            var temp = (LinkedHashMap)array[i];
            builder.setVolume(Integer.parseInt(temp.get("volume").toString()));
            builder.setContent(temp.get("content").toString());
            builder.setMaterial(temp.get("material").toString());
            barrels[i] = builder.createBarrel();
        }
        return barrels;
    }

    @Override
    public Human[] fillArrayByHumans()  {
        BuildHuman builder = new BuildHuman();
        var array = mapArrayFromJson();
        Human[] humans = new Human[array.length];
        for(int i=0;i<humans.length;i++){
            var temp = (LinkedHashMap)array[i];
            builder.setGender(temp.get("gender").toString());
            builder.setAge(Integer.parseInt(temp.get("age").toString()));
            builder.setSurname(temp.get("surname").toString());
            humans[i] = builder.createHuman();
        }
        return humans;
    }

    private Object[] mapArrayFromJson() {
        List<Object> objectList = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            objectList = Arrays.asList(mapper.readValue(file, Object[].class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return objectList.toArray();
    }
}
