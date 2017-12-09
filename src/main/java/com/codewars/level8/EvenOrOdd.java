package com.codewars.level8;

/*
*Create a function that takes an integer as an argument and returns "Even" for even numbers or "Odd" for odd numbers.
*/
 class EvenOrOdd {
     static String even_or_odd(int number) {
        //Place code here
        return number%2 == 0 ? "Even" : "Odd";
    }
}
