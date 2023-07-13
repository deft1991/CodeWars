package com.codewars.leetcode.mock;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;


/**
 * @author Sergey Golitsyn
 * created on 31.01.2023
 */
class Subscription {
    public Subscription() {
    }

    public Subscription(int id, int customerId, int monthlyPriceInCents) {
        this.id = id;
        this.customerId = customerId;
        this.monthlyPriceInCents = monthlyPriceInCents;
    }

    public int id;
    public int customerId;
    public int monthlyPriceInCents;
}

class User {
    public User() {
    }

    public User(int id, String name, LocalDate activatedOn, LocalDate deactivatedOn, int customerId) {
        this.id = id;
        this.name = name;
        this.activatedOn = activatedOn;
        this.deactivatedOn = deactivatedOn;
        this.customerId = customerId;
    }

    public int id;
    public String name;
    public LocalDate activatedOn;
    public LocalDate deactivatedOn;
    public int customerId;
}

class Challenge {

    public static void main(String[] args) {
        Subscription plan = new Subscription(1, 1, 5000);

        User[] users = {
                new User(1, "Employee #1", LocalDate.of(2019, 1, 1), null, 1),
                new User(2, "Employee #2", LocalDate.of(2019, 1, 1), null, 1)
        };

        System.out.println(Challenge.monthlyCharge("2018-10", plan, users)); // 0
//        System.out.println(Challenge.monthlyCharge("2020-12", plan, users)); // 2
    }

    public static int monthlyCharge(String month, Subscription subscription, User[] users) {
        if (subscription == null || users.length == 0) {
            return 0;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
//        LocalDate date = LocalDate.parse(month, formatter);

        YearMonth date = YearMonth.parse(month, formatter);

        Map<Integer, User> userMap = new HashMap<>();

        int totalDays = 0;
        for (User u : users) {
            if (date.getYear() < u.activatedOn.getYear()){
                continue;
            }
            if (date.getYear() == u.activatedOn.getYear() && date.getMonth().getValue() < u.activatedOn.getMonth().getValue()){
                continue;
            }
            if ((u.deactivatedOn != null && date.getMonth().getValue() > u.deactivatedOn.getMonth().getValue())) {
                // skip
            } else {
                if (date.getMonth() == u.activatedOn.getMonth()) { // activate on this month
                    long daysBetween;
                    if (u.deactivatedOn != null && date.getMonth() == u.deactivatedOn.getMonth()) { // deactivate this month
                        daysBetween = DAYS.between(u.activatedOn, u.deactivatedOn);
                    } else { // deactivate other month
                        daysBetween = DAYS.between(u.activatedOn, lastDayOfMonth(u.activatedOn));
                    }
                    totalDays += daysBetween;
                } else if (u.deactivatedOn != null && date.getMonth() == u.deactivatedOn.getMonth()) {
                    long daysBetween = DAYS.between(firstDayOfMonth(u.deactivatedOn), u.deactivatedOn);
                    totalDays += daysBetween;
                } else {
                    totalDays += DAYS.between(firstDayOfMonth(date.atDay(1)), lastDayOfMonth(date.atEndOfMonth()));
                }
            }
        }

        float perDay = subscription.monthlyPriceInCents / date.lengthOfMonth();

        return (int) (perDay * totalDays);
    }

    /*******************
     * Helper functions *
     *******************/

    /**
     * Takes a LocalDate object and returns a LocalDate which is the first day
     * of that month. For example:
     * <p>
     * firstDayOfMonth(LocalDate.of(2022, 3, 17)) // => LocalDate.of(2022, 3, 1)
     **/
    private static LocalDate firstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    /**
     * Takes a LocalDate object and returns a LocalDate which is the last day
     * of that month. For example:
     * <p>
     * lastDayOfMonth(LocalDate.of(2022, 3, 17)) // => LocalDate.of(2022, 3, 31)
     **/
    private static LocalDate lastDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    /**
     * Takes a LocalDate object and returns a LocalDate which is the next day.
     * For example:
     * <p>
     * nextDay(LocalDate.of(2022, 3, 17)) // => LocalDate.of(2022, 3, 18)
     * nextDay(LocalDate.of(2022, 3, 31)) // => LocalDate.of(2022, 4, 1)
     **/
    private static LocalDate nextDay(LocalDate date) {
        return date.plusDays(1);
    }
}
