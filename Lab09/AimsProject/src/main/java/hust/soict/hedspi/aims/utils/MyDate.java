/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class MyDate {
    private int day;
    private int month;
    private int year;
    private static Map<String, Integer> map = new HashMap<String, Integer>();
    private static Map<Integer, String> month_map = new HashMap<Integer, String>();
    private static DateTimeFormatter formatter;

    public MyDate() {
        LocalDate date = LocalDate.now();
        day = date.getDayOfMonth();
        month = date.getMonthValue();
        year = date.getYear();
    }

    public MyDate(int day, int month, int year) {
        this(); // Now
        try {
            LocalDate date = LocalDate.parse(day + "/" + month + "/" + year, DateTimeFormatter.ofPattern("[d/M/y]"));
            this.day = date.getDayOfMonth();
            this.month = date.getMonthValue();
            this.year = date.getYear();
        } catch (DateTimeException e) {
            System.out.println("Invalid Date");
        }
    }

    public MyDate(String strDate) {
        this(); // Now
        accept(strDate);
    }

    public MyDate(String day, String month, String year) {
        this(); // Now
        try {
            int intDay = map.get(day.toLowerCase());
            int intMonth = map.get(month.toLowerCase());
            String[] split_year = year.split(" ");
            String strYear = map.get(split_year[0]).toString() + map.get(split_year[1]).toString();
            int intYear = Integer.parseInt(strYear);

            LocalDate date = LocalDate.parse(intDay + "/" + intMonth + "/" + intYear, formatter);
            this.day = date.getDayOfMonth();
            this.month = date.getMonthValue();
            this.year = date.getYear();
        }
        catch (Exception e) {
            System.out.println("Invalid date time!");
        }
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        try {
            LocalDate date = LocalDate.parse(day + "/" + this.month + "/" + this.year, DateTimeFormatter.ofPattern("[d/M/y]"));
            this.day = date.getDayOfMonth();
            this.month = date.getMonthValue();
            this.year = date.getYear();
        } catch (DateTimeException e) {
            System.out.println("Invalid day");
        }
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12)
            this.month = month;
        else
            System.out.println("Invalid month");
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        if (year > 0)
            this.year = year;
        else
            System.out.println("Invalid year");
    }

    public void print() {
        String out = month_map.get(month) + " " + day;
        switch (day) {
            case 1:
            case 21:
            case 31:
                out += "st ";
                break;
            case 2:
            case 12:
            case 22:
                out += "nd ";
                break;
            case 3:
            case 13:
            case 23:
                out += "rd ";
                break;

            default:
                out += "th ";
                break;
        }
        out += year;

        System.out.println("Date: " + out);
    }

    public void accept(String strDate)
    {
        try {
            strDate = strDate.replaceAll("st|nd|rd|th", ""); // Regex for remove 'st', 'nd', 'rd', 'th' from day
            LocalDate date = LocalDate.parse(strDate, formatter);
            day = date.getDayOfMonth();
            month = date.getMonthValue();
            year = date.getYear();
        } catch (DateTimeException e) {
            System.out.println("Invalid Date");
        }
    }

    static {
        // Date format
        String pattern = "[d[/][-][.][ ]M[/][-][.][ ]yyyy]" // 1/1/2021, 1-1-2021, 1.1.2021, 1 1 2021
        + "[d MMM[,] yyyy]" // 1 Jan, 2021
        + "[MMM d[,] yyyy]" // Jan 1, 2021
        + "[MMMM d[,] yyyy]" // January 1, 2021
        + "[ddMMyyyy]"; // 01012021

        formatter = DateTimeFormatter.ofPattern(pattern);

        // Date mapping
        String[] month_s = {"January", "February", "March", "April", "May", "June", "July", "August", "September", 
            "October", "November", "December"}; // 1 -> 12

        String[] day_s = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",
            "eleventh", "twelfth", "thirdteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth",
            "nineteenth", "twenty", "twenty-first", "twenty-second", "twenty-third", "twenty-fourth", "twenty-fifth",
            "twenty-sixth", "twenty-seventh", "twenty-eighth", "twenty-ninth", "thirty", "thirty-first"}; // 1 -> 31

        String[] more_years = {"twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five", "twenty-six",
            "twenty-seven", "twenty-eigth", "twenty-nine"}; // 2020 -> 2030

        for (int i = 0; i < 12; i++) {
            map.put(month_s[i].toLowerCase(), i+1);
            month_map.put(i+1, month_s[i]);
        }

        for (int i = 0; i < 31; i++)
            map.put(day_s[i], i+1);

        for (int i = 0; i < more_years.length; i++)
            map.put(more_years[i], i+21);
    }
}

