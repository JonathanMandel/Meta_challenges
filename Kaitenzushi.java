import java.util.HashMap;

/**
 * There are N dishes in a row on a kaiten belt, with the ith dish being of type D[i].
 * Some dishes may be of the same type as one another.
 *
 * You're very hungry, but you'd also like to keep things interesting. The N dishes will
 * arrive in front of you, one after another in order, and for each one you'll eat it as
 * long as it isn't the same type as any of the previous K dishes you've eaten.
 *
 * Determine how many dishes you'll end up eating.
 *
 * 1 <= N <= 500,000
 * 1 <= D[i] <= 1,000,000
 */
public class Kaitenzushi {
    public int getMaxDishes(int N, int[] D, int K) {
        // Map of dish # (key) to eat # (value)
        HashMap<Integer, Integer> map = new HashMap<>();
        int eat = 0;
        for (int i=0; i<N; i++) {
            int dish = D[i];
            int lastEat = map.getOrDefault(dish, 0);
            if (lastEat == 0 || lastEat < (eat + 1 - K)) {
                map.put(dish, ++eat);
            }
        }
        return eat;
    }
}
