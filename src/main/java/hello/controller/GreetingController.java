package hello.controller;

import hello.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zsoltbalogh on 17/12/2016.
 */
@RestController
public class GreetingController
{

    private static final String GREETING_TEMPLATE = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting sayGreeting(
            @RequestParam(value = "name", defaultValue = "World") String name)
    {
        return new Greeting(
                counter.getAndIncrement(),
                String.format(GREETING_TEMPLATE, name)
        );
    }
}