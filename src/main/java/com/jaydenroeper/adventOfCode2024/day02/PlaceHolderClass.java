package com.jaydenroeper.adventOfCode2024.day02;

import com.jaydenroeper.adventOfCode2024.day01.LocationFinder;
import com.jaydenroeper.adventOfCode2024.utils.FileUtils;

public class PlaceHolderClass {

    public PlaceHolderClass() {

    }

    public String findPlaceHolder() {
        return "Jayden Roeper";
    }

    public static void main(String[] args) {
        String inputFileString = FileUtils.readFileToString("day02/example.txt");
        PlaceHolderClass placeHolderClass = new PlaceHolderClass();

        String holder = placeHolderClass.findPlaceHolder();

        System.out.println("Place Holder: " + holder);
    }
}
