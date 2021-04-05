package ch.eoc.kafkademo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    // TODO: what is the meaning and usage of groupId?
    /*
    @KafkaListener(topics = "", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("Kafka consumer - message: %s", message));
    }
     */
}