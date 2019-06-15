package utils;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;


/**
 * @author Asathor
 */
public class PublicaMensaje {

    private static final String ACTION_ID_HEADER = "actionId";
    private static final String ACTION_HEADER = "action";
    private ConnectionFactory connFactory;
    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageProducer msgProducer;
    private String activeMqBrokerUri;
    private String username;
    private String password;

    public PublicaMensaje(final String activeMqBrokerUri, final String username, final String password) {
        super();
        this.activeMqBrokerUri = activeMqBrokerUri;
        this.username = username;
        this.password = password;
    }


    public void setup(final boolean transacted, final boolean isDestinationTopic, final String destinationName)
            throws JMSException {
        setConnectionFactory(activeMqBrokerUri, username, password);
        setConnection();
        setSession(transacted);
        setDdestination(isDestinationTopic, destinationName);
        setMsgProducer();
    }


    public void close() throws JMSException {
        if (msgProducer != null) {
            msgProducer.close();
            msgProducer = null;
        }
        if (session != null) {
            session.close();
            session = null;
        }
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }


    public void commit(final boolean transacted) throws JMSException {
        if (transacted) {
            session.commit();
        }
    }


    public void sendMessage(final String actionVal) throws JMSException {
        TextMessage textMessage = buildTextMessageWithProperty(actionVal);
        msgProducer.send(destination, textMessage);
    }


    private TextMessage buildTextMessageWithProperty(final String txtMessage) throws JMSException {
        TextMessage textMessage = session.createTextMessage(txtMessage);
        return textMessage;
    }


    private void setDdestination(final boolean isDestinationTopic, final String destinationName) throws JMSException {
        if (isDestinationTopic) {
            destination = session.createTopic(destinationName);
        } else {
            destination = session.createQueue(destinationName);
        }
    }


    private void setMsgProducer() throws JMSException {
        msgProducer = session.createProducer(destination);
    }


    private void setSession(final boolean transacted) throws JMSException {
        // transacted=true for better performance to push message in batch mode
        session = connection.createSession(transacted, Session.AUTO_ACKNOWLEDGE);
    }


    private void setConnection() throws JMSException {
        connection = connFactory.createConnection();
        connection.start();
    }


    private void setConnectionFactory(final String activeMqBrokerUri, final String username, final String password) {
        connFactory = new ActiveMQConnectionFactory(username, password, activeMqBrokerUri);
        ((ActiveMQConnectionFactory) connFactory).setUseAsyncSend(true);
        RedeliveryPolicy policy = ((ActiveMQConnectionFactory) connFactory).getRedeliveryPolicy();
        policy.setInitialRedeliveryDelay(500);
        policy.setBackOffMultiplier(2);
        policy.setUseExponentialBackOff(true);
        policy.setMaximumRedeliveries(2);
    }


}
