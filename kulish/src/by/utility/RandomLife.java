package by.utility;

import by.country.Country;
import by.country.LiberationType;

public class RandomLife {
    public static int RandomPeople() {
        return (int) Math.round(Math.random() * 40);
    }

    public static double RandomMark() {
        return 2.0 + Math.round(Math.random() * 3.0 * 10) / 10.0;
    }

    public static boolean RandomState() {
        return Math.round(Math.random() + (Country.getInstance().getLiberationType() == LiberationType.High ? 0.05 : 0.35)) == 0;
    }
}
