package Products;

import Payment.Shop;

public class NapoleonCake extends Shop implements Confectionery {
    @Override
    public String getDescription() {
        return "You added napoleon cake ";
    }

    @Override
    public int price() {
        return 500;
    }
    @Override
    public void pay() {
        super.pay();
    }
}
