package io.github.personal_finance.security;

import com.google.common.collect.ImmutableList;
import io.github.personal_finance.domainSecurity.Role;
import io.github.personal_finance.domainSecurity.UserSecurity;
import io.github.personal_finance.persistenceSecurity.UserDao;
import io.github.personal_finance.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {

       return userDao.findByUsername(username).orElse(null);


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
