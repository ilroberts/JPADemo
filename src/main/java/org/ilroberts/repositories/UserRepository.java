package org.ilroberts.repositories;

import org.ilroberts.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);

    List<User> findByFirstName(String firstName);

    Long deleteByFirstName(String firstName);
}
