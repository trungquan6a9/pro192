/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.io.*;
import java.util.*;

/**
 *
 * @author johny
 */
public class Clock implements Comparable, Serializable {

    File f = new File("test.txt");

    protected String clockID;
    protected String clockName;
    protected String clockType;
    protected String clockBrand;
    protected int manufacturingYear;
    protected double clockSize;

    public Clock() {
    }

    public Clock(String clockID, String clockName, String clockType, String clockBrand, int manufacturingYear, double clockSize) {
        this.clockID = clockID;
        this.clockName = clockName;
        this.clockType = clockType;
        this.clockBrand = clockBrand;
        this.manufacturingYear = manufacturingYear;
        this.clockSize = clockSize;
    }

    public String getClockName() {
        return clockName;
    }

    public void setClockName(String clockName) {
        this.clockName = clockName;
    }

    public String getClockType() {
        return clockType;
    }

    public void setClockType(String clockType) {
        this.clockType = clockType;
    }

    public String getClockBrand() {
        return clockBrand;
    }

    public void setClockBrand(String clockBrand) {
        this.clockBrand = clockBrand;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public double getClockSize() {
        return clockSize;
    }

    public void setClockSize(double clockSize) {
        this.clockSize = clockSize;
    }

    public String getClockID() {
        return clockID;
    }

    public void setClockID(String clockID) {
        this.clockID = clockID;
    }

    @Override
    public int compareTo(Object obj) {
        Clock c = (Clock) obj;
        if (clockID.compareTo(c.getClockID()) > 0) {
            return 1;
        } else if (clockID.compareTo(c.getClockID()) == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "|" + clockID + " |" + clockName + " |" + clockType + " |" + clockBrand + " |" + manufacturingYear + " |" + clockSize + " mm|";
    }

    public void inputAClock() {
        System.out.println("Now you can add a new clock");
        clockID = inputString("Please, input clock's ID: ");
        clockName = inputString("Please, input clock's name: ");
        clockType = inputString("Please, input clock's type (Men or Women): ");
        clockBrand = inputString("Please, input clock's brand: ");
        manufacturingYear = inputAnInteger("Please, input clock's manufacturing year: ");
        clockSize = inputADouble("Please, input clock's size: ");
    }

    public String inputString(String msg) {
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            System.out.print(msg);
            str = sc.nextLine();
            if (str.length() == 0 || str.isEmpty()) {
                System.out.println("You have been inputed nothing! Try again!");
            } else {
                return str;
            }
        } while (true);
    }

    public int inputAnInteger(String msg) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine().trim().substring(0, 4));
                return n;
            } catch (Exception e) {
                System.out.println("Please input a year (xxxx)!!!");
            }
        }
    }

    public double inputADouble(String msg) {
        Scanner sc = new Scanner(System.in);
        double d;
        while (true) {
            try {
                System.out.print(msg);
                d = Double.parseDouble(sc.nextLine().trim().substring(0, 2));
                return d;
            } catch (Exception e) {
                System.out.println("Please input a size (xx.x)");
            }
        }
    }

    public void printTitle() {
        System.out.printf("|ID   |Name              |Type  |Brand       |MFG |Size   |\n\n");
    }

    public void outputAClock() {
        System.out.printf("|%-5s|%-18s|%-6s|%-12s|%4d|%3.1f |\n",
                clockID, clockName, clockType, clockBrand, manufacturingYear, clockSize);
    }
}
