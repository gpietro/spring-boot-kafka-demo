package ch.eoc.kafkademo.controllers;

import ch.eoc.kafkademo.engine.Producer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "kafka")
public class KafkaController {

    private final Producer producer;

    KafkaController(Producer producer) {
        this.producer = producer;
    }

    /*
    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }
     */
}