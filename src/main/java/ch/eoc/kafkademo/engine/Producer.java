package ch.eoc.kafkademo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    /*
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "patients";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        logger.info(String.format("Kafka producer - message: %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }

     */
}