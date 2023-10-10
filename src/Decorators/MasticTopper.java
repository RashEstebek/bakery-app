package Decorators;

import Products.Confectionery;

public class MasticTopper extends TopperDecorator{
    public MasticTopper(Confectionery confectionery) {

        super(confectionery);
    }

    @Override
    public String getDescription() {

        return super.getDescription() + "and mastic topper for ";
    }

    @Override
    public int price() {

        return super.price() + 160;
    }
}
