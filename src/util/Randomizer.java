package util;

import java.util.ArrayList;
import java.util.Random;

public class Randomizer {
    public static <T> T getRandomElement(ArrayList<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
