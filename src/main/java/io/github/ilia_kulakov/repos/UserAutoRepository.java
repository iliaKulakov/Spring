package io.github.ilia_kulakov.repos;


import io.github.ilia_kulakov.model.UserOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAutoRepository extends JpaRepository<UserOne, Long> {

    UserOne findModelsByModelID(Long id);
}