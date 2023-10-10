package OrderState;

public class NotPicked implements StatusState{
    @Override
    public void Status() {
        System.out.println("\u001B[31m" + "Status: you haven't picked any item..." + "\u001B[0m");
    }
}
