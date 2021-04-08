package ch.eoc.kafkademo.engine;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    // TODO: what is the meaning of KafkaListener id?
    // Testing the kafka messages
    @KafkaListener(id="location", topics="adt.events.location")
    public void listener(ConsumerRecord<String, GenericRecord> record) {
        System.out.println("Consuming schema: " + record.value().getSchema().getName());
    }
}