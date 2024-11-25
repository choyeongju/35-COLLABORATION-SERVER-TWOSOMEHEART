package sopt.twosome.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import sopt.twosome.exception.ErrorCode;
import sopt.twosome.exception.InvalidArgsException;

@AllArgsConstructor
public enum Togo {
    OUT(0, "포장"),
    IN(1, "매장");

    private final int index;
    private final String value;


    @JsonCreator
    public static Togo fromIndex(int index) {
        for (Togo togo : Togo.values()) {
            if (togo.index == index) {
                return togo;
            }
        }
        throw new InvalidArgsException(ErrorCode.INVALID_OPTIONS);
    }

    public int getIndex() {
        return index;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
