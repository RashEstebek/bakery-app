package Factory;

import Products.Confectionery;
import Products.NapoleonCake;

public class NapoleonCakeFactory implements ConfectioneryFactory {
    @Override
    public Confectionery createConfectionery() {
        return new NapoleonCake();
    }
}
