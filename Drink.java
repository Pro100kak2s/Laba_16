package com.company;

public final class Drink extends MenuItem implements Alcoholable{
    private double alcoholVol;
    private DrinkTypeEnum type;

    public Drink() {
        super();
    }

    public DrinkTypeEnum getType() {
        return type;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return type.isAlcohol();
    }

    @Override
    public double getAlcoholVol() {
        return 0;
    }
}
