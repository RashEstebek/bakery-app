package Factory;
import Products.BakedGoods;
import Products.Pretzel;
public class PretzelFactory implements BakedGoodsFactory {
    @Override
    public BakedGoods createBakedGoods() {
        return new Pretzel();
    }
}
