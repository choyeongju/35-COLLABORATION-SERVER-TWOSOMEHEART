package sopt.twosome.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import sopt.twosome.exception.ErrorCode;
import sopt.twosome.exception.InvalidArgsException;

@AllArgsConstructor
public enum Size {
    REGULAR(0, "레귤러"),
    LARGE(1, "라지");

    private final int index;
    private final String value;


    @JsonCreator
    public static Size fromIndex(int index) {
        for (Size size : Size.values()) {
            if (size.index == index) {
                return size;
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
