package zuchowskim.crit.crit.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface userRepository extends CrudRepository<userModel, Integer> {

    Optional<userModel> findByName(String userName);

}
