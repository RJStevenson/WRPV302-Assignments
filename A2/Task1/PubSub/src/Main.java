import PubSubBroker.PubSubBroker;
import PubSubBroker.Subscriber;

import java.nio.channels.Pipe;

public class Main {
    Integer pine =1;
    public static void main(String[] args) {
        PubSubBroker broker =  PubSubBroker.getInstance();

        Boolean temp = broker.Publish("Banna", 2);
        temp = broker.RegisterTopic("Score", Integer.class);
        Main man = new Main();
        broker.Subscribe("Score",man.onMessageReceived );

        Integer obama = 5;
        temp = broker.Publish("Score", obama);

        System.out.println(man.pine);

    }


    public Subscriber onMessageReceived = new Subscriber() {
        @Override
        public void OnMessageReceived(Object Data) {
            pine = (Integer) Data;
        }
    };

}
