package ch.demo.gpietro.serde;

import ch.demo.gpietro.schema.EventPatientLocation;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

public class EventPatientLocationAvroSerde extends SpecificAvroSerde<EventPatientLocation> {
}
