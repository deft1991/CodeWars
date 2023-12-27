package com.codewars;

import java.time.LocalDate;

/*
 * Created by sgolitsyn on 5/7/20
 */
public class Tets {


    public static void main(String[] args) {
        LocalDate parse = LocalDate.parse("2018-10");
        System.out.println(firstDayOfMonth(parse));
    }

    private static LocalDate firstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }
}
