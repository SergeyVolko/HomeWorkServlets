package ru.productstar.servlets.model;

import ru.productstar.servlets.enums.TypeTransaction;

public class Transaction  {
    private String name;
    private int sum;
    private TypeTransaction typeTransaction;

    public Transaction(String name, int sum, TypeTransaction typeTransaction) {
        this.name = name;
        this.sum = sum;
        this.typeTransaction = typeTransaction;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                ", typeTransaction=" + typeTransaction +
                '}';
    }
}
