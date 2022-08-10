package com.codewars.facebook;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 04.05.2022
 */
public class ContiguousSubarrays {


// Add any extra import statements you may need here


    // Add any helper functions you may need here

    /*
        Stack<Integer> stack = new Stack<>();
    int[] ans = new int[arr.length];
    for(int i = 0; i < arr.length; i++) {
      while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        ans[i] += ans[stack.pop()];
      }
      stack.push(i);
      ans[i]++;
    }
     stack.clear();
    int[] temp = new int[arr.length];
     for(int i = arr.length - 1; i >= 0; i--) {
      while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        int idx = stack.pop();
        ans[i] += temp[idx];
        temp[i] += temp[idx];
      }
      stack.push(i);
      temp[i]++;
    }
    return ans;
     */
    int[] countSubarrays2(int[] arr) {
        // Write your code here
        int[] rez = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                rez[i] += rez[stack.pop()];
            }
            stack.push(i);
            rez[i]++;
        }

        stack.clear();

        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                int idx = stack.pop();
                rez[i] += temp[idx];
                temp[i] += temp[idx];
            }
            stack.push(i);
            temp[i]++;
        }
        return rez;
    }

    int[] countSubarrays(int[] arr) {
        // Write your code here
        int[] rez = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = getCount(arr, i);
            rez[i] = count;
        }
        return rez;
    }

    private int getCount(int[] arr, int idx) {
        int cur = arr[idx];
        int left = idx - 1;
        int right = idx + 1;
        int count = 0;
        while (left >= 0) {
            if (arr[left] < cur) {
                count++;
                left--;
            } else {
                break;
            }
        }
        while (right < arr.length) {
            if (arr[right] < cur) {
                count++;
                right++;
            } else {
                break;
            }
        }
        return count + 1;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int[] test_0 = new int[]{1, 2};
        int[] expected_0 = new int[]{1, 2};
        int[] output_0 = countSubarrays2(test_0);
        check(expected_0, output_0);

        test_0 = new int[]{2, 1};
        expected_0 = new int[]{2, 1};
        output_0 = countSubarrays2(test_0);
        check(expected_0, output_0);

        test_0 = new int[]{1, 2, 3};
        expected_0 = new int[]{1, 2, 3};
        output_0 = countSubarrays2(test_0);
        check(expected_0, output_0);


        test_0 = new int[]{3, 2, 1};
        expected_0 = new int[]{3, 2, 1};
        output_0 = countSubarrays2(test_0);
        check(expected_0, output_0);

        test_0 = new int[]{1, 3, 2};
        expected_0 = new int[]{1, 3, 1};
        output_0 = countSubarrays2(test_0);
        check(expected_0, output_0);

        int[] test_1 = {3, 4, 1, 6, 2};
        int[] expected_1 = {1, 3, 1, 5, 1};
        int[] output_1 = countSubarrays2(test_1);
        check(expected_1, output_1);

        int[] test_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {1, 2, 6, 1, 3, 1};
        int[] output_2 = countSubarrays2(test_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ContiguousSubarrays().run();
    }
}
