package com.example.apachedatevalidator.util;

import java.util.HashSet;
import java.util.Set;

public class DateValidator {


    private static Set<String> dates = new HashSet<>();

    static {
        for (int year = 1900; year < 2050; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= daysInMonth(year, month); day++) {
                    StringBuilder date = new StringBuilder();
                    date.append(String.format("%04d", year));
                    date.append(String.format("%02d", month));
                    date.append(String.format("%02d", day));
                    dates.add(date.toString());
                }
            }
        }
    }


    private static int daysInMonth(int year, int month) {
        int daysInMonth;
        switch (month) {
            case 1: // fall through
            case 3: // fall through
            case 5: // fall through
            case 7: // fall through
            case 8: // fall through
            case 10: // fall through
            case 12:
                daysInMonth = 31;
                break;
            case 2:
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                // returns 30 even for nonexistant months
                daysInMonth = 30;
        }
        return daysInMonth;
    }


    public static boolean isValidDate(String dateString) {
        //dates.forEach(System.out::println);
        System.out.println("Printing date String: " +dateString);
        dateString=dateString.replaceAll("-","").trim();
        System.out.println("Printing cleaned date string : "+dateString);
        //set.forEach(System.out::println);
        return dates.contains(dateString);
    }



}
