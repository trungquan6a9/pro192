/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johny
 */
public class ClockShop {

    private String shopName;

    List<Clock> clockList = new ArrayList();

    public ClockShop(String shopName) {
        this.shopName = shopName;
    }

    public void addClock(Clock clock) {
        clockList.add(clock);
    }

    public void printShopMenu() {
        System.out.println("Welcome to " + shopName);
        System.out.println("Our clock are: ");
        for (Clock x : clockList) {
            x.outputAClock();
        }
        System.out.println("");
    }
}
