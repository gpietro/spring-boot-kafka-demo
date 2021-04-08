package ch.eoc.kafkademo.engine;

import ch.eoc.kafkademo.schema.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "adt.events.location";
    private final KafkaTemplate<Long, Object> kafkaTemplate;

    public Producer(KafkaTemplate<Long, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Async
    public ListenableFuture<SendResult<Long, Object>> produceEventPatientCheckedIn(EventPatientCheckedIn eventPatientCheckedIn) {
        logger.info("producing {} to {}", eventPatientCheckedIn, TOPIC);
        return kafkaTemplate.send(TOPIC, eventPatientCheckedIn.getPatientId(), eventPatientCheckedIn);
    }

    @Async
    public ListenableFuture<SendResult<Long, Object>> produceEventPatientCheckedOut(EventPatientCheckedOut eventPatientCheckedOut) {
        logger.info("producing {} to {}", eventPatientCheckedOut, TOPIC);
        return kafkaTemplate.send(TOPIC, eventPatientCheckedOut.getPatientId(), eventPatientCheckedOut);
    }

    /*
    public void sendMessage(String message) {
        logger.info(String.format("Kafka producer - message: %s", message));
        // this.kafkaTemplate.send(TOPIC, message);
    }

     */

    @EventListener(ApplicationStartedEvent.class)
    public void produce() {
        /*
        kafkaTemplate.send(TOPIC, 1L, new EventPatientCheckedIn(1L, 1001L, 104L, 11L, 6L));
        kafkaTemplate.send(TOPIC, 1L, new EventPatientBedChanged(1L, 1001L, 7L));
        kafkaTemplate.send(TOPIC, 1L, new EventPatientRoomChanged(1L, 1001L, 10L));
        kafkaTemplate.send(TOPIC, 2L, new EventPatientCheckedIn(2L, 1002L, 110L, 18L, 2L));
        kafkaTemplate.send(TOPIC, 3L, new EventPatientCheckedIn(3L, 1003L, 111L, 16L, 1L));
        kafkaTemplate.send(TOPIC, 1L, new EventPatientCheckedOut(1L, 1001L));
        kafkaTemplate.send(TOPIC, 3L, new EventPatientBedChanged(3L, 1003L, 3L));


        this.kafkaTemplate.send(TOPIC, "1", new EventPatientLocation("PatientCheckedIn", 1L, 1001L, 3L, 1003L, 3L));
        this.kafkaTemplate.send(TOPIC, "1", new EventPatientLocation("PatientChangedBed", 1L, 1001L, 3L, 1003L, 4L));
        this.kafkaTemplate.send(TOPIC, "1", new EventPatientLocation("PatientCheckedOut", 1L, 1001L, 3L, 1003L, 4L));
        this.kafkaTemplate.send(TOPIC, "2", new EventPatientLocation("PatientCheckedIn", 2L, 1002L, 3L, 1004L, 3L));
        this.kafkaTemplate.send(TOPIC, "3", new EventPatientLocation("PatientCheckedIn", 3L, 1003L, 3L, 1004L, 1L));
        this.kafkaTemplate.send(TOPIC, "4", new EventPatientLocation("PatientCheckedIn", 4L, 1004L, 3L, 1006L, 3L));
         */
    }
}