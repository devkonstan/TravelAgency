package pl.biuropodrozy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.DTO.UserDTO;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<UserDTO, Integer> {

    Optional<UserDTO> findByLogin(String login);
}

