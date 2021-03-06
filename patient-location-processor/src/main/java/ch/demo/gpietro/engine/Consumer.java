package ch.demo.gpietro.engine;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    // Testing the kafka messages
    @KafkaListener(id = "location", topics = "adt.events.location")
    public void listener(ConsumerRecord<String, GenericRecord> record) {
        System.out.println("Consuming schema: " + record.value().getSchema().getName());
    }
}