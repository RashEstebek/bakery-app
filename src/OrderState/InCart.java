package OrderState;

import jdk.swing.interop.SwingInterOpUtils;

public class InCart implements StatusState{
    @Override
    public void Status() {
        System.out.println("\u001B[33m" + "Status: item(s) are in cart..." + "\u001B[0m");
    }
}
