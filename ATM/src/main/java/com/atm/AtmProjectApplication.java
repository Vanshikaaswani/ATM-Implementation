package com.atm;

import com.atm.repository.Atm;
import com.atm.services.ATMUser;
import com.atm.services.Withdrawal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * Entry point for ATM project Application
 */
public class AtmProjectApplication {
    private static final Logger logger = LoggerFactory.getLogger(ATMUser.class);

    public static void main(String[] args) throws InterruptedException {

        logger.info("Starting ATM Application");
        Atm atm = Atm.getInstance();
        Withdrawal withdrawal = new Withdrawal(atm);

        Thread t1 = new Thread(new ATMUser(withdrawal, 5000, "1"), " User1");
        t1.start();

        Thread t2 = new Thread(new ATMUser(withdrawal, 1000, "2"), "User2");
        t2.start();

        t1.join();
        t2.join();

        logger.info("Ended ATM Application");

    }
}
