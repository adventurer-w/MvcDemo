package com.example.mvcdemo.modle;

import com.example.mvcdemo.money.Money;

public class Moneymodel {
    private static Money money = new Money();

    static {
        money.setNumber(0);
    }

    public void addNumber() {
        money.setNumber(money.getNumber() + 64);
    }

    public void reduceNumber(int n) {
        money.setNumber(money.getNumber() - n);
    }
    public int getMoney(){
        return money.getNumber();
    }
    public String selectData(){
        return money.toString();
    }
}
