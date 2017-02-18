package hello.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static hello.controller.ControllerTestUtil.JSON_UTF8_CONTENT_TYPE;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by zsolt_balogh on 29/12/2016.
 */
public class IntroductionControllerTest {

    private IntroductionController testedController;

    private MockMvc mockMvc;

    @Before
    public void setup() {

        testedController = new IntroductionController();

        mockMvc = standaloneSetup(testedController).build();
    }

    @Test
    public void shouldReturnAnIntroduction() throws Exception {

        mockMvc.perform(get("/introduction"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_UTF8_CONTENT_TYPE))
                .andExpect(jsonPath("$.name", is("I'm a test web application to integrate Spring Boot ans Swagger.")));
    }
}
