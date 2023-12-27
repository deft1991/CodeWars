package com.codewars;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.time.*;

public class MonthlyChargeTests {
    Subscription plan = new Subscription(1, 1, 5000);

    User[] users = {
            new User(1, "Employee #1", LocalDate.of(2019, 1, 1), null, 1),
            new User(2, "Employee #2", LocalDate.of(2019, 1, 1), null, 1)
    };

    @Test
    public void worksWhenNoUsersAreActive() {
        int actual = Challenge.monthlyCharge("2018-10", plan, users);
        assertEquals(0, actual);
    }

    @Test
    public void worksWhenTheActiveUsersAreActiveTheEntireMonth() {
        float expectedUserCount = 2;
        assertEquals(expectedUserCount * 5000, Challenge.monthlyCharge("2020-12", plan, users), 1);
    }
}
