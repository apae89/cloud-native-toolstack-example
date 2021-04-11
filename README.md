# Introduction (Work in Progress)

This repository contains a minimum example of three cloud-native _Spring Boot_ based microservices communicating with 
each other via a 
REST API including an _Elastic Stack_ with _FileBeat_ for log analysis and _Jaeger_ to collect trace information.

The goal is to provide a playground for developers and give a feeling what's required to get such an environment 
working and how the different tools together. Furthermore, it could be used for development projects to give a developer the 
toolchain he usually can expect in a microservice environment and use it for local testing.

## How to get started
Only a few steps are necessary to get this example running after cloning to your local system. Just execute the 
following commands from a command line inside the root directory to get the setup started. 

* Start Elastic Stack, FileBeat, and Jaeger 
```commandline
docker-compose up
```

* Start the single services (make sure to run from distinct command lines)
```commandline
mvn spring-boot:run -Pservice-1
mvn spring-boot:run -Pservice-2
mvn spring-boot:run -Pservice-3
```

### What to do next
1. Send a GET request to _service-1_ via Postman or cURL `curl http://localhost:8080/api/hello`
2. Navigate to Kibana UI and create an index pattern "filebeat-*" to match all indices created by filebeat, as 
   described [here](https://www.sarulabs.com/post/5/2019-08-12/sending-docker-logs-to-elasticsearch-and-kibana-with-filebeat.html).
3. Explore the web interfaces of Kibana and Jaeger to get a feeling how these tools work
4. Read the next section to understand what's going on under the hood...

### Web interface URLs
* Jaeger UI: http://localhost:16686/search
* Kibana: http://localhost:5601

## Example setup explained

The microservices are based on Spring Boot and are maintained as Maven modules. To keep this example easy to
understand, the modules consist of the same code but come with different configurations.

The log analysis stack consists of the Elastic Stack that stores and visualizes log information and FileBeat as a
log collector. Logstash is not used in this example, even if it's started as part of the Elastic Stack container.
Jaeger is used to visualize trace information. 
Both stacks are executed as Docker containers with docker-compose.

### Logging
Logging inside the application is done via Sl4j API and the Logback library, that comes shipped with Spring Boot 
starter by default. Log configuration is maintained in the `logback-spring.xml` that can be found inside the 
resources folder. Log behaviour is defined through Spring profiles in order to change the log output depending on the 
execution environment. In cloud environments it's usually only necessary to print log data to stdout whereas it can be 
useful in a local development environment to write log data to a logfile as well. Log output is written as JSON 
using the LogstashEncoder, which makes it easier to extract information from the log data via FileBeat and ingest it 
into Elasticsearch (except for the console appender in the dev environment, to make it easier to read).

In this use case FileBeat is responsible to continuously read and extract log data from a logfile and sending them 
to Elasticsearch, where it creates the necessary structures (Indices, ...) on first startup as well. Configuration 
is done via the _filebeat.yaml_, that defines in the `path` attribute where to read the log data from inside the 
container. In cloud environments log output is usually read from logfiles of the Docker daemon that stores information 
written to _stdout_ by the running containers, together with some additional information about the containers 
producing the log output provided by the Docker daemon itself (example configuration can be found out inside 
the configuration file).
To make the log files written by the services visible to FileBeat, the folder containing the log 
files is mounted into the container as defined inside the `docker-compose.yaml`. 

To add the service name and version to the log output they were explicitly added to the MDC via the Logback 
configuration 
file
```xml
    <springProperty scope="context" name="serviceName" source="spring.application.name"/>
    <springProperty scope="context" name="serviceVersion" source="spring.version"/>
```

### Tracing
Trace data itself is sent by the services via a Zipkin reporter over HTTP, that is integrated via the _Brave_ 
tracer library, that comes shipped with _Spring Sleuth_. The last provides Spring Boot auto-configuration for everything 
around Tracing. This ensures that the Tomcat server that serves our REST API and the Spring WebClient that we're 
using to send requests to other services are already configured and enabled for tracing. Furthermore, the TraceIds 
and SpanIds are implicitly added to the _Mapped Diagnostic Context (MDC)_ of Sl4j and thus added to the log outputs.

Since Jaeger is used to collect and visualize trace information, it must be configured to accept trace data in 
Zipkin format. To enable this, Jaeger has to start its Zipkin HTTP collector. This is done inside the 
`docker-compose.yaml` by providing a corresponding environment variable to the Jaeger service:
```yaml
environment:
- COLLECTOR_ZIPKIN_HOST_PORT=:9411
```

To assign the trace information being sent to Jaeger to the sending service the application name defined in the 
_application.yml_ is automatically added to the trace data.


## Known bugs
* FileBeat stops detecting changes after a while
* FileBeat injects a timestamp for the processing time into Elastic documents even if a timestamp exists denoting the 
  time when the log entry was written (probably an issue with timestamp format of log entry) 
