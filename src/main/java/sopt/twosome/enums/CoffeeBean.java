package sopt.twosome.enums;

public enum CoffeeBean {
    BLACK(0),
    AROMA(1),
    DECAFFEINE(2);

    private final int index;

    CoffeeBean(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
