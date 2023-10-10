package Products;
import Payment.Shop;

public class RedVelvet extends Shop implements Confectionery {
    @Override
    public String getDescription() {
        return "You added red velvet ";
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
