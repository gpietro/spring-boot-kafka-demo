package ch.eoc.kafkademo.controllers;

import ch.eoc.kafkademo.engine.Producer;
import ch.eoc.kafkademo.schema.EventPatientCheckedIn;
import ch.eoc.kafkademo.schema.EventPatientCheckedOut;
import com.fasterxml.jackson.databind.MapperFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping(value = "/v1")
public class LocationController {

    private final Logger logger = LoggerFactory.getLogger(LocationController.class);

    private final Producer producer;

    /**
     * Configuring this Bean allows Avro objects to be serialized by
     * Jackson, otherwise, it attempts to serialize non-data values
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.featuresToEnable(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);
        return builder;
    }

    LocationController(Producer producer) {
        Objects.requireNonNull(producer, "producer must not be null"); // Fail fast
        this.producer = producer;
    }

    @PostMapping(value = "/location/checkin")
    @Async
    public DeferredResult<ResponseEntity<?>> checkinEvent(@RequestBody EventPatientCheckedIn eventPatientCheckedIn) {
        final DeferredResult<ResponseEntity<?>> httpResult = new DeferredResult<>();
        logger.info("patient checkin: {}", eventPatientCheckedIn);
        producer.produceEventPatientCheckedIn(eventPatientCheckedIn).addCallback(new ListenableFutureCallback<SendResult<Long, Object>>() {
            @Override
            public void onSuccess(SendResult<Long, Object> result) {
                logger.info("Produce success: patientId = {}", result.getProducerRecord().key());
                httpResult.setResult(new ResponseEntity(HttpStatus.OK));
            }

            @Override
            public void onFailure(final Throwable ex) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
            }
        });
        return httpResult;
    }

    @PostMapping(value = "/location/checkout")
    @Async
    public DeferredResult<ResponseEntity<?>> checkoutEvent(@RequestBody EventPatientCheckedOut eventPatientCheckedOut) {
        final DeferredResult<ResponseEntity<?>> httpResult = new DeferredResult<>();
        logger.info("patient checkout: {}", eventPatientCheckedOut);
        producer.produceEventPatientCheckedOut(eventPatientCheckedOut).addCallback(new ListenableFutureCallback<SendResult<Long, Object>>() {
            @Override
            public void onSuccess(SendResult<Long, Object> result) {
                logger.info("Produce success: patientId = {}", result.getProducerRecord().key());
                httpResult.setResult(new ResponseEntity(HttpStatus.OK));
            }

            @Override
            public void onFailure(final Throwable ex) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
            }
        });
        return httpResult;
    }
}