#!/bin/bash

while :
do
  echo "DB is up ..."
      java -jar audit-history-producer.jar --spring.config.name=application
      break
  
  sleep 3
done