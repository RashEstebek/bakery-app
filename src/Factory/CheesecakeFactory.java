package Factory;

import Products.Cheesecake;
import Products.Confectionery;

public class CheesecakeFactory implements ConfectioneryFactory {
    @Override
    public Confectionery createConfectionery() {
        return new Cheesecake();
    }
}
