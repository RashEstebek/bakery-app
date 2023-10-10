package Factory;

import Products.Confectionery;
import Products.RedVelvet;
import Products.WhoopiePie;

public class WhoopieFactory implements ConfectioneryFactory {
    @Override
    public Confectionery createConfectionery() {
        return new WhoopiePie();
    }
}
