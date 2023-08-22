package PubSubBroker;

import Result.Result;

import javax.management.ObjectInstance;
import java.util.HashMap;
import java.util.Map;

public class PubSubBroker {
    private static PubSubBroker BrokerInstance;
    private Map<String, Topic> Topics;

    private PubSubBroker()
    {
        Topics = new HashMap<String, Topic>();
    }

    public static PubSubBroker getInstance(){
        if (BrokerInstance!=null)
            return BrokerInstance;
        BrokerInstance = new PubSubBroker();
        return BrokerInstance;
    }

    public boolean Subscribe(String TopicName, Subscriber OnMessageReceived)
    {
        Topic topic = Topics.get(TopicName);
        if (topic!=null) {
            return topic.AddSub(OnMessageReceived);
        }
        return false;
    }

    public boolean Publish(String TopicName, Object data)
    {
        Topic temp = Topics.get(TopicName);
        if(temp==null || !temp.Type.equals(data.getClass()))
        {
            return false;
        }
        return temp.Publish(data);
    }

    public boolean UnSubscribe(Subscriber subscriber, String TopicName)
    {
        Topic temp = Topics.get(TopicName);
        if(temp==null)
        {
           return false;
        }
        temp.UnSub(subscriber);
        return true;
    }

    public boolean RegisterTopic(String TopicName, Class type)
    {
        if(Topics.get(TopicName)==null) {
            Topics.put(TopicName, new Topic(TopicName, type));
            return true;
        }
        else
        {
            return false;
        }
    }

}