package hust.soict.hedspi.aims.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;
import java.util.*;

public class MyDate {

	private int day;
    private int month;
    private int year;
    private static Map<String, Integer> map = new HashMap<String, Integer>();
    private static Map<Integer, String> month_map = new HashMap<Integer, String>();
    private static HashMap<String, Integer> numbers= new HashMap<String, Integer>();
    private static DateTimeFormatter formatter;

    public MyDate() {
        LocalDate date = LocalDate.now();
        this.day = date.getDayOfMonth();
        this.month = date.getMonthValue();
        this.year = date.getYear();
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
            String strYearFirst = numbers.get(split_year[0]).toString();
            String strYearSecond = numbers.get(split_year[1]).toString();
            
            if (strYearSecond.equals("100")) {
            	strYearFirst += "00";
            }
            else if (strYearSecond.equals("1000")) {
            	strYearFirst += "000";
            } else {
            	strYearFirst += strYearSecond;
            }
            int intYear = Integer.parseInt(strYearFirst);

            this.day = intDay;
            this.month = intMonth;
            this.year = intYear;
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
                out += "st ";
                break;
            case 2:
                out += "nd ";
                break;
            case 3:
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
        String pattern = "[d[/][-][.][ ]M[/][-][.][ ]yyyy]"
        + "[d MMM[,] yyyy]"
        + "[MMM d[,] yyyy]"
        + "[MMMM d[,] yyyy]"
        + "[ddMMyyyy]";

        formatter = DateTimeFormatter.ofPattern(pattern);

        // Date mapping
        String[] month_s = {"January", "February", "March", "April", "May", "June", "July", "August", "September", 
            "October", "November", "December"}; // 1 -> 12

        String[] day_s = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",
            "eleventh", "twelfth", "thirdteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth",
            "nineteenth", "twenty", "twenty-first", "twenty-second", "twenty-third", "twenty-fourth", "twenty-fifth",
            "twenty-sixth", "twenty-seventh", "twenty-eighth", "twenty-ninth", "thirty", "thirty-first"}; // 1 -> 31

        String[] more_years = {"twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five", "twenty-six",
            "twenty-seven", "twenty-eigth", "twenty-nine","hundred"}; // 2021 -> 2030

        for (int i = 0; i < 12; i++) {
            map.put(month_s[i].toLowerCase(), i+1);
            month_map.put(i+1, month_s[i]);
        }

        for (int i = 0; i < 31; i++) {
        	map.put(day_s[i], i+1);
        }
            

        for (int i = 0; i < more_years.length; i++) {
        	map.put(more_years[i], i+21);
        }
        
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);
        numbers.put("eleven", 11);
        numbers.put("twelve", 12);
        numbers.put("thirteen", 13);
        numbers.put("fourteen", 14);
        numbers.put("fifteen", 15);
        numbers.put("sixteen", 16);
        numbers.put("seventeen", 17);
        numbers.put("eighteen", 18);
        numbers.put("nineteen", 19);


        numbers.put("twenty", 20);
        numbers.put("thirty", 30);
        numbers.put("fourty", 40);
        numbers.put("fifty", 50);
        numbers.put("sixty", 60);
        numbers.put("seventy", 70);
        numbers.put("eighty", 80);
        numbers.put("ninety", 90);

        numbers.put("hundred", 100);
        numbers.put("thousand", 1000);

            
    }
    
    public static void main (String[] args) {
    	MyDate currentDate = new MyDate();
    	currentDate.print();
    	
    	
    }
}
