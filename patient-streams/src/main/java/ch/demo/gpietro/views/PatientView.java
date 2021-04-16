package ch.demo.gpietro.views;

import ch.demo.gpietro.schema.BoardLocation;
import ch.demo.gpietro.schema.EventPatientLocation;
import ch.demo.gpietro.schema.Patient;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Slf4j
@Component
public class PatientView {

    @Bean
    public Function<KStream<Long, EventPatientLocation>,
            Function<GlobalKTable<String, Patient>,
                    KStream<Long, BoardLocation>>> process() {
        return locationKStream -> (
                patientGlobalKTable -> (
                        locationKStream.peek(this::logKeyValue)
                                .join(
                                        patientGlobalKTable,
                                        (s, location) -> String.valueOf(location.getPatientId()),
                                        this::toBoardLocation
                                )
                                .peek(this::logKeyValue)
                )
        );
    }

    private void logKeyValue(Long key, Object value) {
        log.info("==> key: {}, value: {}", key, value);
    }

    private BoardLocation toBoardLocation(EventPatientLocation eventPatientLocation, Patient patient) {
        BoardLocation boardLocation = new BoardLocation();
        boardLocation.setPatientId(eventPatientLocation.getPatientId());
        boardLocation.setTreatmentId(eventPatientLocation.getTreatmentId());
        boardLocation.setWardId(eventPatientLocation.getWardId());
        boardLocation.setRoomId(eventPatientLocation.getRoomId());
        boardLocation.setBedId(eventPatientLocation.getBedId());
        boardLocation.setFirstName(patient.getFirstName());
        boardLocation.setLastName(patient.getLastName());
        boardLocation.setBirthDate(patient.getBirthDate());
        return boardLocation;
    }

    /*
    private String srUrl;

    @Autowired
    public PatientView(@Value("${spring.cloud.stream.kafka.streams.binder.configuration.schema.registry.url}") String srUrl) {
        this.srUrl = srUrl;
    }

    @Autowired
    public void buildPatientView(StreamsBuilder builder) {
        builder.table("mysql.admindb.patients", Consumed.with(Serdes.Long(), specificAvro()), Materialized.as("view.patients"));
    }

    private SpecificAvroSerde<Patient> specificAvro() {
        SpecificAvroSerde<Patient> serde = new SpecificAvroSerde<>();
        final Map<String, String> config = Map.of(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, srUrl);
        serde.configure(config, false);
        return serde;
    }
     */
}
