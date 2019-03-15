package io.github.personal_finance.repository;

import io.github.personal_finance.domainSecurity.dtoSecurity.TokenSecurityTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<TokenSecurityTable,Long> {

    TokenSecurityTable findTokenSecurityTableById(Long id);

}
