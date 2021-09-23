#!/bin/bash

git pull origin master

mvn clean install -DskipTests

sudo docker-compose stop
sudo docker-compose up --build