package org.example;

import org.example.model.RandomFillStrategy;
import org.example.model.UserFillStrategy;
import org.example.ui.Console;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       // (new Console()).runMainLoop();
UserFillStrategy FillStrategy = new UserFillStrategy();
        System.out.println(Arrays.toString(
        FillStrategy.fillArrayByAnimals()));

    }
}