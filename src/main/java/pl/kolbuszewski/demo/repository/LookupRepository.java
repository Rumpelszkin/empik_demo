package pl.kolbuszewski.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kolbuszewski.demo.model.UserLookUp;

import java.util.Optional;

@Repository
public interface LookupRepository extends CrudRepository<UserLookUp, String> {
    public Optional<UserLookUp> findByLogin(String login);

}
