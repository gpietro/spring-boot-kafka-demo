package ch.demo.gpietro.controllers;

import ch.demo.gpietro.schema.json.BoardLocation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@Slf4j
@RestController
@RequestMapping("iq/v1/")
public class InteractiveQueryController {

    final ReactiveKafkaConsumerTemplate<String, BoardLocation> reactiveKafkaConsumerTemplate;

    public InteractiveQueryController(ReactiveKafkaConsumerTemplate<String, BoardLocation> reactiveKafkaConsumerTemplate) {
        this.reactiveKafkaConsumerTemplate = reactiveKafkaConsumerTemplate;
    }

    @GetMapping(value = "/locations", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public Flux<BoardLocation> getBoardLocations() {
        return reactiveKafkaConsumerTemplate
                .receive()
                .map(ConsumerRecord::value)
                .doOnNext(boardLocation -> log.info("successfully consumed {}", boardLocation))
                .doOnError(throwable -> log.error("something bad happened while consuming : {}", throwable.getMessage()));
    }

    /*
    @GetMapping("{id}")
    public Patient getPatient(@PathVariable final Long id) {
        final KafkaStreams kafkaStreams = streamsBuilderFactoryBean.getKafkaStreams();
        ReadOnlyKeyValueStore<Long, Patient> store = kafkaStreams.store(StoreQueryParameters.fromNameAndType("view.patients", QueryableStoreTypes.keyValueStore()));

        return store.get(id);
    }
     */
}