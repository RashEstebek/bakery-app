package Decorators;

import Products.Confectionery;

public class TopperDecorator extends CreamDecorator {
    public TopperDecorator(Confectionery confectionery) {
        super(confectionery);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public int price() {
        return super.price();
    }
}
