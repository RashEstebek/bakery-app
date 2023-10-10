package Factory;
import Products.BakedGoods;
import Products.Brioche;


public class BriocheFactory implements BakedGoodsFactory {
    @Override
    public BakedGoods createBakedGoods() {
        return new Brioche();
    }
}
