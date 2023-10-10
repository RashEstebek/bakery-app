package Observer;

import java.util.ArrayList;
import java.util.List;

public class AddItemPublisher {

    private static AddItemPublisher INSTANCE = new AddItemPublisher();

    private AddItemPublisher() {

    }

    public static AddItemPublisher getInstance() {
        return INSTANCE;
    }

    private final List<ISubscriber> subscribers = new ArrayList<>();

    public void addSubscriber(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void publish(String productName) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(productName);
        }
    }
    
}
