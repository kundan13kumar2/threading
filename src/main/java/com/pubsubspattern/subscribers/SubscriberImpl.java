package com.pubsubspattern.subscribers;

import com.pubsubspattern.pubsubservices.PubSubServices;

public class SubscriberImpl extends Subscriber {
    @Override
    public void addSubscriber(String topic, PubSubServices pubSubServices) {
        pubSubServices.addSubscriber(topic, this);
    }

    @Override
    public void unSubscriber(String topic, PubSubServices pubSubServices) {
        pubSubServices.removeSubscriber(topic, this);
    }

    @Override
    public void getMessagesForSubscriberOfTopic(String topic, PubSubServices pubSubServices) {
        pubSubServices.getMessagesForSubscriberofTopic(topic, this);
    }
}
