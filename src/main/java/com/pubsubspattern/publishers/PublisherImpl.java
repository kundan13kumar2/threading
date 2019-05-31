package com.pubsubspattern.publishers;

import com.pubsubspattern.Message;
import com.pubsubspattern.pubsubservices.PubSubServices;

public class PublisherImpl implements Publisher {

    @Override
    public void publish(Message message, PubSubServices pubSubServices) {
        pubSubServices.addMessageToQueue(message);
    }
}
