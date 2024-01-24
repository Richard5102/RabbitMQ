import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class UtilsQueueDeclaration {

    public static void main(String[] argv) throws Exception {
        final String QUEUE_NAME = "hello";
        final String EXCHANGE_NAME = "topic_logs";

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();

             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT); // CREAR EXCHANGE DE TIPO FANOUT
            channel.queueDeclare(QUEUE_NAME, false, false, false, null); // CREAR QUEUE DEFAULT
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ""); // ENLAZAR EXCHANGE CON QUEUE
            channel.queueDelete(QUEUE_NAME); // BORRAR QUEUE
            channel.exchangeDelete(EXCHANGE_NAME); // BORRAR EXCHANGE
            channel.queuePurge(QUEUE_NAME); // LIMPIAR QUEUE
        }
        crearExchange(EXCHANGE_NAME);
        declararQUEUE(QUEUE_NAME);
        unirEXCHANGEQUEUE(EXCHANGE_NAME, QUEUE_NAME);
        borrarQUEUE(QUEUE_NAME);
        borrarEXCHANGE(EXCHANGE_NAME);
        limpiarQUEUE(QUEUE_NAME);
    }

    public static void crearExchange(String EXCHANGE_NAME) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
             channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT); // CREAR EXCHANGE DE TIPO FANOUT

        }
    }

    public static void declararQUEUE(String QUEUE_NAME) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
               channel.queueDeclare(QUEUE_NAME, false, false, false, null); // CREAR QUEUE DEFAULT
        }
    }

    public static void  unirEXCHANGEQUEUE(String EXCHANGE_NAME, String QUEUE_NAME) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ""); // ENLAZAR EXCHANGE CON QUEUE
        }
    }

    public static void  borrarQUEUE( String QUEUE_NAME) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
             channel.queueDelete(QUEUE_NAME); // BORRAR QUEUE
        }
    }

    public static void  borrarEXCHANGE( String EXCHANGE_NAME) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDelete(EXCHANGE_NAME); // BORRAR EXCHANGE
        }
    }

    public static void  limpiarQUEUE( String QUEUE_NAME) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queuePurge(QUEUE_NAME); // LIMPIAR QUEUE
        }
    }

}
