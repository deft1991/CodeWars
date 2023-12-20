package com.codewars.leetcode.daily;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 17.12.2023
 */
public class DesignFoodRatingSystem {

    public static void main(String[] args) {
        String[] foods = new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = new int[]{9, 12, 8, 15, 14, 7};
        FoodRatings f = new FoodRatings(foods, cuisines, ratings);
        System.out.println(f.highestRated("korean")); // kimchi
        System.out.println(f.highestRated("japanese")); // ramen
        f.changeRating("sushi", 16);
        System.out.println(f.highestRated("japanese")); // sushi
        f.changeRating("ramen", 16);
        System.out.println(f.highestRated("japanese")); // ramen
    }

    static class FoodRatings {

        private Map<String, Food> mapFood;
        private Map<String, Set<Food>> mapCusine;
        // Firstly, a hash table is needed to efficiently map each food item to its cuisine and current rating.
        // In addition, another hash table is needed to map cuisines to foods
        // within each cuisine stored in an ordered set according to their ratings.
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            mapFood = new HashMap<>();
            mapCusine = new HashMap<>();

            for (int i = 0; i < foods.length; i++){
                Food f = new Food(foods[i], cuisines[i], ratings[i]);
                mapFood.put(foods[i], f);

                Set<Food> set = mapCusine.getOrDefault(cuisines[i], new TreeSet<>((a,b) -> {
                    if (Integer.compare(b.rating, a.rating) == 0){
                        return a.food.compareTo(b.food);
                    }
                    return Integer.compare(b.rating, a.rating);
                }));
                set.add(f);
                mapCusine.put(cuisines[i], set);
            }
        }

        public void changeRating(String food, int newRating) {
            Food f = mapFood.get(food);
            Set<Food> foods = mapCusine.get(f.cuisine);
            foods.remove(f);
            f.rating = newRating;
            foods.add(f);
            mapCusine.put(f.cuisine, foods);
        }

        public String highestRated(String cuisine) {
            Set<Food> foods = mapCusine.get(cuisine);
            return foods.stream().findFirst().get().food;
        }
    }

    static class Food {
        String food;
        String cuisine;
        int rating;

        Food(String food, String cuisine, int rating){
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

}
