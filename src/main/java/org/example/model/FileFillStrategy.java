package org.example.model;

import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.BuildBarrel;
import org.example.buildEntity.BuildHuman;
import org.example.director.DirectorFile;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.*;


//TODO Implement class
public class FileFillStrategy implements FillStrategy {
    private File file;
    private DirectorFile directorFile ;
    public FileFillStrategy(File file)  {
        this.file = file;
    }

    @Override
    public Animal[] fillArrayByAnimals()  {
        var array = mapArrayFromJson();
        directorFile =  new DirectorFile(array);
        BuildAnimal builder = new BuildAnimal();
        Animal[] animals = new Animal[array.length];
        for(int i=0;i<array.length;i++){
            directorFile.createAnimal(builder);
            animals[i] = builder.createAnimal();
        }
        return animals;
    }
    @Override
    public Barrel[] fillArrayByBarrels() {
        var array = mapArrayFromJson();
        directorFile =  new DirectorFile(array);
        BuildBarrel builder = new BuildBarrel();
        Barrel[] barrels = new Barrel[array.length];

        for(int i=0;i<array.length;i++){
            directorFile.createBarrel(builder);
            barrels[i] = builder.createBarrel();
        }
        return barrels;
    }

    @Override
    public Human[] fillArrayByHumans()  {
        var array = mapArrayFromJson();
        directorFile =  new DirectorFile(array);
        BuildHuman builder = new BuildHuman();
        Human[] humans = new Human[array.length];

        for(int i=0;i<humans.length;i++){
            directorFile.createHuman(builder);
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
