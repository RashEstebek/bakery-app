package Products;

import Payment.Shop;

public class Cheesecake extends Shop implements Confectionery {
    @Override
    public String getDescription() {
        return "You added cheesecake ";
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
