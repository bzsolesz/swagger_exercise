package hello.service;

import hello.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zsolt_balogh on 22/12/2016.
 */
@Service
public class GreetingService {

    private static final String GREETING_TEMPLATE = "Hello %s!";
    private static final String DEFAULT_NAME = "World";

    private final AtomicLong counter = new AtomicLong();

    public Greeting sayGreeting(Optional<String> name) {

        long requestIndex = counter.incrementAndGet();
        String responseMessage = String.format(GREETING_TEMPLATE, name.orElse(DEFAULT_NAME));

        return new Greeting(requestIndex, responseMessage);
    }
}