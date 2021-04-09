package ch.demo.gpietro.streams;

import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.schemaregistry.testutil.MockSchemaRegistry;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import org.apache.avro.Schema;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

class LocationProcessorTest {

    // A mocked schema registry for our serdes to use
    private static final String SCHEMA_REGISTRY_SCOPE = LocationProcessorTest.class.getName();
    private static final String MOCK_SCHEMA_REGISTRY_URL = "mock://" + SCHEMA_REGISTRY_SCOPE;


    private static String inputTopic = "adt.events.location";
    private static String outputTopic = "adt.patient.location";

    @Test
    public void shouldProcessLocationEvents() throws Exception {
        // Register multiple schemas?
        final SchemaRegistryClient schemaRegistryClient = MockSchemaRegistry.getClientForScope(SCHEMA_REGISTRY_SCOPE);

        File eventCheckedIn = new File("src/main/avro/EventPatientCheckedIn.avsc");
        File eventCheckedOut = new File("src/main/avro/EventPatientCheckedOut.avsc");
        File eventRoomChanged = new File("src/main/avro/EventPatientRoomChanged.avsc");
        File eventBedChanged = new File("src/main/avro/EventPatientBedChanged.avsc");

        schemaRegistryClient.register("adt.events.location", new Schema.Parser().parse(new FileInputStream(eventCheckedIn)));
        schemaRegistryClient.register("adt.events.location", new Schema.Parser().parse(new FileInputStream(eventCheckedOut)));
        schemaRegistryClient.register("adt.events.location", new Schema.Parser().parse(new FileInputStream(eventRoomChanged)));
        schemaRegistryClient.register("adt.events.location", new Schema.Parser().parse(new FileInputStream(eventBedChanged)));


        /**
         * Not deprecated way...
         * ---
         * String schemaContent = Files.readString(Path.of("src/main/avro/AllEventsLocation.avsc"), StandardCharsets.UTF_8);
         * AvroSchema avroSchema = new AvroSchema(schemaContent);
         * schemaRegistryClient.register("adt.events.location", avroSchema);
         * ---
         */

        final StreamsBuilder builder = new StreamsBuilder();

        final Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "location-processor-test");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy config");
        streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, GenericAvroSerde.class);
        streamsConfiguration.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, MOCK_SCHEMA_REGISTRY_URL);

    }


}