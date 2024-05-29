package com.atm.services;

import com.atm.dto.WithdrawalTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


/***
 * Represents AtmUser attempting to withdraw cash
 * Implements Runnable to enable user to run in a separate thread.
 */
public class ATMUser implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ATMUser.class);

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
                logger.info("Transaction id: {}  Withdrawal details: {}", entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            logger.error("Transaction failed for id {}. {}", id, e.getMessage());
        }
    }
}
