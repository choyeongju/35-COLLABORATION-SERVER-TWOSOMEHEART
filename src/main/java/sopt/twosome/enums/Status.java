package sopt.twosome.enums;


import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    NEW("New"),
    BEST("Best"),
    DEFAULT("Default");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }
}