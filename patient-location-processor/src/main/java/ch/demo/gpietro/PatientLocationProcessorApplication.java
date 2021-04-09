package ch.demo.gpietro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafka
@EnableKafkaStreams
public class PatientLocationProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientLocationProcessorApplication.class, args);
	}


}