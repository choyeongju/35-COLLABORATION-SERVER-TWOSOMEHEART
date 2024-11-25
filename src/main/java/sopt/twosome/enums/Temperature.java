package sopt.twosome.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import sopt.twosome.exception.ErrorCode;
import sopt.twosome.exception.InvalidArgsException;

@AllArgsConstructor
public enum Temperature {
    ICE(0, "아이스"),
    HOT(1, "핫");

    private final int index;
    private final String value;


    @JsonCreator
    public static Temperature fromIndex(int index) {
        for (Temperature temperature : Temperature.values()) {
            if (temperature.index == index) {
                return temperature;
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
