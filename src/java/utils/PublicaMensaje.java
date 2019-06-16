package utils;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * @author Asathor
 */
public class PublicaMensaje {

    private final LogClass log;
    private final String QUEUE = "libros.facturas";
    private final String URL = "tcp://localhost:61616";
    Connection conexion;
    Session sesion;
    Destination destino;
    MessageProducer productor;

    private PublicaMensaje() {
        log = LogClass.crearLog(PublicaMensaje.class.getName());
    }


    public static PublicaMensaje crearPublicador() {
        return new PublicaMensaje();
    }


    private void setConexion() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        conexion = connectionFactory.createConnection();
        conexion.start();
        log.info("Creando conexion de ActiveMQ");
    }


    private void setSesion(boolean transaccional) throws JMSException {
        sesion = conexion.createSession(transaccional, Session.AUTO_ACKNOWLEDGE);
        log.info("Estableciendo la sesion de ActiveMq");
    }


    private void setDestino() throws JMSException {
        destino = sesion.createQueue(QUEUE);
        log.info("Estableciendo cola de destino en" + QUEUE);
    }


    private void setProductor() throws JMSException {
        productor = sesion.createProducer(destino);
        productor.setDeliveryMode(DeliveryMode.PERSISTENT);
        log.info("Estableciendo el productor de mensajes.");
    }


    private TextMessage crearMensaje(String textoMensaje) throws JMSException {
        log.info("Estableciendo el mensaje");
        log.info(textoMensaje);
        return sesion.createTextMessage(textoMensaje);
    }


    private void configurarMensaje() throws JMSException {
        setConexion();
        setSesion(false);
        setDestino();
        setProductor();
        log.info("ActiveMQ configurado");
    }


    public void enviar(String textoMensaje) throws JMSException {
        configurarMensaje();
        productor.send(crearMensaje(textoMensaje));
        log.info("Enviando el mensaje");
        cerrarConexion();
    }


    private void cerrarConexion() throws JMSException {
        if (productor != null) {
            productor.close();
            productor = null;
            log.info("Productor cerrado.");
        }
        if (sesion != null) {
            sesion.close();
            sesion = null;
            log.info("Sesion cerrada.");
        }
        if (conexion != null) {
            conexion.close();
            conexion = null;
            log.info("Conexion cerrada.");
        }
    }


}
