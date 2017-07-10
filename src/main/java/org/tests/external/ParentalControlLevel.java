package org.tests.external;

/**
 * Created by GArlington on 09/02/2016.
 */
public enum ParentalControlLevel {
    Level_U("U", 0),
    Level_PG("PG", 1),
    Level_12("12", 12),
    Level_15("15", 15),
    Level_18("18", 18);

    private final String name;
    private final int ordinal;

    ParentalControlLevel(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }
}
