package Factory;
import Products.BakedGoods;
import Products.Bagel;

public class BagelFactory implements BakedGoodsFactory {
    @Override
    public BakedGoods createBakedGoods() {
        return new Bagel();
    }
}
