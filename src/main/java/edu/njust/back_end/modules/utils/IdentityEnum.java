package edu.njust.back_end.modules.utils;

import lombok.Getter;

@Getter
public enum IdentityEnum {
    DOCTOR(0, "doctor"),PATIENT(1, "patient");
    private final int value;
    private final String name;

    private IdentityEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

}
