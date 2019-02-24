package io.github.personal_finance;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.personal_finance.controller.UsersController;
import io.github.personal_finance.controller.dto.UserCreateDTO;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.receiver.ArrivalReceiver;
import io.github.personal_finance.receiver.ExpenseReceiver;
import io.github.personal_finance.repository.UsersRepository;
import io.github.personal_finance.service.UserService;
import io.github.personal_finance.service.impl.CommonUserService;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
//@WebMvcTest(CommonUserService.class)
@WebMvcTest(UsersController.class)
//@SpringBootTest(
//        classes = TestConfiguration.class)
public class AppUserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UsersRepository usersRepository;

    @MockBean
    private UserService userService;

    @MockBean
    private ConnectionFactory connectionFactory;

    @MockBean
    private ExpenseReceiver expenseReceiver;

    @MockBean
    private ArrivalReceiver arrivalReceiver;

//    @Test
//    public void testAppUserOne() throws Exception {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        UserCreateDTO userCreateDTO = new UserCreateDTO(
//                "test_user_1"
//        );
//
//        when(usersRepository.save(any(User.class)))
//                .thenReturn(new User("test_user_1"));
//
//        ResultActions result = mvc.perform(post("/users").content(mapper.writeValueAsString(userCreateDTO))
//                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(Matchers.containsString(userCreateDTO.getUsername())));
//    }


        @Test
    public void testAppUserOne() throws Exception {

            ObjectMapper mapper = new ObjectMapper();

            UserCreateDTO userCreateDTO = new UserCreateDTO(
                    "test_user_1");



//            when(usersRepository.save(any(User.class)))
//                    .thenReturn(new User("test_user_1"));

            User user = userService.createUser(userCreateDTO);

            ResultActions result = mvc.perform(post("/users").content(mapper.writeValueAsBytes(user))
                            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andDo(print())
                .andExpect(status().isOk());


//      ResultActions result = mvc.perform(post("/users").content(mapper.writeValueAsString(userCreateDTO))
//                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(Matchers.containsString(userCreateDTO.getUsername())));
//    }

        }
}
