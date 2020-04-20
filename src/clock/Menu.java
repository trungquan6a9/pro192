/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.util.Scanner;

/**
 *
 * @author johny
 */
public class Menu {

    private int choice;

    public Menu() {
    }

    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                do {
                    System.out.print("Your choice: ");
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice < 1 || choice > 7) {
                        System.out.println("\nPlease try again! Your option is from 1 to 7!");
                    }
                } while (choice < 1 || choice > 7);
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Do you know how to input an integer huh!?");
            }
        } while (true);
    }

    public void display() {
        System.out.println("Welcome to my Luxury Clock Store!!!");
        System.out.println("***********************************");
        System.out.println("Please choose your option is from 1 to 6:");
        System.out.println("1./ View clock list.");
        System.out.println("2./ Sort clock list by ID.");
        System.out.println("3./ Add a new clock.");
        System.out.println("4./ Update a clock.");
        System.out.println("5./ Delete a clock.");
        System.out.println("6./ Show shop's clock.");
        System.out.println("7./ Exit.");
    }

    public void sayBye() {
        System.out.println("Thanks for visit my store!\nBye!!!");
    }
}
