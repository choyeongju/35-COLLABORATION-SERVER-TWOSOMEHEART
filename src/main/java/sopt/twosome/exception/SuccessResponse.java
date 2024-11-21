package sopt.twosome.exception;


import com.fasterxml.jackson.annotation.JsonInclude;

public record SuccessResponse<T>(
        int status,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data
)
{
    public static <T> SuccessResponse<T> of(SuccessCode successCode, T data) {
        return new SuccessResponse<>(successCode.getHttpStatus().value(), data);
    }

    //응답에 data 없을 때
    public static SuccessResponse<Void> of(SuccessCode successCode) {
        return new SuccessResponse<>(successCode.getHttpStatus().value(), null);
    }

}
