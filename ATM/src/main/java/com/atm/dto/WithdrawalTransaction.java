package com.atm.dto;

/***
 * Withdrawal Transaction details having number of denominations that are withdrawn
 */
public class WithdrawalTransaction {
    private int denomination;
    private int count;

    public WithdrawalTransaction(int denomination, int count) {
        this.denomination = denomination;
        this.count = count;
    }

    public int getDenomination() {
        return denomination;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return " WithdrawalTransaction {" +
                "denomination=" + denomination +
                ", count=" + count +
                " }";
    }
}
