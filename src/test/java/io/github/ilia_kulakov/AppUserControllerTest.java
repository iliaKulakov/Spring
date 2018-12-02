package io.github.ilia_kulakov;

import io.github.ilia_kulakov.controller.GreetingController;
import io.github.ilia_kulakov.controller.UserControllerOne;
import io.github.ilia_kulakov.model.Greeting;
import io.github.ilia_kulakov.model.UserOne;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@WebMvcTest(UserControllerOne.class)
public class AppUserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserControllerOne userControllerOne;

    @Test
    public void testAppUserOne() throws Exception {
        given(userControllerOne.createUser("test_user_1"))
                .willReturn(new UserOne("test_user_1"));



      /*  mvc.perform(get("name")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("name", notNullValue()));*/



    }



}
