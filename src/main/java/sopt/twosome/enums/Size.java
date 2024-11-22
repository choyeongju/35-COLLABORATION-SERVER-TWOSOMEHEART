package sopt.twosome.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Size {
    REGULAR(0),
    LARGE(1);

    private final int index;

    public int getIndex() {
        return index;
    }


}
