package Decorators;

import Products.Confectionery;

public class ChantillyCream extends CreamDecorator {
    public ChantillyCream(Confectionery confectionery) {
        super(confectionery);
    }

    @Override
    public String getDescription() {

        return super.getDescription() + "with chantilly cream ";
    }

    @Override
    public int price() {

        return super.price() + 130;
    }
}
