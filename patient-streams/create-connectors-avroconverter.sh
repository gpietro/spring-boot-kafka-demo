#!/usr/bin/env bash

echo "-----------------------"
echo "Creating connectors ..."
echo "-----------------------"

echo
curl -i -X POST http://localhost:8083/connectors \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  -d '{
  "name": "mysql-source-patients",
  "config": {
    "connector.class": "io.confluent.connect.jdbc.JdbcSourceConnector",
    "connection.url": "jdbc:mysql://mysql:3306/admindb?characterEncoding=UTF-8&serverTimezone=UTC",
    "connection.user": "root",
    "connection.password": "rootpw",
    "table.whitelist": "patients",
    "mode": "timestamp+incrementing",
    "timestamp.column.name": "updated_at",
    "incrementing.column.name": "id",
    "topic.prefix": "mysql.admindb.",
    "tasks.max": "1",

    "_comment": "--- Add key to the message based on the entity id field ---",
    "transforms.createKey.type": "org.apache.kafka.connect.transforms.ValueToKey",
    "transforms.createKey.fields": "id",
    "transforms.extractId.type": "org.apache.kafka.connect.transforms.ExtractField$Key",
    "transforms.extractId.field": "id",
  }
}'