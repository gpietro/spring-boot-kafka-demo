package ch.demo.gpietro.serde.avro;

import ch.demo.gpietro.schema.avro.EventPatientLocation;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

public class EventPatientLocationAvroSerde extends SpecificAvroSerde<EventPatientLocation> {
}
