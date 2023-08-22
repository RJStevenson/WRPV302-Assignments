package PubSubBroker;

@FunctionalInterface
public interface Subscriber<T> {
    void OnMessageReceived(T Data);
}
