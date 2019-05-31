package com.pubsubspattern.pubsubservices;

import com.pubsubspattern.Message;
import com.pubsubspattern.subscribers.Subscriber;

import java.util.*;

public class PubSubServices {


    Map<String, Set<Subscriber>> topicSubsribersMap = new HashMap<>();

    Queue<Message> messageQueue = new LinkedList<>();

    public void addMessageToQueue(Message message) {
        messageQueue.add(message);
    }

    public void addSubscriber(String topic, Subscriber subscriber) {

        Set<Subscriber> existingSubscriberSet = topicSubsribersMap.computeIfAbsent(topic, set -> new HashSet<>());
        existingSubscriberSet.add(subscriber);
        topicSubsribersMap.put(topic, existingSubscriberSet);

    }

    public void removeSubscriber(String topic, Subscriber subscriber) {

        Set<Subscriber> subscribersSet = topicSubsribersMap.get(topic);
        subscribersSet.remove(subscriber);
        topicSubsribersMap.put(topic, subscribersSet);

    }

    public void broadcast() {

        if (messageQueue.isEmpty())
            System.out.println("No messages from publishers to display!!");
        else {
            while (!messageQueue.isEmpty()) {
                Message message = messageQueue.remove();

                String topic = message.getTopic();
                Set<Subscriber> topicSubscriber = topicSubsribersMap.get(topic);

                for (Subscriber subscriber : topicSubscriber) {

                    List<Message> subscriberMessages = subscriber.getSubscriberMessages();
                    subscriberMessages.add(message);
                    subscriber.setSubscriberMessages(subscriberMessages);

                }
            }
        }

    }


    public void getMessagesForSubscriberofTopic(String topic, Subscriber subscriber){
        if(messageQueue.isEmpty()){
            System.out.println("No Message from publishers to display");
        }
        else {
            while (!messageQueue.isEmpty()){
                Message message=messageQueue.remove();

                if(message.getTopic().equalsIgnoreCase(topic)){

                    Set<Subscriber> subscriberSetOfTopic=topicSubsribersMap.get(topic);

                    for(Subscriber _subscriber :subscriberSetOfTopic){
                        if(_subscriber.equals(subscriber)){
                            List<Message> subscriberMessage=subscriber.getSubscriberMessages();
                            subscriberMessage.add(message);
                            subscriber.setSubscriberMessages(subscriberMessage);
                        }
                    }

                }
            }
        }
    }


}
