import Observer.ISubscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart implements ISubscriber {
    private static ShoppingCart INSTANCE;
    private static String check = " ";

    public static ShoppingCart getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ShoppingCart();
        }
        return INSTANCE;
    }

    private ShoppingCart(){

    }

    public void addProduct(String productName){
        check += productName + "\n";
    }

    public void showProduct(){
        System.out.println("\n\\\u001B[32m=========== YOUR CART UPDATED ===========\\\u001B[0m");
        System.out.println("\n================= YOUR CART =================" +
                "\n" + check);
    }

    @Override
    public void update(String productName) {
        addProduct(productName);
        showProduct();
    }
}
