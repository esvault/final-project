package org.example.model;

import org.example.buildEntity.Director;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.utils.Validator;

import java.io.File;
import java.util.*;


//TODO Implement class
public class FileFillStrategy implements FillStrategy {
    private File file;
    private Director director = new Director();;

    public FileFillStrategy()  {
        Scanner sc = new Scanner(System.in);
        boolean isNotFound = true;
        String filePath = null;
        File file = null;
        while (isNotFound){
            System.out.println("Введите путь к файлу");
            filePath = sc.next();
            file = new File(filePath);
            if(!file.exists()){
                System.out.println("Файл не найден, попробуйте другой");
                continue;
            }
            isNotFound = false;
        }
        this.file = file;
    }

    @Override
    public Animal[] fillArrayByAnimals()  {
        var array = mapArrayFromJson();
        ArrayList<Animal> animals= new ArrayList<>();

        for(int i=0; i < array.length; i++){
            var temp = (LinkedHashMap<String,String>)array[i];
            String species = temp.get("species");
            String eyeColor = temp.get("eyeColor");
            boolean wool = Boolean.parseBoolean(temp.get("wool"));

            if(!Validator.containsOnlyLetters(species) ||
                !Validator.containsOnlyLetters(eyeColor) ||
                ! Validator.validateBoolean(String.valueOf(wool))){
                continue;
            }
            else{
                animals.add(director.createAnimal(species, eyeColor, wool));
            }
        }
        Animal[] result = new Animal[animals.size()];
        return animals.toArray(result);
    }
    @Override
    public Barrel[] fillArrayByBarrels() {
        var array = mapArrayFromJson();
        ArrayList<Barrel> barrels= new ArrayList<>();

        for(int i=0; i<array.length;i++){
            var temp = (LinkedHashMap)array[i];
            int volume = Integer.parseInt(temp.get("volume").toString());
            String content = temp.get("content").toString();
            String material = temp.get("material").toString();

            if(!Validator.validateVolume(String.valueOf(volume)) ||
                !Validator.containsOnlyLetters(content) ||
                !Validator.containsOnlyLetters(material)){
                continue;
            }
            else {
                barrels.add(director.createBarrel(volume, content, material));
            }
        }
        Barrel[] result = new Barrel[barrels.size()];
        return barrels.toArray(result);
    }

    @Override
    public Human[] fillArrayByHumans()  {
        var array = mapArrayFromJson();
        ArrayList<Human> humans = new ArrayList<>();

        for(int i=0; i<array.length; i++){
            var temp = (LinkedHashMap)array[i];
            String gender = temp.get("gender").toString();
            int age = Integer.parseInt(temp.get("age").toString());
            String surname = temp.get("surname").toString();

            if(!Validator.containsOnlyLetters(gender) ||
                !Validator.validateAge(String.valueOf(age)) ||
                !Validator.validateSurname(surname)){
                continue;
            }
            else{
                humans.add(director.createHuman(gender, age, surname)) ;
            }
        }
        Human[] result= new Human[humans.size()];
        return humans.toArray(result);
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
