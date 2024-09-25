package org.example.model;

import org.example.director.Director;
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
    private Director director;

    public FileFillStrategy(File file)  {
        this.file = file;
    }

    @Override
    public Animal[] fillArrayByAnimals()  {
        var array = mapArrayFromJson();
        Animal[] animals = new Animal[array.length];

        for(int i=0;i<animals.length;i++){
            var temp = (LinkedHashMap<String,String>)array[i];
            String species = temp.get("species");
            String eyeColor = temp.get("eyeColor");
            boolean wool = Boolean.parseBoolean(temp.get("wool"));

            animals[i] = director.createAnimal(species, eyeColor, wool);
        }
        return animals;
    }
    @Override
    public Barrel[] fillArrayByBarrels() {
        var array = mapArrayFromJson();
        Barrel[] barrels = new Barrel[array.length];

        for(int i=0;i<barrels.length;i++){
            var temp = (LinkedHashMap)array[i];
            int volume = Integer.parseInt(temp.get("volume").toString());
            String content = temp.get("content").toString();
            String material = temp.get("material").toString();

            barrels[i] = director.createBarrel(volume, content, material);
        }
        return barrels;
    }

    @Override
    public Human[] fillArrayByHumans()  {
        var array = mapArrayFromJson();
        Human[] humans = new Human[array.length];

        for(int i=0;i<humans.length;i++){
            var temp = (LinkedHashMap)array[i];
            String gender = temp.get("gender").toString();
            int age = Integer.parseInt(temp.get("age").toString());
            String surname = temp.get("surname").toString();

            humans[i] = director.createHuman(gender, age, surname);
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
