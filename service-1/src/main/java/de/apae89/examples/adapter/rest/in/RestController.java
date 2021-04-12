package de.apae89.examples.adapter.rest.in;

import de.apae89.examples.adapter.rest.out.RestDownstreamServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "api")
@Slf4j
public class RestController {

    @Value("${spring.application.name}")
    private String serviceName;

    @Autowired
    private RestDownstreamServiceClient downstreamService;

    @GetMapping("hello")
    public String hello(@RequestHeader Map<String, String> headers) {
        MDC.put("userId", headers.getOrDefault("userid", ""));
        log.info("Received client request", keyValue("header", headers));
        if(downstreamService.shouldCallDownstreamService()) {
            downstreamService.invokeDownstreamService();;
        }
        MDC.clear();
        return "Hello from service: " + serviceName;
    }

}
