package sopt.twosome.enums;

public enum Togo {
    OUT(0),
    IN(1);

    private final int index;

    Togo(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
