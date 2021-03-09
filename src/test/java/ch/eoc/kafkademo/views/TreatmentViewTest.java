package ch.eoc.kafkademo.views;

import ch.eoc.kafkademo.schema.Encounter;
import ch.eoc.kafkademo.schema.EncounterStatus;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.TestInputTopic;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.TopologyTestDriver;
import org.junit.jupiter.api.Test;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

import java.util.Map;
import java.util.Properties;

import static org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG;
import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static org.assertj.core.api.Assertions.assertThat;

class TreatmentViewTest {

    private static final String SCHEMA_REGISTRY_SCOPE = TreatmentViewTest.class.getName();
    private static final String MOCK_SCHEMA_REGISTRY_URL = "mock://" + SCHEMA_REGISTRY_SCOPE;

    @Test
    void materializedView() {

        // Create topology to handle stream of users
        final StreamsBuilder builder = new StreamsBuilder();
        new TreatmentView().buildTreatmentView(builder);

        Properties properties = new Properties();
        properties.putAll(Map.of(
                APPLICATION_ID_CONFIG, "kafka-demo",
                BOOTSTRAP_SERVERS_CONFIG, "dummy:9092",
                SCHEMA_REGISTRY_URL_CONFIG, MOCK_SCHEMA_REGISTRY_URL
        ));

        // Create test driver
        TopologyTestDriver topologyTestDriver = new TopologyTestDriver(builder.build(), properties);

        // Configure Serializer to use the same mock schema registry URL
        KafkaAvroSerializer kafkaAvroSerializer = new KafkaAvroSerializer();
        Map<String, String> config = Map.of(SCHEMA_REGISTRY_URL_CONFIG, MOCK_SCHEMA_REGISTRY_URL);
        kafkaAvroSerializer.configure(config, false);

        final TestInputTopic treatments = topologyTestDriver.createInputTopic("treatments", Serdes.String().serializer(), kafkaAvroSerializer);

        treatments.pipeInput("1", new Encounter(1L, EncounterStatus.ARRIVED, 1L));
        treatments.pipeInput("2", new Encounter(2L, EncounterStatus.PLANNED, 2L));
        treatments.pipeInput("1", new Encounter(1L, EncounterStatus.INPROGRESS, 1L));
        treatments.pipeInput("3", new Encounter(3L, EncounterStatus.TRIAGED, 3L));
        treatments.pipeInput("1", new Encounter(1L, EncounterStatus.FINISHED, 1L));

        final KeyValueStore<String, Encounter> keyValueStore = topologyTestDriver.getKeyValueStore("treatments-view");

        assertThat(keyValueStore.get("1").getStatus()).isEqualTo(EncounterStatus.FINISHED);
        // assertThat(keyValueStore.get("2").getStatus()).isEqualTo(EncounterStatus.PLANNED);
        // assertThat(keyValueStore.get("3").getStatus()).isEqualTo(EncounterStatus.TRIAGED);
    }
}