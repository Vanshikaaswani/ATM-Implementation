package com.atm.services;

import com.atm.dto.WithdrawalTransaction;
import com.atm.repository.Atm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Handles Withdrawal operations for ATM.
 */
public class Withdrawal {
    private Atm atm;

    public Withdrawal(Atm atm) {
        this.atm = atm;
    }

    /***
     * Performs cash withdrawal
     * @param withdrawAmount amount to withdraw
     * @param id             the transaction id
     * @return a map containing transaction id and  list of withdrawal transaction.
     * @throws RuntimeException if Atm does not have sufficient cash denominations.
     */
    public synchronized Map<String, List<WithdrawalTransaction>> withdraw(int withdrawAmount, String id) {

        validateAmount(withdrawAmount);

        Map<Integer, Integer> denominations = atm.getCashDenominations();
        Map<String, List<WithdrawalTransaction>> result = new HashMap<>();
        List<WithdrawalTransaction> transactions = new ArrayList<>();

        for (int denomination : denominations.keySet()) {
            if (withdrawAmount <= 0) {
                break;
            }
            int demNeeded = withdrawAmount / denomination;
            int demAvailable = denominations.getOrDefault(denomination, 0);

            if (demAvailable > 0 && demNeeded > 0) {
                int demWithdraw = Math.min(demAvailable, demNeeded);
                transactions.add(new WithdrawalTransaction(denomination, demWithdraw));
                withdrawAmount -= demWithdraw * denomination;
                int newCashDenominationValue = demAvailable - demWithdraw;
                atm.updateDenomination(denomination, newCashDenominationValue);
            }
        }
        if (withdrawAmount > 0) {
            throw new RuntimeException("Atm does not have sufficient cash denominations");
        }
        result.put(id, transactions);
        return result;
    }

    /***
     * Validating if withdraw amount is not negative and atm has sufficient balance.
     * @param withdrawAmount
     */
    public void validateAmount(int withdrawAmount) {
        int balance = atm.getCashDenominations().entrySet().stream().mapToInt(denominations -> denominations.getKey() * denominations.getValue()).sum();
        if (balance == 0) {
            throw new RuntimeException("Atm has no cash.");
        }
        if (balance < withdrawAmount) {
            throw new RuntimeException("Atm cash balance is low");
        }
        if (withdrawAmount <= 0) {
            throw new RuntimeException("Withdrawal amount must be greater than 0");
        }
    }
}
