import com.rabbitmq.client.*;

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
            // PARA LIMPIAR UNA COLA NO HAY UN CÓDIGO EN ESPECÍFICO, SE DEBE DE ELIMINAR
            channel.queueDelete(QUEUE_NAME);
            channel.exchangeDelete(EXCHANGE_NAME);
        }
    }
}
