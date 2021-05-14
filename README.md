# PoC Kafka for ADT Patient

### *Working progress*

This PoC aims to evaluate the usage of Kafka for event sourcing in the development of an Admission Dismission Transfer Patient solution.

## Run Kafka locally with docker

- `docker-compose up -d`

*Remove all exited containers* `docker rm $(docker ps -a -f status=exited -q)`

### Run ksqldb-cli
- `docker exec -it ksqldb-cli ksql http://ksqldb-server:8088`
- `show topics;`
- `print 'topic-name' FROM BEGINNING;`

### Application schema
![Application schema](https://raw.githubusercontent.com/gpietro/spring-boot-kafka-demo/master/app-schema.png)


### Todo
- React front-end application

### Notes
- The topic Board has been converted to JSON format to able to use ReactiveKafkaConsumerTemplate that wasn't working with AVRO deserializer.