package Payment;

public class PayByCreditCard implements IPayment{
    @Override
    public void pay() {
        System.out.println("Your item is purchasing by credit card...");
    }
}
