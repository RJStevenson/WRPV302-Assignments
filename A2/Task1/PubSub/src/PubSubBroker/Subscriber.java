package PubSubBroker;

@FunctionalInterface
public interface Subscriber {
    void OnMessageReceived(Object Data);
}
