package org.example.buildEntity;

import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;

public interface ObjectFactory {
    Animal createAnimal();
    Barrel createBarrel();
    Human createHuman();
}
