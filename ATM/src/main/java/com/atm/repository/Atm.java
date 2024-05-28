package com.atm.repository;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/***
 * Atm class having all the denominations and related methods
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

    public static Atm getInstance() {
        if (atm == null) {
            atm = new Atm();
        }
        return atm;
    }

    public synchronized Map<Integer, Integer> getCashDenominations() {
        return denominations;
    }

    public synchronized void updateDenomination(int denomination, int count) {
        denominations.put(denomination, count);
    }
}
