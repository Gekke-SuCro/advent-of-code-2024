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

    public int findAmountOfSaveReports(String inputString) {
        List<String> safeLevels = new ArrayList<>();

        for (String row : inputString.split("\n")) {
            row = row.trim();

            int rowCheck = isSafeRow(row);
            if (rowCheck == -1) {
                safeLevels.add(row);
            }
        }

        return safeLevels.size();
    }

    public Calculation calculateLevel(String lastCol, String newCol) {
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

    private int isSafeRow(String rowString) {
        boolean isSafeLevel = true;

        int index = 0;
        String[] rowNumbers = rowString.split(" ");
        Level rowLevel = null;

        int numOfUnsafeLevels = 0;

        for (String col : rowNumbers) {
            if (index >= rowNumbers.length - 1) {
                continue;
            }

            Calculation calculation = calculateLevel(col, rowNumbers[index + 1]);;
            Level level = calculation.level;

            if (index == 0) {
                rowLevel = level;
                System.out.println("Row start: " + col);
            }

            if ((rowLevel != level) || (calculation.distance > 3)) {
                isSafeLevel = false;
                numOfUnsafeLevels++;
            }

            System.out.println(level);
            index++;
        }

        if (isSafeLevel) {
            return -1;
        }

        return numOfUnsafeLevels;
    }

    public static void main(String[] args) {
        String inputFileString = FileUtils.readFileToString("day02/example.txt");
        ReportChecker reportChecker = new ReportChecker();

        int saveReports = reportChecker.findAmountOfSaveReports(inputFileString);
        System.out.println("Save reports: " + saveReports);
    }
}
