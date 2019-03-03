package io.github.personal_finance;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.personal_finance.controller.UsersController;
import io.github.personal_finance.controller.dto.UserCreateDTO;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.receiver.ArrivalReceiver;
import io.github.personal_finance.receiver.ExpenseReceiver;
import io.github.personal_finance.repository.UsersRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = TestConfiguration.class)
//@WebMvcTest(UsersController.class)
//public class AppUserControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private UsersRepository usersRepository;
//
//    @MockBean
//    private ConnectionFactory connectionFactory;
//
//    @MockBean
//    private ExpenseReceiver expenseReceiver;
//
//    @MockBean
//    private ArrivalReceiver arrivalReceiver;
//
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
//
//    @Test
//    public void testPostUser() {
//
//    }
//
//}
