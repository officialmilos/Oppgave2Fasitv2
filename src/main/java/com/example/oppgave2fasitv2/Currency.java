package com.example.oppgave2fasitv2;

//Simple POJO (Plain Old Java Object) class for currency
public class Currency {
    private String currency;
    private double rate;

    public Currency(String currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public Currency() {}

    public String getCurrency() {
        return currency;
    }

    public double getRate() {
        return rate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
}