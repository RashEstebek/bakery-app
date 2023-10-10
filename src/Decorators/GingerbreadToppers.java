package Decorators;

import Products.Confectionery;

public class GingerbreadToppers extends TopperDecorator{
    public GingerbreadToppers(Confectionery confectionery) {

        super(confectionery);
    }

    @Override
    public String getDescription() {

        return super.getDescription() + "and gingerbread topper for ";
    }

    @Override
    public int price() {

        return super.price() + 90;
    }
}
