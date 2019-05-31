package com.pubsubspattern.subscribers;

import com.pubsubspattern.Message;
import com.pubsubspattern.pubsubservices.PubSubServices;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {

    private List<Message> subscriberMessages = new ArrayList<>();

    public List<Message> getSubscriberMessages() {
        return subscriberMessages;
    }

    public void setSubscriberMessages(List<Message> subscriberMessages) {
        this.subscriberMessages = subscriberMessages;
    }

    public abstract void addSubscriber(String topic, PubSubServices pubSubServices);

    public abstract void unSubscriber(String topic, PubSubServices pubSubServices);


    public abstract void getMessagesForSubscriberOfTopic(String topic, PubSubServices pubSubServices);

    public void printMessages() {
        for (Message message : subscriberMessages) {
            System.out.println("Message topic -> " + message.getTopic() + " : " + message.getPayload());
        }
    }

}
