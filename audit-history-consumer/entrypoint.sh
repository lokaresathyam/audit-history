#!/bin/bash

while :
do
  echo "DB is up ..."
      java -jar audit-history-consumer.jar --spring.config.name=application
      break
  
  sleep 3
done