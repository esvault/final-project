package org.example.director;

import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.BuildBarrel;
import org.example.buildEntity.BuildHuman;

import java.util.Random;
public class DirectorRandom {
    String[] animalSpecies = {"kat","dog","cow","snake"};
    String[] animalEyeColor = {"blue","black","gray","green"};
    // String[] animalWool = {"long","short","not","feather"};
    String[] barrelContent = {"long","short","not","feather"};
    String[] barrelMaterial = {"long","short","not","feather"};
    String[] humanGender = {"Apache combat helicopter","male","female","it"};
    String[]  humanSurname = {"long","short","not","feather"};

    Random rand = new Random();
    public void createRandomAnimal(BuildAnimal builder){
            builder.setSpecies(animalSpecies[rand.nextInt(animalSpecies.length)]);
            builder.setEyeColor(animalEyeColor[rand.nextInt(animalEyeColor.length)]);
            // builder.setWool(animalWool[rand.nextInt(animalWool.length)]);
            builder.setWool(rand.nextInt(10) > 5);
    }
    public void createRandomBarrel(BuildBarrel builder) {
            builder.setVolume(rand.nextInt(6));
            builder.setContent(barrelContent[rand.nextInt(barrelContent.length)]);
            builder.setMaterial(barrelMaterial[rand.nextInt(barrelMaterial.length)]);
    }
    public void createRandomHuman(BuildHuman builder) {
            builder.setGender(humanGender[rand.nextInt(humanGender.length)]);
            builder.setAge(rand.nextInt(100));
            builder.setSurname(humanSurname[rand.nextInt(humanSurname.length)]);
    }
}
