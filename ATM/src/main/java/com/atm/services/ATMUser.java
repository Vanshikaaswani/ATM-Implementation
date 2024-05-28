package com.atm.services;

import com.atm.dto.WithdrawalTransaction;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/***
 * Represents AtmUser attempting to withdraw cash
 * Implements Runnable to enable user to run in a separate thread.
 */
public class ATMUser implements Runnable {
    private static final Logger logger = LogManager.getLogger(ATMUser.class);

    private Withdrawal withdrawal;
    private int withdrawAmount;
    private String id;

    public ATMUser(Withdrawal withdrawal, int withdrawAmount, String id) {
        this.withdrawal = withdrawal;
        this.withdrawAmount = withdrawAmount;
        this.id = id;
    }

    /***
     * Logs the transaction details or any error encountered
     */
    @Override
    public void run() {
        try {
            Map<String, List<WithdrawalTransaction>> withdrawResult = withdrawal.withdraw(withdrawAmount, id);
            for (Map.Entry<String, List<WithdrawalTransaction>> entry : withdrawResult.entrySet()) {
                logger.info("Transaction id: " + entry.getKey() + "  " + "Withdrawal details: " + entry.getValue());
            }
        } catch (Exception e) {
            logger.error("Transaction failed for id " + id + ". " + e.getMessage());
        }
    }
}
