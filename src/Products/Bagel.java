package Products;

import Payment.Shop;

public class Bagel extends Shop implements BakedGoods {
    @Override
    public String getDescription() {
        return "You added bagel ";
    }

    @Override
    public int price() {
        return 300;
    }

    @Override
    public void pay() {
        super.pay();
    }
}
