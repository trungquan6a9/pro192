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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;
        Menu m = new Menu();
        ClockManagement clockManagement = new ClockManagement();
        do {
            clockManagement.readFile();
            m.display();
            choice = m.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You have just select option View clock list.\n");
                    clockManagement.viewClockList();
                    System.out.println("Press Enter key to continues...");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("You have just select option Sort clock list by ID.\n");
                    clockManagement.sortClockListByID();
                    System.out.println("Press Enter key to continues...");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("You have just select option Add a new clock.\n");
                    clockManagement.addAClock();
                    System.out.println("Press Enter key to continues...");
                    sc.nextLine();

                    break;
                case 4:
                    System.out.println("You have just select option Update a clock.\n");
                    clockManagement.updateAClock();
                    System.out.println("Press Enter key to continues...");
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("You have just select option Delete a clock.\n");
                    clockManagement.deleteAClock();
                    System.out.println("Press Enter key to continues...");
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("You have just select option Show shop's clock.\n");
                    clockManagement.showShopClock();
                    System.out.println("Press Enter key to continues...");
                    sc.nextLine();
                    break;
                default:
                    System.out.println("");
                    m.sayBye();
                    break;
            }
        } while (choice != 7);
    }

}
