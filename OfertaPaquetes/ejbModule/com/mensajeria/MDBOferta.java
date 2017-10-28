package com.mensajeria;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MDBOferta
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/toPortalWeb"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/toPortalWeb")
public class MDBOferta implements MessageListener {

    /**
     * Default constructor. 
     */
    public MDBOferta() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	try {
    		String messageText = null;
    		if(message instanceof TextMessage){
    		messageText = ((TextMessage)message).getText();
    		}
    		Logger.getAnonymousLogger().info("Mensaje recibido: " + messageText);
    		} catch (Exception e) {
    		Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage(), e);
    		}
        
    }

}
