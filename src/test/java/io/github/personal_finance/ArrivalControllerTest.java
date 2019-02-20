package io.github.personal_finance;

import io.github.personal_finance.controller.ArrivalController;
import io.github.personal_finance.domain.Arrival;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.repository.ArrivalRepository;
import org.apache.tomcat.jni.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrivalControllerTest {
    private final List<Arrival> categories = new ArrayList<Arrival>();
    private Long categoryId = 1L;
    private BigDecimal amount = new BigDecimal("1.2");
    private Long userId = 1L;
    private User user = new User();
    private Category category = new Category();


//    @Before
//    public void initArrivalInfo(){
//    Arrival arrival = new Arrival();
//    arrival.setAmount(amount);
//    arrival.setCategory(category);
//    arrival.setId(1);
//    arrival.setUser(user);
//    categories.add(arrival);
//    }

    @Test
    public void testGetMapping(){
        ArrivalRepository arrivalRepository = mock(ArrivalRepository.class);
        when(arrivalRepository.findAll())
                .thenReturn(categories);

      //  ArrivalController arrivalController = new ArrivalController();
      //  ExtendedМodelMap uiModel = new ExtendedМodelMap();

    }

}



