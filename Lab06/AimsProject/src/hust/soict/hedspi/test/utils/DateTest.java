package hust.soict.hedspi.test.utils;

import hust.soict.hedspi.aims.utils.*;
import hust.soict.hedspi.aims.dics.*;

public class DateTest {
    public static void main(String[] args) {
        MyDate new_date = new MyDate();
        new_date = new MyDate(12, 4, 2000);
        new_date = new MyDate("1/1/2000");
        new_date = new MyDate("28-12-2000");
        new_date = new MyDate("12.5.2000");
        new_date = new MyDate("14 3 2000");
        new_date = new MyDate("9 Feb 2000");
        new_date = new MyDate("1 Oct, 2000");
        new_date = new MyDate("October 11, 2000");
        new_date = new MyDate("08102000");
        new_date.accept("17/7/2000");
        new_date.accept("24.12.2000");
        new_date = new MyDate("fifth", "April", "twenty twenty-five");
        new_date.print();

        MyDate date0 = new MyDate("fifth", "March" ,"twenty hundred");
        date0.print();
        MyDate date1 = new MyDate(12, 4, 2000);
        MyDate date2 = new MyDate(28, 12, 2000);
        System.out.println(DateUtils.CompareDate(date1, date2));
     
    }
}
