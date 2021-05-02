package br.com.cleanhouse.entity.enums;

public enum TypeUserProfile {

    MAID(1),
    HOUSE_OWNER(2);

    private int code;

    TypeUserProfile(int valueCode) {
        this.code = valueCode;
    }
}
