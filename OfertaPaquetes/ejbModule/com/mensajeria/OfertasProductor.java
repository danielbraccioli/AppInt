package com.mensajeria;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;

/**
 * Session Bean implementation class OfertasProductor
 */
@Stateless
@LocalBean
public class OfertasProductor implements OfertasProductorRemote, OfertasProductorLocal {

	@Resource(lookup = "java:/jms/queue/toPortalWeb")
	private Queue testQueue;

	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	JMSContext context;

	public void sendMessage(String messageText) {
		TextMessage message = context.createTextMessage(messageText);
		context.createProducer().send(testQueue, message);
	}

}
