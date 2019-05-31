package com.pubsubspattern.publishers;

import com.pubsubspattern.Message;
import com.pubsubspattern.pubsubservices.PubSubServices;

public interface Publisher {

    void publish(Message message, PubSubServices pubSubServices);

}
