/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.garbage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class NoGarbage {
    public static void main(String args[]) throws IOException {
        String filename = "sometext.txt";
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        try {
            String line = reader.readLine();
            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
               
        }
        System.out.println(sb);
        System.out.println(System.currentTimeMillis() - start);
    }
}