package ch.demo.gpietro.serde;

import ch.demo.gpietro.schema.Patient;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

public class PatientAvroSerde extends SpecificAvroSerde<Patient> {
}
