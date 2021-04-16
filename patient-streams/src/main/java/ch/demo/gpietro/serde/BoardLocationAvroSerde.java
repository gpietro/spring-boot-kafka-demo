package ch.demo.gpietro.serde;


import ch.demo.gpietro.schema.BoardLocation;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

public class BoardLocationAvroSerde extends SpecificAvroSerde<BoardLocation> {
}
