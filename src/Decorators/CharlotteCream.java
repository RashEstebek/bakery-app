package Decorators;

import Products.Confectionery;

public class CharlotteCream extends CreamDecorator {
    public CharlotteCream(Confectionery confectionery) {

        super(confectionery);
    }

    @Override
    public String getDescription() {

        return super.getDescription() + "with charlotte cream ";
    }

    @Override
    public int price() {

        return super.price() + 150;
    }
}
