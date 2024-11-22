package sopt.twosome.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Temperature {
    ICE(0),
    HOT(1);

    private final int index;

    public int getIndex() {
        return index;
    }


}
