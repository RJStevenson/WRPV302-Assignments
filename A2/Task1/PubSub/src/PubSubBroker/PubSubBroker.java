package PubSubBroker;

import Result.Result;

import javax.management.ObjectInstance;
import java.util.HashMap;
import java.util.Map;

public class PubSubBroker<T> {
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

    public boolean Publish(String TopicName, T Data)
    {
        Topic temp = Topics.get(TopicName);
        if(temp==null)
        {
            return false;
        }
        temp.Data= Data;
        return temp.Publish();
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

    public boolean RegisterTopic(String TopicName, T data)
    {
        if(Topics.get(TopicName)==null) {
            Topics.put(TopicName, new Topic(TopicName, data));
            return true;
        }
        else
        {
            return false;
        }
    }

/**
    public Result SubscribeWithResult(String TopicName, Subscriber OnMessageReceived)
    {
        Topic topic = Topics.get(TopicName);
        if (topic!=null) {
            topic.Subscribers.add(OnMessageReceived);
            return new Result<Topic>(topic);
        }
        return  new Result(false, "Topic not found with name " + TopicName);
    }

    public Result PublishWithResult(String TopicName, T Data)
    {
        return null;

    }


    public Result RegisterTopicWithResult(String TopicName, T data)
    {
        if(Topics.get(TopicName)==null) {
            Topics.put(TopicName, new Topic(TopicName, data));
            return new Result(data);
        }
        else
        {
            return new Result(false, "Topic Already Exists with name: " + TopicName);
        }
    }
    **//
}