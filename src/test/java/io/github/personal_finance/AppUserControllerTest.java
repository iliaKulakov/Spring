package io.github.personal_finance;

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
