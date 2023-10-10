package Decorators;

import Products.Confectionery;

public class ChocolateTopper extends TopperDecorator {
    public ChocolateTopper(Confectionery confectionery) {
        super(confectionery);
    }

    @Override
    public String getDescription() {

        return super.getDescription() + "and chocolate topper for ";
    }

    @Override
    public int price() {

        return super.price() + 100;
    }
}
