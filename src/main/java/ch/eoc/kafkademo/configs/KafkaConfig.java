package ch.eoc.kafkademo.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topicLocationEvents() {
        return TopicBuilder.name("adt-events-location").partitions(1).replicas(1).build();
    }

    // TODO: what is the meaning of KafkaListener id?
    // Testing the kafka messages
    @KafkaListener(id="location", topics="adt-events-location")
	public void listener(ConsumerRecord<String, Object> record) {
		System.out.println(record.value().toString());
	}
}