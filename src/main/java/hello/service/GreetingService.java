package hello.service;

import hello.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by zsolt_balogh on 26/12/2016.
 */
@Service
public interface GreetingService {
    Greeting sayGreeting(Optional<String> name);
}
