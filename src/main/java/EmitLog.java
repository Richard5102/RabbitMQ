import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.net.ConnectException;
import java.util.concurrent.ExecutionException;

public class EmitLog {

    private static final String EXCHANGE_NAME = "ExchangeDataIn";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("66.70.135.115");
        factory.setPort(5672);
        factory.setUsername("Restaurante");
        factory.setPassword("testing123");

        for (int i = 0; i < 25; i++) {
            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {

                String message = "Hello world!, message number: "+ i;


                channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + message + "'");
            }
            catch (ConnectException exception) {
                throw (exception);
            }
        }
    }
}