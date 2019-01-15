package io.github.ilia_kulakov.repos;

import io.github.ilia_kulakov.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository <Message,Long>{
}
