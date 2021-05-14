package ch.demo.gpietro.serde.avro;

import ch.demo.gpietro.schema.avro.Patient;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

public class PatientAvroSerde extends SpecificAvroSerde<Patient> {
}
