package com.codewars.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by sgolitsyn on 5/20/20
 *
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
Обьяснение: у нас есть массив элементов от 1...Н
 и н это размер массива, тоесть максимальное возможное число в массиве будет Н + 1.
Можно попробовать отсортировать массив и найти элементы которые будут стоять не на своих местах
+ считать смещение индекса если есть повторяющиеся элементы. Но это займет время O(Nlog(N))
, потому что сортировка потребует в среднем такое время.
Вариант А:
Что если попробовать добавить к каждой позиции что соответствует элемент (nums(nums(i) - 1)) добавить Н ?
Исходный массив : [4,3,2,7,8,2,3,1] --> Добавим Н к nums(nums (0) - 1) = 3; nums(3) += Н и получим модифицированный массив
[4,3,2,15,8,2,3,1] --> повторим это действие для всех элементов массива
Но как мы можем заметить на 3й позиции сейчас 15 -> и мы получим ошибку нехватки размера массива.
Что бы избежать этого мы будем искать элемент nums((nums(i) - 1) % Н) -> остаток от деления на Н вернет нм исходное число =))
[12,19,18,15,8,2,11,9] получаем такой массив (надеюсь нигде не опечатался)
Как мы можем заметить элементы в 2х позициях не изменились, что говорит о том что их нет в исходном массиве.
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray find = new FindAllNumbersDisappearedInAnArray();
        int[] ints = {4, 3, 2, 7, 8, 2, 3, 1};
        find.findDisappearedNumbers2(ints);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> rezList = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[(nums[i] - 1) % length] += length;
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] <= length) {
                rezList.add(i + 1);
            }
        }
        return rezList;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> rez = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            nums[idx] = nums[idx] > 0 ? - nums[idx] : nums[idx];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                rez.add(i + 1);
            }
        }
        return rez;
    }
}
