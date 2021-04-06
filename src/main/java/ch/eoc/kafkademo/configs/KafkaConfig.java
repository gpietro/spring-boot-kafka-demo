package ch.eoc.kafkademo.configs;

import ch.eoc.kafkademo.schema.EventPatientCheckedIn;
import ch.eoc.kafkademo.schema.EventPatientCheckedOut;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topicEventsLocation() {
        return TopicBuilder.name("adt.events.location").partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic topicPatientLocation() {
        return TopicBuilder.name("adt.patient.location").partitions(1).replicas(1).build();
    }

    // TODO: what is the meaning of KafkaListener id?
    // Testing the kafka messages
    @KafkaListener(id="location", topics="adt.events.location")
	public void listener(ConsumerRecord<String, GenericRecord> record) {
        System.out.println("Schema: " + record.value().getSchema().getName());
	}
}