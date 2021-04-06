package ch.eoc.kafkademo.engine;

import ch.eoc.kafkademo.schema.EventPatientLocation;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Processor {

    final StreamsBuilder builder = new StreamsBuilder();

    /*
    1. ksql
    2. materialize view
    3. reduce

    checkout -> PL: { pId: 1, wardId: 101, datetime: ..., status: past }
    checkin  -> PL: { pId: 1, wardId: 100, datetime: ..., status: active }


    {
      wardId: 100
      exitWardId: 101
    }
     */
    @Autowired
    public void process() {
        KStream<String, GenericRecord> inputStream = builder.stream("adt.events.location", Consumed.with(Serdes.String(), new GenericAvroSerde()));

        System.out.println("STREAM PROCESSOR IS CALLED!");

        inputStream.mapValues(record -> {
            System.out.println("Map event: " + record.getSchema().getName());
            return record.get("patientId");
        });

        inputStream.groupByKey().reduce(
                (acc, curr) -> {
                    // TODO: what is the acc type?
                    System.out.println("Event type: " + curr.getSchema().getName());
                    acc.put("patientId", curr.get("patientId"));
                    acc.put("treatmentId", curr.get("treatmentId"));
                    acc.put("wardId", curr.get("wardId"));
                    acc.put("roomId", curr.get("roomId"));
                    acc.put("bedId", curr.get("bedId"));
                    return acc;
                }).toStream().to("adt.patient.location", Produced.with(Serdes.String(), new GenericAvroSerde())); // TODO replace with EventPatientLocation;
        // builder.stream("adt.events.location").foreach((key, value) -> System.out.println(key + " => " + value));
    }

}