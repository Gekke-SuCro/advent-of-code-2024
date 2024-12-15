package com.jaydenroeper.adventOfCode2024.day02;

import com.jaydenroeper.adventOfCode2024.day01.LocationFinder;
import com.jaydenroeper.adventOfCode2024.utils.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportChecker {

    public ReportChecker() {

    }

    public int findAmountOfSaveReports() {
        int saveReports = 0;
        return saveReports;
    }

    public Calculation calcuateLevel(String lastCol, String newCol) {
        int colInt = Integer.parseInt(lastCol);
        int nextColInt = Integer.parseInt(newCol);
        int distance = Math.abs(colInt - nextColInt);

        Calculation calculation = new Calculation();
        calculation.distance = distance;

        if (colInt > nextColInt) {
            calculation.level = Level.DECREASING;
        } else if (colInt < nextColInt) {
            calculation.level = Level.INCREASING;
        } else {
            calculation.level = Level.NEUTRAL;
        }

        return calculation;
    }

    public static void main(String[] args) {
        String inputFileString = FileUtils.readFileToString("day02/input.txt");
        ReportChecker reportChecker = new ReportChecker();

//        int saveReports = reportChecker.findAmountOfSaveReports();
//
//        System.out.println("Save reports: " + saveReports);

        List<String> safeLevels = new ArrayList<>();

        for (String row : inputFileString.split("\n")) {
            row = row.trim();
            boolean levelIsSafe = true;

            int index = 0;
            String[] rowNumbers = row.split(" ");
            Level rowLevel = null;
            for (String col : rowNumbers) {
                if (index >= rowNumbers.length - 1) {
                    continue;
                }

                Calculation calculation = reportChecker.calcuateLevel(col, rowNumbers[index + 1]);;
                Level level = calculation.level;

                if (index == 0) {
                    rowLevel = level;
                    System.out.println("Row start: " + col);
                }

                if (rowLevel != level) {
                    levelIsSafe = false;
                }
                System.out.println(level);

                if (calculation.distance > 3) {
                    levelIsSafe = false;
                }
                index++;
            }
            if (levelIsSafe) {
                safeLevels.add(row);
            }
        }

        System.out.println(safeLevels.size());
    }
}
