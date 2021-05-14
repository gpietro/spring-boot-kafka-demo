package ch.demo.gpietro.serde.avro;


import ch.demo.gpietro.schema.avro.BoardLocation;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

public class BoardLocationAvroSerde extends SpecificAvroSerde<BoardLocation> {
}
