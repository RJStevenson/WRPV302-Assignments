package PubSubBroker;

import java.util.ArrayList;
import java.util.List;

class Topic<T> {
    public String Name;
    public T Data;
    public List<Subscriber<T>> Subscribers;

    //public ObjectInstance Publisher;

    public Topic(String name, T data)
    {
        Subscribers = new ArrayList<>();
        this.Data = data;
        this.Name = name;
    }

    public boolean AddSub(Subscriber sub)
    {
        if(IsInList(sub)==false) {
            Subscribers.add(sub);
            return true;
        }
        return false;
    }

    public void UnSub(Subscriber sub)
    {
        int orginal = Subscribers.size();
        for (int i = 0; i < orginal; i++) {
           if(Subscribers.get(i).equals(sub))
               Subscribers.remove(i);
        }
    }

    public boolean Publish()
    {
        boolean value = true;
        for (int i = 0; i < Subscribers.size(); i++) {

            try {
                Subscribers.get(i).OnMessageReceived(Data);
            } catch (Exception e) {
               value = false;
            }
        }
        return  value;
    }

    private boolean IsInList(Subscriber<T> sub)
    {
        for (int i = 0; i < Subscribers.size(); i++) {
            if(Subscribers.get(i).equals(sub))
                return true;
        }
        return false;
    }
}
