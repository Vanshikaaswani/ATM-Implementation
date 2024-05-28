package com.atm.services;

import com.atm.dto.WithdrawalTransaction;

import java.util.List;
import java.util.Map;

/***
 * AtmUser attempting to withdraw cash
 */
public class ATMUser implements Runnable {
    private Withdrawal withdrawal;
    private int withdrawAmount;
    private String id;

    public ATMUser(Withdrawal withdrawal, int withdrawAmount, String id) {
        this.withdrawal = withdrawal;
        this.withdrawAmount = withdrawAmount;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Map<String, List<WithdrawalTransaction>> withdrawResult = withdrawal.withdraw(withdrawAmount, id);
            for (Map.Entry<String, List<WithdrawalTransaction>> entry : withdrawResult.entrySet()) {
                System.out.println("Transaction id: " + entry.getKey() + "  " + "Withdrawal details: " + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println("Transaction failed for id " + id + ". " + e.getMessage());
        }
    }
}
