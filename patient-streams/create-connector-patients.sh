#!/usr/bin/env bash

echo "-----------------------"
echo "Creating connectors ..."
echo "-----------------------"

echo
curl -i -X POST http://localhost:8083/connectors \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  -d '@connectors/mysql-source-patients.json'