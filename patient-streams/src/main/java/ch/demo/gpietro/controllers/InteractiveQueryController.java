/*
package ch.demo.gpietro.controllers;

import ch.demo.gpietro.schema.Patient;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("iq/v1/")
public class InteractiveQueryController {

    // Necessary to be able to access the ktable
    private final StreamsBuilderFactoryBean streamsBuilderFactoryBean;

    public InteractiveQueryController(StreamsBuilderFactoryBean streamsBuilderFactoryBean) {
        this.streamsBuilderFactoryBean = streamsBuilderFactoryBean;
    }

    @GetMapping("{id}")
    public Patient getPatient(@PathVariable final Long id) {
        final KafkaStreams kafkaStreams = streamsBuilderFactoryBean.getKafkaStreams();
        ReadOnlyKeyValueStore<Long, Patient> store = kafkaStreams.store(StoreQueryParameters.fromNameAndType("view.patients", QueryableStoreTypes.keyValueStore()));

        return store.get(id);
    }
}
 */