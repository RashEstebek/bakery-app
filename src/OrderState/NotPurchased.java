package OrderState;

public class NotPurchased implements StatusState{
    @Override
    public void Status() {
        System.out.println("\u001B[33m" + "Status: item is not purchased..." + "\u001B[0m");
    }
}
