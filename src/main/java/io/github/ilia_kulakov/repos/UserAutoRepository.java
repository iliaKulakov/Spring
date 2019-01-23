package io.github.ilia_kulakov.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAutoRepository extends JpaRepository<String, Long> {

    String findModelsByModelID(Long id);
}