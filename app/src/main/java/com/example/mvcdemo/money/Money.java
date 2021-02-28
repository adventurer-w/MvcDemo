package com.example.mvcdemo.money;

public class Money {
    private int number;

    public Money(){ }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number+"";
    }
}
