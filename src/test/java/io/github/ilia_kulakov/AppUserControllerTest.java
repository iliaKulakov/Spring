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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(UserControllerOne.class)
public class AppUserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserControllerOne userControllerOne;

    @Test
    public void testAppUserOne() throws Exception {
       // given(userControllerOne.greeting("name")).willReturn(new Greeting(0, "Hello, name!"));
        given(userControllerOne.createUser("test_user_1"))
                .willReturn(new UserOne("test_user_1") );

    }



}
