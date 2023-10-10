package Factory;

import Products.Cheesecake;
import Products.Confectionery;
import Products.RedVelvet;

public class RedvelvetFactory implements ConfectioneryFactory {
    @Override
    public Confectionery createConfectionery() {
        return new RedVelvet();
    }
}
