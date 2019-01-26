package io.github.personal_finance.repos;


import io.github.personal_finance.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {


    User findUserById(Long id);


}
