package sopt.twosome.enums;

public enum Temperature {
    ICE(0),
    HOT(1);

    private final int index;

    Temperature(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }


}
