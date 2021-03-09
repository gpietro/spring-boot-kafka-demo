package ch.eoc.kafkademo.views;

import ch.eoc.kafkademo.schema.Encounter;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

import java.util.Map;

@Component
public class TreatmentView {

    @Value("${spring.kafka.properties.schema.registry.url}")
    String srUrl;

    public void buildTreatmentView(StreamsBuilder builder) {
        final Serde<Encounter> valueSpecificAvroSerde = new SpecificAvroSerde<>();
        builder.table("treatments", Consumed.with(Serdes.String(), specificAvro()), Materialized.as("treatments-view"));
    }

    private SpecificAvroSerde<Encounter> specificAvro() {
        SpecificAvroSerde<Encounter> serde = new SpecificAvroSerde<>();
        final Map<String, String>
                config =
                Map.of(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8085");
        serde.configure(config, false);
        return serde;
    }
}