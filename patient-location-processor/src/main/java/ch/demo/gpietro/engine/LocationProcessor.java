package ch.demo.gpietro.engine;

import ch.demo.gpietro.configs.SchemaRegistryConfig;
import ch.demo.gpietro.schema.*;
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
        KStream<String, GenericRecord> inputStream = builder.stream("adt.events.location", Consumed.with(Serdes.String(), eventsValueSerde()));

        final KStream<String, EventPatientLocation> outputStream = inputStream.transformValues(() -> new ValueTransformer<GenericRecord, EventPatientLocation>() {

            @Override
            public void init(ProcessorContext processorContext) {

            }

            @Override
            public EventPatientLocation transform(final GenericRecord eventLocation) {
                EventPatientLocation patientLocation = new EventPatientLocation();
                Schema schema = eventLocation.getSchema();
                /*if (EventPatientPlanned.getClassSchema().equals(schema)) {
                    EventPatientPlanned patientPlanned = (EventPatientPlanned) SpecificData.get().deepCopy(EventPatientPlanned.SCHEMA$, eventLocation);
                    patientLocation.setPatientId(patientPlanned.getPatientId());
                    patientLocation.setWardId(patientPlanned.getWardId());
                    patientLocation.setEpisodeOfCareId(patientPlanned.getEpisodeOfCareId());
                    patientLocation.setDate(patientPlanned.getDate());
                    patientLocation.setStatus(EncounterStatus.PLANNED);
                } else

                 */
                if (EventPatientCheckedIn.getClassSchema().equals(schema)) {
                    EventPatientCheckedIn patientCheckedIn = (EventPatientCheckedIn) SpecificData.get().deepCopy(EventPatientCheckedIn.SCHEMA$, eventLocation);
                    patientLocation.setPatientId(patientCheckedIn.getPatientId());
                    patientLocation.setEpisodeOfCareId(patientCheckedIn.getEpisodeOfCareId());
                    patientLocation.setWardId(patientCheckedIn.getWardId());
                    patientLocation.setRoomId(patientCheckedIn.getRoomId());
                    patientLocation.setBedId(patientCheckedIn.getBedId());
                    patientLocation.setStatus(EncounterStatus.ACTIVE);
                } else if (EventPatientCheckedOut.getClassSchema().equals(schema)) {
                    EventPatientCheckedOut patientCheckedOut = (EventPatientCheckedOut) SpecificData.get().deepCopy(EventPatientCheckedOut.SCHEMA$, eventLocation);
                    patientLocation.setPatientId(patientCheckedOut.getPatientId());
                    patientLocation.setEpisodeOfCareId(patientCheckedOut.getEpisodeOfCareId());
                    patientLocation.setWardId(patientCheckedOut.getWardId());
                    patientLocation.setStatus(EncounterStatus.PAST);
                } else if (EventPatientRoomChanged.getClassSchema().equals(schema)) {
                    EventPatientRoomChanged eventPatientRoomChanged = (EventPatientRoomChanged) SpecificData.get().deepCopy(EventPatientRoomChanged.SCHEMA$, eventLocation);
                    patientLocation.setPatientId(eventPatientRoomChanged.getPatientId());
                    patientLocation.setEpisodeOfCareId(eventPatientRoomChanged.getEpisodeOfCareId());
                    patientLocation.setWardId(eventPatientRoomChanged.getWardId());
                    patientLocation.setRoomId(eventPatientRoomChanged.getRoomId());
                    patientLocation.setStatus(EncounterStatus.ACTIVE);
                } else if (EventPatientBedChanged.getClassSchema().equals(schema)) {
                    EventPatientBedChanged eventPatientBedChanged = (EventPatientBedChanged) SpecificData.get().deepCopy(EventPatientBedChanged.SCHEMA$, eventLocation);
                    patientLocation.setPatientId(eventPatientBedChanged.getPatientId());
                    patientLocation.setEpisodeOfCareId(eventPatientBedChanged.getEpisodeOfCareId());
                    patientLocation.setWardId(eventPatientBedChanged.getWardId());
                    patientLocation.setRoomId(eventPatientBedChanged.getRoomId());
                    patientLocation.setBedId(eventPatientBedChanged.getBedId());
                    patientLocation.setStatus(EncounterStatus.ACTIVE);
                }
                return patientLocation;
            }

            @Override
            public void close() {

            }
        });

        outputStream.to("adt.patient.location", Produced.with(Serdes.String(), locationValueSerde()));
    }

}