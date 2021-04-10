package de.msg.cloud.examples.adapter.rest.out;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@Component
public class RestDownstreamServiceClient {

    @Value("${downstream.service.url}")
    private String downstreamServiceUrl;

    @Autowired
    @Qualifier("downstreamServiceClient")
    private WebClient downstreamServiceClient;

    public boolean shouldCallDownstreamService() {
        return StringUtils.hasText(downstreamServiceUrl);
    }

    public void invokeDownstreamService() {
        log.info("Send request to downstream service: {}", keyValue("downstreamServiceUrl", downstreamServiceUrl));
        ResponseEntity<String> response = downstreamServiceClient.get()
                .uri(URI.create(downstreamServiceUrl))
                .retrieve()
                .toEntity(String.class)
                .block();
        log.info("Received response from downstream service: {}", response.getBody());
    }
}
