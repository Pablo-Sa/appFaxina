package br.com.cleanhouse.entity.enums;

public enum TypeUserProfile {

    MAID(0),
    HOUSE_OWNER(1);

    private int code;

    TypeUserProfile(int valueCode) {
        this.code = valueCode;
    }
}
