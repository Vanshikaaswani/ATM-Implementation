package com.atm;

import com.atm.repository.Atm;
import com.atm.services.ATMUser;
import com.atm.services.Withdrawal;

/***
 * Entry point for ATM project Application
 */
public class AtmProjectApplication {

    public static void main(String[] args) throws InterruptedException {

        Atm atm = Atm.getInstance();
        Withdrawal withdrawal = new Withdrawal(atm);

        Thread t1 = new Thread(new ATMUser(withdrawal, 5500, "1"), " User1");
        t1.start();

        Thread t2 = new Thread(new ATMUser(withdrawal, 1000, "2"), "User2");
        t2.start();

        t1.join();
        t2.join();

    }
}
