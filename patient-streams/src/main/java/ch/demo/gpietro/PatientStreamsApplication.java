package ch.demo.gpietro;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class PatientStreamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientStreamsApplication.class, args);
	}


	@Bean
	public NewTopic topicStorePatients() {
		return TopicBuilder.name("mysql.admindb.patients").partitions(1).replicas(1).build();
	}

	@KafkaListener(groupId = "storeStreamsGroup", topics = "mysql.admindb.patients")
	public void listener(ConsumerRecord<String, GenericRecord> record) {
		System.out.println("Consuming schema: " + record.value().getSchema().getName());
	}
}