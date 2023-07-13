package com.codewars.neetcode.linkedList;

/**
 * @author Sergey Golitsyn
 * created on 12.01.2023
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();

        System.out.println(f.findDuplicate(new int[]{1,3,4,2,2})); // 2
        System.out.println(f.findDuplicate(new int[]{3,1,3,4,2})); // 3
    }

    public int findDuplicate(int[] nums) {

        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];

        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int slow2 = nums[0];
        while (slow2 != slow) {
            slow2 = nums[slow2];
            slow = nums[slow];
        }
        return slow;
    }

    public int findDuplicate2(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        boolean first = true;
        while (first || fast != slow) {
            if (first) first = false;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int slow2 = nums[0];
        while (slow2 != slow) {
            if (first) first = false;
            slow2 = nums[slow2];
            slow = nums[slow];
        }
        return slow;
    }
}
