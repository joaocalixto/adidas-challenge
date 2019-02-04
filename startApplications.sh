#!/bin/sh

echo "Creating jars..."
mvn clean install

echo "\nMaven process finished!"

echo "\nBuildin docker images"

docker build --file=./config-server/Dockerfile --tag=config-server:latest --rm=true .

docker build --file=./service-discovery/Dockerfile --tag=service-discovery:latest --rm=true .

docker build --file=./itineraries-data/Dockerfile --tag=itineraries-data:latest --rm=true .

docker build --file=./itenerary-search/Dockerfile --tag=itenerary-search:latest --rm=true .

docker build --file=./gateway-service/Dockerfile --tag=gateway-service:latest --rm=true .


docker-compose up --no-start