package io.github.personal_finance.security;

import com.google.common.collect.ImmutableList;
import io.github.personal_finance.domainSecurity.Role;
import io.github.personal_finance.domainSecurity.UserSecurity;
import io.github.personal_finance.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserSecurity.builder()
                .username(username)
                .password("password")
                .authorities(ImmutableList.of(Role.USER))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
    }


}
