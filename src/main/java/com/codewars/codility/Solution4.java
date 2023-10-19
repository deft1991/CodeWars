package com.codewars.codility;

/**
 * @author Sergey Golitsyn
 * created on 07.09.2023
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.CountingMinutes("12:30pm-12:00am"));
        System.out.println(s.CountingMinutes("1:23am-1:08am"));
    }

    public static String CountingMinutes(String str) {
        // Split the start and end times from the input string
        String[] startArr = str.split("-");
        String startTime = startArr[0];
        String endTime = startArr[1];

        // Convert the start and end times to minutes from midnight
        int startMinutes = getMinutesFromMidnight(startTime);
        int endMinutes = getMinutesFromMidnight(endTime);

        // Calculate the time difference, ensuring that it's a positive value
        int timeDiff = (endMinutes - startMinutes + 1440) % 1440;
        // Return the time difference in minutes
        return String.valueOf(timeDiff);
    }

    static int getMinutesFromMidnight(String timeStr) {
        StringBuilder sb = new StringBuilder();
        sb.substring(2);
        // Split the hours and minutes from the time string
        String[] timeArr = timeStr.substring(0, timeStr.length() - 2).split(":");
        String hourStr = timeArr[0];
        String minuteStr = timeArr[1];

        // Convert the hours and minutes to integers
        int hour = Integer.parseInt(hourStr);
        int minute = Integer.parseInt(minuteStr);

        // Determine if the time is in the PM
        boolean isPM = timeStr.endsWith("pm");

        // Convert the time to minutes from midnight
        int totalMinutes = hour * 60 + minute;
        return isPM ? totalMinutes + 720 : totalMinutes;
    }
}
