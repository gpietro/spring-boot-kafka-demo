#!/usr/bin/env bash

echo "-------------------------------"
echo "Connector and their tasks state"
echo "-------------------------------"

curl localhost:8083/connectors/mysql-source-patients/status