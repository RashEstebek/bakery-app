package Products;

import Payment.Shop;

public class WhoopiePie extends Shop implements Confectionery {
    @Override
    public String getDescription() {
        return "You added whoopie pie ";
    }

    @Override
    public int price() {
        return 480;
    }
    @Override
    public void pay() {
        super.pay();
    }
}
