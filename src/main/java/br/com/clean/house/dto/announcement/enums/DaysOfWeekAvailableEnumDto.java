package br.com.clean.house.dto.announcement.enums;

public enum DaysOfWeekAvailableEnumDto {

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int codeOfDay;
    DaysOfWeekAvailableEnumDto(int codeValue) {
        this.codeOfDay = codeValue;
    }
}
