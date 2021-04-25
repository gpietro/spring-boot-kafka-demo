package ch.demo.gpietro.serde;


import ch.demo.gpietro.schema.BoardLocation;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroDeserializer;

public class BoardLocationAvroDeserializer extends SpecificAvroDeserializer<BoardLocation> {
}
