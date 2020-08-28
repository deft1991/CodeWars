package com.codewars.leetcode.topInterviewQuestions.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Created by sgolitsyn on 8/27/20
 *
You have a lock in front of you with 4 circular wheels.
Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
The wheels can rotate freely and wrap around:
for example we can turn '9' to be '0', or '0' to be '9'.
Each move consists of turning one wheel one slot.

The lock initially starts at '0000',
a string representing the state of the 4 wheels.

You are given a list of deadends dead ends,
meaning if the lock displays any of these codes,
the wheels of the lock will stop turning and
you will be unable to open it.

Given a target representing the value of the wheels
that will unlock the lock,
return the minimum total number of turns required to open the lock,
or -1 if it is impossible.



Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:

Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:

Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:

Input: deadends = ["0000"], target = "8888"
Output: -1


Constraints:

1 <= deadends.length <= 500
deadends[i].length == 4
target.length == 4
target will not be in the list deadends.
target and deadends[i] consist of digits only.
 */
public class OpenTheLock {

    public static void main(String[] args) {
        OpenTheLock openTheLock = new OpenTheLock();

        System.out.println(openTheLock.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202")); // 6
        System.out.println(openTheLock.openLock(new String[]{"8888"}, "0009")); // 1
        System.out.println(openTheLock.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888")); // -1
        System.out.println(openTheLock.openLock(new String[]{"0000"}, "8888")); // -1
    }

    /*
    Ok,

    lets prepare Set for dead variants for use contains method
    lets prepare Set for visited nodes
    and queue for BFS.

    next
    take elements fro queue and increment and decrement each char in word from queue.
    if adjacency equals target return level
    else add adjacency to queue

     */
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        visited.add("0000");
        queue.add(new Pair<>("0000", 0));

        while (!queue.isEmpty()) {

            Pair<String, Integer> pair = queue.poll();
            String key = pair.getKey();
            Integer level = pair.getValue();
            if (!dead.contains(key)) {
                if (key.equals(target)) {
                    return level;
                } else {
                    for (int i = 0; i < target.length(); i++) {

                        String upAdjacency = key.substring(0, i)
                                + (key.charAt(i) - '0' == 9 ? 1 : key.charAt(i) - '0' + 1)
                                + key.substring(i + 1);

                        String downAdjacency = key.substring(0, i)
                                + (key.charAt(i) - '0' == 0 ? 9 : key.charAt(i) - '0' - 1)
                                + key.substring(i + 1);


                        if (!dead.contains(upAdjacency) && !visited.contains(upAdjacency)){
                            visited.add(upAdjacency);
                            queue.add(new Pair<>(upAdjacency, level + 1));
                        }
                        if (!dead.contains(downAdjacency) && !visited.contains(downAdjacency)){
                            visited.add(downAdjacency);
                            queue.add(new Pair<>(downAdjacency, level + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static class Pair<T,E>{
        private final T key;
        private final E value;

        public Pair(T key, E value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public E getValue() {
            return value;
        }
    }
}
