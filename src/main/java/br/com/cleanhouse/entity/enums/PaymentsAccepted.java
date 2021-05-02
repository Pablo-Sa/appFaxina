package br.com.cleanhouse.entity.enums;

public enum PaymentsAccepted {
    CREDIT_CARD(1),
    DEBIT_CARD(2),
    IN_CASH(3),
    PIX(4),
    BANK_TRANSFERS(5),
    CHECK_BOOK(6);

    private Integer code;

    PaymentsAccepted(Integer codeValue){
        this.code = codeValue;
    }
}
