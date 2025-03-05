package ru.productstar.servlets.enums;

public enum TypeTransaction {
    INCOME("Income"),
    EXPENSE("Expense");

    private final String type;

    TypeTransaction(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
