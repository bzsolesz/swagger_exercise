package hello.controller;

import hello.model.Introduction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zsoltbalogh on 19/12/2016.
 */
@RestController
public class IntroductionController
{
    @RequestMapping(value = "/introduction", method = RequestMethod.GET)
    public Introduction introduceYourself() {
        return new Introduction("I'm a test web application to integrate Spring Boot ans Swagger.");
    }
}
