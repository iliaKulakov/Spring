package io.github.personal_finance.securityService;

import io.github.personal_finance.domainSecurity.dtoSecurity.UserSecurity;
import io.github.personal_finance.domainSecurity.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class SecurityUserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void init(){
        if(userDao.findByUsername("user")==null) {

            userDao.save(UserSecurity.builder()
                    .username("user")
                    .password("{noop}password")
                    .enabled(true)
                    .credentialsNonExpired(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .authorities("USER")
                    .build());
        }
    }

   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username);
//       UserDetails userDetails =  userDao.findByUsername(username);
//       return userDetails;

//      UserSecurity userSecurity = userDao.findByUsername(username);
//      return userSecurity;

//        return UserSecurity.builder()
//                .username(username)
//                .password("{noop}password") //really strange things but working
//                .authorities(ImmutableList.of(Role.USER))
//                .accountNonExpired(true)
//                .accountNonLocked(true)
//                .credentialsNonExpired(true)
//                .enabled(true)
//                .build();
    }

}
