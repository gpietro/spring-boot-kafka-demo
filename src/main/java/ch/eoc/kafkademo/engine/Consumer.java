package ch.eoc.kafkademo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    /*
    @KafkaListener(topics = "patients", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("Kafka consumer - message: %s", message));
    }
     */
}