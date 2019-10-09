package pl.travelagency.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.travelagency.dto.UserDto;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<UserDto, Integer> {

    Optional<UserDto> findByLogin(String login);
}

