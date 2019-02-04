# Adidas Code challenge

Here is the adidas challenge code. With micro services architecture implemented with spring cloud


# Architecture overview
Components
 - gateway service: Entry service for the use of api
 - service discovery: Registration server for microservices
 - configuration service: Service used for applications to retrieve their properties
 -  itinerary data: Microservice that stores route and city data
 - itinerary search: Micro service that calculates the best itinerary between cities

![enter image description here](https://s3.amazonaws.com/certificados-calixto/Blank+Diagram.png)


## Run the project

    docker build --file=./config-server/Dockerfile --tag=config-server:latest --rm=true .
    docker build --file=./service-discovery/Dockerfile --tag=service-discovery:latest --rm=true .
    docker build --file=./itineraries-data/Dockerfile --tag=itineraries-data:latest --rm=true .
    docker build --file=./itenerary-search/Dockerfile --tag=itenerary-search:latest --rm=true .
    docker build --file=./gateway-service/Dockerfile --tag=gateway-service:latest --rm=true .

Afther that

    docker-compose up --no-start
## Entry Points

API Documentation
http://localhost:8001/swagger-ui.html

If you hit this URL the service will return the routes sorted by less distance and connections
http://localhost:8001/itinerary-search/itinerary?from=recife&to=rio

[{"routes":"recife -> salvador -> rio","duration":2.0,"citiesVisited":["salvador","rio"]},{"routes":"recife -> rio","duration":3.0,"citiesVisited":["rio"]},{"routes":"recife -> brasilia -> rio","duration":4.0,"citiesVisited":["brasilia","rio"]}]

However, you can add a sort to the list [durantion or connection]

http://localhost:8001/itinerary?from=recife&to=rio&sortBy=duration
[{"routes":"recife -> salvador -> rio","duration":2.0,"citiesVisited":["salvador","rio"]},{"routes":"recife -> rio","duration":3.0,"citiesVisited":["rio"]},{"routes":"recife -> brasilia -> rio","duration":4.0,"citiesVisited":["brasilia","rio"]}]

http://localhost:8001/itinerary?from=recife&to=rio&sortBy=connection
[{"routes":"recife -> rio","duration":3.0,"citiesVisited":["rio"]},{"routes":"recife -> brasilia -> rio","duration":4.0,"citiesVisited":["brasilia","rio"]},{"routes":"recife -> salvador -> rio","duration":2.0,"citiesVisited":["salvador","rio"]}]

## Init Data

![enter image description here](https://s3.amazonaws.com/certificados-calixto/cities.png)