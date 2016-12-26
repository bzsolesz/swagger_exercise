package hello.controller;

import hello.Application;
import hello.model.Greeting;
import hello.service.GreetingService;
import hello.service.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zsolt_balogh on 25/12/2016.
 */
public class GreetingControllerTest {

    private static final MediaType JSON_UTF8_CONTENT_TYPE =
            new MediaType(
                    MediaType.APPLICATION_JSON.getType(),
                    MediaType.APPLICATION_JSON.getSubtype(),
                    Charset.forName("utf8"));

    @Mock
    private GreetingService greetingServiceMock;

    @InjectMocks
    private GreetingController testedController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(testedController).build();
    }

    @Test
    public void shouldSayAGreetingWithDefaultName() throws Exception {

        when(greetingServiceMock.sayGreeting(Optional.<String>empty()))
                .thenReturn(new Greeting(1, "Hello World!"));

        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_UTF8_CONTENT_TYPE))
                .andExpect(jsonPath("$.content", is("Hello World!")));
    }

    @Test
    public void shouldSayAGreetingWithTheRequestedName() throws Exception {

        when(greetingServiceMock.sayGreeting(Optional.of("TestName")))
                .thenReturn(new Greeting(1, "Hello TestName!"));

        mockMvc.perform(get("/greeting?name=TestName"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_UTF8_CONTENT_TYPE))
                .andExpect(jsonPath("$.content", is("Hello TestName!")));
    }
}
