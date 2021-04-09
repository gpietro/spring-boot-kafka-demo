#!/usr/bin/env bash

echo "Create topic mysql.storedb.patients"
echo "------------------------------------"
docker exec -t zookeeper kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1 --topic mysql.storedb.patients

echo
echo "List topics"
echo "-----------"
docker exec -t zookeeper kafka-topics --list --bootstrap-server kafka:9092
