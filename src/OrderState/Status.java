package OrderState;

public class Status {
    StatusState status;

    public void setStatus(StatusState status){
        this.status=status;
    }

    public void changeStatus(){
        if(status instanceof NotPicked){
            setStatus(new InCart());
        }
        else if(status instanceof InCart){
            setStatus(new NotPurchased());
        }
        else if(status instanceof NotPurchased){
            setStatus(new Purchased());
        }
        else if(status instanceof Purchased){
            setStatus(new NotPicked());
        }
    }
    public void showStatus(){
        status.Status();
    }
}
