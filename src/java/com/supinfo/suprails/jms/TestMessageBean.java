/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author alexis
 */
@MessageDriven(
    mappedName = "queue/SupRails",
    activationConfig = {
        @ActivationConfigProperty(
            propertyName = "destinationType",
            propertyValue = "javax.jms.queue"
        )
    }
)
public class TestMessageBean implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("New message : " + ((TextMessage) message).getText());
        }
        catch(Exception e) {
            System.out.println("Error when receiving the message : " + e.getMessage());
        }
            
    }
    
}
