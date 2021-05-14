package ch.demo.gpietro.configs;

import ch.demo.gpietro.schema.json.BoardLocation;
import ch.demo.gpietro.serde.json.BoardLocationJsonDeserializer;
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
    private final String schemaRegistryUrl;

    @Autowired
    public KafkaConfig(
            @Value("${spring.kafka.consumer.bootstrap-servers:localhost:9092}") final String bootstrapServersConfig,
            @Value("${spring.kafka.consumer.schema.registry.url:localhost:8081}") final String schemaRegistryUrl) {
        this.bootstrapServersConfig = bootstrapServersConfig;
        this.schemaRegistryUrl = schemaRegistryUrl;
    }

    @Bean
    public ReactiveKafkaConsumerTemplate<String, BoardLocation> reactiveKafkaConsumerTemplate() {
        ReceiverOptions<String, BoardLocation> properties = ReceiverOptions.<String, BoardLocation>create()
                .consumerProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServersConfig)
                .consumerProperty(ConsumerConfig.GROUP_ID_CONFIG, "board")
                .consumerProperty("schema.registry.url", "localhost:8081")
                .subscription(Collections.singleton("board"))
                .withKeyDeserializer(new StringDeserializer())
                .withValueDeserializer(new BoardLocationJsonDeserializer());

        return new ReactiveKafkaConsumerTemplate<>(properties);
    }
}
