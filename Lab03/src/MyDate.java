import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;

public class MyDate {
    private int day;
    private int month;
    private int year;

    // constructor with no para
    public MyDate() {
        LocalDate date = LocalDate.now();
        this.day = date.getDayOfMonth();
        this.month = date.getMonthValue();
        this.year = date.getYear();
    }
    // constructor with 3 para
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
    // constructor with one para
    public MyDate(String strDate) {
        this(); // Now
        accept(strDate);
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

    public void print(){
        System.out.println("Date: " + this.day + "/" + this.month + "/" + this.year);
    }

    public void accept(String strDate)
    {
        try {
            String pattern = "[d[/][-][.][ ]M[/][-][.][ ]yyyy]"
                            + "[d MMM[,] yyyy]"
                            + "[MMM d[,] yyyy]"
                            + "[MMMM d[,] yyyy]"
                            + "[ddMMyyyy]";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            strDate = strDate.replaceAll("st|nd|rd|th", ""); // Regex for remove 'st', 'nd', 'rd', 'th' from day
            LocalDate date = LocalDate.parse(strDate, formatter);
            this.day = date.getDayOfMonth();
            this.month = date.getMonthValue();
            this.year = date.getYear();
        } catch (DateTimeException e) {
            System.out.println("Invalid Date");
        }
    }
}
