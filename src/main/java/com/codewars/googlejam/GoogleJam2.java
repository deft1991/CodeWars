package com.codewars.googlejam;

import java.util.Scanner;

/**
 * @author Sergey Golitsyn
 * created on 15.04.2023
 * <p>
 * Problem
 * Onyaomale is leading a project to exchange the lightbulbs from street lights along a freeway from incandescent ones to LED lightbulbs that are both more energy-efficient and powerful. She started by taking all the old incandescent lightbulbs out, and is now focused on installing the new LED ones. Because the new lightbulbs are more powerful, Onyaomale thinks it is possible that some street lights are not necessary and she can save even more energy by not using them.
 * <p>
 * We model the freeway as a straight line measuring M
 * meters that goes from west to east. The x
 * -th meter is a point that is x
 * meters to the east of the western end of the freeway. If a street light is located at the x
 * -th meter, and a lightbulb with an illumination radius of R
 * meters is installed on it, then the street light illuminates the segment of freeway starting at the max(0,x−R)
 * -th meter and ending at the min(M,x+R)
 * -th meter, inclusive. Onyaomale needs to install lightbulbs in such a way that every point of the freeway is illuminated by at least one of them. Notice that this includes illuminating points that are not an integer number of meters away from the freeway endpoints. Street lights that are left without a lightbulb do not illuminate anything.
 * <p>
 * Given the length of the freeway in meters M
 * , the illumination radius of the new lightbulbs R
 * and the locations of all street lights, find the minimum number of lightbulbs Onyaomale needs to install to illuminate the whole freeway, or report that it is impossible to do so.
 * <p>
 * Input
 * The first line of the input gives the number of test cases, T
 * . T
 * test cases follow. Each test case consists of two lines. The first line contains three integers M
 * , R
 * , and N
 * : the length, in meters, of the freeway, the illumination radius, in meters, of the lightbulbs and the number of street lights, respectively. The second line of a test case contains N
 * sorted integers X1,X2,…,XN
 * representing the meters of the freeway where street lights are located.
 * <p>
 * Output
 * For each test case, output one line containing Case #x
 * : y
 * , where x
 * is the test case number (starting from 1) and y
 * is the minimum number of lightbulbs Onyaomale needs to install to illuminate the whole freeway, if it is possible. If there is no way to illuminate the entire freeway using the current street lights, y
 * should be IMPOSSIBLE instead.
 * <p>
 * Limits
 * Time limit: 10 seconds.
 * Memory limit: 2 GB.
 * 1≤T≤100
 * .
 * 1≤M≤109
 * .
 * 1≤R≤109
 * .
 * 0≤X1
 * .
 * Xi<Xi+1
 * , for all i
 * .
 * XN≤M
 * .
 * Test Set 1 (Visible Verdict)
 * 1≤N≤10
 * .
 * Test Set 2 (Visible Verdict)
 * 1≤N≤105
 * .
 * Sample
 * Sample Input
 * save_alt
 * content_copy
 * 3
 * 10 3 3
 * 2 7 9
 * 10 2 3
 * 2 7 9
 * 10 2 4
 * 2 3 7 9
 * Sample Output
 * save_alt
 * content_copy
 * Case #1: 2
 * Case #2: IMPOSSIBLE
 * Case #3: 4
 * In Sample Case #1, Onyaomale can illuminate the entire freeway by placing bulbs in the western-most and middle street lights only, leaving the eastern-most one unused. With these two lights covering [0,5]
 * and [4,10]
 * , the entire freeway ([0,10]
 * ) is illuminated.
 * <p>
 * Illustration of sample case 1
 * In Sample Case #2, Onyaomale has the same configuration as in Sample Case #1, but with weaker lightbulbs. In this case, there is no way for her to illuminate the entire freeway. In particular, even if all the street lights are lit, the middle point between the 4
 * -th and 5
 * -th meters would still not be illuminated.
 * <p>
 * Illustration of sample case 2
 * For Sample Case #3 Onyaomale has an additional street light at the 3
 * -th meter, compared to Sample Case #2, while all other conditions are the same. In this case, installing a lightbulb in every street light is the only way to have the entire freeway illuminated.
 * <p>
 * Illustration of sample case 3
 */
public class GoogleJam2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int M = scanner.nextInt();
            int R = scanner.nextInt();
            int N = scanner.nextInt();
            int[] X = new int[N];
            for (int i = 0; i < N; i++) {
                X[i] = scanner.nextInt();
            }
            int ans = solve(M, R, X);
            if (ans == -1) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                System.out.printf("Case #%d: %d\n", t, ans);
            }
        }
        scanner.close();
    }

    static int solve(int Meters, int Radius, int[] X) {
        int count = -1;

        int startMeter = X[0] - Radius;
        int endMeter = X[0] + Radius;
        count++;
        if (endMeter >= Meters) {
            return count;
        }

        for (int i = 1; i < X.length; i++) {
            count++;
            int curStart = X[i] - Radius;
            int curEnd = X[i] + Radius;

            if (endMeter >= curStart) {
                endMeter = curEnd;
            } else {
                return -1;
            }
            if (endMeter >= Meters) {
                return count + 1;
            }
        }

        if (startMeter <= 0 && endMeter >= Meters) {
            return count + 1;
        } else {
            return -1;
        }

    }
}
