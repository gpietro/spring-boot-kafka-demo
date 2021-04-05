package ch.eoc.kafkademo.engine;

import ch.eoc.kafkademo.schema.EventPatientCheckedIn;

import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Properties;

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
/*
        builder.stream("adt-events-location").groupByKey().reduce((acc, curr) -> {
            // PatientLocationState { patientId, treatmentId, status, ... }
            // GenericRecord
            if(curr.get("type").equals("PateitnCheckedIN...") instanceof EventPatientCheckedIn) {
                acc.put("patientId", curr.get("pati"));
                acc.put("status",  "active");
            } else if (curr.get("")) {

            }
            return acc;
        }, new EventPatientLocation());
*/
        builder.stream("adt-events-location").foreach((key, value) -> System.out.println(key + " => " + value));
    }

}