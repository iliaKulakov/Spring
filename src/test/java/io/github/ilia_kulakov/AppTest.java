package io.github.ilia_kulakov;

import io.github.ilia_kulakov.controller.GreetingController;
import io.github.ilia_kulakov.model.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
public class AppTest {


    @Autowired
    private MockMvc mvc;


    @MockBean
    private GreetingController greetingController;


    @Test
    public void testAppHasAGreeting() throws Exception {
        given(greetingController.greeting("name")).willReturn(new Greeting(0, "Hello, name!"));


        mvc.perform(get("/greeting").param("name", "name")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("content", notNullValue()))
                .andExpect(jsonPath("content", is("Hello, name!")));
    }



    @Test
    public void testAppHasAGreetingNegariveScenario() throws Exception {

        try {
            given(greetingController.greeting("name")).willReturn(new Greeting(0, "Hello, name!"));
            mvc.perform(get("/greeting").param("name", "name")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("content", notNullValue()))
                    .andExpect(jsonPath("content", is("Hello, name!")));
        }
        catch (Exception e)
        {
            System.out.println("Exception occurred in result");
        }

    }


}
