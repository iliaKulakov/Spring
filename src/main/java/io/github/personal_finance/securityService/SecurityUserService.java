package io.github.personal_finance.securityService;

import io.github.personal_finance.domainSecurity.UserDao;
import io.github.personal_finance.domainSecurity.dtoSecurity.UserSecurity;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SecurityUserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @PostConstruct //create user with Bcrypt
    public void init() {

        String password = new BCryptPasswordEncoder().encode("password");

        if (userDao.findByUsername("user") == null) {
            userDao.save(
                    UserSecurity.builder().
                            username("user")
                            .password(password)
                            .enabled(true)
                            .credentialsNonExpired(true)
                            .accountNonExpired(true)
                            .accountNonLocked(true)
                            .authorities("USER")
                            .build());
        }
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username);
//
    }

}
