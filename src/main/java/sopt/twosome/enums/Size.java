package sopt.twosome.enums;

public enum Size {
    REGULAR(0),
    LARGE(1);

    private final int index;

    Size(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }


}
