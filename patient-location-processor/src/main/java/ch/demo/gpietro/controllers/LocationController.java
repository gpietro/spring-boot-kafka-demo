package ch.demo.gpietro.controllers;

import ch.demo.gpietro.engine.Producer;
import ch.demo.gpietro.schema.avro.*;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping(value = "/v1")
public class LocationController {

    private final Logger logger = LoggerFactory.getLogger(LocationController.class);

    private final Producer producer;

    LocationController(Producer producer) {
        Objects.requireNonNull(producer, "producer must not be null"); // Fail fast
        this.producer = producer;
    }

    /**
     * Configuring this Bean allows Avro objects to be serialized by
     * Jackson, otherwise, it attempts to serialize non-data values
     *
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.featuresToEnable(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);
        return builder;
    }

    @PostMapping(value = "/location/checkin")
    @Async
    public DeferredResult<ResponseEntity<?>> checkinEvent(@RequestBody EventPatientCheckedIn eventPatientCheckedIn) {
        final DeferredResult<ResponseEntity<?>> httpResult = new DeferredResult<>();
        logger.info("patient checkin: {}", eventPatientCheckedIn);
        producer.produceEventPatientCheckedIn(eventPatientCheckedIn).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onSuccess(SendResult<String, Object> result) {
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
        producer.produceEventPatientCheckedOut(eventPatientCheckedOut).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onSuccess(SendResult<String, Object> result) {
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

    @PostMapping(value = "/location/plan")
    @Async
    public DeferredResult<ResponseEntity<?>> planEvent(@RequestBody EventPatientPlanned eventPatientPlanned) {
        final DeferredResult<ResponseEntity<?>> httpResult = new DeferredResult<>();
        logger.info("patient planned: {}", eventPatientPlanned);
        producer.produceEventPatientPlanned(eventPatientPlanned).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onSuccess(SendResult<String, Object> result) {
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

    @PostMapping(value = "/location/change-room")
    @Async
    public DeferredResult<ResponseEntity<?>> changeRoom(@RequestBody EventPatientRoomChanged eventPatientRoomChanged) {
        final DeferredResult<ResponseEntity<?>> httpResult = new DeferredResult<>();
        logger.info("patient planned: {}", eventPatientRoomChanged);
        producer.produceEventPatientRoomChanged(eventPatientRoomChanged).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onSuccess(SendResult<String, Object> result) {
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

    @PostMapping(value = "/location/change-bed")
    @Async
    public DeferredResult<ResponseEntity<?>> changeBed(@RequestBody EventPatientBedChanged eventPatientBedChanged) {
        final DeferredResult<ResponseEntity<?>> httpResult = new DeferredResult<>();
        logger.info("patient planned: {}", eventPatientBedChanged);
        producer.produceEventPatientBedChanged(eventPatientBedChanged).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onSuccess(SendResult<String, Object> result) {
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