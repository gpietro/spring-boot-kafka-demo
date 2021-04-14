package ch.demo.gpietro.views;

import ch.demo.gpietro.schema.Patient;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PatientView {

    private String srUrl;

    @Autowired
    public PatientView(@Value("${spring.cloud.stream.kafka.streams.binder.configuration.schema.registry.url}") String srUrl) {
        this.srUrl = srUrl;
    }

    @Autowired
    public void buildPatientView(StreamsBuilder builder) {
        builder.table("mysql.admindb.patients", Consumed.with(Serdes.Long(), specificAvro()), Materialized.as("view.patients"));
    }

    private SpecificAvroSerde<Patient> specificAvro() {
        SpecificAvroSerde<Patient> serde = new SpecificAvroSerde<>();
        final Map<String, String> config = Map.of(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, srUrl);
        serde.configure(config, false);
        return serde;
    }
}
