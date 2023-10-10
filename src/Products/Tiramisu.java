package Products;
import Payment.Shop;

public class Tiramisu extends Shop implements Confectionery {
    @Override
    public String getDescription() {
        return "You added tiramisu ";
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
