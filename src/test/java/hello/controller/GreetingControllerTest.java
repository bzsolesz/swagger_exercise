package hello.controller;

import hello.model.Greeting;
import hello.service.GreetingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static hello.controller.ControllerTestUtil.JSON_UTF8_CONTENT_TYPE;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by zsolt_balogh on 25/12/2016.
 */
public class GreetingControllerTest {

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
