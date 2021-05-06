/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.utils;


public class DateUtils {
    public static int CompareDate(MyDate date1, MyDate date2) {
        // date1 < date2 => -1
        // date1 = date2 => 0
        // date1 > date2 => 1
        if (date1.getYear() < date2.getYear()) return -1;
        else {
            if (date1.getYear() > date2.getYear()) return 1;
            else {
                if (date1.getMonth() < date2.getMonth()) return -1;
                else {
                    if (date1.getMonth() > date2.getMonth()) return 1;
                    else {
                        if (date1.getDay() < date2.getDay()) return -1;
                        else {
                            if (date1.getDay() > date2.getDay()) return 1;
                            else {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
    }

    // public static MyDate[] SortDate(MyDate[] dates) {

    // }
}
