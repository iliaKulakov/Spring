package io.github.personal_finance;

import com.github.fridujo.rabbitmq.mock.MockConnectionFactory;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenseRepository;
import io.github.personal_finance.repository.UsersRepository;
import io.github.personal_finance.service.UserService;
import io.github.personal_finance.service.impl.CommonUserService;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

@SpringBootConfiguration
@SpringBootApplication(scanBasePackages = "io.github.personal_finance")
public class TestConfiguration {
    @Bean
    ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(new MockConnectionFactory());
    }

    @Bean
    UserService userService() {
        return new CommonUserService(expenseRepository(), categoryRepository(), usersRepository());
    }

    @Bean
    UsersRepository usersRepository() {
        return mock(UsersRepository.class);
    }

    @Bean
    ExpenseRepository expenseRepository() {
        return mock(ExpenseRepository.class);
    }

    @Bean
    CategoryRepository categoryRepository() {
        return mock(CategoryRepository.class);
    }

}
