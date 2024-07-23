package com.codewars;

/**
 * @author Sergey Golitsyn
 * created on 22.05.2024
 */

/*
ci/cd pipeline

['success', 'success', 'error', 'error']

input --> status with build ['success', 'success', 'error', 'error']
at least 1 err
find the first err in array

['s', 's',  's', 'e', 'e']
                  ^

 Time Comp O(log(N)) -> N array size
 Space Comp O(1)


 */
public class PaloAlto2 {

    public static void main(String[] args) {
        PaloAlto2 p = new PaloAlto2();
        System.out.println(p.findFirstError(new String[]{"success", "success", "error", "error"})); // 2
        System.out.println(p.findFirstError(new String[]{"error", "error"})); // 0
        System.out.println(p.findFirstError(new String[]{"success", "error"})); // 1
    }

    /*

    'error', 'error']
                             ^
    start = 0;
    end = 3;

    ->
     mid = 0 + (3) / 2 -> 1

      start = 2
      end = 3
      mid = 2 + (3-2) / 2 -> 2

       ->
     */
    public int findFirstError(String[] arr) {
        if (arr.length == 1 || arr[0].equals("error")) {
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid].equals("error") && arr[mid-1].equals("success")){
                return mid;
            } else if(arr[mid].equals("error")){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
