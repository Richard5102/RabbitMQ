import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class ReceiveLogs {
    private static final String QUEUE = "QuueDataOut2";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("66.70.135.115");
        factory.setPort(5672);
        factory.setUsername("Restaurante");
        factory.setPassword("testing123");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE, true, deliverCallback, consumerTag -> { });
    }

    public void RecieveRabbitMsgs() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("66.70.135.115");
        factory.setPort(5672);
        factory.setUsername("Restaurante");
        factory.setPassword("testing123");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'"); // Hacer algo con el código o devolver el mensaje recibido
        };
        channel.basicConsume(QUEUE, true, deliverCallback, consumerTag -> { });
    }
}