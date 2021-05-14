package ch.demo.gpietro.serde.json;


import ch.demo.gpietro.schema.json.BoardLocation;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class BoardLocationJsonDeserializer extends JsonDeserializer<BoardLocation> {
}
