package com.ultimatechat;

import java.io.*;

/*
 * This class is to control inputs and simplify the declaration of
 * BuferedReader, InputStreamReader
 */
public class Inputs {
    private BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    
    /* 
     * If input value can't convert to integer, 
     * show an error message and request it again.
     */
    public int int_input(String message) {
        while (true) {
            try{
                System.out.print(message);
                return Integer.parseInt(r.readLine());
            } catch (IOException | NumberFormatException e){
                System.out.println("Incorrect value");
            }
        }
    }
    
    /* 
     * The same of int_input method and control the input is in the range
     */
    public int int_range(String message, int range1, int range2) {
        int num;
        do {
            num = int_input(message);
            if (num < range1 || num > range2) {
                System.out.println("Incorrect value");
            }
        } while (num < range1 || num > range2);
        return num;
    }
    
    /*
     * If input value can't convert to float, 
     * show an error message and request it again.
     */
    public float float_input(String message) {
        while (true){
            try{
                System.out.print(message);
                return Float.parseFloat(r.readLine());
            } catch (IOException | NumberFormatException e){
                System.out.println("Incorrect value");
            }
        }
    }


    /* 
     * The same of flot_input method and control the input is in the range
     */
    public float float_input_range(String message, float range1, float range2) {
        float num;
        do {
            num = float_input(message);
            if (num < range1 || num > range2) {
                System.out.println("Incorrect value");
            }
        } while (num < range1 || num > range2);
        return num;
    }

    /*
     * String input control
     */
    public String str_input(String message) {
        while (true){
            try{
                System.out.print(message);
                return r.readLine();
            } catch (IOException e){
                System.out.println("Incorrect value");
            }
        }
    }
}

