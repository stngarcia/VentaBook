package utils;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * @author asathor
 */
public class MensajesAMQ {

    private ActiveMQConnectionFactory connectionFactory;
    private Connection conection;
    private Session session;
    private Destination destination;
    private TextMessage msg;
    private String mensaje = "";

    private MensajesAMQ() {
    }


    public static MensajesAMQ crear() {
        return new MensajesAMQ();
    }


    public String getMensaje() {
        return mensaje;
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public void enviarMensaje() throws JMSException {
        connectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
        conection = connectionFactory.createConnection();
        conection.start();
        session = conection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        destination = session.createQueue("libros.facturas");
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        producer.send(session.createTextMessage(mensaje));
        producer.close();
        session.close();
        conection.close();
    }


    public void recibirMensaje() throws JMSException {
        connectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
        conection = connectionFactory.createConnection();
        conection.start();
        session = conection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        destination = session.createQueue("libros.facturas");
        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive(1000);
        if ((null != message) && (message instanceof TextMessage)) {
            this.mensaje = ((TextMessage) message).getText();
        }
        consumer.close();
        session.close();
        conection.close();
    }


}
