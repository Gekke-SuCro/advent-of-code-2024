package com.jaydenroeper.adventOfCode2024.day01;

import com.jaydenroeper.adventOfCode2024.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class LocationFinder {
    List<Integer> leftRowInts;
    List<Integer> rightRowInts;

    public LocationFinder(String inputFile) {
        leftRowInts = new ArrayList<>();
        rightRowInts = new ArrayList<>();
        loadIntRows(inputFile);
    }

    /**
     * Split the two numbers per row into 2 separate and sorted lists.
     * @param input
     */
    private void loadIntRows(String input) {
        input = input.replaceAll(" ", ".");

        for (String row : input.split("\n")) {
            row = row.trim();
            String[] rowSplit = row.split("\\.");
            String leftNumber = rowSplit[0];
            String rightNumber = rowSplit[rowSplit.length-1];

            leftRowInts.add(Integer.parseInt(leftNumber));
            rightRowInts.add(Integer.parseInt(rightNumber));
        }

        leftRowInts = leftRowInts.stream().sorted().toList();
        rightRowInts = rightRowInts.stream().sorted().toList();
    }

    public int findLocationsByDistance() {
        int totalDistance = 0;

        if (leftRowInts.size() == rightRowInts.size()) {
            for (int i = 0; i < leftRowInts.size(); i++) {
                totalDistance += Math.abs(leftRowInts.get(i) - rightRowInts.get(i));
            }
        }

        return totalDistance;
    }

    public int findLocationsBySimilarity() {
        int totalSimilarity = 0;

        int count = 0;
        for (int i = 0; i < leftRowInts.size(); i++) {
            int leftNumber = leftRowInts.get(i);
            for (Integer number : rightRowInts) {
                if (number == leftNumber) {
                    count++;
                }
            }
            totalSimilarity += (leftNumber * count);
            count = 0;
        }

        return totalSimilarity;
    }

    public static void main(String[] args) {
        String inputFileString = FileUtils.readFileToString("day01/input.txt");
        LocationFinder locationFinder = new LocationFinder(inputFileString);

        int totalDistance = locationFinder.findLocationsByDistance();
        int totalSimilarity = locationFinder.findLocationsBySimilarity();

        System.out.println("Total distance: " + totalDistance);
        System.out.println("Total similarity: " + totalSimilarity);
    }
}
