package com.atm.repository;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/***
 * Singleton class representing Atm having all cash denominations with update and get methods
 */
public class Atm {

    private static Atm atm = null;
    Map<Integer, Integer> denominations = new TreeMap<>(Collections.reverseOrder());

    private Atm() {
        denominations.put(10, 10);
        denominations.put(20, 2);
        denominations.put(50, 10);
        denominations.put(500, 10);
        denominations.put(100, 10);
    }

    /***
     * returns singleton instance of ATM.
     * @return the singleton instance
     */

    public static Atm getInstance() {
        if (atm == null) {
            atm = new Atm();
        }
        return atm;
    }

    /***
     * get cash denominations map
     * @return Map<Integer, Integer>
     */
    public synchronized Map<Integer, Integer> getCashDenominations() {
        return denominations;
    }

    /***
     * updating cash denominations counts
     * @param denomination cash
     * @param count quantity of cash
     */
    public synchronized void updateDenomination(int denomination, int count) {
        denominations.put(denomination, count);
    }
}
