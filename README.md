# spring-jpa-basics
Java Spring boot project using Spring JPA module with basic setup.


To fully run this application you'll first need to build the docker image in which the postgreSQL database will be running.

Go to Docker folder and inside exec the following command:

```docker build . --tag spring-jpa-test```

To run the docker image type:

```docker run -p8081:5432 spring-jpa-test```

The database engine will be listening on your machine's 8081 port.

To access to database client run:

```docker exec -it containerId psql -U root -d springtest```



