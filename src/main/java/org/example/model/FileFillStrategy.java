package org.example.model;

import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;


//TODO Implement class
public class FileFillStrategy implements FillStrategy {
    private String file;
    private int size;

    public FileFillStrategy(String file, int size){
        this.file=file;
        this.size = size;
    }


    @Override
    public Animal[] fillArrayByAnimals() {

        Animal[] animals = new Animal[size];
        var array = fillArray();

        for(int i=0;i<animals.length;i++){
            var temp = (LinkedHashMap<String,String>)array[i];
            Animal animal = new Animal(temp.get("species"),temp.get("eyeColor"),temp.get("wool"));
//            animal.setSpecies();
//            animal.setEyeColor();
//            animal.setWool();
            animals[i] = animal;
        }
        return animals;
    }

    @Override
    public Barrel[] fillArrayByBarrels() {

        return null;
    }
    @Override
    public Human[] fillArrayByHumans() {

        return null;
    }

    private Object[] fillArray(){

        File f = new File(file);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        try {
            var objectList = Arrays.asList(mapper.readValue(f, Object[].class));
            return objectList.toArray();
        } catch (JsonProcessingException e) {
            // TODO обработка исключения
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
