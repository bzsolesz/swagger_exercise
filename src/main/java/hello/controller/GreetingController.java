package hello.controller;


import hello.model.Greeting;
import hello.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by zsoltbalogh on 17/12/2016.
 */
@RestController
public class GreetingController
{
    @Autowired
    private GreetingService greetingService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting sayGreeting(
            @RequestParam(value = "name", required = false) String name)
    {
        return greetingService.sayGreeting(Optional.ofNullable(name));
    }
}
