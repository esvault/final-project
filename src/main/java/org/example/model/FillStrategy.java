package org.example.model;

import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;

public interface FillStrategy {
    Animal[] fillArrayByAnimals();
    Barrel[] fillArrayByBarrels();
    Human[] fillArrayByHumans();
}
