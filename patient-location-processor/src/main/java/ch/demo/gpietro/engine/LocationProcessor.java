package ch.demo.gpietro.engine;

import ch.demo.gpietro.schema.EventPatientCheckedOut;
import ch.demo.gpietro.schema.EventPatientLocation;
import ch.demo.gpietro.configs.SchemaRegistryConfig;
import ch.demo.gpietro.schema.EventPatientCheckedIn;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificData;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.ValueTransformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationProcessor {

    private static final Logger logger = LoggerFactory.getLogger(LocationProcessor.class);

    private final SchemaRegistryConfig schemaRegistryConfig;

    @Autowired
    public LocationProcessor(final SchemaRegistryConfig schemaRegistryConfig) {
        logger.info("Constructing LocationProcessor: {} {}", "adt.events.location", schemaRegistryConfig.url);
        this.schemaRegistryConfig = schemaRegistryConfig;
    }

    private Serde<GenericRecord> eventsValueSerde() {
        Serde<GenericRecord> genericAvroSerde = new GenericAvroSerde();
        genericAvroSerde.configure(schemaRegistryConfig.buildPropertiesMap(), false);
        return genericAvroSerde;
    }

    private SpecificAvroSerde<EventPatientLocation> locationValueSerde() {
        SpecificAvroSerde<EventPatientLocation> specificAvroSerde = new SpecificAvroSerde<>();
        specificAvroSerde.configure(schemaRegistryConfig.buildPropertiesMap(), false);
        return specificAvroSerde;
    }

    @Autowired
    public void process(final StreamsBuilder builder) {
        logger.info("Processing location events");
        KStream<Long, GenericRecord> inputStream = builder.stream("adt.events.location", Consumed.with(Serdes.Long(), eventsValueSerde()));

        final KStream<Long, EventPatientLocation> outputStream = inputStream.transformValues(() -> new ValueTransformer<GenericRecord, EventPatientLocation>() {

            @Override
            public void init(ProcessorContext processorContext) {

            }

            @Override
            public EventPatientLocation transform(final GenericRecord eventLocation) {
                EventPatientLocation patientLocation = new EventPatientLocation();
                Schema schema = eventLocation.getSchema();
                if (EventPatientCheckedIn.getClassSchema().equals(schema)) {
                    EventPatientCheckedIn patientCheckedIn = (EventPatientCheckedIn) SpecificData.get().deepCopy(EventPatientCheckedIn.SCHEMA$, eventLocation);
                    patientLocation.setType("Patient checked in!");
                    patientLocation.setPatientId(patientCheckedIn.getPatientId());
                    patientLocation.setTreatmentId(patientCheckedIn.getTreatmentId());
                    patientLocation.setWardId(patientCheckedIn.getWardId());
                    patientLocation.setRoomId(patientCheckedIn.getRoomId());
                    patientLocation.setBedId(patientCheckedIn.getBedId());
                } else if (EventPatientCheckedOut.getClassSchema().equals(schema)) {
                    EventPatientCheckedOut patientCheckedOut = (EventPatientCheckedOut) SpecificData.get().deepCopy(EventPatientCheckedOut.SCHEMA$, eventLocation);
                    patientLocation.setType("Patient checked out!");
                    patientLocation.setPatientId(patientCheckedOut.getPatientId());
                    patientLocation.setTreatmentId(patientCheckedOut.getTreatmentId());
                }
                return patientLocation;
            }

            @Override
            public void close() {

            }
        });
        /*
        final KStream<Long, EventPatientLocation> outputStream = inputStream.groupByKey().reduce(
                new EventPatientLocation(), (acc, curr) -> {
                    // TODO: what is the acc type?
                    System.out.println("Event type: " + curr.getSchema().getName());

                    acc.put("patientId", curr.get("patientId"));
                    acc.put("treatmentId", curr.get("treatmentId"));
                    acc.put("wardId", curr.get("wardId"));
                    acc.put("roomId", curr.get("roomId"));
                    acc.put("bedId", curr.get("bedId"));
                    acc.put("patientId", curr.get("patientId"));
                    return new EventPatientLocation();
                }).toStream();
        */
        outputStream.to("adt.patient.location", Produced.with(Serdes.Long(), locationValueSerde()));
    }

}