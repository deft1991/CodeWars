package com.codewars.level7;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MysteryColorAnalyzerImpl implements MysteryColorAnalyzer {

    @Override
    public int numberOfDistinctColors(List<Color> mysteryColors) {
//        Set<Color> rez = new HashSet<>();
//        for (Color mysteryColor : mysteryColors) {
//            rez.add(mysteryColor);
//        }
//        return rez.size();
        return (int) mysteryColors.stream().distinct().count();
    }

    @Override
    public int colorOccurrence(List<Color> mysteryColors, Color color) {
//        int count = 0;
//        for (Color mysteryColor : mysteryColors) {
//            if (color == mysteryColor) count++;
//        }
//        return count;
        return (int) mysteryColors.stream().filter(color::equals).count();
    }
}
