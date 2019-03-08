package io.github.personal_finance.domainSecurity;

import io.github.personal_finance.domainSecurity.dtoSecurity.UserSecurity;
import io.github.personal_finance.repositorySecurity.UserSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @Autowired
    private UserSecurityRepository userSecurityRepository;

    public UserSecurity findByUsername(String username) {
        UserSecurity userSecurity = this.userSecurityRepository.findUserSecuritiesByUsername(username);
        return userSecurity;

    }

    public void save(UserSecurity userSecurity) {
        userSecurityRepository.save(userSecurity);
    }

}
