package utils;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author asathor
 */
public class LogClass {

    private static Logger log;

    private LogClass(String clase) {
        log = Logger.getLogger(clase);
    }


    public static LogClass crearLog(String clase) {
        return new LogClass(clase);
    }


    public void error(String mensaje, Object objeto) {
        log.log(Level.SEVERE, mensaje, objeto);
    }


    public void info(String mensaje) {
        log.log(Level.INFO, mensaje);
    }


}
