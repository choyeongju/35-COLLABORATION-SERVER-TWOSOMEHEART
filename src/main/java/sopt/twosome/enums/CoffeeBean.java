package sopt.twosome.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CoffeeBean {
    BLACK(0),
    AROMA(1),
    DECAFFEINE(2);

    private final int index;

    public int getIndex() {
        return index;
    }
}
