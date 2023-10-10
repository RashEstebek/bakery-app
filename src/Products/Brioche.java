package Products;
import Payment.Shop;

public class Brioche extends Shop implements BakedGoods {
    @Override
    public String getDescription() {
        return "You added brioche ";
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