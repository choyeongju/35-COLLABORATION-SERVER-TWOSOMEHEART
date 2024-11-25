package sopt.twosome.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import sopt.twosome.exception.ErrorCode;
import sopt.twosome.exception.InvalidArgsException;

@AllArgsConstructor
public enum CoffeeBean {
    BLACK(0, "블랙그라운드"),
    AROMA(1, "아로마노트"),
    DECAFFEINE(2, "디카페인");

    private final int index;
    private final String value;


    @JsonCreator
    public static CoffeeBean fromIndex(int index) {
        for (CoffeeBean bean : CoffeeBean.values()) {
            if (bean.index == index) {
                return bean;
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
