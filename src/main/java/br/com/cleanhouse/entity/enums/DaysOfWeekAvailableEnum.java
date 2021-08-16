package br.com.cleanhouse.entity.enums;

public enum DaysOfWeekAvailableEnum {

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int codeOfDay;
    DaysOfWeekAvailableEnum(int codeValue) {
        this.codeOfDay = codeValue;
    }
}
