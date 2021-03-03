package ch.eoc.kafkademo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("patients").partitions(1).replicas(1).build();
	}

	@KafkaListener(id="patientId", topics="patients")
	public void listener(String message) {
		System.out.println(message);
	}

	@Bean
	public ApplicationRunner runner(KafkaTemplate<String, String> template) {
		return args -> {
			template.send("patients", "Pietro Ghezzi");
		};
	}
}