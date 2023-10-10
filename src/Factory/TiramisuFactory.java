package Factory;

import Products.Confectionery;
import Products.Tiramisu;

public class TiramisuFactory implements ConfectioneryFactory {
    @Override
    public Confectionery createConfectionery() {
        return new Tiramisu();
    }
}
