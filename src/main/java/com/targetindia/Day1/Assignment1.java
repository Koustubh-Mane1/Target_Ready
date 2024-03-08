package com.targetindia.Day1;


import java.util.Scanner;


public class Assignment1 {
    private static boolean isLeap(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private static int getFirstDay(int firstDay, int firstYear,int firstMonth, int year,  int month, int[] dayCount, int getDay) {
        while (firstDay != 1 || firstYear != year || firstMonth != month) {
            if (isLeap(firstYear)) {
                dayCount[1] = 29;
            } else {
                dayCount[1] = 28;
            }

            firstDay++;
            getDay++;

            if (firstDay > dayCount[firstMonth - 1]) {
                firstMonth++;
                firstDay = 1;
            }

            if (firstMonth > 12) {
                firstMonth = 1;
                firstYear++;
            }
            if (getDay == 7) {
                getDay = 0;
            }
        }
        return getDay;
    }

    private static void check(int month, int year) {
        if (month > 12 || month < 1) {
            System.out.println("Invalid Month");
            System.exit(1);
        }
        if (year < 1) {
            System.out.println("Invalid Year");
            System.exit(1);
        }
    }

    private static void printHelper(int month, String[] dayName, int[] dayCount, int getDay) {
        for (int i = 0; i < 7; i++) {
            System.out.print("   " + dayName[i]);
        }
        System.out.println();
        for (int i = 1; i <= (dayCount[month - 1] + getDay); i++) {
            if (i > 6) {
                getDay = getDay % 6;
            }
        }
        int gap = getDay;
        if (gap < 0)
            gap = 6;

        for (int i = 0; i < gap; i++)
            System.out.print("      ");

        for (int i = 1; i <= dayCount[month - 1]; i++) {
            System.out.printf(" %4d ", i);

            if ((i + gap) % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static void printCalender(int month, int year) {
        check(month, year);

        String[] dayName = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};

        int[] dayCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int getDay = 1;

        int firstDay = 1;
        int firstYear = 1;
        int firstMonth = 1;
        
        getDay = getFirstDay(firstDay, firstYear,firstMonth, year , month, dayCount, getDay);

        if (isLeap(year)) {
            dayCount[1] = 29;
        } else {
            dayCount[1] = 28;
        }

        printHelper(month, dayName, dayCount, getDay);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Year: ");
        int year = sc.nextInt();

        System.out.print("Enter Month: ");
        int month = sc.nextInt();

        printCalender(month, year);
    }
}
