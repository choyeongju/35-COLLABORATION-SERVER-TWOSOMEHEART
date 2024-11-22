package sopt.twosome.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Togo {
    OUT(0),
    IN(1);

    private final int index;

    public int getIndex() {
        return index;
    }
}
