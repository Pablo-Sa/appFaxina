package br.com.clean.house.entity.enums;

public enum AcceptedPaymentsEnum {
    CREDIT_CARD(1),
    DEBIT_CARD(2),
    IN_CASH(3),
    PIX(4),
    BANK_TRANSFERS(5),
    CHECK_BOOK(6);

    private Integer code;

    AcceptedPaymentsEnum(Integer codeValue){
        this.code = codeValue;
    }
}
