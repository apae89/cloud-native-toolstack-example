# Introduction (Work in Progress)

This repository contains a minimum example of three cloud-native _Spring Boot_ based microservices communicating with 
each other via a 
REST API including an _Elastic Stack_ with _FileBeat_ for log analysis and _Jaeger_ to collect tracing information.

The goal is to provide a playground for developers and give a feeling what's required to get such an environment 
working and how the different tools together. Furthermore, it could be used for development projects to give a developer the 
toolchain he usually can expect in a microservice environment and use it for local testing.

## How to get started
Execute the following commands from a command line inside the root directory to get the setup started: 

* Start Elastic Stack, FileBeat, and Jaeger 
```commandline
docker-compose up
```

* Start the single services (make sure to run from distinct command lines)
```commandline
mvn spring-boot:run -pl service-1
mvn spring-boot:run -pl service-2
mvn spring-boot:run -pl service-3
```
### Web interface URLs
* Jaeger UI: http://localhost:16686/search
* Kibana: http://localhost:5601

### What to do next
1. After initial start of the analysis stacks log entries will be ingested into ElasticSearch immediately.
2. Send a GET request to service-1 via Postman or cURL `curl http://localhost:8080/api/hello`
3. Navigate to Kibana UI and create an index pattern "filebeat-*" to match all indices created by filebeat, as 
   described [here](https://www.sarulabs.com/post/5/2019-08-12/sending-docker-logs-to-elasticsearch-and-kibana-with-filebeat.html).
4. Explore the web interfaces of Kibana and Jaeger to get a feeling how these tools work
5. Read the next section to understand what's going on under the hood...



## Example setup explained

The log analysis stack consists of the Elastic Stack for storing and visualizing log information and FileBeat as a
log collector. Logstash is not used in this example, even if it's started as part of the Elastic Stack container.
Jaeger is used to collect and analyze tracing information.
Both stacks are executed as Docker containers with docker-compose.

The microservices are based on Spring Boot and are maintained as Maven modules. To keep this example easy to
understand, the modules consist of the same code but come with different configurations.

_// Add Detail explanation_
Artefacts, ...

### Detail explanation
tbd




