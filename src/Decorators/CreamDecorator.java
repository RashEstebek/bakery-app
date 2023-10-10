package Decorators;

import Products.Confectionery;

public class CreamDecorator implements Confectionery {
    Confectionery confectionery;

    public CreamDecorator(Confectionery confectionery){

        this.confectionery=confectionery;
    }
    @Override
    public String getDescription() {

        return confectionery.getDescription();
    }

    @Override
    public int price() {

        return confectionery.price();
    }
}
