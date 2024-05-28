package com.atm.services;

import com.atm.dto.WithdrawalTransaction;
import com.atm.repository.Atm;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WithdrawalTest {

    @Test
    public void testRun_WhenAmountIsLessThanAtmBalance_WithdrawalSuccess() {
        Atm atm = Atm.getInstance();
        Withdrawal withdrawal = new Withdrawal(atm);

        Map<String, List<WithdrawalTransaction>> res = withdrawal.withdraw(1000, "3");

        assertTrue(res.containsKey("3"));
        assertFalse(res.get("3").isEmpty());
    }

    @Test
    public void testRun_WhenAmountIsLessThanNegative_WithdrawalFailure() {
        Atm atm = Atm.getInstance();
        Withdrawal withdrawal = new Withdrawal(atm);

        assertThrows(RuntimeException.class, () -> withdrawal.withdraw(-100, "4"));
    }

    @Test
    public void testRun_WhenAmountIsGreaterAtmBalance_WithdrawalFailure() {
        Atm atm = Atm.getInstance();
        Withdrawal withdrawal = new Withdrawal(atm);

        assertThrows(RuntimeException.class, () -> withdrawal.withdraw(1000000, "5"));
    }


    @Test
    public void testRun_WhenAmountIsZero_WithdrawalFailure() {
        Atm atm = Atm.getInstance();
        Withdrawal withdrawal = new Withdrawal(atm);

        assertThrows(RuntimeException.class, () -> withdrawal.withdraw(0, "6"));
    }


}