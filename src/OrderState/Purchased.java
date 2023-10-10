package OrderState;

public class Purchased implements StatusState {
    @Override
    public void Status() {
        System.out.println("\u001B[32m" + "Status: item is purchased..." + "\u001B[0m");
    }
}
