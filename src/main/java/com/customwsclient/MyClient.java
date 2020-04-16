/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.customwsclient;

import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.ActorMaterializerSettings;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import play.libs.ws.*;
import play.libs.ws.ahc.*;

import java.net.URI;
import java.util.Optional;

/**
 * @author Kundan Kumar
 * @version $Id: CustomWSClient.java, v 0.1 2020-03-22 6:18 PM Kundan Kumar Exp $$
 */
public class MyClient   {
    public static void main(String[] args) {
        
        WebClient client1 = WebClient.create();
        WebClient.ResponseSpec response = client1.post().uri(URI.create("https://www.google.com/")).retrieve(); 
        
        
    }
}