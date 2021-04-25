package ch.demo.gpietro.configs;

import ch.demo.gpietro.schema.BoardLocation;
import ch.demo.gpietro.serde.BoardLocationAvroDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.Collections;


@Configuration
public class KafkaConfig {

    private final String bootstrapServersConfig;

    @Autowired
    public KafkaConfig(
            @Value("${spring.kafka.consumer.bootstrap-servers:localhost:9092}") final String bootstrapServersConfig) {
        this.bootstrapServersConfig = bootstrapServersConfig;
    }

    @Bean
    public ReactiveKafkaConsumerTemplate<String, BoardLocation> reactiveKafkaConsumerTemplate() {
        ReceiverOptions<String, BoardLocation> properties = ReceiverOptions.<String, BoardLocation>create()
                .consumerProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServersConfig)
                .consumerProperty(ConsumerConfig.GROUP_ID_CONFIG, "board")
                .subscription(Collections.singleton("board"))
                .withKeyDeserializer(new StringDeserializer())
                .withValueDeserializer(new BoardLocationAvroDeserializer())
                .consumerProperty(ConsumerConfig.GROUP_ID_CONFIG, "board.consumer");

        return new ReactiveKafkaConsumerTemplate<>(properties);
    }
}
