package io.github.personal_finance.persistenceSecurity;

import io.github.personal_finance.domainSecurity.UserSecurity;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDao {

//    @Autowired
//    private HibernateTemplate hibernateTemplate;

    public Optional<UserSecurity> findByUsername(String username){
//        return hibernateTemplate.f;
        return null;
    }
}
