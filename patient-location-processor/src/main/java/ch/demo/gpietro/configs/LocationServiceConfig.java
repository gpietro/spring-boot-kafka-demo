package ch.demo.gpietro.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.streams.StreamsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.TopicBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@Configuration
public class LocationServiceConfig {

    private final String httpServerPort;
    private final KafkaProperties configuredKafkaProperties;

    @Autowired
    public LocationServiceConfig(KafkaProperties props, @Value("${server.port}") String port) {
        configuredKafkaProperties = props;
        httpServerPort = port;
    }

    @Bean
    public NewTopic topicEventsLocation() {
        return TopicBuilder.name("adt.events.location").partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic topicPatientLocation() {
        return TopicBuilder.name("adt.patient.location").partitions(1).replicas(1).build();
    }

    @Bean
    KafkaStreamsConfiguration defaultKafkaStreamsConfig() throws UnknownHostException {
        Map<String, Object> newConfig = configuredKafkaProperties.buildStreamsProperties();
        newConfig.put(
                StreamsConfig.APPLICATION_SERVER_CONFIG,
                InetAddress.getLocalHost().getHostName() + ":" + httpServerPort);
        return new KafkaStreamsConfiguration(newConfig);
    }
}