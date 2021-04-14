#!/usr/bin/env bash

echo "-------------------------------"
echo "Deleting connector patients ..."
echo "-------------------------------"

echo
curl -X DELETE http://localhost:8083/connectors/mysql-source-patients