package br.com.clean.house.entity.enums;

public enum TypeUserProfileEnum {

    MAID(0),
    HOUSE_OWNER(1);

    private int code;

    TypeUserProfileEnum(int valueCode) {
        this.code = valueCode;
    }
}
