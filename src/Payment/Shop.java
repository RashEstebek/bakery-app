package Payment;

public class Shop {
    IPayment ipayment;
//new PayByCreditCard()
    public void setPaymentMethod(IPayment ipayment){
        this.ipayment = ipayment;
    }

    public void pay(){
        ipayment.pay();
    }

}
