package io.github.personal_finance.repositorySecurity;

import io.github.personal_finance.domainSecurity.dtoSecurity.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecurityRepository extends JpaRepository<UserSecurity, String> {

    UserSecurity findUserSecuritiesByUsername(String username);
}
