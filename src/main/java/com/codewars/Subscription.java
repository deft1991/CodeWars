package com.codewars;

/**
 * @author Sergey Golitsyn
 * created on 27.12.2023
 */
import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

class Subscription {

    public static void main(String[] args) {
        Subscription plan = new Subscription(1, 1, 5000);

        User[] users = {
                new User(1, "Employee #1", LocalDate.of(2019, 1, 1), null, 1),
                new User(2, "Employee #2", LocalDate.of(2019, 1, 1), null, 1)
        };

        System.out.println(Challenge.monthlyCharge("2018-10", plan, users));
        System.out.println(Challenge.monthlyCharge("2020-12", plan, users));
    }

    public Subscription() {}
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
    public User() {}
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

class Challenge
{
    private static final DecimalFormat decfor = new DecimalFormat("0.0");
    public static int monthlyCharge(String month, Subscription subscription, User[] users) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate firstDay = parseToLocalDate(month + "-01", formatter);

        if (firstDay == null) {
            throw new IllegalArgumentException("Invalid date format");
        }

        LocalDate lastDay = lastDayOfMonth(firstDay);
        float dailyRate = (float) subscription.monthlyPriceInCents / lastDay.lengthOfMonth(); // Use floating-point division
        float totalCharge = 0;
        for (LocalDate currentDate = firstDay; !currentDate.isAfter(lastDay); currentDate = nextDay(currentDate)) {
            int activeUsers = countActiveUsers(currentDate, users);
            totalCharge += activeUsers * dailyRate;
        }

        String format = decfor.format(totalCharge);
        return (int)Float.parseFloat(format);
    }

    private static int countActiveUsers(LocalDate currentDate, User[] users) {
        int count = 0;
        for (User user : users) {
            if (isActiveOnDate(currentDate, user)) {
                count++;
            }
        }
        return count;
    }
    private static LocalDate parseToLocalDate(String dateString, DateTimeFormatter formatter) {
        try {
            return LocalDate.parse(dateString, formatter); // Adjust the parsing logic
        } catch (Exception e) {
            return null;
        }
    }

    private static boolean isActiveOnDate(LocalDate currentDate, User user) {
        return !currentDate.isBefore(user.activatedOn) && (user.deactivatedOn == null || !currentDate.isAfter(user.deactivatedOn));
    }

    /*******************
     * Helper functions *
     *******************/

    /**
     Takes a LocalDate object and returns a LocalDate which is the first day
     of that month. For example:

     firstDayOfMonth(LocalDate.of(2022, 3, 17)) // => LocalDate.of(2022, 3, 1)
     **/
    private static LocalDate firstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    /**
     Takes a LocalDate object and returns a LocalDate which is the last day
     of that month. For example:

     lastDayOfMonth(LocalDate.of(2022, 3, 17)) // => LocalDate.of(2022, 3, 31)
     **/
    private static LocalDate lastDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    /**
     Takes a LocalDate object and returns a LocalDate which is the next day.
     For example:

     nextDay(LocalDate.of(2022, 3, 17)) // => LocalDate.of(2022, 3, 18)
     nextDay(LocalDate.of(2022, 3, 31)) // => LocalDate.of(2022, 4, 1)
     **/
    private static LocalDate nextDay(LocalDate date) {
        return date.plusDays(1);
    }
}
