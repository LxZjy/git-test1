package Homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HomeWork02 {
    public static void main(String[] args) {
        String filePath = "e:\\a.txt";
        BufferedReader br = null;
        int LineNum = 0;
        String Line = "";
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((Line = br.readLine()) != null) {//循环读取
                System.out.println(++LineNum + Line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
