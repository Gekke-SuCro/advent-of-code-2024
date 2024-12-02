package com.jaydenroeper.adventOfCode2024.day02;

import com.jaydenroeper.adventOfCode2024.day01.LocationFinder;
import com.jaydenroeper.adventOfCode2024.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class ReportChecker {

    public ReportChecker() {

    }

    public int findAmountOfSaveReports() {
        int saveReports = 0;
        return saveReports;
    }

    public static void main(String[] args) {
        String inputFileString = FileUtils.readFileToString("day02/example.txt");
        ReportChecker reportChecker = new ReportChecker();

//        int saveReports = reportChecker.findAmountOfSaveReports();
//
//        System.out.println("Save reports: " + saveReports);

        List<String> safeLevels = new ArrayList<>();

        Level level = Level.NEUTRAL;
        for (String row : inputFileString.split("\n")) {
            row = row.trim();
            String lastCol = row.substring(0, 1).trim();
            boolean levelIsSafe = true;

            String subRow = row.substring(1).trim();
            for (String col : subRow.split(" ")) {
                col = col.trim();
                System.out.println(col);

                int lastColInt = Integer.parseInt(lastCol);
                int currColInt = Integer.parseInt(col);
                Level lastLevel = level;

                if (lastColInt > currColInt) {
                    level = Level.DECREASING;
                } else if (lastColInt < currColInt) {
                    level = Level.INCREASING;
                } else {
                    level = Level.NEUTRAL;
                }

                levelIsSafe = (lastLevel == level);
                lastCol = col;
            }

            if (levelIsSafe) {
                safeLevels.add(row);
            }
        }

        System.out.println(safeLevels);
    }
}
