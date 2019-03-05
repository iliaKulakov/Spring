package io.github.personal_finance.persistenceSecurity;

import io.github.personal_finance.domainSecurity.UserSecurity;
import io.github.personal_finance.repositorySecurity.UserSecurityRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class UserDao {

    @Autowired
    private UserSecurityRepository userSecurityRepository;

    public UserSecurity findByUsername(String username){
        UserSecurity userSecurity =this.userSecurityRepository.findUserSecuritiesByUsername(username);
        return  userSecurity;

    }

    public void save(UserSecurity userSecurity){
        userSecurityRepository.save(userSecurity);
    }

}
