package ch.eoc.kafkademo.configs;

import ch.eoc.kafkademo.schema.Encounter;
import ch.eoc.kafkademo.schema.EncounterStatus;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Map;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.properties.schema.registry.url}")
    String srUrl;

    @Bean
    public NewTopic topicTreatments() {
        return TopicBuilder.name("treatments").partitions(1).replicas(1).build();
    }

	// Testing the kafka messages
    @KafkaListener(id="treatmentId", topics="treatments")
	public void listener(Encounter encounter) {
		System.out.println(encounter.toString());
	}

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, Encounter> template) {
        return args -> {
            template.send("treatments", "1", new Encounter(1L, EncounterStatus.ARRIVED, 1L));
            template.send("treatments", "2", new Encounter(2L, EncounterStatus.PLANNED, 2L));
            template.send("treatments", "1", new Encounter(1L, EncounterStatus.INPROGRESS, 1L));
            template.send("treatments", "3", new Encounter(3L, EncounterStatus.TRIAGED, 3L));
            template.send("treatments", "1", new Encounter(1L, EncounterStatus.FINISHED, 1L));
        };
    }
}