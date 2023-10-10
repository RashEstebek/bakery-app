package Payment;

public class PayByPayPal implements IPayment{
    @Override
    public void pay() {
        System.out.println("your item is purchased by PayPal service ");

    }
}
