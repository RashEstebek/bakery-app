package Products;

import Payment.Shop;

public class Pretzel extends Shop implements BakedGoods {
    @Override
    public String getDescription() {
        return "You added pretzel ";
    }

    @Override
    public int price() {
        return 400;
    }

    @Override
    public void pay() {
        super.pay();
    }
}
