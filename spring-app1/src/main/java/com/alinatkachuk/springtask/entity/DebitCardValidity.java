package com.alinatkachuk.springtask.entity;

public enum DebitCardValidity {

    ONE(1),
    THREE(3),
    FIVE (5);

    private final int value;
    private DebitCardValidity(int value) {
        this.value=value;
    }

    public int getDebitCardValidity() {
        return value;
    }
}
