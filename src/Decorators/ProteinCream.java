package Decorators;

import Products.Confectionery;

public class ProteinCream extends CreamDecorator{
    public ProteinCream(Confectionery confectionery) {
        super(confectionery);
    }

    @Override
    public String getDescription() {

        return super.getDescription() + "with protein cream ";
    }

    @Override
    public int price() {

        return super.price() + 70;
    }
}
