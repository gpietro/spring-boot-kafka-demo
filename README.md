# PoC Kafka for ADT Patient

This PoC aims to evaluate the usage of Kafka for event sourcing in the development of an Admission Dismission Transfer Patient solution.

## How to run Kafka locally with docker
- `git clone https://github.com/provectus/kafka-ui.git`
- `cd kafka-ui/docker`
- `docker-compose -f kafka-ui.yaml up`

### Visit kafka UI
- `localhost:8080`


### Run ksqldb-cli
`docker exec -it ksqldb-cli ksql http://ksqldb-server:8088`