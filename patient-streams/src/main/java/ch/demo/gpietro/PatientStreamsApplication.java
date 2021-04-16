package ch.demo.gpietro;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public NewTopic topicOutputBoardPatients() {
        return TopicBuilder.name("board.patient.location").partitions(1).replicas(1).build();
    }
}