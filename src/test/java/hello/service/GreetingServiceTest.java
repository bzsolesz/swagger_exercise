package hello.service;

import hello.model.Greeting;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by zsolt_balogh on 24/12/2016.
 */
public class GreetingServiceTest {

    private GreetingServiceImpl testedService;

    @Before
    public void setup() {
        testedService = new GreetingServiceImpl();
    }

    @Test
    public void shouldReturnNonNullGreeting() {
        Greeting resultGreeting = testedService.sayGreeting(Optional.<String>empty());

        assertNotNull(resultGreeting);
    }

    @Test
    public void shouldReturnGreetingWithDefaultName() {
        Greeting resultGreeting = testedService.sayGreeting(Optional.<String>empty());

        assertEquals("Hello World!", resultGreeting.getContent());
    }

    @Test
    public void shouldIncreaseRequestIdWithEachCall() {
        Greeting resultGreeting = testedService.sayGreeting(Optional.<String>empty());

        assertEquals(1, resultGreeting.getId());

        resultGreeting = testedService.sayGreeting(Optional.<String>empty());

        assertEquals(2, resultGreeting.getId());
    }

    @Test
    public void shouldReturnGreetingWithRequestedName() {
        Greeting resultGreeting = testedService.sayGreeting(Optional.of("TestName"));

        assertEquals("Hello TestName!", resultGreeting.getContent());
    }
}