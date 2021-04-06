# PoC Kafka for ADT Patient

This PoC aims to evaluate the usage of Kafka for event sourcing in the development of an Admission Dismission Transfer Patient solution.

## Run Kafka locally with docker

### Kafka-ui
- `git clone https://github.com/provectus/kafka-ui.git`
- `cd kafka-ui/docker`
- `docker-compose -f kafka-ui.yaml up`
- visit `localhost:8080`

### CP all in one community
- `git clone https://github.com/provectus/kafka-ui.git`
- `cd kafka-ui/docker`
- `docker-compose -f kafka-ui.yaml up`

#### cleanup
- `docker-compose rm -v`

### Run ksqldb-cli
- `docker exec -it ksqldb-cli ksql http://ksqldb-server:8088`
- `show topics`
- `print 'topic-name' FROM BEGINNING`


