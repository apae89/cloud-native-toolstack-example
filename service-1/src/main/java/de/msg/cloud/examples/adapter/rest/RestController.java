package de.msg.cloud.examples.adapter.rest;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.net.URI;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "api")
@Slf4j
public class RestController {

    @Value("${spring.application.name}")
    private String serviceName;

    @Value("${downstream.service.url}")
    private String downstreamServiceUrl;


    @GetMapping("hello")
    public String hello(@RequestHeader Map<String, String> headers) {
        MDC.put("userId", headers.getOrDefault("userid", ""));
        log.info("Received client request", keyValue("header", headers));
        if(StringUtils.hasText(downstreamServiceUrl)) {
            invokeDownstreamService();
        }
        MDC.clear();
        return "Hello from service: " + serviceName;
    }

    private void invokeDownstreamService() {
        WebClient client = WebClient.create(downstreamServiceUrl);
        log.info("Send request to downstream service: {}", keyValue("downstreamServiceUrl", downstreamServiceUrl));
        ResponseEntity<String> response = client.get()
                .uri(URI.create(downstreamServiceUrl))
                .retrieve()
                .toEntity(String.class)
                .block();
        log.info("Received response from downstream service: {}", response.getBody());
    }

}
