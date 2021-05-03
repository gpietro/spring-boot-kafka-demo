# PoC Kafka for ADT Patient

This PoC aims to evaluate the usage of Kafka for event sourcing in the development of an Admission Dismission Transfer Patient solution.

## Run Kafka locally with docker

- `docker-compose up -d`

*Remove all exited containers* `docker rm $(docker ps -a -f status=exited -q)`

### Run ksqldb-cli
- `docker exec -it ksqldb-cli ksql http://ksqldb-server:8088`
- `show topics;`
- `print 'topic-name' FROM BEGINNING;`