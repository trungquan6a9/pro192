/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johny
 */
public class ClockManagement {

    Scanner sc = new Scanner(System.in);
    boolean append = true;
    File f = new File("Clock.txt");
    TreeSet ts = new TreeSet();
    int count = 0;
    Clock c[];

    public void readFile() {
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            List<List> l1 = new ArrayList();
            String line = br.readLine();
            while (line != null) {
                String[] arr1 = line.trim().split("[|]");
                if (arr1.length == 7) {
                    List l2 = new ArrayList();
                    for (int i = 1; i <= 6; i++) {
                        l2.add(arr1[i].trim());
                    }
                    l1.add(l2);
                }
                line = br.readLine();
            }
            fr.close();
            br.close();
            count = 0;
            c = new Clock[l1.size() + 1];
//            List<Clock> clockList = new ArrayList();
            for (int i = 0; i < l1.size(); i++) {
                c[count] = new Clock((String) l1.get(i).get(0), (String) l1.get(i).get(1), (String) l1.get(i).get(2),
                        (String) l1.get(i).get(3), Integer.parseInt((String) l1.get(i).get(4)), Double.parseDouble((String) l1.get(i).get(5)));
                count++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClockManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClockManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ClockManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void viewClockList() {
        if (count == 0) {
            System.out.println("There are any clock!!!\nPlease input at option 3");
        } else {
            c[0].printTitle();
            for (int i = 0; i < count; i++) {
                c[i].outputAClock();
            }
        }
    }

    public void sortClockListByID() {
        if (count == 0) {
            System.out.println("There are any clock!!!\nPlease input at option 3");
        } else {
            for (int i = 0; i < count; i++) {
                ts.add(c[i]);
            }
            Iterator iter = ts.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }
        }
    }

    public void addAClock() {
        boolean chek = true;
        chek = true;
        c[count] = new Clock();
        c[count].inputAClock();
        for (int i = 0; i < c.length - 1; i++) {
            if (c[count].getClockID().compareTo(c[i].getClockID()) == 0) {
                chek = false;
            }
        }
        if (chek == true) {
            FileWriter fw = null;
            try {
                fw = new FileWriter(f, append);
                PrintWriter pw = new PrintWriter(fw);
                pw.printf("|%-5s|%-18s|%-6s|%-12s|%4d|%3.1f|",
                        c[count].getClockID(), c[count].getClockName(), c[count].getClockType(),
                        c[count].getClockBrand(), c[count].getManufacturingYear(), c[count].getClockSize());
                pw.println();
                fw.close();
                pw.close();
                count++;
                System.out.println("You have just input a new clock success!!!");
            } catch (IOException ex) {
                Logger.getLogger(ClockManagement.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClockManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("The Clock's ID had been created!!! Please Try Again!!!\n");
        }
    }

    public void updateAClock() {
        if (count == 0) {
            System.out.println("There are any clock!!!\nPlease input at option 3");
        } else {
            String checkID;
            int update = -1;
            System.out.print("Please give me clock's ID you want to update: ");
            checkID = sc.nextLine();
            for (int i = 0; i < count; i++) {
                if (checkID.compareTo(c[i].getClockID()) == 0) {
                    update = i;
                    break;
                }
            }
            if (update != -1) {
                FileWriter fwu = null;
                try {
                    fwu = new FileWriter(f);
                    PrintWriter pwu = new PrintWriter(fwu);
                    ts.remove(c[update]);
                    c[update] = new Clock();
                    c[update].inputAClock();
                    for (int i = 0; i < c.length - 1; i++) {
                        pwu.printf("|%-5s|%-18s|%-6s|%-12s|%4d|%3.1f|",
                                c[i].getClockID(), c[i].getClockName(), c[i].getClockType(),
                                c[i].getClockBrand(), c[i].getManufacturingYear(), c[i].getClockSize());
                        pwu.println();
                    }
                    fwu.close();
                    pwu.close();
                    System.out.println("You have just update a new clock at ID = " + checkID + " success!!!");
                } catch (IOException ex) {
                    Logger.getLogger(ClockManagement.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fwu.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ClockManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                System.out.println("We can not find that clock's ID, please try again!!!\n");
            }
        }
    }

    public void deleteAClock() {
        if (count == 0) {
            System.out.println("There are any clock!!!\nPlease input at option 3");
        } else {
            String checkID;
            int update = -1;
            System.out.print("Please give me clock's ID you want to delete: ");
            checkID = sc.nextLine();
            for (int i = 0; i < count; i++) {
                if (checkID.compareTo(c[i].getClockID()) == 0) {
                    update = i;
                    break;
                }
            }
            if (update != -1) {
                FileWriter fwu = null;
                try {
                    fwu = new FileWriter(f);
                    PrintWriter pwu = new PrintWriter(fwu);
                    ts.remove(c[update]);
                    Clock tmp = new Clock();
                    for (int i = update; i < c.length - 1; i++) {
                        c[update] = c[update + 1];
                    }
                    for (int i = 0; i < c.length - 2; i++) {
                        pwu.printf("|%-5s|%-18s|%-6s|%-12s|%4d|%3.1f|",
                                c[i].getClockID(), c[i].getClockName(), c[i].getClockType(),
                                c[i].getClockBrand(), c[i].getManufacturingYear(), c[i].getClockSize());
                        pwu.println();
                    }
                    fwu.close();
                    pwu.close();
                    System.out.println("You have just update a new clock at ID = " + checkID + " success!!!");
                } catch (IOException ex) {
                    Logger.getLogger(ClockManagement.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fwu.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ClockManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                System.out.println("We can not find that clock's ID, please try again!!!\n");
            }
        }
    }

    public void showShopClock() {
        if (count == 0) {
            System.out.println("There are any clock!!!\nPlease input at option 3");
        } else {
            ClockShop kimLong = new ClockShop("Kim Long");
            ClockShop bachMa = new ClockShop("Bạch Mã");
            for (int i = 0; i < c.length - 1; i++) {
                if (i % 2 == 0) {
                    kimLong.addClock(c[i]);
                } else {
                    bachMa.addClock(c[i]);
                }
            }
            kimLong.printShopMenu();
            bachMa.printShopMenu();
        }
    }

}
