package org.example.model;

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
        var array = mapArrayFromJson();
        Animal[] animals = new Animal[array.length];
        for(int i=0;i<animals.length;i++){
            var temp = (LinkedHashMap<String,String>)array[i];
            Animal animal = new Animal(temp.get("species"),temp.get("eyeColor"),Boolean.parseBoolean(temp.get("wool")));
            animals[i] = animal;
        }
        return animals;
    }
    @Override
    public Barrel[] fillArrayByBarrels() {
        var array = mapArrayFromJson();
        Barrel[] barrels = new Barrel[array.length];
        for(int i=0;i<barrels.length;i++){
            var temp = (LinkedHashMap)array[i];
            Barrel barrel = new Barrel(Integer.parseInt(temp.get("volume").toString()),temp.get("content").toString(),temp.get("material").toString());
            barrels[i] = barrel;
        }
        return barrels;
    }

    @Override
    public Human[] fillArrayByHumans()  {
        var array = mapArrayFromJson();
        Human[] humans = new Human[array.length];
        for(int i=0;i<humans.length;i++){
            var temp = (LinkedHashMap)array[i];
            Human human = new Human(temp.get("gender").toString(),Integer.parseInt(temp.get("age").toString()),temp.get("surname").toString());
            humans[i] = human;
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
