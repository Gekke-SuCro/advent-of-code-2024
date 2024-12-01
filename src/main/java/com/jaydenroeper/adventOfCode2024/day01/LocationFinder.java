package com.jaydenroeper.adventOfCode2024.day01;

import com.jaydenroeper.adventOfCode2024.utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationFinder {

    public static void main(String[] args) {
        String inputFileString = FileUtils.readFileToString("day01/input.txt");
        inputFileString = inputFileString.replaceAll(" ", ".");

        List<Integer> leftRowInts = new ArrayList<>();
        List<Integer> rightRowInts = new ArrayList<>();


        for (String row : inputFileString.split("\n")) {
            row = row.trim();
            String[] rowSplit = row.split("\\.");
            String leftNumber = rowSplit[0];
            String rightNumber = rowSplit[rowSplit.length-1];

            leftRowInts.add(Integer.parseInt(leftNumber));
            rightRowInts.add(Integer.parseInt(rightNumber));
        }

        leftRowInts = leftRowInts.stream().sorted().toList();
        rightRowInts = rightRowInts.stream().sorted().toList();

        int totalDiff = 0;

        if (leftRowInts.size() == rightRowInts.size()) {
            for (int i = 0; i < leftRowInts.size(); i++) {
                totalDiff += Math.abs(leftRowInts.get(i) - rightRowInts.get(i));
            }
        }

        System.out.println(leftRowInts);
        System.out.println(rightRowInts);
        System.out.println(totalDiff);
    }
}
